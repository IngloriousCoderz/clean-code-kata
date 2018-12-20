# clean-code-kata

A NetBeans project used as a benchmark for lessons on Clean Code.

There are three examples here:

1. Button: a very badly written code, refactored into something more readable.
2. Mario: a representation of Nintendo's famous character, with powerups added through different kinds of solutions:
   1. God Object: one object with a nested switch/case based on type
   2. Hierarchy: A BaseMario class is extended by the superpowered classes
   3. State: BaseMario behaves differently depending on the state it holds
   4. Decorator: the different behaviors can be added and combined at runtime
3. Christmas Tree: an experiment on decorators and TDD, in which we build a complex Christmas tree with parametric height by splitting the problem into multiple simpler subproblems. The end result will look like this:

```
     qp
    ì/\ì
   ì/ *\ì
  ì/o* o\ì
 ì/ o*  *\ì
ì/**  *   \ì
 ----------
     ||
```

There is also an example in which the decorators we built can decorate any kind of tree. For example, a Christmas oak tree will look like this:

```
     qp
ì/--------\ì
ì| o   oo |ì
ì|   *oo  |ì
ì\--------/ì
    \\//
     ||
     ||
```

Every example is purposedly non-commented and solely documented through unit tests.
