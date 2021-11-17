## StringsCompressor

文字列の圧縮

## Overview

アルファベットのみで構成される文字列を圧縮する

## Detail

課題1 文字列圧縮<br>
同じの文字が続く場合、"文字+連続する文字数"に置き換え、 文字数を短くして圧縮する StringsCompressor クラスを作成

課題2 文字列展開<br>
課題1 で圧縮した文字列を展開する StringsExpander クラスを作成

### インターフェース

#### CUI

実行例

課題1

``` java
String text = encode("AAAAABBBBBBBBBBCDDDDDDDDDEEFFFFFG");
System.out.println(text);
```

``` console
A5B10CD9E2F5G
```

課題2

``` java
String text = decode("A5B10CD9E2F5G");
System.out.println(text);
```

``` console
AAAAABBBBBBBBBBCDDDDDDDDDEEFFFFFG
```

## Structure Overview

課題1

- src/
    - App
        - main()
        - encode(String compressedStr)
        - countChar(String compressedStr, int startPoint)
        - toStr(List<Character> characters)
        - withinRange(int a, int b)
        - isDisplayCount(int b)

課題2

- src/
    - App
        - main()
        - decode(String expandedStr)
        - extractionCount(String expandedStr, int startPoint)
        - outputString(int count, char c)
        - isNumber(char c)
