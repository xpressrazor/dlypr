#include <stdio.h>

/**
* Find intersection between two lines
*/
int main()
{
    double a, b, c, d;
    printf("y=ax+b, y=cx+d\n");
    printf("a b c d: ");
    scanf("%lf %lf %lf %lf", &a, &b, &c, &d);
    if (a==c) {
        printf("Two lines are parallel\n");
    } else {
        double x, y;
        x = (d-b)/(a-c);
        y = a * (d-b)/(a-c) + b;
        printf("The lines intersect at: (%g, %g)\n", x, y);
    }
} 
