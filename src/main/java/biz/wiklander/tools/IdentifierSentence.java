package biz.wiklander.tools;

import java.util.Arrays;

public class IdentifierSentence {

    public static void main(final String[] args) {
        formatList(SentenceFactory.adverbs, 5);
    }

    public static void formatList(final String[] words,
            final int wordsPerLine) {

        Arrays.sort(words);

        final int[] charCount = new int[wordsPerLine];

        int i = 0;
        for (final String word : words) {
            if (!(charCount[i % wordsPerLine] > word.length())) {
                charCount[i % wordsPerLine] = word.length();
            }

            i++;
        }

        i = 0;
        for (final String word : words) {
            if (i % wordsPerLine == 0) {
                System.out.print("\n");
            }

            System.out.print(String.format("%1$-"
                    + (charCount[i % wordsPerLine] + 4)
                    + "s", "\"" + word + "\", "));

            i++;
        }
    }

    /**
     * The default 32-bit phrase generator, which creates fun and
     * easy-to-remember phrases consisting of, in order:
     * 
     * <ul>
     * <li>One of 32 numbers, from 2-33 [5 bits]</li>
     * <li>One of 128 adjectives [7 bits]</li>
     * <li>One of 128 subjects (mostly animals, for extra cuteness) [7 bits]</li>
     * <li>One of 128 verbs [7 bits]</li>
     * <li>One of 64 adverbs [6 bits]</li>
     * </ul>
     * 
     * <p>
     * So a random phrase is something like:
     * 
     * "23 glossy ants march happily"
     * </p>
     * 
     * <p>
     * Dividing the phrase into distinct parts of speech with an obvious pattern
     * and constraints makes memorization easier. Restricting the dictionary
     * space to as few syllables as possible (in most cases one- or two-syllable
     * words) makes recitation of the complete phrase simpler. The result is a
     * phrase that, while taking up more bytes to render digitally,
     * theoretically takes up significantly less cognitive space than an 8-digit
     * hex string or even a 6-digit alphanumeric code. This is an experiment. :)
     * </p>
     * 
     * @author Per Wiklander <per@wiklanderconsulting.se>
     * 
     *         Original phrases.js by Greg Slovacek <greg@asana.com>
     *         See also: <a
     *         href"http://blog.asana.com/2011/09/6-sad-squid-snuggle-softly/">
     *         The blog post by Greg about the use of this at Asana
     *         </a>
     */
    private static class SentenceFactory {

        // English plural nouns
        /* @formatter:off */
        final private static String[] nouns = new String[] {
            "ants",        "badgers",     "bats",     "bees",       "butterflies", 
            "cattle",      "chickens",    "clams",    "cockles",    "crabs",       
            "crows",       "deer",        "dogs",     "donkeys",    "doves",       
            "dragonflies", "ducks",       "ferrets",  "flies",      "foxes",       
            "frogs",       "geese",       "gerbils",  "goats",      "greg",        
            "guinea pigs", "hares",       "hawks",    "hedgehogs",  "herons",      
            "horses",      "kingfishers", "lobsters", "mice",       "moles",       
            "moths",       "mussles",     "newts",    "orcs",       "otters",      
            "owls",        "oysters",     "parrots",  "peafowl",    "pheasants",   
            "pigeons",     "pigs",        "pikes",    "platypuses", "rabbits",     
            "rats",        "robins",      "rooks",    "salmons",    "sheep",       
            "snails",      "snakes",      "sparrows", "spiders",    "squirrels",   
            "starlings",   "stoats",      "swans",    "toads",      "trouts",      
            "weasels",
        };
        /* @formatter:on */

        // English adjectives
        /* @formatter:off */
        private static final String[] adjectives = new String[] {
            "awful",    "bad",      "bashful", "berserk",  "big",       
            "bizarre",  "black",    "blue",    "boring",   "brawny",    
            "bright",   "bumpy",    "burly",   "cagey",    "cheerful",  
            "chilly",   "chubby",   "classy",  "clumsy",   "cold",      
            "crazy",    "creepy",   "cuddly",  "dashing",  "dirty",     
            "dizzy",    "drunk",    "dry",     "dull",     "dusty",     
            "eager",    "evil",     "fancy",   "fast",     "fat",       
            "faulty",   "fearless", "filthy",  "foamy",    "friendly",  
            "funny",    "gentle",   "giant",   "glossy",   "good",      
            "goofy",    "great",    "greedy",  "green",    "groovy",    
            "grumpy",   "guilty",   "hairy",   "handsome", "happy",     
            "healthy",  "heavy",    "helpful", "high",     "huge",      
            "hungry",   "icky",     "itchy",   "jazzy",    "jealous",   
            "jolly",    "jumpy",    "kind",    "large",    "lazy",      
            "lean",     "little",   "lively",  "lucky",    "macho",     
            "magenta",  "magic",    "massive", "meek",     "mighty",    
            "mindless", "nasty",    "needy",   "new",      "nice",      
            "noisy",    "odd",      "old",     "orange",   "pretty",    
            "prickly",  "proud",    "puffy",   "purple",   "quick",     
            "quiet",    "rabid",    "rebel",   "red",      "righteous", 
            "round",    "sad",      "sassy",   "scary",    "sedate",    
            "shallow",  "short",    "silly",   "skillful", "skinny",    
            "sloppy",   "slow",     "small",   "smelly",   "sneaky",    
            "snobby",   "strange",  "tacky",   "tall",     "tan",       
            "tough",    "tricky",   "ugly",    "wicked",   "wise",      
            "yellow",   "young",    "zany",
        };
        /* @formatter:on */

        // English verbs, past tense
        /* @formatter:off */
        private static final String[] verbs = new String[] {
            "agree",   "applaud", "argue",   "arise",   "arrive", 
            "attack",  "awaken",  "bake",    "bathe",   "beg",    
            "behave",  "bite",    "blink",   "blush",   "bounce", 
            "breathe", "burrow",  "buzz",    "charge",  "chat",   
            "cheer",   "chew",    "chuckle", "clap",    "cry",    
            "dance",   "dig",     "dive",    "drink",   "eat",    
            "feed",    "fight",   "flap",    "flee",    "float",  
            "fly",     "gather",  "glow",    "grunt",   "hang",   
            "hide",    "howl",    "hunt",    "itch",    "jog",    
            "joke",    "jostle",  "jump",    "kick",    "kneel",  
            "knit",    "krump",   "laugh",   "leap",    "leave",  
            "look",    "lope",    "march",   "mix",     "moan",   
            "nuzzle",  "observe", "plan",    "play",    "plead",  
            "point",   "pray",    "punch",   "push",    "race",   
            "rejoice", "relax",   "retire",  "return",  "roar",   
            "rub",     "rumble",  "run",     "rush",    "sail",   
            "scare",   "scrape",  "scratch", "scream",  "scrub",  
            "search",  "shake",   "shiver",  "shrink",  "shrug",  
            "sigh",    "sing",    "sit",     "skip",    "slap",   
            "sleep",   "slide",   "slip",    "smash",   "snore",  
            "spar",    "speak",   "spit",    "stand",   "stare",  
            "step",    "sting",   "stomp",   "stretch", "strike", 
            "study",   "stumble", "swim",    "talk",    "think",  
            "tickle",  "travel",  "trot",    "twist",   "wait",   
            "walk",    "wander",  "watch",   "wave",    "whine",  
            "whisper", "work",    "wriggle", 
        };
        /* @formatter:on */

        // English adverbs
        /* @formatter:off */
        private static final String[] adverbs = new String[] {
            "ably",     "always",   "angrily",  "badly",    "blindly", 
            "boldly",   "bravely",  "briefly",  "brightly", "busily",  
            "calmly",   "clearly",  "cruelly",  "daily",    "easily",  
            "equally",  "exactly",  "fast",     "fiercely", "fondly",  
            "gently",   "gladly",   "greedily", "happily",  "hastily", 
            "honestly", "hourly",   "hungrily", "joyously", "justly",  
            "kindly",   "lazily",   "loosely",  "loudly",   "madly",   
            "merrily",  "monthly",  "neatly",   "often",    "poorly",  
            "promptly", "quickly",  "quietly",  "rarely",   "roughly", 
            "rudely",   "sadly",    "safely",   "sharply",  "shyly",   
            "slowly",   "smoothly", "softly",   "soon",     "sternly", 
            "swiftly",  "tensely",  "tightly",  "too",      "warmly",  
            "weakly",   "well",     "wildly",   "yearly",   
        };
        /* @formatter:on */
    }
}
