
int arg_tainter_basic_test()
{
  struct myVar;
  memset(myVar, 0, sizeof(myVar));
}

int interproc_arg_tainter_test()
{
  int x;
  interproc_callee(&x);
  sink12(x);
}

int interproc_callee(int *x)
{
  *x = source12();
}
