#include <foo.h>

void
set_chdir(struct bsdtar *bsdtar, const char *newdir)
{
#if defined(_WIN32) && !defined(__CYGWIN__)
	if (newdir[0] == '/' || newdir[0] == '\\' ||
	    /* Detect this type, for example, "C:\" or "C:/" */
	    (((newdir[0] >= 'a' && newdir[0] <= 'z') ||
	      (newdir[0] >= 'A' && newdir[0] <= 'Z')) &&
	    newdir[1] == ':' && (newdir[2] == '/' || newdir[2] == '\\'))) {
#else
	if (newdir[0] == '/') {
#endif
		/* The -C /foo -C /bar case; dump first one. */
		free(bsdtar->pending_chdir);
		bsdtar->pending_chdir = NULL;
	}
	if (bsdtar->pending_chdir == NULL)
		/* Easy case: no previously-saved dir. */
		bsdtar->pending_chdir = strdup(newdir);
	else {
		/* The -C /foo -C bar case; concatenate */
		char *old_pending = bsdtar->pending_chdir;
		size_t old_len = strlen(old_pending);
		bsdtar->pending_chdir = malloc(old_len + strlen(newdir) + 2);
		if (old_pending[old_len - 1] == '/')
			old_pending[old_len - 1] = '\0';
		if (bsdtar->pending_chdir != NULL)
			sprintf(bsdtar->pending_chdir, "%s/%s",
			    old_pending, newdir);
		free(old_pending);
	}
	if (bsdtar->pending_chdir == NULL)
		lafe_errc(1, errno, "No memory");
}

some_water;

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
		
static ssize_t
_7z_write_data(struct archive_write *a, const void *buff, size_t s)
{
	
}
