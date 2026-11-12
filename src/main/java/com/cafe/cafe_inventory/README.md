2. What is the difference between the static variable `totalProducts` and the instance variable `name`?

`totalProducts` is `static`, so there is one shared variable for the `Product` class. All `Product` objects access the same value. `name` is an instance variable, so every `Product` object has its own `name`; changing one product's name does not change another's.

3. What does the copy constructor do, and why does changing `p2.name` not change `p1.name`?

The copy constructor `Product(Product other)` creates a new `Product` and copies the source product's `name`, `price`, and `quantity` into it. After `Product p2 = new Product(p1);`, `p1` and `p2` are separate objects with separate fields. Assigning a new value to `p2.name` changes only that object's field, not `p1.name`. Although both fields initially refer to the same `String` value, strings are immutable, and assigning a different string to one field does not modify the other.

4. Why does Java require `(int) average` when converting a `double` to an `int`, and what happens to the decimal part?

The cast is required because a `double` can hold fractional values and a wider range than an `int`, so converting it can lose information. Casting to `int` discards the fractional part by truncating toward zero; it does not round to the nearest integer. For example, `(int) 5.9` is `5`, and `(int) -5.9` is `-5`.
