//import java.util.concurrent.ThreadLocalRandom;
//
//public class MonteCarlo {
//    private static long totalPointsInCircle = 0;
//    private static long totalIterations;
//    private static int numThreads;
//
//    public static void main(String[] args) {
//        if (args.length != 1) {
//            System.out.println("Usage: java ParallelMonteCarloPi <numThreads>");
//            return;
//        }
//
//        numThreads = Integer.parseInt(args[0]);
//        totalIterations = 1_000_000_000; // Кількість ітерацій для всіх потоків
//
//        Thread[] threads = new Thread[numThreads];
//        long iterationsPerThread = totalIterations / numThreads;
//
//        long startTime = System.nanoTime();
//
//        for (int i = 0; i < numThreads; i++) {
//            threads[i] = new Thread(new MonteCarloPiTask(iterationsPerThread));
//            threads[i].start();
//        }
//
//        for (Thread thread : threads) {
//            try {
//                thread.join();
//            } catch (InterruptedException e) {
//                e.printStackTrace();
//            }
//        }
//
//        double piEstimate = 4.0 * totalPointsInCircle / totalIterations;
//        long endTime = System.nanoTime();
//        double duration = (endTime - startTime) / 1_000_000.0;
//
//        System.out.printf("PI is %.5f%n", piEstimate);
//        System.out.printf("THREADS %d%n", numThreads);
//        System.out.printf("ITERATIONS %,d%n", totalIterations);
//        System.out.printf("TIME %.2fms%n", duration);
//    }
//
//    private static synchronized void addPointsInCircle(long points) {
//        totalPointsInCircle += points;
//    }
//
//    private static class MonteCarloPiTask implements Runnable {
//        private final long iterations;
//
//        public MonteCarloPiTask(long iterations) {
//            this.iterations = iterations;
//        }
//
//        @Override
//        public void run() {
//            long pointsInCircle = 0;
//            for (long i = 0; i < iterations; i++) {
//                double x = ThreadLocalRandom.current().nextDouble();
//                double y = ThreadLocalRandom.current().nextDouble();
//                if (x * x + y * y <= 1) {
//                    pointsInCircle++;
//                }
//            }
//            addPointsInCircle(pointsInCircle);
//        }
//    }
//}
