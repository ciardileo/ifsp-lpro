"""
Classe Memory: armazena e lista matrizes
"""

# imports
from matrix import Matrix

class Memory():
    # atributos de classe
    _matrix_list: list[Matrix]
    
    # método construtor
    def __init__(self) -> None:
        self._matrix_list = []
        
    # métodos
    @property
    def size(self) -> int:
        """
        retorna o tamanho da memória
        """
        return len(self._matrix_list)
    
    
    def get(self, index: int) -> Matrix:
        """
        retorna uma matriz dependendo do tipo
        """
        
        return self._matrix_list[index]
    
    
    def add_matrix(self, matrix: Matrix) -> None:
        """
        função para adicionar uma matriz nova na memória
        matrix: objeto da matriz a ser adicionada
        """
        self._matrix_list.append(matrix)


    def list_matrices(self) -> str:
        """
        função para listar todas as matrizes salvas na memória
        """
        
        answer: str = ""
        
        for i in range(self.size):
            answer += f"\nMatrix {i}:\n"
            
            answer += Matrix.show_matrix(self._matrix_list[i].get_elements())
        
        if answer == "":
            return "MEMÓRIA VAZIA" 
            
        return answer