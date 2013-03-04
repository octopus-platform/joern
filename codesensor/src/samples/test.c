#include <foo.h>

struct foo{
	int x;
};

struct {
	int x;
} v;

struct foobar{
	int x;
} *v;

namespace foo{
	int *ptr = 0x0, *foo = bar;
}

int foo::bar(char *str)
{

}

int foo::bar2(): x(y)
{

}
