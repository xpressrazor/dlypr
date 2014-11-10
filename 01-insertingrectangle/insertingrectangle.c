#include <stdio.h>
#include <stdarg.h>

#define MAP_WIDTH 1024
#define MAP_HEIGHT 1024

/*
 * Find intersecting rectangles.
 */
/*
 * A map that consists of 0 and 1, i.e 1=1block rectangle, 0 = 0block rectangle
 */ 
int map[MAP_WIDTH][MAP_HEIGHT] = {0}; /* Initialize all the map to 0 */

/* To count total area covered by rectangles, we just need to sum up the total pixels used by them, in the paper/map */
void setup_rectangles(int n_args, ...)
{
    va_list myList;
    va_start(myList, n_args);
    int k;

    for(k = 0; k < n_args; k++)
    {
        /* Each rectangle will have the next 4 elements as
         * x1, y1, x2, y2 i.e we need to call va_arg four times
        */
        int x1 = va_arg(myList, int);
        int y1 = va_arg(myList, int);
        int x2 = va_arg(myList, int);
        int y2 = va_arg(myList, int);

        int i, j;
        for(i = y1; i < y2; i++) {
            for(j = x1; j < x2; j++) {
                map[j][i] = 1;
            }
        }
    }   
}

/* Count rectangle size */
int rectsize()
{
    int i, j;
    int sum = 0;

    for(i = 0; i < MAP_HEIGHT; i++) {
        for(j = 0; j < MAP_WIDTH; j++) {
            sum += map[j][i];
        }
    }

    return sum;
}

/* Test */
int main()
{
    /*
    3
        0 1 3 3
        2 2 6 4
        1 0 3 5
    */
    setup_rectangles(
                     3,
                     0, 1, 3, 3,
                     2, 2, 6, 4,
                     1, 0, 3, 5
    );

    printf("Rectangle size: %d\n", rectsize());
} 
