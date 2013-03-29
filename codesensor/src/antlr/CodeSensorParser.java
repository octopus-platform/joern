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
		T__54=1, T__53=2, T__52=3, T__51=4, T__50=5, T__49=6, T__48=7, T__47=8, 
		T__46=9, T__45=10, T__44=11, T__43=12, T__42=13, T__41=14, T__40=15, T__39=16, 
		T__38=17, T__37=18, T__36=19, T__35=20, T__34=21, T__33=22, T__32=23, 
		T__31=24, T__30=25, T__29=26, T__28=27, T__27=28, T__26=29, T__25=30, 
		T__24=31, T__23=32, T__22=33, T__21=34, T__20=35, T__19=36, T__18=37, 
		T__17=38, T__16=39, T__15=40, T__14=41, T__13=42, T__12=43, T__11=44, 
		T__10=45, T__9=46, T__8=47, T__7=48, T__6=49, T__5=50, T__4=51, T__3=52, 
		T__2=53, T__1=54, T__0=55, IF=56, ELSE=57, FOR=58, WHILE=59, BREAK=60, 
		CASE=61, CONTINUE=62, SWITCH=63, DO=64, GOTO=65, RETURN=66, TYPEDEF=67, 
		VOID=68, UNSIGNED=69, SIGNED=70, LONG=71, CV_QUALIFIER=72, VIRTUAL=73, 
		TRY=74, CATCH=75, THROW=76, USING=77, NAMESPACE=78, AUTO=79, REGISTER=80, 
		OPERATOR=81, TEMPLATE=82, CLASS_KEY=83, ALPHA_NUMERIC=84, OPENING_CURLY=85, 
		CLOSING_CURLY=86, PRE_IF=87, PRE_ELSE=88, PRE_ENDIF=89, HEX_LITERAL=90, 
		DECIMAL_LITERAL=91, OCTAL_LITERAL=92, FLOATING_POINT_LITERAL=93, CHAR=94, 
		STRING=95, COMMENT=96, WHITESPACE=97, CPPCOMMENT=98, OTHER=99;
	public static final String[] tokenNames = {
		"<INVALID>", "'&'", "'['", "'*'", "'<'", "'--'", "'!='", "'<='", "'<<'", 
		"'%'", "'->'", "'*='", "')'", "'explicit'", "'inline'", "'::'", "'='", 
		"'|='", "'new'", "'|'", "'!'", "']'", "'<<='", "'-='", "'->*'", "'public'", 
		"','", "'-'", "':'", "'('", "'&='", "'private'", "'?'", "'>>='", "'...'", 
		"'+='", "'^='", "'friend'", "'static'", "'++'", "'>>'", "'delete'", "'^'", 
		"'.'", "'+'", "'protected'", "';'", "'&&'", "'||'", "'>'", "'%='", "'/='", 
		"'/'", "'=='", "'~'", "'>='", "'if'", "'else'", "'for'", "'while'", "'break'", 
		"'case'", "'continue'", "'switch'", "'do'", "'goto'", "'return'", "'typedef'", 
		"'void'", "'unsigned'", "'signed'", "'long'", "CV_QUALIFIER", "'virtual'", 
		"'try'", "'catch'", "'throw'", "'using'", "'namespace'", "'auto'", "'register'", 
		"'operator'", "'template'", "CLASS_KEY", "ALPHA_NUMERIC", "'{'", "'}'", 
		"PRE_IF", "PRE_ELSE", "PRE_ENDIF", "HEX_LITERAL", "DECIMAL_LITERAL", "OCTAL_LITERAL", 
		"FLOATING_POINT_LITERAL", "CHAR", "STRING", "COMMENT", "WHITESPACE", "CPPCOMMENT", 
		"OTHER"
	};
	public static final int
		RULE_code = 0, RULE_using_directive = 1, RULE_expr = 2, RULE_assign_expr = 3, 
		RULE_conditional_expression = 4, RULE_or_expression = 5, RULE_and_expression = 6, 
		RULE_inclusive_or_expression = 7, RULE_exclusive_or_expression = 8, RULE_bit_and_expression = 9, 
		RULE_equality_expression = 10, RULE_relational_expression = 11, RULE_shift_expression = 12, 
		RULE_additive_expression = 13, RULE_multiplicative_expression = 14, RULE_cast_expression = 15, 
		RULE_unary_expression = 16, RULE_inc_dec = 17, RULE_unary_operators = 18, 
		RULE_field = 19, RULE_function_argument_list = 20, RULE_function_argument = 21, 
		RULE_postfix = 22, RULE_primary_expression = 23, RULE_unary_operator = 24, 
		RULE_relational_operator = 25, RULE_constant = 26, RULE_function_decl_specifiers = 27, 
		RULE_ptr_operator = 28, RULE_access_specifier = 29, RULE_operator = 30, 
		RULE_assignment_operator = 31, RULE_equality_operator = 32, RULE_template_decl_start = 33, 
		RULE_template_param_list = 34, RULE_no_brackets = 35, RULE_no_brackets_curlies_or_squares = 36, 
		RULE_no_brackets_or_semicolon = 37, RULE_no_angle_brackets_or_brackets = 38, 
		RULE_no_curlies = 39, RULE_no_squares = 40, RULE_no_squares_or_semicolon = 41, 
		RULE_no_comma_or_semicolon = 42, RULE_assign_water = 43, RULE_assign_water_l2 = 44, 
		RULE_water = 45, RULE_function_def = 46, RULE_return_type = 47, RULE_function_param_list = 48, 
		RULE_parameter_decl_clause = 49, RULE_parameter_decl = 50, RULE_parameter_id = 51, 
		RULE_compound_statement = 52, RULE_ctor_list = 53, RULE_ctor_initializer = 54, 
		RULE_initializer_id = 55, RULE_ctor_expr = 56, RULE_function_name = 57, 
		RULE_exception_specification = 58, RULE_type_id_list = 59, RULE_init_declarator = 60, 
		RULE_type_suffix = 61, RULE_assign_expr_w_ = 62, RULE_assign_expr_w__l2 = 63, 
		RULE_constant_expr_w_ = 64, RULE_simple_decl = 65, RULE_var_decl = 66, 
		RULE_init_declarator_list = 67, RULE_initializer = 68, RULE_initializer_list = 69, 
		RULE_class_def = 70, RULE_class_name = 71, RULE_base_classes = 72, RULE_base_class = 73, 
		RULE_type_name = 74, RULE_base_type = 75, RULE_param_decl_specifiers = 76, 
		RULE_parameter_name = 77, RULE_param_type_list = 78, RULE_param_type = 79, 
		RULE_param_type_id = 80, RULE_identifier = 81, RULE_number = 82, RULE_ptrs = 83;
	public static final String[] ruleNames = {
		"code", "using_directive", "expr", "assign_expr", "conditional_expression", 
		"or_expression", "and_expression", "inclusive_or_expression", "exclusive_or_expression", 
		"bit_and_expression", "equality_expression", "relational_expression", 
		"shift_expression", "additive_expression", "multiplicative_expression", 
		"cast_expression", "unary_expression", "inc_dec", "unary_operators", "field", 
		"function_argument_list", "function_argument", "postfix", "primary_expression", 
		"unary_operator", "relational_operator", "constant", "function_decl_specifiers", 
		"ptr_operator", "access_specifier", "operator", "assignment_operator", 
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
			setState(174);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << 1) | (1L << 2) | (1L << 3) | (1L << 4) | (1L << 5) | (1L << 6) | (1L << 7) | (1L << 8) | (1L << 9) | (1L << 10) | (1L << 11) | (1L << 12) | (1L << 13) | (1L << 14) | (1L << 15) | (1L << 16) | (1L << 17) | (1L << 18) | (1L << 19) | (1L << 20) | (1L << 21) | (1L << 22) | (1L << 23) | (1L << 24) | (1L << 25) | (1L << 26) | (1L << 27) | (1L << 28) | (1L << 29) | (1L << 30) | (1L << 31) | (1L << 32) | (1L << 33) | (1L << 34) | (1L << 35) | (1L << 36) | (1L << 37) | (1L << 38) | (1L << 39) | (1L << 40) | (1L << 41) | (1L << 42) | (1L << 43) | (1L << 44) | (1L << 45) | (1L << 46) | (1L << 47) | (1L << 48) | (1L << 49) | (1L << 50) | (1L << 51) | (1L << 52) | (1L << 53) | (1L << 54) | (1L << 55) | (1L << IF) | (1L << ELSE) | (1L << FOR) | (1L << WHILE) | (1L << BREAK) | (1L << CASE) | (1L << CONTINUE) | (1L << SWITCH))) != 0) || ((((_la - 64)) & ~0x3f) == 0 && ((1L << (_la - 64)) & ((1L << (DO - 64)) | (1L << (GOTO - 64)) | (1L << (RETURN - 64)) | (1L << (TYPEDEF - 64)) | (1L << (VOID - 64)) | (1L << (UNSIGNED - 64)) | (1L << (SIGNED - 64)) | (1L << (LONG - 64)) | (1L << (CV_QUALIFIER - 64)) | (1L << (VIRTUAL - 64)) | (1L << (TRY - 64)) | (1L << (CATCH - 64)) | (1L << (THROW - 64)) | (1L << (USING - 64)) | (1L << (NAMESPACE - 64)) | (1L << (AUTO - 64)) | (1L << (REGISTER - 64)) | (1L << (OPERATOR - 64)) | (1L << (TEMPLATE - 64)) | (1L << (CLASS_KEY - 64)) | (1L << (ALPHA_NUMERIC - 64)) | (1L << (OPENING_CURLY - 64)) | (1L << (CLOSING_CURLY - 64)) | (1L << (PRE_IF - 64)) | (1L << (PRE_ELSE - 64)) | (1L << (PRE_ENDIF - 64)) | (1L << (HEX_LITERAL - 64)) | (1L << (DECIMAL_LITERAL - 64)) | (1L << (OCTAL_LITERAL - 64)) | (1L << (FLOATING_POINT_LITERAL - 64)) | (1L << (CHAR - 64)) | (1L << (STRING - 64)) | (1L << (COMMENT - 64)) | (1L << (WHITESPACE - 64)) | (1L << (CPPCOMMENT - 64)) | (1L << (OTHER - 64)) | (1L << (37 - 64)) | (1L << (38 - 64)) | (1L << (TYPEDEF - 64)) | (1L << (VOID - 64)) | (1L << (UNSIGNED - 64)) | (1L << (SIGNED - 64)) | (1L << (LONG - 64)) | (1L << (CV_QUALIFIER - 64)) | (1L << (VIRTUAL - 64)) | (1L << (USING - 64)) | (1L << (OPERATOR - 64)) | (1L << (TEMPLATE - 64)) | (1L << (CLASS_KEY - 64)) | (1L << (ALPHA_NUMERIC - 64)))) != 0)) {
				{
				setState(172);
				switch ( getInterpreter().adaptivePredict(_input,0,_ctx) ) {
				case 1:
					{
					setState(168); function_def();
					}
					break;

				case 2:
					{
					setState(169); simple_decl();
					}
					break;

				case 3:
					{
					setState(170); using_directive();
					}
					break;

				case 4:
					{
					setState(171); water();
					}
					break;
				}
				}
				setState(176);
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
			setState(177); match(USING);
			setState(178); match(NAMESPACE);
			setState(179); identifier();
			setState(180); match(46);
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
			setState(182); assign_expr();
			setState(185);
			_la = _input.LA(1);
			if (_la==26) {
				{
				setState(183); match(26);
				setState(184); assign_expr();
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
		public List<Assignment_operatorContext> assignment_operator() {
			return getRuleContexts(Assignment_operatorContext.class);
		}
		public List<Conditional_expressionContext> conditional_expression() {
			return getRuleContexts(Conditional_expressionContext.class);
		}
		public Assignment_operatorContext assignment_operator(int i) {
			return getRuleContext(Assignment_operatorContext.class,i);
		}
		public Conditional_expressionContext conditional_expression(int i) {
			return getRuleContext(Conditional_expressionContext.class,i);
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
			setState(187); conditional_expression();
			setState(193);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << 11) | (1L << 16) | (1L << 17) | (1L << 22) | (1L << 23) | (1L << 30) | (1L << 33) | (1L << 35) | (1L << 36) | (1L << 50) | (1L << 51))) != 0)) {
				{
				{
				setState(188); assignment_operator();
				setState(189); conditional_expression();
				}
				}
				setState(195);
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
			setState(196); or_expression();
			setState(202);
			_la = _input.LA(1);
			if (_la==32) {
				{
				setState(197); match(32);
				setState(198); expr();
				setState(199); match(28);
				setState(200); conditional_expression();
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
		public List<And_expressionContext> and_expression() {
			return getRuleContexts(And_expressionContext.class);
		}
		public And_expressionContext and_expression(int i) {
			return getRuleContext(And_expressionContext.class,i);
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
			setState(204); and_expression();
			setState(209);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==48) {
				{
				{
				setState(205); match(48);
				setState(206); and_expression();
				}
				}
				setState(211);
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

	public static class And_expressionContext extends ParserRuleContext {
		public List<Inclusive_or_expressionContext> inclusive_or_expression() {
			return getRuleContexts(Inclusive_or_expressionContext.class);
		}
		public Inclusive_or_expressionContext inclusive_or_expression(int i) {
			return getRuleContext(Inclusive_or_expressionContext.class,i);
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
			setState(212); inclusive_or_expression();
			setState(217);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==47) {
				{
				{
				setState(213); match(47);
				setState(214); inclusive_or_expression();
				}
				}
				setState(219);
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

	public static class Inclusive_or_expressionContext extends ParserRuleContext {
		public Exclusive_or_expressionContext exclusive_or_expression(int i) {
			return getRuleContext(Exclusive_or_expressionContext.class,i);
		}
		public List<Exclusive_or_expressionContext> exclusive_or_expression() {
			return getRuleContexts(Exclusive_or_expressionContext.class);
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
			setState(220); exclusive_or_expression();
			setState(225);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==19) {
				{
				{
				setState(221); match(19);
				setState(222); exclusive_or_expression();
				}
				}
				setState(227);
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

	public static class Exclusive_or_expressionContext extends ParserRuleContext {
		public Bit_and_expressionContext bit_and_expression(int i) {
			return getRuleContext(Bit_and_expressionContext.class,i);
		}
		public List<Bit_and_expressionContext> bit_and_expression() {
			return getRuleContexts(Bit_and_expressionContext.class);
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
			setState(228); bit_and_expression();
			setState(233);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==42) {
				{
				{
				setState(229); match(42);
				setState(230); bit_and_expression();
				}
				}
				setState(235);
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

	public static class Bit_and_expressionContext extends ParserRuleContext {
		public Equality_expressionContext equality_expression(int i) {
			return getRuleContext(Equality_expressionContext.class,i);
		}
		public List<Equality_expressionContext> equality_expression() {
			return getRuleContexts(Equality_expressionContext.class);
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
			setState(236); equality_expression();
			setState(241);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==1) {
				{
				{
				setState(237); match(1);
				setState(238); equality_expression();
				}
				}
				setState(243);
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

	public static class Equality_expressionContext extends ParserRuleContext {
		public Equality_operatorContext equality_operator(int i) {
			return getRuleContext(Equality_operatorContext.class,i);
		}
		public List<Equality_operatorContext> equality_operator() {
			return getRuleContexts(Equality_operatorContext.class);
		}
		public Relational_expressionContext relational_expression(int i) {
			return getRuleContext(Relational_expressionContext.class,i);
		}
		public List<Relational_expressionContext> relational_expression() {
			return getRuleContexts(Relational_expressionContext.class);
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
			setState(244); relational_expression();
			setState(250);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==6 || _la==53) {
				{
				{
				setState(245); equality_operator();
				setState(246); relational_expression();
				}
				}
				setState(252);
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

	public static class Relational_expressionContext extends ParserRuleContext {
		public Relational_operatorContext relational_operator(int i) {
			return getRuleContext(Relational_operatorContext.class,i);
		}
		public List<Shift_expressionContext> shift_expression() {
			return getRuleContexts(Shift_expressionContext.class);
		}
		public List<Relational_operatorContext> relational_operator() {
			return getRuleContexts(Relational_operatorContext.class);
		}
		public Shift_expressionContext shift_expression(int i) {
			return getRuleContext(Shift_expressionContext.class,i);
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
			setState(253); shift_expression();
			setState(259);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << 4) | (1L << 7) | (1L << 49) | (1L << 55))) != 0)) {
				{
				{
				setState(254); relational_operator();
				setState(255); shift_expression();
				}
				}
				setState(261);
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

	public static class Shift_expressionContext extends ParserRuleContext {
		public List<Additive_expressionContext> additive_expression() {
			return getRuleContexts(Additive_expressionContext.class);
		}
		public Additive_expressionContext additive_expression(int i) {
			return getRuleContext(Additive_expressionContext.class,i);
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
			setState(262); additive_expression();
			setState(267);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==8 || _la==40) {
				{
				{
				setState(263);
				_la = _input.LA(1);
				if ( !(_la==8 || _la==40) ) {
				_errHandler.recoverInline(this);
				}
				consume();
				setState(264); additive_expression();
				}
				}
				setState(269);
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

	public static class Additive_expressionContext extends ParserRuleContext {
		public Multiplicative_expressionContext multiplicative_expression(int i) {
			return getRuleContext(Multiplicative_expressionContext.class,i);
		}
		public List<Multiplicative_expressionContext> multiplicative_expression() {
			return getRuleContexts(Multiplicative_expressionContext.class);
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
			setState(270); multiplicative_expression();
			setState(275);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==27 || _la==44) {
				{
				{
				setState(271);
				_la = _input.LA(1);
				if ( !(_la==27 || _la==44) ) {
				_errHandler.recoverInline(this);
				}
				consume();
				setState(272); multiplicative_expression();
				}
				}
				setState(277);
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
			setState(278); cast_expression();
			setState(283);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << 3) | (1L << 9) | (1L << 52))) != 0)) {
				{
				{
				setState(279);
				_la = _input.LA(1);
				if ( !((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << 3) | (1L << 9) | (1L << 52))) != 0)) ) {
				_errHandler.recoverInline(this);
				}
				consume();
				setState(280); cast_expression();
				}
				}
				setState(285);
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
			setState(298);
			switch ( getInterpreter().adaptivePredict(_input,16,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				{
				setState(286); match(29);
				setState(287); type_name();
				setState(291);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (_la==1 || _la==3) {
					{
					{
					setState(288); ptr_operator();
					}
					}
					setState(293);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				setState(294); match(12);
				setState(295); cast_expression();
				}
				}
				break;

			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(297); unary_expression();
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
		public Unary_expressionContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_unary_expression; }
	 
		public Unary_expressionContext() { }
		public void copyFrom(Unary_expressionContext ctx) {
			super.copyFrom(ctx);
		}
	}
	public static class FieldOnlyContext extends Unary_expressionContext {
		public FieldContext field() {
			return getRuleContext(FieldContext.class,0);
		}
		public Inc_decContext inc_dec() {
			return getRuleContext(Inc_decContext.class,0);
		}
		public Unary_operatorsContext unary_operators() {
			return getRuleContext(Unary_operatorsContext.class,0);
		}
		public FieldOnlyContext(Unary_expressionContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof CodeSensorListener ) ((CodeSensorListener)listener).enterFieldOnly(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof CodeSensorListener ) ((CodeSensorListener)listener).exitFieldOnly(this);
		}
	}
	public static class FuncCallContext extends Unary_expressionContext {
		public FieldContext field() {
			return getRuleContext(FieldContext.class,0);
		}
		public Inc_decContext inc_dec() {
			return getRuleContext(Inc_decContext.class,0);
		}
		public Template_param_listContext template_param_list() {
			return getRuleContext(Template_param_listContext.class,0);
		}
		public Unary_operatorsContext unary_operators() {
			return getRuleContext(Unary_operatorsContext.class,0);
		}
		public Function_argument_listContext function_argument_list() {
			return getRuleContext(Function_argument_listContext.class,0);
		}
		public FuncCallContext(Unary_expressionContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof CodeSensorListener ) ((CodeSensorListener)listener).enterFuncCall(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof CodeSensorListener ) ((CodeSensorListener)listener).exitFuncCall(this);
		}
	}

	public final Unary_expressionContext unary_expression() throws RecognitionException {
		Unary_expressionContext _localctx = new Unary_expressionContext(_ctx, getState());
		enterRule(_localctx, 32, RULE_unary_expression);
		int _la;
		try {
			setState(315);
			switch ( getInterpreter().adaptivePredict(_input,18,_ctx) ) {
			case 1:
				_localctx = new FuncCallContext(_localctx);
				enterOuterAlt(_localctx, 1);
				{
				setState(300); inc_dec();
				setState(301); unary_operators();
				setState(302); field();
				{
				setState(307);
				_la = _input.LA(1);
				if (_la==4) {
					{
					setState(303); match(4);
					setState(304); template_param_list();
					setState(305); match(49);
					}
				}

				setState(309); function_argument_list();
				}
				}
				break;

			case 2:
				_localctx = new FieldOnlyContext(_localctx);
				enterOuterAlt(_localctx, 2);
				{
				setState(311); inc_dec();
				setState(312); unary_operators();
				setState(313); field();
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

	public static class Inc_decContext extends ParserRuleContext {
		public Inc_decContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_inc_dec; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof CodeSensorListener ) ((CodeSensorListener)listener).enterInc_dec(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof CodeSensorListener ) ((CodeSensorListener)listener).exitInc_dec(this);
		}
	}

	public final Inc_decContext inc_dec() throws RecognitionException {
		Inc_decContext _localctx = new Inc_decContext(_ctx, getState());
		enterRule(_localctx, 34, RULE_inc_dec);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(320);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==5 || _la==39) {
				{
				{
				setState(317);
				_la = _input.LA(1);
				if ( !(_la==5 || _la==39) ) {
				_errHandler.recoverInline(this);
				}
				consume();
				}
				}
				setState(322);
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

	public static class Unary_operatorsContext extends ParserRuleContext {
		public List<Unary_operatorContext> unary_operator() {
			return getRuleContexts(Unary_operatorContext.class);
		}
		public Unary_operatorContext unary_operator(int i) {
			return getRuleContext(Unary_operatorContext.class,i);
		}
		public Unary_operatorsContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_unary_operators; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof CodeSensorListener ) ((CodeSensorListener)listener).enterUnary_operators(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof CodeSensorListener ) ((CodeSensorListener)listener).exitUnary_operators(this);
		}
	}

	public final Unary_operatorsContext unary_operators() throws RecognitionException {
		Unary_operatorsContext _localctx = new Unary_operatorsContext(_ctx, getState());
		enterRule(_localctx, 36, RULE_unary_operators);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(326);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << 1) | (1L << 3) | (1L << 20) | (1L << 27) | (1L << 44) | (1L << 54))) != 0)) {
				{
				{
				setState(323); unary_operator();
				}
				}
				setState(328);
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
		enterRule(_localctx, 38, RULE_field);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(329); primary_expression();
			setState(333);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << 2) | (1L << 5) | (1L << 10) | (1L << 39) | (1L << 43))) != 0)) {
				{
				{
				setState(330); postfix();
				}
				}
				setState(335);
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
		enterRule(_localctx, 40, RULE_function_argument_list);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(336); match(29);
			setState(345);
			_la = _input.LA(1);
			if ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << 1) | (1L << 3) | (1L << 5) | (1L << 20) | (1L << 27) | (1L << 29) | (1L << 39) | (1L << 44) | (1L << 54))) != 0) || ((((_la - 84)) & ~0x3f) == 0 && ((1L << (_la - 84)) & ((1L << (ALPHA_NUMERIC - 84)) | (1L << (HEX_LITERAL - 84)) | (1L << (DECIMAL_LITERAL - 84)) | (1L << (OCTAL_LITERAL - 84)) | (1L << (FLOATING_POINT_LITERAL - 84)) | (1L << (CHAR - 84)) | (1L << (STRING - 84)))) != 0)) {
				{
				setState(337); function_argument();
				setState(342);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (_la==26) {
					{
					{
					setState(338); match(26);
					setState(339); function_argument();
					}
					}
					setState(344);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				}
			}

			setState(347); match(12);
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
		enterRule(_localctx, 42, RULE_function_argument);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(349); assign_expr();
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
		enterRule(_localctx, 44, RULE_postfix);
		try {
			setState(363);
			switch (_input.LA(1)) {
			case 2:
			case 10:
			case 43:
				enterOuterAlt(_localctx, 1);
				{
				setState(359);
				switch (_input.LA(1)) {
				case 43:
					{
					setState(351); match(43);
					setState(352); identifier();
					}
					break;
				case 10:
					{
					setState(353); match(10);
					setState(354); identifier();
					}
					break;
				case 2:
					{
					setState(355); match(2);
					setState(356); expr();
					setState(357); match(21);
					}
					break;
				default:
					throw new NoViableAltException(this);
				}
				}
				break;
			case 39:
				enterOuterAlt(_localctx, 2);
				{
				setState(361); match(39);
				}
				break;
			case 5:
				enterOuterAlt(_localctx, 3);
				{
				setState(362); match(5);
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
		enterRule(_localctx, 46, RULE_primary_expression);
		try {
			setState(371);
			switch (_input.LA(1)) {
			case ALPHA_NUMERIC:
				enterOuterAlt(_localctx, 1);
				{
				setState(365); identifier();
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
				setState(366); constant();
				}
				break;
			case 29:
				enterOuterAlt(_localctx, 3);
				{
				setState(367); match(29);
				setState(368); expr();
				setState(369); match(12);
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
		enterRule(_localctx, 48, RULE_unary_operator);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(373);
			_la = _input.LA(1);
			if ( !((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << 1) | (1L << 3) | (1L << 20) | (1L << 27) | (1L << 44) | (1L << 54))) != 0)) ) {
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
		enterRule(_localctx, 50, RULE_relational_operator);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(375);
			_la = _input.LA(1);
			if ( !((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << 4) | (1L << 7) | (1L << 49) | (1L << 55))) != 0)) ) {
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
		enterRule(_localctx, 52, RULE_constant);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(377);
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
		enterRule(_localctx, 54, RULE_function_decl_specifiers);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(379);
			_la = _input.LA(1);
			if ( !(((((_la - 13)) & ~0x3f) == 0 && ((1L << (_la - 13)) & ((1L << (13 - 13)) | (1L << (14 - 13)) | (1L << (37 - 13)) | (1L << (38 - 13)) | (1L << (VIRTUAL - 13)))) != 0)) ) {
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
		enterRule(_localctx, 56, RULE_ptr_operator);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(381);
			_la = _input.LA(1);
			if ( !(_la==1 || _la==3) ) {
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
		enterRule(_localctx, 58, RULE_access_specifier);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(383);
			_la = _input.LA(1);
			if ( !((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << 25) | (1L << 31) | (1L << 45))) != 0)) ) {
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
		enterRule(_localctx, 60, RULE_operator);
		int _la;
		try {
			setState(430);
			switch (_input.LA(1)) {
			case 18:
			case 41:
				enterOuterAlt(_localctx, 1);
				{
				{
				setState(385);
				_la = _input.LA(1);
				if ( !(_la==18 || _la==41) ) {
				_errHandler.recoverInline(this);
				}
				consume();
				setState(388);
				_la = _input.LA(1);
				if (_la==2) {
					{
					setState(386); match(2);
					setState(387); match(21);
					}
				}

				}
				}
				break;
			case 44:
				enterOuterAlt(_localctx, 2);
				{
				setState(390); match(44);
				}
				break;
			case 27:
				enterOuterAlt(_localctx, 3);
				{
				setState(391); match(27);
				}
				break;
			case 3:
				enterOuterAlt(_localctx, 4);
				{
				setState(392); match(3);
				}
				break;
			case 52:
				enterOuterAlt(_localctx, 5);
				{
				setState(393); match(52);
				}
				break;
			case 9:
				enterOuterAlt(_localctx, 6);
				{
				setState(394); match(9);
				}
				break;
			case 42:
				enterOuterAlt(_localctx, 7);
				{
				setState(395); match(42);
				}
				break;
			case 1:
				enterOuterAlt(_localctx, 8);
				{
				setState(396); match(1);
				}
				break;
			case 19:
				enterOuterAlt(_localctx, 9);
				{
				setState(397); match(19);
				}
				break;
			case 54:
				enterOuterAlt(_localctx, 10);
				{
				setState(398); match(54);
				}
				break;
			case 20:
				enterOuterAlt(_localctx, 11);
				{
				setState(399); match(20);
				}
				break;
			case 16:
				enterOuterAlt(_localctx, 12);
				{
				setState(400); match(16);
				}
				break;
			case 4:
				enterOuterAlt(_localctx, 13);
				{
				setState(401); match(4);
				}
				break;
			case 49:
				enterOuterAlt(_localctx, 14);
				{
				setState(402); match(49);
				}
				break;
			case 35:
				enterOuterAlt(_localctx, 15);
				{
				setState(403); match(35);
				}
				break;
			case 23:
				enterOuterAlt(_localctx, 16);
				{
				setState(404); match(23);
				}
				break;
			case 11:
				enterOuterAlt(_localctx, 17);
				{
				setState(405); match(11);
				}
				break;
			case 51:
				enterOuterAlt(_localctx, 18);
				{
				setState(406); match(51);
				}
				break;
			case 50:
				enterOuterAlt(_localctx, 19);
				{
				setState(407); match(50);
				}
				break;
			case 36:
				enterOuterAlt(_localctx, 20);
				{
				setState(408); match(36);
				}
				break;
			case 30:
				enterOuterAlt(_localctx, 21);
				{
				setState(409); match(30);
				}
				break;
			case 17:
				enterOuterAlt(_localctx, 22);
				{
				setState(410); match(17);
				}
				break;
			case 40:
				enterOuterAlt(_localctx, 23);
				{
				setState(411); match(40);
				}
				break;
			case 8:
				enterOuterAlt(_localctx, 24);
				{
				setState(412); match(8);
				}
				break;
			case 33:
				enterOuterAlt(_localctx, 25);
				{
				setState(413); match(33);
				}
				break;
			case 22:
				enterOuterAlt(_localctx, 26);
				{
				setState(414); match(22);
				}
				break;
			case 53:
				enterOuterAlt(_localctx, 27);
				{
				setState(415); match(53);
				}
				break;
			case 6:
				enterOuterAlt(_localctx, 28);
				{
				setState(416); match(6);
				}
				break;
			case 7:
				enterOuterAlt(_localctx, 29);
				{
				setState(417); match(7);
				}
				break;
			case 55:
				enterOuterAlt(_localctx, 30);
				{
				setState(418); match(55);
				}
				break;
			case 47:
				enterOuterAlt(_localctx, 31);
				{
				setState(419); match(47);
				}
				break;
			case 48:
				enterOuterAlt(_localctx, 32);
				{
				setState(420); match(48);
				}
				break;
			case 39:
				enterOuterAlt(_localctx, 33);
				{
				setState(421); match(39);
				}
				break;
			case 5:
				enterOuterAlt(_localctx, 34);
				{
				setState(422); match(5);
				}
				break;
			case 26:
				enterOuterAlt(_localctx, 35);
				{
				setState(423); match(26);
				}
				break;
			case 24:
				enterOuterAlt(_localctx, 36);
				{
				setState(424); match(24);
				}
				break;
			case 10:
				enterOuterAlt(_localctx, 37);
				{
				setState(425); match(10);
				}
				break;
			case 29:
				enterOuterAlt(_localctx, 38);
				{
				setState(426); match(29);
				setState(427); match(12);
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 39);
				{
				setState(428); match(2);
				setState(429); match(21);
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
		enterRule(_localctx, 62, RULE_assignment_operator);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(432);
			_la = _input.LA(1);
			if ( !((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << 11) | (1L << 16) | (1L << 17) | (1L << 22) | (1L << 23) | (1L << 30) | (1L << 33) | (1L << 35) | (1L << 36) | (1L << 50) | (1L << 51))) != 0)) ) {
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
		enterRule(_localctx, 64, RULE_equality_operator);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(434);
			_la = _input.LA(1);
			if ( !(_la==6 || _la==53) ) {
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
		enterRule(_localctx, 66, RULE_template_decl_start);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(436); match(TEMPLATE);
			setState(437); match(4);
			setState(438); template_param_list();
			setState(439); match(49);
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
		enterRule(_localctx, 68, RULE_template_param_list);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(450); 
			_errHandler.sync(this);
			_la = _input.LA(1);
			do {
				{
				setState(450);
				switch (_input.LA(1)) {
				case 4:
					{
					{
					setState(441); match(4);
					setState(442); template_param_list();
					setState(443); match(49);
					}
					}
					break;
				case 29:
					{
					{
					setState(445); match(29);
					setState(446); template_param_list();
					setState(447); match(12);
					}
					}
					break;
				case 1:
				case 2:
				case 3:
				case 5:
				case 6:
				case 7:
				case 8:
				case 9:
				case 10:
				case 11:
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
				case 28:
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
				case 50:
				case 51:
				case 52:
				case 53:
				case 54:
				case 55:
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
					setState(449); no_angle_brackets_or_brackets();
					}
					break;
				default:
					throw new NoViableAltException(this);
				}
				}
				setState(452); 
				_errHandler.sync(this);
				_la = _input.LA(1);
			} while ( (((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << 1) | (1L << 2) | (1L << 3) | (1L << 4) | (1L << 5) | (1L << 6) | (1L << 7) | (1L << 8) | (1L << 9) | (1L << 10) | (1L << 11) | (1L << 13) | (1L << 14) | (1L << 15) | (1L << 16) | (1L << 17) | (1L << 18) | (1L << 19) | (1L << 20) | (1L << 21) | (1L << 22) | (1L << 23) | (1L << 24) | (1L << 25) | (1L << 26) | (1L << 27) | (1L << 28) | (1L << 29) | (1L << 30) | (1L << 31) | (1L << 32) | (1L << 33) | (1L << 34) | (1L << 35) | (1L << 36) | (1L << 37) | (1L << 38) | (1L << 39) | (1L << 40) | (1L << 41) | (1L << 42) | (1L << 43) | (1L << 44) | (1L << 45) | (1L << 46) | (1L << 47) | (1L << 48) | (1L << 50) | (1L << 51) | (1L << 52) | (1L << 53) | (1L << 54) | (1L << 55) | (1L << IF) | (1L << ELSE) | (1L << FOR) | (1L << WHILE) | (1L << BREAK) | (1L << CASE) | (1L << CONTINUE) | (1L << SWITCH))) != 0) || ((((_la - 64)) & ~0x3f) == 0 && ((1L << (_la - 64)) & ((1L << (DO - 64)) | (1L << (GOTO - 64)) | (1L << (RETURN - 64)) | (1L << (TYPEDEF - 64)) | (1L << (VOID - 64)) | (1L << (UNSIGNED - 64)) | (1L << (SIGNED - 64)) | (1L << (LONG - 64)) | (1L << (CV_QUALIFIER - 64)) | (1L << (VIRTUAL - 64)) | (1L << (TRY - 64)) | (1L << (CATCH - 64)) | (1L << (THROW - 64)) | (1L << (USING - 64)) | (1L << (NAMESPACE - 64)) | (1L << (AUTO - 64)) | (1L << (REGISTER - 64)) | (1L << (OPERATOR - 64)) | (1L << (TEMPLATE - 64)) | (1L << (CLASS_KEY - 64)) | (1L << (ALPHA_NUMERIC - 64)) | (1L << (OPENING_CURLY - 64)) | (1L << (CLOSING_CURLY - 64)) | (1L << (PRE_IF - 64)) | (1L << (PRE_ELSE - 64)) | (1L << (PRE_ENDIF - 64)) | (1L << (HEX_LITERAL - 64)) | (1L << (DECIMAL_LITERAL - 64)) | (1L << (OCTAL_LITERAL - 64)) | (1L << (FLOATING_POINT_LITERAL - 64)) | (1L << (CHAR - 64)) | (1L << (STRING - 64)) | (1L << (COMMENT - 64)) | (1L << (WHITESPACE - 64)) | (1L << (CPPCOMMENT - 64)) | (1L << (OTHER - 64)))) != 0) );
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
		enterRule(_localctx, 70, RULE_no_brackets);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(454);
			_la = _input.LA(1);
			if ( _la <= 0 || (_la==12 || _la==29) ) {
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
		enterRule(_localctx, 72, RULE_no_brackets_curlies_or_squares);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(456);
			_la = _input.LA(1);
			if ( _la <= 0 || ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << 2) | (1L << 12) | (1L << 21) | (1L << 29))) != 0) || _la==OPENING_CURLY || _la==CLOSING_CURLY) ) {
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
		enterRule(_localctx, 74, RULE_no_brackets_or_semicolon);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(458);
			_la = _input.LA(1);
			if ( _la <= 0 || ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << 12) | (1L << 29) | (1L << 46))) != 0)) ) {
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
		enterRule(_localctx, 76, RULE_no_angle_brackets_or_brackets);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(460);
			_la = _input.LA(1);
			if ( _la <= 0 || ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << 4) | (1L << 12) | (1L << 29) | (1L << 49))) != 0)) ) {
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
		enterRule(_localctx, 78, RULE_no_curlies);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(462);
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
		enterRule(_localctx, 80, RULE_no_squares);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(464);
			_la = _input.LA(1);
			if ( _la <= 0 || (_la==2 || _la==21) ) {
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
		enterRule(_localctx, 82, RULE_no_squares_or_semicolon);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(466);
			_la = _input.LA(1);
			if ( _la <= 0 || ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << 2) | (1L << 21) | (1L << 46))) != 0)) ) {
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
		enterRule(_localctx, 84, RULE_no_comma_or_semicolon);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(468);
			_la = _input.LA(1);
			if ( _la <= 0 || (_la==26 || _la==46) ) {
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
		enterRule(_localctx, 86, RULE_assign_water);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(470);
			_la = _input.LA(1);
			if ( _la <= 0 || ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << 2) | (1L << 12) | (1L << 21) | (1L << 26) | (1L << 29) | (1L << 46))) != 0) || _la==OPENING_CURLY || _la==CLOSING_CURLY) ) {
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
		enterRule(_localctx, 88, RULE_assign_water_l2);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(472);
			_la = _input.LA(1);
			if ( _la <= 0 || ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << 2) | (1L << 12) | (1L << 21) | (1L << 29))) != 0) || _la==OPENING_CURLY || _la==CLOSING_CURLY) ) {
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
		enterRule(_localctx, 90, RULE_water);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(474);
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
		enterRule(_localctx, 92, RULE_function_def);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(477);
			_la = _input.LA(1);
			if (_la==TEMPLATE) {
				{
				setState(476); template_decl_start();
				}
			}

			setState(480);
			switch ( getInterpreter().adaptivePredict(_input,32,_ctx) ) {
			case 1:
				{
				setState(479); return_type();
				}
				break;
			}
			setState(482); function_name();
			setState(483); function_param_list();
			setState(485);
			_la = _input.LA(1);
			if (_la==28) {
				{
				setState(484); ctor_list();
				}
			}

			setState(487); compound_statement();
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
		enterRule(_localctx, 94, RULE_return_type);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			{
			setState(492);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (((((_la - 13)) & ~0x3f) == 0 && ((1L << (_la - 13)) & ((1L << (13 - 13)) | (1L << (14 - 13)) | (1L << (37 - 13)) | (1L << (38 - 13)) | (1L << (VIRTUAL - 13)))) != 0)) {
				{
				{
				setState(489); function_decl_specifiers();
				}
				}
				setState(494);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(495); type_name();
			}
			setState(500);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==1 || _la==3) {
				{
				{
				setState(497); ptr_operator();
				}
				}
				setState(502);
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
		enterRule(_localctx, 96, RULE_function_param_list);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(503); match(29);
			setState(505);
			_la = _input.LA(1);
			if (((((_la - 68)) & ~0x3f) == 0 && ((1L << (_la - 68)) & ((1L << (VOID - 68)) | (1L << (UNSIGNED - 68)) | (1L << (SIGNED - 68)) | (1L << (LONG - 68)) | (1L << (CV_QUALIFIER - 68)) | (1L << (AUTO - 68)) | (1L << (REGISTER - 68)) | (1L << (CLASS_KEY - 68)) | (1L << (ALPHA_NUMERIC - 68)))) != 0)) {
				{
				setState(504); parameter_decl_clause();
				}
			}

			setState(507); match(12);
			setState(511);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==CV_QUALIFIER) {
				{
				{
				setState(508); match(CV_QUALIFIER);
				}
				}
				setState(513);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(515);
			_la = _input.LA(1);
			if (_la==THROW) {
				{
				setState(514); exception_specification();
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
		enterRule(_localctx, 98, RULE_parameter_decl_clause);
		int _la;
		try {
			int _alt;
			setState(530);
			switch ( getInterpreter().adaptivePredict(_input,41,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				{
				setState(517); parameter_decl();
				setState(522);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,39,_ctx);
				while ( _alt!=2 && _alt!=-1 ) {
					if ( _alt==1 ) {
						{
						{
						setState(518); match(26);
						setState(519); parameter_decl();
						}
						} 
					}
					setState(524);
					_errHandler.sync(this);
					_alt = getInterpreter().adaptivePredict(_input,39,_ctx);
				}
				}
				setState(527);
				_la = _input.LA(1);
				if (_la==26) {
					{
					setState(525); match(26);
					setState(526); match(34);
					}
				}

				}
				break;

			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(529); match(VOID);
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
		enterRule(_localctx, 100, RULE_parameter_decl);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(532); param_decl_specifiers();
			setState(533); parameter_id();
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
		enterRule(_localctx, 102, RULE_parameter_id);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(536);
			_la = _input.LA(1);
			if (_la==1 || _la==3) {
				{
				setState(535); ptrs();
				}
			}

			setState(543);
			switch (_input.LA(1)) {
			case 29:
				{
				setState(538); match(29);
				setState(539); parameter_id();
				setState(540); match(12);
				}
				break;
			case 25:
			case 31:
			case 45:
			case ALPHA_NUMERIC:
				{
				setState(542); parameter_name();
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
			setState(546);
			_la = _input.LA(1);
			if (_la==2 || _la==29) {
				{
				setState(545); type_suffix();
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
		enterRule(_localctx, 104, RULE_compound_statement);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(548); match(OPENING_CURLY);
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
		enterRule(_localctx, 106, RULE_ctor_list);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(551); match(28);
			setState(552); ctor_initializer();
			setState(557);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==26) {
				{
				{
				setState(553); match(26);
				setState(554); ctor_initializer();
				}
				}
				setState(559);
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
		enterRule(_localctx, 108, RULE_ctor_initializer);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(560); initializer_id();
			setState(561); ctor_expr();
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
		enterRule(_localctx, 110, RULE_initializer_id);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(564);
			_la = _input.LA(1);
			if (_la==15) {
				{
				setState(563); match(15);
				}
			}

			setState(566); identifier();
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
		enterRule(_localctx, 112, RULE_ctor_expr);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(568); match(29);
			setState(570);
			_la = _input.LA(1);
			if ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << 1) | (1L << 3) | (1L << 5) | (1L << 20) | (1L << 27) | (1L << 29) | (1L << 39) | (1L << 44) | (1L << 54))) != 0) || ((((_la - 84)) & ~0x3f) == 0 && ((1L << (_la - 84)) & ((1L << (ALPHA_NUMERIC - 84)) | (1L << (HEX_LITERAL - 84)) | (1L << (DECIMAL_LITERAL - 84)) | (1L << (OCTAL_LITERAL - 84)) | (1L << (FLOATING_POINT_LITERAL - 84)) | (1L << (CHAR - 84)) | (1L << (STRING - 84)))) != 0)) {
				{
				setState(569); expr();
				}
			}

			setState(572); match(12);
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
		public Function_nameContext function_name() {
			return getRuleContext(Function_nameContext.class,0);
		}
		public TerminalNode OPERATOR() { return getToken(CodeSensorParser.OPERATOR, 0); }
		public IdentifierContext identifier() {
			return getRuleContext(IdentifierContext.class,0);
		}
		public OperatorContext operator() {
			return getRuleContext(OperatorContext.class,0);
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
		enterRule(_localctx, 114, RULE_function_name);
		try {
			setState(581);
			switch (_input.LA(1)) {
			case 29:
				enterOuterAlt(_localctx, 1);
				{
				setState(574); match(29);
				setState(575); function_name();
				setState(576); match(12);
				}
				break;
			case ALPHA_NUMERIC:
				enterOuterAlt(_localctx, 2);
				{
				setState(578); identifier();
				}
				break;
			case OPERATOR:
				enterOuterAlt(_localctx, 3);
				{
				setState(579); match(OPERATOR);
				setState(580); operator();
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
		enterRule(_localctx, 116, RULE_exception_specification);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(583); match(THROW);
			setState(584); match(29);
			setState(585); type_id_list();
			setState(586); match(12);
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
		enterRule(_localctx, 118, RULE_type_id_list);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(591);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << 1) | (1L << 2) | (1L << 3) | (1L << 4) | (1L << 5) | (1L << 6) | (1L << 7) | (1L << 8) | (1L << 9) | (1L << 10) | (1L << 11) | (1L << 13) | (1L << 14) | (1L << 15) | (1L << 16) | (1L << 17) | (1L << 18) | (1L << 19) | (1L << 20) | (1L << 21) | (1L << 22) | (1L << 23) | (1L << 24) | (1L << 25) | (1L << 26) | (1L << 27) | (1L << 28) | (1L << 30) | (1L << 31) | (1L << 32) | (1L << 33) | (1L << 34) | (1L << 35) | (1L << 36) | (1L << 37) | (1L << 38) | (1L << 39) | (1L << 40) | (1L << 41) | (1L << 42) | (1L << 43) | (1L << 44) | (1L << 45) | (1L << 46) | (1L << 47) | (1L << 48) | (1L << 49) | (1L << 50) | (1L << 51) | (1L << 52) | (1L << 53) | (1L << 54) | (1L << 55) | (1L << IF) | (1L << ELSE) | (1L << FOR) | (1L << WHILE) | (1L << BREAK) | (1L << CASE) | (1L << CONTINUE) | (1L << SWITCH))) != 0) || ((((_la - 64)) & ~0x3f) == 0 && ((1L << (_la - 64)) & ((1L << (DO - 64)) | (1L << (GOTO - 64)) | (1L << (RETURN - 64)) | (1L << (TYPEDEF - 64)) | (1L << (VOID - 64)) | (1L << (UNSIGNED - 64)) | (1L << (SIGNED - 64)) | (1L << (LONG - 64)) | (1L << (CV_QUALIFIER - 64)) | (1L << (VIRTUAL - 64)) | (1L << (TRY - 64)) | (1L << (CATCH - 64)) | (1L << (THROW - 64)) | (1L << (USING - 64)) | (1L << (NAMESPACE - 64)) | (1L << (AUTO - 64)) | (1L << (REGISTER - 64)) | (1L << (OPERATOR - 64)) | (1L << (TEMPLATE - 64)) | (1L << (CLASS_KEY - 64)) | (1L << (ALPHA_NUMERIC - 64)) | (1L << (OPENING_CURLY - 64)) | (1L << (CLOSING_CURLY - 64)) | (1L << (PRE_IF - 64)) | (1L << (PRE_ELSE - 64)) | (1L << (PRE_ENDIF - 64)) | (1L << (HEX_LITERAL - 64)) | (1L << (DECIMAL_LITERAL - 64)) | (1L << (OCTAL_LITERAL - 64)) | (1L << (FLOATING_POINT_LITERAL - 64)) | (1L << (CHAR - 64)) | (1L << (STRING - 64)) | (1L << (COMMENT - 64)) | (1L << (WHITESPACE - 64)) | (1L << (CPPCOMMENT - 64)) | (1L << (OTHER - 64)))) != 0)) {
				{
				{
				setState(588); no_brackets();
				}
				}
				setState(593);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(605);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==29) {
				{
				{
				setState(594); match(29);
				setState(595); type_id_list();
				setState(596); match(12);
				setState(600);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << 1) | (1L << 2) | (1L << 3) | (1L << 4) | (1L << 5) | (1L << 6) | (1L << 7) | (1L << 8) | (1L << 9) | (1L << 10) | (1L << 11) | (1L << 13) | (1L << 14) | (1L << 15) | (1L << 16) | (1L << 17) | (1L << 18) | (1L << 19) | (1L << 20) | (1L << 21) | (1L << 22) | (1L << 23) | (1L << 24) | (1L << 25) | (1L << 26) | (1L << 27) | (1L << 28) | (1L << 30) | (1L << 31) | (1L << 32) | (1L << 33) | (1L << 34) | (1L << 35) | (1L << 36) | (1L << 37) | (1L << 38) | (1L << 39) | (1L << 40) | (1L << 41) | (1L << 42) | (1L << 43) | (1L << 44) | (1L << 45) | (1L << 46) | (1L << 47) | (1L << 48) | (1L << 49) | (1L << 50) | (1L << 51) | (1L << 52) | (1L << 53) | (1L << 54) | (1L << 55) | (1L << IF) | (1L << ELSE) | (1L << FOR) | (1L << WHILE) | (1L << BREAK) | (1L << CASE) | (1L << CONTINUE) | (1L << SWITCH))) != 0) || ((((_la - 64)) & ~0x3f) == 0 && ((1L << (_la - 64)) & ((1L << (DO - 64)) | (1L << (GOTO - 64)) | (1L << (RETURN - 64)) | (1L << (TYPEDEF - 64)) | (1L << (VOID - 64)) | (1L << (UNSIGNED - 64)) | (1L << (SIGNED - 64)) | (1L << (LONG - 64)) | (1L << (CV_QUALIFIER - 64)) | (1L << (VIRTUAL - 64)) | (1L << (TRY - 64)) | (1L << (CATCH - 64)) | (1L << (THROW - 64)) | (1L << (USING - 64)) | (1L << (NAMESPACE - 64)) | (1L << (AUTO - 64)) | (1L << (REGISTER - 64)) | (1L << (OPERATOR - 64)) | (1L << (TEMPLATE - 64)) | (1L << (CLASS_KEY - 64)) | (1L << (ALPHA_NUMERIC - 64)) | (1L << (OPENING_CURLY - 64)) | (1L << (CLOSING_CURLY - 64)) | (1L << (PRE_IF - 64)) | (1L << (PRE_ELSE - 64)) | (1L << (PRE_ENDIF - 64)) | (1L << (HEX_LITERAL - 64)) | (1L << (DECIMAL_LITERAL - 64)) | (1L << (OCTAL_LITERAL - 64)) | (1L << (FLOATING_POINT_LITERAL - 64)) | (1L << (CHAR - 64)) | (1L << (STRING - 64)) | (1L << (COMMENT - 64)) | (1L << (WHITESPACE - 64)) | (1L << (CPPCOMMENT - 64)) | (1L << (OTHER - 64)))) != 0)) {
					{
					{
					setState(597); no_brackets();
					}
					}
					setState(602);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				}
				}
				setState(607);
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
		enterRule(_localctx, 120, RULE_init_declarator);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			{
			setState(609);
			_la = _input.LA(1);
			if (_la==1 || _la==3) {
				{
				setState(608); ptrs();
				}
			}

			setState(611); identifier();
			setState(613);
			switch ( getInterpreter().adaptivePredict(_input,53,_ctx) ) {
			case 1:
				{
				setState(612); type_suffix();
				}
				break;
			}
			}
			setState(622);
			switch (_input.LA(1)) {
			case 29:
				{
				{
				setState(615); match(29);
				setState(617);
				_la = _input.LA(1);
				if ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << 1) | (1L << 3) | (1L << 5) | (1L << 20) | (1L << 27) | (1L << 29) | (1L << 39) | (1L << 44) | (1L << 54))) != 0) || ((((_la - 84)) & ~0x3f) == 0 && ((1L << (_la - 84)) & ((1L << (ALPHA_NUMERIC - 84)) | (1L << (HEX_LITERAL - 84)) | (1L << (DECIMAL_LITERAL - 84)) | (1L << (OCTAL_LITERAL - 84)) | (1L << (FLOATING_POINT_LITERAL - 84)) | (1L << (CHAR - 84)) | (1L << (STRING - 84)))) != 0)) {
					{
					setState(616); expr();
					}
				}

				setState(619); match(12);
				}
				}
				break;
			case 16:
				{
				{
				setState(620); match(16);
				setState(621); assign_expr_w_();
				}
				}
				break;
			case 26:
			case 46:
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
		enterRule(_localctx, 122, RULE_type_suffix);
		try {
			setState(629);
			switch (_input.LA(1)) {
			case 2:
				enterOuterAlt(_localctx, 1);
				{
				{
				setState(624); match(2);
				setState(625); constant_expr_w_();
				setState(626); match(21);
				}
				}
				break;
			case 29:
				enterOuterAlt(_localctx, 2);
				{
				setState(628); param_type_list();
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
		enterRule(_localctx, 124, RULE_assign_expr_w_);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(634);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << 1) | (1L << 3) | (1L << 4) | (1L << 5) | (1L << 6) | (1L << 7) | (1L << 8) | (1L << 9) | (1L << 10) | (1L << 11) | (1L << 13) | (1L << 14) | (1L << 15) | (1L << 16) | (1L << 17) | (1L << 18) | (1L << 19) | (1L << 20) | (1L << 22) | (1L << 23) | (1L << 24) | (1L << 25) | (1L << 27) | (1L << 28) | (1L << 30) | (1L << 31) | (1L << 32) | (1L << 33) | (1L << 34) | (1L << 35) | (1L << 36) | (1L << 37) | (1L << 38) | (1L << 39) | (1L << 40) | (1L << 41) | (1L << 42) | (1L << 43) | (1L << 44) | (1L << 45) | (1L << 47) | (1L << 48) | (1L << 49) | (1L << 50) | (1L << 51) | (1L << 52) | (1L << 53) | (1L << 54) | (1L << 55) | (1L << IF) | (1L << ELSE) | (1L << FOR) | (1L << WHILE) | (1L << BREAK) | (1L << CASE) | (1L << CONTINUE) | (1L << SWITCH))) != 0) || ((((_la - 64)) & ~0x3f) == 0 && ((1L << (_la - 64)) & ((1L << (DO - 64)) | (1L << (GOTO - 64)) | (1L << (RETURN - 64)) | (1L << (TYPEDEF - 64)) | (1L << (VOID - 64)) | (1L << (UNSIGNED - 64)) | (1L << (SIGNED - 64)) | (1L << (LONG - 64)) | (1L << (CV_QUALIFIER - 64)) | (1L << (VIRTUAL - 64)) | (1L << (TRY - 64)) | (1L << (CATCH - 64)) | (1L << (THROW - 64)) | (1L << (USING - 64)) | (1L << (NAMESPACE - 64)) | (1L << (AUTO - 64)) | (1L << (REGISTER - 64)) | (1L << (OPERATOR - 64)) | (1L << (TEMPLATE - 64)) | (1L << (CLASS_KEY - 64)) | (1L << (ALPHA_NUMERIC - 64)) | (1L << (PRE_IF - 64)) | (1L << (PRE_ELSE - 64)) | (1L << (PRE_ENDIF - 64)) | (1L << (HEX_LITERAL - 64)) | (1L << (DECIMAL_LITERAL - 64)) | (1L << (OCTAL_LITERAL - 64)) | (1L << (FLOATING_POINT_LITERAL - 64)) | (1L << (CHAR - 64)) | (1L << (STRING - 64)) | (1L << (COMMENT - 64)) | (1L << (WHITESPACE - 64)) | (1L << (CPPCOMMENT - 64)) | (1L << (OTHER - 64)))) != 0)) {
				{
				{
				setState(631); assign_water();
				}
				}
				setState(636);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(659);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==2 || _la==29 || _la==OPENING_CURLY) {
				{
				{
				setState(649);
				switch (_input.LA(1)) {
				case OPENING_CURLY:
					{
					setState(637); match(OPENING_CURLY);
					setState(638); assign_expr_w__l2();
					setState(639); match(CLOSING_CURLY);
					}
					break;
				case 29:
					{
					setState(641); match(29);
					setState(642); assign_expr_w__l2();
					setState(643); match(12);
					}
					break;
				case 2:
					{
					setState(645); match(2);
					setState(646); assign_expr_w__l2();
					setState(647); match(21);
					}
					break;
				default:
					throw new NoViableAltException(this);
				}
				setState(654);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << 1) | (1L << 3) | (1L << 4) | (1L << 5) | (1L << 6) | (1L << 7) | (1L << 8) | (1L << 9) | (1L << 10) | (1L << 11) | (1L << 13) | (1L << 14) | (1L << 15) | (1L << 16) | (1L << 17) | (1L << 18) | (1L << 19) | (1L << 20) | (1L << 22) | (1L << 23) | (1L << 24) | (1L << 25) | (1L << 27) | (1L << 28) | (1L << 30) | (1L << 31) | (1L << 32) | (1L << 33) | (1L << 34) | (1L << 35) | (1L << 36) | (1L << 37) | (1L << 38) | (1L << 39) | (1L << 40) | (1L << 41) | (1L << 42) | (1L << 43) | (1L << 44) | (1L << 45) | (1L << 47) | (1L << 48) | (1L << 49) | (1L << 50) | (1L << 51) | (1L << 52) | (1L << 53) | (1L << 54) | (1L << 55) | (1L << IF) | (1L << ELSE) | (1L << FOR) | (1L << WHILE) | (1L << BREAK) | (1L << CASE) | (1L << CONTINUE) | (1L << SWITCH))) != 0) || ((((_la - 64)) & ~0x3f) == 0 && ((1L << (_la - 64)) & ((1L << (DO - 64)) | (1L << (GOTO - 64)) | (1L << (RETURN - 64)) | (1L << (TYPEDEF - 64)) | (1L << (VOID - 64)) | (1L << (UNSIGNED - 64)) | (1L << (SIGNED - 64)) | (1L << (LONG - 64)) | (1L << (CV_QUALIFIER - 64)) | (1L << (VIRTUAL - 64)) | (1L << (TRY - 64)) | (1L << (CATCH - 64)) | (1L << (THROW - 64)) | (1L << (USING - 64)) | (1L << (NAMESPACE - 64)) | (1L << (AUTO - 64)) | (1L << (REGISTER - 64)) | (1L << (OPERATOR - 64)) | (1L << (TEMPLATE - 64)) | (1L << (CLASS_KEY - 64)) | (1L << (ALPHA_NUMERIC - 64)) | (1L << (PRE_IF - 64)) | (1L << (PRE_ELSE - 64)) | (1L << (PRE_ENDIF - 64)) | (1L << (HEX_LITERAL - 64)) | (1L << (DECIMAL_LITERAL - 64)) | (1L << (OCTAL_LITERAL - 64)) | (1L << (FLOATING_POINT_LITERAL - 64)) | (1L << (CHAR - 64)) | (1L << (STRING - 64)) | (1L << (COMMENT - 64)) | (1L << (WHITESPACE - 64)) | (1L << (CPPCOMMENT - 64)) | (1L << (OTHER - 64)))) != 0)) {
					{
					{
					setState(651); assign_water();
					}
					}
					setState(656);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				}
				}
				setState(661);
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
		enterRule(_localctx, 126, RULE_assign_expr_w__l2);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(665);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << 1) | (1L << 3) | (1L << 4) | (1L << 5) | (1L << 6) | (1L << 7) | (1L << 8) | (1L << 9) | (1L << 10) | (1L << 11) | (1L << 13) | (1L << 14) | (1L << 15) | (1L << 16) | (1L << 17) | (1L << 18) | (1L << 19) | (1L << 20) | (1L << 22) | (1L << 23) | (1L << 24) | (1L << 25) | (1L << 26) | (1L << 27) | (1L << 28) | (1L << 30) | (1L << 31) | (1L << 32) | (1L << 33) | (1L << 34) | (1L << 35) | (1L << 36) | (1L << 37) | (1L << 38) | (1L << 39) | (1L << 40) | (1L << 41) | (1L << 42) | (1L << 43) | (1L << 44) | (1L << 45) | (1L << 46) | (1L << 47) | (1L << 48) | (1L << 49) | (1L << 50) | (1L << 51) | (1L << 52) | (1L << 53) | (1L << 54) | (1L << 55) | (1L << IF) | (1L << ELSE) | (1L << FOR) | (1L << WHILE) | (1L << BREAK) | (1L << CASE) | (1L << CONTINUE) | (1L << SWITCH))) != 0) || ((((_la - 64)) & ~0x3f) == 0 && ((1L << (_la - 64)) & ((1L << (DO - 64)) | (1L << (GOTO - 64)) | (1L << (RETURN - 64)) | (1L << (TYPEDEF - 64)) | (1L << (VOID - 64)) | (1L << (UNSIGNED - 64)) | (1L << (SIGNED - 64)) | (1L << (LONG - 64)) | (1L << (CV_QUALIFIER - 64)) | (1L << (VIRTUAL - 64)) | (1L << (TRY - 64)) | (1L << (CATCH - 64)) | (1L << (THROW - 64)) | (1L << (USING - 64)) | (1L << (NAMESPACE - 64)) | (1L << (AUTO - 64)) | (1L << (REGISTER - 64)) | (1L << (OPERATOR - 64)) | (1L << (TEMPLATE - 64)) | (1L << (CLASS_KEY - 64)) | (1L << (ALPHA_NUMERIC - 64)) | (1L << (PRE_IF - 64)) | (1L << (PRE_ELSE - 64)) | (1L << (PRE_ENDIF - 64)) | (1L << (HEX_LITERAL - 64)) | (1L << (DECIMAL_LITERAL - 64)) | (1L << (OCTAL_LITERAL - 64)) | (1L << (FLOATING_POINT_LITERAL - 64)) | (1L << (CHAR - 64)) | (1L << (STRING - 64)) | (1L << (COMMENT - 64)) | (1L << (WHITESPACE - 64)) | (1L << (CPPCOMMENT - 64)) | (1L << (OTHER - 64)))) != 0)) {
				{
				{
				setState(662); assign_water_l2();
				}
				}
				setState(667);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(690);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==2 || _la==29 || _la==OPENING_CURLY) {
				{
				{
				setState(680);
				switch (_input.LA(1)) {
				case OPENING_CURLY:
					{
					setState(668); match(OPENING_CURLY);
					setState(669); assign_expr_w__l2();
					setState(670); match(CLOSING_CURLY);
					}
					break;
				case 29:
					{
					setState(672); match(29);
					setState(673); assign_expr_w__l2();
					setState(674); match(12);
					}
					break;
				case 2:
					{
					setState(676); match(2);
					setState(677); assign_expr_w__l2();
					setState(678); match(21);
					}
					break;
				default:
					throw new NoViableAltException(this);
				}
				setState(685);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << 1) | (1L << 3) | (1L << 4) | (1L << 5) | (1L << 6) | (1L << 7) | (1L << 8) | (1L << 9) | (1L << 10) | (1L << 11) | (1L << 13) | (1L << 14) | (1L << 15) | (1L << 16) | (1L << 17) | (1L << 18) | (1L << 19) | (1L << 20) | (1L << 22) | (1L << 23) | (1L << 24) | (1L << 25) | (1L << 26) | (1L << 27) | (1L << 28) | (1L << 30) | (1L << 31) | (1L << 32) | (1L << 33) | (1L << 34) | (1L << 35) | (1L << 36) | (1L << 37) | (1L << 38) | (1L << 39) | (1L << 40) | (1L << 41) | (1L << 42) | (1L << 43) | (1L << 44) | (1L << 45) | (1L << 46) | (1L << 47) | (1L << 48) | (1L << 49) | (1L << 50) | (1L << 51) | (1L << 52) | (1L << 53) | (1L << 54) | (1L << 55) | (1L << IF) | (1L << ELSE) | (1L << FOR) | (1L << WHILE) | (1L << BREAK) | (1L << CASE) | (1L << CONTINUE) | (1L << SWITCH))) != 0) || ((((_la - 64)) & ~0x3f) == 0 && ((1L << (_la - 64)) & ((1L << (DO - 64)) | (1L << (GOTO - 64)) | (1L << (RETURN - 64)) | (1L << (TYPEDEF - 64)) | (1L << (VOID - 64)) | (1L << (UNSIGNED - 64)) | (1L << (SIGNED - 64)) | (1L << (LONG - 64)) | (1L << (CV_QUALIFIER - 64)) | (1L << (VIRTUAL - 64)) | (1L << (TRY - 64)) | (1L << (CATCH - 64)) | (1L << (THROW - 64)) | (1L << (USING - 64)) | (1L << (NAMESPACE - 64)) | (1L << (AUTO - 64)) | (1L << (REGISTER - 64)) | (1L << (OPERATOR - 64)) | (1L << (TEMPLATE - 64)) | (1L << (CLASS_KEY - 64)) | (1L << (ALPHA_NUMERIC - 64)) | (1L << (PRE_IF - 64)) | (1L << (PRE_ELSE - 64)) | (1L << (PRE_ENDIF - 64)) | (1L << (HEX_LITERAL - 64)) | (1L << (DECIMAL_LITERAL - 64)) | (1L << (OCTAL_LITERAL - 64)) | (1L << (FLOATING_POINT_LITERAL - 64)) | (1L << (CHAR - 64)) | (1L << (STRING - 64)) | (1L << (COMMENT - 64)) | (1L << (WHITESPACE - 64)) | (1L << (CPPCOMMENT - 64)) | (1L << (OTHER - 64)))) != 0)) {
					{
					{
					setState(682); assign_water_l2();
					}
					}
					setState(687);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				}
				}
				setState(692);
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
		enterRule(_localctx, 128, RULE_constant_expr_w_);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(696);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << 1) | (1L << 3) | (1L << 4) | (1L << 5) | (1L << 6) | (1L << 7) | (1L << 8) | (1L << 9) | (1L << 10) | (1L << 11) | (1L << 12) | (1L << 13) | (1L << 14) | (1L << 15) | (1L << 16) | (1L << 17) | (1L << 18) | (1L << 19) | (1L << 20) | (1L << 22) | (1L << 23) | (1L << 24) | (1L << 25) | (1L << 26) | (1L << 27) | (1L << 28) | (1L << 29) | (1L << 30) | (1L << 31) | (1L << 32) | (1L << 33) | (1L << 34) | (1L << 35) | (1L << 36) | (1L << 37) | (1L << 38) | (1L << 39) | (1L << 40) | (1L << 41) | (1L << 42) | (1L << 43) | (1L << 44) | (1L << 45) | (1L << 46) | (1L << 47) | (1L << 48) | (1L << 49) | (1L << 50) | (1L << 51) | (1L << 52) | (1L << 53) | (1L << 54) | (1L << 55) | (1L << IF) | (1L << ELSE) | (1L << FOR) | (1L << WHILE) | (1L << BREAK) | (1L << CASE) | (1L << CONTINUE) | (1L << SWITCH))) != 0) || ((((_la - 64)) & ~0x3f) == 0 && ((1L << (_la - 64)) & ((1L << (DO - 64)) | (1L << (GOTO - 64)) | (1L << (RETURN - 64)) | (1L << (TYPEDEF - 64)) | (1L << (VOID - 64)) | (1L << (UNSIGNED - 64)) | (1L << (SIGNED - 64)) | (1L << (LONG - 64)) | (1L << (CV_QUALIFIER - 64)) | (1L << (VIRTUAL - 64)) | (1L << (TRY - 64)) | (1L << (CATCH - 64)) | (1L << (THROW - 64)) | (1L << (USING - 64)) | (1L << (NAMESPACE - 64)) | (1L << (AUTO - 64)) | (1L << (REGISTER - 64)) | (1L << (OPERATOR - 64)) | (1L << (TEMPLATE - 64)) | (1L << (CLASS_KEY - 64)) | (1L << (ALPHA_NUMERIC - 64)) | (1L << (OPENING_CURLY - 64)) | (1L << (CLOSING_CURLY - 64)) | (1L << (PRE_IF - 64)) | (1L << (PRE_ELSE - 64)) | (1L << (PRE_ENDIF - 64)) | (1L << (HEX_LITERAL - 64)) | (1L << (DECIMAL_LITERAL - 64)) | (1L << (OCTAL_LITERAL - 64)) | (1L << (FLOATING_POINT_LITERAL - 64)) | (1L << (CHAR - 64)) | (1L << (STRING - 64)) | (1L << (COMMENT - 64)) | (1L << (WHITESPACE - 64)) | (1L << (CPPCOMMENT - 64)) | (1L << (OTHER - 64)))) != 0)) {
				{
				{
				setState(693); no_squares();
				}
				}
				setState(698);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(710);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==2) {
				{
				{
				setState(699); match(2);
				setState(700); constant_expr_w_();
				setState(701); match(21);
				setState(705);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << 1) | (1L << 3) | (1L << 4) | (1L << 5) | (1L << 6) | (1L << 7) | (1L << 8) | (1L << 9) | (1L << 10) | (1L << 11) | (1L << 12) | (1L << 13) | (1L << 14) | (1L << 15) | (1L << 16) | (1L << 17) | (1L << 18) | (1L << 19) | (1L << 20) | (1L << 22) | (1L << 23) | (1L << 24) | (1L << 25) | (1L << 26) | (1L << 27) | (1L << 28) | (1L << 29) | (1L << 30) | (1L << 31) | (1L << 32) | (1L << 33) | (1L << 34) | (1L << 35) | (1L << 36) | (1L << 37) | (1L << 38) | (1L << 39) | (1L << 40) | (1L << 41) | (1L << 42) | (1L << 43) | (1L << 44) | (1L << 45) | (1L << 46) | (1L << 47) | (1L << 48) | (1L << 49) | (1L << 50) | (1L << 51) | (1L << 52) | (1L << 53) | (1L << 54) | (1L << 55) | (1L << IF) | (1L << ELSE) | (1L << FOR) | (1L << WHILE) | (1L << BREAK) | (1L << CASE) | (1L << CONTINUE) | (1L << SWITCH))) != 0) || ((((_la - 64)) & ~0x3f) == 0 && ((1L << (_la - 64)) & ((1L << (DO - 64)) | (1L << (GOTO - 64)) | (1L << (RETURN - 64)) | (1L << (TYPEDEF - 64)) | (1L << (VOID - 64)) | (1L << (UNSIGNED - 64)) | (1L << (SIGNED - 64)) | (1L << (LONG - 64)) | (1L << (CV_QUALIFIER - 64)) | (1L << (VIRTUAL - 64)) | (1L << (TRY - 64)) | (1L << (CATCH - 64)) | (1L << (THROW - 64)) | (1L << (USING - 64)) | (1L << (NAMESPACE - 64)) | (1L << (AUTO - 64)) | (1L << (REGISTER - 64)) | (1L << (OPERATOR - 64)) | (1L << (TEMPLATE - 64)) | (1L << (CLASS_KEY - 64)) | (1L << (ALPHA_NUMERIC - 64)) | (1L << (OPENING_CURLY - 64)) | (1L << (CLOSING_CURLY - 64)) | (1L << (PRE_IF - 64)) | (1L << (PRE_ELSE - 64)) | (1L << (PRE_ENDIF - 64)) | (1L << (HEX_LITERAL - 64)) | (1L << (DECIMAL_LITERAL - 64)) | (1L << (OCTAL_LITERAL - 64)) | (1L << (FLOATING_POINT_LITERAL - 64)) | (1L << (CHAR - 64)) | (1L << (STRING - 64)) | (1L << (COMMENT - 64)) | (1L << (WHITESPACE - 64)) | (1L << (CPPCOMMENT - 64)) | (1L << (OTHER - 64)))) != 0)) {
					{
					{
					setState(702); no_squares();
					}
					}
					setState(707);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				}
				}
				setState(712);
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
		enterRule(_localctx, 130, RULE_simple_decl);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			{
			setState(714);
			_la = _input.LA(1);
			if (_la==TYPEDEF) {
				{
				setState(713); match(TYPEDEF);
				}
			}

			setState(717);
			_la = _input.LA(1);
			if (_la==TEMPLATE) {
				{
				setState(716); template_decl_start();
				}
			}

			}
			setState(719); var_decl();
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
		enterRule(_localctx, 132, RULE_var_decl);
		try {
			setState(728);
			switch ( getInterpreter().adaptivePredict(_input,71,_ctx) ) {
			case 1:
				_localctx = new DeclByClassContext(_localctx);
				enterOuterAlt(_localctx, 1);
				{
				setState(721); class_def();
				setState(723);
				switch ( getInterpreter().adaptivePredict(_input,70,_ctx) ) {
				case 1:
					{
					setState(722); init_declarator_list();
					}
					break;
				}
				}
				break;

			case 2:
				_localctx = new DeclByTypeContext(_localctx);
				enterOuterAlt(_localctx, 2);
				{
				setState(725); type_name();
				setState(726); init_declarator_list();
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
		enterRule(_localctx, 134, RULE_init_declarator_list);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(730); init_declarator();
			setState(735);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==26) {
				{
				{
				setState(731); match(26);
				setState(732); init_declarator();
				}
				}
				setState(737);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(738); match(46);
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
		enterRule(_localctx, 136, RULE_initializer);
		try {
			setState(745);
			switch (_input.LA(1)) {
			case 1:
			case 3:
			case 5:
			case 20:
			case 27:
			case 29:
			case 39:
			case 44:
			case 54:
			case ALPHA_NUMERIC:
			case HEX_LITERAL:
			case DECIMAL_LITERAL:
			case OCTAL_LITERAL:
			case FLOATING_POINT_LITERAL:
			case CHAR:
			case STRING:
				enterOuterAlt(_localctx, 1);
				{
				setState(740); assign_expr();
				}
				break;
			case OPENING_CURLY:
				enterOuterAlt(_localctx, 2);
				{
				setState(741); match(OPENING_CURLY);
				setState(742); initializer_list();
				setState(743); match(CLOSING_CURLY);
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
		enterRule(_localctx, 138, RULE_initializer_list);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(747); initializer();
			setState(752);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==26) {
				{
				{
				setState(748); match(26);
				setState(749); initializer();
				}
				}
				setState(754);
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
		enterRule(_localctx, 140, RULE_class_def);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(755); match(CLASS_KEY);
			setState(757);
			_la = _input.LA(1);
			if (_la==ALPHA_NUMERIC) {
				{
				setState(756); class_name();
				}
			}

			setState(760);
			_la = _input.LA(1);
			if (_la==28) {
				{
				setState(759); base_classes();
				}
			}

			setState(762); match(OPENING_CURLY);
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
		enterRule(_localctx, 142, RULE_class_name);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(765); identifier();
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
		enterRule(_localctx, 144, RULE_base_classes);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(767); match(28);
			setState(768); base_class();
			setState(773);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==26) {
				{
				{
				setState(769); match(26);
				setState(770); base_class();
				}
				}
				setState(775);
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
		enterRule(_localctx, 146, RULE_base_class);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(777);
			_la = _input.LA(1);
			if (_la==VIRTUAL) {
				{
				setState(776); match(VIRTUAL);
				}
			}

			setState(780);
			_la = _input.LA(1);
			if ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << 25) | (1L << 31) | (1L << 45))) != 0)) {
				{
				setState(779); access_specifier();
				}
			}

			setState(782); identifier();
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
		enterRule(_localctx, 148, RULE_type_name);
		int _la;
		try {
			setState(815);
			switch ( getInterpreter().adaptivePredict(_input,85,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				{
				setState(787);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (_la==CV_QUALIFIER) {
					{
					{
					setState(784); match(CV_QUALIFIER);
					}
					}
					setState(789);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				setState(791);
				_la = _input.LA(1);
				if (((((_la - 69)) & ~0x3f) == 0 && ((1L << (_la - 69)) & ((1L << (UNSIGNED - 69)) | (1L << (SIGNED - 69)) | (1L << (CLASS_KEY - 69)))) != 0)) {
					{
					setState(790);
					_la = _input.LA(1);
					if ( !(((((_la - 69)) & ~0x3f) == 0 && ((1L << (_la - 69)) & ((1L << (UNSIGNED - 69)) | (1L << (SIGNED - 69)) | (1L << (CLASS_KEY - 69)))) != 0)) ) {
					_errHandler.recoverInline(this);
					}
					consume();
					}
				}

				setState(793); base_type();
				setState(798);
				_la = _input.LA(1);
				if (_la==4) {
					{
					setState(794); match(4);
					setState(795); template_param_list();
					setState(796); match(49);
					}
				}

				setState(810);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (_la==15) {
					{
					{
					setState(800); match(15);
					setState(801); base_type();
					setState(806);
					_la = _input.LA(1);
					if (_la==4) {
						{
						setState(802); match(4);
						setState(803); template_param_list();
						setState(804); match(49);
						}
					}

					}
					}
					setState(812);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				}
				}
				break;

			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(813); match(UNSIGNED);
				}
				break;

			case 3:
				enterOuterAlt(_localctx, 3);
				{
				setState(814); match(SIGNED);
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
		enterRule(_localctx, 150, RULE_base_type);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(822);
			switch ( getInterpreter().adaptivePredict(_input,86,_ctx) ) {
			case 1:
				{
				setState(817); match(ALPHA_NUMERIC);
				}
				break;

			case 2:
				{
				setState(818); match(VOID);
				}
				break;

			case 3:
				{
				setState(819); match(LONG);
				}
				break;

			case 4:
				{
				setState(820); match(LONG);
				setState(821); match(LONG);
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
		enterRule(_localctx, 152, RULE_param_decl_specifiers);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(825);
			_la = _input.LA(1);
			if (_la==AUTO || _la==REGISTER) {
				{
				setState(824);
				_la = _input.LA(1);
				if ( !(_la==AUTO || _la==REGISTER) ) {
				_errHandler.recoverInline(this);
				}
				consume();
				}
			}

			setState(827); type_name();
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
		enterRule(_localctx, 154, RULE_parameter_name);
		try {
			setState(831);
			switch (_input.LA(1)) {
			case ALPHA_NUMERIC:
				enterOuterAlt(_localctx, 1);
				{
				setState(829); identifier();
				}
				break;
			case 25:
			case 31:
			case 45:
				enterOuterAlt(_localctx, 2);
				{
				setState(830); access_specifier();
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
		enterRule(_localctx, 156, RULE_param_type_list);
		int _la;
		try {
			setState(848);
			switch ( getInterpreter().adaptivePredict(_input,91,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(833); match(29);
				setState(834); match(VOID);
				setState(835); match(12);
				}
				break;

			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(836); match(29);
				setState(845);
				_la = _input.LA(1);
				if (((((_la - 68)) & ~0x3f) == 0 && ((1L << (_la - 68)) & ((1L << (VOID - 68)) | (1L << (UNSIGNED - 68)) | (1L << (SIGNED - 68)) | (1L << (LONG - 68)) | (1L << (CV_QUALIFIER - 68)) | (1L << (AUTO - 68)) | (1L << (REGISTER - 68)) | (1L << (CLASS_KEY - 68)) | (1L << (ALPHA_NUMERIC - 68)))) != 0)) {
					{
					setState(837); param_type();
					setState(842);
					_errHandler.sync(this);
					_la = _input.LA(1);
					while (_la==26) {
						{
						{
						setState(838); match(26);
						setState(839); param_type();
						}
						}
						setState(844);
						_errHandler.sync(this);
						_la = _input.LA(1);
					}
					}
				}

				setState(847); match(12);
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
		enterRule(_localctx, 158, RULE_param_type);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(850); param_decl_specifiers();
			setState(851); param_type_id();
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
		enterRule(_localctx, 160, RULE_param_type_id);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(854);
			_la = _input.LA(1);
			if (_la==1 || _la==3) {
				{
				setState(853); ptrs();
				}
			}

			setState(863);
			switch ( getInterpreter().adaptivePredict(_input,94,_ctx) ) {
			case 1:
				{
				setState(856); match(29);
				setState(857); param_type_id();
				setState(858); match(12);
				}
				break;

			case 2:
				{
				setState(861);
				_la = _input.LA(1);
				if (((((_la - 25)) & ~0x3f) == 0 && ((1L << (_la - 25)) & ((1L << (25 - 25)) | (1L << (31 - 25)) | (1L << (45 - 25)) | (1L << (ALPHA_NUMERIC - 25)))) != 0)) {
					{
					setState(860); parameter_name();
					}
				}

				}
				break;
			}
			setState(866);
			_la = _input.LA(1);
			if (_la==2 || _la==29) {
				{
				setState(865); type_suffix();
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
		enterRule(_localctx, 162, RULE_identifier);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(868); match(ALPHA_NUMERIC);
			setState(873);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==15) {
				{
				{
				setState(869); match(15);
				setState(870); match(ALPHA_NUMERIC);
				}
				}
				setState(875);
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
		enterRule(_localctx, 164, RULE_number);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(876);
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
		enterRule(_localctx, 166, RULE_ptrs);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(879); 
			_errHandler.sync(this);
			_la = _input.LA(1);
			do {
				{
				{
				setState(878); ptr_operator();
				}
				}
				setState(881); 
				_errHandler.sync(this);
				_la = _input.LA(1);
			} while ( _la==1 || _la==3 );
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
		"\2\3e\u0376\4\2\t\2\4\3\t\3\4\4\t\4\4\5\t\5\4\6\t\6\4\7\t\7\4\b\t\b\4"+
		"\t\t\t\4\n\t\n\4\13\t\13\4\f\t\f\4\r\t\r\4\16\t\16\4\17\t\17\4\20\t\20"+
		"\4\21\t\21\4\22\t\22\4\23\t\23\4\24\t\24\4\25\t\25\4\26\t\26\4\27\t\27"+
		"\4\30\t\30\4\31\t\31\4\32\t\32\4\33\t\33\4\34\t\34\4\35\t\35\4\36\t\36"+
		"\4\37\t\37\4 \t \4!\t!\4\"\t\"\4#\t#\4$\t$\4%\t%\4&\t&\4\'\t\'\4(\t(\4"+
		")\t)\4*\t*\4+\t+\4,\t,\4-\t-\4.\t.\4/\t/\4\60\t\60\4\61\t\61\4\62\t\62"+
		"\4\63\t\63\4\64\t\64\4\65\t\65\4\66\t\66\4\67\t\67\48\t8\49\t9\4:\t:\4"+
		";\t;\4<\t<\4=\t=\4>\t>\4?\t?\4@\t@\4A\tA\4B\tB\4C\tC\4D\tD\4E\tE\4F\t"+
		"F\4G\tG\4H\tH\4I\tI\4J\tJ\4K\tK\4L\tL\4M\tM\4N\tN\4O\tO\4P\tP\4Q\tQ\4"+
		"R\tR\4S\tS\4T\tT\4U\tU\3\2\3\2\3\2\3\2\7\2\u00af\n\2\f\2\16\2\u00b2\13"+
		"\2\3\3\3\3\3\3\3\3\3\3\3\4\3\4\3\4\5\4\u00bc\n\4\3\5\3\5\3\5\3\5\7\5\u00c2"+
		"\n\5\f\5\16\5\u00c5\13\5\3\6\3\6\3\6\3\6\3\6\3\6\5\6\u00cd\n\6\3\7\3\7"+
		"\3\7\7\7\u00d2\n\7\f\7\16\7\u00d5\13\7\3\b\3\b\3\b\7\b\u00da\n\b\f\b\16"+
		"\b\u00dd\13\b\3\t\3\t\3\t\7\t\u00e2\n\t\f\t\16\t\u00e5\13\t\3\n\3\n\3"+
		"\n\7\n\u00ea\n\n\f\n\16\n\u00ed\13\n\3\13\3\13\3\13\7\13\u00f2\n\13\f"+
		"\13\16\13\u00f5\13\13\3\f\3\f\3\f\3\f\7\f\u00fb\n\f\f\f\16\f\u00fe\13"+
		"\f\3\r\3\r\3\r\3\r\7\r\u0104\n\r\f\r\16\r\u0107\13\r\3\16\3\16\3\16\7"+
		"\16\u010c\n\16\f\16\16\16\u010f\13\16\3\17\3\17\3\17\7\17\u0114\n\17\f"+
		"\17\16\17\u0117\13\17\3\20\3\20\3\20\7\20\u011c\n\20\f\20\16\20\u011f"+
		"\13\20\3\21\3\21\3\21\7\21\u0124\n\21\f\21\16\21\u0127\13\21\3\21\3\21"+
		"\3\21\3\21\5\21\u012d\n\21\3\22\3\22\3\22\3\22\3\22\3\22\3\22\5\22\u0136"+
		"\n\22\3\22\3\22\3\22\3\22\3\22\3\22\5\22\u013e\n\22\3\23\7\23\u0141\n"+
		"\23\f\23\16\23\u0144\13\23\3\24\7\24\u0147\n\24\f\24\16\24\u014a\13\24"+
		"\3\25\3\25\7\25\u014e\n\25\f\25\16\25\u0151\13\25\3\26\3\26\3\26\3\26"+
		"\7\26\u0157\n\26\f\26\16\26\u015a\13\26\5\26\u015c\n\26\3\26\3\26\3\27"+
		"\3\27\3\30\3\30\3\30\3\30\3\30\3\30\3\30\3\30\5\30\u016a\n\30\3\30\3\30"+
		"\5\30\u016e\n\30\3\31\3\31\3\31\3\31\3\31\3\31\5\31\u0176\n\31\3\32\3"+
		"\32\3\33\3\33\3\34\3\34\3\35\3\35\3\36\3\36\3\37\3\37\3 \3 \3 \5 \u0187"+
		"\n \3 \3 \3 \3 \3 \3 \3 \3 \3 \3 \3 \3 \3 \3 \3 \3 \3 \3 \3 \3 \3 \3 "+
		"\3 \3 \3 \3 \3 \3 \3 \3 \3 \3 \3 \3 \3 \3 \3 \3 \3 \3 \5 \u01b1\n \3!"+
		"\3!\3\"\3\"\3#\3#\3#\3#\3#\3$\3$\3$\3$\3$\3$\3$\3$\3$\6$\u01c5\n$\r$\16"+
		"$\u01c6\3%\3%\3&\3&\3\'\3\'\3(\3(\3)\3)\3*\3*\3+\3+\3,\3,\3-\3-\3.\3."+
		"\3/\3/\3\60\5\60\u01e0\n\60\3\60\5\60\u01e3\n\60\3\60\3\60\3\60\5\60\u01e8"+
		"\n\60\3\60\3\60\3\61\7\61\u01ed\n\61\f\61\16\61\u01f0\13\61\3\61\3\61"+
		"\3\61\7\61\u01f5\n\61\f\61\16\61\u01f8\13\61\3\62\3\62\5\62\u01fc\n\62"+
		"\3\62\3\62\7\62\u0200\n\62\f\62\16\62\u0203\13\62\3\62\5\62\u0206\n\62"+
		"\3\63\3\63\3\63\7\63\u020b\n\63\f\63\16\63\u020e\13\63\3\63\3\63\5\63"+
		"\u0212\n\63\3\63\5\63\u0215\n\63\3\64\3\64\3\64\3\65\5\65\u021b\n\65\3"+
		"\65\3\65\3\65\3\65\3\65\5\65\u0222\n\65\3\65\5\65\u0225\n\65\3\66\3\66"+
		"\3\66\3\67\3\67\3\67\3\67\7\67\u022e\n\67\f\67\16\67\u0231\13\67\38\3"+
		"8\38\39\59\u0237\n9\39\39\3:\3:\5:\u023d\n:\3:\3:\3;\3;\3;\3;\3;\3;\3"+
		";\5;\u0248\n;\3<\3<\3<\3<\3<\3=\7=\u0250\n=\f=\16=\u0253\13=\3=\3=\3="+
		"\3=\7=\u0259\n=\f=\16=\u025c\13=\7=\u025e\n=\f=\16=\u0261\13=\3>\5>\u0264"+
		"\n>\3>\3>\5>\u0268\n>\3>\3>\5>\u026c\n>\3>\3>\3>\5>\u0271\n>\3?\3?\3?"+
		"\3?\3?\5?\u0278\n?\3@\7@\u027b\n@\f@\16@\u027e\13@\3@\3@\3@\3@\3@\3@\3"+
		"@\3@\3@\3@\3@\3@\5@\u028c\n@\3@\7@\u028f\n@\f@\16@\u0292\13@\7@\u0294"+
		"\n@\f@\16@\u0297\13@\3A\7A\u029a\nA\fA\16A\u029d\13A\3A\3A\3A\3A\3A\3"+
		"A\3A\3A\3A\3A\3A\3A\5A\u02ab\nA\3A\7A\u02ae\nA\fA\16A\u02b1\13A\7A\u02b3"+
		"\nA\fA\16A\u02b6\13A\3B\7B\u02b9\nB\fB\16B\u02bc\13B\3B\3B\3B\3B\7B\u02c2"+
		"\nB\fB\16B\u02c5\13B\7B\u02c7\nB\fB\16B\u02ca\13B\3C\5C\u02cd\nC\3C\5"+
		"C\u02d0\nC\3C\3C\3D\3D\5D\u02d6\nD\3D\3D\3D\5D\u02db\nD\3E\3E\3E\7E\u02e0"+
		"\nE\fE\16E\u02e3\13E\3E\3E\3F\3F\3F\3F\3F\5F\u02ec\nF\3G\3G\3G\7G\u02f1"+
		"\nG\fG\16G\u02f4\13G\3H\3H\5H\u02f8\nH\3H\5H\u02fb\nH\3H\3H\3H\3I\3I\3"+
		"J\3J\3J\3J\7J\u0306\nJ\fJ\16J\u0309\13J\3K\5K\u030c\nK\3K\5K\u030f\nK"+
		"\3K\3K\3L\7L\u0314\nL\fL\16L\u0317\13L\3L\5L\u031a\nL\3L\3L\3L\3L\3L\5"+
		"L\u0321\nL\3L\3L\3L\3L\3L\3L\5L\u0329\nL\7L\u032b\nL\fL\16L\u032e\13L"+
		"\3L\3L\5L\u0332\nL\3M\3M\3M\3M\3M\5M\u0339\nM\3N\5N\u033c\nN\3N\3N\3O"+
		"\3O\5O\u0342\nO\3P\3P\3P\3P\3P\3P\3P\7P\u034b\nP\fP\16P\u034e\13P\5P\u0350"+
		"\nP\3P\5P\u0353\nP\3Q\3Q\3Q\3R\5R\u0359\nR\3R\3R\3R\3R\3R\5R\u0360\nR"+
		"\5R\u0362\nR\3R\5R\u0365\nR\3S\3S\3S\7S\u036a\nS\fS\16S\u036d\13S\3T\3"+
		"T\3U\6U\u0372\nU\rU\16U\u0373\3U\2V\2\4\6\b\n\f\16\20\22\24\26\30\32\34"+
		"\36 \"$&(*,.\60\62\64\668:<>@BDFHJLNPRTVXZ\\^`bdfhjlnprtvxz|~\u0080\u0082"+
		"\u0084\u0086\u0088\u008a\u008c\u008e\u0090\u0092\u0094\u0096\u0098\u009a"+
		"\u009c\u009e\u00a0\u00a2\u00a4\u00a6\u00a8\2\34\4\n\n**\4\35\35..\5\5"+
		"\5\13\13\66\66\4\7\7))\b\3\3\5\5\26\26\35\35..88\6\6\6\t\t\63\6399\3\\"+
		"a\5\17\20\'(KK\4\3\3\5\5\5\33\33!!//\4\24\24++\t\r\r\22\23\30\31  ##%"+
		"&\64\65\4\b\b\67\67\4\16\16\37\37\7\4\4\16\16\27\27\37\37WX\5\16\16\37"+
		"\37\60\60\6\6\6\16\16\37\37\63\63\3WX\4\4\4\27\27\5\4\4\27\27\60\60\4"+
		"\34\34\60\60\t\4\4\16\16\27\27\34\34\37\37\60\60WX\7\4\4\16\16\27\27\37"+
		"\37WX\4GHUU\3QR\3\\^\u03b5\2\u00b0\3\2\2\2\4\u00b3\3\2\2\2\6\u00b8\3\2"+
		"\2\2\b\u00bd\3\2\2\2\n\u00c6\3\2\2\2\f\u00ce\3\2\2\2\16\u00d6\3\2\2\2"+
		"\20\u00de\3\2\2\2\22\u00e6\3\2\2\2\24\u00ee\3\2\2\2\26\u00f6\3\2\2\2\30"+
		"\u00ff\3\2\2\2\32\u0108\3\2\2\2\34\u0110\3\2\2\2\36\u0118\3\2\2\2 \u012c"+
		"\3\2\2\2\"\u013d\3\2\2\2$\u0142\3\2\2\2&\u0148\3\2\2\2(\u014b\3\2\2\2"+
		"*\u0152\3\2\2\2,\u015f\3\2\2\2.\u016d\3\2\2\2\60\u0175\3\2\2\2\62\u0177"+
		"\3\2\2\2\64\u0179\3\2\2\2\66\u017b\3\2\2\28\u017d\3\2\2\2:\u017f\3\2\2"+
		"\2<\u0181\3\2\2\2>\u01b0\3\2\2\2@\u01b2\3\2\2\2B\u01b4\3\2\2\2D\u01b6"+
		"\3\2\2\2F\u01c4\3\2\2\2H\u01c8\3\2\2\2J\u01ca\3\2\2\2L\u01cc\3\2\2\2N"+
		"\u01ce\3\2\2\2P\u01d0\3\2\2\2R\u01d2\3\2\2\2T\u01d4\3\2\2\2V\u01d6\3\2"+
		"\2\2X\u01d8\3\2\2\2Z\u01da\3\2\2\2\\\u01dc\3\2\2\2^\u01df\3\2\2\2`\u01ee"+
		"\3\2\2\2b\u01f9\3\2\2\2d\u0214\3\2\2\2f\u0216\3\2\2\2h\u021a\3\2\2\2j"+
		"\u0226\3\2\2\2l\u0229\3\2\2\2n\u0232\3\2\2\2p\u0236\3\2\2\2r\u023a\3\2"+
		"\2\2t\u0247\3\2\2\2v\u0249\3\2\2\2x\u0251\3\2\2\2z\u0263\3\2\2\2|\u0277"+
		"\3\2\2\2~\u027c\3\2\2\2\u0080\u029b\3\2\2\2\u0082\u02ba\3\2\2\2\u0084"+
		"\u02cc\3\2\2\2\u0086\u02da\3\2\2\2\u0088\u02dc\3\2\2\2\u008a\u02eb\3\2"+
		"\2\2\u008c\u02ed\3\2\2\2\u008e\u02f5\3\2\2\2\u0090\u02ff\3\2\2\2\u0092"+
		"\u0301\3\2\2\2\u0094\u030b\3\2\2\2\u0096\u0331\3\2\2\2\u0098\u0338\3\2"+
		"\2\2\u009a\u033b\3\2\2\2\u009c\u0341\3\2\2\2\u009e\u0352\3\2\2\2\u00a0"+
		"\u0354\3\2\2\2\u00a2\u0358\3\2\2\2\u00a4\u0366\3\2\2\2\u00a6\u036e\3\2"+
		"\2\2\u00a8\u0371\3\2\2\2\u00aa\u00af\5^\60\2\u00ab\u00af\5\u0084C\2\u00ac"+
		"\u00af\5\4\3\2\u00ad\u00af\5\\/\2\u00ae\u00aa\3\2\2\2\u00ae\u00ab\3\2"+
		"\2\2\u00ae\u00ac\3\2\2\2\u00ae\u00ad\3\2\2\2\u00af\u00b2\3\2\2\2\u00b0"+
		"\u00ae\3\2\2\2\u00b0\u00b1\3\2\2\2\u00b1\3\3\2\2\2\u00b2\u00b0\3\2\2\2"+
		"\u00b3\u00b4\7O\2\2\u00b4\u00b5\7P\2\2\u00b5\u00b6\5\u00a4S\2\u00b6\u00b7"+
		"\7\60\2\2\u00b7\5\3\2\2\2\u00b8\u00bb\5\b\5\2\u00b9\u00ba\7\34\2\2\u00ba"+
		"\u00bc\5\b\5\2\u00bb\u00b9\3\2\2\2\u00bb\u00bc\3\2\2\2\u00bc\7\3\2\2\2"+
		"\u00bd\u00c3\5\n\6\2\u00be\u00bf\5@!\2\u00bf\u00c0\5\n\6\2\u00c0\u00c2"+
		"\3\2\2\2\u00c1\u00be\3\2\2\2\u00c2\u00c5\3\2\2\2\u00c3\u00c1\3\2\2\2\u00c3"+
		"\u00c4\3\2\2\2\u00c4\t\3\2\2\2\u00c5\u00c3\3\2\2\2\u00c6\u00cc\5\f\7\2"+
		"\u00c7\u00c8\7\"\2\2\u00c8\u00c9\5\6\4\2\u00c9\u00ca\7\36\2\2\u00ca\u00cb"+
		"\5\n\6\2\u00cb\u00cd\3\2\2\2\u00cc\u00c7\3\2\2\2\u00cc\u00cd\3\2\2\2\u00cd"+
		"\13\3\2\2\2\u00ce\u00d3\5\16\b\2\u00cf\u00d0\7\62\2\2\u00d0\u00d2\5\16"+
		"\b\2\u00d1\u00cf\3\2\2\2\u00d2\u00d5\3\2\2\2\u00d3\u00d1\3\2\2\2\u00d3"+
		"\u00d4\3\2\2\2\u00d4\r\3\2\2\2\u00d5\u00d3\3\2\2\2\u00d6\u00db\5\20\t"+
		"\2\u00d7\u00d8\7\61\2\2\u00d8\u00da\5\20\t\2\u00d9\u00d7\3\2\2\2\u00da"+
		"\u00dd\3\2\2\2\u00db\u00d9\3\2\2\2\u00db\u00dc\3\2\2\2\u00dc\17\3\2\2"+
		"\2\u00dd\u00db\3\2\2\2\u00de\u00e3\5\22\n\2\u00df\u00e0\7\25\2\2\u00e0"+
		"\u00e2\5\22\n\2\u00e1\u00df\3\2\2\2\u00e2\u00e5\3\2\2\2\u00e3\u00e1\3"+
		"\2\2\2\u00e3\u00e4\3\2\2\2\u00e4\21\3\2\2\2\u00e5\u00e3\3\2\2\2\u00e6"+
		"\u00eb\5\24\13\2\u00e7\u00e8\7,\2\2\u00e8\u00ea\5\24\13\2\u00e9\u00e7"+
		"\3\2\2\2\u00ea\u00ed\3\2\2\2\u00eb\u00e9\3\2\2\2\u00eb\u00ec\3\2\2\2\u00ec"+
		"\23\3\2\2\2\u00ed\u00eb\3\2\2\2\u00ee\u00f3\5\26\f\2\u00ef\u00f0\7\3\2"+
		"\2\u00f0\u00f2\5\26\f\2\u00f1\u00ef\3\2\2\2\u00f2\u00f5\3\2\2\2\u00f3"+
		"\u00f1\3\2\2\2\u00f3\u00f4\3\2\2\2\u00f4\25\3\2\2\2\u00f5\u00f3\3\2\2"+
		"\2\u00f6\u00fc\5\30\r\2\u00f7\u00f8\5B\"\2\u00f8\u00f9\5\30\r\2\u00f9"+
		"\u00fb\3\2\2\2\u00fa\u00f7\3\2\2\2\u00fb\u00fe\3\2\2\2\u00fc\u00fa\3\2"+
		"\2\2\u00fc\u00fd\3\2\2\2\u00fd\27\3\2\2\2\u00fe\u00fc\3\2\2\2\u00ff\u0105"+
		"\5\32\16\2\u0100\u0101\5\64\33\2\u0101\u0102\5\32\16\2\u0102\u0104\3\2"+
		"\2\2\u0103\u0100\3\2\2\2\u0104\u0107\3\2\2\2\u0105\u0103\3\2\2\2\u0105"+
		"\u0106\3\2\2\2\u0106\31\3\2\2\2\u0107\u0105\3\2\2\2\u0108\u010d\5\34\17"+
		"\2\u0109\u010a\t\2\2\2\u010a\u010c\5\34\17\2\u010b\u0109\3\2\2\2\u010c"+
		"\u010f\3\2\2\2\u010d\u010b\3\2\2\2\u010d\u010e\3\2\2\2\u010e\33\3\2\2"+
		"\2\u010f\u010d\3\2\2\2\u0110\u0115\5\36\20\2\u0111\u0112\t\3\2\2\u0112"+
		"\u0114\5\36\20\2\u0113\u0111\3\2\2\2\u0114\u0117\3\2\2\2\u0115\u0113\3"+
		"\2\2\2\u0115\u0116\3\2\2\2\u0116\35\3\2\2\2\u0117\u0115\3\2\2\2\u0118"+
		"\u011d\5 \21\2\u0119\u011a\t\4\2\2\u011a\u011c\5 \21\2\u011b\u0119\3\2"+
		"\2\2\u011c\u011f\3\2\2\2\u011d\u011b\3\2\2\2\u011d\u011e\3\2\2\2\u011e"+
		"\37\3\2\2\2\u011f\u011d\3\2\2\2\u0120\u0121\7\37\2\2\u0121\u0125\5\u0096"+
		"L\2\u0122\u0124\5:\36\2\u0123\u0122\3\2\2\2\u0124\u0127\3\2\2\2\u0125"+
		"\u0123\3\2\2\2\u0125\u0126\3\2\2\2\u0126\u0128\3\2\2\2\u0127\u0125\3\2"+
		"\2\2\u0128\u0129\7\16\2\2\u0129\u012a\5 \21\2\u012a\u012d\3\2\2\2\u012b"+
		"\u012d\5\"\22\2\u012c\u0120\3\2\2\2\u012c\u012b\3\2\2\2\u012d!\3\2\2\2"+
		"\u012e\u012f\5$\23\2\u012f\u0130\5&\24\2\u0130\u0135\5(\25\2\u0131\u0132"+
		"\7\6\2\2\u0132\u0133\5F$\2\u0133\u0134\7\63\2\2\u0134\u0136\3\2\2\2\u0135"+
		"\u0131\3\2\2\2\u0135\u0136\3\2\2\2\u0136\u0137\3\2\2\2\u0137\u0138\5*"+
		"\26\2\u0138\u013e\3\2\2\2\u0139\u013a\5$\23\2\u013a\u013b\5&\24\2\u013b"+
		"\u013c\5(\25\2\u013c\u013e\3\2\2\2\u013d\u012e\3\2\2\2\u013d\u0139\3\2"+
		"\2\2\u013e#\3\2\2\2\u013f\u0141\t\5\2\2\u0140\u013f\3\2\2\2\u0141\u0144"+
		"\3\2\2\2\u0142\u0140\3\2\2\2\u0142\u0143\3\2\2\2\u0143%\3\2\2\2\u0144"+
		"\u0142\3\2\2\2\u0145\u0147\5\62\32\2\u0146\u0145\3\2\2\2\u0147\u014a\3"+
		"\2\2\2\u0148\u0146\3\2\2\2\u0148\u0149\3\2\2\2\u0149\'\3\2\2\2\u014a\u0148"+
		"\3\2\2\2\u014b\u014f\5\60\31\2\u014c\u014e\5.\30\2\u014d\u014c\3\2\2\2"+
		"\u014e\u0151\3\2\2\2\u014f\u014d\3\2\2\2\u014f\u0150\3\2\2\2\u0150)\3"+
		"\2\2\2\u0151\u014f\3\2\2\2\u0152\u015b\7\37\2\2\u0153\u0158\5,\27\2\u0154"+
		"\u0155\7\34\2\2\u0155\u0157\5,\27\2\u0156\u0154\3\2\2\2\u0157\u015a\3"+
		"\2\2\2\u0158\u0156\3\2\2\2\u0158\u0159\3\2\2\2\u0159\u015c\3\2\2\2\u015a"+
		"\u0158\3\2\2\2\u015b\u0153\3\2\2\2\u015b\u015c\3\2\2\2\u015c\u015d\3\2"+
		"\2\2\u015d\u015e\7\16\2\2\u015e+\3\2\2\2\u015f\u0160\5\b\5\2\u0160-\3"+
		"\2\2\2\u0161\u0162\7-\2\2\u0162\u016a\5\u00a4S\2\u0163\u0164\7\f\2\2\u0164"+
		"\u016a\5\u00a4S\2\u0165\u0166\7\4\2\2\u0166\u0167\5\6\4\2\u0167\u0168"+
		"\7\27\2\2\u0168\u016a\3\2\2\2\u0169\u0161\3\2\2\2\u0169\u0163\3\2\2\2"+
		"\u0169\u0165\3\2\2\2\u016a\u016e\3\2\2\2\u016b\u016e\7)\2\2\u016c\u016e"+
		"\7\7\2\2\u016d\u0169\3\2\2\2\u016d\u016b\3\2\2\2\u016d\u016c\3\2\2\2\u016e"+
		"/\3\2\2\2\u016f\u0176\5\u00a4S\2\u0170\u0176\5\66\34\2\u0171\u0172\7\37"+
		"\2\2\u0172\u0173\5\6\4\2\u0173\u0174\7\16\2\2\u0174\u0176\3\2\2\2\u0175"+
		"\u016f\3\2\2\2\u0175\u0170\3\2\2\2\u0175\u0171\3\2\2\2\u0176\61\3\2\2"+
		"\2\u0177\u0178\t\6\2\2\u0178\63\3\2\2\2\u0179\u017a\t\7\2\2\u017a\65\3"+
		"\2\2\2\u017b\u017c\t\b\2\2\u017c\67\3\2\2\2\u017d\u017e\t\t\2\2\u017e"+
		"9\3\2\2\2\u017f\u0180\t\n\2\2\u0180;\3\2\2\2\u0181\u0182\t\13\2\2\u0182"+
		"=\3\2\2\2\u0183\u0186\t\f\2\2\u0184\u0185\7\4\2\2\u0185\u0187\7\27\2\2"+
		"\u0186\u0184\3\2\2\2\u0186\u0187\3\2\2\2\u0187\u01b1\3\2\2\2\u0188\u01b1"+
		"\7.\2\2\u0189\u01b1\7\35\2\2\u018a\u01b1\7\5\2\2\u018b\u01b1\7\66\2\2"+
		"\u018c\u01b1\7\13\2\2\u018d\u01b1\7,\2\2\u018e\u01b1\7\3\2\2\u018f\u01b1"+
		"\7\25\2\2\u0190\u01b1\78\2\2\u0191\u01b1\7\26\2\2\u0192\u01b1\7\22\2\2"+
		"\u0193\u01b1\7\6\2\2\u0194\u01b1\7\63\2\2\u0195\u01b1\7%\2\2\u0196\u01b1"+
		"\7\31\2\2\u0197\u01b1\7\r\2\2\u0198\u01b1\7\65\2\2\u0199\u01b1\7\64\2"+
		"\2\u019a\u01b1\7&\2\2\u019b\u01b1\7 \2\2\u019c\u01b1\7\23\2\2\u019d\u01b1"+
		"\7*\2\2\u019e\u01b1\7\n\2\2\u019f\u01b1\7#\2\2\u01a0\u01b1\7\30\2\2\u01a1"+
		"\u01b1\7\67\2\2\u01a2\u01b1\7\b\2\2\u01a3\u01b1\7\t\2\2\u01a4\u01b1\7"+
		"9\2\2\u01a5\u01b1\7\61\2\2\u01a6\u01b1\7\62\2\2\u01a7\u01b1\7)\2\2\u01a8"+
		"\u01b1\7\7\2\2\u01a9\u01b1\7\34\2\2\u01aa\u01b1\7\32\2\2\u01ab\u01b1\7"+
		"\f\2\2\u01ac\u01ad\7\37\2\2\u01ad\u01b1\7\16\2\2\u01ae\u01af\7\4\2\2\u01af"+
		"\u01b1\7\27\2\2\u01b0\u0183\3\2\2\2\u01b0\u0188\3\2\2\2\u01b0\u0189\3"+
		"\2\2\2\u01b0\u018a\3\2\2\2\u01b0\u018b\3\2\2\2\u01b0\u018c\3\2\2\2\u01b0"+
		"\u018d\3\2\2\2\u01b0\u018e\3\2\2\2\u01b0\u018f\3\2\2\2\u01b0\u0190\3\2"+
		"\2\2\u01b0\u0191\3\2\2\2\u01b0\u0192\3\2\2\2\u01b0\u0193\3\2\2\2\u01b0"+
		"\u0194\3\2\2\2\u01b0\u0195\3\2\2\2\u01b0\u0196\3\2\2\2\u01b0\u0197\3\2"+
		"\2\2\u01b0\u0198\3\2\2\2\u01b0\u0199\3\2\2\2\u01b0\u019a\3\2\2\2\u01b0"+
		"\u019b\3\2\2\2\u01b0\u019c\3\2\2\2\u01b0\u019d\3\2\2\2\u01b0\u019e\3\2"+
		"\2\2\u01b0\u019f\3\2\2\2\u01b0\u01a0\3\2\2\2\u01b0\u01a1\3\2\2\2\u01b0"+
		"\u01a2\3\2\2\2\u01b0\u01a3\3\2\2\2\u01b0\u01a4\3\2\2\2\u01b0\u01a5\3\2"+
		"\2\2\u01b0\u01a6\3\2\2\2\u01b0\u01a7\3\2\2\2\u01b0\u01a8\3\2\2\2\u01b0"+
		"\u01a9\3\2\2\2\u01b0\u01aa\3\2\2\2\u01b0\u01ab\3\2\2\2\u01b0\u01ac\3\2"+
		"\2\2\u01b0\u01ae\3\2\2\2\u01b1?\3\2\2\2\u01b2\u01b3\t\r\2\2\u01b3A\3\2"+
		"\2\2\u01b4\u01b5\t\16\2\2\u01b5C\3\2\2\2\u01b6\u01b7\7T\2\2\u01b7\u01b8"+
		"\7\6\2\2\u01b8\u01b9\5F$\2\u01b9\u01ba\7\63\2\2\u01baE\3\2\2\2\u01bb\u01bc"+
		"\7\6\2\2\u01bc\u01bd\5F$\2\u01bd\u01be\7\63\2\2\u01be\u01c5\3\2\2\2\u01bf"+
		"\u01c0\7\37\2\2\u01c0\u01c1\5F$\2\u01c1\u01c2\7\16\2\2\u01c2\u01c5\3\2"+
		"\2\2\u01c3\u01c5\5N(\2\u01c4\u01bb\3\2\2\2\u01c4\u01bf\3\2\2\2\u01c4\u01c3"+
		"\3\2\2\2\u01c5\u01c6\3\2\2\2\u01c6\u01c4\3\2\2\2\u01c6\u01c7\3\2\2\2\u01c7"+
		"G\3\2\2\2\u01c8\u01c9\n\17\2\2\u01c9I\3\2\2\2\u01ca\u01cb\n\20\2\2\u01cb"+
		"K\3\2\2\2\u01cc\u01cd\n\21\2\2\u01cdM\3\2\2\2\u01ce\u01cf\n\22\2\2\u01cf"+
		"O\3\2\2\2\u01d0\u01d1\n\23\2\2\u01d1Q\3\2\2\2\u01d2\u01d3\n\24\2\2\u01d3"+
		"S\3\2\2\2\u01d4\u01d5\n\25\2\2\u01d5U\3\2\2\2\u01d6\u01d7\n\26\2\2\u01d7"+
		"W\3\2\2\2\u01d8\u01d9\n\27\2\2\u01d9Y\3\2\2\2\u01da\u01db\n\30\2\2\u01db"+
		"[\3\2\2\2\u01dc\u01dd\13\2\2\2\u01dd]\3\2\2\2\u01de\u01e0\5D#\2\u01df"+
		"\u01de\3\2\2\2\u01df\u01e0\3\2\2\2\u01e0\u01e2\3\2\2\2\u01e1\u01e3\5`"+
		"\61\2\u01e2\u01e1\3\2\2\2\u01e2\u01e3\3\2\2\2\u01e3\u01e4\3\2\2\2\u01e4"+
		"\u01e5\5t;\2\u01e5\u01e7\5b\62\2\u01e6\u01e8\5l\67\2\u01e7\u01e6\3\2\2"+
		"\2\u01e7\u01e8\3\2\2\2\u01e8\u01e9\3\2\2\2\u01e9\u01ea\5j\66\2\u01ea_"+
		"\3\2\2\2\u01eb\u01ed\58\35\2\u01ec\u01eb\3\2\2\2\u01ed\u01f0\3\2\2\2\u01ee"+
		"\u01ec\3\2\2\2\u01ee\u01ef\3\2\2\2\u01ef\u01f1\3\2\2\2\u01f0\u01ee\3\2"+
		"\2\2\u01f1\u01f2\5\u0096L\2\u01f2\u01f6\3\2\2\2\u01f3\u01f5\5:\36\2\u01f4"+
		"\u01f3\3\2\2\2\u01f5\u01f8\3\2\2\2\u01f6\u01f4\3\2\2\2\u01f6\u01f7\3\2"+
		"\2\2\u01f7a\3\2\2\2\u01f8\u01f6\3\2\2\2\u01f9\u01fb\7\37\2\2\u01fa\u01fc"+
		"\5d\63\2\u01fb\u01fa\3\2\2\2\u01fb\u01fc\3\2\2\2\u01fc\u01fd\3\2\2\2\u01fd"+
		"\u0201\7\16\2\2\u01fe\u0200\7J\2\2\u01ff\u01fe\3\2\2\2\u0200\u0203\3\2"+
		"\2\2\u0201\u01ff\3\2\2\2\u0201\u0202\3\2\2\2\u0202\u0205\3\2\2\2\u0203"+
		"\u0201\3\2\2\2\u0204\u0206\5v<\2\u0205\u0204\3\2\2\2\u0205\u0206\3\2\2"+
		"\2\u0206c\3\2\2\2\u0207\u020c\5f\64\2\u0208\u0209\7\34\2\2\u0209\u020b"+
		"\5f\64\2\u020a\u0208\3\2\2\2\u020b\u020e\3\2\2\2\u020c\u020a\3\2\2\2\u020c"+
		"\u020d\3\2\2\2\u020d\u0211\3\2\2\2\u020e\u020c\3\2\2\2\u020f\u0210\7\34"+
		"\2\2\u0210\u0212\7$\2\2\u0211\u020f\3\2\2\2\u0211\u0212\3\2\2\2\u0212"+
		"\u0215\3\2\2\2\u0213\u0215\7F\2\2\u0214\u0207\3\2\2\2\u0214\u0213\3\2"+
		"\2\2\u0215e\3\2\2\2\u0216\u0217\5\u009aN\2\u0217\u0218\5h\65\2\u0218g"+
		"\3\2\2\2\u0219\u021b\5\u00a8U\2\u021a\u0219\3\2\2\2\u021a\u021b\3\2\2"+
		"\2\u021b\u0221\3\2\2\2\u021c\u021d\7\37\2\2\u021d\u021e\5h\65\2\u021e"+
		"\u021f\7\16\2\2\u021f\u0222\3\2\2\2\u0220\u0222\5\u009cO\2\u0221\u021c"+
		"\3\2\2\2\u0221\u0220\3\2\2\2\u0222\u0224\3\2\2\2\u0223\u0225\5|?\2\u0224"+
		"\u0223\3\2\2\2\u0224\u0225\3\2\2\2\u0225i\3\2\2\2\u0226\u0227\7W\2\2\u0227"+
		"\u0228\b\66\1\2\u0228k\3\2\2\2\u0229\u022a\7\36\2\2\u022a\u022f\5n8\2"+
		"\u022b\u022c\7\34\2\2\u022c\u022e\5n8\2\u022d\u022b\3\2\2\2\u022e\u0231"+
		"\3\2\2\2\u022f\u022d\3\2\2\2\u022f\u0230\3\2\2\2\u0230m\3\2\2\2\u0231"+
		"\u022f\3\2\2\2\u0232\u0233\5p9\2\u0233\u0234\5r:\2\u0234o\3\2\2\2\u0235"+
		"\u0237\7\21\2\2\u0236\u0235\3\2\2\2\u0236\u0237\3\2\2\2\u0237\u0238\3"+
		"\2\2\2\u0238\u0239\5\u00a4S\2\u0239q\3\2\2\2\u023a\u023c\7\37\2\2\u023b"+
		"\u023d\5\6\4\2\u023c\u023b\3\2\2\2\u023c\u023d\3\2\2\2\u023d\u023e\3\2"+
		"\2\2\u023e\u023f\7\16\2\2\u023fs\3\2\2\2\u0240\u0241\7\37\2\2\u0241\u0242"+
		"\5t;\2\u0242\u0243\7\16\2\2\u0243\u0248\3\2\2\2\u0244\u0248\5\u00a4S\2"+
		"\u0245\u0246\7S\2\2\u0246\u0248\5> \2\u0247\u0240\3\2\2\2\u0247\u0244"+
		"\3\2\2\2\u0247\u0245\3\2\2\2\u0248u\3\2\2\2\u0249\u024a\7N\2\2\u024a\u024b"+
		"\7\37\2\2\u024b\u024c\5x=\2\u024c\u024d\7\16\2\2\u024dw\3\2\2\2\u024e"+
		"\u0250\5H%\2\u024f\u024e\3\2\2\2\u0250\u0253\3\2\2\2\u0251\u024f\3\2\2"+
		"\2\u0251\u0252\3\2\2\2\u0252\u025f\3\2\2\2\u0253\u0251\3\2\2\2\u0254\u0255"+
		"\7\37\2\2\u0255\u0256\5x=\2\u0256\u025a\7\16\2\2\u0257\u0259\5H%\2\u0258"+
		"\u0257\3\2\2\2\u0259\u025c\3\2\2\2\u025a\u0258\3\2\2\2\u025a\u025b\3\2"+
		"\2\2\u025b\u025e\3\2\2\2\u025c\u025a\3\2\2\2\u025d\u0254\3\2\2\2\u025e"+
		"\u0261\3\2\2\2\u025f\u025d\3\2\2\2\u025f\u0260\3\2\2\2\u0260y\3\2\2\2"+
		"\u0261\u025f\3\2\2\2\u0262\u0264\5\u00a8U\2\u0263\u0262\3\2\2\2\u0263"+
		"\u0264\3\2\2\2\u0264\u0265\3\2\2\2\u0265\u0267\5\u00a4S\2\u0266\u0268"+
		"\5|?\2\u0267\u0266\3\2\2\2\u0267\u0268\3\2\2\2\u0268\u0270\3\2\2\2\u0269"+
		"\u026b\7\37\2\2\u026a\u026c\5\6\4\2\u026b\u026a\3\2\2\2\u026b\u026c\3"+
		"\2\2\2\u026c\u026d\3\2\2\2\u026d\u0271\7\16\2\2\u026e\u026f\7\22\2\2\u026f"+
		"\u0271\5~@\2\u0270\u0269\3\2\2\2\u0270\u026e\3\2\2\2\u0270\u0271\3\2\2"+
		"\2\u0271{\3\2\2\2\u0272\u0273\7\4\2\2\u0273\u0274\5\u0082B\2\u0274\u0275"+
		"\7\27\2\2\u0275\u0278\3\2\2\2\u0276\u0278\5\u009eP\2\u0277\u0272\3\2\2"+
		"\2\u0277\u0276\3\2\2\2\u0278}\3\2\2\2\u0279\u027b\5X-\2\u027a\u0279\3"+
		"\2\2\2\u027b\u027e\3\2\2\2\u027c\u027a\3\2\2\2\u027c\u027d\3\2\2\2\u027d"+
		"\u0295\3\2\2\2\u027e\u027c\3\2\2\2\u027f\u0280\7W\2\2\u0280\u0281\5\u0080"+
		"A\2\u0281\u0282\7X\2\2\u0282\u028c\3\2\2\2\u0283\u0284\7\37\2\2\u0284"+
		"\u0285\5\u0080A\2\u0285\u0286\7\16\2\2\u0286\u028c\3\2\2\2\u0287\u0288"+
		"\7\4\2\2\u0288\u0289\5\u0080A\2\u0289\u028a\7\27\2\2\u028a\u028c\3\2\2"+
		"\2\u028b\u027f\3\2\2\2\u028b\u0283\3\2\2\2\u028b\u0287\3\2\2\2\u028c\u0290"+
		"\3\2\2\2\u028d\u028f\5X-\2\u028e\u028d\3\2\2\2\u028f\u0292\3\2\2\2\u0290"+
		"\u028e\3\2\2\2\u0290\u0291\3\2\2\2\u0291\u0294\3\2\2\2\u0292\u0290\3\2"+
		"\2\2\u0293\u028b\3\2\2\2\u0294\u0297\3\2\2\2\u0295\u0293\3\2\2\2\u0295"+
		"\u0296\3\2\2\2\u0296\177\3\2\2\2\u0297\u0295\3\2\2\2\u0298\u029a\5Z.\2"+
		"\u0299\u0298\3\2\2\2\u029a\u029d\3\2\2\2\u029b\u0299\3\2\2\2\u029b\u029c"+
		"\3\2\2\2\u029c\u02b4\3\2\2\2\u029d\u029b\3\2\2\2\u029e\u029f\7W\2\2\u029f"+
		"\u02a0\5\u0080A\2\u02a0\u02a1\7X\2\2\u02a1\u02ab\3\2\2\2\u02a2\u02a3\7"+
		"\37\2\2\u02a3\u02a4\5\u0080A\2\u02a4\u02a5\7\16\2\2\u02a5\u02ab\3\2\2"+
		"\2\u02a6\u02a7\7\4\2\2\u02a7\u02a8\5\u0080A\2\u02a8\u02a9\7\27\2\2\u02a9"+
		"\u02ab\3\2\2\2\u02aa\u029e\3\2\2\2\u02aa\u02a2\3\2\2\2\u02aa\u02a6\3\2"+
		"\2\2\u02ab\u02af\3\2\2\2\u02ac\u02ae\5Z.\2\u02ad\u02ac\3\2\2\2\u02ae\u02b1"+
		"\3\2\2\2\u02af\u02ad\3\2\2\2\u02af\u02b0\3\2\2\2\u02b0\u02b3\3\2\2\2\u02b1"+
		"\u02af\3\2\2\2\u02b2\u02aa\3\2\2\2\u02b3\u02b6\3\2\2\2\u02b4\u02b2\3\2"+
		"\2\2\u02b4\u02b5\3\2\2\2\u02b5\u0081\3\2\2\2\u02b6\u02b4\3\2\2\2\u02b7"+
		"\u02b9\5R*\2\u02b8\u02b7\3\2\2\2\u02b9\u02bc\3\2\2\2\u02ba\u02b8\3\2\2"+
		"\2\u02ba\u02bb\3\2\2\2\u02bb\u02c8\3\2\2\2\u02bc\u02ba\3\2\2\2\u02bd\u02be"+
		"\7\4\2\2\u02be\u02bf\5\u0082B\2\u02bf\u02c3\7\27\2\2\u02c0\u02c2\5R*\2"+
		"\u02c1\u02c0\3\2\2\2\u02c2\u02c5\3\2\2\2\u02c3\u02c1\3\2\2\2\u02c3\u02c4"+
		"\3\2\2\2\u02c4\u02c7\3\2\2\2\u02c5\u02c3\3\2\2\2\u02c6\u02bd\3\2\2\2\u02c7"+
		"\u02ca\3\2\2\2\u02c8\u02c6\3\2\2\2\u02c8\u02c9\3\2\2\2\u02c9\u0083\3\2"+
		"\2\2\u02ca\u02c8\3\2\2\2\u02cb\u02cd\7E\2\2\u02cc\u02cb\3\2\2\2\u02cc"+
		"\u02cd\3\2\2\2\u02cd\u02cf\3\2\2\2\u02ce\u02d0\5D#\2\u02cf\u02ce\3\2\2"+
		"\2\u02cf\u02d0\3\2\2\2\u02d0\u02d1\3\2\2\2\u02d1\u02d2\5\u0086D\2\u02d2"+
		"\u0085\3\2\2\2\u02d3\u02d5\5\u008eH\2\u02d4\u02d6\5\u0088E\2\u02d5\u02d4"+
		"\3\2\2\2\u02d5\u02d6\3\2\2\2\u02d6\u02db\3\2\2\2\u02d7\u02d8\5\u0096L"+
		"\2\u02d8\u02d9\5\u0088E\2\u02d9\u02db\3\2\2\2\u02da\u02d3\3\2\2\2\u02da"+
		"\u02d7\3\2\2\2\u02db\u0087\3\2\2\2\u02dc\u02e1\5z>\2\u02dd\u02de\7\34"+
		"\2\2\u02de\u02e0\5z>\2\u02df\u02dd\3\2\2\2\u02e0\u02e3\3\2\2\2\u02e1\u02df"+
		"\3\2\2\2\u02e1\u02e2\3\2\2\2\u02e2\u02e4\3\2\2\2\u02e3\u02e1\3\2\2\2\u02e4"+
		"\u02e5\7\60\2\2\u02e5\u0089\3\2\2\2\u02e6\u02ec\5\b\5\2\u02e7\u02e8\7"+
		"W\2\2\u02e8\u02e9\5\u008cG\2\u02e9\u02ea\7X\2\2\u02ea\u02ec\3\2\2\2\u02eb"+
		"\u02e6\3\2\2\2\u02eb\u02e7\3\2\2\2\u02ec\u008b\3\2\2\2\u02ed\u02f2\5\u008a"+
		"F\2\u02ee\u02ef\7\34\2\2\u02ef\u02f1\5\u008aF\2\u02f0\u02ee\3\2\2\2\u02f1"+
		"\u02f4\3\2\2\2\u02f2\u02f0\3\2\2\2\u02f2\u02f3\3\2\2\2\u02f3\u008d\3\2"+
		"\2\2\u02f4\u02f2\3\2\2\2\u02f5\u02f7\7U\2\2\u02f6\u02f8\5\u0090I\2\u02f7"+
		"\u02f6\3\2\2\2\u02f7\u02f8\3\2\2\2\u02f8\u02fa\3\2\2\2\u02f9\u02fb\5\u0092"+
		"J\2\u02fa\u02f9\3\2\2\2\u02fa\u02fb\3\2\2\2\u02fb\u02fc\3\2\2\2\u02fc"+
		"\u02fd\7W\2\2\u02fd\u02fe\bH\1\2\u02fe\u008f\3\2\2\2\u02ff\u0300\5\u00a4"+
		"S\2\u0300\u0091\3\2\2\2\u0301\u0302\7\36\2\2\u0302\u0307\5\u0094K\2\u0303"+
		"\u0304\7\34\2\2\u0304\u0306\5\u0094K\2\u0305\u0303\3\2\2\2\u0306\u0309"+
		"\3\2\2\2\u0307\u0305\3\2\2\2\u0307\u0308\3\2\2\2\u0308\u0093\3\2\2\2\u0309"+
		"\u0307\3\2\2\2\u030a\u030c\7K\2\2\u030b\u030a\3\2\2\2\u030b\u030c\3\2"+
		"\2\2\u030c\u030e\3\2\2\2\u030d\u030f\5<\37\2\u030e\u030d\3\2\2\2\u030e"+
		"\u030f\3\2\2\2\u030f\u0310\3\2\2\2\u0310\u0311\5\u00a4S\2\u0311\u0095"+
		"\3\2\2\2\u0312\u0314\7J\2\2\u0313\u0312\3\2\2\2\u0314\u0317\3\2\2\2\u0315"+
		"\u0313\3\2\2\2\u0315\u0316\3\2\2\2\u0316\u0319\3\2\2\2\u0317\u0315\3\2"+
		"\2\2\u0318\u031a\t\31\2\2\u0319\u0318\3\2\2\2\u0319\u031a\3\2\2\2\u031a"+
		"\u031b\3\2\2\2\u031b\u0320\5\u0098M\2\u031c\u031d\7\6\2\2\u031d\u031e"+
		"\5F$\2\u031e\u031f\7\63\2\2\u031f\u0321\3\2\2\2\u0320\u031c\3\2\2\2\u0320"+
		"\u0321\3\2\2\2\u0321\u032c\3\2\2\2\u0322\u0323\7\21\2\2\u0323\u0328\5"+
		"\u0098M\2\u0324\u0325\7\6\2\2\u0325\u0326\5F$\2\u0326\u0327\7\63\2\2\u0327"+
		"\u0329\3\2\2\2\u0328\u0324\3\2\2\2\u0328\u0329\3\2\2\2\u0329\u032b\3\2"+
		"\2\2\u032a\u0322\3\2\2\2\u032b\u032e\3\2\2\2\u032c\u032a\3\2\2\2\u032c"+
		"\u032d\3\2\2\2\u032d\u0332\3\2\2\2\u032e\u032c\3\2\2\2\u032f\u0332\7G"+
		"\2\2\u0330\u0332\7H\2\2\u0331\u0315\3\2\2\2\u0331\u032f\3\2\2\2\u0331"+
		"\u0330\3\2\2\2\u0332\u0097\3\2\2\2\u0333\u0339\7V\2\2\u0334\u0339\7F\2"+
		"\2\u0335\u0339\7I\2\2\u0336\u0337\7I\2\2\u0337\u0339\7I\2\2\u0338\u0333"+
		"\3\2\2\2\u0338\u0334\3\2\2\2\u0338\u0335\3\2\2\2\u0338\u0336\3\2\2\2\u0339"+
		"\u0099\3\2\2\2\u033a\u033c\t\32\2\2\u033b\u033a\3\2\2\2\u033b\u033c\3"+
		"\2\2\2\u033c\u033d\3\2\2\2\u033d\u033e\5\u0096L\2\u033e\u009b\3\2\2\2"+
		"\u033f\u0342\5\u00a4S\2\u0340\u0342\5<\37\2\u0341\u033f\3\2\2\2\u0341"+
		"\u0340\3\2\2\2\u0342\u009d\3\2\2\2\u0343\u0344\7\37\2\2\u0344\u0345\7"+
		"F\2\2\u0345\u0353\7\16\2\2\u0346\u034f\7\37\2\2\u0347\u034c\5\u00a0Q\2"+
		"\u0348\u0349\7\34\2\2\u0349\u034b\5\u00a0Q\2\u034a\u0348\3\2\2\2\u034b"+
		"\u034e\3\2\2\2\u034c\u034a\3\2\2\2\u034c\u034d\3\2\2\2\u034d\u0350\3\2"+
		"\2\2\u034e\u034c\3\2\2\2\u034f\u0347\3\2\2\2\u034f\u0350\3\2\2\2\u0350"+
		"\u0351\3\2\2\2\u0351\u0353\7\16\2\2\u0352\u0343\3\2\2\2\u0352\u0346\3"+
		"\2\2\2\u0353\u009f\3\2\2\2\u0354\u0355\5\u009aN\2\u0355\u0356\5\u00a2"+
		"R\2\u0356\u00a1\3\2\2\2\u0357\u0359\5\u00a8U\2\u0358\u0357\3\2\2\2\u0358"+
		"\u0359\3\2\2\2\u0359\u0361\3\2\2\2\u035a\u035b\7\37\2\2\u035b\u035c\5"+
		"\u00a2R\2\u035c\u035d\7\16\2\2\u035d\u0362\3\2\2\2\u035e\u0360\5\u009c"+
		"O\2\u035f\u035e\3\2\2\2\u035f\u0360\3\2\2\2\u0360\u0362\3\2\2\2\u0361"+
		"\u035a\3\2\2\2\u0361\u035f\3\2\2\2\u0362\u0364\3\2\2\2\u0363\u0365\5|"+
		"?\2\u0364\u0363\3\2\2\2\u0364\u0365\3\2\2\2\u0365\u00a3\3\2\2\2\u0366"+
		"\u036b\7V\2\2\u0367\u0368\7\21\2\2\u0368\u036a\7V\2\2\u0369\u0367\3\2"+
		"\2\2\u036a\u036d\3\2\2\2\u036b\u0369\3\2\2\2\u036b\u036c\3\2\2\2\u036c"+
		"\u00a5\3\2\2\2\u036d\u036b\3\2\2\2\u036e\u036f\t\33\2\2\u036f\u00a7\3"+
		"\2\2\2\u0370\u0372\5:\36\2\u0371\u0370\3\2\2\2\u0372\u0373\3\2\2\2\u0373"+
		"\u0371\3\2\2\2\u0373\u0374\3\2\2\2\u0374\u00a9\3\2\2\2d\u00ae\u00b0\u00bb"+
		"\u00c3\u00cc\u00d3\u00db\u00e3\u00eb\u00f3\u00fc\u0105\u010d\u0115\u011d"+
		"\u0125\u012c\u0135\u013d\u0142\u0148\u014f\u0158\u015b\u0169\u016d\u0175"+
		"\u0186\u01b0\u01c4\u01c6\u01df\u01e2\u01e7\u01ee\u01f6\u01fb\u0201\u0205"+
		"\u020c\u0211\u0214\u021a\u0221\u0224\u022f\u0236\u023c\u0247\u0251\u025a"+
		"\u025f\u0263\u0267\u026b\u0270\u0277\u027c\u028b\u0290\u0295\u029b\u02aa"+
		"\u02af\u02b4\u02ba\u02c3\u02c8\u02cc\u02cf\u02d5\u02da\u02e1\u02eb\u02f2"+
		"\u02f7\u02fa\u0307\u030b\u030e\u0315\u0319\u0320\u0328\u032c\u0331\u0338"+
		"\u033b\u0341\u034c\u034f\u0352\u0358\u035f\u0361\u0364\u036b\u0373";
	public static final ATN _ATN =
		ATNSimulator.deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
	}
}