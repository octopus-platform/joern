void test_astnodes ()
{
	x = 8 * ++a - b;
}

void test_funccall (char *name)
{
	fprintf(STDERR, "Hello %s!\n", name);
}

void test_funccall_from_assignment ()
{
	x = 45 + 2*sqrt(9);
}

void test_funccall_from_nested_assignment ()
{
	x = 45 + (a = 5 + sqrt(9));
}

int declared_function(char *, int);

