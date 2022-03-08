# Workshop Two Markdown File - SENG3320

#### Written by Bryce Tuppurainen

Extremely useful resource: https://code.visualstudio.com/docs/java/java-testing

---

## 1. Concepts

- How many branches are there in an if-statement? Two

---

- What does a loop loop like in a CFG? There are two outgoing edges at the end of the loop, one back to the original node which often comes out the side, the other feeding down which is the exit situation for the loop

---

- Statement, Branch, Path Coverage:

  - Statement Coverage: is just the ratio of the number of statements over the total number of statements in the CFG that get executed by a particular set of test cases

  - Branch Coverage: is the same, but for unique branches, so you count the edges that get executed over the total number of edges

  - Path coverage: Is where you consider every single possible combination of path that can be executed, and count the number of unique paths that are followed by a collection of test cases against the total number of possible unique paths

---

## Consider the following code:

```
public static int median(int x, int y, int z) {
        int median = 0;
        if(x >= y && x <= z){
            median = x;
        } else if(x >= z && x <= y){
            median = x;
        } else if(y >=x && y < z){
            median = z;
        } else if(y >= z && y <= x){
            median = y;
        } else {
            median = z;
        }
        return median;
   }
}
```

```
Y <= X <= Z - case one
Z <= X <= Y - case two (else-if)
X <= Y < Z - case three (else-if)
Z < Y <= X - case four (else-if)
NO OTHER CONDITIONS - case five

There is no way to satisfy more than one 'case' at once due to the elses, therefore five required tests
```

1. Test cases for 100% Statement Branch and Path Coverage:

   - t1:{x=1,y=1,z=1} - All Equal OR Y, X, Z
   - t2:{x=2,y=3,z=1} - Z, X, Y
   - t3:{x=1,y=2,z=3} - X, Y, Z
   - t4:{x=1,y=2,z=3} - Z, Y, X
   - t5:{x=3,y=1,z=2} - Y, Z, X

2. Yes, statement on line-8 forms a contidiction with not line-4 and as such line-9 is unreachable

3. - See VSDX file
   - Six Branches - Including the isStrong check at the end
   - Many of the execution paths are unreachable, the problem is that any time that isStrong is set to false then the true statement at the bottom then becomes unreachable (i.e., there are contridictions in this code)
   - Two test inputs for 100% Statement Coverage, one where every condition is satisfied and the password is weak, and the other where no conditions are satisfied and the password is strong
   - The same two also provide 100% Branch Coverage together as they hit every possible edge on the 'way-down'
