1. Concepts:

   - What is condition coverage?

   Condition coverage is the number of conditions that have their true-and-false branches considered over the number of total possible true-false branches for every condition (note that there can be multiple conditions within a single decision)

   `if ((x > 5) && (y < 0)); T = {(x=6,y=1), (x=4, y=-1)}`

   - What is C/DC?

   Is is both the condition coverage, as well as the number of full decisions that can be satisfied as true-and-false overall.

   `if ((x > 5) && (y < 0)); T = {(x=6,y=-1), (x=4, y=1)}`

   - What is MCC?

   Every single combination of true-and-false for every single condition must be satisfied

   `if ((x > 5) && (y < 0)); T = {(x=6,y=-1), (x=6, y=1), (x=5, y=-1), (x=5, y=1)}`

   - How do you compare these coverage metrics?

   MCC >= C/DC >= CC - However, this also applies to their worst-case time/space complexity for testing

2. Coverage Analysis:

   ```
   if ((A||B) && C) {
       // CODE
   } else {
   // MORE CODE
   }
   ```

   AND

   ```
   if (A||B||C) {
       // CODE
   } else {
       // MORE CODE
   }
   ```

   - 100% Statement, Condition, C/DC and Branch Coverage:

   ```
   T={(A=TRUE,B=TRUE,C=TRUE),(A=FALSE,B=FALSE,C=FALSE)}
   ```

   - 100% MCC

   ```
   T={
       (A=TRUE,B=TRUE,C=TRUE)
       (A=TRUE,B=TRUE,C=FALSE)
       (A=TRUE,B=FALSE,C=TRUE)
       (A=TRUE,B=FALSE,C=FALSE)
       (A=FALSE,B=TRUE,C=TRUE)
       (A=FALSE,B=TRUE,C=FALSE)
       (A=FALSE,B=FALSE,C=TRUE)
       (A=FALSE,B=FALSE,C=FALSE)
   }
   ```
