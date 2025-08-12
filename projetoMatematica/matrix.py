"""
Classe Matrix com suas operações
"""

class Matrix():
    # atributos de classe
    _elements: list[float]
    rows: list[float]
    cols: list[float]
    
    # método construtor
    def __init__(self, matrix: list[float]) -> None:
        self._elements = matrix
        self.rows = len(matrix)
        self.cols = len(matrix[0])
    
    
    # métodos
    @staticmethod
    def show_matrix(matrix: list[float]) -> str:
        """
        função que retorna uma string dos elementos de uma matriz]
        matrix: matriz a ser printada
        """
        
        result: str = ""
        
        for i in range(len(matrix)):
            result += "[ "
            
            result += " ".join(map(str, matrix[i]))
                
            result += " ]\n"
            
        return result
    
    
    def get_elements(self) -> list[float]:
        """
        getter dos elementos
        """
        return self._elements
    
    
    def sum(self, matrix: list[float]) -> list[float]:
        """
        função que realiza a adição entre duas matrizes, se for possível
        matrix: matriz a adicionar
        """
        
        # checa se as dimensões das matrizes são iguais
        if self.cols == len(matrix[0]) and self.rows == len(matrix):
            rows: int = len(matrix)
            cols: int = len(matrix[0])
            result_matrix: list[float] = [[0] * cols for _ in range(rows)]
            
            # faz a soma
            for i in range(rows):
                for j in range(cols):
                    result_matrix[i][j] = self._elements[i][j] + matrix[i][j]
                    
            return result_matrix
        
        else:
            return None   
        
        
    def subtract(self, matrix: list[float]) -> list[float]:
        """
        função que realiza a subtração entre matrizes, se for possível
        matrix: matriz a ser subtraída
        """
        
         # checa se as dimensões das matrizes são iguais
        if self.cols == len(matrix[0]) and self.rows == len(matrix):
            rows: int = len(matrix)
            cols: int = len(matrix[0])
            result_matrix: list[float] = [[0] * cols for _ in range(rows)]
            
            # faz a soma
            for i in range(rows):
                for j in range(cols):
                    result_matrix[i][j] = self._elements[i][j] - matrix[i][j]
                    
            return result_matrix
        
        else:
            return None   
        
        
    def multiply_number(self, number: float) -> list[float]:
        """
        função que multiplica uma matriz inteira por um número real
        number: fator
        """
                
        # cria a matriz do resultado
        result_matrix: list[float] = [[0] * self.cols for _ in range(self.rows)]
        
        for i in range(self.rows):
            for j in range(self.cols):
                result_matrix[i][j] = self._elements[i][j] * number
                
        return result_matrix
    
    
    def multiply_matrix(self, matrix: list[float]) -> list[float]:
        """
        função que realiza a multiplicação entre duas matrizes
        matrix: segunda matriz
        """
        
        rows: int = len(matrix)
        cols: int = len(matrix[0])
        
        # checa as condições
        if self.cols == rows:
            result_rows: int = self.rows
            result_cols: int = cols
            
            result_matrix: list[float] = [[0] * result_cols for _ in range(result_rows)]
            
            for i in range(result_rows):
                for j in range(result_cols):
                    acumulator = 0
                    for element1, element2 in zip(self._elements[i], self.transpose(matrix)[j]):
                        acumulator += element1 * element2
                        
                    result_matrix[i][j] = acumulator
                
            return result_matrix
        
        else:
            return None
    
    
    def transpose(self, matrix: list[float] = None) -> list[float]:
        """
        função que retorna a transposta da matrix
        """
        
        if matrix is None:
            matrix = self._elements
        
        rows: int = len(matrix[0])
        cols: int = len(matrix)
        
        result_matrix: list[float] = [[0] * cols for _ in range(rows)]
        
        for i in range(rows):
            for j in range(cols):
                result_matrix[i][j] = matrix[j][i]
                
    
        return result_matrix
    
    
    def square(self) -> list[float]:
        if self.cols == self.rows:
            return self.multiply_matrix(self._elements)
            
        return False
        
        
