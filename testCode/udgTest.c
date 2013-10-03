
int udg_test_simple_decl()
{
	int x;
}

int udg_test_decl_with_assign()
{
	int x = 0;
}

int udg_test_param_decl(int x)
{
	
}

int udg_test_use_untainted_call()
{
	foo(x);
}

int udg_test_def_tainted_call()
{
	foo(x);
}

int udg_test_def_tainted_call_addr()
{
	foo(&x);
}

int plusEqualsUse()
{
	// there should be a DEF(X)
	// and a USE(X), USE(Y)
	x += y;
}

int condition_test()
{
  if(x && y) return 0;
  if(z) return 1;
}

int test_buf_def()
{
  // We need to improve pointer tracking here:
  // Currently, it's USE(buf), DEF(buf)
  buf[i] = x;
}
