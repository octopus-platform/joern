// Generated from ./CodeSensor.g4 by ANTLR 4.0

	package antlr;


  import java.util.Stack;

import org.antlr.v4.runtime.atn.*;
import org.antlr.v4.runtime.dfa.DFA;
import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.misc.*;
import org.antlr.v4.runtime.tree.*;
import java.util.List;
import java.util.Iterator;
import java.util.ArrayList;

@SuppressWarnings({"all", "warnings", "unchecked", "unused", "cast"})
public class CodeSensorParser extends Parser {
	protected static final DFA[] _decisionToDFA;
	protected static final PredictionContextCache _sharedContextCache =
		new PredictionContextCache();
	public static final int
		T__52=1, T__51=2, T__50=3, T__49=4, T__48=5, T__47=6, T__46=7, T__45=8, 
		T__44=9, T__43=10, T__42=11, T__41=12, T__40=13, T__39=14, T__38=15, T__37=16, 
		T__36=17, T__35=18, T__34=19, T__33=20, T__32=21, T__31=22, T__30=23, 
		T__29=24, T__28=25, T__27=26, T__26=27, T__25=28, T__24=29, T__23=30, 
		T__22=31, T__21=32, T__20=33, T__19=34, T__18=35, T__17=36, T__16=37, 
		T__15=38, T__14=39, T__13=40, T__12=41, T__11=42, T__10=43, T__9=44, T__8=45, 
		T__7=46, T__6=47, T__5=48, T__4=49, T__3=50, T__2=51, T__1=52, T__0=53, 
		IF=54, ELSE=55, FOR=56, WHILE=57, BREAK=58, CASE=59, CONTINUE=60, SWITCH=61, 
		DO=62, GOTO=63, RETURN=64, TYPEDEF=65, VOID=66, UNSIGNED=67, SIGNED=68, 
		LONG=69, CV_QUALIFIER=70, VIRTUAL=71, TRY=72, CATCH=73, THROW=74, USING=75, 
		NAMESPACE=76, AUTO=77, REGISTER=78, OPERATOR=79, TEMPLATE=80, CLASS_KEY=81, 
		ALPHA_NUMERIC=82, OPENING_CURLY=83, CLOSING_CURLY=84, SMALLER=85, LARGER=86, 
		PRE_IF=87, PRE_ELSE=88, PRE_ENDIF=89, HEX_LITERAL=90, DECIMAL_LITERAL=91, 
		OCTAL_LITERAL=92, FLOATING_POINT_LITERAL=93, CHAR=94, STRING=95, COMMENT=96, 
		WHITESPACE=97, CPPCOMMENT=98, OTHER=99;
	public static final String[] tokenNames = {
		"<INVALID>", "'&'", "'*'", "'['", "'--'", "'!='", "'<='", "'<<'", "'%'", 
		"'->'", "'*='", "')'", "'explicit'", "'inline'", "'::'", "'='", "'|='", 
		"'new'", "'|'", "'!'", "']'", "'<<='", "'-='", "'->*'", "'public'", "','", 
		"'-'", "':'", "'('", "'&='", "'private'", "'?'", "'>>='", "'...'", "'+='", 
		"'^='", "'friend'", "'static'", "'++'", "'>>'", "'delete'", "'^'", "'.'", 
		"'+'", "'protected'", "';'", "'&&'", "'||'", "'%='", "'/='", "'/'", "'=='", 
		"'~'", "'>='", "'if'", "'else'", "'for'", "'while'", "'break'", "'case'", 
		"'continue'", "'switch'", "'do'", "'goto'", "'return'", "'typedef'", "'void'", 
		"'unsigned'", "'signed'", "'long'", "CV_QUALIFIER", "'virtual'", "'try'", 
		"'catch'", "'throw'", "'using'", "'namespace'", "'auto'", "'register'", 
		"'operator'", "'template'", "CLASS_KEY", "ALPHA_NUMERIC", "'{'", "'}'", 
		"'<'", "'>'", "PRE_IF", "PRE_ELSE", "PRE_ENDIF", "HEX_LITERAL", "DECIMAL_LITERAL", 
		"OCTAL_LITERAL", "FLOATING_POINT_LITERAL", "CHAR", "STRING", "COMMENT", 
		"WHITESPACE", "CPPCOMMENT", "OTHER"
	};
	public static final int
		RULE_code = 0, RULE_using_directive = 1, RULE_expr = 2, RULE_assign_expr = 3, 
		RULE_conditional_expression = 4, RULE_or_expression = 5, RULE_and_expression = 6, 
		RULE_inclusive_or_expression = 7, RULE_exclusive_or_expression = 8, RULE_bit_and_expression = 9, 
		RULE_equality_expression = 10, RULE_relational_expression = 11, RULE_shift_expression = 12, 
		RULE_additive_expression = 13, RULE_multiplicative_expression = 14, RULE_cast_expression = 15, 
		RULE_unary_expression = 16, RULE_postfix_expression = 17, RULE_field = 18, 
		RULE_function_call_tail = 19, RULE_call_template_list = 20, RULE_function_argument_list = 21, 
		RULE_function_argument = 22, RULE_postfix = 23, RULE_primary_expression = 24, 
		RULE_unary_operator = 25, RULE_relational_operator = 26, RULE_constant = 27, 
		RULE_function_decl_specifiers = 28, RULE_ptr_operator = 29, RULE_access_specifier = 30, 
		RULE_operator_function_id = 31, RULE_operator = 32, RULE_assignment_operator = 33, 
		RULE_equality_operator = 34, RULE_template_decl_start = 35, RULE_template_param_list = 36, 
		RULE_no_brackets = 37, RULE_no_brackets_curlies_or_squares = 38, RULE_no_brackets_or_semicolon = 39, 
		RULE_no_angle_brackets_or_brackets = 40, RULE_no_curlies = 41, RULE_no_squares = 42, 
		RULE_no_squares_or_semicolon = 43, RULE_no_comma_or_semicolon = 44, RULE_assign_water = 45, 
		RULE_assign_water_l2 = 46, RULE_water = 47, RULE_function_def = 48, RULE_return_type = 49, 
		RULE_function_param_list = 50, RULE_parameter_decl_clause = 51, RULE_parameter_decl = 52, 
		RULE_parameter_id = 53, RULE_compound_statement = 54, RULE_ctor_list = 55, 
		RULE_ctor_initializer = 56, RULE_initializer_id = 57, RULE_ctor_expr = 58, 
		RULE_function_name = 59, RULE_exception_specification = 60, RULE_type_id_list = 61, 
		RULE_init_declarator = 62, RULE_type_suffix = 63, RULE_assign_expr_w_ = 64, 
		RULE_assign_expr_w__l2 = 65, RULE_constant_expr_w_ = 66, RULE_simple_decl = 67, 
		RULE_var_decl = 68, RULE_init_declarator_list = 69, RULE_initializer = 70, 
		RULE_initializer_list = 71, RULE_class_def = 72, RULE_class_name = 73, 
		RULE_base_classes = 74, RULE_base_class = 75, RULE_type_name = 76, RULE_base_type = 77, 
		RULE_param_decl_specifiers = 78, RULE_parameter_name = 79, RULE_param_type_list = 80, 
		RULE_param_type = 81, RULE_param_type_id = 82, RULE_identifier = 83, RULE_number = 84, 
		RULE_ptrs = 85;
	public static final String[] ruleNames = {
		"code", "using_directive", "expr", "assign_expr", "conditional_expression", 
		"or_expression", "and_expression", "inclusive_or_expression", "exclusive_or_expression", 
		"bit_and_expression", "equality_expression", "relational_expression", 
		"shift_expression", "additive_expression", "multiplicative_expression", 
		"cast_expression", "unary_expression", "postfix_expression", "field", 
		"function_call_tail", "call_template_list", "function_argument_list", 
		"function_argument", "postfix", "primary_expression", "unary_operator", 
		"relational_operator", "constant", "function_decl_specifiers", "ptr_operator", 
		"access_specifier", "operator_function_id", "operator", "assignment_operator", 
		"equality_operator", "template_decl_start", "template_param_list", "no_brackets", 
		"no_brackets_curlies_or_squares", "no_brackets_or_semicolon", "no_angle_brackets_or_brackets", 
		"no_curlies", "no_squares", "no_squares_or_semicolon", "no_comma_or_semicolon", 
		"assign_water", "assign_water_l2", "water", "function_def", "return_type", 
		"function_param_list", "parameter_decl_clause", "parameter_decl", "parameter_id", 
		"compound_statement", "ctor_list", "ctor_initializer", "initializer_id", 
		"ctor_expr", "function_name", "exception_specification", "type_id_list", 
		"init_declarator", "type_suffix", "assign_expr_w_", "assign_expr_w__l2", 
		"constant_expr_w_", "simple_decl", "var_decl", "init_declarator_list", 
		"initializer", "initializer_list", "class_def", "class_name", "base_classes", 
		"base_class", "type_name", "base_type", "param_decl_specifiers", "parameter_name", 
		"param_type_list", "param_type", "param_type_id", "identifier", "number", 
		"ptrs"
	};

	@Override
	public String getGrammarFileName() { return "CodeSensor.g4"; }

	@Override
	public String[] getTokenNames() { return tokenNames; }

	@Override
	public String[] getRuleNames() { return ruleNames; }

	@Override
	public ATN getATN() { return _ATN; }


	            public boolean skipToEndOfObject()
	            {
	                Stack<Object> CurlyStack = new Stack<Object>();
	                Object o = new Object();
	                int t = _input.LA(1);

	                while(t != EOF && !(CurlyStack.empty() && t == CLOSING_CURLY)){
	                    
	                    if(t == PRE_ELSE){
	                        Stack<Object> ifdefStack = new Stack<Object>();
	                        consume();
	                        t = _input.LA(1);
	                        
	                        while(t != EOF && !(ifdefStack.empty() && (t == PRE_ENDIF))){
	                            if(t == PRE_IF)
	                                ifdefStack.push(o);
	                            else if(t == PRE_ENDIF)
	                                ifdefStack.pop();
	                            consume();
	                            t = _input.LA(1);
	                        }
	                    }
	                    
	                    if(t == OPENING_CURLY)
	                        CurlyStack.push(o);
	                    else if(t == CLOSING_CURLY)
	                        CurlyStack.pop();
	                    
	                    consume();
	                    t = _input.LA(1);
	                }
	                if(t != EOF)
	                    consume();
	                return true;
	            }

	   // this should go into FunctionGrammar but ANTLR fails
	   // to join the parser::members-section on inclusion
	   
	   public boolean preProcSkipToEnd()
	   {
	                Stack<Object> CurlyStack = new Stack<Object>();
	                Object o = new Object();
	                int t = _input.LA(1);

	                while(t != EOF && !(CurlyStack.empty() && t == PRE_ENDIF)){
	                                        
	                    if(t == PRE_IF)
	                        CurlyStack.push(o);
	                    else if(t == PRE_ENDIF)
	                        CurlyStack.pop();
	                    
	                    consume();
	                    t = _input.LA(1);
	                }
	                if(t != EOF)
	                    consume();
	                return true;
	   }


	public CodeSensorParser(TokenStream input) {
		super(input);
		_interp = new ParserATNSimulator(this,_ATN,_decisionToDFA,_sharedContextCache);
	}
	public static class CodeContext extends ParserRuleContext {
		public List<WaterContext> water() {
			return getRuleContexts(WaterContext.class);
		}
		public Using_directiveContext using_directive(int i) {
			return getRuleContext(Using_directiveContext.class,i);
		}
		public List<Function_defContext> function_def() {
			return getRuleContexts(Function_defContext.class);
		}
		public Simple_declContext simple_decl(int i) {
			return getRuleContext(Simple_declContext.class,i);
		}
		public List<Using_directiveContext> using_directive() {
			return getRuleContexts(Using_directiveContext.class);
		}
		public List<Simple_declContext> simple_decl() {
			return getRuleContexts(Simple_declContext.class);
		}
		public Function_defContext function_def(int i) {
			return getRuleContext(Function_defContext.class,i);
		}
		public WaterContext water(int i) {
			return getRuleContext(WaterContext.class,i);
		}
		public CodeContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_code; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof CodeSensorListener ) ((CodeSensorListener)listener).enterCode(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof CodeSensorListener ) ((CodeSensorListener)listener).exitCode(this);
		}
	}

	public final CodeContext code() throws RecognitionException {
		CodeContext _localctx = new CodeContext(_ctx, getState());
		enterRule(_localctx, 0, RULE_code);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(178);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << 1) | (1L << 2) | (1L << 3) | (1L << 4) | (1L << 5) | (1L << 6) | (1L << 7) | (1L << 8) | (1L << 9) | (1L << 10) | (1L << 11) | (1L << 12) | (1L << 13) | (1L << 14) | (1L << 15) | (1L << 16) | (1L << 17) | (1L << 18) | (1L << 19) | (1L << 20) | (1L << 21) | (1L << 22) | (1L << 23) | (1L << 24) | (1L << 25) | (1L << 26) | (1L << 27) | (1L << 28) | (1L << 29) | (1L << 30) | (1L << 31) | (1L << 32) | (1L << 33) | (1L << 34) | (1L << 35) | (1L << 36) | (1L << 37) | (1L << 38) | (1L << 39) | (1L << 40) | (1L << 41) | (1L << 42) | (1L << 43) | (1L << 44) | (1L << 45) | (1L << 46) | (1L << 47) | (1L << 48) | (1L << 49) | (1L << 50) | (1L << 51) | (1L << 52) | (1L << 53) | (1L << IF) | (1L << ELSE) | (1L << FOR) | (1L << WHILE) | (1L << BREAK) | (1L << CASE) | (1L << CONTINUE) | (1L << SWITCH) | (1L << DO) | (1L << GOTO))) != 0) || ((((_la - 64)) & ~0x3f) == 0 && ((1L << (_la - 64)) & ((1L << (RETURN - 64)) | (1L << (TYPEDEF - 64)) | (1L << (VOID - 64)) | (1L << (UNSIGNED - 64)) | (1L << (SIGNED - 64)) | (1L << (LONG - 64)) | (1L << (CV_QUALIFIER - 64)) | (1L << (VIRTUAL - 64)) | (1L << (TRY - 64)) | (1L << (CATCH - 64)) | (1L << (THROW - 64)) | (1L << (USING - 64)) | (1L << (NAMESPACE - 64)) | (1L << (AUTO - 64)) | (1L << (REGISTER - 64)) | (1L << (OPERATOR - 64)) | (1L << (TEMPLATE - 64)) | (1L << (CLASS_KEY - 64)) | (1L << (ALPHA_NUMERIC - 64)) | (1L << (OPENING_CURLY - 64)) | (1L << (CLOSING_CURLY - 64)) | (1L << (SMALLER - 64)) | (1L << (LARGER - 64)) | (1L << (PRE_IF - 64)) | (1L << (PRE_ELSE - 64)) | (1L << (PRE_ENDIF - 64)) | (1L << (HEX_LITERAL - 64)) | (1L << (DECIMAL_LITERAL - 64)) | (1L << (OCTAL_LITERAL - 64)) | (1L << (FLOATING_POINT_LITERAL - 64)) | (1L << (CHAR - 64)) | (1L << (STRING - 64)) | (1L << (COMMENT - 64)) | (1L << (WHITESPACE - 64)) | (1L << (CPPCOMMENT - 64)) | (1L << (OTHER - 64)) | (1L << (36 - 64)) | (1L << (37 - 64)) | (1L << (TYPEDEF - 64)) | (1L << (VOID - 64)) | (1L << (UNSIGNED - 64)) | (1L << (SIGNED - 64)) | (1L << (LONG - 64)) | (1L << (CV_QUALIFIER - 64)) | (1L << (VIRTUAL - 64)) | (1L << (USING - 64)) | (1L << (OPERATOR - 64)) | (1L << (TEMPLATE - 64)) | (1L << (CLASS_KEY - 64)) | (1L << (ALPHA_NUMERIC - 64)))) != 0)) {
				{
				setState(176);
				switch ( getInterpreter().adaptivePredict(_input,0,_ctx) ) {
				case 1:
					{
					setState(172); function_def();
					}
					break;

				case 2:
					{
					setState(173); simple_decl();
					}
					break;

				case 3:
					{
					setState(174); using_directive();
					}
					break;

				case 4:
					{
					setState(175); water();
					}
					break;
				}
				}
				setState(180);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class Using_directiveContext extends ParserRuleContext {
		public TerminalNode USING() { return getToken(CodeSensorParser.USING, 0); }
		public IdentifierContext identifier() {
			return getRuleContext(IdentifierContext.class,0);
		}
		public TerminalNode NAMESPACE() { return getToken(CodeSensorParser.NAMESPACE, 0); }
		public Using_directiveContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_using_directive; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof CodeSensorListener ) ((CodeSensorListener)listener).enterUsing_directive(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof CodeSensorListener ) ((CodeSensorListener)listener).exitUsing_directive(this);
		}
	}

	public final Using_directiveContext using_directive() throws RecognitionException {
		Using_directiveContext _localctx = new Using_directiveContext(_ctx, getState());
		enterRule(_localctx, 2, RULE_using_directive);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(181); match(USING);
			setState(182); match(NAMESPACE);
			setState(183); identifier();
			setState(184); match(45);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class ExprContext extends ParserRuleContext {
		public Assign_exprContext assign_expr(int i) {
			return getRuleContext(Assign_exprContext.class,i);
		}
		public List<Assign_exprContext> assign_expr() {
			return getRuleContexts(Assign_exprContext.class);
		}
		public ExprContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_expr; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof CodeSensorListener ) ((CodeSensorListener)listener).enterExpr(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof CodeSensorListener ) ((CodeSensorListener)listener).exitExpr(this);
		}
	}

	public final ExprContext expr() throws RecognitionException {
		ExprContext _localctx = new ExprContext(_ctx, getState());
		enterRule(_localctx, 4, RULE_expr);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(186); assign_expr();
			setState(189);
			_la = _input.LA(1);
			if (_la==25) {
				{
				setState(187); match(25);
				setState(188); assign_expr();
				}
			}

			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class Assign_exprContext extends ParserRuleContext {
		public Assignment_operatorContext assignment_operator() {
			return getRuleContext(Assignment_operatorContext.class,0);
		}
		public Conditional_expressionContext conditional_expression() {
			return getRuleContext(Conditional_expressionContext.class,0);
		}
		public Assign_exprContext assign_expr() {
			return getRuleContext(Assign_exprContext.class,0);
		}
		public Assign_exprContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_assign_expr; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof CodeSensorListener ) ((CodeSensorListener)listener).enterAssign_expr(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof CodeSensorListener ) ((CodeSensorListener)listener).exitAssign_expr(this);
		}
	}

	public final Assign_exprContext assign_expr() throws RecognitionException {
		Assign_exprContext _localctx = new Assign_exprContext(_ctx, getState());
		enterRule(_localctx, 6, RULE_assign_expr);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(191); conditional_expression();
			setState(195);
			_la = _input.LA(1);
			if ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << 10) | (1L << 15) | (1L << 16) | (1L << 21) | (1L << 22) | (1L << 29) | (1L << 32) | (1L << 34) | (1L << 35) | (1L << 48) | (1L << 49))) != 0)) {
				{
				setState(192); assignment_operator();
				setState(193); assign_expr();
				}
			}

			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class Conditional_expressionContext extends ParserRuleContext {
		public Or_expressionContext or_expression() {
			return getRuleContext(Or_expressionContext.class,0);
		}
		public Conditional_expressionContext conditional_expression() {
			return getRuleContext(Conditional_expressionContext.class,0);
		}
		public ExprContext expr() {
			return getRuleContext(ExprContext.class,0);
		}
		public Conditional_expressionContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_conditional_expression; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof CodeSensorListener ) ((CodeSensorListener)listener).enterConditional_expression(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof CodeSensorListener ) ((CodeSensorListener)listener).exitConditional_expression(this);
		}
	}

	public final Conditional_expressionContext conditional_expression() throws RecognitionException {
		Conditional_expressionContext _localctx = new Conditional_expressionContext(_ctx, getState());
		enterRule(_localctx, 8, RULE_conditional_expression);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(197); or_expression();
			setState(203);
			_la = _input.LA(1);
			if (_la==31) {
				{
				setState(198); match(31);
				setState(199); expr();
				setState(200); match(27);
				setState(201); conditional_expression();
				}
			}

			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class Or_expressionContext extends ParserRuleContext {
		public Or_expressionContext or_expression() {
			return getRuleContext(Or_expressionContext.class,0);
		}
		public And_expressionContext and_expression() {
			return getRuleContext(And_expressionContext.class,0);
		}
		public Or_expressionContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_or_expression; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof CodeSensorListener ) ((CodeSensorListener)listener).enterOr_expression(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof CodeSensorListener ) ((CodeSensorListener)listener).exitOr_expression(this);
		}
	}

	public final Or_expressionContext or_expression() throws RecognitionException {
		Or_expressionContext _localctx = new Or_expressionContext(_ctx, getState());
		enterRule(_localctx, 10, RULE_or_expression);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(205); and_expression();
			setState(208);
			_la = _input.LA(1);
			if (_la==47) {
				{
				setState(206); match(47);
				setState(207); or_expression();
				}
			}

			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class And_expressionContext extends ParserRuleContext {
		public Inclusive_or_expressionContext inclusive_or_expression() {
			return getRuleContext(Inclusive_or_expressionContext.class,0);
		}
		public And_expressionContext and_expression() {
			return getRuleContext(And_expressionContext.class,0);
		}
		public And_expressionContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_and_expression; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof CodeSensorListener ) ((CodeSensorListener)listener).enterAnd_expression(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof CodeSensorListener ) ((CodeSensorListener)listener).exitAnd_expression(this);
		}
	}

	public final And_expressionContext and_expression() throws RecognitionException {
		And_expressionContext _localctx = new And_expressionContext(_ctx, getState());
		enterRule(_localctx, 12, RULE_and_expression);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(210); inclusive_or_expression();
			setState(213);
			_la = _input.LA(1);
			if (_la==46) {
				{
				setState(211); match(46);
				setState(212); and_expression();
				}
			}

			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class Inclusive_or_expressionContext extends ParserRuleContext {
		public Inclusive_or_expressionContext inclusive_or_expression() {
			return getRuleContext(Inclusive_or_expressionContext.class,0);
		}
		public Exclusive_or_expressionContext exclusive_or_expression() {
			return getRuleContext(Exclusive_or_expressionContext.class,0);
		}
		public Inclusive_or_expressionContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_inclusive_or_expression; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof CodeSensorListener ) ((CodeSensorListener)listener).enterInclusive_or_expression(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof CodeSensorListener ) ((CodeSensorListener)listener).exitInclusive_or_expression(this);
		}
	}

	public final Inclusive_or_expressionContext inclusive_or_expression() throws RecognitionException {
		Inclusive_or_expressionContext _localctx = new Inclusive_or_expressionContext(_ctx, getState());
		enterRule(_localctx, 14, RULE_inclusive_or_expression);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(215); exclusive_or_expression();
			setState(218);
			_la = _input.LA(1);
			if (_la==18) {
				{
				setState(216); match(18);
				setState(217); inclusive_or_expression();
				}
			}

			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class Exclusive_or_expressionContext extends ParserRuleContext {
		public Exclusive_or_expressionContext exclusive_or_expression() {
			return getRuleContext(Exclusive_or_expressionContext.class,0);
		}
		public Bit_and_expressionContext bit_and_expression() {
			return getRuleContext(Bit_and_expressionContext.class,0);
		}
		public Exclusive_or_expressionContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_exclusive_or_expression; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof CodeSensorListener ) ((CodeSensorListener)listener).enterExclusive_or_expression(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof CodeSensorListener ) ((CodeSensorListener)listener).exitExclusive_or_expression(this);
		}
	}

	public final Exclusive_or_expressionContext exclusive_or_expression() throws RecognitionException {
		Exclusive_or_expressionContext _localctx = new Exclusive_or_expressionContext(_ctx, getState());
		enterRule(_localctx, 16, RULE_exclusive_or_expression);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(220); bit_and_expression();
			setState(223);
			_la = _input.LA(1);
			if (_la==41) {
				{
				setState(221); match(41);
				setState(222); exclusive_or_expression();
				}
			}

			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class Bit_and_expressionContext extends ParserRuleContext {
		public Equality_expressionContext equality_expression() {
			return getRuleContext(Equality_expressionContext.class,0);
		}
		public Bit_and_expressionContext bit_and_expression() {
			return getRuleContext(Bit_and_expressionContext.class,0);
		}
		public Bit_and_expressionContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_bit_and_expression; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof CodeSensorListener ) ((CodeSensorListener)listener).enterBit_and_expression(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof CodeSensorListener ) ((CodeSensorListener)listener).exitBit_and_expression(this);
		}
	}

	public final Bit_and_expressionContext bit_and_expression() throws RecognitionException {
		Bit_and_expressionContext _localctx = new Bit_and_expressionContext(_ctx, getState());
		enterRule(_localctx, 18, RULE_bit_and_expression);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(225); equality_expression();
			setState(228);
			_la = _input.LA(1);
			if (_la==1) {
				{
				setState(226); match(1);
				setState(227); bit_and_expression();
				}
			}

			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class Equality_expressionContext extends ParserRuleContext {
		public Equality_expressionContext equality_expression() {
			return getRuleContext(Equality_expressionContext.class,0);
		}
		public Equality_operatorContext equality_operator() {
			return getRuleContext(Equality_operatorContext.class,0);
		}
		public Relational_expressionContext relational_expression() {
			return getRuleContext(Relational_expressionContext.class,0);
		}
		public Equality_expressionContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_equality_expression; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof CodeSensorListener ) ((CodeSensorListener)listener).enterEquality_expression(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof CodeSensorListener ) ((CodeSensorListener)listener).exitEquality_expression(this);
		}
	}

	public final Equality_expressionContext equality_expression() throws RecognitionException {
		Equality_expressionContext _localctx = new Equality_expressionContext(_ctx, getState());
		enterRule(_localctx, 20, RULE_equality_expression);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(230); relational_expression();
			setState(234);
			_la = _input.LA(1);
			if (_la==5 || _la==51) {
				{
				setState(231); equality_operator();
				setState(232); equality_expression();
				}
			}

			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class Relational_expressionContext extends ParserRuleContext {
		public Shift_expressionContext shift_expression() {
			return getRuleContext(Shift_expressionContext.class,0);
		}
		public Relational_operatorContext relational_operator() {
			return getRuleContext(Relational_operatorContext.class,0);
		}
		public Relational_expressionContext relational_expression() {
			return getRuleContext(Relational_expressionContext.class,0);
		}
		public Relational_expressionContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_relational_expression; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof CodeSensorListener ) ((CodeSensorListener)listener).enterRelational_expression(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof CodeSensorListener ) ((CodeSensorListener)listener).exitRelational_expression(this);
		}
	}

	public final Relational_expressionContext relational_expression() throws RecognitionException {
		Relational_expressionContext _localctx = new Relational_expressionContext(_ctx, getState());
		enterRule(_localctx, 22, RULE_relational_expression);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(236); shift_expression();
			setState(240);
			_la = _input.LA(1);
			if (_la==6 || _la==53 || _la==SMALLER || _la==LARGER) {
				{
				setState(237); relational_operator();
				setState(238); relational_expression();
				}
			}

			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class Shift_expressionContext extends ParserRuleContext {
		public Additive_expressionContext additive_expression() {
			return getRuleContext(Additive_expressionContext.class,0);
		}
		public Shift_expressionContext shift_expression() {
			return getRuleContext(Shift_expressionContext.class,0);
		}
		public Shift_expressionContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_shift_expression; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof CodeSensorListener ) ((CodeSensorListener)listener).enterShift_expression(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof CodeSensorListener ) ((CodeSensorListener)listener).exitShift_expression(this);
		}
	}

	public final Shift_expressionContext shift_expression() throws RecognitionException {
		Shift_expressionContext _localctx = new Shift_expressionContext(_ctx, getState());
		enterRule(_localctx, 24, RULE_shift_expression);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(242); additive_expression();
			setState(245);
			_la = _input.LA(1);
			if (_la==7 || _la==39) {
				{
				setState(243);
				_la = _input.LA(1);
				if ( !(_la==7 || _la==39) ) {
				_errHandler.recoverInline(this);
				}
				consume();
				setState(244); shift_expression();
				}
			}

			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class Additive_expressionContext extends ParserRuleContext {
		public Additive_expressionContext additive_expression() {
			return getRuleContext(Additive_expressionContext.class,0);
		}
		public Multiplicative_expressionContext multiplicative_expression() {
			return getRuleContext(Multiplicative_expressionContext.class,0);
		}
		public Additive_expressionContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_additive_expression; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof CodeSensorListener ) ((CodeSensorListener)listener).enterAdditive_expression(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof CodeSensorListener ) ((CodeSensorListener)listener).exitAdditive_expression(this);
		}
	}

	public final Additive_expressionContext additive_expression() throws RecognitionException {
		Additive_expressionContext _localctx = new Additive_expressionContext(_ctx, getState());
		enterRule(_localctx, 26, RULE_additive_expression);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(247); multiplicative_expression();
			setState(250);
			_la = _input.LA(1);
			if (_la==26 || _la==43) {
				{
				setState(248);
				_la = _input.LA(1);
				if ( !(_la==26 || _la==43) ) {
				_errHandler.recoverInline(this);
				}
				consume();
				setState(249); additive_expression();
				}
			}

			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class Multiplicative_expressionContext extends ParserRuleContext {
		public List<Cast_expressionContext> cast_expression() {
			return getRuleContexts(Cast_expressionContext.class);
		}
		public Cast_expressionContext cast_expression(int i) {
			return getRuleContext(Cast_expressionContext.class,i);
		}
		public Multiplicative_expressionContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_multiplicative_expression; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof CodeSensorListener ) ((CodeSensorListener)listener).enterMultiplicative_expression(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof CodeSensorListener ) ((CodeSensorListener)listener).exitMultiplicative_expression(this);
		}
	}

	public final Multiplicative_expressionContext multiplicative_expression() throws RecognitionException {
		Multiplicative_expressionContext _localctx = new Multiplicative_expressionContext(_ctx, getState());
		enterRule(_localctx, 28, RULE_multiplicative_expression);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(252); cast_expression();
			setState(255);
			_la = _input.LA(1);
			if ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << 2) | (1L << 8) | (1L << 50))) != 0)) {
				{
				setState(253);
				_la = _input.LA(1);
				if ( !((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << 2) | (1L << 8) | (1L << 50))) != 0)) ) {
				_errHandler.recoverInline(this);
				}
				consume();
				setState(254); cast_expression();
				}
			}

			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class Cast_expressionContext extends ParserRuleContext {
		public Cast_expressionContext cast_expression() {
			return getRuleContext(Cast_expressionContext.class,0);
		}
		public Ptr_operatorContext ptr_operator(int i) {
			return getRuleContext(Ptr_operatorContext.class,i);
		}
		public Unary_expressionContext unary_expression() {
			return getRuleContext(Unary_expressionContext.class,0);
		}
		public Type_nameContext type_name() {
			return getRuleContext(Type_nameContext.class,0);
		}
		public List<Ptr_operatorContext> ptr_operator() {
			return getRuleContexts(Ptr_operatorContext.class);
		}
		public Cast_expressionContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_cast_expression; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof CodeSensorListener ) ((CodeSensorListener)listener).enterCast_expression(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof CodeSensorListener ) ((CodeSensorListener)listener).exitCast_expression(this);
		}
	}

	public final Cast_expressionContext cast_expression() throws RecognitionException {
		Cast_expressionContext _localctx = new Cast_expressionContext(_ctx, getState());
		enterRule(_localctx, 30, RULE_cast_expression);
		int _la;
		try {
			setState(269);
			switch ( getInterpreter().adaptivePredict(_input,16,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				{
				setState(257); match(28);
				setState(258); type_name();
				setState(262);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (_la==1 || _la==2) {
					{
					{
					setState(259); ptr_operator();
					}
					}
					setState(264);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				setState(265); match(11);
				setState(266); cast_expression();
				}
				}
				break;

			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(268); unary_expression();
				}
				break;
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class Unary_expressionContext extends ParserRuleContext {
		public Postfix_expressionContext postfix_expression() {
			return getRuleContext(Postfix_expressionContext.class,0);
		}
		public List<Unary_operatorContext> unary_operator() {
			return getRuleContexts(Unary_operatorContext.class);
		}
		public Unary_operatorContext unary_operator(int i) {
			return getRuleContext(Unary_operatorContext.class,i);
		}
		public Unary_expressionContext unary_expression() {
			return getRuleContext(Unary_expressionContext.class,0);
		}
		public Unary_expressionContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_unary_expression; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof CodeSensorListener ) ((CodeSensorListener)listener).enterUnary_expression(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof CodeSensorListener ) ((CodeSensorListener)listener).exitUnary_expression(this);
		}
	}

	public final Unary_expressionContext unary_expression() throws RecognitionException {
		Unary_expressionContext _localctx = new Unary_expressionContext(_ctx, getState());
		enterRule(_localctx, 32, RULE_unary_expression);
		int _la;
		try {
			setState(282);
			switch (_input.LA(1)) {
			case 4:
				enterOuterAlt(_localctx, 1);
				{
				setState(271); match(4);
				setState(272); unary_expression();
				}
				break;
			case 38:
				enterOuterAlt(_localctx, 2);
				{
				setState(273); match(38);
				setState(274); unary_expression();
				}
				break;
			case 1:
			case 2:
			case 19:
			case 26:
			case 28:
			case 43:
			case 52:
			case ALPHA_NUMERIC:
			case HEX_LITERAL:
			case DECIMAL_LITERAL:
			case OCTAL_LITERAL:
			case FLOATING_POINT_LITERAL:
			case CHAR:
			case STRING:
				enterOuterAlt(_localctx, 3);
				{
				setState(278);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << 1) | (1L << 2) | (1L << 19) | (1L << 26) | (1L << 43) | (1L << 52))) != 0)) {
					{
					{
					setState(275); unary_operator();
					}
					}
					setState(280);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				setState(281); postfix_expression();
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class Postfix_expressionContext extends ParserRuleContext {
		public Postfix_expressionContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_postfix_expression; }
	 
		public Postfix_expressionContext() { }
		public void copyFrom(Postfix_expressionContext ctx) {
			super.copyFrom(ctx);
		}
	}
	public static class FieldOnlyContext extends Postfix_expressionContext {
		public FieldContext field() {
			return getRuleContext(FieldContext.class,0);
		}
		public FieldOnlyContext(Postfix_expressionContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof CodeSensorListener ) ((CodeSensorListener)listener).enterFieldOnly(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof CodeSensorListener ) ((CodeSensorListener)listener).exitFieldOnly(this);
		}
	}
	public static class FuncCallContext extends Postfix_expressionContext {
		public FieldContext field() {
			return getRuleContext(FieldContext.class,0);
		}
		public Function_call_tailContext function_call_tail() {
			return getRuleContext(Function_call_tailContext.class,0);
		}
		public FuncCallContext(Postfix_expressionContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof CodeSensorListener ) ((CodeSensorListener)listener).enterFuncCall(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof CodeSensorListener ) ((CodeSensorListener)listener).exitFuncCall(this);
		}
	}

	public final Postfix_expressionContext postfix_expression() throws RecognitionException {
		Postfix_expressionContext _localctx = new Postfix_expressionContext(_ctx, getState());
		enterRule(_localctx, 34, RULE_postfix_expression);
		try {
			setState(288);
			switch ( getInterpreter().adaptivePredict(_input,19,_ctx) ) {
			case 1:
				_localctx = new FuncCallContext(_localctx);
				enterOuterAlt(_localctx, 1);
				{
				setState(284); field();
				setState(285); function_call_tail();
				}
				break;

			case 2:
				_localctx = new FieldOnlyContext(_localctx);
				enterOuterAlt(_localctx, 2);
				{
				setState(287); field();
				}
				break;
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class FieldContext extends ParserRuleContext {
		public PostfixContext postfix(int i) {
			return getRuleContext(PostfixContext.class,i);
		}
		public List<PostfixContext> postfix() {
			return getRuleContexts(PostfixContext.class);
		}
		public Primary_expressionContext primary_expression() {
			return getRuleContext(Primary_expressionContext.class,0);
		}
		public FieldContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_field; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof CodeSensorListener ) ((CodeSensorListener)listener).enterField(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof CodeSensorListener ) ((CodeSensorListener)listener).exitField(this);
		}
	}

	public final FieldContext field() throws RecognitionException {
		FieldContext _localctx = new FieldContext(_ctx, getState());
		enterRule(_localctx, 36, RULE_field);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(290); primary_expression();
			setState(294);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << 3) | (1L << 4) | (1L << 9) | (1L << 38) | (1L << 42))) != 0)) {
				{
				{
				setState(291); postfix();
				}
				}
				setState(296);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class Function_call_tailContext extends ParserRuleContext {
		public Call_template_listContext call_template_list() {
			return getRuleContext(Call_template_listContext.class,0);
		}
		public Function_argument_listContext function_argument_list() {
			return getRuleContext(Function_argument_listContext.class,0);
		}
		public Function_call_tailContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_function_call_tail; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof CodeSensorListener ) ((CodeSensorListener)listener).enterFunction_call_tail(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof CodeSensorListener ) ((CodeSensorListener)listener).exitFunction_call_tail(this);
		}
	}

	public final Function_call_tailContext function_call_tail() throws RecognitionException {
		Function_call_tailContext _localctx = new Function_call_tailContext(_ctx, getState());
		enterRule(_localctx, 38, RULE_function_call_tail);
		try {
			setState(301);
			switch (_input.LA(1)) {
			case SMALLER:
				enterOuterAlt(_localctx, 1);
				{
				setState(297); call_template_list();
				setState(298); function_argument_list();
				}
				break;
			case 28:
				enterOuterAlt(_localctx, 2);
				{
				setState(300); function_argument_list();
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class Call_template_listContext extends ParserRuleContext {
		public Template_param_listContext template_param_list() {
			return getRuleContext(Template_param_listContext.class,0);
		}
		public Call_template_listContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_call_template_list; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof CodeSensorListener ) ((CodeSensorListener)listener).enterCall_template_list(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof CodeSensorListener ) ((CodeSensorListener)listener).exitCall_template_list(this);
		}
	}

	public final Call_template_listContext call_template_list() throws RecognitionException {
		Call_template_listContext _localctx = new Call_template_listContext(_ctx, getState());
		enterRule(_localctx, 40, RULE_call_template_list);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(303); template_param_list();
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class Function_argument_listContext extends ParserRuleContext {
		public Function_argumentContext function_argument(int i) {
			return getRuleContext(Function_argumentContext.class,i);
		}
		public List<Function_argumentContext> function_argument() {
			return getRuleContexts(Function_argumentContext.class);
		}
		public Function_argument_listContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_function_argument_list; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof CodeSensorListener ) ((CodeSensorListener)listener).enterFunction_argument_list(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof CodeSensorListener ) ((CodeSensorListener)listener).exitFunction_argument_list(this);
		}
	}

	public final Function_argument_listContext function_argument_list() throws RecognitionException {
		Function_argument_listContext _localctx = new Function_argument_listContext(_ctx, getState());
		enterRule(_localctx, 42, RULE_function_argument_list);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(305); match(28);
			setState(314);
			_la = _input.LA(1);
			if ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << 1) | (1L << 2) | (1L << 4) | (1L << 19) | (1L << 26) | (1L << 28) | (1L << 38) | (1L << 43) | (1L << 52))) != 0) || ((((_la - 82)) & ~0x3f) == 0 && ((1L << (_la - 82)) & ((1L << (ALPHA_NUMERIC - 82)) | (1L << (HEX_LITERAL - 82)) | (1L << (DECIMAL_LITERAL - 82)) | (1L << (OCTAL_LITERAL - 82)) | (1L << (FLOATING_POINT_LITERAL - 82)) | (1L << (CHAR - 82)) | (1L << (STRING - 82)))) != 0)) {
				{
				setState(306); function_argument();
				setState(311);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (_la==25) {
					{
					{
					setState(307); match(25);
					setState(308); function_argument();
					}
					}
					setState(313);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				}
			}

			setState(316); match(11);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class Function_argumentContext extends ParserRuleContext {
		public Assign_exprContext assign_expr() {
			return getRuleContext(Assign_exprContext.class,0);
		}
		public Function_argumentContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_function_argument; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof CodeSensorListener ) ((CodeSensorListener)listener).enterFunction_argument(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof CodeSensorListener ) ((CodeSensorListener)listener).exitFunction_argument(this);
		}
	}

	public final Function_argumentContext function_argument() throws RecognitionException {
		Function_argumentContext _localctx = new Function_argumentContext(_ctx, getState());
		enterRule(_localctx, 44, RULE_function_argument);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(318); assign_expr();
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class PostfixContext extends ParserRuleContext {
		public ExprContext expr() {
			return getRuleContext(ExprContext.class,0);
		}
		public IdentifierContext identifier() {
			return getRuleContext(IdentifierContext.class,0);
		}
		public PostfixContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_postfix; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof CodeSensorListener ) ((CodeSensorListener)listener).enterPostfix(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof CodeSensorListener ) ((CodeSensorListener)listener).exitPostfix(this);
		}
	}

	public final PostfixContext postfix() throws RecognitionException {
		PostfixContext _localctx = new PostfixContext(_ctx, getState());
		enterRule(_localctx, 46, RULE_postfix);
		try {
			setState(332);
			switch (_input.LA(1)) {
			case 3:
			case 9:
			case 42:
				enterOuterAlt(_localctx, 1);
				{
				setState(328);
				switch (_input.LA(1)) {
				case 42:
					{
					setState(320); match(42);
					setState(321); identifier();
					}
					break;
				case 9:
					{
					setState(322); match(9);
					setState(323); identifier();
					}
					break;
				case 3:
					{
					setState(324); match(3);
					setState(325); expr();
					setState(326); match(20);
					}
					break;
				default:
					throw new NoViableAltException(this);
				}
				}
				break;
			case 38:
				enterOuterAlt(_localctx, 2);
				{
				setState(330); match(38);
				}
				break;
			case 4:
				enterOuterAlt(_localctx, 3);
				{
				setState(331); match(4);
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class Primary_expressionContext extends ParserRuleContext {
		public ConstantContext constant() {
			return getRuleContext(ConstantContext.class,0);
		}
		public ExprContext expr() {
			return getRuleContext(ExprContext.class,0);
		}
		public IdentifierContext identifier() {
			return getRuleContext(IdentifierContext.class,0);
		}
		public Primary_expressionContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_primary_expression; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof CodeSensorListener ) ((CodeSensorListener)listener).enterPrimary_expression(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof CodeSensorListener ) ((CodeSensorListener)listener).exitPrimary_expression(this);
		}
	}

	public final Primary_expressionContext primary_expression() throws RecognitionException {
		Primary_expressionContext _localctx = new Primary_expressionContext(_ctx, getState());
		enterRule(_localctx, 48, RULE_primary_expression);
		try {
			setState(340);
			switch (_input.LA(1)) {
			case ALPHA_NUMERIC:
				enterOuterAlt(_localctx, 1);
				{
				setState(334); identifier();
				}
				break;
			case HEX_LITERAL:
			case DECIMAL_LITERAL:
			case OCTAL_LITERAL:
			case FLOATING_POINT_LITERAL:
			case CHAR:
			case STRING:
				enterOuterAlt(_localctx, 2);
				{
				setState(335); constant();
				}
				break;
			case 28:
				enterOuterAlt(_localctx, 3);
				{
				setState(336); match(28);
				setState(337); expr();
				setState(338); match(11);
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class Unary_operatorContext extends ParserRuleContext {
		public Unary_operatorContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_unary_operator; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof CodeSensorListener ) ((CodeSensorListener)listener).enterUnary_operator(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof CodeSensorListener ) ((CodeSensorListener)listener).exitUnary_operator(this);
		}
	}

	public final Unary_operatorContext unary_operator() throws RecognitionException {
		Unary_operatorContext _localctx = new Unary_operatorContext(_ctx, getState());
		enterRule(_localctx, 50, RULE_unary_operator);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(342);
			_la = _input.LA(1);
			if ( !((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << 1) | (1L << 2) | (1L << 19) | (1L << 26) | (1L << 43) | (1L << 52))) != 0)) ) {
			_errHandler.recoverInline(this);
			}
			consume();
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class Relational_operatorContext extends ParserRuleContext {
		public Relational_operatorContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_relational_operator; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof CodeSensorListener ) ((CodeSensorListener)listener).enterRelational_operator(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof CodeSensorListener ) ((CodeSensorListener)listener).exitRelational_operator(this);
		}
	}

	public final Relational_operatorContext relational_operator() throws RecognitionException {
		Relational_operatorContext _localctx = new Relational_operatorContext(_ctx, getState());
		enterRule(_localctx, 52, RULE_relational_operator);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(344);
			_la = _input.LA(1);
			if ( !(_la==6 || _la==53 || _la==SMALLER || _la==LARGER) ) {
			_errHandler.recoverInline(this);
			}
			consume();
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class ConstantContext extends ParserRuleContext {
		public TerminalNode CHAR() { return getToken(CodeSensorParser.CHAR, 0); }
		public TerminalNode OCTAL_LITERAL() { return getToken(CodeSensorParser.OCTAL_LITERAL, 0); }
		public TerminalNode HEX_LITERAL() { return getToken(CodeSensorParser.HEX_LITERAL, 0); }
		public TerminalNode FLOATING_POINT_LITERAL() { return getToken(CodeSensorParser.FLOATING_POINT_LITERAL, 0); }
		public TerminalNode DECIMAL_LITERAL() { return getToken(CodeSensorParser.DECIMAL_LITERAL, 0); }
		public TerminalNode STRING() { return getToken(CodeSensorParser.STRING, 0); }
		public ConstantContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_constant; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof CodeSensorListener ) ((CodeSensorListener)listener).enterConstant(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof CodeSensorListener ) ((CodeSensorListener)listener).exitConstant(this);
		}
	}

	public final ConstantContext constant() throws RecognitionException {
		ConstantContext _localctx = new ConstantContext(_ctx, getState());
		enterRule(_localctx, 54, RULE_constant);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(346);
			_la = _input.LA(1);
			if ( !(((((_la - 90)) & ~0x3f) == 0 && ((1L << (_la - 90)) & ((1L << (HEX_LITERAL - 90)) | (1L << (DECIMAL_LITERAL - 90)) | (1L << (OCTAL_LITERAL - 90)) | (1L << (FLOATING_POINT_LITERAL - 90)) | (1L << (CHAR - 90)) | (1L << (STRING - 90)))) != 0)) ) {
			_errHandler.recoverInline(this);
			}
			consume();
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class Function_decl_specifiersContext extends ParserRuleContext {
		public Function_decl_specifiersContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_function_decl_specifiers; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof CodeSensorListener ) ((CodeSensorListener)listener).enterFunction_decl_specifiers(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof CodeSensorListener ) ((CodeSensorListener)listener).exitFunction_decl_specifiers(this);
		}
	}

	public final Function_decl_specifiersContext function_decl_specifiers() throws RecognitionException {
		Function_decl_specifiersContext _localctx = new Function_decl_specifiersContext(_ctx, getState());
		enterRule(_localctx, 56, RULE_function_decl_specifiers);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(348);
			_la = _input.LA(1);
			if ( !(((((_la - 12)) & ~0x3f) == 0 && ((1L << (_la - 12)) & ((1L << (12 - 12)) | (1L << (13 - 12)) | (1L << (36 - 12)) | (1L << (37 - 12)) | (1L << (VIRTUAL - 12)))) != 0)) ) {
			_errHandler.recoverInline(this);
			}
			consume();
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class Ptr_operatorContext extends ParserRuleContext {
		public Ptr_operatorContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_ptr_operator; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof CodeSensorListener ) ((CodeSensorListener)listener).enterPtr_operator(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof CodeSensorListener ) ((CodeSensorListener)listener).exitPtr_operator(this);
		}
	}

	public final Ptr_operatorContext ptr_operator() throws RecognitionException {
		Ptr_operatorContext _localctx = new Ptr_operatorContext(_ctx, getState());
		enterRule(_localctx, 58, RULE_ptr_operator);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(350);
			_la = _input.LA(1);
			if ( !(_la==1 || _la==2) ) {
			_errHandler.recoverInline(this);
			}
			consume();
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class Access_specifierContext extends ParserRuleContext {
		public Access_specifierContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_access_specifier; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof CodeSensorListener ) ((CodeSensorListener)listener).enterAccess_specifier(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof CodeSensorListener ) ((CodeSensorListener)listener).exitAccess_specifier(this);
		}
	}

	public final Access_specifierContext access_specifier() throws RecognitionException {
		Access_specifierContext _localctx = new Access_specifierContext(_ctx, getState());
		enterRule(_localctx, 60, RULE_access_specifier);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(352);
			_la = _input.LA(1);
			if ( !((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << 24) | (1L << 30) | (1L << 44))) != 0)) ) {
			_errHandler.recoverInline(this);
			}
			consume();
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class Operator_function_idContext extends ParserRuleContext {
		public TerminalNode OPERATOR() { return getToken(CodeSensorParser.OPERATOR, 0); }
		public OperatorContext operator() {
			return getRuleContext(OperatorContext.class,0);
		}
		public Operator_function_idContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_operator_function_id; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof CodeSensorListener ) ((CodeSensorListener)listener).enterOperator_function_id(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof CodeSensorListener ) ((CodeSensorListener)listener).exitOperator_function_id(this);
		}
	}

	public final Operator_function_idContext operator_function_id() throws RecognitionException {
		Operator_function_idContext _localctx = new Operator_function_idContext(_ctx, getState());
		enterRule(_localctx, 62, RULE_operator_function_id);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(354); match(OPERATOR);
			setState(355); operator();
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class OperatorContext extends ParserRuleContext {
		public OperatorContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_operator; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof CodeSensorListener ) ((CodeSensorListener)listener).enterOperator(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof CodeSensorListener ) ((CodeSensorListener)listener).exitOperator(this);
		}
	}

	public final OperatorContext operator() throws RecognitionException {
		OperatorContext _localctx = new OperatorContext(_ctx, getState());
		enterRule(_localctx, 64, RULE_operator);
		int _la;
		try {
			setState(402);
			switch (_input.LA(1)) {
			case 17:
			case 40:
				enterOuterAlt(_localctx, 1);
				{
				{
				setState(357);
				_la = _input.LA(1);
				if ( !(_la==17 || _la==40) ) {
				_errHandler.recoverInline(this);
				}
				consume();
				setState(360);
				_la = _input.LA(1);
				if (_la==3) {
					{
					setState(358); match(3);
					setState(359); match(20);
					}
				}

				}
				}
				break;
			case 43:
				enterOuterAlt(_localctx, 2);
				{
				setState(362); match(43);
				}
				break;
			case 26:
				enterOuterAlt(_localctx, 3);
				{
				setState(363); match(26);
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 4);
				{
				setState(364); match(2);
				}
				break;
			case 50:
				enterOuterAlt(_localctx, 5);
				{
				setState(365); match(50);
				}
				break;
			case 8:
				enterOuterAlt(_localctx, 6);
				{
				setState(366); match(8);
				}
				break;
			case 41:
				enterOuterAlt(_localctx, 7);
				{
				setState(367); match(41);
				}
				break;
			case 1:
				enterOuterAlt(_localctx, 8);
				{
				setState(368); match(1);
				}
				break;
			case 18:
				enterOuterAlt(_localctx, 9);
				{
				setState(369); match(18);
				}
				break;
			case 52:
				enterOuterAlt(_localctx, 10);
				{
				setState(370); match(52);
				}
				break;
			case 19:
				enterOuterAlt(_localctx, 11);
				{
				setState(371); match(19);
				}
				break;
			case 15:
				enterOuterAlt(_localctx, 12);
				{
				setState(372); match(15);
				}
				break;
			case SMALLER:
				enterOuterAlt(_localctx, 13);
				{
				setState(373); match(SMALLER);
				}
				break;
			case LARGER:
				enterOuterAlt(_localctx, 14);
				{
				setState(374); match(LARGER);
				}
				break;
			case 34:
				enterOuterAlt(_localctx, 15);
				{
				setState(375); match(34);
				}
				break;
			case 22:
				enterOuterAlt(_localctx, 16);
				{
				setState(376); match(22);
				}
				break;
			case 10:
				enterOuterAlt(_localctx, 17);
				{
				setState(377); match(10);
				}
				break;
			case 49:
				enterOuterAlt(_localctx, 18);
				{
				setState(378); match(49);
				}
				break;
			case 48:
				enterOuterAlt(_localctx, 19);
				{
				setState(379); match(48);
				}
				break;
			case 35:
				enterOuterAlt(_localctx, 20);
				{
				setState(380); match(35);
				}
				break;
			case 29:
				enterOuterAlt(_localctx, 21);
				{
				setState(381); match(29);
				}
				break;
			case 16:
				enterOuterAlt(_localctx, 22);
				{
				setState(382); match(16);
				}
				break;
			case 39:
				enterOuterAlt(_localctx, 23);
				{
				setState(383); match(39);
				}
				break;
			case 7:
				enterOuterAlt(_localctx, 24);
				{
				setState(384); match(7);
				}
				break;
			case 32:
				enterOuterAlt(_localctx, 25);
				{
				setState(385); match(32);
				}
				break;
			case 21:
				enterOuterAlt(_localctx, 26);
				{
				setState(386); match(21);
				}
				break;
			case 51:
				enterOuterAlt(_localctx, 27);
				{
				setState(387); match(51);
				}
				break;
			case 5:
				enterOuterAlt(_localctx, 28);
				{
				setState(388); match(5);
				}
				break;
			case 6:
				enterOuterAlt(_localctx, 29);
				{
				setState(389); match(6);
				}
				break;
			case 53:
				enterOuterAlt(_localctx, 30);
				{
				setState(390); match(53);
				}
				break;
			case 46:
				enterOuterAlt(_localctx, 31);
				{
				setState(391); match(46);
				}
				break;
			case 47:
				enterOuterAlt(_localctx, 32);
				{
				setState(392); match(47);
				}
				break;
			case 38:
				enterOuterAlt(_localctx, 33);
				{
				setState(393); match(38);
				}
				break;
			case 4:
				enterOuterAlt(_localctx, 34);
				{
				setState(394); match(4);
				}
				break;
			case 25:
				enterOuterAlt(_localctx, 35);
				{
				setState(395); match(25);
				}
				break;
			case 23:
				enterOuterAlt(_localctx, 36);
				{
				setState(396); match(23);
				}
				break;
			case 9:
				enterOuterAlt(_localctx, 37);
				{
				setState(397); match(9);
				}
				break;
			case 28:
				enterOuterAlt(_localctx, 38);
				{
				setState(398); match(28);
				setState(399); match(11);
				}
				break;
			case 3:
				enterOuterAlt(_localctx, 39);
				{
				setState(400); match(3);
				setState(401); match(20);
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class Assignment_operatorContext extends ParserRuleContext {
		public Assignment_operatorContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_assignment_operator; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof CodeSensorListener ) ((CodeSensorListener)listener).enterAssignment_operator(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof CodeSensorListener ) ((CodeSensorListener)listener).exitAssignment_operator(this);
		}
	}

	public final Assignment_operatorContext assignment_operator() throws RecognitionException {
		Assignment_operatorContext _localctx = new Assignment_operatorContext(_ctx, getState());
		enterRule(_localctx, 66, RULE_assignment_operator);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(404);
			_la = _input.LA(1);
			if ( !((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << 10) | (1L << 15) | (1L << 16) | (1L << 21) | (1L << 22) | (1L << 29) | (1L << 32) | (1L << 34) | (1L << 35) | (1L << 48) | (1L << 49))) != 0)) ) {
			_errHandler.recoverInline(this);
			}
			consume();
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class Equality_operatorContext extends ParserRuleContext {
		public Equality_operatorContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_equality_operator; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof CodeSensorListener ) ((CodeSensorListener)listener).enterEquality_operator(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof CodeSensorListener ) ((CodeSensorListener)listener).exitEquality_operator(this);
		}
	}

	public final Equality_operatorContext equality_operator() throws RecognitionException {
		Equality_operatorContext _localctx = new Equality_operatorContext(_ctx, getState());
		enterRule(_localctx, 68, RULE_equality_operator);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(406);
			_la = _input.LA(1);
			if ( !(_la==5 || _la==51) ) {
			_errHandler.recoverInline(this);
			}
			consume();
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class Template_decl_startContext extends ParserRuleContext {
		public Template_param_listContext template_param_list() {
			return getRuleContext(Template_param_listContext.class,0);
		}
		public TerminalNode TEMPLATE() { return getToken(CodeSensorParser.TEMPLATE, 0); }
		public Template_decl_startContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_template_decl_start; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof CodeSensorListener ) ((CodeSensorListener)listener).enterTemplate_decl_start(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof CodeSensorListener ) ((CodeSensorListener)listener).exitTemplate_decl_start(this);
		}
	}

	public final Template_decl_startContext template_decl_start() throws RecognitionException {
		Template_decl_startContext _localctx = new Template_decl_startContext(_ctx, getState());
		enterRule(_localctx, 70, RULE_template_decl_start);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(408); match(TEMPLATE);
			setState(409); template_param_list();
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class Template_param_listContext extends ParserRuleContext {
		public Template_param_listContext template_param_list(int i) {
			return getRuleContext(Template_param_listContext.class,i);
		}
		public No_angle_brackets_or_bracketsContext no_angle_brackets_or_brackets(int i) {
			return getRuleContext(No_angle_brackets_or_bracketsContext.class,i);
		}
		public List<No_angle_brackets_or_bracketsContext> no_angle_brackets_or_brackets() {
			return getRuleContexts(No_angle_brackets_or_bracketsContext.class);
		}
		public List<Template_param_listContext> template_param_list() {
			return getRuleContexts(Template_param_listContext.class);
		}
		public Template_param_listContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_template_param_list; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof CodeSensorListener ) ((CodeSensorListener)listener).enterTemplate_param_list(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof CodeSensorListener ) ((CodeSensorListener)listener).exitTemplate_param_list(this);
		}
	}

	public final Template_param_listContext template_param_list() throws RecognitionException {
		Template_param_listContext _localctx = new Template_param_listContext(_ctx, getState());
		enterRule(_localctx, 72, RULE_template_param_list);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(411); match(SMALLER);
			setState(423);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << 1) | (1L << 2) | (1L << 3) | (1L << 4) | (1L << 5) | (1L << 6) | (1L << 7) | (1L << 8) | (1L << 9) | (1L << 10) | (1L << 12) | (1L << 13) | (1L << 14) | (1L << 15) | (1L << 16) | (1L << 17) | (1L << 18) | (1L << 19) | (1L << 20) | (1L << 21) | (1L << 22) | (1L << 23) | (1L << 24) | (1L << 25) | (1L << 26) | (1L << 27) | (1L << 28) | (1L << 29) | (1L << 30) | (1L << 31) | (1L << 32) | (1L << 33) | (1L << 34) | (1L << 35) | (1L << 36) | (1L << 37) | (1L << 38) | (1L << 39) | (1L << 40) | (1L << 41) | (1L << 42) | (1L << 43) | (1L << 44) | (1L << 45) | (1L << 46) | (1L << 47) | (1L << 48) | (1L << 49) | (1L << 50) | (1L << 51) | (1L << 52) | (1L << 53) | (1L << IF) | (1L << ELSE) | (1L << FOR) | (1L << WHILE) | (1L << BREAK) | (1L << CASE) | (1L << CONTINUE) | (1L << SWITCH) | (1L << DO) | (1L << GOTO))) != 0) || ((((_la - 64)) & ~0x3f) == 0 && ((1L << (_la - 64)) & ((1L << (RETURN - 64)) | (1L << (TYPEDEF - 64)) | (1L << (VOID - 64)) | (1L << (UNSIGNED - 64)) | (1L << (SIGNED - 64)) | (1L << (LONG - 64)) | (1L << (CV_QUALIFIER - 64)) | (1L << (VIRTUAL - 64)) | (1L << (TRY - 64)) | (1L << (CATCH - 64)) | (1L << (THROW - 64)) | (1L << (USING - 64)) | (1L << (NAMESPACE - 64)) | (1L << (AUTO - 64)) | (1L << (REGISTER - 64)) | (1L << (OPERATOR - 64)) | (1L << (TEMPLATE - 64)) | (1L << (CLASS_KEY - 64)) | (1L << (ALPHA_NUMERIC - 64)) | (1L << (OPENING_CURLY - 64)) | (1L << (CLOSING_CURLY - 64)) | (1L << (SMALLER - 64)) | (1L << (PRE_IF - 64)) | (1L << (PRE_ELSE - 64)) | (1L << (PRE_ENDIF - 64)) | (1L << (HEX_LITERAL - 64)) | (1L << (DECIMAL_LITERAL - 64)) | (1L << (OCTAL_LITERAL - 64)) | (1L << (FLOATING_POINT_LITERAL - 64)) | (1L << (CHAR - 64)) | (1L << (STRING - 64)) | (1L << (COMMENT - 64)) | (1L << (WHITESPACE - 64)) | (1L << (CPPCOMMENT - 64)) | (1L << (OTHER - 64)))) != 0)) {
				{
				setState(421);
				switch (_input.LA(1)) {
				case SMALLER:
					{
					{
					setState(412); match(SMALLER);
					setState(413); template_param_list();
					setState(414); match(LARGER);
					}
					}
					break;
				case 28:
					{
					{
					setState(416); match(28);
					setState(417); template_param_list();
					setState(418); match(11);
					}
					}
					break;
				case 1:
				case 2:
				case 3:
				case 4:
				case 5:
				case 6:
				case 7:
				case 8:
				case 9:
				case 10:
				case 12:
				case 13:
				case 14:
				case 15:
				case 16:
				case 17:
				case 18:
				case 19:
				case 20:
				case 21:
				case 22:
				case 23:
				case 24:
				case 25:
				case 26:
				case 27:
				case 29:
				case 30:
				case 31:
				case 32:
				case 33:
				case 34:
				case 35:
				case 36:
				case 37:
				case 38:
				case 39:
				case 40:
				case 41:
				case 42:
				case 43:
				case 44:
				case 45:
				case 46:
				case 47:
				case 48:
				case 49:
				case 50:
				case 51:
				case 52:
				case 53:
				case IF:
				case ELSE:
				case FOR:
				case WHILE:
				case BREAK:
				case CASE:
				case CONTINUE:
				case SWITCH:
				case DO:
				case GOTO:
				case RETURN:
				case TYPEDEF:
				case VOID:
				case UNSIGNED:
				case SIGNED:
				case LONG:
				case CV_QUALIFIER:
				case VIRTUAL:
				case TRY:
				case CATCH:
				case THROW:
				case USING:
				case NAMESPACE:
				case AUTO:
				case REGISTER:
				case OPERATOR:
				case TEMPLATE:
				case CLASS_KEY:
				case ALPHA_NUMERIC:
				case OPENING_CURLY:
				case CLOSING_CURLY:
				case PRE_IF:
				case PRE_ELSE:
				case PRE_ENDIF:
				case HEX_LITERAL:
				case DECIMAL_LITERAL:
				case OCTAL_LITERAL:
				case FLOATING_POINT_LITERAL:
				case CHAR:
				case STRING:
				case COMMENT:
				case WHITESPACE:
				case CPPCOMMENT:
				case OTHER:
					{
					setState(420); no_angle_brackets_or_brackets();
					}
					break;
				default:
					throw new NoViableAltException(this);
				}
				}
				setState(425);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(426); match(LARGER);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class No_bracketsContext extends ParserRuleContext {
		public No_bracketsContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_no_brackets; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof CodeSensorListener ) ((CodeSensorListener)listener).enterNo_brackets(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof CodeSensorListener ) ((CodeSensorListener)listener).exitNo_brackets(this);
		}
	}

	public final No_bracketsContext no_brackets() throws RecognitionException {
		No_bracketsContext _localctx = new No_bracketsContext(_ctx, getState());
		enterRule(_localctx, 74, RULE_no_brackets);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(428);
			_la = _input.LA(1);
			if ( _la <= 0 || (_la==11 || _la==28) ) {
			_errHandler.recoverInline(this);
			}
			consume();
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class No_brackets_curlies_or_squaresContext extends ParserRuleContext {
		public No_brackets_curlies_or_squaresContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_no_brackets_curlies_or_squares; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof CodeSensorListener ) ((CodeSensorListener)listener).enterNo_brackets_curlies_or_squares(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof CodeSensorListener ) ((CodeSensorListener)listener).exitNo_brackets_curlies_or_squares(this);
		}
	}

	public final No_brackets_curlies_or_squaresContext no_brackets_curlies_or_squares() throws RecognitionException {
		No_brackets_curlies_or_squaresContext _localctx = new No_brackets_curlies_or_squaresContext(_ctx, getState());
		enterRule(_localctx, 76, RULE_no_brackets_curlies_or_squares);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(430);
			_la = _input.LA(1);
			if ( _la <= 0 || ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << 3) | (1L << 11) | (1L << 20) | (1L << 28))) != 0) || _la==OPENING_CURLY || _la==CLOSING_CURLY) ) {
			_errHandler.recoverInline(this);
			}
			consume();
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class No_brackets_or_semicolonContext extends ParserRuleContext {
		public No_brackets_or_semicolonContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_no_brackets_or_semicolon; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof CodeSensorListener ) ((CodeSensorListener)listener).enterNo_brackets_or_semicolon(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof CodeSensorListener ) ((CodeSensorListener)listener).exitNo_brackets_or_semicolon(this);
		}
	}

	public final No_brackets_or_semicolonContext no_brackets_or_semicolon() throws RecognitionException {
		No_brackets_or_semicolonContext _localctx = new No_brackets_or_semicolonContext(_ctx, getState());
		enterRule(_localctx, 78, RULE_no_brackets_or_semicolon);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(432);
			_la = _input.LA(1);
			if ( _la <= 0 || ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << 11) | (1L << 28) | (1L << 45))) != 0)) ) {
			_errHandler.recoverInline(this);
			}
			consume();
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class No_angle_brackets_or_bracketsContext extends ParserRuleContext {
		public No_angle_brackets_or_bracketsContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_no_angle_brackets_or_brackets; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof CodeSensorListener ) ((CodeSensorListener)listener).enterNo_angle_brackets_or_brackets(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof CodeSensorListener ) ((CodeSensorListener)listener).exitNo_angle_brackets_or_brackets(this);
		}
	}

	public final No_angle_brackets_or_bracketsContext no_angle_brackets_or_brackets() throws RecognitionException {
		No_angle_brackets_or_bracketsContext _localctx = new No_angle_brackets_or_bracketsContext(_ctx, getState());
		enterRule(_localctx, 80, RULE_no_angle_brackets_or_brackets);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(434);
			_la = _input.LA(1);
			if ( _la <= 0 || (_la==11 || _la==28 || _la==SMALLER || _la==LARGER) ) {
			_errHandler.recoverInline(this);
			}
			consume();
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class No_curliesContext extends ParserRuleContext {
		public No_curliesContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_no_curlies; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof CodeSensorListener ) ((CodeSensorListener)listener).enterNo_curlies(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof CodeSensorListener ) ((CodeSensorListener)listener).exitNo_curlies(this);
		}
	}

	public final No_curliesContext no_curlies() throws RecognitionException {
		No_curliesContext _localctx = new No_curliesContext(_ctx, getState());
		enterRule(_localctx, 82, RULE_no_curlies);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(436);
			_la = _input.LA(1);
			if ( _la <= 0 || (_la==OPENING_CURLY || _la==CLOSING_CURLY) ) {
			_errHandler.recoverInline(this);
			}
			consume();
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class No_squaresContext extends ParserRuleContext {
		public No_squaresContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_no_squares; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof CodeSensorListener ) ((CodeSensorListener)listener).enterNo_squares(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof CodeSensorListener ) ((CodeSensorListener)listener).exitNo_squares(this);
		}
	}

	public final No_squaresContext no_squares() throws RecognitionException {
		No_squaresContext _localctx = new No_squaresContext(_ctx, getState());
		enterRule(_localctx, 84, RULE_no_squares);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(438);
			_la = _input.LA(1);
			if ( _la <= 0 || (_la==3 || _la==20) ) {
			_errHandler.recoverInline(this);
			}
			consume();
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class No_squares_or_semicolonContext extends ParserRuleContext {
		public No_squares_or_semicolonContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_no_squares_or_semicolon; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof CodeSensorListener ) ((CodeSensorListener)listener).enterNo_squares_or_semicolon(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof CodeSensorListener ) ((CodeSensorListener)listener).exitNo_squares_or_semicolon(this);
		}
	}

	public final No_squares_or_semicolonContext no_squares_or_semicolon() throws RecognitionException {
		No_squares_or_semicolonContext _localctx = new No_squares_or_semicolonContext(_ctx, getState());
		enterRule(_localctx, 86, RULE_no_squares_or_semicolon);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(440);
			_la = _input.LA(1);
			if ( _la <= 0 || ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << 3) | (1L << 20) | (1L << 45))) != 0)) ) {
			_errHandler.recoverInline(this);
			}
			consume();
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class No_comma_or_semicolonContext extends ParserRuleContext {
		public No_comma_or_semicolonContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_no_comma_or_semicolon; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof CodeSensorListener ) ((CodeSensorListener)listener).enterNo_comma_or_semicolon(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof CodeSensorListener ) ((CodeSensorListener)listener).exitNo_comma_or_semicolon(this);
		}
	}

	public final No_comma_or_semicolonContext no_comma_or_semicolon() throws RecognitionException {
		No_comma_or_semicolonContext _localctx = new No_comma_or_semicolonContext(_ctx, getState());
		enterRule(_localctx, 88, RULE_no_comma_or_semicolon);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(442);
			_la = _input.LA(1);
			if ( _la <= 0 || (_la==25 || _la==45) ) {
			_errHandler.recoverInline(this);
			}
			consume();
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class Assign_waterContext extends ParserRuleContext {
		public Assign_waterContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_assign_water; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof CodeSensorListener ) ((CodeSensorListener)listener).enterAssign_water(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof CodeSensorListener ) ((CodeSensorListener)listener).exitAssign_water(this);
		}
	}

	public final Assign_waterContext assign_water() throws RecognitionException {
		Assign_waterContext _localctx = new Assign_waterContext(_ctx, getState());
		enterRule(_localctx, 90, RULE_assign_water);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(444);
			_la = _input.LA(1);
			if ( _la <= 0 || ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << 3) | (1L << 11) | (1L << 20) | (1L << 25) | (1L << 28) | (1L << 45))) != 0) || _la==OPENING_CURLY || _la==CLOSING_CURLY) ) {
			_errHandler.recoverInline(this);
			}
			consume();
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class Assign_water_l2Context extends ParserRuleContext {
		public Assign_water_l2Context(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_assign_water_l2; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof CodeSensorListener ) ((CodeSensorListener)listener).enterAssign_water_l2(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof CodeSensorListener ) ((CodeSensorListener)listener).exitAssign_water_l2(this);
		}
	}

	public final Assign_water_l2Context assign_water_l2() throws RecognitionException {
		Assign_water_l2Context _localctx = new Assign_water_l2Context(_ctx, getState());
		enterRule(_localctx, 92, RULE_assign_water_l2);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(446);
			_la = _input.LA(1);
			if ( _la <= 0 || ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << 3) | (1L << 11) | (1L << 20) | (1L << 28))) != 0) || _la==OPENING_CURLY || _la==CLOSING_CURLY) ) {
			_errHandler.recoverInline(this);
			}
			consume();
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class WaterContext extends ParserRuleContext {
		public WaterContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_water; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof CodeSensorListener ) ((CodeSensorListener)listener).enterWater(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof CodeSensorListener ) ((CodeSensorListener)listener).exitWater(this);
		}
	}

	public final WaterContext water() throws RecognitionException {
		WaterContext _localctx = new WaterContext(_ctx, getState());
		enterRule(_localctx, 94, RULE_water);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(448);
			matchWildcard();
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class Function_defContext extends ParserRuleContext {
		public Function_param_listContext function_param_list() {
			return getRuleContext(Function_param_listContext.class,0);
		}
		public Template_decl_startContext template_decl_start() {
			return getRuleContext(Template_decl_startContext.class,0);
		}
		public Function_nameContext function_name() {
			return getRuleContext(Function_nameContext.class,0);
		}
		public Return_typeContext return_type() {
			return getRuleContext(Return_typeContext.class,0);
		}
		public Ctor_listContext ctor_list() {
			return getRuleContext(Ctor_listContext.class,0);
		}
		public Compound_statementContext compound_statement() {
			return getRuleContext(Compound_statementContext.class,0);
		}
		public Function_defContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_function_def; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof CodeSensorListener ) ((CodeSensorListener)listener).enterFunction_def(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof CodeSensorListener ) ((CodeSensorListener)listener).exitFunction_def(this);
		}
	}

	public final Function_defContext function_def() throws RecognitionException {
		Function_defContext _localctx = new Function_defContext(_ctx, getState());
		enterRule(_localctx, 96, RULE_function_def);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(451);
			_la = _input.LA(1);
			if (_la==TEMPLATE) {
				{
				setState(450); template_decl_start();
				}
			}

			setState(454);
			switch ( getInterpreter().adaptivePredict(_input,32,_ctx) ) {
			case 1:
				{
				setState(453); return_type();
				}
				break;
			}
			setState(456); function_name();
			setState(457); function_param_list();
			setState(459);
			_la = _input.LA(1);
			if (_la==27) {
				{
				setState(458); ctor_list();
				}
			}

			setState(461); compound_statement();
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class Return_typeContext extends ParserRuleContext {
		public List<Function_decl_specifiersContext> function_decl_specifiers() {
			return getRuleContexts(Function_decl_specifiersContext.class);
		}
		public Ptr_operatorContext ptr_operator(int i) {
			return getRuleContext(Ptr_operatorContext.class,i);
		}
		public Type_nameContext type_name() {
			return getRuleContext(Type_nameContext.class,0);
		}
		public Function_decl_specifiersContext function_decl_specifiers(int i) {
			return getRuleContext(Function_decl_specifiersContext.class,i);
		}
		public List<Ptr_operatorContext> ptr_operator() {
			return getRuleContexts(Ptr_operatorContext.class);
		}
		public Return_typeContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_return_type; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof CodeSensorListener ) ((CodeSensorListener)listener).enterReturn_type(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof CodeSensorListener ) ((CodeSensorListener)listener).exitReturn_type(this);
		}
	}

	public final Return_typeContext return_type() throws RecognitionException {
		Return_typeContext _localctx = new Return_typeContext(_ctx, getState());
		enterRule(_localctx, 98, RULE_return_type);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			{
			setState(466);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (((((_la - 12)) & ~0x3f) == 0 && ((1L << (_la - 12)) & ((1L << (12 - 12)) | (1L << (13 - 12)) | (1L << (36 - 12)) | (1L << (37 - 12)) | (1L << (VIRTUAL - 12)))) != 0)) {
				{
				{
				setState(463); function_decl_specifiers();
				}
				}
				setState(468);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(469); type_name();
			}
			setState(474);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==1 || _la==2) {
				{
				{
				setState(471); ptr_operator();
				}
				}
				setState(476);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class Function_param_listContext extends ParserRuleContext {
		public List<TerminalNode> CV_QUALIFIER() { return getTokens(CodeSensorParser.CV_QUALIFIER); }
		public Exception_specificationContext exception_specification() {
			return getRuleContext(Exception_specificationContext.class,0);
		}
		public Parameter_decl_clauseContext parameter_decl_clause() {
			return getRuleContext(Parameter_decl_clauseContext.class,0);
		}
		public TerminalNode CV_QUALIFIER(int i) {
			return getToken(CodeSensorParser.CV_QUALIFIER, i);
		}
		public Function_param_listContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_function_param_list; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof CodeSensorListener ) ((CodeSensorListener)listener).enterFunction_param_list(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof CodeSensorListener ) ((CodeSensorListener)listener).exitFunction_param_list(this);
		}
	}

	public final Function_param_listContext function_param_list() throws RecognitionException {
		Function_param_listContext _localctx = new Function_param_listContext(_ctx, getState());
		enterRule(_localctx, 100, RULE_function_param_list);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(477); match(28);
			setState(479);
			_la = _input.LA(1);
			if (((((_la - 66)) & ~0x3f) == 0 && ((1L << (_la - 66)) & ((1L << (VOID - 66)) | (1L << (UNSIGNED - 66)) | (1L << (SIGNED - 66)) | (1L << (LONG - 66)) | (1L << (CV_QUALIFIER - 66)) | (1L << (AUTO - 66)) | (1L << (REGISTER - 66)) | (1L << (CLASS_KEY - 66)) | (1L << (ALPHA_NUMERIC - 66)))) != 0)) {
				{
				setState(478); parameter_decl_clause();
				}
			}

			setState(481); match(11);
			setState(485);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==CV_QUALIFIER) {
				{
				{
				setState(482); match(CV_QUALIFIER);
				}
				}
				setState(487);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(489);
			_la = _input.LA(1);
			if (_la==THROW) {
				{
				setState(488); exception_specification();
				}
			}

			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class Parameter_decl_clauseContext extends ParserRuleContext {
		public TerminalNode VOID() { return getToken(CodeSensorParser.VOID, 0); }
		public List<Parameter_declContext> parameter_decl() {
			return getRuleContexts(Parameter_declContext.class);
		}
		public Parameter_declContext parameter_decl(int i) {
			return getRuleContext(Parameter_declContext.class,i);
		}
		public Parameter_decl_clauseContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_parameter_decl_clause; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof CodeSensorListener ) ((CodeSensorListener)listener).enterParameter_decl_clause(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof CodeSensorListener ) ((CodeSensorListener)listener).exitParameter_decl_clause(this);
		}
	}

	public final Parameter_decl_clauseContext parameter_decl_clause() throws RecognitionException {
		Parameter_decl_clauseContext _localctx = new Parameter_decl_clauseContext(_ctx, getState());
		enterRule(_localctx, 102, RULE_parameter_decl_clause);
		int _la;
		try {
			int _alt;
			setState(504);
			switch ( getInterpreter().adaptivePredict(_input,41,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				{
				setState(491); parameter_decl();
				setState(496);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,39,_ctx);
				while ( _alt!=2 && _alt!=-1 ) {
					if ( _alt==1 ) {
						{
						{
						setState(492); match(25);
						setState(493); parameter_decl();
						}
						} 
					}
					setState(498);
					_errHandler.sync(this);
					_alt = getInterpreter().adaptivePredict(_input,39,_ctx);
				}
				}
				setState(501);
				_la = _input.LA(1);
				if (_la==25) {
					{
					setState(499); match(25);
					setState(500); match(33);
					}
				}

				}
				break;

			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(503); match(VOID);
				}
				break;
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class Parameter_declContext extends ParserRuleContext {
		public Param_decl_specifiersContext param_decl_specifiers() {
			return getRuleContext(Param_decl_specifiersContext.class,0);
		}
		public Parameter_idContext parameter_id() {
			return getRuleContext(Parameter_idContext.class,0);
		}
		public Parameter_declContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_parameter_decl; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof CodeSensorListener ) ((CodeSensorListener)listener).enterParameter_decl(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof CodeSensorListener ) ((CodeSensorListener)listener).exitParameter_decl(this);
		}
	}

	public final Parameter_declContext parameter_decl() throws RecognitionException {
		Parameter_declContext _localctx = new Parameter_declContext(_ctx, getState());
		enterRule(_localctx, 104, RULE_parameter_decl);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(506); param_decl_specifiers();
			setState(507); parameter_id();
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class Parameter_idContext extends ParserRuleContext {
		public Type_suffixContext type_suffix() {
			return getRuleContext(Type_suffixContext.class,0);
		}
		public Parameter_idContext parameter_id() {
			return getRuleContext(Parameter_idContext.class,0);
		}
		public Parameter_nameContext parameter_name() {
			return getRuleContext(Parameter_nameContext.class,0);
		}
		public PtrsContext ptrs() {
			return getRuleContext(PtrsContext.class,0);
		}
		public Parameter_idContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_parameter_id; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof CodeSensorListener ) ((CodeSensorListener)listener).enterParameter_id(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof CodeSensorListener ) ((CodeSensorListener)listener).exitParameter_id(this);
		}
	}

	public final Parameter_idContext parameter_id() throws RecognitionException {
		Parameter_idContext _localctx = new Parameter_idContext(_ctx, getState());
		enterRule(_localctx, 106, RULE_parameter_id);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(510);
			_la = _input.LA(1);
			if (_la==1 || _la==2) {
				{
				setState(509); ptrs();
				}
			}

			setState(517);
			switch (_input.LA(1)) {
			case 28:
				{
				setState(512); match(28);
				setState(513); parameter_id();
				setState(514); match(11);
				}
				break;
			case 24:
			case 30:
			case 44:
			case ALPHA_NUMERIC:
				{
				setState(516); parameter_name();
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
			setState(520);
			_la = _input.LA(1);
			if (_la==3 || _la==28) {
				{
				setState(519); type_suffix();
				}
			}

			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class Compound_statementContext extends ParserRuleContext {
		public TerminalNode OPENING_CURLY() { return getToken(CodeSensorParser.OPENING_CURLY, 0); }
		public Compound_statementContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_compound_statement; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof CodeSensorListener ) ((CodeSensorListener)listener).enterCompound_statement(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof CodeSensorListener ) ((CodeSensorListener)listener).exitCompound_statement(this);
		}
	}

	public final Compound_statementContext compound_statement() throws RecognitionException {
		Compound_statementContext _localctx = new Compound_statementContext(_ctx, getState());
		enterRule(_localctx, 108, RULE_compound_statement);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(522); match(OPENING_CURLY);
			 skipToEndOfObject(); 
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class Ctor_listContext extends ParserRuleContext {
		public Ctor_initializerContext ctor_initializer(int i) {
			return getRuleContext(Ctor_initializerContext.class,i);
		}
		public List<Ctor_initializerContext> ctor_initializer() {
			return getRuleContexts(Ctor_initializerContext.class);
		}
		public Ctor_listContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_ctor_list; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof CodeSensorListener ) ((CodeSensorListener)listener).enterCtor_list(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof CodeSensorListener ) ((CodeSensorListener)listener).exitCtor_list(this);
		}
	}

	public final Ctor_listContext ctor_list() throws RecognitionException {
		Ctor_listContext _localctx = new Ctor_listContext(_ctx, getState());
		enterRule(_localctx, 110, RULE_ctor_list);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(525); match(27);
			setState(526); ctor_initializer();
			setState(531);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==25) {
				{
				{
				setState(527); match(25);
				setState(528); ctor_initializer();
				}
				}
				setState(533);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class Ctor_initializerContext extends ParserRuleContext {
		public Initializer_idContext initializer_id() {
			return getRuleContext(Initializer_idContext.class,0);
		}
		public Ctor_exprContext ctor_expr() {
			return getRuleContext(Ctor_exprContext.class,0);
		}
		public Ctor_initializerContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_ctor_initializer; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof CodeSensorListener ) ((CodeSensorListener)listener).enterCtor_initializer(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof CodeSensorListener ) ((CodeSensorListener)listener).exitCtor_initializer(this);
		}
	}

	public final Ctor_initializerContext ctor_initializer() throws RecognitionException {
		Ctor_initializerContext _localctx = new Ctor_initializerContext(_ctx, getState());
		enterRule(_localctx, 112, RULE_ctor_initializer);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(534); initializer_id();
			setState(535); ctor_expr();
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class Initializer_idContext extends ParserRuleContext {
		public IdentifierContext identifier() {
			return getRuleContext(IdentifierContext.class,0);
		}
		public Initializer_idContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_initializer_id; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof CodeSensorListener ) ((CodeSensorListener)listener).enterInitializer_id(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof CodeSensorListener ) ((CodeSensorListener)listener).exitInitializer_id(this);
		}
	}

	public final Initializer_idContext initializer_id() throws RecognitionException {
		Initializer_idContext _localctx = new Initializer_idContext(_ctx, getState());
		enterRule(_localctx, 114, RULE_initializer_id);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(538);
			_la = _input.LA(1);
			if (_la==14) {
				{
				setState(537); match(14);
				}
			}

			setState(540); identifier();
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class Ctor_exprContext extends ParserRuleContext {
		public ExprContext expr() {
			return getRuleContext(ExprContext.class,0);
		}
		public Ctor_exprContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_ctor_expr; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof CodeSensorListener ) ((CodeSensorListener)listener).enterCtor_expr(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof CodeSensorListener ) ((CodeSensorListener)listener).exitCtor_expr(this);
		}
	}

	public final Ctor_exprContext ctor_expr() throws RecognitionException {
		Ctor_exprContext _localctx = new Ctor_exprContext(_ctx, getState());
		enterRule(_localctx, 116, RULE_ctor_expr);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(542); match(28);
			setState(544);
			_la = _input.LA(1);
			if ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << 1) | (1L << 2) | (1L << 4) | (1L << 19) | (1L << 26) | (1L << 28) | (1L << 38) | (1L << 43) | (1L << 52))) != 0) || ((((_la - 82)) & ~0x3f) == 0 && ((1L << (_la - 82)) & ((1L << (ALPHA_NUMERIC - 82)) | (1L << (HEX_LITERAL - 82)) | (1L << (DECIMAL_LITERAL - 82)) | (1L << (OCTAL_LITERAL - 82)) | (1L << (FLOATING_POINT_LITERAL - 82)) | (1L << (CHAR - 82)) | (1L << (STRING - 82)))) != 0)) {
				{
				setState(543); expr();
				}
			}

			setState(546); match(11);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class Function_nameContext extends ParserRuleContext {
		public Operator_function_idContext operator_function_id() {
			return getRuleContext(Operator_function_idContext.class,0);
		}
		public Function_nameContext function_name() {
			return getRuleContext(Function_nameContext.class,0);
		}
		public IdentifierContext identifier() {
			return getRuleContext(IdentifierContext.class,0);
		}
		public Function_nameContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_function_name; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof CodeSensorListener ) ((CodeSensorListener)listener).enterFunction_name(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof CodeSensorListener ) ((CodeSensorListener)listener).exitFunction_name(this);
		}
	}

	public final Function_nameContext function_name() throws RecognitionException {
		Function_nameContext _localctx = new Function_nameContext(_ctx, getState());
		enterRule(_localctx, 118, RULE_function_name);
		try {
			setState(554);
			switch (_input.LA(1)) {
			case 28:
				enterOuterAlt(_localctx, 1);
				{
				setState(548); match(28);
				setState(549); function_name();
				setState(550); match(11);
				}
				break;
			case ALPHA_NUMERIC:
				enterOuterAlt(_localctx, 2);
				{
				setState(552); identifier();
				}
				break;
			case OPERATOR:
				enterOuterAlt(_localctx, 3);
				{
				setState(553); operator_function_id();
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class Exception_specificationContext extends ParserRuleContext {
		public Type_id_listContext type_id_list() {
			return getRuleContext(Type_id_listContext.class,0);
		}
		public TerminalNode THROW() { return getToken(CodeSensorParser.THROW, 0); }
		public Exception_specificationContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_exception_specification; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof CodeSensorListener ) ((CodeSensorListener)listener).enterException_specification(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof CodeSensorListener ) ((CodeSensorListener)listener).exitException_specification(this);
		}
	}

	public final Exception_specificationContext exception_specification() throws RecognitionException {
		Exception_specificationContext _localctx = new Exception_specificationContext(_ctx, getState());
		enterRule(_localctx, 120, RULE_exception_specification);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(556); match(THROW);
			setState(557); match(28);
			setState(558); type_id_list();
			setState(559); match(11);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class Type_id_listContext extends ParserRuleContext {
		public List<Type_id_listContext> type_id_list() {
			return getRuleContexts(Type_id_listContext.class);
		}
		public Type_id_listContext type_id_list(int i) {
			return getRuleContext(Type_id_listContext.class,i);
		}
		public No_bracketsContext no_brackets(int i) {
			return getRuleContext(No_bracketsContext.class,i);
		}
		public List<No_bracketsContext> no_brackets() {
			return getRuleContexts(No_bracketsContext.class);
		}
		public Type_id_listContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_type_id_list; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof CodeSensorListener ) ((CodeSensorListener)listener).enterType_id_list(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof CodeSensorListener ) ((CodeSensorListener)listener).exitType_id_list(this);
		}
	}

	public final Type_id_listContext type_id_list() throws RecognitionException {
		Type_id_listContext _localctx = new Type_id_listContext(_ctx, getState());
		enterRule(_localctx, 122, RULE_type_id_list);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(564);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << 1) | (1L << 2) | (1L << 3) | (1L << 4) | (1L << 5) | (1L << 6) | (1L << 7) | (1L << 8) | (1L << 9) | (1L << 10) | (1L << 12) | (1L << 13) | (1L << 14) | (1L << 15) | (1L << 16) | (1L << 17) | (1L << 18) | (1L << 19) | (1L << 20) | (1L << 21) | (1L << 22) | (1L << 23) | (1L << 24) | (1L << 25) | (1L << 26) | (1L << 27) | (1L << 29) | (1L << 30) | (1L << 31) | (1L << 32) | (1L << 33) | (1L << 34) | (1L << 35) | (1L << 36) | (1L << 37) | (1L << 38) | (1L << 39) | (1L << 40) | (1L << 41) | (1L << 42) | (1L << 43) | (1L << 44) | (1L << 45) | (1L << 46) | (1L << 47) | (1L << 48) | (1L << 49) | (1L << 50) | (1L << 51) | (1L << 52) | (1L << 53) | (1L << IF) | (1L << ELSE) | (1L << FOR) | (1L << WHILE) | (1L << BREAK) | (1L << CASE) | (1L << CONTINUE) | (1L << SWITCH) | (1L << DO) | (1L << GOTO))) != 0) || ((((_la - 64)) & ~0x3f) == 0 && ((1L << (_la - 64)) & ((1L << (RETURN - 64)) | (1L << (TYPEDEF - 64)) | (1L << (VOID - 64)) | (1L << (UNSIGNED - 64)) | (1L << (SIGNED - 64)) | (1L << (LONG - 64)) | (1L << (CV_QUALIFIER - 64)) | (1L << (VIRTUAL - 64)) | (1L << (TRY - 64)) | (1L << (CATCH - 64)) | (1L << (THROW - 64)) | (1L << (USING - 64)) | (1L << (NAMESPACE - 64)) | (1L << (AUTO - 64)) | (1L << (REGISTER - 64)) | (1L << (OPERATOR - 64)) | (1L << (TEMPLATE - 64)) | (1L << (CLASS_KEY - 64)) | (1L << (ALPHA_NUMERIC - 64)) | (1L << (OPENING_CURLY - 64)) | (1L << (CLOSING_CURLY - 64)) | (1L << (SMALLER - 64)) | (1L << (LARGER - 64)) | (1L << (PRE_IF - 64)) | (1L << (PRE_ELSE - 64)) | (1L << (PRE_ENDIF - 64)) | (1L << (HEX_LITERAL - 64)) | (1L << (DECIMAL_LITERAL - 64)) | (1L << (OCTAL_LITERAL - 64)) | (1L << (FLOATING_POINT_LITERAL - 64)) | (1L << (CHAR - 64)) | (1L << (STRING - 64)) | (1L << (COMMENT - 64)) | (1L << (WHITESPACE - 64)) | (1L << (CPPCOMMENT - 64)) | (1L << (OTHER - 64)))) != 0)) {
				{
				{
				setState(561); no_brackets();
				}
				}
				setState(566);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(578);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==28) {
				{
				{
				setState(567); match(28);
				setState(568); type_id_list();
				setState(569); match(11);
				setState(573);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << 1) | (1L << 2) | (1L << 3) | (1L << 4) | (1L << 5) | (1L << 6) | (1L << 7) | (1L << 8) | (1L << 9) | (1L << 10) | (1L << 12) | (1L << 13) | (1L << 14) | (1L << 15) | (1L << 16) | (1L << 17) | (1L << 18) | (1L << 19) | (1L << 20) | (1L << 21) | (1L << 22) | (1L << 23) | (1L << 24) | (1L << 25) | (1L << 26) | (1L << 27) | (1L << 29) | (1L << 30) | (1L << 31) | (1L << 32) | (1L << 33) | (1L << 34) | (1L << 35) | (1L << 36) | (1L << 37) | (1L << 38) | (1L << 39) | (1L << 40) | (1L << 41) | (1L << 42) | (1L << 43) | (1L << 44) | (1L << 45) | (1L << 46) | (1L << 47) | (1L << 48) | (1L << 49) | (1L << 50) | (1L << 51) | (1L << 52) | (1L << 53) | (1L << IF) | (1L << ELSE) | (1L << FOR) | (1L << WHILE) | (1L << BREAK) | (1L << CASE) | (1L << CONTINUE) | (1L << SWITCH) | (1L << DO) | (1L << GOTO))) != 0) || ((((_la - 64)) & ~0x3f) == 0 && ((1L << (_la - 64)) & ((1L << (RETURN - 64)) | (1L << (TYPEDEF - 64)) | (1L << (VOID - 64)) | (1L << (UNSIGNED - 64)) | (1L << (SIGNED - 64)) | (1L << (LONG - 64)) | (1L << (CV_QUALIFIER - 64)) | (1L << (VIRTUAL - 64)) | (1L << (TRY - 64)) | (1L << (CATCH - 64)) | (1L << (THROW - 64)) | (1L << (USING - 64)) | (1L << (NAMESPACE - 64)) | (1L << (AUTO - 64)) | (1L << (REGISTER - 64)) | (1L << (OPERATOR - 64)) | (1L << (TEMPLATE - 64)) | (1L << (CLASS_KEY - 64)) | (1L << (ALPHA_NUMERIC - 64)) | (1L << (OPENING_CURLY - 64)) | (1L << (CLOSING_CURLY - 64)) | (1L << (SMALLER - 64)) | (1L << (LARGER - 64)) | (1L << (PRE_IF - 64)) | (1L << (PRE_ELSE - 64)) | (1L << (PRE_ENDIF - 64)) | (1L << (HEX_LITERAL - 64)) | (1L << (DECIMAL_LITERAL - 64)) | (1L << (OCTAL_LITERAL - 64)) | (1L << (FLOATING_POINT_LITERAL - 64)) | (1L << (CHAR - 64)) | (1L << (STRING - 64)) | (1L << (COMMENT - 64)) | (1L << (WHITESPACE - 64)) | (1L << (CPPCOMMENT - 64)) | (1L << (OTHER - 64)))) != 0)) {
					{
					{
					setState(570); no_brackets();
					}
					}
					setState(575);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				}
				}
				setState(580);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class Init_declaratorContext extends ParserRuleContext {
		public Type_suffixContext type_suffix() {
			return getRuleContext(Type_suffixContext.class,0);
		}
		public ExprContext expr() {
			return getRuleContext(ExprContext.class,0);
		}
		public PtrsContext ptrs() {
			return getRuleContext(PtrsContext.class,0);
		}
		public IdentifierContext identifier() {
			return getRuleContext(IdentifierContext.class,0);
		}
		public Assign_expr_w_Context assign_expr_w_() {
			return getRuleContext(Assign_expr_w_Context.class,0);
		}
		public Init_declaratorContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_init_declarator; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof CodeSensorListener ) ((CodeSensorListener)listener).enterInit_declarator(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof CodeSensorListener ) ((CodeSensorListener)listener).exitInit_declarator(this);
		}
	}

	public final Init_declaratorContext init_declarator() throws RecognitionException {
		Init_declaratorContext _localctx = new Init_declaratorContext(_ctx, getState());
		enterRule(_localctx, 124, RULE_init_declarator);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			{
			setState(582);
			_la = _input.LA(1);
			if (_la==1 || _la==2) {
				{
				setState(581); ptrs();
				}
			}

			setState(584); identifier();
			setState(586);
			switch ( getInterpreter().adaptivePredict(_input,53,_ctx) ) {
			case 1:
				{
				setState(585); type_suffix();
				}
				break;
			}
			}
			setState(595);
			switch (_input.LA(1)) {
			case 28:
				{
				{
				setState(588); match(28);
				setState(590);
				_la = _input.LA(1);
				if ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << 1) | (1L << 2) | (1L << 4) | (1L << 19) | (1L << 26) | (1L << 28) | (1L << 38) | (1L << 43) | (1L << 52))) != 0) || ((((_la - 82)) & ~0x3f) == 0 && ((1L << (_la - 82)) & ((1L << (ALPHA_NUMERIC - 82)) | (1L << (HEX_LITERAL - 82)) | (1L << (DECIMAL_LITERAL - 82)) | (1L << (OCTAL_LITERAL - 82)) | (1L << (FLOATING_POINT_LITERAL - 82)) | (1L << (CHAR - 82)) | (1L << (STRING - 82)))) != 0)) {
					{
					setState(589); expr();
					}
				}

				setState(592); match(11);
				}
				}
				break;
			case 15:
				{
				{
				setState(593); match(15);
				setState(594); assign_expr_w_();
				}
				}
				break;
			case 25:
			case 45:
				break;
			default:
				throw new NoViableAltException(this);
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class Type_suffixContext extends ParserRuleContext {
		public Param_type_listContext param_type_list() {
			return getRuleContext(Param_type_listContext.class,0);
		}
		public Constant_expr_w_Context constant_expr_w_() {
			return getRuleContext(Constant_expr_w_Context.class,0);
		}
		public Type_suffixContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_type_suffix; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof CodeSensorListener ) ((CodeSensorListener)listener).enterType_suffix(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof CodeSensorListener ) ((CodeSensorListener)listener).exitType_suffix(this);
		}
	}

	public final Type_suffixContext type_suffix() throws RecognitionException {
		Type_suffixContext _localctx = new Type_suffixContext(_ctx, getState());
		enterRule(_localctx, 126, RULE_type_suffix);
		try {
			setState(602);
			switch (_input.LA(1)) {
			case 3:
				enterOuterAlt(_localctx, 1);
				{
				{
				setState(597); match(3);
				setState(598); constant_expr_w_();
				setState(599); match(20);
				}
				}
				break;
			case 28:
				enterOuterAlt(_localctx, 2);
				{
				setState(601); param_type_list();
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class Assign_expr_w_Context extends ParserRuleContext {
		public List<Assign_expr_w__l2Context> assign_expr_w__l2() {
			return getRuleContexts(Assign_expr_w__l2Context.class);
		}
		public Assign_waterContext assign_water(int i) {
			return getRuleContext(Assign_waterContext.class,i);
		}
		public Assign_expr_w__l2Context assign_expr_w__l2(int i) {
			return getRuleContext(Assign_expr_w__l2Context.class,i);
		}
		public List<Assign_waterContext> assign_water() {
			return getRuleContexts(Assign_waterContext.class);
		}
		public Assign_expr_w_Context(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_assign_expr_w_; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof CodeSensorListener ) ((CodeSensorListener)listener).enterAssign_expr_w_(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof CodeSensorListener ) ((CodeSensorListener)listener).exitAssign_expr_w_(this);
		}
	}

	public final Assign_expr_w_Context assign_expr_w_() throws RecognitionException {
		Assign_expr_w_Context _localctx = new Assign_expr_w_Context(_ctx, getState());
		enterRule(_localctx, 128, RULE_assign_expr_w_);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(607);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << 1) | (1L << 2) | (1L << 4) | (1L << 5) | (1L << 6) | (1L << 7) | (1L << 8) | (1L << 9) | (1L << 10) | (1L << 12) | (1L << 13) | (1L << 14) | (1L << 15) | (1L << 16) | (1L << 17) | (1L << 18) | (1L << 19) | (1L << 21) | (1L << 22) | (1L << 23) | (1L << 24) | (1L << 26) | (1L << 27) | (1L << 29) | (1L << 30) | (1L << 31) | (1L << 32) | (1L << 33) | (1L << 34) | (1L << 35) | (1L << 36) | (1L << 37) | (1L << 38) | (1L << 39) | (1L << 40) | (1L << 41) | (1L << 42) | (1L << 43) | (1L << 44) | (1L << 46) | (1L << 47) | (1L << 48) | (1L << 49) | (1L << 50) | (1L << 51) | (1L << 52) | (1L << 53) | (1L << IF) | (1L << ELSE) | (1L << FOR) | (1L << WHILE) | (1L << BREAK) | (1L << CASE) | (1L << CONTINUE) | (1L << SWITCH) | (1L << DO) | (1L << GOTO))) != 0) || ((((_la - 64)) & ~0x3f) == 0 && ((1L << (_la - 64)) & ((1L << (RETURN - 64)) | (1L << (TYPEDEF - 64)) | (1L << (VOID - 64)) | (1L << (UNSIGNED - 64)) | (1L << (SIGNED - 64)) | (1L << (LONG - 64)) | (1L << (CV_QUALIFIER - 64)) | (1L << (VIRTUAL - 64)) | (1L << (TRY - 64)) | (1L << (CATCH - 64)) | (1L << (THROW - 64)) | (1L << (USING - 64)) | (1L << (NAMESPACE - 64)) | (1L << (AUTO - 64)) | (1L << (REGISTER - 64)) | (1L << (OPERATOR - 64)) | (1L << (TEMPLATE - 64)) | (1L << (CLASS_KEY - 64)) | (1L << (ALPHA_NUMERIC - 64)) | (1L << (SMALLER - 64)) | (1L << (LARGER - 64)) | (1L << (PRE_IF - 64)) | (1L << (PRE_ELSE - 64)) | (1L << (PRE_ENDIF - 64)) | (1L << (HEX_LITERAL - 64)) | (1L << (DECIMAL_LITERAL - 64)) | (1L << (OCTAL_LITERAL - 64)) | (1L << (FLOATING_POINT_LITERAL - 64)) | (1L << (CHAR - 64)) | (1L << (STRING - 64)) | (1L << (COMMENT - 64)) | (1L << (WHITESPACE - 64)) | (1L << (CPPCOMMENT - 64)) | (1L << (OTHER - 64)))) != 0)) {
				{
				{
				setState(604); assign_water();
				}
				}
				setState(609);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(632);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==3 || _la==28 || _la==OPENING_CURLY) {
				{
				{
				setState(622);
				switch (_input.LA(1)) {
				case OPENING_CURLY:
					{
					setState(610); match(OPENING_CURLY);
					setState(611); assign_expr_w__l2();
					setState(612); match(CLOSING_CURLY);
					}
					break;
				case 28:
					{
					setState(614); match(28);
					setState(615); assign_expr_w__l2();
					setState(616); match(11);
					}
					break;
				case 3:
					{
					setState(618); match(3);
					setState(619); assign_expr_w__l2();
					setState(620); match(20);
					}
					break;
				default:
					throw new NoViableAltException(this);
				}
				setState(627);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << 1) | (1L << 2) | (1L << 4) | (1L << 5) | (1L << 6) | (1L << 7) | (1L << 8) | (1L << 9) | (1L << 10) | (1L << 12) | (1L << 13) | (1L << 14) | (1L << 15) | (1L << 16) | (1L << 17) | (1L << 18) | (1L << 19) | (1L << 21) | (1L << 22) | (1L << 23) | (1L << 24) | (1L << 26) | (1L << 27) | (1L << 29) | (1L << 30) | (1L << 31) | (1L << 32) | (1L << 33) | (1L << 34) | (1L << 35) | (1L << 36) | (1L << 37) | (1L << 38) | (1L << 39) | (1L << 40) | (1L << 41) | (1L << 42) | (1L << 43) | (1L << 44) | (1L << 46) | (1L << 47) | (1L << 48) | (1L << 49) | (1L << 50) | (1L << 51) | (1L << 52) | (1L << 53) | (1L << IF) | (1L << ELSE) | (1L << FOR) | (1L << WHILE) | (1L << BREAK) | (1L << CASE) | (1L << CONTINUE) | (1L << SWITCH) | (1L << DO) | (1L << GOTO))) != 0) || ((((_la - 64)) & ~0x3f) == 0 && ((1L << (_la - 64)) & ((1L << (RETURN - 64)) | (1L << (TYPEDEF - 64)) | (1L << (VOID - 64)) | (1L << (UNSIGNED - 64)) | (1L << (SIGNED - 64)) | (1L << (LONG - 64)) | (1L << (CV_QUALIFIER - 64)) | (1L << (VIRTUAL - 64)) | (1L << (TRY - 64)) | (1L << (CATCH - 64)) | (1L << (THROW - 64)) | (1L << (USING - 64)) | (1L << (NAMESPACE - 64)) | (1L << (AUTO - 64)) | (1L << (REGISTER - 64)) | (1L << (OPERATOR - 64)) | (1L << (TEMPLATE - 64)) | (1L << (CLASS_KEY - 64)) | (1L << (ALPHA_NUMERIC - 64)) | (1L << (SMALLER - 64)) | (1L << (LARGER - 64)) | (1L << (PRE_IF - 64)) | (1L << (PRE_ELSE - 64)) | (1L << (PRE_ENDIF - 64)) | (1L << (HEX_LITERAL - 64)) | (1L << (DECIMAL_LITERAL - 64)) | (1L << (OCTAL_LITERAL - 64)) | (1L << (FLOATING_POINT_LITERAL - 64)) | (1L << (CHAR - 64)) | (1L << (STRING - 64)) | (1L << (COMMENT - 64)) | (1L << (WHITESPACE - 64)) | (1L << (CPPCOMMENT - 64)) | (1L << (OTHER - 64)))) != 0)) {
					{
					{
					setState(624); assign_water();
					}
					}
					setState(629);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				}
				}
				setState(634);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class Assign_expr_w__l2Context extends ParserRuleContext {
		public List<Assign_expr_w__l2Context> assign_expr_w__l2() {
			return getRuleContexts(Assign_expr_w__l2Context.class);
		}
		public List<Assign_water_l2Context> assign_water_l2() {
			return getRuleContexts(Assign_water_l2Context.class);
		}
		public Assign_water_l2Context assign_water_l2(int i) {
			return getRuleContext(Assign_water_l2Context.class,i);
		}
		public Assign_expr_w__l2Context assign_expr_w__l2(int i) {
			return getRuleContext(Assign_expr_w__l2Context.class,i);
		}
		public Assign_expr_w__l2Context(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_assign_expr_w__l2; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof CodeSensorListener ) ((CodeSensorListener)listener).enterAssign_expr_w__l2(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof CodeSensorListener ) ((CodeSensorListener)listener).exitAssign_expr_w__l2(this);
		}
	}

	public final Assign_expr_w__l2Context assign_expr_w__l2() throws RecognitionException {
		Assign_expr_w__l2Context _localctx = new Assign_expr_w__l2Context(_ctx, getState());
		enterRule(_localctx, 130, RULE_assign_expr_w__l2);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(638);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << 1) | (1L << 2) | (1L << 4) | (1L << 5) | (1L << 6) | (1L << 7) | (1L << 8) | (1L << 9) | (1L << 10) | (1L << 12) | (1L << 13) | (1L << 14) | (1L << 15) | (1L << 16) | (1L << 17) | (1L << 18) | (1L << 19) | (1L << 21) | (1L << 22) | (1L << 23) | (1L << 24) | (1L << 25) | (1L << 26) | (1L << 27) | (1L << 29) | (1L << 30) | (1L << 31) | (1L << 32) | (1L << 33) | (1L << 34) | (1L << 35) | (1L << 36) | (1L << 37) | (1L << 38) | (1L << 39) | (1L << 40) | (1L << 41) | (1L << 42) | (1L << 43) | (1L << 44) | (1L << 45) | (1L << 46) | (1L << 47) | (1L << 48) | (1L << 49) | (1L << 50) | (1L << 51) | (1L << 52) | (1L << 53) | (1L << IF) | (1L << ELSE) | (1L << FOR) | (1L << WHILE) | (1L << BREAK) | (1L << CASE) | (1L << CONTINUE) | (1L << SWITCH) | (1L << DO) | (1L << GOTO))) != 0) || ((((_la - 64)) & ~0x3f) == 0 && ((1L << (_la - 64)) & ((1L << (RETURN - 64)) | (1L << (TYPEDEF - 64)) | (1L << (VOID - 64)) | (1L << (UNSIGNED - 64)) | (1L << (SIGNED - 64)) | (1L << (LONG - 64)) | (1L << (CV_QUALIFIER - 64)) | (1L << (VIRTUAL - 64)) | (1L << (TRY - 64)) | (1L << (CATCH - 64)) | (1L << (THROW - 64)) | (1L << (USING - 64)) | (1L << (NAMESPACE - 64)) | (1L << (AUTO - 64)) | (1L << (REGISTER - 64)) | (1L << (OPERATOR - 64)) | (1L << (TEMPLATE - 64)) | (1L << (CLASS_KEY - 64)) | (1L << (ALPHA_NUMERIC - 64)) | (1L << (SMALLER - 64)) | (1L << (LARGER - 64)) | (1L << (PRE_IF - 64)) | (1L << (PRE_ELSE - 64)) | (1L << (PRE_ENDIF - 64)) | (1L << (HEX_LITERAL - 64)) | (1L << (DECIMAL_LITERAL - 64)) | (1L << (OCTAL_LITERAL - 64)) | (1L << (FLOATING_POINT_LITERAL - 64)) | (1L << (CHAR - 64)) | (1L << (STRING - 64)) | (1L << (COMMENT - 64)) | (1L << (WHITESPACE - 64)) | (1L << (CPPCOMMENT - 64)) | (1L << (OTHER - 64)))) != 0)) {
				{
				{
				setState(635); assign_water_l2();
				}
				}
				setState(640);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(663);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==3 || _la==28 || _la==OPENING_CURLY) {
				{
				{
				setState(653);
				switch (_input.LA(1)) {
				case OPENING_CURLY:
					{
					setState(641); match(OPENING_CURLY);
					setState(642); assign_expr_w__l2();
					setState(643); match(CLOSING_CURLY);
					}
					break;
				case 28:
					{
					setState(645); match(28);
					setState(646); assign_expr_w__l2();
					setState(647); match(11);
					}
					break;
				case 3:
					{
					setState(649); match(3);
					setState(650); assign_expr_w__l2();
					setState(651); match(20);
					}
					break;
				default:
					throw new NoViableAltException(this);
				}
				setState(658);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << 1) | (1L << 2) | (1L << 4) | (1L << 5) | (1L << 6) | (1L << 7) | (1L << 8) | (1L << 9) | (1L << 10) | (1L << 12) | (1L << 13) | (1L << 14) | (1L << 15) | (1L << 16) | (1L << 17) | (1L << 18) | (1L << 19) | (1L << 21) | (1L << 22) | (1L << 23) | (1L << 24) | (1L << 25) | (1L << 26) | (1L << 27) | (1L << 29) | (1L << 30) | (1L << 31) | (1L << 32) | (1L << 33) | (1L << 34) | (1L << 35) | (1L << 36) | (1L << 37) | (1L << 38) | (1L << 39) | (1L << 40) | (1L << 41) | (1L << 42) | (1L << 43) | (1L << 44) | (1L << 45) | (1L << 46) | (1L << 47) | (1L << 48) | (1L << 49) | (1L << 50) | (1L << 51) | (1L << 52) | (1L << 53) | (1L << IF) | (1L << ELSE) | (1L << FOR) | (1L << WHILE) | (1L << BREAK) | (1L << CASE) | (1L << CONTINUE) | (1L << SWITCH) | (1L << DO) | (1L << GOTO))) != 0) || ((((_la - 64)) & ~0x3f) == 0 && ((1L << (_la - 64)) & ((1L << (RETURN - 64)) | (1L << (TYPEDEF - 64)) | (1L << (VOID - 64)) | (1L << (UNSIGNED - 64)) | (1L << (SIGNED - 64)) | (1L << (LONG - 64)) | (1L << (CV_QUALIFIER - 64)) | (1L << (VIRTUAL - 64)) | (1L << (TRY - 64)) | (1L << (CATCH - 64)) | (1L << (THROW - 64)) | (1L << (USING - 64)) | (1L << (NAMESPACE - 64)) | (1L << (AUTO - 64)) | (1L << (REGISTER - 64)) | (1L << (OPERATOR - 64)) | (1L << (TEMPLATE - 64)) | (1L << (CLASS_KEY - 64)) | (1L << (ALPHA_NUMERIC - 64)) | (1L << (SMALLER - 64)) | (1L << (LARGER - 64)) | (1L << (PRE_IF - 64)) | (1L << (PRE_ELSE - 64)) | (1L << (PRE_ENDIF - 64)) | (1L << (HEX_LITERAL - 64)) | (1L << (DECIMAL_LITERAL - 64)) | (1L << (OCTAL_LITERAL - 64)) | (1L << (FLOATING_POINT_LITERAL - 64)) | (1L << (CHAR - 64)) | (1L << (STRING - 64)) | (1L << (COMMENT - 64)) | (1L << (WHITESPACE - 64)) | (1L << (CPPCOMMENT - 64)) | (1L << (OTHER - 64)))) != 0)) {
					{
					{
					setState(655); assign_water_l2();
					}
					}
					setState(660);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				}
				}
				setState(665);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class Constant_expr_w_Context extends ParserRuleContext {
		public Constant_expr_w_Context constant_expr_w_(int i) {
			return getRuleContext(Constant_expr_w_Context.class,i);
		}
		public List<No_squaresContext> no_squares() {
			return getRuleContexts(No_squaresContext.class);
		}
		public No_squaresContext no_squares(int i) {
			return getRuleContext(No_squaresContext.class,i);
		}
		public List<Constant_expr_w_Context> constant_expr_w_() {
			return getRuleContexts(Constant_expr_w_Context.class);
		}
		public Constant_expr_w_Context(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_constant_expr_w_; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof CodeSensorListener ) ((CodeSensorListener)listener).enterConstant_expr_w_(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof CodeSensorListener ) ((CodeSensorListener)listener).exitConstant_expr_w_(this);
		}
	}

	public final Constant_expr_w_Context constant_expr_w_() throws RecognitionException {
		Constant_expr_w_Context _localctx = new Constant_expr_w_Context(_ctx, getState());
		enterRule(_localctx, 132, RULE_constant_expr_w_);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(669);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << 1) | (1L << 2) | (1L << 4) | (1L << 5) | (1L << 6) | (1L << 7) | (1L << 8) | (1L << 9) | (1L << 10) | (1L << 11) | (1L << 12) | (1L << 13) | (1L << 14) | (1L << 15) | (1L << 16) | (1L << 17) | (1L << 18) | (1L << 19) | (1L << 21) | (1L << 22) | (1L << 23) | (1L << 24) | (1L << 25) | (1L << 26) | (1L << 27) | (1L << 28) | (1L << 29) | (1L << 30) | (1L << 31) | (1L << 32) | (1L << 33) | (1L << 34) | (1L << 35) | (1L << 36) | (1L << 37) | (1L << 38) | (1L << 39) | (1L << 40) | (1L << 41) | (1L << 42) | (1L << 43) | (1L << 44) | (1L << 45) | (1L << 46) | (1L << 47) | (1L << 48) | (1L << 49) | (1L << 50) | (1L << 51) | (1L << 52) | (1L << 53) | (1L << IF) | (1L << ELSE) | (1L << FOR) | (1L << WHILE) | (1L << BREAK) | (1L << CASE) | (1L << CONTINUE) | (1L << SWITCH) | (1L << DO) | (1L << GOTO))) != 0) || ((((_la - 64)) & ~0x3f) == 0 && ((1L << (_la - 64)) & ((1L << (RETURN - 64)) | (1L << (TYPEDEF - 64)) | (1L << (VOID - 64)) | (1L << (UNSIGNED - 64)) | (1L << (SIGNED - 64)) | (1L << (LONG - 64)) | (1L << (CV_QUALIFIER - 64)) | (1L << (VIRTUAL - 64)) | (1L << (TRY - 64)) | (1L << (CATCH - 64)) | (1L << (THROW - 64)) | (1L << (USING - 64)) | (1L << (NAMESPACE - 64)) | (1L << (AUTO - 64)) | (1L << (REGISTER - 64)) | (1L << (OPERATOR - 64)) | (1L << (TEMPLATE - 64)) | (1L << (CLASS_KEY - 64)) | (1L << (ALPHA_NUMERIC - 64)) | (1L << (OPENING_CURLY - 64)) | (1L << (CLOSING_CURLY - 64)) | (1L << (SMALLER - 64)) | (1L << (LARGER - 64)) | (1L << (PRE_IF - 64)) | (1L << (PRE_ELSE - 64)) | (1L << (PRE_ENDIF - 64)) | (1L << (HEX_LITERAL - 64)) | (1L << (DECIMAL_LITERAL - 64)) | (1L << (OCTAL_LITERAL - 64)) | (1L << (FLOATING_POINT_LITERAL - 64)) | (1L << (CHAR - 64)) | (1L << (STRING - 64)) | (1L << (COMMENT - 64)) | (1L << (WHITESPACE - 64)) | (1L << (CPPCOMMENT - 64)) | (1L << (OTHER - 64)))) != 0)) {
				{
				{
				setState(666); no_squares();
				}
				}
				setState(671);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(683);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==3) {
				{
				{
				setState(672); match(3);
				setState(673); constant_expr_w_();
				setState(674); match(20);
				setState(678);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << 1) | (1L << 2) | (1L << 4) | (1L << 5) | (1L << 6) | (1L << 7) | (1L << 8) | (1L << 9) | (1L << 10) | (1L << 11) | (1L << 12) | (1L << 13) | (1L << 14) | (1L << 15) | (1L << 16) | (1L << 17) | (1L << 18) | (1L << 19) | (1L << 21) | (1L << 22) | (1L << 23) | (1L << 24) | (1L << 25) | (1L << 26) | (1L << 27) | (1L << 28) | (1L << 29) | (1L << 30) | (1L << 31) | (1L << 32) | (1L << 33) | (1L << 34) | (1L << 35) | (1L << 36) | (1L << 37) | (1L << 38) | (1L << 39) | (1L << 40) | (1L << 41) | (1L << 42) | (1L << 43) | (1L << 44) | (1L << 45) | (1L << 46) | (1L << 47) | (1L << 48) | (1L << 49) | (1L << 50) | (1L << 51) | (1L << 52) | (1L << 53) | (1L << IF) | (1L << ELSE) | (1L << FOR) | (1L << WHILE) | (1L << BREAK) | (1L << CASE) | (1L << CONTINUE) | (1L << SWITCH) | (1L << DO) | (1L << GOTO))) != 0) || ((((_la - 64)) & ~0x3f) == 0 && ((1L << (_la - 64)) & ((1L << (RETURN - 64)) | (1L << (TYPEDEF - 64)) | (1L << (VOID - 64)) | (1L << (UNSIGNED - 64)) | (1L << (SIGNED - 64)) | (1L << (LONG - 64)) | (1L << (CV_QUALIFIER - 64)) | (1L << (VIRTUAL - 64)) | (1L << (TRY - 64)) | (1L << (CATCH - 64)) | (1L << (THROW - 64)) | (1L << (USING - 64)) | (1L << (NAMESPACE - 64)) | (1L << (AUTO - 64)) | (1L << (REGISTER - 64)) | (1L << (OPERATOR - 64)) | (1L << (TEMPLATE - 64)) | (1L << (CLASS_KEY - 64)) | (1L << (ALPHA_NUMERIC - 64)) | (1L << (OPENING_CURLY - 64)) | (1L << (CLOSING_CURLY - 64)) | (1L << (SMALLER - 64)) | (1L << (LARGER - 64)) | (1L << (PRE_IF - 64)) | (1L << (PRE_ELSE - 64)) | (1L << (PRE_ENDIF - 64)) | (1L << (HEX_LITERAL - 64)) | (1L << (DECIMAL_LITERAL - 64)) | (1L << (OCTAL_LITERAL - 64)) | (1L << (FLOATING_POINT_LITERAL - 64)) | (1L << (CHAR - 64)) | (1L << (STRING - 64)) | (1L << (COMMENT - 64)) | (1L << (WHITESPACE - 64)) | (1L << (CPPCOMMENT - 64)) | (1L << (OTHER - 64)))) != 0)) {
					{
					{
					setState(675); no_squares();
					}
					}
					setState(680);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				}
				}
				setState(685);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class Simple_declContext extends ParserRuleContext {
		public Template_decl_startContext template_decl_start() {
			return getRuleContext(Template_decl_startContext.class,0);
		}
		public TerminalNode TYPEDEF() { return getToken(CodeSensorParser.TYPEDEF, 0); }
		public Var_declContext var_decl() {
			return getRuleContext(Var_declContext.class,0);
		}
		public Simple_declContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_simple_decl; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof CodeSensorListener ) ((CodeSensorListener)listener).enterSimple_decl(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof CodeSensorListener ) ((CodeSensorListener)listener).exitSimple_decl(this);
		}
	}

	public final Simple_declContext simple_decl() throws RecognitionException {
		Simple_declContext _localctx = new Simple_declContext(_ctx, getState());
		enterRule(_localctx, 134, RULE_simple_decl);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			{
			setState(687);
			_la = _input.LA(1);
			if (_la==TYPEDEF) {
				{
				setState(686); match(TYPEDEF);
				}
			}

			setState(690);
			_la = _input.LA(1);
			if (_la==TEMPLATE) {
				{
				setState(689); template_decl_start();
				}
			}

			}
			setState(692); var_decl();
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class Var_declContext extends ParserRuleContext {
		public Var_declContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_var_decl; }
	 
		public Var_declContext() { }
		public void copyFrom(Var_declContext ctx) {
			super.copyFrom(ctx);
		}
	}
	public static class DeclByClassContext extends Var_declContext {
		public Class_defContext class_def() {
			return getRuleContext(Class_defContext.class,0);
		}
		public Init_declarator_listContext init_declarator_list() {
			return getRuleContext(Init_declarator_listContext.class,0);
		}
		public DeclByClassContext(Var_declContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof CodeSensorListener ) ((CodeSensorListener)listener).enterDeclByClass(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof CodeSensorListener ) ((CodeSensorListener)listener).exitDeclByClass(this);
		}
	}
	public static class DeclByTypeContext extends Var_declContext {
		public Init_declarator_listContext init_declarator_list() {
			return getRuleContext(Init_declarator_listContext.class,0);
		}
		public Type_nameContext type_name() {
			return getRuleContext(Type_nameContext.class,0);
		}
		public DeclByTypeContext(Var_declContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof CodeSensorListener ) ((CodeSensorListener)listener).enterDeclByType(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof CodeSensorListener ) ((CodeSensorListener)listener).exitDeclByType(this);
		}
	}

	public final Var_declContext var_decl() throws RecognitionException {
		Var_declContext _localctx = new Var_declContext(_ctx, getState());
		enterRule(_localctx, 136, RULE_var_decl);
		try {
			setState(701);
			switch ( getInterpreter().adaptivePredict(_input,71,_ctx) ) {
			case 1:
				_localctx = new DeclByClassContext(_localctx);
				enterOuterAlt(_localctx, 1);
				{
				setState(694); class_def();
				setState(696);
				switch ( getInterpreter().adaptivePredict(_input,70,_ctx) ) {
				case 1:
					{
					setState(695); init_declarator_list();
					}
					break;
				}
				}
				break;

			case 2:
				_localctx = new DeclByTypeContext(_localctx);
				enterOuterAlt(_localctx, 2);
				{
				setState(698); type_name();
				setState(699); init_declarator_list();
				}
				break;
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class Init_declarator_listContext extends ParserRuleContext {
		public List<Init_declaratorContext> init_declarator() {
			return getRuleContexts(Init_declaratorContext.class);
		}
		public Init_declaratorContext init_declarator(int i) {
			return getRuleContext(Init_declaratorContext.class,i);
		}
		public Init_declarator_listContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_init_declarator_list; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof CodeSensorListener ) ((CodeSensorListener)listener).enterInit_declarator_list(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof CodeSensorListener ) ((CodeSensorListener)listener).exitInit_declarator_list(this);
		}
	}

	public final Init_declarator_listContext init_declarator_list() throws RecognitionException {
		Init_declarator_listContext _localctx = new Init_declarator_listContext(_ctx, getState());
		enterRule(_localctx, 138, RULE_init_declarator_list);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(703); init_declarator();
			setState(708);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==25) {
				{
				{
				setState(704); match(25);
				setState(705); init_declarator();
				}
				}
				setState(710);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(711); match(45);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class InitializerContext extends ParserRuleContext {
		public Initializer_listContext initializer_list() {
			return getRuleContext(Initializer_listContext.class,0);
		}
		public Assign_exprContext assign_expr() {
			return getRuleContext(Assign_exprContext.class,0);
		}
		public InitializerContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_initializer; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof CodeSensorListener ) ((CodeSensorListener)listener).enterInitializer(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof CodeSensorListener ) ((CodeSensorListener)listener).exitInitializer(this);
		}
	}

	public final InitializerContext initializer() throws RecognitionException {
		InitializerContext _localctx = new InitializerContext(_ctx, getState());
		enterRule(_localctx, 140, RULE_initializer);
		try {
			setState(718);
			switch (_input.LA(1)) {
			case 1:
			case 2:
			case 4:
			case 19:
			case 26:
			case 28:
			case 38:
			case 43:
			case 52:
			case ALPHA_NUMERIC:
			case HEX_LITERAL:
			case DECIMAL_LITERAL:
			case OCTAL_LITERAL:
			case FLOATING_POINT_LITERAL:
			case CHAR:
			case STRING:
				enterOuterAlt(_localctx, 1);
				{
				setState(713); assign_expr();
				}
				break;
			case OPENING_CURLY:
				enterOuterAlt(_localctx, 2);
				{
				setState(714); match(OPENING_CURLY);
				setState(715); initializer_list();
				setState(716); match(CLOSING_CURLY);
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class Initializer_listContext extends ParserRuleContext {
		public InitializerContext initializer(int i) {
			return getRuleContext(InitializerContext.class,i);
		}
		public List<InitializerContext> initializer() {
			return getRuleContexts(InitializerContext.class);
		}
		public Initializer_listContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_initializer_list; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof CodeSensorListener ) ((CodeSensorListener)listener).enterInitializer_list(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof CodeSensorListener ) ((CodeSensorListener)listener).exitInitializer_list(this);
		}
	}

	public final Initializer_listContext initializer_list() throws RecognitionException {
		Initializer_listContext _localctx = new Initializer_listContext(_ctx, getState());
		enterRule(_localctx, 142, RULE_initializer_list);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(720); initializer();
			setState(725);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==25) {
				{
				{
				setState(721); match(25);
				setState(722); initializer();
				}
				}
				setState(727);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class Class_defContext extends ParserRuleContext {
		public Base_classesContext base_classes() {
			return getRuleContext(Base_classesContext.class,0);
		}
		public Class_nameContext class_name() {
			return getRuleContext(Class_nameContext.class,0);
		}
		public TerminalNode CLASS_KEY() { return getToken(CodeSensorParser.CLASS_KEY, 0); }
		public TerminalNode OPENING_CURLY() { return getToken(CodeSensorParser.OPENING_CURLY, 0); }
		public Class_defContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_class_def; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof CodeSensorListener ) ((CodeSensorListener)listener).enterClass_def(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof CodeSensorListener ) ((CodeSensorListener)listener).exitClass_def(this);
		}
	}

	public final Class_defContext class_def() throws RecognitionException {
		Class_defContext _localctx = new Class_defContext(_ctx, getState());
		enterRule(_localctx, 144, RULE_class_def);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(728); match(CLASS_KEY);
			setState(730);
			_la = _input.LA(1);
			if (_la==ALPHA_NUMERIC) {
				{
				setState(729); class_name();
				}
			}

			setState(733);
			_la = _input.LA(1);
			if (_la==27) {
				{
				setState(732); base_classes();
				}
			}

			setState(735); match(OPENING_CURLY);
			skipToEndOfObject(); 
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class Class_nameContext extends ParserRuleContext {
		public IdentifierContext identifier() {
			return getRuleContext(IdentifierContext.class,0);
		}
		public Class_nameContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_class_name; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof CodeSensorListener ) ((CodeSensorListener)listener).enterClass_name(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof CodeSensorListener ) ((CodeSensorListener)listener).exitClass_name(this);
		}
	}

	public final Class_nameContext class_name() throws RecognitionException {
		Class_nameContext _localctx = new Class_nameContext(_ctx, getState());
		enterRule(_localctx, 146, RULE_class_name);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(738); identifier();
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class Base_classesContext extends ParserRuleContext {
		public Base_classContext base_class(int i) {
			return getRuleContext(Base_classContext.class,i);
		}
		public List<Base_classContext> base_class() {
			return getRuleContexts(Base_classContext.class);
		}
		public Base_classesContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_base_classes; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof CodeSensorListener ) ((CodeSensorListener)listener).enterBase_classes(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof CodeSensorListener ) ((CodeSensorListener)listener).exitBase_classes(this);
		}
	}

	public final Base_classesContext base_classes() throws RecognitionException {
		Base_classesContext _localctx = new Base_classesContext(_ctx, getState());
		enterRule(_localctx, 148, RULE_base_classes);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(740); match(27);
			setState(741); base_class();
			setState(746);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==25) {
				{
				{
				setState(742); match(25);
				setState(743); base_class();
				}
				}
				setState(748);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class Base_classContext extends ParserRuleContext {
		public TerminalNode VIRTUAL() { return getToken(CodeSensorParser.VIRTUAL, 0); }
		public Access_specifierContext access_specifier() {
			return getRuleContext(Access_specifierContext.class,0);
		}
		public IdentifierContext identifier() {
			return getRuleContext(IdentifierContext.class,0);
		}
		public Base_classContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_base_class; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof CodeSensorListener ) ((CodeSensorListener)listener).enterBase_class(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof CodeSensorListener ) ((CodeSensorListener)listener).exitBase_class(this);
		}
	}

	public final Base_classContext base_class() throws RecognitionException {
		Base_classContext _localctx = new Base_classContext(_ctx, getState());
		enterRule(_localctx, 150, RULE_base_class);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(750);
			_la = _input.LA(1);
			if (_la==VIRTUAL) {
				{
				setState(749); match(VIRTUAL);
				}
			}

			setState(753);
			_la = _input.LA(1);
			if ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << 24) | (1L << 30) | (1L << 44))) != 0)) {
				{
				setState(752); access_specifier();
				}
			}

			setState(755); identifier();
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class Type_nameContext extends ParserRuleContext {
		public List<TerminalNode> CV_QUALIFIER() { return getTokens(CodeSensorParser.CV_QUALIFIER); }
		public Template_param_listContext template_param_list(int i) {
			return getRuleContext(Template_param_listContext.class,i);
		}
		public TerminalNode SIGNED() { return getToken(CodeSensorParser.SIGNED, 0); }
		public TerminalNode UNSIGNED() { return getToken(CodeSensorParser.UNSIGNED, 0); }
		public List<Template_param_listContext> template_param_list() {
			return getRuleContexts(Template_param_listContext.class);
		}
		public Base_typeContext base_type(int i) {
			return getRuleContext(Base_typeContext.class,i);
		}
		public List<Base_typeContext> base_type() {
			return getRuleContexts(Base_typeContext.class);
		}
		public TerminalNode CV_QUALIFIER(int i) {
			return getToken(CodeSensorParser.CV_QUALIFIER, i);
		}
		public TerminalNode CLASS_KEY() { return getToken(CodeSensorParser.CLASS_KEY, 0); }
		public Type_nameContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_type_name; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof CodeSensorListener ) ((CodeSensorListener)listener).enterType_name(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof CodeSensorListener ) ((CodeSensorListener)listener).exitType_name(this);
		}
	}

	public final Type_nameContext type_name() throws RecognitionException {
		Type_nameContext _localctx = new Type_nameContext(_ctx, getState());
		enterRule(_localctx, 152, RULE_type_name);
		int _la;
		try {
			setState(782);
			switch ( getInterpreter().adaptivePredict(_input,85,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				{
				setState(760);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (_la==CV_QUALIFIER) {
					{
					{
					setState(757); match(CV_QUALIFIER);
					}
					}
					setState(762);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				setState(764);
				_la = _input.LA(1);
				if (((((_la - 67)) & ~0x3f) == 0 && ((1L << (_la - 67)) & ((1L << (UNSIGNED - 67)) | (1L << (SIGNED - 67)) | (1L << (CLASS_KEY - 67)))) != 0)) {
					{
					setState(763);
					_la = _input.LA(1);
					if ( !(((((_la - 67)) & ~0x3f) == 0 && ((1L << (_la - 67)) & ((1L << (UNSIGNED - 67)) | (1L << (SIGNED - 67)) | (1L << (CLASS_KEY - 67)))) != 0)) ) {
					_errHandler.recoverInline(this);
					}
					consume();
					}
				}

				setState(766); base_type();
				setState(768);
				_la = _input.LA(1);
				if (_la==SMALLER) {
					{
					setState(767); template_param_list();
					}
				}

				setState(777);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (_la==14) {
					{
					{
					setState(770); match(14);
					setState(771); base_type();
					setState(773);
					_la = _input.LA(1);
					if (_la==SMALLER) {
						{
						setState(772); template_param_list();
						}
					}

					}
					}
					setState(779);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				}
				}
				break;

			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(780); match(UNSIGNED);
				}
				break;

			case 3:
				enterOuterAlt(_localctx, 3);
				{
				setState(781); match(SIGNED);
				}
				break;
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class Base_typeContext extends ParserRuleContext {
		public TerminalNode VOID() { return getToken(CodeSensorParser.VOID, 0); }
		public TerminalNode ALPHA_NUMERIC() { return getToken(CodeSensorParser.ALPHA_NUMERIC, 0); }
		public TerminalNode LONG(int i) {
			return getToken(CodeSensorParser.LONG, i);
		}
		public List<TerminalNode> LONG() { return getTokens(CodeSensorParser.LONG); }
		public Base_typeContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_base_type; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof CodeSensorListener ) ((CodeSensorListener)listener).enterBase_type(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof CodeSensorListener ) ((CodeSensorListener)listener).exitBase_type(this);
		}
	}

	public final Base_typeContext base_type() throws RecognitionException {
		Base_typeContext _localctx = new Base_typeContext(_ctx, getState());
		enterRule(_localctx, 154, RULE_base_type);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(789);
			switch ( getInterpreter().adaptivePredict(_input,86,_ctx) ) {
			case 1:
				{
				setState(784); match(ALPHA_NUMERIC);
				}
				break;

			case 2:
				{
				setState(785); match(VOID);
				}
				break;

			case 3:
				{
				setState(786); match(LONG);
				}
				break;

			case 4:
				{
				setState(787); match(LONG);
				setState(788); match(LONG);
				}
				break;
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class Param_decl_specifiersContext extends ParserRuleContext {
		public Type_nameContext type_name() {
			return getRuleContext(Type_nameContext.class,0);
		}
		public TerminalNode REGISTER() { return getToken(CodeSensorParser.REGISTER, 0); }
		public TerminalNode AUTO() { return getToken(CodeSensorParser.AUTO, 0); }
		public Param_decl_specifiersContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_param_decl_specifiers; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof CodeSensorListener ) ((CodeSensorListener)listener).enterParam_decl_specifiers(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof CodeSensorListener ) ((CodeSensorListener)listener).exitParam_decl_specifiers(this);
		}
	}

	public final Param_decl_specifiersContext param_decl_specifiers() throws RecognitionException {
		Param_decl_specifiersContext _localctx = new Param_decl_specifiersContext(_ctx, getState());
		enterRule(_localctx, 156, RULE_param_decl_specifiers);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(792);
			_la = _input.LA(1);
			if (_la==AUTO || _la==REGISTER) {
				{
				setState(791);
				_la = _input.LA(1);
				if ( !(_la==AUTO || _la==REGISTER) ) {
				_errHandler.recoverInline(this);
				}
				consume();
				}
			}

			setState(794); type_name();
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class Parameter_nameContext extends ParserRuleContext {
		public Access_specifierContext access_specifier() {
			return getRuleContext(Access_specifierContext.class,0);
		}
		public IdentifierContext identifier() {
			return getRuleContext(IdentifierContext.class,0);
		}
		public Parameter_nameContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_parameter_name; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof CodeSensorListener ) ((CodeSensorListener)listener).enterParameter_name(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof CodeSensorListener ) ((CodeSensorListener)listener).exitParameter_name(this);
		}
	}

	public final Parameter_nameContext parameter_name() throws RecognitionException {
		Parameter_nameContext _localctx = new Parameter_nameContext(_ctx, getState());
		enterRule(_localctx, 158, RULE_parameter_name);
		try {
			setState(798);
			switch (_input.LA(1)) {
			case ALPHA_NUMERIC:
				enterOuterAlt(_localctx, 1);
				{
				setState(796); identifier();
				}
				break;
			case 24:
			case 30:
			case 44:
				enterOuterAlt(_localctx, 2);
				{
				setState(797); access_specifier();
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class Param_type_listContext extends ParserRuleContext {
		public Param_typeContext param_type(int i) {
			return getRuleContext(Param_typeContext.class,i);
		}
		public List<Param_typeContext> param_type() {
			return getRuleContexts(Param_typeContext.class);
		}
		public TerminalNode VOID() { return getToken(CodeSensorParser.VOID, 0); }
		public Param_type_listContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_param_type_list; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof CodeSensorListener ) ((CodeSensorListener)listener).enterParam_type_list(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof CodeSensorListener ) ((CodeSensorListener)listener).exitParam_type_list(this);
		}
	}

	public final Param_type_listContext param_type_list() throws RecognitionException {
		Param_type_listContext _localctx = new Param_type_listContext(_ctx, getState());
		enterRule(_localctx, 160, RULE_param_type_list);
		int _la;
		try {
			setState(815);
			switch ( getInterpreter().adaptivePredict(_input,91,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(800); match(28);
				setState(801); match(VOID);
				setState(802); match(11);
				}
				break;

			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(803); match(28);
				setState(812);
				_la = _input.LA(1);
				if (((((_la - 66)) & ~0x3f) == 0 && ((1L << (_la - 66)) & ((1L << (VOID - 66)) | (1L << (UNSIGNED - 66)) | (1L << (SIGNED - 66)) | (1L << (LONG - 66)) | (1L << (CV_QUALIFIER - 66)) | (1L << (AUTO - 66)) | (1L << (REGISTER - 66)) | (1L << (CLASS_KEY - 66)) | (1L << (ALPHA_NUMERIC - 66)))) != 0)) {
					{
					setState(804); param_type();
					setState(809);
					_errHandler.sync(this);
					_la = _input.LA(1);
					while (_la==25) {
						{
						{
						setState(805); match(25);
						setState(806); param_type();
						}
						}
						setState(811);
						_errHandler.sync(this);
						_la = _input.LA(1);
					}
					}
				}

				setState(814); match(11);
				}
				break;
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class Param_typeContext extends ParserRuleContext {
		public Param_type_idContext param_type_id() {
			return getRuleContext(Param_type_idContext.class,0);
		}
		public Param_decl_specifiersContext param_decl_specifiers() {
			return getRuleContext(Param_decl_specifiersContext.class,0);
		}
		public Param_typeContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_param_type; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof CodeSensorListener ) ((CodeSensorListener)listener).enterParam_type(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof CodeSensorListener ) ((CodeSensorListener)listener).exitParam_type(this);
		}
	}

	public final Param_typeContext param_type() throws RecognitionException {
		Param_typeContext _localctx = new Param_typeContext(_ctx, getState());
		enterRule(_localctx, 162, RULE_param_type);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(817); param_decl_specifiers();
			setState(818); param_type_id();
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class Param_type_idContext extends ParserRuleContext {
		public Param_type_idContext param_type_id() {
			return getRuleContext(Param_type_idContext.class,0);
		}
		public Type_suffixContext type_suffix() {
			return getRuleContext(Type_suffixContext.class,0);
		}
		public Parameter_nameContext parameter_name() {
			return getRuleContext(Parameter_nameContext.class,0);
		}
		public PtrsContext ptrs() {
			return getRuleContext(PtrsContext.class,0);
		}
		public Param_type_idContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_param_type_id; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof CodeSensorListener ) ((CodeSensorListener)listener).enterParam_type_id(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof CodeSensorListener ) ((CodeSensorListener)listener).exitParam_type_id(this);
		}
	}

	public final Param_type_idContext param_type_id() throws RecognitionException {
		Param_type_idContext _localctx = new Param_type_idContext(_ctx, getState());
		enterRule(_localctx, 164, RULE_param_type_id);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(821);
			_la = _input.LA(1);
			if (_la==1 || _la==2) {
				{
				setState(820); ptrs();
				}
			}

			setState(830);
			switch ( getInterpreter().adaptivePredict(_input,94,_ctx) ) {
			case 1:
				{
				setState(823); match(28);
				setState(824); param_type_id();
				setState(825); match(11);
				}
				break;

			case 2:
				{
				setState(828);
				_la = _input.LA(1);
				if (((((_la - 24)) & ~0x3f) == 0 && ((1L << (_la - 24)) & ((1L << (24 - 24)) | (1L << (30 - 24)) | (1L << (44 - 24)) | (1L << (ALPHA_NUMERIC - 24)))) != 0)) {
					{
					setState(827); parameter_name();
					}
				}

				}
				break;
			}
			setState(833);
			_la = _input.LA(1);
			if (_la==3 || _la==28) {
				{
				setState(832); type_suffix();
				}
			}

			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class IdentifierContext extends ParserRuleContext {
		public TerminalNode ALPHA_NUMERIC(int i) {
			return getToken(CodeSensorParser.ALPHA_NUMERIC, i);
		}
		public List<TerminalNode> ALPHA_NUMERIC() { return getTokens(CodeSensorParser.ALPHA_NUMERIC); }
		public IdentifierContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_identifier; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof CodeSensorListener ) ((CodeSensorListener)listener).enterIdentifier(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof CodeSensorListener ) ((CodeSensorListener)listener).exitIdentifier(this);
		}
	}

	public final IdentifierContext identifier() throws RecognitionException {
		IdentifierContext _localctx = new IdentifierContext(_ctx, getState());
		enterRule(_localctx, 166, RULE_identifier);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(835); match(ALPHA_NUMERIC);
			setState(840);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==14) {
				{
				{
				setState(836); match(14);
				setState(837); match(ALPHA_NUMERIC);
				}
				}
				setState(842);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class NumberContext extends ParserRuleContext {
		public TerminalNode OCTAL_LITERAL() { return getToken(CodeSensorParser.OCTAL_LITERAL, 0); }
		public TerminalNode HEX_LITERAL() { return getToken(CodeSensorParser.HEX_LITERAL, 0); }
		public TerminalNode DECIMAL_LITERAL() { return getToken(CodeSensorParser.DECIMAL_LITERAL, 0); }
		public NumberContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_number; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof CodeSensorListener ) ((CodeSensorListener)listener).enterNumber(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof CodeSensorListener ) ((CodeSensorListener)listener).exitNumber(this);
		}
	}

	public final NumberContext number() throws RecognitionException {
		NumberContext _localctx = new NumberContext(_ctx, getState());
		enterRule(_localctx, 168, RULE_number);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(843);
			_la = _input.LA(1);
			if ( !(((((_la - 90)) & ~0x3f) == 0 && ((1L << (_la - 90)) & ((1L << (HEX_LITERAL - 90)) | (1L << (DECIMAL_LITERAL - 90)) | (1L << (OCTAL_LITERAL - 90)))) != 0)) ) {
			_errHandler.recoverInline(this);
			}
			consume();
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class PtrsContext extends ParserRuleContext {
		public Ptr_operatorContext ptr_operator(int i) {
			return getRuleContext(Ptr_operatorContext.class,i);
		}
		public List<Ptr_operatorContext> ptr_operator() {
			return getRuleContexts(Ptr_operatorContext.class);
		}
		public PtrsContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_ptrs; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof CodeSensorListener ) ((CodeSensorListener)listener).enterPtrs(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof CodeSensorListener ) ((CodeSensorListener)listener).exitPtrs(this);
		}
	}

	public final PtrsContext ptrs() throws RecognitionException {
		PtrsContext _localctx = new PtrsContext(_ctx, getState());
		enterRule(_localctx, 170, RULE_ptrs);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(846); 
			_errHandler.sync(this);
			_la = _input.LA(1);
			do {
				{
				{
				setState(845); ptr_operator();
				}
				}
				setState(848); 
				_errHandler.sync(this);
				_la = _input.LA(1);
			} while ( _la==1 || _la==2 );
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static final String _serializedATN =
		"\2\3e\u0355\4\2\t\2\4\3\t\3\4\4\t\4\4\5\t\5\4\6\t\6\4\7\t\7\4\b\t\b\4"+
		"\t\t\t\4\n\t\n\4\13\t\13\4\f\t\f\4\r\t\r\4\16\t\16\4\17\t\17\4\20\t\20"+
		"\4\21\t\21\4\22\t\22\4\23\t\23\4\24\t\24\4\25\t\25\4\26\t\26\4\27\t\27"+
		"\4\30\t\30\4\31\t\31\4\32\t\32\4\33\t\33\4\34\t\34\4\35\t\35\4\36\t\36"+
		"\4\37\t\37\4 \t \4!\t!\4\"\t\"\4#\t#\4$\t$\4%\t%\4&\t&\4\'\t\'\4(\t(\4"+
		")\t)\4*\t*\4+\t+\4,\t,\4-\t-\4.\t.\4/\t/\4\60\t\60\4\61\t\61\4\62\t\62"+
		"\4\63\t\63\4\64\t\64\4\65\t\65\4\66\t\66\4\67\t\67\48\t8\49\t9\4:\t:\4"+
		";\t;\4<\t<\4=\t=\4>\t>\4?\t?\4@\t@\4A\tA\4B\tB\4C\tC\4D\tD\4E\tE\4F\t"+
		"F\4G\tG\4H\tH\4I\tI\4J\tJ\4K\tK\4L\tL\4M\tM\4N\tN\4O\tO\4P\tP\4Q\tQ\4"+
		"R\tR\4S\tS\4T\tT\4U\tU\4V\tV\4W\tW\3\2\3\2\3\2\3\2\7\2\u00b3\n\2\f\2\16"+
		"\2\u00b6\13\2\3\3\3\3\3\3\3\3\3\3\3\4\3\4\3\4\5\4\u00c0\n\4\3\5\3\5\3"+
		"\5\3\5\5\5\u00c6\n\5\3\6\3\6\3\6\3\6\3\6\3\6\5\6\u00ce\n\6\3\7\3\7\3\7"+
		"\5\7\u00d3\n\7\3\b\3\b\3\b\5\b\u00d8\n\b\3\t\3\t\3\t\5\t\u00dd\n\t\3\n"+
		"\3\n\3\n\5\n\u00e2\n\n\3\13\3\13\3\13\5\13\u00e7\n\13\3\f\3\f\3\f\3\f"+
		"\5\f\u00ed\n\f\3\r\3\r\3\r\3\r\5\r\u00f3\n\r\3\16\3\16\3\16\5\16\u00f8"+
		"\n\16\3\17\3\17\3\17\5\17\u00fd\n\17\3\20\3\20\3\20\5\20\u0102\n\20\3"+
		"\21\3\21\3\21\7\21\u0107\n\21\f\21\16\21\u010a\13\21\3\21\3\21\3\21\3"+
		"\21\5\21\u0110\n\21\3\22\3\22\3\22\3\22\3\22\7\22\u0117\n\22\f\22\16\22"+
		"\u011a\13\22\3\22\5\22\u011d\n\22\3\23\3\23\3\23\3\23\5\23\u0123\n\23"+
		"\3\24\3\24\7\24\u0127\n\24\f\24\16\24\u012a\13\24\3\25\3\25\3\25\3\25"+
		"\5\25\u0130\n\25\3\26\3\26\3\27\3\27\3\27\3\27\7\27\u0138\n\27\f\27\16"+
		"\27\u013b\13\27\5\27\u013d\n\27\3\27\3\27\3\30\3\30\3\31\3\31\3\31\3\31"+
		"\3\31\3\31\3\31\3\31\5\31\u014b\n\31\3\31\3\31\5\31\u014f\n\31\3\32\3"+
		"\32\3\32\3\32\3\32\3\32\5\32\u0157\n\32\3\33\3\33\3\34\3\34\3\35\3\35"+
		"\3\36\3\36\3\37\3\37\3 \3 \3!\3!\3!\3\"\3\"\3\"\5\"\u016b\n\"\3\"\3\""+
		"\3\"\3\"\3\"\3\"\3\"\3\"\3\"\3\"\3\"\3\"\3\"\3\"\3\"\3\"\3\"\3\"\3\"\3"+
		"\"\3\"\3\"\3\"\3\"\3\"\3\"\3\"\3\"\3\"\3\"\3\"\3\"\3\"\3\"\3\"\3\"\3\""+
		"\3\"\3\"\3\"\5\"\u0195\n\"\3#\3#\3$\3$\3%\3%\3%\3&\3&\3&\3&\3&\3&\3&\3"+
		"&\3&\3&\7&\u01a8\n&\f&\16&\u01ab\13&\3&\3&\3\'\3\'\3(\3(\3)\3)\3*\3*\3"+
		"+\3+\3,\3,\3-\3-\3.\3.\3/\3/\3\60\3\60\3\61\3\61\3\62\5\62\u01c6\n\62"+
		"\3\62\5\62\u01c9\n\62\3\62\3\62\3\62\5\62\u01ce\n\62\3\62\3\62\3\63\7"+
		"\63\u01d3\n\63\f\63\16\63\u01d6\13\63\3\63\3\63\3\63\7\63\u01db\n\63\f"+
		"\63\16\63\u01de\13\63\3\64\3\64\5\64\u01e2\n\64\3\64\3\64\7\64\u01e6\n"+
		"\64\f\64\16\64\u01e9\13\64\3\64\5\64\u01ec\n\64\3\65\3\65\3\65\7\65\u01f1"+
		"\n\65\f\65\16\65\u01f4\13\65\3\65\3\65\5\65\u01f8\n\65\3\65\5\65\u01fb"+
		"\n\65\3\66\3\66\3\66\3\67\5\67\u0201\n\67\3\67\3\67\3\67\3\67\3\67\5\67"+
		"\u0208\n\67\3\67\5\67\u020b\n\67\38\38\38\39\39\39\39\79\u0214\n9\f9\16"+
		"9\u0217\139\3:\3:\3:\3;\5;\u021d\n;\3;\3;\3<\3<\5<\u0223\n<\3<\3<\3=\3"+
		"=\3=\3=\3=\3=\5=\u022d\n=\3>\3>\3>\3>\3>\3?\7?\u0235\n?\f?\16?\u0238\13"+
		"?\3?\3?\3?\3?\7?\u023e\n?\f?\16?\u0241\13?\7?\u0243\n?\f?\16?\u0246\13"+
		"?\3@\5@\u0249\n@\3@\3@\5@\u024d\n@\3@\3@\5@\u0251\n@\3@\3@\3@\5@\u0256"+
		"\n@\3A\3A\3A\3A\3A\5A\u025d\nA\3B\7B\u0260\nB\fB\16B\u0263\13B\3B\3B\3"+
		"B\3B\3B\3B\3B\3B\3B\3B\3B\3B\5B\u0271\nB\3B\7B\u0274\nB\fB\16B\u0277\13"+
		"B\7B\u0279\nB\fB\16B\u027c\13B\3C\7C\u027f\nC\fC\16C\u0282\13C\3C\3C\3"+
		"C\3C\3C\3C\3C\3C\3C\3C\3C\3C\5C\u0290\nC\3C\7C\u0293\nC\fC\16C\u0296\13"+
		"C\7C\u0298\nC\fC\16C\u029b\13C\3D\7D\u029e\nD\fD\16D\u02a1\13D\3D\3D\3"+
		"D\3D\7D\u02a7\nD\fD\16D\u02aa\13D\7D\u02ac\nD\fD\16D\u02af\13D\3E\5E\u02b2"+
		"\nE\3E\5E\u02b5\nE\3E\3E\3F\3F\5F\u02bb\nF\3F\3F\3F\5F\u02c0\nF\3G\3G"+
		"\3G\7G\u02c5\nG\fG\16G\u02c8\13G\3G\3G\3H\3H\3H\3H\3H\5H\u02d1\nH\3I\3"+
		"I\3I\7I\u02d6\nI\fI\16I\u02d9\13I\3J\3J\5J\u02dd\nJ\3J\5J\u02e0\nJ\3J"+
		"\3J\3J\3K\3K\3L\3L\3L\3L\7L\u02eb\nL\fL\16L\u02ee\13L\3M\5M\u02f1\nM\3"+
		"M\5M\u02f4\nM\3M\3M\3N\7N\u02f9\nN\fN\16N\u02fc\13N\3N\5N\u02ff\nN\3N"+
		"\3N\5N\u0303\nN\3N\3N\3N\5N\u0308\nN\7N\u030a\nN\fN\16N\u030d\13N\3N\3"+
		"N\5N\u0311\nN\3O\3O\3O\3O\3O\5O\u0318\nO\3P\5P\u031b\nP\3P\3P\3Q\3Q\5"+
		"Q\u0321\nQ\3R\3R\3R\3R\3R\3R\3R\7R\u032a\nR\fR\16R\u032d\13R\5R\u032f"+
		"\nR\3R\5R\u0332\nR\3S\3S\3S\3T\5T\u0338\nT\3T\3T\3T\3T\3T\5T\u033f\nT"+
		"\5T\u0341\nT\3T\5T\u0344\nT\3U\3U\3U\7U\u0349\nU\fU\16U\u034c\13U\3V\3"+
		"V\3W\6W\u0351\nW\rW\16W\u0352\3W\2X\2\4\6\b\n\f\16\20\22\24\26\30\32\34"+
		"\36 \"$&(*,.\60\62\64\668:<>@BDFHJLNPRTVXZ\\^`bdfhjlnprtvxz|~\u0080\u0082"+
		"\u0084\u0086\u0088\u008a\u008c\u008e\u0090\u0092\u0094\u0096\u0098\u009a"+
		"\u009c\u009e\u00a0\u00a2\u00a4\u00a6\u00a8\u00aa\u00ac\2\33\4\t\t))\4"+
		"\34\34--\5\4\4\n\n\64\64\7\3\4\25\25\34\34--\66\66\5\b\b\67\67WX\3\\a"+
		"\5\16\17&\'II\3\3\4\5\32\32  ..\4\23\23**\t\f\f\21\22\27\30\37\37\"\""+
		"$%\62\63\4\7\7\65\65\4\r\r\36\36\7\5\5\r\r\26\26\36\36UV\5\r\r\36\36/"+
		"/\5\r\r\36\36WX\3UV\4\5\5\26\26\5\5\5\26\26//\4\33\33//\t\5\5\r\r\26\26"+
		"\33\33\36\36//UV\7\5\5\r\r\26\26\36\36UV\4EFSS\3OP\3\\^\u0393\2\u00b4"+
		"\3\2\2\2\4\u00b7\3\2\2\2\6\u00bc\3\2\2\2\b\u00c1\3\2\2\2\n\u00c7\3\2\2"+
		"\2\f\u00cf\3\2\2\2\16\u00d4\3\2\2\2\20\u00d9\3\2\2\2\22\u00de\3\2\2\2"+
		"\24\u00e3\3\2\2\2\26\u00e8\3\2\2\2\30\u00ee\3\2\2\2\32\u00f4\3\2\2\2\34"+
		"\u00f9\3\2\2\2\36\u00fe\3\2\2\2 \u010f\3\2\2\2\"\u011c\3\2\2\2$\u0122"+
		"\3\2\2\2&\u0124\3\2\2\2(\u012f\3\2\2\2*\u0131\3\2\2\2,\u0133\3\2\2\2."+
		"\u0140\3\2\2\2\60\u014e\3\2\2\2\62\u0156\3\2\2\2\64\u0158\3\2\2\2\66\u015a"+
		"\3\2\2\28\u015c\3\2\2\2:\u015e\3\2\2\2<\u0160\3\2\2\2>\u0162\3\2\2\2@"+
		"\u0164\3\2\2\2B\u0194\3\2\2\2D\u0196\3\2\2\2F\u0198\3\2\2\2H\u019a\3\2"+
		"\2\2J\u019d\3\2\2\2L\u01ae\3\2\2\2N\u01b0\3\2\2\2P\u01b2\3\2\2\2R\u01b4"+
		"\3\2\2\2T\u01b6\3\2\2\2V\u01b8\3\2\2\2X\u01ba\3\2\2\2Z\u01bc\3\2\2\2\\"+
		"\u01be\3\2\2\2^\u01c0\3\2\2\2`\u01c2\3\2\2\2b\u01c5\3\2\2\2d\u01d4\3\2"+
		"\2\2f\u01df\3\2\2\2h\u01fa\3\2\2\2j\u01fc\3\2\2\2l\u0200\3\2\2\2n\u020c"+
		"\3\2\2\2p\u020f\3\2\2\2r\u0218\3\2\2\2t\u021c\3\2\2\2v\u0220\3\2\2\2x"+
		"\u022c\3\2\2\2z\u022e\3\2\2\2|\u0236\3\2\2\2~\u0248\3\2\2\2\u0080\u025c"+
		"\3\2\2\2\u0082\u0261\3\2\2\2\u0084\u0280\3\2\2\2\u0086\u029f\3\2\2\2\u0088"+
		"\u02b1\3\2\2\2\u008a\u02bf\3\2\2\2\u008c\u02c1\3\2\2\2\u008e\u02d0\3\2"+
		"\2\2\u0090\u02d2\3\2\2\2\u0092\u02da\3\2\2\2\u0094\u02e4\3\2\2\2\u0096"+
		"\u02e6\3\2\2\2\u0098\u02f0\3\2\2\2\u009a\u0310\3\2\2\2\u009c\u0317\3\2"+
		"\2\2\u009e\u031a\3\2\2\2\u00a0\u0320\3\2\2\2\u00a2\u0331\3\2\2\2\u00a4"+
		"\u0333\3\2\2\2\u00a6\u0337\3\2\2\2\u00a8\u0345\3\2\2\2\u00aa\u034d\3\2"+
		"\2\2\u00ac\u0350\3\2\2\2\u00ae\u00b3\5b\62\2\u00af\u00b3\5\u0088E\2\u00b0"+
		"\u00b3\5\4\3\2\u00b1\u00b3\5`\61\2\u00b2\u00ae\3\2\2\2\u00b2\u00af\3\2"+
		"\2\2\u00b2\u00b0\3\2\2\2\u00b2\u00b1\3\2\2\2\u00b3\u00b6\3\2\2\2\u00b4"+
		"\u00b2\3\2\2\2\u00b4\u00b5\3\2\2\2\u00b5\3\3\2\2\2\u00b6\u00b4\3\2\2\2"+
		"\u00b7\u00b8\7M\2\2\u00b8\u00b9\7N\2\2\u00b9\u00ba\5\u00a8U\2\u00ba\u00bb"+
		"\7/\2\2\u00bb\5\3\2\2\2\u00bc\u00bf\5\b\5\2\u00bd\u00be\7\33\2\2\u00be"+
		"\u00c0\5\b\5\2\u00bf\u00bd\3\2\2\2\u00bf\u00c0\3\2\2\2\u00c0\7\3\2\2\2"+
		"\u00c1\u00c5\5\n\6\2\u00c2\u00c3\5D#\2\u00c3\u00c4\5\b\5\2\u00c4\u00c6"+
		"\3\2\2\2\u00c5\u00c2\3\2\2\2\u00c5\u00c6\3\2\2\2\u00c6\t\3\2\2\2\u00c7"+
		"\u00cd\5\f\7\2\u00c8\u00c9\7!\2\2\u00c9\u00ca\5\6\4\2\u00ca\u00cb\7\35"+
		"\2\2\u00cb\u00cc\5\n\6\2\u00cc\u00ce\3\2\2\2\u00cd\u00c8\3\2\2\2\u00cd"+
		"\u00ce\3\2\2\2\u00ce\13\3\2\2\2\u00cf\u00d2\5\16\b\2\u00d0\u00d1\7\61"+
		"\2\2\u00d1\u00d3\5\f\7\2\u00d2\u00d0\3\2\2\2\u00d2\u00d3\3\2\2\2\u00d3"+
		"\r\3\2\2\2\u00d4\u00d7\5\20\t\2\u00d5\u00d6\7\60\2\2\u00d6\u00d8\5\16"+
		"\b\2\u00d7\u00d5\3\2\2\2\u00d7\u00d8\3\2\2\2\u00d8\17\3\2\2\2\u00d9\u00dc"+
		"\5\22\n\2\u00da\u00db\7\24\2\2\u00db\u00dd\5\20\t\2\u00dc\u00da\3\2\2"+
		"\2\u00dc\u00dd\3\2\2\2\u00dd\21\3\2\2\2\u00de\u00e1\5\24\13\2\u00df\u00e0"+
		"\7+\2\2\u00e0\u00e2\5\22\n\2\u00e1\u00df\3\2\2\2\u00e1\u00e2\3\2\2\2\u00e2"+
		"\23\3\2\2\2\u00e3\u00e6\5\26\f\2\u00e4\u00e5\7\3\2\2\u00e5\u00e7\5\24"+
		"\13\2\u00e6\u00e4\3\2\2\2\u00e6\u00e7\3\2\2\2\u00e7\25\3\2\2\2\u00e8\u00ec"+
		"\5\30\r\2\u00e9\u00ea\5F$\2\u00ea\u00eb\5\26\f\2\u00eb\u00ed\3\2\2\2\u00ec"+
		"\u00e9\3\2\2\2\u00ec\u00ed\3\2\2\2\u00ed\27\3\2\2\2\u00ee\u00f2\5\32\16"+
		"\2\u00ef\u00f0\5\66\34\2\u00f0\u00f1\5\30\r\2\u00f1\u00f3\3\2\2\2\u00f2"+
		"\u00ef\3\2\2\2\u00f2\u00f3\3\2\2\2\u00f3\31\3\2\2\2\u00f4\u00f7\5\34\17"+
		"\2\u00f5\u00f6\t\2\2\2\u00f6\u00f8\5\32\16\2\u00f7\u00f5\3\2\2\2\u00f7"+
		"\u00f8\3\2\2\2\u00f8\33\3\2\2\2\u00f9\u00fc\5\36\20\2\u00fa\u00fb\t\3"+
		"\2\2\u00fb\u00fd\5\34\17\2\u00fc\u00fa\3\2\2\2\u00fc\u00fd\3\2\2\2\u00fd"+
		"\35\3\2\2\2\u00fe\u0101\5 \21\2\u00ff\u0100\t\4\2\2\u0100\u0102\5 \21"+
		"\2\u0101\u00ff\3\2\2\2\u0101\u0102\3\2\2\2\u0102\37\3\2\2\2\u0103\u0104"+
		"\7\36\2\2\u0104\u0108\5\u009aN\2\u0105\u0107\5<\37\2\u0106\u0105\3\2\2"+
		"\2\u0107\u010a\3\2\2\2\u0108\u0106\3\2\2\2\u0108\u0109\3\2\2\2\u0109\u010b"+
		"\3\2\2\2\u010a\u0108\3\2\2\2\u010b\u010c\7\r\2\2\u010c\u010d\5 \21\2\u010d"+
		"\u0110\3\2\2\2\u010e\u0110\5\"\22\2\u010f\u0103\3\2\2\2\u010f\u010e\3"+
		"\2\2\2\u0110!\3\2\2\2\u0111\u0112\7\6\2\2\u0112\u011d\5\"\22\2\u0113\u0114"+
		"\7(\2\2\u0114\u011d\5\"\22\2\u0115\u0117\5\64\33\2\u0116\u0115\3\2\2\2"+
		"\u0117\u011a\3\2\2\2\u0118\u0116\3\2\2\2\u0118\u0119\3\2\2\2\u0119\u011b"+
		"\3\2\2\2\u011a\u0118\3\2\2\2\u011b\u011d\5$\23\2\u011c\u0111\3\2\2\2\u011c"+
		"\u0113\3\2\2\2\u011c\u0118\3\2\2\2\u011d#\3\2\2\2\u011e\u011f\5&\24\2"+
		"\u011f\u0120\5(\25\2\u0120\u0123\3\2\2\2\u0121\u0123\5&\24\2\u0122\u011e"+
		"\3\2\2\2\u0122\u0121\3\2\2\2\u0123%\3\2\2\2\u0124\u0128\5\62\32\2\u0125"+
		"\u0127\5\60\31\2\u0126\u0125\3\2\2\2\u0127\u012a\3\2\2\2\u0128\u0126\3"+
		"\2\2\2\u0128\u0129\3\2\2\2\u0129\'\3\2\2\2\u012a\u0128\3\2\2\2\u012b\u012c"+
		"\5*\26\2\u012c\u012d\5,\27\2\u012d\u0130\3\2\2\2\u012e\u0130\5,\27\2\u012f"+
		"\u012b\3\2\2\2\u012f\u012e\3\2\2\2\u0130)\3\2\2\2\u0131\u0132\5J&\2\u0132"+
		"+\3\2\2\2\u0133\u013c\7\36\2\2\u0134\u0139\5.\30\2\u0135\u0136\7\33\2"+
		"\2\u0136\u0138\5.\30\2\u0137\u0135\3\2\2\2\u0138\u013b\3\2\2\2\u0139\u0137"+
		"\3\2\2\2\u0139\u013a\3\2\2\2\u013a\u013d\3\2\2\2\u013b\u0139\3\2\2\2\u013c"+
		"\u0134\3\2\2\2\u013c\u013d\3\2\2\2\u013d\u013e\3\2\2\2\u013e\u013f\7\r"+
		"\2\2\u013f-\3\2\2\2\u0140\u0141\5\b\5\2\u0141/\3\2\2\2\u0142\u0143\7,"+
		"\2\2\u0143\u014b\5\u00a8U\2\u0144\u0145\7\13\2\2\u0145\u014b\5\u00a8U"+
		"\2\u0146\u0147\7\5\2\2\u0147\u0148\5\6\4\2\u0148\u0149\7\26\2\2\u0149"+
		"\u014b\3\2\2\2\u014a\u0142\3\2\2\2\u014a\u0144\3\2\2\2\u014a\u0146\3\2"+
		"\2\2\u014b\u014f\3\2\2\2\u014c\u014f\7(\2\2\u014d\u014f\7\6\2\2\u014e"+
		"\u014a\3\2\2\2\u014e\u014c\3\2\2\2\u014e\u014d\3\2\2\2\u014f\61\3\2\2"+
		"\2\u0150\u0157\5\u00a8U\2\u0151\u0157\58\35\2\u0152\u0153\7\36\2\2\u0153"+
		"\u0154\5\6\4\2\u0154\u0155\7\r\2\2\u0155\u0157\3\2\2\2\u0156\u0150\3\2"+
		"\2\2\u0156\u0151\3\2\2\2\u0156\u0152\3\2\2\2\u0157\63\3\2\2\2\u0158\u0159"+
		"\t\5\2\2\u0159\65\3\2\2\2\u015a\u015b\t\6\2\2\u015b\67\3\2\2\2\u015c\u015d"+
		"\t\7\2\2\u015d9\3\2\2\2\u015e\u015f\t\b\2\2\u015f;\3\2\2\2\u0160\u0161"+
		"\t\t\2\2\u0161=\3\2\2\2\u0162\u0163\t\n\2\2\u0163?\3\2\2\2\u0164\u0165"+
		"\7Q\2\2\u0165\u0166\5B\"\2\u0166A\3\2\2\2\u0167\u016a\t\13\2\2\u0168\u0169"+
		"\7\5\2\2\u0169\u016b\7\26\2\2\u016a\u0168\3\2\2\2\u016a\u016b\3\2\2\2"+
		"\u016b\u0195\3\2\2\2\u016c\u0195\7-\2\2\u016d\u0195\7\34\2\2\u016e\u0195"+
		"\7\4\2\2\u016f\u0195\7\64\2\2\u0170\u0195\7\n\2\2\u0171\u0195\7+\2\2\u0172"+
		"\u0195\7\3\2\2\u0173\u0195\7\24\2\2\u0174\u0195\7\66\2\2\u0175\u0195\7"+
		"\25\2\2\u0176\u0195\7\21\2\2\u0177\u0195\7W\2\2\u0178\u0195\7X\2\2\u0179"+
		"\u0195\7$\2\2\u017a\u0195\7\30\2\2\u017b\u0195\7\f\2\2\u017c\u0195\7\63"+
		"\2\2\u017d\u0195\7\62\2\2\u017e\u0195\7%\2\2\u017f\u0195\7\37\2\2\u0180"+
		"\u0195\7\22\2\2\u0181\u0195\7)\2\2\u0182\u0195\7\t\2\2\u0183\u0195\7\""+
		"\2\2\u0184\u0195\7\27\2\2\u0185\u0195\7\65\2\2\u0186\u0195\7\7\2\2\u0187"+
		"\u0195\7\b\2\2\u0188\u0195\7\67\2\2\u0189\u0195\7\60\2\2\u018a\u0195\7"+
		"\61\2\2\u018b\u0195\7(\2\2\u018c\u0195\7\6\2\2\u018d\u0195\7\33\2\2\u018e"+
		"\u0195\7\31\2\2\u018f\u0195\7\13\2\2\u0190\u0191\7\36\2\2\u0191\u0195"+
		"\7\r\2\2\u0192\u0193\7\5\2\2\u0193\u0195\7\26\2\2\u0194\u0167\3\2\2\2"+
		"\u0194\u016c\3\2\2\2\u0194\u016d\3\2\2\2\u0194\u016e\3\2\2\2\u0194\u016f"+
		"\3\2\2\2\u0194\u0170\3\2\2\2\u0194\u0171\3\2\2\2\u0194\u0172\3\2\2\2\u0194"+
		"\u0173\3\2\2\2\u0194\u0174\3\2\2\2\u0194\u0175\3\2\2\2\u0194\u0176\3\2"+
		"\2\2\u0194\u0177\3\2\2\2\u0194\u0178\3\2\2\2\u0194\u0179\3\2\2\2\u0194"+
		"\u017a\3\2\2\2\u0194\u017b\3\2\2\2\u0194\u017c\3\2\2\2\u0194\u017d\3\2"+
		"\2\2\u0194\u017e\3\2\2\2\u0194\u017f\3\2\2\2\u0194\u0180\3\2\2\2\u0194"+
		"\u0181\3\2\2\2\u0194\u0182\3\2\2\2\u0194\u0183\3\2\2\2\u0194\u0184\3\2"+
		"\2\2\u0194\u0185\3\2\2\2\u0194\u0186\3\2\2\2\u0194\u0187\3\2\2\2\u0194"+
		"\u0188\3\2\2\2\u0194\u0189\3\2\2\2\u0194\u018a\3\2\2\2\u0194\u018b\3\2"+
		"\2\2\u0194\u018c\3\2\2\2\u0194\u018d\3\2\2\2\u0194\u018e\3\2\2\2\u0194"+
		"\u018f\3\2\2\2\u0194\u0190\3\2\2\2\u0194\u0192\3\2\2\2\u0195C\3\2\2\2"+
		"\u0196\u0197\t\f\2\2\u0197E\3\2\2\2\u0198\u0199\t\r\2\2\u0199G\3\2\2\2"+
		"\u019a\u019b\7R\2\2\u019b\u019c\5J&\2\u019cI\3\2\2\2\u019d\u01a9\7W\2"+
		"\2\u019e\u019f\7W\2\2\u019f\u01a0\5J&\2\u01a0\u01a1\7X\2\2\u01a1\u01a8"+
		"\3\2\2\2\u01a2\u01a3\7\36\2\2\u01a3\u01a4\5J&\2\u01a4\u01a5\7\r\2\2\u01a5"+
		"\u01a8\3\2\2\2\u01a6\u01a8\5R*\2\u01a7\u019e\3\2\2\2\u01a7\u01a2\3\2\2"+
		"\2\u01a7\u01a6\3\2\2\2\u01a8\u01ab\3\2\2\2\u01a9\u01a7\3\2\2\2\u01a9\u01aa"+
		"\3\2\2\2\u01aa\u01ac\3\2\2\2\u01ab\u01a9\3\2\2\2\u01ac\u01ad\7X\2\2\u01ad"+
		"K\3\2\2\2\u01ae\u01af\n\16\2\2\u01afM\3\2\2\2\u01b0\u01b1\n\17\2\2\u01b1"+
		"O\3\2\2\2\u01b2\u01b3\n\20\2\2\u01b3Q\3\2\2\2\u01b4\u01b5\n\21\2\2\u01b5"+
		"S\3\2\2\2\u01b6\u01b7\n\22\2\2\u01b7U\3\2\2\2\u01b8\u01b9\n\23\2\2\u01b9"+
		"W\3\2\2\2\u01ba\u01bb\n\24\2\2\u01bbY\3\2\2\2\u01bc\u01bd\n\25\2\2\u01bd"+
		"[\3\2\2\2\u01be\u01bf\n\26\2\2\u01bf]\3\2\2\2\u01c0\u01c1\n\27\2\2\u01c1"+
		"_\3\2\2\2\u01c2\u01c3\13\2\2\2\u01c3a\3\2\2\2\u01c4\u01c6\5H%\2\u01c5"+
		"\u01c4\3\2\2\2\u01c5\u01c6\3\2\2\2\u01c6\u01c8\3\2\2\2\u01c7\u01c9\5d"+
		"\63\2\u01c8\u01c7\3\2\2\2\u01c8\u01c9\3\2\2\2\u01c9\u01ca\3\2\2\2\u01ca"+
		"\u01cb\5x=\2\u01cb\u01cd\5f\64\2\u01cc\u01ce\5p9\2\u01cd\u01cc\3\2\2\2"+
		"\u01cd\u01ce\3\2\2\2\u01ce\u01cf\3\2\2\2\u01cf\u01d0\5n8\2\u01d0c\3\2"+
		"\2\2\u01d1\u01d3\5:\36\2\u01d2\u01d1\3\2\2\2\u01d3\u01d6\3\2\2\2\u01d4"+
		"\u01d2\3\2\2\2\u01d4\u01d5\3\2\2\2\u01d5\u01d7\3\2\2\2\u01d6\u01d4\3\2"+
		"\2\2\u01d7\u01d8\5\u009aN\2\u01d8\u01dc\3\2\2\2\u01d9\u01db\5<\37\2\u01da"+
		"\u01d9\3\2\2\2\u01db\u01de\3\2\2\2\u01dc\u01da\3\2\2\2\u01dc\u01dd\3\2"+
		"\2\2\u01dde\3\2\2\2\u01de\u01dc\3\2\2\2\u01df\u01e1\7\36\2\2\u01e0\u01e2"+
		"\5h\65\2\u01e1\u01e0\3\2\2\2\u01e1\u01e2\3\2\2\2\u01e2\u01e3\3\2\2\2\u01e3"+
		"\u01e7\7\r\2\2\u01e4\u01e6\7H\2\2\u01e5\u01e4\3\2\2\2\u01e6\u01e9\3\2"+
		"\2\2\u01e7\u01e5\3\2\2\2\u01e7\u01e8\3\2\2\2\u01e8\u01eb\3\2\2\2\u01e9"+
		"\u01e7\3\2\2\2\u01ea\u01ec\5z>\2\u01eb\u01ea\3\2\2\2\u01eb\u01ec\3\2\2"+
		"\2\u01ecg\3\2\2\2\u01ed\u01f2\5j\66\2\u01ee\u01ef\7\33\2\2\u01ef\u01f1"+
		"\5j\66\2\u01f0\u01ee\3\2\2\2\u01f1\u01f4\3\2\2\2\u01f2\u01f0\3\2\2\2\u01f2"+
		"\u01f3\3\2\2\2\u01f3\u01f7\3\2\2\2\u01f4\u01f2\3\2\2\2\u01f5\u01f6\7\33"+
		"\2\2\u01f6\u01f8\7#\2\2\u01f7\u01f5\3\2\2\2\u01f7\u01f8\3\2\2\2\u01f8"+
		"\u01fb\3\2\2\2\u01f9\u01fb\7D\2\2\u01fa\u01ed\3\2\2\2\u01fa\u01f9\3\2"+
		"\2\2\u01fbi\3\2\2\2\u01fc\u01fd\5\u009eP\2\u01fd\u01fe\5l\67\2\u01fek"+
		"\3\2\2\2\u01ff\u0201\5\u00acW\2\u0200\u01ff\3\2\2\2\u0200\u0201\3\2\2"+
		"\2\u0201\u0207\3\2\2\2\u0202\u0203\7\36\2\2\u0203\u0204\5l\67\2\u0204"+
		"\u0205\7\r\2\2\u0205\u0208\3\2\2\2\u0206\u0208\5\u00a0Q\2\u0207\u0202"+
		"\3\2\2\2\u0207\u0206\3\2\2\2\u0208\u020a\3\2\2\2\u0209\u020b\5\u0080A"+
		"\2\u020a\u0209\3\2\2\2\u020a\u020b\3\2\2\2\u020bm\3\2\2\2\u020c\u020d"+
		"\7U\2\2\u020d\u020e\b8\1\2\u020eo\3\2\2\2\u020f\u0210\7\35\2\2\u0210\u0215"+
		"\5r:\2\u0211\u0212\7\33\2\2\u0212\u0214\5r:\2\u0213\u0211\3\2\2\2\u0214"+
		"\u0217\3\2\2\2\u0215\u0213\3\2\2\2\u0215\u0216\3\2\2\2\u0216q\3\2\2\2"+
		"\u0217\u0215\3\2\2\2\u0218\u0219\5t;\2\u0219\u021a\5v<\2\u021as\3\2\2"+
		"\2\u021b\u021d\7\20\2\2\u021c\u021b\3\2\2\2\u021c\u021d\3\2\2\2\u021d"+
		"\u021e\3\2\2\2\u021e\u021f\5\u00a8U\2\u021fu\3\2\2\2\u0220\u0222\7\36"+
		"\2\2\u0221\u0223\5\6\4\2\u0222\u0221\3\2\2\2\u0222\u0223\3\2\2\2\u0223"+
		"\u0224\3\2\2\2\u0224\u0225\7\r\2\2\u0225w\3\2\2\2\u0226\u0227\7\36\2\2"+
		"\u0227\u0228\5x=\2\u0228\u0229\7\r\2\2\u0229\u022d\3\2\2\2\u022a\u022d"+
		"\5\u00a8U\2\u022b\u022d\5@!\2\u022c\u0226\3\2\2\2\u022c\u022a\3\2\2\2"+
		"\u022c\u022b\3\2\2\2\u022dy\3\2\2\2\u022e\u022f\7L\2\2\u022f\u0230\7\36"+
		"\2\2\u0230\u0231\5|?\2\u0231\u0232\7\r\2\2\u0232{\3\2\2\2\u0233\u0235"+
		"\5L\'\2\u0234\u0233\3\2\2\2\u0235\u0238\3\2\2\2\u0236\u0234\3\2\2\2\u0236"+
		"\u0237\3\2\2\2\u0237\u0244\3\2\2\2\u0238\u0236\3\2\2\2\u0239\u023a\7\36"+
		"\2\2\u023a\u023b\5|?\2\u023b\u023f\7\r\2\2\u023c\u023e\5L\'\2\u023d\u023c"+
		"\3\2\2\2\u023e\u0241\3\2\2\2\u023f\u023d\3\2\2\2\u023f\u0240\3\2\2\2\u0240"+
		"\u0243\3\2\2\2\u0241\u023f\3\2\2\2\u0242\u0239\3\2\2\2\u0243\u0246\3\2"+
		"\2\2\u0244\u0242\3\2\2\2\u0244\u0245\3\2\2\2\u0245}\3\2\2\2\u0246\u0244"+
		"\3\2\2\2\u0247\u0249\5\u00acW\2\u0248\u0247\3\2\2\2\u0248\u0249\3\2\2"+
		"\2\u0249\u024a\3\2\2\2\u024a\u024c\5\u00a8U\2\u024b\u024d\5\u0080A\2\u024c"+
		"\u024b\3\2\2\2\u024c\u024d\3\2\2\2\u024d\u0255\3\2\2\2\u024e\u0250\7\36"+
		"\2\2\u024f\u0251\5\6\4\2\u0250\u024f\3\2\2\2\u0250\u0251\3\2\2\2\u0251"+
		"\u0252\3\2\2\2\u0252\u0256\7\r\2\2\u0253\u0254\7\21\2\2\u0254\u0256\5"+
		"\u0082B\2\u0255\u024e\3\2\2\2\u0255\u0253\3\2\2\2\u0255\u0256\3\2\2\2"+
		"\u0256\177\3\2\2\2\u0257\u0258\7\5\2\2\u0258\u0259\5\u0086D\2\u0259\u025a"+
		"\7\26\2\2\u025a\u025d\3\2\2\2\u025b\u025d\5\u00a2R\2\u025c\u0257\3\2\2"+
		"\2\u025c\u025b\3\2\2\2\u025d\u0081\3\2\2\2\u025e\u0260\5\\/\2\u025f\u025e"+
		"\3\2\2\2\u0260\u0263\3\2\2\2\u0261\u025f\3\2\2\2\u0261\u0262\3\2\2\2\u0262"+
		"\u027a\3\2\2\2\u0263\u0261\3\2\2\2\u0264\u0265\7U\2\2\u0265\u0266\5\u0084"+
		"C\2\u0266\u0267\7V\2\2\u0267\u0271\3\2\2\2\u0268\u0269\7\36\2\2\u0269"+
		"\u026a\5\u0084C\2\u026a\u026b\7\r\2\2\u026b\u0271\3\2\2\2\u026c\u026d"+
		"\7\5\2\2\u026d\u026e\5\u0084C\2\u026e\u026f\7\26\2\2\u026f\u0271\3\2\2"+
		"\2\u0270\u0264\3\2\2\2\u0270\u0268\3\2\2\2\u0270\u026c\3\2\2\2\u0271\u0275"+
		"\3\2\2\2\u0272\u0274\5\\/\2\u0273\u0272\3\2\2\2\u0274\u0277\3\2\2\2\u0275"+
		"\u0273\3\2\2\2\u0275\u0276\3\2\2\2\u0276\u0279\3\2\2\2\u0277\u0275\3\2"+
		"\2\2\u0278\u0270\3\2\2\2\u0279\u027c\3\2\2\2\u027a\u0278\3\2\2\2\u027a"+
		"\u027b\3\2\2\2\u027b\u0083\3\2\2\2\u027c\u027a\3\2\2\2\u027d\u027f\5^"+
		"\60\2\u027e\u027d\3\2\2\2\u027f\u0282\3\2\2\2\u0280\u027e\3\2\2\2\u0280"+
		"\u0281\3\2\2\2\u0281\u0299\3\2\2\2\u0282\u0280\3\2\2\2\u0283\u0284\7U"+
		"\2\2\u0284\u0285\5\u0084C\2\u0285\u0286\7V\2\2\u0286\u0290\3\2\2\2\u0287"+
		"\u0288\7\36\2\2\u0288\u0289\5\u0084C\2\u0289\u028a\7\r\2\2\u028a\u0290"+
		"\3\2\2\2\u028b\u028c\7\5\2\2\u028c\u028d\5\u0084C\2\u028d\u028e\7\26\2"+
		"\2\u028e\u0290\3\2\2\2\u028f\u0283\3\2\2\2\u028f\u0287\3\2\2\2\u028f\u028b"+
		"\3\2\2\2\u0290\u0294\3\2\2\2\u0291\u0293\5^\60\2\u0292\u0291\3\2\2\2\u0293"+
		"\u0296\3\2\2\2\u0294\u0292\3\2\2\2\u0294\u0295\3\2\2\2\u0295\u0298\3\2"+
		"\2\2\u0296\u0294\3\2\2\2\u0297\u028f\3\2\2\2\u0298\u029b\3\2\2\2\u0299"+
		"\u0297\3\2\2\2\u0299\u029a\3\2\2\2\u029a\u0085\3\2\2\2\u029b\u0299\3\2"+
		"\2\2\u029c\u029e\5V,\2\u029d\u029c\3\2\2\2\u029e\u02a1\3\2\2\2\u029f\u029d"+
		"\3\2\2\2\u029f\u02a0\3\2\2\2\u02a0\u02ad\3\2\2\2\u02a1\u029f\3\2\2\2\u02a2"+
		"\u02a3\7\5\2\2\u02a3\u02a4\5\u0086D\2\u02a4\u02a8\7\26\2\2\u02a5\u02a7"+
		"\5V,\2\u02a6\u02a5\3\2\2\2\u02a7\u02aa\3\2\2\2\u02a8\u02a6\3\2\2\2\u02a8"+
		"\u02a9\3\2\2\2\u02a9\u02ac\3\2\2\2\u02aa\u02a8\3\2\2\2\u02ab\u02a2\3\2"+
		"\2\2\u02ac\u02af\3\2\2\2\u02ad\u02ab\3\2\2\2\u02ad\u02ae\3\2\2\2\u02ae"+
		"\u0087\3\2\2\2\u02af\u02ad\3\2\2\2\u02b0\u02b2\7C\2\2\u02b1\u02b0\3\2"+
		"\2\2\u02b1\u02b2\3\2\2\2\u02b2\u02b4\3\2\2\2\u02b3\u02b5\5H%\2\u02b4\u02b3"+
		"\3\2\2\2\u02b4\u02b5\3\2\2\2\u02b5\u02b6\3\2\2\2\u02b6\u02b7\5\u008aF"+
		"\2\u02b7\u0089\3\2\2\2\u02b8\u02ba\5\u0092J\2\u02b9\u02bb\5\u008cG\2\u02ba"+
		"\u02b9\3\2\2\2\u02ba\u02bb\3\2\2\2\u02bb\u02c0\3\2\2\2\u02bc\u02bd\5\u009a"+
		"N\2\u02bd\u02be\5\u008cG\2\u02be\u02c0\3\2\2\2\u02bf\u02b8\3\2\2\2\u02bf"+
		"\u02bc\3\2\2\2\u02c0\u008b\3\2\2\2\u02c1\u02c6\5~@\2\u02c2\u02c3\7\33"+
		"\2\2\u02c3\u02c5\5~@\2\u02c4\u02c2\3\2\2\2\u02c5\u02c8\3\2\2\2\u02c6\u02c4"+
		"\3\2\2\2\u02c6\u02c7\3\2\2\2\u02c7\u02c9\3\2\2\2\u02c8\u02c6\3\2\2\2\u02c9"+
		"\u02ca\7/\2\2\u02ca\u008d\3\2\2\2\u02cb\u02d1\5\b\5\2\u02cc\u02cd\7U\2"+
		"\2\u02cd\u02ce\5\u0090I\2\u02ce\u02cf\7V\2\2\u02cf\u02d1\3\2\2\2\u02d0"+
		"\u02cb\3\2\2\2\u02d0\u02cc\3\2\2\2\u02d1\u008f\3\2\2\2\u02d2\u02d7\5\u008e"+
		"H\2\u02d3\u02d4\7\33\2\2\u02d4\u02d6\5\u008eH\2\u02d5\u02d3\3\2\2\2\u02d6"+
		"\u02d9\3\2\2\2\u02d7\u02d5\3\2\2\2\u02d7\u02d8\3\2\2\2\u02d8\u0091\3\2"+
		"\2\2\u02d9\u02d7\3\2\2\2\u02da\u02dc\7S\2\2\u02db\u02dd\5\u0094K\2\u02dc"+
		"\u02db\3\2\2\2\u02dc\u02dd\3\2\2\2\u02dd\u02df\3\2\2\2\u02de\u02e0\5\u0096"+
		"L\2\u02df\u02de\3\2\2\2\u02df\u02e0\3\2\2\2\u02e0\u02e1\3\2\2\2\u02e1"+
		"\u02e2\7U\2\2\u02e2\u02e3\bJ\1\2\u02e3\u0093\3\2\2\2\u02e4\u02e5\5\u00a8"+
		"U\2\u02e5\u0095\3\2\2\2\u02e6\u02e7\7\35\2\2\u02e7\u02ec\5\u0098M\2\u02e8"+
		"\u02e9\7\33\2\2\u02e9\u02eb\5\u0098M\2\u02ea\u02e8\3\2\2\2\u02eb\u02ee"+
		"\3\2\2\2\u02ec\u02ea\3\2\2\2\u02ec\u02ed\3\2\2\2\u02ed\u0097\3\2\2\2\u02ee"+
		"\u02ec\3\2\2\2\u02ef\u02f1\7I\2\2\u02f0\u02ef\3\2\2\2\u02f0\u02f1\3\2"+
		"\2\2\u02f1\u02f3\3\2\2\2\u02f2\u02f4\5> \2\u02f3\u02f2\3\2\2\2\u02f3\u02f4"+
		"\3\2\2\2\u02f4\u02f5\3\2\2\2\u02f5\u02f6\5\u00a8U\2\u02f6\u0099\3\2\2"+
		"\2\u02f7\u02f9\7H\2\2\u02f8\u02f7\3\2\2\2\u02f9\u02fc\3\2\2\2\u02fa\u02f8"+
		"\3\2\2\2\u02fa\u02fb\3\2\2\2\u02fb\u02fe\3\2\2\2\u02fc\u02fa\3\2\2\2\u02fd"+
		"\u02ff\t\30\2\2\u02fe\u02fd\3\2\2\2\u02fe\u02ff\3\2\2\2\u02ff\u0300\3"+
		"\2\2\2\u0300\u0302\5\u009cO\2\u0301\u0303\5J&\2\u0302\u0301\3\2\2\2\u0302"+
		"\u0303\3\2\2\2\u0303\u030b\3\2\2\2\u0304\u0305\7\20\2\2\u0305\u0307\5"+
		"\u009cO\2\u0306\u0308\5J&\2\u0307\u0306\3\2\2\2\u0307\u0308\3\2\2\2\u0308"+
		"\u030a\3\2\2\2\u0309\u0304\3\2\2\2\u030a\u030d\3\2\2\2\u030b\u0309\3\2"+
		"\2\2\u030b\u030c\3\2\2\2\u030c\u0311\3\2\2\2\u030d\u030b\3\2\2\2\u030e"+
		"\u0311\7E\2\2\u030f\u0311\7F\2\2\u0310\u02fa\3\2\2\2\u0310\u030e\3\2\2"+
		"\2\u0310\u030f\3\2\2\2\u0311\u009b\3\2\2\2\u0312\u0318\7T\2\2\u0313\u0318"+
		"\7D\2\2\u0314\u0318\7G\2\2\u0315\u0316\7G\2\2\u0316\u0318\7G\2\2\u0317"+
		"\u0312\3\2\2\2\u0317\u0313\3\2\2\2\u0317\u0314\3\2\2\2\u0317\u0315\3\2"+
		"\2\2\u0318\u009d\3\2\2\2\u0319\u031b\t\31\2\2\u031a\u0319\3\2\2\2\u031a"+
		"\u031b\3\2\2\2\u031b\u031c\3\2\2\2\u031c\u031d\5\u009aN\2\u031d\u009f"+
		"\3\2\2\2\u031e\u0321\5\u00a8U\2\u031f\u0321\5> \2\u0320\u031e\3\2\2\2"+
		"\u0320\u031f\3\2\2\2\u0321\u00a1\3\2\2\2\u0322\u0323\7\36\2\2\u0323\u0324"+
		"\7D\2\2\u0324\u0332\7\r\2\2\u0325\u032e\7\36\2\2\u0326\u032b\5\u00a4S"+
		"\2\u0327\u0328\7\33\2\2\u0328\u032a\5\u00a4S\2\u0329\u0327\3\2\2\2\u032a"+
		"\u032d\3\2\2\2\u032b\u0329\3\2\2\2\u032b\u032c\3\2\2\2\u032c\u032f\3\2"+
		"\2\2\u032d\u032b\3\2\2\2\u032e\u0326\3\2\2\2\u032e\u032f\3\2\2\2\u032f"+
		"\u0330\3\2\2\2\u0330\u0332\7\r\2\2\u0331\u0322\3\2\2\2\u0331\u0325\3\2"+
		"\2\2\u0332\u00a3\3\2\2\2\u0333\u0334\5\u009eP\2\u0334\u0335\5\u00a6T\2"+
		"\u0335\u00a5\3\2\2\2\u0336\u0338\5\u00acW\2\u0337\u0336\3\2\2\2\u0337"+
		"\u0338\3\2\2\2\u0338\u0340\3\2\2\2\u0339\u033a\7\36\2\2\u033a\u033b\5"+
		"\u00a6T\2\u033b\u033c\7\r\2\2\u033c\u0341\3\2\2\2\u033d\u033f\5\u00a0"+
		"Q\2\u033e\u033d\3\2\2\2\u033e\u033f\3\2\2\2\u033f\u0341\3\2\2\2\u0340"+
		"\u0339\3\2\2\2\u0340\u033e\3\2\2\2\u0341\u0343\3\2\2\2\u0342\u0344\5\u0080"+
		"A\2\u0343\u0342\3\2\2\2\u0343\u0344\3\2\2\2\u0344\u00a7\3\2\2\2\u0345"+
		"\u034a\7T\2\2\u0346\u0347\7\20\2\2\u0347\u0349\7T\2\2\u0348\u0346\3\2"+
		"\2\2\u0349\u034c\3\2\2\2\u034a\u0348\3\2\2\2\u034a\u034b\3\2\2\2\u034b"+
		"\u00a9\3\2\2\2\u034c\u034a\3\2\2\2\u034d\u034e\t\32\2\2\u034e\u00ab\3"+
		"\2\2\2\u034f\u0351\5<\37\2\u0350\u034f\3\2\2\2\u0351\u0352\3\2\2\2\u0352"+
		"\u0350\3\2\2\2\u0352\u0353\3\2\2\2\u0353\u00ad\3\2\2\2d\u00b2\u00b4\u00bf"+
		"\u00c5\u00cd\u00d2\u00d7\u00dc\u00e1\u00e6\u00ec\u00f2\u00f7\u00fc\u0101"+
		"\u0108\u010f\u0118\u011c\u0122\u0128\u012f\u0139\u013c\u014a\u014e\u0156"+
		"\u016a\u0194\u01a7\u01a9\u01c5\u01c8\u01cd\u01d4\u01dc\u01e1\u01e7\u01eb"+
		"\u01f2\u01f7\u01fa\u0200\u0207\u020a\u0215\u021c\u0222\u022c\u0236\u023f"+
		"\u0244\u0248\u024c\u0250\u0255\u025c\u0261\u0270\u0275\u027a\u0280\u028f"+
		"\u0294\u0299\u029f\u02a8\u02ad\u02b1\u02b4\u02ba\u02bf\u02c6\u02d0\u02d7"+
		"\u02dc\u02df\u02ec\u02f0\u02f3\u02fa\u02fe\u0302\u0307\u030b\u0310\u0317"+
		"\u031a\u0320\u032b\u032e\u0331\u0337\u033e\u0340\u0343\u034a\u0352";
	public static final ATN _ATN =
		ATNSimulator.deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
	}
}