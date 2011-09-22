package biz.wiklander.tools;

import java.util.Arrays;
import java.util.List;

public class IdentifierSentence {

    // English adjectives
    private static final List<String> adjectives = Arrays.asList(
            "cute", "dapper", "large", "small", "long", "short", "thick",
            "narrow", "deep", "flat", "whole", "low", "high", "near", "far",
            "fast", "quick", "slow", "early", "late", "bright", "dark",
            "cloudy", "warm", "cool", "cold", "windy", "noisy", "loud",
            "quiet", "dry", "clear", "hard", "soft", "heavy", "light",
            "strong", "weak", "tidy", "clean", "dirty", "empty", "full",
            "close", "thirsty", "hungry", "fat", "old", "fresh", "dead",
            "healthy", "sweet", "sour", "bitter", "salty", "good", "bad",
            "great", "important", "useful", "expensive", "cheap", "free",
            "difficult", "strong", "weak", "able", "free", "rich", "afraid",
            "brave", "fine", "sad", "proud", "comfortable", "happy", "clever",
            "interesting", "famous", "exciting", "funny", "kind", "polite",
            "fair", "share", "busy", "free", "lazy", "lucky", "careful",
            "safe", "dangerous", "mad"
            );

    // English plural nouns (all animals)
    final private static List<String> nouns = Arrays.asList(
            "rabbits", "badgers", "foxes", "chickens", "bats", "deer",
            "snakes", "hares", "hedgehogs", "platypuses", "moles", "mice",
            "otters", "rats", "squirrels", "stoats", "weasels", "crows",
            "doves", "ducks", "geese", "hawks", "herons", "kingfishers",
            "owls", "peafowl", "pheasants", "pigeons", "robins", "rooks",
            "sparrows", "starlings", "swans", "ants", "bees", "butterflies",
            "dragonflies", "flies", "moths", "spiders", "pikes", "salmons",
            "trouts", "frogs", "newts", "toads", "crabs", "lobsters", "clams",
            "cockles", "mussles", "oysters", "snails", "cattle", "dogs",
            "donkeys", "goats", "horses", "pigs", "sheep", "ferrets",
            "gerbils", "guinea pigs", "parrots", "greg", "orcs"
            );

    // English verbs, past tense
    private static final List<String> verbs = Arrays.asList(
            "sang", "played", "knitted", "floundered", "danced", "played",
            "listened", "ran", "talked", "cuddled", "sat", "kissed", "hugged",
            "whimpered", "hid", "fought", "whispered", "cried", "snuggled",
            "walked", "drove", "loitered", "whimpered", "felt", "jumped",
            "hopped", "went", "married", "engaged", "stomped"
            );

    // English adverbs
    private static final List<String> adverbs = Arrays.asList(
            "jovially", "merrily", "cordially", "easily", "loudly"
            );

    private static int adjectiveFactor;

    private static int nounFactor;

    private static int verbFactor;

    private static int adverbFactor;

    static {
        adjectiveFactor = 32;
        nounFactor = adjectiveFactor * adjectives.size();
        verbFactor = nounFactor * nouns.size();
        adverbFactor = verbFactor * verbs.size();

    }

    public static String random() {
        int count = randomInt(33) + 2;

        String adjective = randomItem(adjectives);
        String noun = randomItem(nouns);
        String verb = randomItem(verbs);
        String adverb = randomItem(adverbs);

        return String.format("%s %s %s %s %s", count, adjective, noun, verb,
                adverb);
    }

    public static int parse(String sentence) {
        String[] words = sentence.split(" ");

        int count = Integer.parseInt(words[0], 10);

        int adjective = adjectives.indexOf(words[1]);
        int noun = nouns.indexOf(words[2]);
        int verb = verbs.indexOf(words[3]);
        int adverb = adverbs.indexOf(words[4]);

        return count +
                adjective * adjectiveFactor +
                noun * nounFactor +
                verb * verbFactor +
                adverb * adverbFactor;
    }

    private static final String randomItem(List<String> items) {
        return items.get(randomInt(items.size()));
    }

    private static final int randomInt(int max) {
        return (int) Math.floor(Math.random() * max);
    }
}
