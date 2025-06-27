## Syndrome method playground
This project involves the Kotlin implementation and testing of a syndrome decoder under the binary symmetric channel (BSC) model. The tasks are as follows:

### 1. Syndrome Decoding and BSC Simulation
- Implement the **syndrome decoding method**.
- Simulate a **binary symmetric channel (BSC)** with bit-flip probability \( p \).

### 2. Decoding Random Error Vectors
- Decode randomly generated error vectors of a specified **weight**.
- The number of vectors to decode should be provided as a **user-defined input**.

### 3. Testing with Standard Codes
Use the following codes for testing:
- **Hadamard code**
- **Hamming code**
- **Random code** with parameters:
  - Code rate \( k/n = 0.9 \)
  - Parity-check matrix with 5 randomly placed ones in each column

For the random code, determine the **minimum value of \( n \)** at which the program **fails or crashes**.

### 4. Syndrome Table and Error Rate Plot
For the **random code of length 200**, do the following:
- Construct the **syndrome table**.
- Generate a plot with:
  - **X-axis**: Bit-flip probability \( p \)
  - **Y-axis**: Fraction of incorrectly decoded vectors

> 🧪 For each value of \( p \), simulate and decode at least **100,000 vectors**.

Find the smallest \( p \) such that the decoding error rate reaches $5*10^{-6}$.

---

### 📝 Notes
- Use the **zero vector** as the transmitted codeword.
- For all codes (except the random one), use **canonical forms** of the generator and parity-check matrices.

![image](https://github.com/user-attachments/assets/05d20001-16c7-44e2-bed3-f47f6c84f7e1)


## Постановка задачи на русском языке

1. Запрограммировать метод синдромов и двоичный симметричный канал связи с вероятностью p.

2. Декодирование случайных ошибок заданного веса (число векторов которые необходимо декодировать является параметром вводимым "с руки").

3. В качестве тестов использовать: код Адамара, код Хэмминга, проверочную матрицу кода: k/n=0.9, в каждом столбце которого единицы в случайных 5 местах. Найти минимальное n для которых программа не работает/вылетает.

4. Для предложенного случайного кода длины 200 построить таблицу синдромов и следующий график.
 По горизонтальной оси вероятность ошибки декодирования-$p$, по вертикальной-отношение числа неверно декодированных векторов ко всем векторам (пример прилагается). Прогнать не менее 100000 векторов для каждого значения $p$.
Найти p такое что вероятность будет $5*10^{-6}$.

![image](https://github.com/user-attachments/assets/b00e28c9-2cec-4ab2-9304-91b35e2fa163)

В качестве кодового слова брать нулевой вектор и матрицы в канонических видах (кроме случайного кода).
