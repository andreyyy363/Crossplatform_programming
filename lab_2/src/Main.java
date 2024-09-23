/*
Варіант №1 (за списком №19):
Напишіть програму, яка знаходить всі унікальні підстроки заданого рядка та
виводить їх разом із кількістю входжень кожної підстроки.
*/

public class Main {
    public static void main(String[] args) {
        String input = "abcab";

        String[] substrings = new String[input.length() * (input.length() + 1) / 2]; // Масив для збереження підстрок
        int[] counts = new int[substrings.length]; // Масив для збереження кількості входжень підстрок
        int index = 0;

        for (int i = 0; i < input.length(); i++) {
            for (int j = i + 1; j <= input.length(); j++) {
                String substring = input.substring(i, j);

                // Перевірка, чи вже існує підстрока в масиві
                int foundIndex = -1;
                for (int k = 0; k < index; k++) {
                    if (substrings[k].equals(substring)) {
                        foundIndex = k;
                        break;
                    }
                }

                // Додавання нової підстроки, якщо такої ще немає
                if (foundIndex == -1) {
                    substrings[index] = substring;
                    counts[index] = 1;
                    index++;
                } else {
                    // Якщо підстрока вже є, збільшуємо лічильник
                    counts[foundIndex]++;
                }
            }
        }

        // Вивід всіх унікальних підстрок та їх кількість
        System.out.println("Унікальні підстроки та кількість входжень:");
        for (int i = 0; i < index; i++) {
            System.out.println("Підстрока: " + substrings[i] + " - Кількість входжень: " + counts[i]);
        }
    }
}
