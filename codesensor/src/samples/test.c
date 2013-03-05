#include <foo.h>

int bar, *foo[10];

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

static void
free_cache(struct name_cache *cache)
{
	size_t i;

	if (cache != NULL) {
		for (i = 0; i < cache->size; i++)
			free(cache->cache[i].name);
		free(cache);
	}
}

static const char * lookup_name(struct cpio *cpio, struct name_cache **name_cache_variable,
				int (*lookup_fn)(struct cpio *, const char **, id_t), id_t id)
{
	
}
		
