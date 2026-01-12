public class WordTranslator {
    public static void main(String[] args) {
        // Single array for English words
        String[] englishWords = {"sky", "run", "study", "music", "dog"};

        // 2D array for translations: [EnglishWordIndex][LanguageIndex]
        // Languages: 0=Dutch, 1=French, 2=Italian
        String[][] translations = {
            {"hemel", "ciel", "cielo"},     // sky
            {"rennen", "courir", "correre"}, // run
            {"studie", "etude", "studia"},   // study
            {"muziek", "musique", "musica"}, // music
            {"hond", "chien", "cane"}        // dog
        };

        // Print header
        System.out.println("WORD IN ENGLISH\t\tDUTCH\t\tFRENCH\t\tITALIAN");
        System.out.println("----------------------------------------------------------------");

        // Loop through each English word and print its translations
        for (int i = 0; i < englishWords.length; i++) {
            System.out.printf("%-20s", englishWords[i]); // Print English word
            for (int j = 0; j < translations[i].length; j++) {
                System.out.printf("%-15s", translations[i][j]); // Print each translation
            }
            System.out.println(); // New line for next word
        }
    }
}