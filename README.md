FizzBuzz
===============

Introduction

This kata, taken from a popular children's maths game (or student drinking game), 
is the starting point on the TDD track. It's designed to be a semi-guided first 
stop for learning TDD from scratch.

Instructions

Write a function that takes positive integers and outputs their string representation.

Your function should comply with the following additional rules:

1. If the number is a multiple of three, return the string "Fizz".
2. If the number is a multiple of five, return the string "Buzz".
3. If the number is a multiple of both three and five, return the string "FizzBuzz".

For example, given the numbers from 1 to 15 in order, the function would return:

    1
    2
    Fizz
    4
    Buzz
    Fizz
    7
    8
    Fizz
    Buzz
    11
    Fizz
    13
    14
    FizzBuzz

Link: https://www.codurance.com/katalyst/fizzbuzz

Roman Numerals
===============

Introduction

Write a program to convert Arabic numbers into their Roman numeral equivalents.

The Romans wrote their numbers using combinations of the following letters:

        Number	Numeral
        1		I
        5		V
        10		X
        50		L
        100		C
        500		D
        1000	M

Initially, the Roman Numerals system consisted of expressing the number in terms 
of the most appropriate symbol that could be used.

To start, for the numbers 1-4, we would use the 'I' symbol in multiples to represent 
the number:

        Number	Numeral
        1		I
        2		II
        3		III
        4		IV

When the numbers got to 5, we would use 'V' as this symbol was the most 
efficient way to represent the number.

        Number	Numeral
        5		V

For the single integers greater than 5, a new rule came into effect: when 'smaller' 
symbols are appended one or more times behind the 'larger' symbol, it is 
considered to be added to the value representing the larger symbol.

        Number	Numeral
        6		VI
        7		VII
        8		VIII
        9		VIIII

So, the initial sequence of Roman Numerals for the integers 1 - 9 were as follows:

        1	2	3	4	5	6	7	8	9
        I	II	III	IIII	V	VI	VII	VIII	VIIII

However, as you may have noticed the numbers for 4 and 9 don't look right. But 
the original formation of the numerals was this (even some clock faces still display 
IIII for 4). But this created problems as people kept confusing III with IIII and VIII 
with VIIII an additional rule was developed.

For numbers such as 4 and 9, the smaller symbol (I) is prepended with the larger 
symbol (V or 5 for the number 4, and X representing 10 for the number 9). When 
the smaller symbol appears before the larger symbol, it is considered to 
be subtracted from the larger symbol.

So, 'IV' is evaluated as: V - I = 5 - 1 = 4 and 'IX' is evaluated as: X - I = 10 - 1 = 9

Hence, the list of Roman Numerals for 1 - 9 are as amended to:

        1	2	3	4	5	6	7	8	9
        I	II	III	IV	V	VI	VII	VIII	IX

Because Roman system is follow a decimal notation system, the same rules apply 
for the next order up: units of 10. In this case, use the symbols, 'X' for 10, 'L' for fifty
and 'C' for a hundred.

        10	20	30	40	50	60	70	80	90
        X	XX	XXX	XL	L	LX	LXX	LXXX	XC

For the next decimal order up, use the same rules again with 'C' for 100, 'D' for 
500 and 'M' for 1000

        100	200	300	400	500	600	700	800	900
        C	CC	CCC	CD	D	DC	DCC	DCCC	CM
(As there are no symbols higher than 'M' (1000) the pattern stops here, and 
usually Roman Numerals don't consider numbers more than a few thousand)

There were certain rules that the numerals follow which should be observed:

The 'base 1' symbols ('I', 'X', 'C', 'M') can be subtracted from the next highest 
'base 5' symbol ('V', 'L', 'D') or 'base 1' symbol, but only one occurrence is 
allowed. The symbol cannot be prepended to a symbol that is the next decimal 
order higher. So 'IV', 'IX' is ok' but 'IL' or 'IC' are not. 'XL', 'XC' is valid' but XD and
XM are not ('CD' and 'CM' are also valid)

The symbols 'I' and 'X' can be repeated at most 3 times in a row when the 
symbol is being appended

The 'base 5' symbols 'V', 'L' and 'D' can never be repeated

More examples:

        Number	Numeral
        4		IV
        9		IX
        29		XXIX
        80		LXXX
        294		CCXCIV
        2019	MMXIX


Link: https://www.codurance.com/katalyst/roman-numerals

Mars Rover Kata
===============

Develop an API that moves a rover around on a grid.

Rules:

1. You are given the initial starting point (0,0,N) of a rover.
2. 0,0 are X,Y co-ordinates on a grid of (10,10).
3. N is the direction it is facing (i.e. N,S,E,W).
4. L and R allow the rover to rotate left and right.
5. M allows the rover to move one point in the current direction.
6. The rover receives a char array of commands e.g. RMMLM and returns the finishing point after the moves e.g. 2:1:N
7. The rover wraps around if it reaches the end of the grid.
8. The grid may have obstacles. If a given sequence of commands encounters an obstacle, the rover moves up to the 
last possible point and reports the obstacle e.g. O:2:2:N

Link: https://www.codurance.com/katalyst/mars-rover


Bank Kata
===============

Test application from outside, identifying side effects

### Problem description - Bank Kata

Create a simple bank application with the following features:

    - Deposit into Account
    - Withdraw from an Account
    - Print a bank statement to the console

## Acceptance criteria

Statement should have transactions in the following format:

    Date       || Amount || Balance
    10/04/2014 || 500.00 || 1400.00
    02/04/2014 || -100.00 || 900.00
    01/04/2014 || 1000.00 || 1000.00

## Starting point and constraints

Start with a class the following structure:

    public class Account {

        public void deposit(int amount);

        public void withdrawal(int amount);

        public void printStatement();
    }

You are not allowed to add any other public method to this class.

NOTE: In order to keep the exercise simple, use int for money and String for dates. Also, you can ignore the formatting of the statement (spaces between pipes and words, etc).

Link: https://www.codurance.com/katalyst/bank


Bags Kata
===============

## Requirements

Create an application that helps Durance organize the items in his bags. Each bag 
can have either a category or not, the backpack has no category.

Items are always added to the backpack, if it happens to be full, the item is added 
to the next available bag.

After organizing the items, each bag should have the items belonging to its 
category, sorted alphabetically. If the bag happens to be full, the rest of the items 
are stored in the backpack or successive bags, following the previous sort.

## Rules

Durance has 1 backpack and 4 extra bags
Each bag has a capacity of 4 items, the backpack has a capacity of 8 items
Each bag can have a category, the backpack doesn't have one
Items are sorted alphabetically after organizing the bags

## Items

        {
        "clothes": ["Leather", "Linen", "Silk", "Wool"],
        "herbs": ["Cherry Blossom", "Marigold", "Rose", "Seaweed"],
        "metals": ["Copper", "Gold", "Iron", "Silver"],
        "weapons": ["Axe", "Dagger", "Mace", "Sword"]
        }

Link: https://www.codurance.com/katalyst/bags

ATM Machine Kata
===============

# Iteration 1
## Business Rules

We want to build an ATM machine and the first thing we need to do, is to create 
the software that will breakdown which bills (notes) and coins to give you when 
you are trying to make a withdrawal.

The content of the ATM is:

    | Value | Type |
    |-------|------|
    | 500   | bill |
    | 200   | bill |
    | 100   | bill |
    | 50    | bill |
    | 20    | bill |
    | 10    | bill |
    | 5     | bill |
    | 2     | coin |
    | 1     | coin |

## Example

Input

    As a user
    I withdraw 434€

Output

    2 bills of 200.
    1 bill of 20.
    1 bill of 10.
    2 coins of 2.

# Iteration 2
## Business Rules

The ATM machine has the following distribution of money.

- When the ATM machine has no more money should return an error that shows 
"The ATM machine has not enough money, please go to the nearest atm 
machine".
- If the ATM has no more bills or coins should try to use other quantities to allow 
the user to withdraw the amount.

The initial state of any ATM

    | Value | Type | quantity of units |
    |-------|------|-------------------|
    | 500   | bill | 2                 |
    | 200   | bill | 3                 |
    | 100   | bill | 5                 |
    | 50    | bill | 12                |
    | 20    | bill | 20                |
    | 10    | bill | 50                |
    | 5     | bill | 100               |
    | 2     | coin | 250               |
    | 1     | coin | 500               |

## Example

The initial state of any ATM

    | Value | Type | quantity of units |
    |-------|------|-------------------|
    | 500   | bill | 2                 |
    | 200   | bill | 3                 |
    | 100   | bill | 5                 |
    | 50    | bill | 12                |
    | 20    | bill | 20                |
    | 10    | bill | 50                |
    | 5     | bill | 100               |
    | 2     | coin | 250               |
    | 1     | coin | 500               |

Input

    As a user
    I withdraw 1725€

Output

    2 bills of 500.
    3 bills of 200.
    1 bill of 100.
    1 bill of 20.
    1 bill of 5.

ATM state after the output

    | Value | Type | quantity of units |
    |-------|------|-------------------|
    | 500   | bill | 0                 |
    | 200   | bill | 0                 |
    | 100   | bill | 4                 |
    | 50    | bill | 12                |
    | 20    | bill | 19                |
    | 10    | bill | 50                |
    | 5     | bill | 99                |
    | 2     | coin | 250               |
    | 1     | coin | 500               |

Input

    As a user
    I withdraw 1825€

Output

    4 bills of 100.
    12 bills of 50.
    19 bills of 20.
    44 bills of 10.
    1 bill of 5.

ATM state after the output

    | Value | Type | quantity of units |
    |-------|------|-------------------|
    | 500   | bill | 0                 |
    | 200   | bill | 0                 |
    | 100   | bill | 0                 |
    | 50    | bill | 0                 |
    | 20    | bill | 0                 |
    | 10    | bill | 6                 |
    | 5     | bill | 98                |
    | 2     | coin | 250               |
    | 1     | coin | 500               |
