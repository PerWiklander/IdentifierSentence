# IdentifierSentence: Create unique, memorable ids in Java

`IdentifierSentence` is a simple tool to let you generate (probably) unique, memorable ids in Java applications.

It creates sentences on the form count + adjective + noun + verb + adverb, as described in [this Asana blog post](http://asana.com/2011/09/6-sad-squid-snuggle-softly/ "6 sad squids snuggle softly") by Greg Slovacek, whom this tool is named after.

Linus G Thiel wrote a [Node.js implementation](https://github.com/linus/greg) that I based my work on.

Pull requests are welcome.

## Version
0.0.1

## Requirements
- None

## Installation

Via local maven repo:

    $ git clone git@github.com:PerWiklander/IdentifierSentence.git
    $ cd IdentifierSentence && mvn install

Not released into Maven central yet.

## Usage

    // Generate a random identifier
    String randomSentence = IdentifierSentence.random();
    
    System.out.println(
      String.format(
        "The sentence \"%s\" corresponds to the id %d",
        randomSentence, IdentifierSentence.parse(randomSentence)
      )
    );

## Credits

Per Wiklander &lt;per@wiklanderconsulting.se&gt;

## Thank you

Greg Slovacek
Linus G Thiel &lt;linus@hanssonlarsson.se&gt;

## License 

(The MIT License)

Copyright (c) 2010 Hansson &amp; Larsson &lt;info@hanssonlarsson.se&gt;

Permission is hereby granted, free of charge, to any person obtaining
a copy of this software and associated documentation files (the
'Software'), to deal in the Software without restriction, including
without limitation the rights to use, copy, modify, merge, publish,
distribute, sublicense, and/or sell copies of the Software, and to
permit persons to whom the Software is furnished to do so, subject to
the following conditions:

The above copyright notice and this permission notice shall be
included in all copies or substantial portions of the Software.

THE SOFTWARE IS PROVIDED 'AS IS', WITHOUT WARRANTY OF ANY KIND,
EXPRESS OR IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF
MERCHANTABILITY, FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT.
IN NO EVENT SHALL THE AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY
CLAIM, DAMAGES OR OTHER LIABILITY, WHETHER IN AN ACTION OF CONTRACT,
TORT OR OTHERWISE, ARISING FROM, OUT OF OR IN CONNECTION WITH THE
SOFTWARE OR THE USE OR OTHER DEALINGS IN THE SOFTWARE.