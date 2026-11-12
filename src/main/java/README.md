1. What did you predict for Warmup.java, and what did it actually print? Explain the lines that surprised you.

expected output:

```text
7 5.0 __
Two
Three
```

actual Output:

```text
7 5.0 -126
Two
Three
```

Why each line is printed:

- `(int) 7.9` converts the decimal number to an integer. Java removes the fractional part; it does not round, so `a` is `7`.
- `x` is the integer `5`. Assigning it to the `double` variable `d` converts it to `5.0`.
- `n` is `130`, but a Java `byte` can hold only values from `-128` to `127`. A byte uses 8 bits. When `130` is cast to a byte, Java keeps its lowest 8 bits: `10000010`. Java interprets that bit pattern as `-126` in signed byte format, so `b` is `-126`, not `127`. The cast does not clamp the value to the largest byte value.
- The first `println` combines `a`, `d`, and `b` with spaces, producing `7 5.0 -126`.
- `day` is `2`, so the `switch` starts at `case 2` and prints `Two`. There is no `break` after that case, so execution continues into `case 3` and prints `Three`.


