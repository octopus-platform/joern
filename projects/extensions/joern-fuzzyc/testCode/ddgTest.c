

int ddg_simplest_test()
{
	// Make sure x propagates to foo 
	int x = 0;
	foo(x);
}


int ddg_test_struct()
{
	struct my_struct foo;
	foo.bar = 10;
	copy_somehwere(foo);
}
