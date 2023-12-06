public class ThreadExample {

    public static void main(String[] args) {
        Thread mainThread = new Thread(() -> {
            // Код, що виконується в головному потоці
            System.out.println("Main Thread is running.");

            // Створення і запуск другого потоку
            Thread secondThread = new Thread(() -> {
                System.out.println("Second Thread is running.");
            });
            secondThread.start();

            try {
                // Очікування завершення другого потоку
                secondThread.join();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

            System.out.println("Main Thread is finishing.");
        });

        // Створення і запуск третього потоку
        Thread firstThread = new Thread(() -> {
            System.out.println("First Thread is running.");
        });
        firstThread.start();

        try {
            // Очікування завершення третього потоку
            firstThread.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        // Запуск головного потоку
        mainThread.start();

        try {
            // Очікування завершення головного потоку
            mainThread.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.out.println("All threads are finished.");
    }
}
