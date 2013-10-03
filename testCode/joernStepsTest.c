

int test_call_get()
{
  int x = bar(y);
  
  if(x == ERROR) return;

  foo(x);
}

int test_call_tainting()
{
	taint_source(x,y);

	if(x == 0) return 1;
	if(y == 0) return -1;
}


int two_taint_sources()
{
	taint_source(x,y);	
	second_taint_source(z);
	
	if(y == 0) return 1;
	if(z == 0) return -1;
}
