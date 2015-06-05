package biz.wiklander.tools;

import org.jetbrains.annotations.NotNull;

import java.util.Arrays;
import java.util.List;

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
 * <p>
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
 * <p>
 * Original phrases.js by Greg Slovacek <greg@asana.com>
 * See also: <a
 * href"http://blog.asana.com/2011/09/6-sad-squid-snuggle-softly/">
 * The blog post by Greg about the use of this at Asana
 * </a>
 */
public class IdentifierSentence {
  // English adjectives
  /* @formatter:off */
  private final static List<String> adjectives = Arrays.asList(
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
    "yellow",   "young",    "zany"
  );
  /* @formatter:on */

  // English plural nouns
  /* @formatter:off */
  private final static List<String> nouns = Arrays.asList(
    "angels",     "ant-lions", "ants",        "badgers",   "banshees",
    "basilisks",  "bats",      "bears",       "bees",      "birds",
    "bookworms",  "buffalo",   "butterflies", "cats",      "centaurs",
    "chickens",   "clams",     "cockles",     "cows",      "crabs",
    "crows",      "deer",      "demons",      "devils",    "dingos",
    "dogs",       "dolphins",  "donkeys",     "doves",     "dragonflies",
    "dragons",    "ducks",     "dwarves",     "elephants", "fairies",
    "falcons",    "fauns",     "ferrets",     "fish",      "flies",
    "foxes",      "frogs",     "geckos",      "geese",     "gerbils",
    "ghosts",     "ghouls",    "giants",      "gnomes",    "goats",
    "goblins",    "golems",    "goombas",     "griffins",  "guinea pigs",
    "hares",      "hawks",     "hedgehogs",   "herons",    "horses",
    "hyenas",     "kangaroos", "kingfishers", "lions",     "lizards",
    "lobsters",   "mammoths",  "mermaids",    "mice",      "moles",
    "monkeys",    "monsters",  "moths",       "mussles",   "newts",
    "ogres",      "orcs",      "otters",      "owls",      "oxen",
    "oysters",    "panthers",  "parrots",     "penguins",  "people",
    "pheasants",  "pigeons",   "pigs",        "pikes",     "ponies",
    "princesses", "rabbits",   "rats",        "rhinos",    "robins",
    "rooks",      "salmons",   "scorpions",   "sharks",    "sheep",
    "sirens",     "skeletons", "snakes",      "sparrows",  "spiders",
    "spiders",    "spirits",   "sprites",     "squirrels", "starlings",
    "stoats",     "swans",     "tigers",      "toads",     "trouts",
    "unicorns",   "vampires",  "wasps",       "weasels",   "werewolves",
    "whales",     "witches",   "wolves",      "wombats",   "worms",
    "yetis",      "zebras",    "zombies"
  );
  /* @formatter:on */


  // English verbs, past tense
  /* @formatter:off */
  private final static List<String> verbs = Arrays.asList(
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
    "whisper", "work",    "wriggle"
  );
  /* @formatter:on */

  // English adverbs
  /* @formatter:off */
  private static final List<String> adverbs = Arrays.asList(
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
    "weakly",   "well",     "wildly",   "yearly"
  );
  /* @formatter:on */

  private static final long adjectiveFactor;

  private static final long nounFactor;

  private static final long verbFactor;

  private static final long adverbFactor;

  static {
    adjectiveFactor = 32;
    nounFactor      = adjectiveFactor * adjectives.size();
    verbFactor      = nounFactor * nouns.size();
    adverbFactor    = verbFactor * verbs.size();
  }

  public static String random() {
    int count = randomInt(33) + 2;

    String adjective  = randomItem(adjectives);
    String noun       = randomItem(nouns);
    String verb       = randomItem(verbs);
    String adverb     = randomItem(adverbs);

    return String.format(
      "%s %s %s %s %s",
      count,
      adjective,
      noun,
      verb,
      adverb
    );
  }

  public static long parseSentence(@NotNull String sentence) {
    String[] words = sentence.split(" ");

    int count = Integer.parseInt(words[0], 10);

    int adjective = adjectives.indexOf(words[1]);
    int noun      = nouns.indexOf(words[2]);
    int verb      = verbs.indexOf(words[3]);
    int adverb    = adverbs.indexOf(words[4]);

    return count +
      adjective * adjectiveFactor +
      noun      * nounFactor +
      verb      * verbFactor +
      adverb    * adverbFactor;
  }

  private static String randomItem(@NotNull List<String> items) {
    return items.get(randomInt(items.size()));
  }

  private static int randomInt(int max) {
    return (int) Math.floor(Math.random() * max);
  }
}
