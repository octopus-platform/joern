void multi_catch(void)
{
	try {
		exception();
	}
	catch (int e) {
		oops();
	}
	catch (char e) {
		oops();
	}
	catch (...) {
		oops();
	}
}

void nested_try(void)
{
	try
	{
		try {
			try_something();
		}
		catch(int e) {
			throw 't';
		}

	}
	catch (char e)
	{
		oops();
	}
	catch (...)
	{
		oops();
	}
}

void throw_without_catch(void) {
	throw -1;
}
