

int test_call_get()
{
  int x = bar(y);
  
  if(x == ERROR) return;

  foo(x);
}

int test_call_tainting()
{
	taint_source(&x,&y);

	if(x == 0) return 1;
	if(y == 0) return -1;
}


int two_taint_sources()
{
	taint_source(&x,&y);	
	second_taint_source(&z);
	
	if(y == 0) return 1;
	if(z == 0) return -1;
}


int test_dataFlowFromRegex()
{
	taint_source(&x,&y);	
	if(x == 0) return;

	sink(y);
}

int test_isNotSanitizedByRegex()
{
	taint_source(&x,&y);	
	
	memset(y, 0, sizeof(y));

	sink(y);
}

int test_dataFlowFromUntainted()
{
	not_a_taint_source(&x,&y);	
	if(x == 0) return;

	sink(y);
}

int test_dataFlowToFromParam(int aUniqueParamName)
{
	sanitizer(aUniqueParamName);
	sink(aUniqueParamName);
}

int test_checksSymbol(int count)
{
	if(count > 0)
		return;
}

int testParamTaint(char *buf)
{
  taint_source(buf, buf);
}

int testParamTaintAssign(char *ptr)
{
  *ptr = 1;
}
