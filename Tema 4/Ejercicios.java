public class Ejercicios {
    public int linearSearch(int[] array, int target) {
        for (int i = 0; i < array.length; i++) {
            if (array[i] == target) {
                return i; // Devuelve el índice del elemento encontrado
            }
        }
        return -1; // Devuelve -1 si el elemento no se encuentra
    }

    public int binarySearch(int[] array, int target) {
        int left = 0;
        int right = array.length - 1;
    
        while (left <= right) {
            int mid = left + (right - left) / 2; // Evita desbordamiento
    
            // Compara el elemento del medio con el objetivo
            if (array[mid] == target) {
                return mid; // Devuelve el índice del elemento encontrado
            }
            if (array[mid] < target) {
                left = mid + 1; // Busca en la mitad derecha
            } else {
                right = mid - 1; // Busca en la mitad izquierda
            }
        }
        return -1; // Devuelve -1 si el elemento no se encuentra
    }

    public void bubbleSort(int[] array) {
        int n = array.length;
        boolean swapped;
    
        for (int i = 0; i < n - 1; i++) {
            swapped = false;
            
            for (int j = 0; j < n - 1 - i; j++) {
                if (array[j] > array[j + 1]) {
                    // Intercambiar array[j] y array[j + 1]
                    int temp = array[j];
                    array[j] = array[j + 1];
                    array[j + 1] = temp;
                    swapped = true;
                }
            }
            
            // Si no hubo intercambios, el arreglo ya está ordenado
            if (!swapped) {
                break;
            }
        }
    }

    public void selectionSort(int[] array) {
        int n = array.length;
    
        for (int i = 0; i < n - 1; i++) {
            // Encontrar el índice del elemento mínimo en el resto del arreglo
            int minIndex = i;
            for (int j = i + 1; j < n; j++) {
                if (array[j] < array[minIndex]) {
                    minIndex = j; // Actualizar el índice del mínimo
                }
            }
            // Intercambiar el elemento mínimo encontrado con el elemento en la posición i
            int temp = array[minIndex];
            array[minIndex] = array[i];
            array[i] = temp;
        }
    }

    public void insertionSort(int[] array) {
        for (int i = 1; i < array.length; i++) {
            int key = array[i];
            int j = i - 1;
    
            // Mover elementos de array[0..i-1] que son mayores que key
            // a una posición adelante de su posición actual
            while (j >= 0 && array[j] > key) {
                array[j + 1] = array[j];
                j--;
            }
            array[j + 1] = key;
        }
    }
}