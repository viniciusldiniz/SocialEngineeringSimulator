import java.util.Scanner;

public class SocialEngineeringSimulator {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("=== Simulador de Engenharia Social ===");
        System.out.println("Responda às perguntas e veja se você está vulnerável a um ataque.\n");

        int score = 0;

        // Perguntas típicas de engenharia social
        String[] questions = {
            "Qual é o nome da sua mãe?",
            "Qual foi o modelo do seu primeiro carro?",
            "Qual é o nome do seu animal de estimação?",
            "Qual é o seu endereço de e-mail profissional?",
            "Qual o nome da sua escola primária?",
            "Você já compartilhou sua senha com alguém? (sim/não)"
        };

        // Respostas "perigosas" que indicam vulnerabilidade
        String[] safeAnswers = {
            "",     // para nome da mãe, não vamos comparar — só alertar
            "",     // idem
            "",     // idem
            "",     // idem
            "",     // idem
            "não"   // para a última pergunta queremos "não"
        };

        for (int i = 0; i < questions.length; i++) {
            System.out.print(questions[i] + " ");
            String answer = scanner.nextLine().trim().toLowerCase();

            if (i == 5) { // pergunta final sim/não
                if (!answer.equals("não")) {
                    System.out.println("⚠️ Resposta preocupante! Nunca compartilhe sua senha.");
                    score++;
                }
            } else {
                if (!answer.isEmpty()) {
                    System.out.println("⚠️ Cuidado! Essa informação pode ser usada contra você em ataques.");
                    score++;
                }
            }
            System.out.println();
        }

        if (score == 0) {
            System.out.println("Parabéns! Você está atento aos riscos de engenharia social.");
        } else {
            System.out.println("Você respondeu de forma vulnerável a " + score + " pergunta(s).");
            System.out.println("Esteja sempre atento ao compartilhar informações pessoais.");
        }

        System.out.println("\n== Fim do Simulador ==");
        scanner.close();
    }
}
