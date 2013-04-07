#include <foo.h>


struct lafe_line_reader *
lafe_line_reader(const char *pathname, int nullSeparator)
{
	if (strcmp(pathname, "-") == 0)
		lr->f = stdin;
	else
		lr->f = fopen(pathname, "r");
}

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

#ifdef open_file
/* prototype 1 */

void read_png(char *file_name)  /* We need to open the file */
{
	return (ERROR);

#else no_open_file
/* prototype 2 */
   void read_png(FILE *fp, unsigned int sig_read)  /* File is already open */
      {
#endif no_open_file
 /* Only use one prototype! */
	   foo();
}

#endif /* if 0 */


int main(int argc, char **argv)
{

    do
        XNextEvent(display, &e);
    while (!(e.type == ButtonPress && e.xbutton.button == Button1) &&
           !(e.type == KeyPress &&    /*  v--- or 1 for shifted keys */
             ((k = XLookupKeysym(&e.xkey, 0)) == XK_q || k == XK_Escape) ));
   
}

void
js_GetObjectSlotName(JSTracer *trc, char *buf, size_t bufsize)
{
   

    if (!shape) {
        const char *slotname = NULL;
        if (obj->isGlobal()) {
#define TEST_SLOT_MATCHES_PROTOTYPE(name,code,init)                           \
            if ((code) == slot) { slotname = js_##name##_str; goto found; }
            JS_FOR_EACH_PROTOTYPE(TEST_SLOT_MATCHES_PROTOTYPE)
#undef TEST_SLOT_MATCHES_PROTOTYPE
        }
     
    } else {
        jsid propid = shape->propid();
        if (JSID_IS_INT(propid)) {
            JS_snprintf(buf, bufsize, "%ld", (long)JSID_TO_INT(propid));
        } else if (JSID_IS_ATOM(propid)) {
            PutEscapedString(buf, bufsize, JSID_TO_ATOM(propid), 0);
        } else {
            JS_snprintf(buf, bufsize, "**FINALIZED ATOM KEY**");
        }
    }
}

int
js_BoyerMooreHorspool(const jschar *text, uint32_t textlen,
                      const jschar *pat, uint32_t patlen)
{
	 for (uint32_t k = m; k < textlen; k += ((c = text[k]) >= sBMHCharSetSize) ? patlen : skip[c]) {
         }
}

static void
__tar_dosmaperr(unsigned long e)
{
	int			i;

	if (e == 0)	{
		errno = 0;
		return;
	}

	for (i = 0; i < (int)sizeof(doserrors); i++) {
		if (doserrors[i].winerr == e) {
			errno = doserrors[i].doserr;
			return;
		}
	}

	/* fprintf(stderr, "unrecognized win32 error code: %lu", e); */
	errno = EINVAL;
	return;
}

