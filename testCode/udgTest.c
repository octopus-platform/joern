
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

int udg_test_struct_field_use()
{
  foo(x.y);
}

int udg_test_assign_to_array_field()
{
  arr[x] = 0;
}


int udg_test_assign_to_expression()
{
  *(a + b) = 0;
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

int conditional_expr()
{
  int x = foo? bar: 0;
}

int test_buf_def()
{
  buf[i] = x;
}

int arrUse()
{
  x = arr[i];
}

int complexInArgs()
{
  return foo( pLtv->u.u16 );
}


int complexAssign()
{
  pLtv->u.u16 = 1;
  return 0;
}

int plusplus()
{
  a ++;
}

int callWithRef()
{
  fooBar(&bar);
}

int nonDerefUnary()
{
  x = ++ a;
}
