import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Random;

public class OrdenamientoGUI {
    private JTextArea txtDesordenado;
    private JTextArea txtOrdenado;
    private JComboBox cbMetodos;
    private JButton btnOrdenar;
    private JLabel lblDesordenado;
    private JLabel lblOrdenado;
    private JLabel lblMetodo;
    private JPanel panelGeneral;

    int[] Arregloid = new int[20];

    public OrdenamientoGUI() {

        btnOrdenar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
              if(cbMetodos.getSelectedIndex()==0) {
                  txtDesordenado.setText("");
                  txtOrdenado.setText("");
                  burbuja();
              } if(cbMetodos.getSelectedIndex()==1) {
                    txtDesordenado.setText("");
                    txtOrdenado.setText("");
                    seleccion();
                } if(cbMetodos.getSelectedIndex()==2) {
                    txtDesordenado.setText("");
                    txtOrdenado.setText("");
                    insercion();
                }if(cbMetodos.getSelectedIndex()==3) {
                    txtDesordenado.setText("");
                    txtOrdenado.setText("");
                    merge();
                }if(cbMetodos.getSelectedIndex()==4) {
                    txtDesordenado.setText("");
                    txtOrdenado.setText("");
                    quick();
                }
            }
        });
    }

    private static int aleatorio(int max,int min) {
        int num = (int)(Math.round(Math.random() * (max-min))) + min;
        return num;
    }

    public void burbuja() {

            int tamanio = Arregloid.length;
            Random rid = new Random();
            for (int i = 0; i < Arregloid.length; i++)
                Arregloid[i] = aleatorio(1, 255);
            //Arreglo Desordenado
            for (int i = 0; i < Arregloid.length; i++)
                txtDesordenado.append("\n" + Arregloid[i]);
            //Invoca a la funcion
            JOptionPane.showMessageDialog(null, "En la matriz de: " + Arregloid.length + " datos");
            int iteraciones = bubbleSort(Arregloid);

            //Arreglo Ordenado
            for (int i = 0; i < Arregloid.length; i++)
                txtOrdenado.append("\n" + Arregloid[i]);
            // Imprime el número de iteraciones realizadas
            JOptionPane.showMessageDialog(null, "Número de iteraciones: " + iteraciones);

    }

    public int bubbleSort(int[] arr) {
        int n = arr.length;
        int iteraciones = 0; // Contador de iteraciones
        for (int i = 0; i < n - 1; i++) {
            for (int j = 0; j < n - i - 1; j++) {
                iteraciones++; // Incrementa el contador en cada iteración
                if (arr[j] > arr[j + 1]) {
                    // Intercambiar arr[j] y arr[j + 1]
                    int temp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = temp;
                }
            }
        }
        return iteraciones; // Devuelve el número total de iteraciones realizadas
    }

    public void seleccion() {
        int tamanio = Arregloid.length;
        Random rid = new Random();
        for (int i = 0; i < Arregloid.length; i++)
            Arregloid[i] = aleatorio(1, 255);
        //Arreglo Desordenado
        for (int i = 0; i < Arregloid.length; i++)
            txtDesordenado.append("\n" + Arregloid[i]);
        //Invoca a la funcion
        JOptionPane.showMessageDialog(null, "En la matriz de: " + Arregloid.length + " datos");
        int iteraciones = selectionSort(Arregloid);

        //Arreglo Ordenado
        for (int i = 0; i < Arregloid.length; i++)
            txtOrdenado.append("\n" + Arregloid[i]);
        // Imprime el número de iteraciones realizadas
        JOptionPane.showMessageDialog(null, "Número de iteraciones: " + iteraciones);
    }

    public int selectionSort(int[] arr) {
        int n = arr.length;
        int iteraciones = 0; // Contador de iteraciones
        for (int i = 0; i < n - 1; i++) {
            // Encuentra el mínimo en el arreglo desordenado
            int minIdx = i;
            for (int j = i + 1; j < n; j++) {
                iteraciones++; // Incrementa el contador en cada iteración
                if (arr[j] < arr[minIdx]) {
                    minIdx = j;
                }
            }
            // Intercambiar el elemento mínimo con el primer elemento
            int temp = arr[minIdx];
            arr[minIdx] = arr[i];
            arr[i] = temp;
        }
        return iteraciones; // Devuelve el número total de iteraciones realizadas
    }

    public void insercion() {
        int tamanio = Arregloid.length;
        Random rid = new Random();
        for (int i = 0; i < Arregloid.length; i++)
            Arregloid[i] = aleatorio(1, 255);
        // Arreglo Desordenado
        for (int i = 0; i < Arregloid.length; i++)
            txtDesordenado.append("\n" + Arregloid[i]);
        // Invoca a la función
        JOptionPane.showMessageDialog(null, "En la matriz de: " + Arregloid.length + " datos");
        int iteraciones = insertionSort(Arregloid);

        // Arreglo Ordenado
        for (int i = 0; i < Arregloid.length; i++)
            txtOrdenado.append("\n" + Arregloid[i]);
        // Imprime el número de iteraciones realizadas
        JOptionPane.showMessageDialog(null, "Número de iteraciones: " + iteraciones);
    }

    public int insertionSort(int[] arr) {
        int n = arr.length;
        int iteraciones = 0; // Contador de iteraciones
        for (int i = 1; i < n; ++i) {
            int key = arr[i];
            int j = i - 1;
            // Desplaza los elementos de arr[0..i-1] que son mayores que key
            while (j >= 0 && arr[j] > key) {
                arr[j + 1] = arr[j];
                j = j - 1;
                iteraciones++; // Incrementa el contador en cada iteración del while
            }
            arr[j + 1] = key;
            iteraciones++; // Incrementa el contador para la comparación que falló en el while
        }
        return iteraciones; // Devuelve el número total de iteraciones realizadas
    }


    public void merge() {
        int tamanio = Arregloid.length;
        Random rid = new Random();
        for (int i = 0; i < Arregloid.length; i++)
            Arregloid[i] = aleatorio(1, 255);
        // Arreglo Desordenado
        for (int i = 0; i < Arregloid.length; i++)
            txtDesordenado.append("\n" + Arregloid[i]);
        // Invoca a la función
        JOptionPane.showMessageDialog(null, "En la matriz de: " + Arregloid.length + " datos");
        int iteraciones = mergeSort(Arregloid, 0, Arregloid.length - 1);

        // Arreglo Ordenado
        for (int i = 0; i < Arregloid.length; i++)
            txtOrdenado.append("\n" + Arregloid[i]);
        // Imprime el número de iteraciones realizadas
        JOptionPane.showMessageDialog(null, "Número de iteraciones: " + iteraciones);
    }

    public int mergeSort(int[] arr, int l, int r) {
        int iteraciones = 0;
        if (l < r) {
            // Encuentra el punto medio del arreglo
            int m = (l + r) / 2;
            // Ordena la primera y segunda mitad
            iteraciones += mergeSort(arr, l, m);
            iteraciones += mergeSort(arr, m + 1, r);
            // Combina las mitades ordenadas
            iteraciones += merge(arr, l, m, r);
        }
        return iteraciones;
    }

    // Método para combinar dos subarreglos
    public int merge(int[] arr, int l, int m, int r) {
        int iteraciones = 0;
        // Tamaños de los subarreglos
        int n1 = m - l + 1;
        int n2 = r - m;

        // Arreglos temporales
        int[] L = new int[n1];
        int[] R = new int[n2];

        // Copia los datos a los arreglos temporales
        for (int i = 0; i < n1; ++i) {
            L[i] = arr[l + i];
            iteraciones++; // Cuenta la iteración de la copia
        }
        for (int j = 0; j < n2; ++j) {
            R[j] = arr[m + 1 + j];
            iteraciones++; // Cuenta la iteración de la copia
        }

        // Indices iniciales de los subarreglos y del arreglo combinado
        int i = 0, j = 0, k = l;

        // Combina los arreglos
        while (i < n1 && j < n2) {
            iteraciones++; // Cuenta la iteración de la comparación
            if (L[i] <= R[j]) {
                arr[k] = L[i];
                i++;
            } else {
                arr[k] = R[j];
                j++;
            }
            k++;
        }

        // Copia los elementos restantes de L[]
        while (i < n1) {
            arr[k] = L[i];
            i++;
            k++;
            iteraciones++; // Cuenta la iteración de la copia
        }

        // Copia los elementos restantes de R[]
        while (j < n2) {
            arr[k] = R[j];
            j++;
            k++;
            iteraciones++; // Cuenta la iteración de la copia
        }

        return iteraciones;
    }

    public void quick() {
        int tamanio = Arregloid.length;
        Random rid = new Random();
        for (int i = 0; i < Arregloid.length; i++)
            Arregloid[i] = aleatorio(1, 255);
        // Arreglo Desordenado
        for (int i = 0; i < Arregloid.length; i++)
            txtDesordenado.append("\n" + Arregloid[i]);
        // Invoca a la función
        JOptionPane.showMessageDialog(null, "En la matriz de: " + Arregloid.length + " datos");
        int iteraciones = quickSort(Arregloid, 0, Arregloid.length - 1);

        // Arreglo Ordenado
        for (int i = 0; i < Arregloid.length; i++)
            txtOrdenado.append("\n" + Arregloid[i]);
        // Imprime el número de iteraciones realizadas
        JOptionPane.showMessageDialog(null, "Número de iteraciones: " + iteraciones);
    }

    public int quickSort(int[] arr, int low, int high) {
        int iteraciones = 0;
        if (low < high) {
            // pi es el índice de partición, arr[pi] está en la posición correcta
            int[] result = partition(arr, low, high);
            int pi = result[0];
            iteraciones += result[1];
            // Ordenar los elementos antes y después de la partición
            iteraciones += quickSort(arr, low, pi - 1);
            iteraciones += quickSort(arr, pi + 1, high);
        }
        return iteraciones;
    }

    // Método para particionar el arreglo
    public int[] partition(int[] arr, int low, int high) {
        int pivot = arr[high];
        int i = (low - 1); // Índice del elemento más pequeño
        int iteraciones = 0;
        for (int j = low; j < high; j++) {
            iteraciones++; // Incrementa el contador en cada iteración
            // Si el elemento actual es menor o igual al pivote
            if (arr[j] <= pivot) {
                i++;
                // Intercambiar arr[i] y arr[j]
                int temp = arr[i];
                arr[i] = arr[j];
                arr[j] = temp;
                iteraciones++; // Cuenta la iteración de la copia
            }
        }
        // Intercambiar arr[i + 1] con arr[high] (o pivote)
        int temp = arr[i + 1];
        arr[i + 1] = arr[high];
        arr[high] = temp;
        iteraciones++; // Cuenta la iteración de la copia
        return new int[]{i + 1, iteraciones};
    }

    public static void main(String[] args) {
        JFrame frame = new JFrame("OrdenamientoGUI");
        frame.setContentPane(new OrdenamientoGUI().panelGeneral);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setVisible(true);
    }
}
