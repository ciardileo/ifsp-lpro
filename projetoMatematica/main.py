"""
MATEMÁTICA 3 - Professor Gilberto
Leonardo Ciardi - INI3

Script de Matrizes
Funções disponíveis:
- Transposição
- Multiplicação
	- Por número
	- Por matriz
- Adição
- Subtração
- Calcular diagonais

As funções foram feitas sem o uso do NumPy para praticar a lógica das operações
"""

# imports
from matrix import Matrix
from memory import Memory
# import traceback

# global vars
SEPARATOR: str = "<======================>"
MAIN_MENU: str = "[1] Adicionar matriz\n[2] Listar matriz(es)\n[3] Operações\n[4] Mostrar menu\n[5] Sair"
OPERATIONS_MENU: str = "[1] Adição\n[2] Subtração\n[3] Multiplicação por número\n[4] Multiplicação por matriz\n[5] Transposição\n[6] Mostrar operações\n[7] Voltar"
matrix_memory: Memory = Memory()

# função principal
def main() -> None:
	# variáveis globais
	global matrix_memory
	
	print("MATRIX")
	print(SEPARATOR)
	print(MAIN_MENU)
	print(SEPARATOR)

	user_option: str = ""

	# menu interativo
	while user_option.strip() != "5":
		user_option: str = input("Opção: ")

		match user_option.strip():
			# adicionar matriz
			case "1":
				try:
					rows: int = int(input("N° de linhas: ").strip())
					cols: int = int(input("N° de colunas: ").strip())
					new_matrix: list[float] = []
					
					if not (cols > 0 and rows > 0):
						raise ValueError("As dimensões devem ser números positivos")

					for _ in range(rows):
						row: list = list(map(float, input().strip().split()))

						if len(row) != cols:
							raise ValueError("Você digitou valores a mais ou a menos")

						new_matrix.append(row)
						
					matrix_memory.add_matrix(Matrix(new_matrix))
					print(f"Matrix {matrix_memory.size - 1} adicionada")

				except ValueError as e:
					print("[ERRO] Você deve digitar algum número")
					
				except Exception as e:
					print(f"[ERRO] {e}")
			
			# listar matrizes
			case "2":
				print(matrix_memory.list_matrices())
				   
			# operações com matrizes
			case "3":
				user_option2: str = ""
				print(OPERATIONS_MENU)
				
				while user_option2 != "7":
					user_option2 = input("Opção: ")
					
					try:
						match user_option2:
							# adição
							case "1":
								index_matrix1: int = int(input("Número da primeira matriz: "))
								index_matrix2: int = int(input("Número da segunda matriz: "))
								
								if 0 <= index_matrix1 <= matrix_memory.size and 0 <= index_matrix2 <= matrix_memory.size:
									matrix1 = matrix_memory.get(index_matrix1)
									matrix2 = matrix_memory.get(index_matrix2)
									
									result: list[float] = matrix1.sum(matrix2.get_elements())

									if result:
										print("Resultado:")
										print(Matrix.show_matrix(result))
									else:
										print("[ERRO] A dimensão das matrizes não bate")
								
								else:
									raise Exception("Alguma das matrizes não existe")
								
							
							# subtração 
							case "2":
								index_matrix1: int = int(input("Número da primeira matriz: "))
								index_matrix2: int = int(input("Número da segunda matriz: "))
								
								if 0 <= index_matrix1 <= matrix_memory.size and 0 <= index_matrix2 <= matrix_memory.size:
									matrix1 = matrix_memory.get(index_matrix1)
									matrix2 = matrix_memory.get(index_matrix2)
									result: list[float] = matrix1.subtract(matrix2.get_elements())
			
									if result:
										print("Resultado:")
										print(Matrix.show_matrix(result))
									else:
										print("[ERRO] A dimensão das matrizes não bate")
									
								else:
									raise Exception("Alguma das matrizes não existe")
							
							# multiplicação por número 
							case "3":
								index_matrix: int = int(input("Número da primeira matriz: "))
								number: float = float(input("Número para multiplicar: "))
								
								if 0 <= index_matrix <= matrix_memory.size:
									matrix = matrix_memory.get(index_matrix)
									result: list[float] = matrix.multiply_number(number)
									print("Resultado:")
									print(Matrix.show_matrix(result))
									
								else:
									raise Exception("Alguma das matrizes não existe")
							
							# multiplicação por matriz
							case "4":
								index_matrix1: int = int(input("Número da primeira matriz: "))
								index_matrix2: int = int(input("Número da segunda matriz: "))
								
								if 0 <= index_matrix1 <= matrix_memory.size and 0 <= index_matrix2 <= matrix_memory.size:
									matrix1 = matrix_memory.get(index_matrix1)
									matrix2 = matrix_memory.get(index_matrix2)
									result: list[float] = matrix1.multiply_matrix(matrix2.get_elements())
			
									if result:
										print("Resultado:")
										print(Matrix.show_matrix(result))
									else:
										print("[ERRO] A dimensão das matrizes não bate")
									
								else:
									raise Exception("Alguma das matrizes não existe")
							
							# transposição
							case "5":
								index_matrix: int = int(input("Número da matriz: "))
								
								if 0 <= index_matrix <= matrix_memory.size:
									matrix = matrix_memory.get(index_matrix)
									result: list[float] = matrix.transpose()
									print("Resultado:")
									print(Matrix.show_matrix(result))
									
								else:
									raise Exception("Essa matriz não existe")
							
							# mostrar as operações
							case "6":
								print(OPERATIONS_MENU)

							# voltar 
							case "7":
								print("Voltando...")
					
						if user_option2.strip() not in ["1", "2", "3", "4", "5", "6", "7"]:
							print("[ERRO] Opção inexistente")
					
					except ValueError:
						print("[ERRO] Você deve digitar um número")
						
					except Exception as e:
						print(f"[ERRO] {e.with_traceback}")
						# traceback.print_exc()
				
			# mostrar menu
			case "4":
				print(MAIN_MENU)           
			
			# sair 
			case "5":
				print("Saindo...")
				break
			
		# default
		if user_option.strip() not in ["1", "2", "3", "4", "5"]:
			print("[ERRO] Opção inexistente") 
			
		print(SEPARATOR)           

if __name__ == "__main__":
	main()