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
		"<INVALID>", "'&'", "'['", "'*'", "'--'", "'<'", "'!='", "'<='", "'<<'", 
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
		RULE_unary_expression = 16, RULE_field = 17, RULE_function_argument_list = 18, 
		RULE_function_argument = 19, RULE_postfix = 20, RULE_primary_expression = 21, 
		RULE_unary_operator = 22, RULE_relational_operator = 23, RULE_constant = 24, 
		RULE_function_decl_specifiers = 25, RULE_ptr_operator = 26, RULE_access_specifier = 27, 
		RULE_operator = 28, RULE_assignment_operator = 29, RULE_equality_operator = 30, 
		RULE_template_decl_start = 31, RULE_template_param_list = 32, RULE_no_brackets = 33, 
		RULE_no_brackets_curlies_or_squares = 34, RULE_no_brackets_or_semicolon = 35, 
		RULE_no_angle_brackets_or_brackets = 36, RULE_no_curlies = 37, RULE_no_squares = 38, 
		RULE_no_squares_or_semicolon = 39, RULE_no_comma_or_semicolon = 40, RULE_assign_water = 41, 
		RULE_assign_water_l2 = 42, RULE_water = 43, RULE_function_def = 44, RULE_return_type = 45, 
		RULE_function_param_list = 46, RULE_parameter_decl_clause = 47, RULE_parameter_decl = 48, 
		RULE_parameter_id = 49, RULE_compound_statement = 50, RULE_ctor_list = 51, 
		RULE_ctor_initializer = 52, RULE_initializer_id = 53, RULE_ctor_expr = 54, 
		RULE_function_name = 55, RULE_exception_specification = 56, RULE_type_id_list = 57, 
		RULE_init_declarator = 58, RULE_type_suffix = 59, RULE_assign_expr_w_ = 60, 
		RULE_assign_expr_w__l2 = 61, RULE_constant_expr_w_ = 62, RULE_simple_decl = 63, 
		RULE_var_decl = 64, RULE_init_declarator_list = 65, RULE_initializer = 66, 
		RULE_initializer_list = 67, RULE_class_def = 68, RULE_class_name = 69, 
		RULE_base_classes = 70, RULE_base_class = 71, RULE_type_name = 72, RULE_base_type = 73, 
		RULE_param_decl_specifiers = 74, RULE_parameter_name = 75, RULE_param_type_list = 76, 
		RULE_param_type = 77, RULE_param_type_id = 78, RULE_identifier = 79, RULE_number = 80, 
		RULE_ptrs = 81;
	public static final String[] ruleNames = {
		"code", "using_directive", "expr", "assign_expr", "conditional_expression", 
		"or_expression", "and_expression", "inclusive_or_expression", "exclusive_or_expression", 
		"bit_and_expression", "equality_expression", "relational_expression", 
		"shift_expression", "additive_expression", "multiplicative_expression", 
		"cast_expression", "unary_expression", "field", "function_argument_list", 
		"function_argument", "postfix", "primary_expression", "unary_operator", 
		"relational_operator", "constant", "function_decl_specifiers", "ptr_operator", 
		"access_specifier", "operator", "assignment_operator", "equality_operator", 
		"template_decl_start", "template_param_list", "no_brackets", "no_brackets_curlies_or_squares", 
		"no_brackets_or_semicolon", "no_angle_brackets_or_brackets", "no_curlies", 
		"no_squares", "no_squares_or_semicolon", "no_comma_or_semicolon", "assign_water", 
		"assign_water_l2", "water", "function_def", "return_type", "function_param_list", 
		"parameter_decl_clause", "parameter_decl", "parameter_id", "compound_statement", 
		"ctor_list", "ctor_initializer", "initializer_id", "ctor_expr", "function_name", 
		"exception_specification", "type_id_list", "init_declarator", "type_suffix", 
		"assign_expr_w_", "assign_expr_w__l2", "constant_expr_w_", "simple_decl", 
		"var_decl", "init_declarator_list", "initializer", "initializer_list", 
		"class_def", "class_name", "base_classes", "base_class", "type_name", 
		"base_type", "param_decl_specifiers", "parameter_name", "param_type_list", 
		"param_type", "param_type_id", "identifier", "number", "ptrs"
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
			setState(170);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << 1) | (1L << 2) | (1L << 3) | (1L << 4) | (1L << 5) | (1L << 6) | (1L << 7) | (1L << 8) | (1L << 9) | (1L << 10) | (1L << 11) | (1L << 12) | (1L << 13) | (1L << 14) | (1L << 15) | (1L << 16) | (1L << 17) | (1L << 18) | (1L << 19) | (1L << 20) | (1L << 21) | (1L << 22) | (1L << 23) | (1L << 24) | (1L << 25) | (1L << 26) | (1L << 27) | (1L << 28) | (1L << 29) | (1L << 30) | (1L << 31) | (1L << 32) | (1L << 33) | (1L << 34) | (1L << 35) | (1L << 36) | (1L << 37) | (1L << 38) | (1L << 39) | (1L << 40) | (1L << 41) | (1L << 42) | (1L << 43) | (1L << 44) | (1L << 45) | (1L << 46) | (1L << 47) | (1L << 48) | (1L << 49) | (1L << 50) | (1L << 51) | (1L << 52) | (1L << 53) | (1L << 54) | (1L << 55) | (1L << IF) | (1L << ELSE) | (1L << FOR) | (1L << WHILE) | (1L << BREAK) | (1L << CASE) | (1L << CONTINUE) | (1L << SWITCH))) != 0) || ((((_la - 64)) & ~0x3f) == 0 && ((1L << (_la - 64)) & ((1L << (DO - 64)) | (1L << (GOTO - 64)) | (1L << (RETURN - 64)) | (1L << (TYPEDEF - 64)) | (1L << (VOID - 64)) | (1L << (UNSIGNED - 64)) | (1L << (SIGNED - 64)) | (1L << (LONG - 64)) | (1L << (CV_QUALIFIER - 64)) | (1L << (VIRTUAL - 64)) | (1L << (TRY - 64)) | (1L << (CATCH - 64)) | (1L << (THROW - 64)) | (1L << (USING - 64)) | (1L << (NAMESPACE - 64)) | (1L << (AUTO - 64)) | (1L << (REGISTER - 64)) | (1L << (OPERATOR - 64)) | (1L << (TEMPLATE - 64)) | (1L << (CLASS_KEY - 64)) | (1L << (ALPHA_NUMERIC - 64)) | (1L << (OPENING_CURLY - 64)) | (1L << (CLOSING_CURLY - 64)) | (1L << (PRE_IF - 64)) | (1L << (PRE_ELSE - 64)) | (1L << (PRE_ENDIF - 64)) | (1L << (HEX_LITERAL - 64)) | (1L << (DECIMAL_LITERAL - 64)) | (1L << (OCTAL_LITERAL - 64)) | (1L << (FLOATING_POINT_LITERAL - 64)) | (1L << (CHAR - 64)) | (1L << (STRING - 64)) | (1L << (COMMENT - 64)) | (1L << (WHITESPACE - 64)) | (1L << (CPPCOMMENT - 64)) | (1L << (OTHER - 64)) | (1L << (37 - 64)) | (1L << (38 - 64)) | (1L << (TYPEDEF - 64)) | (1L << (VOID - 64)) | (1L << (UNSIGNED - 64)) | (1L << (SIGNED - 64)) | (1L << (LONG - 64)) | (1L << (CV_QUALIFIER - 64)) | (1L << (VIRTUAL - 64)) | (1L << (USING - 64)) | (1L << (OPERATOR - 64)) | (1L << (TEMPLATE - 64)) | (1L << (CLASS_KEY - 64)) | (1L << (ALPHA_NUMERIC - 64)))) != 0)) {
				{
				setState(168);
				switch ( getInterpreter().adaptivePredict(_input,0,_ctx) ) {
				case 1:
					{
					setState(164); function_def();
					}
					break;

				case 2:
					{
					setState(165); simple_decl();
					}
					break;

				case 3:
					{
					setState(166); using_directive();
					}
					break;

				case 4:
					{
					setState(167); water();
					}
					break;
				}
				}
				setState(172);
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
			setState(173); match(USING);
			setState(174); match(NAMESPACE);
			setState(175); identifier();
			setState(176); match(46);
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
			setState(178); assign_expr();
			setState(181);
			_la = _input.LA(1);
			if (_la==26) {
				{
				setState(179); match(26);
				setState(180); assign_expr();
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
			setState(183); conditional_expression();
			setState(189);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << 11) | (1L << 16) | (1L << 17) | (1L << 22) | (1L << 23) | (1L << 30) | (1L << 33) | (1L << 35) | (1L << 36) | (1L << 50) | (1L << 51))) != 0)) {
				{
				{
				setState(184); assignment_operator();
				setState(185); conditional_expression();
				}
				}
				setState(191);
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
			setState(192); or_expression();
			setState(198);
			_la = _input.LA(1);
			if (_la==32) {
				{
				setState(193); match(32);
				setState(194); expr();
				setState(195); match(28);
				setState(196); conditional_expression();
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
			setState(200); and_expression();
			setState(205);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==48) {
				{
				{
				setState(201); match(48);
				setState(202); and_expression();
				}
				}
				setState(207);
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
			setState(208); inclusive_or_expression();
			setState(213);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==47) {
				{
				{
				setState(209); match(47);
				setState(210); inclusive_or_expression();
				}
				}
				setState(215);
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
			setState(216); exclusive_or_expression();
			setState(221);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==19) {
				{
				{
				setState(217); match(19);
				setState(218); exclusive_or_expression();
				}
				}
				setState(223);
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
			setState(224); bit_and_expression();
			setState(229);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==42) {
				{
				{
				setState(225); match(42);
				setState(226); bit_and_expression();
				}
				}
				setState(231);
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
			setState(232); equality_expression();
			setState(237);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==1) {
				{
				{
				setState(233); match(1);
				setState(234); equality_expression();
				}
				}
				setState(239);
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
			setState(240); relational_expression();
			setState(246);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==6 || _la==53) {
				{
				{
				setState(241); equality_operator();
				setState(242); relational_expression();
				}
				}
				setState(248);
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
			setState(249); shift_expression();
			setState(255);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << 5) | (1L << 7) | (1L << 49) | (1L << 55))) != 0)) {
				{
				{
				setState(250); relational_operator();
				setState(251); shift_expression();
				}
				}
				setState(257);
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
			setState(258); additive_expression();
			setState(263);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==8 || _la==40) {
				{
				{
				setState(259);
				_la = _input.LA(1);
				if ( !(_la==8 || _la==40) ) {
				_errHandler.recoverInline(this);
				}
				consume();
				setState(260); additive_expression();
				}
				}
				setState(265);
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
			setState(266); multiplicative_expression();
			setState(271);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==27 || _la==44) {
				{
				{
				setState(267);
				_la = _input.LA(1);
				if ( !(_la==27 || _la==44) ) {
				_errHandler.recoverInline(this);
				}
				consume();
				setState(268); multiplicative_expression();
				}
				}
				setState(273);
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
			setState(274); cast_expression();
			setState(279);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << 3) | (1L << 9) | (1L << 52))) != 0)) {
				{
				{
				setState(275);
				_la = _input.LA(1);
				if ( !((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << 3) | (1L << 9) | (1L << 52))) != 0)) ) {
				_errHandler.recoverInline(this);
				}
				consume();
				setState(276); cast_expression();
				}
				}
				setState(281);
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
			setState(294);
			switch ( getInterpreter().adaptivePredict(_input,16,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				{
				setState(282); match(29);
				setState(283); type_name();
				setState(287);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (_la==1 || _la==3) {
					{
					{
					setState(284); ptr_operator();
					}
					}
					setState(289);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				setState(290); match(12);
				setState(291); cast_expression();
				}
				}
				break;

			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(293); unary_expression();
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
		public List<Unary_operatorContext> unary_operator() {
			return getRuleContexts(Unary_operatorContext.class);
		}
		public Unary_operatorContext unary_operator(int i) {
			return getRuleContext(Unary_operatorContext.class,i);
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
		public List<Unary_operatorContext> unary_operator() {
			return getRuleContexts(Unary_operatorContext.class);
		}
		public Unary_operatorContext unary_operator(int i) {
			return getRuleContext(Unary_operatorContext.class,i);
		}
		public Template_param_listContext template_param_list() {
			return getRuleContext(Template_param_listContext.class,0);
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
			setState(330);
			switch ( getInterpreter().adaptivePredict(_input,22,_ctx) ) {
			case 1:
				_localctx = new FuncCallContext(_localctx);
				enterOuterAlt(_localctx, 1);
				{
				setState(299);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (_la==4 || _la==39) {
					{
					{
					setState(296);
					_la = _input.LA(1);
					if ( !(_la==4 || _la==39) ) {
					_errHandler.recoverInline(this);
					}
					consume();
					}
					}
					setState(301);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				setState(305);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << 1) | (1L << 3) | (1L << 20) | (1L << 27) | (1L << 44) | (1L << 54))) != 0)) {
					{
					{
					setState(302); unary_operator();
					}
					}
					setState(307);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				setState(308); field();
				{
				setState(313);
				_la = _input.LA(1);
				if (_la==5) {
					{
					setState(309); match(5);
					setState(310); template_param_list();
					setState(311); match(49);
					}
				}

				setState(315); function_argument_list();
				}
				}
				break;

			case 2:
				_localctx = new FieldOnlyContext(_localctx);
				enterOuterAlt(_localctx, 2);
				{
				setState(320);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (_la==4 || _la==39) {
					{
					{
					setState(317);
					_la = _input.LA(1);
					if ( !(_la==4 || _la==39) ) {
					_errHandler.recoverInline(this);
					}
					consume();
					}
					}
					setState(322);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
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
				setState(329); field();
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
		enterRule(_localctx, 34, RULE_field);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(332); primary_expression();
			setState(336);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << 2) | (1L << 4) | (1L << 10) | (1L << 39) | (1L << 43))) != 0)) {
				{
				{
				setState(333); postfix();
				}
				}
				setState(338);
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
		enterRule(_localctx, 36, RULE_function_argument_list);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(339); match(29);
			setState(348);
			_la = _input.LA(1);
			if ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << 1) | (1L << 3) | (1L << 4) | (1L << 20) | (1L << 27) | (1L << 29) | (1L << 39) | (1L << 44) | (1L << 54))) != 0) || ((((_la - 84)) & ~0x3f) == 0 && ((1L << (_la - 84)) & ((1L << (ALPHA_NUMERIC - 84)) | (1L << (HEX_LITERAL - 84)) | (1L << (DECIMAL_LITERAL - 84)) | (1L << (OCTAL_LITERAL - 84)) | (1L << (FLOATING_POINT_LITERAL - 84)) | (1L << (CHAR - 84)) | (1L << (STRING - 84)))) != 0)) {
				{
				setState(340); function_argument();
				setState(345);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (_la==26) {
					{
					{
					setState(341); match(26);
					setState(342); function_argument();
					}
					}
					setState(347);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				}
			}

			setState(350); match(12);
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
		enterRule(_localctx, 38, RULE_function_argument);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(352); assign_expr();
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
		enterRule(_localctx, 40, RULE_postfix);
		try {
			setState(366);
			switch (_input.LA(1)) {
			case 2:
			case 10:
			case 43:
				enterOuterAlt(_localctx, 1);
				{
				setState(362);
				switch (_input.LA(1)) {
				case 43:
					{
					setState(354); match(43);
					setState(355); identifier();
					}
					break;
				case 10:
					{
					setState(356); match(10);
					setState(357); identifier();
					}
					break;
				case 2:
					{
					setState(358); match(2);
					setState(359); expr();
					setState(360); match(21);
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
				setState(364); match(39);
				}
				break;
			case 4:
				enterOuterAlt(_localctx, 3);
				{
				setState(365); match(4);
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
		enterRule(_localctx, 42, RULE_primary_expression);
		try {
			setState(374);
			switch (_input.LA(1)) {
			case ALPHA_NUMERIC:
				enterOuterAlt(_localctx, 1);
				{
				setState(368); identifier();
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
				setState(369); constant();
				}
				break;
			case 29:
				enterOuterAlt(_localctx, 3);
				{
				setState(370); match(29);
				setState(371); expr();
				setState(372); match(12);
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
		enterRule(_localctx, 44, RULE_unary_operator);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(376);
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
		enterRule(_localctx, 46, RULE_relational_operator);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(378);
			_la = _input.LA(1);
			if ( !((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << 5) | (1L << 7) | (1L << 49) | (1L << 55))) != 0)) ) {
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
		enterRule(_localctx, 48, RULE_constant);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(380);
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
		enterRule(_localctx, 50, RULE_function_decl_specifiers);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(382);
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
		enterRule(_localctx, 52, RULE_ptr_operator);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(384);
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
		enterRule(_localctx, 54, RULE_access_specifier);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(386);
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
		enterRule(_localctx, 56, RULE_operator);
		int _la;
		try {
			setState(433);
			switch (_input.LA(1)) {
			case 18:
			case 41:
				enterOuterAlt(_localctx, 1);
				{
				{
				setState(388);
				_la = _input.LA(1);
				if ( !(_la==18 || _la==41) ) {
				_errHandler.recoverInline(this);
				}
				consume();
				setState(391);
				_la = _input.LA(1);
				if (_la==2) {
					{
					setState(389); match(2);
					setState(390); match(21);
					}
				}

				}
				}
				break;
			case 44:
				enterOuterAlt(_localctx, 2);
				{
				setState(393); match(44);
				}
				break;
			case 27:
				enterOuterAlt(_localctx, 3);
				{
				setState(394); match(27);
				}
				break;
			case 3:
				enterOuterAlt(_localctx, 4);
				{
				setState(395); match(3);
				}
				break;
			case 52:
				enterOuterAlt(_localctx, 5);
				{
				setState(396); match(52);
				}
				break;
			case 9:
				enterOuterAlt(_localctx, 6);
				{
				setState(397); match(9);
				}
				break;
			case 42:
				enterOuterAlt(_localctx, 7);
				{
				setState(398); match(42);
				}
				break;
			case 1:
				enterOuterAlt(_localctx, 8);
				{
				setState(399); match(1);
				}
				break;
			case 19:
				enterOuterAlt(_localctx, 9);
				{
				setState(400); match(19);
				}
				break;
			case 54:
				enterOuterAlt(_localctx, 10);
				{
				setState(401); match(54);
				}
				break;
			case 20:
				enterOuterAlt(_localctx, 11);
				{
				setState(402); match(20);
				}
				break;
			case 16:
				enterOuterAlt(_localctx, 12);
				{
				setState(403); match(16);
				}
				break;
			case 5:
				enterOuterAlt(_localctx, 13);
				{
				setState(404); match(5);
				}
				break;
			case 49:
				enterOuterAlt(_localctx, 14);
				{
				setState(405); match(49);
				}
				break;
			case 35:
				enterOuterAlt(_localctx, 15);
				{
				setState(406); match(35);
				}
				break;
			case 23:
				enterOuterAlt(_localctx, 16);
				{
				setState(407); match(23);
				}
				break;
			case 11:
				enterOuterAlt(_localctx, 17);
				{
				setState(408); match(11);
				}
				break;
			case 51:
				enterOuterAlt(_localctx, 18);
				{
				setState(409); match(51);
				}
				break;
			case 50:
				enterOuterAlt(_localctx, 19);
				{
				setState(410); match(50);
				}
				break;
			case 36:
				enterOuterAlt(_localctx, 20);
				{
				setState(411); match(36);
				}
				break;
			case 30:
				enterOuterAlt(_localctx, 21);
				{
				setState(412); match(30);
				}
				break;
			case 17:
				enterOuterAlt(_localctx, 22);
				{
				setState(413); match(17);
				}
				break;
			case 40:
				enterOuterAlt(_localctx, 23);
				{
				setState(414); match(40);
				}
				break;
			case 8:
				enterOuterAlt(_localctx, 24);
				{
				setState(415); match(8);
				}
				break;
			case 33:
				enterOuterAlt(_localctx, 25);
				{
				setState(416); match(33);
				}
				break;
			case 22:
				enterOuterAlt(_localctx, 26);
				{
				setState(417); match(22);
				}
				break;
			case 53:
				enterOuterAlt(_localctx, 27);
				{
				setState(418); match(53);
				}
				break;
			case 6:
				enterOuterAlt(_localctx, 28);
				{
				setState(419); match(6);
				}
				break;
			case 7:
				enterOuterAlt(_localctx, 29);
				{
				setState(420); match(7);
				}
				break;
			case 55:
				enterOuterAlt(_localctx, 30);
				{
				setState(421); match(55);
				}
				break;
			case 47:
				enterOuterAlt(_localctx, 31);
				{
				setState(422); match(47);
				}
				break;
			case 48:
				enterOuterAlt(_localctx, 32);
				{
				setState(423); match(48);
				}
				break;
			case 39:
				enterOuterAlt(_localctx, 33);
				{
				setState(424); match(39);
				}
				break;
			case 4:
				enterOuterAlt(_localctx, 34);
				{
				setState(425); match(4);
				}
				break;
			case 26:
				enterOuterAlt(_localctx, 35);
				{
				setState(426); match(26);
				}
				break;
			case 24:
				enterOuterAlt(_localctx, 36);
				{
				setState(427); match(24);
				}
				break;
			case 10:
				enterOuterAlt(_localctx, 37);
				{
				setState(428); match(10);
				}
				break;
			case 29:
				enterOuterAlt(_localctx, 38);
				{
				setState(429); match(29);
				setState(430); match(12);
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 39);
				{
				setState(431); match(2);
				setState(432); match(21);
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
		enterRule(_localctx, 58, RULE_assignment_operator);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(435);
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
		enterRule(_localctx, 60, RULE_equality_operator);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(437);
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
		enterRule(_localctx, 62, RULE_template_decl_start);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(439); match(TEMPLATE);
			setState(440); template_param_list();
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
		enterRule(_localctx, 64, RULE_template_param_list);
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(451); 
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,32,_ctx);
			do {
				switch (_alt) {
				case 1:
					{
					setState(451);
					switch (_input.LA(1)) {
					case 5:
						{
						{
						setState(442); match(5);
						setState(443); template_param_list();
						setState(444); match(49);
						}
						}
						break;
					case 29:
						{
						{
						setState(446); match(29);
						setState(447); template_param_list();
						setState(448); match(12);
						}
						}
						break;
					case 1:
					case 2:
					case 3:
					case 4:
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
						setState(450); no_angle_brackets_or_brackets();
						}
						break;
					default:
						throw new NoViableAltException(this);
					}
					}
					break;
				default:
					throw new NoViableAltException(this);
				}
				setState(453); 
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,32,_ctx);
			} while ( _alt!=2 && _alt!=-1 );
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
		enterRule(_localctx, 66, RULE_no_brackets);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(455);
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
		enterRule(_localctx, 68, RULE_no_brackets_curlies_or_squares);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(457);
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
		enterRule(_localctx, 70, RULE_no_brackets_or_semicolon);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(459);
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
		enterRule(_localctx, 72, RULE_no_angle_brackets_or_brackets);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(461);
			_la = _input.LA(1);
			if ( _la <= 0 || ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << 5) | (1L << 12) | (1L << 29) | (1L << 49))) != 0)) ) {
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
		enterRule(_localctx, 74, RULE_no_curlies);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(463);
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
		enterRule(_localctx, 76, RULE_no_squares);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(465);
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
		enterRule(_localctx, 78, RULE_no_squares_or_semicolon);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(467);
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
		enterRule(_localctx, 80, RULE_no_comma_or_semicolon);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(469);
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
		enterRule(_localctx, 82, RULE_assign_water);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(471);
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
		enterRule(_localctx, 84, RULE_assign_water_l2);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(473);
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
		enterRule(_localctx, 86, RULE_water);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(475);
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
		enterRule(_localctx, 88, RULE_function_def);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(478);
			_la = _input.LA(1);
			if (_la==TEMPLATE) {
				{
				setState(477); template_decl_start();
				}
			}

			setState(481);
			switch ( getInterpreter().adaptivePredict(_input,34,_ctx) ) {
			case 1:
				{
				setState(480); return_type();
				}
				break;
			}
			setState(483); function_name();
			setState(484); function_param_list();
			setState(486);
			_la = _input.LA(1);
			if (_la==28) {
				{
				setState(485); ctor_list();
				}
			}

			setState(488); compound_statement();
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
		enterRule(_localctx, 90, RULE_return_type);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			{
			setState(493);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (((((_la - 13)) & ~0x3f) == 0 && ((1L << (_la - 13)) & ((1L << (13 - 13)) | (1L << (14 - 13)) | (1L << (37 - 13)) | (1L << (38 - 13)) | (1L << (VIRTUAL - 13)))) != 0)) {
				{
				{
				setState(490); function_decl_specifiers();
				}
				}
				setState(495);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(496); type_name();
			}
			setState(501);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==1 || _la==3) {
				{
				{
				setState(498); ptr_operator();
				}
				}
				setState(503);
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
		enterRule(_localctx, 92, RULE_function_param_list);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(504); match(29);
			setState(506);
			_la = _input.LA(1);
			if (((((_la - 68)) & ~0x3f) == 0 && ((1L << (_la - 68)) & ((1L << (VOID - 68)) | (1L << (UNSIGNED - 68)) | (1L << (SIGNED - 68)) | (1L << (LONG - 68)) | (1L << (CV_QUALIFIER - 68)) | (1L << (AUTO - 68)) | (1L << (REGISTER - 68)) | (1L << (CLASS_KEY - 68)) | (1L << (ALPHA_NUMERIC - 68)))) != 0)) {
				{
				setState(505); parameter_decl_clause();
				}
			}

			setState(508); match(12);
			setState(512);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==CV_QUALIFIER) {
				{
				{
				setState(509); match(CV_QUALIFIER);
				}
				}
				setState(514);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(516);
			_la = _input.LA(1);
			if (_la==THROW) {
				{
				setState(515); exception_specification();
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
		enterRule(_localctx, 94, RULE_parameter_decl_clause);
		int _la;
		try {
			int _alt;
			setState(531);
			switch ( getInterpreter().adaptivePredict(_input,43,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				{
				setState(518); parameter_decl();
				setState(523);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,41,_ctx);
				while ( _alt!=2 && _alt!=-1 ) {
					if ( _alt==1 ) {
						{
						{
						setState(519); match(26);
						setState(520); parameter_decl();
						}
						} 
					}
					setState(525);
					_errHandler.sync(this);
					_alt = getInterpreter().adaptivePredict(_input,41,_ctx);
				}
				}
				setState(528);
				_la = _input.LA(1);
				if (_la==26) {
					{
					setState(526); match(26);
					setState(527); match(34);
					}
				}

				}
				break;

			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(530); match(VOID);
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
		enterRule(_localctx, 96, RULE_parameter_decl);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(533); param_decl_specifiers();
			setState(534); parameter_id();
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
		enterRule(_localctx, 98, RULE_parameter_id);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(537);
			_la = _input.LA(1);
			if (_la==1 || _la==3) {
				{
				setState(536); ptrs();
				}
			}

			setState(544);
			switch (_input.LA(1)) {
			case 29:
				{
				setState(539); match(29);
				setState(540); parameter_id();
				setState(541); match(12);
				}
				break;
			case 25:
			case 31:
			case 45:
			case ALPHA_NUMERIC:
				{
				setState(543); parameter_name();
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
			setState(547);
			_la = _input.LA(1);
			if (_la==2 || _la==29) {
				{
				setState(546); type_suffix();
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
		enterRule(_localctx, 100, RULE_compound_statement);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(549); match(OPENING_CURLY);
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
		enterRule(_localctx, 102, RULE_ctor_list);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(552); match(28);
			setState(553); ctor_initializer();
			setState(558);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==26) {
				{
				{
				setState(554); match(26);
				setState(555); ctor_initializer();
				}
				}
				setState(560);
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
		enterRule(_localctx, 104, RULE_ctor_initializer);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(561); initializer_id();
			setState(562); ctor_expr();
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
		enterRule(_localctx, 106, RULE_initializer_id);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(565);
			_la = _input.LA(1);
			if (_la==15) {
				{
				setState(564); match(15);
				}
			}

			setState(567); identifier();
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
		enterRule(_localctx, 108, RULE_ctor_expr);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(569); match(29);
			setState(571);
			_la = _input.LA(1);
			if ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << 1) | (1L << 3) | (1L << 4) | (1L << 20) | (1L << 27) | (1L << 29) | (1L << 39) | (1L << 44) | (1L << 54))) != 0) || ((((_la - 84)) & ~0x3f) == 0 && ((1L << (_la - 84)) & ((1L << (ALPHA_NUMERIC - 84)) | (1L << (HEX_LITERAL - 84)) | (1L << (DECIMAL_LITERAL - 84)) | (1L << (OCTAL_LITERAL - 84)) | (1L << (FLOATING_POINT_LITERAL - 84)) | (1L << (CHAR - 84)) | (1L << (STRING - 84)))) != 0)) {
				{
				setState(570); expr();
				}
			}

			setState(573); match(12);
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
		enterRule(_localctx, 110, RULE_function_name);
		try {
			setState(582);
			switch (_input.LA(1)) {
			case 29:
				enterOuterAlt(_localctx, 1);
				{
				setState(575); match(29);
				setState(576); function_name();
				setState(577); match(12);
				}
				break;
			case ALPHA_NUMERIC:
				enterOuterAlt(_localctx, 2);
				{
				setState(579); identifier();
				}
				break;
			case OPERATOR:
				enterOuterAlt(_localctx, 3);
				{
				setState(580); match(OPERATOR);
				setState(581); operator();
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
		enterRule(_localctx, 112, RULE_exception_specification);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(584); match(THROW);
			setState(585); match(29);
			setState(586); type_id_list();
			setState(587); match(12);
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
		enterRule(_localctx, 114, RULE_type_id_list);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(592);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << 1) | (1L << 2) | (1L << 3) | (1L << 4) | (1L << 5) | (1L << 6) | (1L << 7) | (1L << 8) | (1L << 9) | (1L << 10) | (1L << 11) | (1L << 13) | (1L << 14) | (1L << 15) | (1L << 16) | (1L << 17) | (1L << 18) | (1L << 19) | (1L << 20) | (1L << 21) | (1L << 22) | (1L << 23) | (1L << 24) | (1L << 25) | (1L << 26) | (1L << 27) | (1L << 28) | (1L << 30) | (1L << 31) | (1L << 32) | (1L << 33) | (1L << 34) | (1L << 35) | (1L << 36) | (1L << 37) | (1L << 38) | (1L << 39) | (1L << 40) | (1L << 41) | (1L << 42) | (1L << 43) | (1L << 44) | (1L << 45) | (1L << 46) | (1L << 47) | (1L << 48) | (1L << 49) | (1L << 50) | (1L << 51) | (1L << 52) | (1L << 53) | (1L << 54) | (1L << 55) | (1L << IF) | (1L << ELSE) | (1L << FOR) | (1L << WHILE) | (1L << BREAK) | (1L << CASE) | (1L << CONTINUE) | (1L << SWITCH))) != 0) || ((((_la - 64)) & ~0x3f) == 0 && ((1L << (_la - 64)) & ((1L << (DO - 64)) | (1L << (GOTO - 64)) | (1L << (RETURN - 64)) | (1L << (TYPEDEF - 64)) | (1L << (VOID - 64)) | (1L << (UNSIGNED - 64)) | (1L << (SIGNED - 64)) | (1L << (LONG - 64)) | (1L << (CV_QUALIFIER - 64)) | (1L << (VIRTUAL - 64)) | (1L << (TRY - 64)) | (1L << (CATCH - 64)) | (1L << (THROW - 64)) | (1L << (USING - 64)) | (1L << (NAMESPACE - 64)) | (1L << (AUTO - 64)) | (1L << (REGISTER - 64)) | (1L << (OPERATOR - 64)) | (1L << (TEMPLATE - 64)) | (1L << (CLASS_KEY - 64)) | (1L << (ALPHA_NUMERIC - 64)) | (1L << (OPENING_CURLY - 64)) | (1L << (CLOSING_CURLY - 64)) | (1L << (PRE_IF - 64)) | (1L << (PRE_ELSE - 64)) | (1L << (PRE_ENDIF - 64)) | (1L << (HEX_LITERAL - 64)) | (1L << (DECIMAL_LITERAL - 64)) | (1L << (OCTAL_LITERAL - 64)) | (1L << (FLOATING_POINT_LITERAL - 64)) | (1L << (CHAR - 64)) | (1L << (STRING - 64)) | (1L << (COMMENT - 64)) | (1L << (WHITESPACE - 64)) | (1L << (CPPCOMMENT - 64)) | (1L << (OTHER - 64)))) != 0)) {
				{
				{
				setState(589); no_brackets();
				}
				}
				setState(594);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(606);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==29) {
				{
				{
				setState(595); match(29);
				setState(596); type_id_list();
				setState(597); match(12);
				setState(601);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << 1) | (1L << 2) | (1L << 3) | (1L << 4) | (1L << 5) | (1L << 6) | (1L << 7) | (1L << 8) | (1L << 9) | (1L << 10) | (1L << 11) | (1L << 13) | (1L << 14) | (1L << 15) | (1L << 16) | (1L << 17) | (1L << 18) | (1L << 19) | (1L << 20) | (1L << 21) | (1L << 22) | (1L << 23) | (1L << 24) | (1L << 25) | (1L << 26) | (1L << 27) | (1L << 28) | (1L << 30) | (1L << 31) | (1L << 32) | (1L << 33) | (1L << 34) | (1L << 35) | (1L << 36) | (1L << 37) | (1L << 38) | (1L << 39) | (1L << 40) | (1L << 41) | (1L << 42) | (1L << 43) | (1L << 44) | (1L << 45) | (1L << 46) | (1L << 47) | (1L << 48) | (1L << 49) | (1L << 50) | (1L << 51) | (1L << 52) | (1L << 53) | (1L << 54) | (1L << 55) | (1L << IF) | (1L << ELSE) | (1L << FOR) | (1L << WHILE) | (1L << BREAK) | (1L << CASE) | (1L << CONTINUE) | (1L << SWITCH))) != 0) || ((((_la - 64)) & ~0x3f) == 0 && ((1L << (_la - 64)) & ((1L << (DO - 64)) | (1L << (GOTO - 64)) | (1L << (RETURN - 64)) | (1L << (TYPEDEF - 64)) | (1L << (VOID - 64)) | (1L << (UNSIGNED - 64)) | (1L << (SIGNED - 64)) | (1L << (LONG - 64)) | (1L << (CV_QUALIFIER - 64)) | (1L << (VIRTUAL - 64)) | (1L << (TRY - 64)) | (1L << (CATCH - 64)) | (1L << (THROW - 64)) | (1L << (USING - 64)) | (1L << (NAMESPACE - 64)) | (1L << (AUTO - 64)) | (1L << (REGISTER - 64)) | (1L << (OPERATOR - 64)) | (1L << (TEMPLATE - 64)) | (1L << (CLASS_KEY - 64)) | (1L << (ALPHA_NUMERIC - 64)) | (1L << (OPENING_CURLY - 64)) | (1L << (CLOSING_CURLY - 64)) | (1L << (PRE_IF - 64)) | (1L << (PRE_ELSE - 64)) | (1L << (PRE_ENDIF - 64)) | (1L << (HEX_LITERAL - 64)) | (1L << (DECIMAL_LITERAL - 64)) | (1L << (OCTAL_LITERAL - 64)) | (1L << (FLOATING_POINT_LITERAL - 64)) | (1L << (CHAR - 64)) | (1L << (STRING - 64)) | (1L << (COMMENT - 64)) | (1L << (WHITESPACE - 64)) | (1L << (CPPCOMMENT - 64)) | (1L << (OTHER - 64)))) != 0)) {
					{
					{
					setState(598); no_brackets();
					}
					}
					setState(603);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				}
				}
				setState(608);
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
		enterRule(_localctx, 116, RULE_init_declarator);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			{
			setState(610);
			_la = _input.LA(1);
			if (_la==1 || _la==3) {
				{
				setState(609); ptrs();
				}
			}

			setState(612); identifier();
			setState(614);
			switch ( getInterpreter().adaptivePredict(_input,55,_ctx) ) {
			case 1:
				{
				setState(613); type_suffix();
				}
				break;
			}
			}
			setState(623);
			switch (_input.LA(1)) {
			case 29:
				{
				{
				setState(616); match(29);
				setState(618);
				_la = _input.LA(1);
				if ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << 1) | (1L << 3) | (1L << 4) | (1L << 20) | (1L << 27) | (1L << 29) | (1L << 39) | (1L << 44) | (1L << 54))) != 0) || ((((_la - 84)) & ~0x3f) == 0 && ((1L << (_la - 84)) & ((1L << (ALPHA_NUMERIC - 84)) | (1L << (HEX_LITERAL - 84)) | (1L << (DECIMAL_LITERAL - 84)) | (1L << (OCTAL_LITERAL - 84)) | (1L << (FLOATING_POINT_LITERAL - 84)) | (1L << (CHAR - 84)) | (1L << (STRING - 84)))) != 0)) {
					{
					setState(617); expr();
					}
				}

				setState(620); match(12);
				}
				}
				break;
			case 16:
				{
				{
				setState(621); match(16);
				setState(622); assign_expr_w_();
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
		enterRule(_localctx, 118, RULE_type_suffix);
		try {
			setState(630);
			switch (_input.LA(1)) {
			case 2:
				enterOuterAlt(_localctx, 1);
				{
				{
				setState(625); match(2);
				setState(626); constant_expr_w_();
				setState(627); match(21);
				}
				}
				break;
			case 29:
				enterOuterAlt(_localctx, 2);
				{
				setState(629); param_type_list();
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
		enterRule(_localctx, 120, RULE_assign_expr_w_);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(635);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << 1) | (1L << 3) | (1L << 4) | (1L << 5) | (1L << 6) | (1L << 7) | (1L << 8) | (1L << 9) | (1L << 10) | (1L << 11) | (1L << 13) | (1L << 14) | (1L << 15) | (1L << 16) | (1L << 17) | (1L << 18) | (1L << 19) | (1L << 20) | (1L << 22) | (1L << 23) | (1L << 24) | (1L << 25) | (1L << 27) | (1L << 28) | (1L << 30) | (1L << 31) | (1L << 32) | (1L << 33) | (1L << 34) | (1L << 35) | (1L << 36) | (1L << 37) | (1L << 38) | (1L << 39) | (1L << 40) | (1L << 41) | (1L << 42) | (1L << 43) | (1L << 44) | (1L << 45) | (1L << 47) | (1L << 48) | (1L << 49) | (1L << 50) | (1L << 51) | (1L << 52) | (1L << 53) | (1L << 54) | (1L << 55) | (1L << IF) | (1L << ELSE) | (1L << FOR) | (1L << WHILE) | (1L << BREAK) | (1L << CASE) | (1L << CONTINUE) | (1L << SWITCH))) != 0) || ((((_la - 64)) & ~0x3f) == 0 && ((1L << (_la - 64)) & ((1L << (DO - 64)) | (1L << (GOTO - 64)) | (1L << (RETURN - 64)) | (1L << (TYPEDEF - 64)) | (1L << (VOID - 64)) | (1L << (UNSIGNED - 64)) | (1L << (SIGNED - 64)) | (1L << (LONG - 64)) | (1L << (CV_QUALIFIER - 64)) | (1L << (VIRTUAL - 64)) | (1L << (TRY - 64)) | (1L << (CATCH - 64)) | (1L << (THROW - 64)) | (1L << (USING - 64)) | (1L << (NAMESPACE - 64)) | (1L << (AUTO - 64)) | (1L << (REGISTER - 64)) | (1L << (OPERATOR - 64)) | (1L << (TEMPLATE - 64)) | (1L << (CLASS_KEY - 64)) | (1L << (ALPHA_NUMERIC - 64)) | (1L << (PRE_IF - 64)) | (1L << (PRE_ELSE - 64)) | (1L << (PRE_ENDIF - 64)) | (1L << (HEX_LITERAL - 64)) | (1L << (DECIMAL_LITERAL - 64)) | (1L << (OCTAL_LITERAL - 64)) | (1L << (FLOATING_POINT_LITERAL - 64)) | (1L << (CHAR - 64)) | (1L << (STRING - 64)) | (1L << (COMMENT - 64)) | (1L << (WHITESPACE - 64)) | (1L << (CPPCOMMENT - 64)) | (1L << (OTHER - 64)))) != 0)) {
				{
				{
				setState(632); assign_water();
				}
				}
				setState(637);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(660);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==2 || _la==29 || _la==OPENING_CURLY) {
				{
				{
				setState(650);
				switch (_input.LA(1)) {
				case OPENING_CURLY:
					{
					setState(638); match(OPENING_CURLY);
					setState(639); assign_expr_w__l2();
					setState(640); match(CLOSING_CURLY);
					}
					break;
				case 29:
					{
					setState(642); match(29);
					setState(643); assign_expr_w__l2();
					setState(644); match(12);
					}
					break;
				case 2:
					{
					setState(646); match(2);
					setState(647); assign_expr_w__l2();
					setState(648); match(21);
					}
					break;
				default:
					throw new NoViableAltException(this);
				}
				setState(655);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << 1) | (1L << 3) | (1L << 4) | (1L << 5) | (1L << 6) | (1L << 7) | (1L << 8) | (1L << 9) | (1L << 10) | (1L << 11) | (1L << 13) | (1L << 14) | (1L << 15) | (1L << 16) | (1L << 17) | (1L << 18) | (1L << 19) | (1L << 20) | (1L << 22) | (1L << 23) | (1L << 24) | (1L << 25) | (1L << 27) | (1L << 28) | (1L << 30) | (1L << 31) | (1L << 32) | (1L << 33) | (1L << 34) | (1L << 35) | (1L << 36) | (1L << 37) | (1L << 38) | (1L << 39) | (1L << 40) | (1L << 41) | (1L << 42) | (1L << 43) | (1L << 44) | (1L << 45) | (1L << 47) | (1L << 48) | (1L << 49) | (1L << 50) | (1L << 51) | (1L << 52) | (1L << 53) | (1L << 54) | (1L << 55) | (1L << IF) | (1L << ELSE) | (1L << FOR) | (1L << WHILE) | (1L << BREAK) | (1L << CASE) | (1L << CONTINUE) | (1L << SWITCH))) != 0) || ((((_la - 64)) & ~0x3f) == 0 && ((1L << (_la - 64)) & ((1L << (DO - 64)) | (1L << (GOTO - 64)) | (1L << (RETURN - 64)) | (1L << (TYPEDEF - 64)) | (1L << (VOID - 64)) | (1L << (UNSIGNED - 64)) | (1L << (SIGNED - 64)) | (1L << (LONG - 64)) | (1L << (CV_QUALIFIER - 64)) | (1L << (VIRTUAL - 64)) | (1L << (TRY - 64)) | (1L << (CATCH - 64)) | (1L << (THROW - 64)) | (1L << (USING - 64)) | (1L << (NAMESPACE - 64)) | (1L << (AUTO - 64)) | (1L << (REGISTER - 64)) | (1L << (OPERATOR - 64)) | (1L << (TEMPLATE - 64)) | (1L << (CLASS_KEY - 64)) | (1L << (ALPHA_NUMERIC - 64)) | (1L << (PRE_IF - 64)) | (1L << (PRE_ELSE - 64)) | (1L << (PRE_ENDIF - 64)) | (1L << (HEX_LITERAL - 64)) | (1L << (DECIMAL_LITERAL - 64)) | (1L << (OCTAL_LITERAL - 64)) | (1L << (FLOATING_POINT_LITERAL - 64)) | (1L << (CHAR - 64)) | (1L << (STRING - 64)) | (1L << (COMMENT - 64)) | (1L << (WHITESPACE - 64)) | (1L << (CPPCOMMENT - 64)) | (1L << (OTHER - 64)))) != 0)) {
					{
					{
					setState(652); assign_water();
					}
					}
					setState(657);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				}
				}
				setState(662);
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
		enterRule(_localctx, 122, RULE_assign_expr_w__l2);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(666);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << 1) | (1L << 3) | (1L << 4) | (1L << 5) | (1L << 6) | (1L << 7) | (1L << 8) | (1L << 9) | (1L << 10) | (1L << 11) | (1L << 13) | (1L << 14) | (1L << 15) | (1L << 16) | (1L << 17) | (1L << 18) | (1L << 19) | (1L << 20) | (1L << 22) | (1L << 23) | (1L << 24) | (1L << 25) | (1L << 26) | (1L << 27) | (1L << 28) | (1L << 30) | (1L << 31) | (1L << 32) | (1L << 33) | (1L << 34) | (1L << 35) | (1L << 36) | (1L << 37) | (1L << 38) | (1L << 39) | (1L << 40) | (1L << 41) | (1L << 42) | (1L << 43) | (1L << 44) | (1L << 45) | (1L << 46) | (1L << 47) | (1L << 48) | (1L << 49) | (1L << 50) | (1L << 51) | (1L << 52) | (1L << 53) | (1L << 54) | (1L << 55) | (1L << IF) | (1L << ELSE) | (1L << FOR) | (1L << WHILE) | (1L << BREAK) | (1L << CASE) | (1L << CONTINUE) | (1L << SWITCH))) != 0) || ((((_la - 64)) & ~0x3f) == 0 && ((1L << (_la - 64)) & ((1L << (DO - 64)) | (1L << (GOTO - 64)) | (1L << (RETURN - 64)) | (1L << (TYPEDEF - 64)) | (1L << (VOID - 64)) | (1L << (UNSIGNED - 64)) | (1L << (SIGNED - 64)) | (1L << (LONG - 64)) | (1L << (CV_QUALIFIER - 64)) | (1L << (VIRTUAL - 64)) | (1L << (TRY - 64)) | (1L << (CATCH - 64)) | (1L << (THROW - 64)) | (1L << (USING - 64)) | (1L << (NAMESPACE - 64)) | (1L << (AUTO - 64)) | (1L << (REGISTER - 64)) | (1L << (OPERATOR - 64)) | (1L << (TEMPLATE - 64)) | (1L << (CLASS_KEY - 64)) | (1L << (ALPHA_NUMERIC - 64)) | (1L << (PRE_IF - 64)) | (1L << (PRE_ELSE - 64)) | (1L << (PRE_ENDIF - 64)) | (1L << (HEX_LITERAL - 64)) | (1L << (DECIMAL_LITERAL - 64)) | (1L << (OCTAL_LITERAL - 64)) | (1L << (FLOATING_POINT_LITERAL - 64)) | (1L << (CHAR - 64)) | (1L << (STRING - 64)) | (1L << (COMMENT - 64)) | (1L << (WHITESPACE - 64)) | (1L << (CPPCOMMENT - 64)) | (1L << (OTHER - 64)))) != 0)) {
				{
				{
				setState(663); assign_water_l2();
				}
				}
				setState(668);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(691);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==2 || _la==29 || _la==OPENING_CURLY) {
				{
				{
				setState(681);
				switch (_input.LA(1)) {
				case OPENING_CURLY:
					{
					setState(669); match(OPENING_CURLY);
					setState(670); assign_expr_w__l2();
					setState(671); match(CLOSING_CURLY);
					}
					break;
				case 29:
					{
					setState(673); match(29);
					setState(674); assign_expr_w__l2();
					setState(675); match(12);
					}
					break;
				case 2:
					{
					setState(677); match(2);
					setState(678); assign_expr_w__l2();
					setState(679); match(21);
					}
					break;
				default:
					throw new NoViableAltException(this);
				}
				setState(686);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << 1) | (1L << 3) | (1L << 4) | (1L << 5) | (1L << 6) | (1L << 7) | (1L << 8) | (1L << 9) | (1L << 10) | (1L << 11) | (1L << 13) | (1L << 14) | (1L << 15) | (1L << 16) | (1L << 17) | (1L << 18) | (1L << 19) | (1L << 20) | (1L << 22) | (1L << 23) | (1L << 24) | (1L << 25) | (1L << 26) | (1L << 27) | (1L << 28) | (1L << 30) | (1L << 31) | (1L << 32) | (1L << 33) | (1L << 34) | (1L << 35) | (1L << 36) | (1L << 37) | (1L << 38) | (1L << 39) | (1L << 40) | (1L << 41) | (1L << 42) | (1L << 43) | (1L << 44) | (1L << 45) | (1L << 46) | (1L << 47) | (1L << 48) | (1L << 49) | (1L << 50) | (1L << 51) | (1L << 52) | (1L << 53) | (1L << 54) | (1L << 55) | (1L << IF) | (1L << ELSE) | (1L << FOR) | (1L << WHILE) | (1L << BREAK) | (1L << CASE) | (1L << CONTINUE) | (1L << SWITCH))) != 0) || ((((_la - 64)) & ~0x3f) == 0 && ((1L << (_la - 64)) & ((1L << (DO - 64)) | (1L << (GOTO - 64)) | (1L << (RETURN - 64)) | (1L << (TYPEDEF - 64)) | (1L << (VOID - 64)) | (1L << (UNSIGNED - 64)) | (1L << (SIGNED - 64)) | (1L << (LONG - 64)) | (1L << (CV_QUALIFIER - 64)) | (1L << (VIRTUAL - 64)) | (1L << (TRY - 64)) | (1L << (CATCH - 64)) | (1L << (THROW - 64)) | (1L << (USING - 64)) | (1L << (NAMESPACE - 64)) | (1L << (AUTO - 64)) | (1L << (REGISTER - 64)) | (1L << (OPERATOR - 64)) | (1L << (TEMPLATE - 64)) | (1L << (CLASS_KEY - 64)) | (1L << (ALPHA_NUMERIC - 64)) | (1L << (PRE_IF - 64)) | (1L << (PRE_ELSE - 64)) | (1L << (PRE_ENDIF - 64)) | (1L << (HEX_LITERAL - 64)) | (1L << (DECIMAL_LITERAL - 64)) | (1L << (OCTAL_LITERAL - 64)) | (1L << (FLOATING_POINT_LITERAL - 64)) | (1L << (CHAR - 64)) | (1L << (STRING - 64)) | (1L << (COMMENT - 64)) | (1L << (WHITESPACE - 64)) | (1L << (CPPCOMMENT - 64)) | (1L << (OTHER - 64)))) != 0)) {
					{
					{
					setState(683); assign_water_l2();
					}
					}
					setState(688);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				}
				}
				setState(693);
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
		enterRule(_localctx, 124, RULE_constant_expr_w_);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(697);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << 1) | (1L << 3) | (1L << 4) | (1L << 5) | (1L << 6) | (1L << 7) | (1L << 8) | (1L << 9) | (1L << 10) | (1L << 11) | (1L << 12) | (1L << 13) | (1L << 14) | (1L << 15) | (1L << 16) | (1L << 17) | (1L << 18) | (1L << 19) | (1L << 20) | (1L << 22) | (1L << 23) | (1L << 24) | (1L << 25) | (1L << 26) | (1L << 27) | (1L << 28) | (1L << 29) | (1L << 30) | (1L << 31) | (1L << 32) | (1L << 33) | (1L << 34) | (1L << 35) | (1L << 36) | (1L << 37) | (1L << 38) | (1L << 39) | (1L << 40) | (1L << 41) | (1L << 42) | (1L << 43) | (1L << 44) | (1L << 45) | (1L << 46) | (1L << 47) | (1L << 48) | (1L << 49) | (1L << 50) | (1L << 51) | (1L << 52) | (1L << 53) | (1L << 54) | (1L << 55) | (1L << IF) | (1L << ELSE) | (1L << FOR) | (1L << WHILE) | (1L << BREAK) | (1L << CASE) | (1L << CONTINUE) | (1L << SWITCH))) != 0) || ((((_la - 64)) & ~0x3f) == 0 && ((1L << (_la - 64)) & ((1L << (DO - 64)) | (1L << (GOTO - 64)) | (1L << (RETURN - 64)) | (1L << (TYPEDEF - 64)) | (1L << (VOID - 64)) | (1L << (UNSIGNED - 64)) | (1L << (SIGNED - 64)) | (1L << (LONG - 64)) | (1L << (CV_QUALIFIER - 64)) | (1L << (VIRTUAL - 64)) | (1L << (TRY - 64)) | (1L << (CATCH - 64)) | (1L << (THROW - 64)) | (1L << (USING - 64)) | (1L << (NAMESPACE - 64)) | (1L << (AUTO - 64)) | (1L << (REGISTER - 64)) | (1L << (OPERATOR - 64)) | (1L << (TEMPLATE - 64)) | (1L << (CLASS_KEY - 64)) | (1L << (ALPHA_NUMERIC - 64)) | (1L << (OPENING_CURLY - 64)) | (1L << (CLOSING_CURLY - 64)) | (1L << (PRE_IF - 64)) | (1L << (PRE_ELSE - 64)) | (1L << (PRE_ENDIF - 64)) | (1L << (HEX_LITERAL - 64)) | (1L << (DECIMAL_LITERAL - 64)) | (1L << (OCTAL_LITERAL - 64)) | (1L << (FLOATING_POINT_LITERAL - 64)) | (1L << (CHAR - 64)) | (1L << (STRING - 64)) | (1L << (COMMENT - 64)) | (1L << (WHITESPACE - 64)) | (1L << (CPPCOMMENT - 64)) | (1L << (OTHER - 64)))) != 0)) {
				{
				{
				setState(694); no_squares();
				}
				}
				setState(699);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(711);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==2) {
				{
				{
				setState(700); match(2);
				setState(701); constant_expr_w_();
				setState(702); match(21);
				setState(706);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << 1) | (1L << 3) | (1L << 4) | (1L << 5) | (1L << 6) | (1L << 7) | (1L << 8) | (1L << 9) | (1L << 10) | (1L << 11) | (1L << 12) | (1L << 13) | (1L << 14) | (1L << 15) | (1L << 16) | (1L << 17) | (1L << 18) | (1L << 19) | (1L << 20) | (1L << 22) | (1L << 23) | (1L << 24) | (1L << 25) | (1L << 26) | (1L << 27) | (1L << 28) | (1L << 29) | (1L << 30) | (1L << 31) | (1L << 32) | (1L << 33) | (1L << 34) | (1L << 35) | (1L << 36) | (1L << 37) | (1L << 38) | (1L << 39) | (1L << 40) | (1L << 41) | (1L << 42) | (1L << 43) | (1L << 44) | (1L << 45) | (1L << 46) | (1L << 47) | (1L << 48) | (1L << 49) | (1L << 50) | (1L << 51) | (1L << 52) | (1L << 53) | (1L << 54) | (1L << 55) | (1L << IF) | (1L << ELSE) | (1L << FOR) | (1L << WHILE) | (1L << BREAK) | (1L << CASE) | (1L << CONTINUE) | (1L << SWITCH))) != 0) || ((((_la - 64)) & ~0x3f) == 0 && ((1L << (_la - 64)) & ((1L << (DO - 64)) | (1L << (GOTO - 64)) | (1L << (RETURN - 64)) | (1L << (TYPEDEF - 64)) | (1L << (VOID - 64)) | (1L << (UNSIGNED - 64)) | (1L << (SIGNED - 64)) | (1L << (LONG - 64)) | (1L << (CV_QUALIFIER - 64)) | (1L << (VIRTUAL - 64)) | (1L << (TRY - 64)) | (1L << (CATCH - 64)) | (1L << (THROW - 64)) | (1L << (USING - 64)) | (1L << (NAMESPACE - 64)) | (1L << (AUTO - 64)) | (1L << (REGISTER - 64)) | (1L << (OPERATOR - 64)) | (1L << (TEMPLATE - 64)) | (1L << (CLASS_KEY - 64)) | (1L << (ALPHA_NUMERIC - 64)) | (1L << (OPENING_CURLY - 64)) | (1L << (CLOSING_CURLY - 64)) | (1L << (PRE_IF - 64)) | (1L << (PRE_ELSE - 64)) | (1L << (PRE_ENDIF - 64)) | (1L << (HEX_LITERAL - 64)) | (1L << (DECIMAL_LITERAL - 64)) | (1L << (OCTAL_LITERAL - 64)) | (1L << (FLOATING_POINT_LITERAL - 64)) | (1L << (CHAR - 64)) | (1L << (STRING - 64)) | (1L << (COMMENT - 64)) | (1L << (WHITESPACE - 64)) | (1L << (CPPCOMMENT - 64)) | (1L << (OTHER - 64)))) != 0)) {
					{
					{
					setState(703); no_squares();
					}
					}
					setState(708);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				}
				}
				setState(713);
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
		enterRule(_localctx, 126, RULE_simple_decl);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			{
			setState(715);
			_la = _input.LA(1);
			if (_la==TYPEDEF) {
				{
				setState(714); match(TYPEDEF);
				}
			}

			setState(718);
			_la = _input.LA(1);
			if (_la==TEMPLATE) {
				{
				setState(717); template_decl_start();
				}
			}

			}
			setState(720); var_decl();
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
		enterRule(_localctx, 128, RULE_var_decl);
		try {
			setState(729);
			switch ( getInterpreter().adaptivePredict(_input,73,_ctx) ) {
			case 1:
				_localctx = new DeclByClassContext(_localctx);
				enterOuterAlt(_localctx, 1);
				{
				setState(722); class_def();
				setState(724);
				switch ( getInterpreter().adaptivePredict(_input,72,_ctx) ) {
				case 1:
					{
					setState(723); init_declarator_list();
					}
					break;
				}
				}
				break;

			case 2:
				_localctx = new DeclByTypeContext(_localctx);
				enterOuterAlt(_localctx, 2);
				{
				setState(726); type_name();
				setState(727); init_declarator_list();
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
		enterRule(_localctx, 130, RULE_init_declarator_list);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(731); init_declarator();
			setState(736);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==26) {
				{
				{
				setState(732); match(26);
				setState(733); init_declarator();
				}
				}
				setState(738);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(739); match(46);
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
		enterRule(_localctx, 132, RULE_initializer);
		try {
			setState(746);
			switch (_input.LA(1)) {
			case 1:
			case 3:
			case 4:
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
				setState(741); assign_expr();
				}
				break;
			case OPENING_CURLY:
				enterOuterAlt(_localctx, 2);
				{
				setState(742); match(OPENING_CURLY);
				setState(743); initializer_list();
				setState(744); match(CLOSING_CURLY);
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
		enterRule(_localctx, 134, RULE_initializer_list);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(748); initializer();
			setState(753);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==26) {
				{
				{
				setState(749); match(26);
				setState(750); initializer();
				}
				}
				setState(755);
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
		enterRule(_localctx, 136, RULE_class_def);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(756); match(CLASS_KEY);
			setState(758);
			_la = _input.LA(1);
			if (_la==ALPHA_NUMERIC) {
				{
				setState(757); class_name();
				}
			}

			setState(761);
			_la = _input.LA(1);
			if (_la==28) {
				{
				setState(760); base_classes();
				}
			}

			setState(763); match(OPENING_CURLY);
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
		enterRule(_localctx, 138, RULE_class_name);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(766); identifier();
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
		enterRule(_localctx, 140, RULE_base_classes);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(768); match(28);
			setState(769); base_class();
			setState(774);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==26) {
				{
				{
				setState(770); match(26);
				setState(771); base_class();
				}
				}
				setState(776);
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
		enterRule(_localctx, 142, RULE_base_class);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(778);
			_la = _input.LA(1);
			if (_la==VIRTUAL) {
				{
				setState(777); match(VIRTUAL);
				}
			}

			setState(781);
			_la = _input.LA(1);
			if ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << 25) | (1L << 31) | (1L << 45))) != 0)) {
				{
				setState(780); access_specifier();
				}
			}

			setState(783); identifier();
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
		enterRule(_localctx, 144, RULE_type_name);
		int _la;
		try {
			setState(816);
			switch ( getInterpreter().adaptivePredict(_input,87,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				{
				setState(788);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (_la==CV_QUALIFIER) {
					{
					{
					setState(785); match(CV_QUALIFIER);
					}
					}
					setState(790);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				setState(792);
				_la = _input.LA(1);
				if (((((_la - 69)) & ~0x3f) == 0 && ((1L << (_la - 69)) & ((1L << (UNSIGNED - 69)) | (1L << (SIGNED - 69)) | (1L << (CLASS_KEY - 69)))) != 0)) {
					{
					setState(791);
					_la = _input.LA(1);
					if ( !(((((_la - 69)) & ~0x3f) == 0 && ((1L << (_la - 69)) & ((1L << (UNSIGNED - 69)) | (1L << (SIGNED - 69)) | (1L << (CLASS_KEY - 69)))) != 0)) ) {
					_errHandler.recoverInline(this);
					}
					consume();
					}
				}

				setState(794); base_type();
				setState(799);
				_la = _input.LA(1);
				if (_la==5) {
					{
					setState(795); match(5);
					setState(796); template_param_list();
					setState(797); match(49);
					}
				}

				setState(811);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (_la==15) {
					{
					{
					setState(801); match(15);
					setState(802); base_type();
					setState(807);
					_la = _input.LA(1);
					if (_la==5) {
						{
						setState(803); match(5);
						setState(804); template_param_list();
						setState(805); match(49);
						}
					}

					}
					}
					setState(813);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				}
				}
				break;

			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(814); match(UNSIGNED);
				}
				break;

			case 3:
				enterOuterAlt(_localctx, 3);
				{
				setState(815); match(SIGNED);
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
		enterRule(_localctx, 146, RULE_base_type);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(823);
			switch ( getInterpreter().adaptivePredict(_input,88,_ctx) ) {
			case 1:
				{
				setState(818); match(ALPHA_NUMERIC);
				}
				break;

			case 2:
				{
				setState(819); match(VOID);
				}
				break;

			case 3:
				{
				setState(820); match(LONG);
				}
				break;

			case 4:
				{
				setState(821); match(LONG);
				setState(822); match(LONG);
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
		enterRule(_localctx, 148, RULE_param_decl_specifiers);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(826);
			_la = _input.LA(1);
			if (_la==AUTO || _la==REGISTER) {
				{
				setState(825);
				_la = _input.LA(1);
				if ( !(_la==AUTO || _la==REGISTER) ) {
				_errHandler.recoverInline(this);
				}
				consume();
				}
			}

			setState(828); type_name();
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
		enterRule(_localctx, 150, RULE_parameter_name);
		try {
			setState(832);
			switch (_input.LA(1)) {
			case ALPHA_NUMERIC:
				enterOuterAlt(_localctx, 1);
				{
				setState(830); identifier();
				}
				break;
			case 25:
			case 31:
			case 45:
				enterOuterAlt(_localctx, 2);
				{
				setState(831); access_specifier();
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
		enterRule(_localctx, 152, RULE_param_type_list);
		int _la;
		try {
			setState(849);
			switch ( getInterpreter().adaptivePredict(_input,93,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(834); match(29);
				setState(835); match(VOID);
				setState(836); match(12);
				}
				break;

			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(837); match(29);
				setState(846);
				_la = _input.LA(1);
				if (((((_la - 68)) & ~0x3f) == 0 && ((1L << (_la - 68)) & ((1L << (VOID - 68)) | (1L << (UNSIGNED - 68)) | (1L << (SIGNED - 68)) | (1L << (LONG - 68)) | (1L << (CV_QUALIFIER - 68)) | (1L << (AUTO - 68)) | (1L << (REGISTER - 68)) | (1L << (CLASS_KEY - 68)) | (1L << (ALPHA_NUMERIC - 68)))) != 0)) {
					{
					setState(838); param_type();
					setState(843);
					_errHandler.sync(this);
					_la = _input.LA(1);
					while (_la==26) {
						{
						{
						setState(839); match(26);
						setState(840); param_type();
						}
						}
						setState(845);
						_errHandler.sync(this);
						_la = _input.LA(1);
					}
					}
				}

				setState(848); match(12);
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
		enterRule(_localctx, 154, RULE_param_type);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(851); param_decl_specifiers();
			setState(852); param_type_id();
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
		enterRule(_localctx, 156, RULE_param_type_id);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(855);
			_la = _input.LA(1);
			if (_la==1 || _la==3) {
				{
				setState(854); ptrs();
				}
			}

			setState(864);
			switch ( getInterpreter().adaptivePredict(_input,96,_ctx) ) {
			case 1:
				{
				setState(857); match(29);
				setState(858); param_type_id();
				setState(859); match(12);
				}
				break;

			case 2:
				{
				setState(862);
				_la = _input.LA(1);
				if (((((_la - 25)) & ~0x3f) == 0 && ((1L << (_la - 25)) & ((1L << (25 - 25)) | (1L << (31 - 25)) | (1L << (45 - 25)) | (1L << (ALPHA_NUMERIC - 25)))) != 0)) {
					{
					setState(861); parameter_name();
					}
				}

				}
				break;
			}
			setState(867);
			_la = _input.LA(1);
			if (_la==2 || _la==29) {
				{
				setState(866); type_suffix();
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
		enterRule(_localctx, 158, RULE_identifier);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(869); match(ALPHA_NUMERIC);
			setState(874);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==15) {
				{
				{
				setState(870); match(15);
				setState(871); match(ALPHA_NUMERIC);
				}
				}
				setState(876);
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
		enterRule(_localctx, 160, RULE_number);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(877);
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
		enterRule(_localctx, 162, RULE_ptrs);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(880); 
			_errHandler.sync(this);
			_la = _input.LA(1);
			do {
				{
				{
				setState(879); ptr_operator();
				}
				}
				setState(882); 
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
		"\2\3e\u0377\4\2\t\2\4\3\t\3\4\4\t\4\4\5\t\5\4\6\t\6\4\7\t\7\4\b\t\b\4"+
		"\t\t\t\4\n\t\n\4\13\t\13\4\f\t\f\4\r\t\r\4\16\t\16\4\17\t\17\4\20\t\20"+
		"\4\21\t\21\4\22\t\22\4\23\t\23\4\24\t\24\4\25\t\25\4\26\t\26\4\27\t\27"+
		"\4\30\t\30\4\31\t\31\4\32\t\32\4\33\t\33\4\34\t\34\4\35\t\35\4\36\t\36"+
		"\4\37\t\37\4 \t \4!\t!\4\"\t\"\4#\t#\4$\t$\4%\t%\4&\t&\4\'\t\'\4(\t(\4"+
		")\t)\4*\t*\4+\t+\4,\t,\4-\t-\4.\t.\4/\t/\4\60\t\60\4\61\t\61\4\62\t\62"+
		"\4\63\t\63\4\64\t\64\4\65\t\65\4\66\t\66\4\67\t\67\48\t8\49\t9\4:\t:\4"+
		";\t;\4<\t<\4=\t=\4>\t>\4?\t?\4@\t@\4A\tA\4B\tB\4C\tC\4D\tD\4E\tE\4F\t"+
		"F\4G\tG\4H\tH\4I\tI\4J\tJ\4K\tK\4L\tL\4M\tM\4N\tN\4O\tO\4P\tP\4Q\tQ\4"+
		"R\tR\4S\tS\3\2\3\2\3\2\3\2\7\2\u00ab\n\2\f\2\16\2\u00ae\13\2\3\3\3\3\3"+
		"\3\3\3\3\3\3\4\3\4\3\4\5\4\u00b8\n\4\3\5\3\5\3\5\3\5\7\5\u00be\n\5\f\5"+
		"\16\5\u00c1\13\5\3\6\3\6\3\6\3\6\3\6\3\6\5\6\u00c9\n\6\3\7\3\7\3\7\7\7"+
		"\u00ce\n\7\f\7\16\7\u00d1\13\7\3\b\3\b\3\b\7\b\u00d6\n\b\f\b\16\b\u00d9"+
		"\13\b\3\t\3\t\3\t\7\t\u00de\n\t\f\t\16\t\u00e1\13\t\3\n\3\n\3\n\7\n\u00e6"+
		"\n\n\f\n\16\n\u00e9\13\n\3\13\3\13\3\13\7\13\u00ee\n\13\f\13\16\13\u00f1"+
		"\13\13\3\f\3\f\3\f\3\f\7\f\u00f7\n\f\f\f\16\f\u00fa\13\f\3\r\3\r\3\r\3"+
		"\r\7\r\u0100\n\r\f\r\16\r\u0103\13\r\3\16\3\16\3\16\7\16\u0108\n\16\f"+
		"\16\16\16\u010b\13\16\3\17\3\17\3\17\7\17\u0110\n\17\f\17\16\17\u0113"+
		"\13\17\3\20\3\20\3\20\7\20\u0118\n\20\f\20\16\20\u011b\13\20\3\21\3\21"+
		"\3\21\7\21\u0120\n\21\f\21\16\21\u0123\13\21\3\21\3\21\3\21\3\21\5\21"+
		"\u0129\n\21\3\22\7\22\u012c\n\22\f\22\16\22\u012f\13\22\3\22\7\22\u0132"+
		"\n\22\f\22\16\22\u0135\13\22\3\22\3\22\3\22\3\22\3\22\5\22\u013c\n\22"+
		"\3\22\3\22\3\22\7\22\u0141\n\22\f\22\16\22\u0144\13\22\3\22\7\22\u0147"+
		"\n\22\f\22\16\22\u014a\13\22\3\22\5\22\u014d\n\22\3\23\3\23\7\23\u0151"+
		"\n\23\f\23\16\23\u0154\13\23\3\24\3\24\3\24\3\24\7\24\u015a\n\24\f\24"+
		"\16\24\u015d\13\24\5\24\u015f\n\24\3\24\3\24\3\25\3\25\3\26\3\26\3\26"+
		"\3\26\3\26\3\26\3\26\3\26\5\26\u016d\n\26\3\26\3\26\5\26\u0171\n\26\3"+
		"\27\3\27\3\27\3\27\3\27\3\27\5\27\u0179\n\27\3\30\3\30\3\31\3\31\3\32"+
		"\3\32\3\33\3\33\3\34\3\34\3\35\3\35\3\36\3\36\3\36\5\36\u018a\n\36\3\36"+
		"\3\36\3\36\3\36\3\36\3\36\3\36\3\36\3\36\3\36\3\36\3\36\3\36\3\36\3\36"+
		"\3\36\3\36\3\36\3\36\3\36\3\36\3\36\3\36\3\36\3\36\3\36\3\36\3\36\3\36"+
		"\3\36\3\36\3\36\3\36\3\36\3\36\3\36\3\36\3\36\3\36\3\36\5\36\u01b4\n\36"+
		"\3\37\3\37\3 \3 \3!\3!\3!\3\"\3\"\3\"\3\"\3\"\3\"\3\"\3\"\3\"\6\"\u01c6"+
		"\n\"\r\"\16\"\u01c7\3#\3#\3$\3$\3%\3%\3&\3&\3\'\3\'\3(\3(\3)\3)\3*\3*"+
		"\3+\3+\3,\3,\3-\3-\3.\5.\u01e1\n.\3.\5.\u01e4\n.\3.\3.\3.\5.\u01e9\n."+
		"\3.\3.\3/\7/\u01ee\n/\f/\16/\u01f1\13/\3/\3/\3/\7/\u01f6\n/\f/\16/\u01f9"+
		"\13/\3\60\3\60\5\60\u01fd\n\60\3\60\3\60\7\60\u0201\n\60\f\60\16\60\u0204"+
		"\13\60\3\60\5\60\u0207\n\60\3\61\3\61\3\61\7\61\u020c\n\61\f\61\16\61"+
		"\u020f\13\61\3\61\3\61\5\61\u0213\n\61\3\61\5\61\u0216\n\61\3\62\3\62"+
		"\3\62\3\63\5\63\u021c\n\63\3\63\3\63\3\63\3\63\3\63\5\63\u0223\n\63\3"+
		"\63\5\63\u0226\n\63\3\64\3\64\3\64\3\65\3\65\3\65\3\65\7\65\u022f\n\65"+
		"\f\65\16\65\u0232\13\65\3\66\3\66\3\66\3\67\5\67\u0238\n\67\3\67\3\67"+
		"\38\38\58\u023e\n8\38\38\39\39\39\39\39\39\39\59\u0249\n9\3:\3:\3:\3:"+
		"\3:\3;\7;\u0251\n;\f;\16;\u0254\13;\3;\3;\3;\3;\7;\u025a\n;\f;\16;\u025d"+
		"\13;\7;\u025f\n;\f;\16;\u0262\13;\3<\5<\u0265\n<\3<\3<\5<\u0269\n<\3<"+
		"\3<\5<\u026d\n<\3<\3<\3<\5<\u0272\n<\3=\3=\3=\3=\3=\5=\u0279\n=\3>\7>"+
		"\u027c\n>\f>\16>\u027f\13>\3>\3>\3>\3>\3>\3>\3>\3>\3>\3>\3>\3>\5>\u028d"+
		"\n>\3>\7>\u0290\n>\f>\16>\u0293\13>\7>\u0295\n>\f>\16>\u0298\13>\3?\7"+
		"?\u029b\n?\f?\16?\u029e\13?\3?\3?\3?\3?\3?\3?\3?\3?\3?\3?\3?\3?\5?\u02ac"+
		"\n?\3?\7?\u02af\n?\f?\16?\u02b2\13?\7?\u02b4\n?\f?\16?\u02b7\13?\3@\7"+
		"@\u02ba\n@\f@\16@\u02bd\13@\3@\3@\3@\3@\7@\u02c3\n@\f@\16@\u02c6\13@\7"+
		"@\u02c8\n@\f@\16@\u02cb\13@\3A\5A\u02ce\nA\3A\5A\u02d1\nA\3A\3A\3B\3B"+
		"\5B\u02d7\nB\3B\3B\3B\5B\u02dc\nB\3C\3C\3C\7C\u02e1\nC\fC\16C\u02e4\13"+
		"C\3C\3C\3D\3D\3D\3D\3D\5D\u02ed\nD\3E\3E\3E\7E\u02f2\nE\fE\16E\u02f5\13"+
		"E\3F\3F\5F\u02f9\nF\3F\5F\u02fc\nF\3F\3F\3F\3G\3G\3H\3H\3H\3H\7H\u0307"+
		"\nH\fH\16H\u030a\13H\3I\5I\u030d\nI\3I\5I\u0310\nI\3I\3I\3J\7J\u0315\n"+
		"J\fJ\16J\u0318\13J\3J\5J\u031b\nJ\3J\3J\3J\3J\3J\5J\u0322\nJ\3J\3J\3J"+
		"\3J\3J\3J\5J\u032a\nJ\7J\u032c\nJ\fJ\16J\u032f\13J\3J\3J\5J\u0333\nJ\3"+
		"K\3K\3K\3K\3K\5K\u033a\nK\3L\5L\u033d\nL\3L\3L\3M\3M\5M\u0343\nM\3N\3"+
		"N\3N\3N\3N\3N\3N\7N\u034c\nN\fN\16N\u034f\13N\5N\u0351\nN\3N\5N\u0354"+
		"\nN\3O\3O\3O\3P\5P\u035a\nP\3P\3P\3P\3P\3P\5P\u0361\nP\5P\u0363\nP\3P"+
		"\5P\u0366\nP\3Q\3Q\3Q\7Q\u036b\nQ\fQ\16Q\u036e\13Q\3R\3R\3S\6S\u0373\n"+
		"S\rS\16S\u0374\3S\2T\2\4\6\b\n\f\16\20\22\24\26\30\32\34\36 \"$&(*,.\60"+
		"\62\64\668:<>@BDFHJLNPRTVXZ\\^`bdfhjlnprtvxz|~\u0080\u0082\u0084\u0086"+
		"\u0088\u008a\u008c\u008e\u0090\u0092\u0094\u0096\u0098\u009a\u009c\u009e"+
		"\u00a0\u00a2\u00a4\2\35\4\n\n**\4\35\35..\5\5\5\13\13\66\66\4\6\6))\4"+
		"\6\6))\b\3\3\5\5\26\26\35\35..88\6\7\7\t\t\63\6399\3\\a\5\17\20\'(KK\4"+
		"\3\3\5\5\5\33\33!!//\4\24\24++\t\r\r\22\23\30\31  ##%&\64\65\4\b\b\67"+
		"\67\4\16\16\37\37\7\4\4\16\16\27\27\37\37WX\5\16\16\37\37\60\60\6\7\7"+
		"\16\16\37\37\63\63\3WX\4\4\4\27\27\5\4\4\27\27\60\60\4\34\34\60\60\t\4"+
		"\4\16\16\27\27\34\34\37\37\60\60WX\7\4\4\16\16\27\27\37\37WX\4GHUU\3Q"+
		"R\3\\^\u03ba\2\u00ac\3\2\2\2\4\u00af\3\2\2\2\6\u00b4\3\2\2\2\b\u00b9\3"+
		"\2\2\2\n\u00c2\3\2\2\2\f\u00ca\3\2\2\2\16\u00d2\3\2\2\2\20\u00da\3\2\2"+
		"\2\22\u00e2\3\2\2\2\24\u00ea\3\2\2\2\26\u00f2\3\2\2\2\30\u00fb\3\2\2\2"+
		"\32\u0104\3\2\2\2\34\u010c\3\2\2\2\36\u0114\3\2\2\2 \u0128\3\2\2\2\"\u014c"+
		"\3\2\2\2$\u014e\3\2\2\2&\u0155\3\2\2\2(\u0162\3\2\2\2*\u0170\3\2\2\2,"+
		"\u0178\3\2\2\2.\u017a\3\2\2\2\60\u017c\3\2\2\2\62\u017e\3\2\2\2\64\u0180"+
		"\3\2\2\2\66\u0182\3\2\2\28\u0184\3\2\2\2:\u01b3\3\2\2\2<\u01b5\3\2\2\2"+
		">\u01b7\3\2\2\2@\u01b9\3\2\2\2B\u01c5\3\2\2\2D\u01c9\3\2\2\2F\u01cb\3"+
		"\2\2\2H\u01cd\3\2\2\2J\u01cf\3\2\2\2L\u01d1\3\2\2\2N\u01d3\3\2\2\2P\u01d5"+
		"\3\2\2\2R\u01d7\3\2\2\2T\u01d9\3\2\2\2V\u01db\3\2\2\2X\u01dd\3\2\2\2Z"+
		"\u01e0\3\2\2\2\\\u01ef\3\2\2\2^\u01fa\3\2\2\2`\u0215\3\2\2\2b\u0217\3"+
		"\2\2\2d\u021b\3\2\2\2f\u0227\3\2\2\2h\u022a\3\2\2\2j\u0233\3\2\2\2l\u0237"+
		"\3\2\2\2n\u023b\3\2\2\2p\u0248\3\2\2\2r\u024a\3\2\2\2t\u0252\3\2\2\2v"+
		"\u0264\3\2\2\2x\u0278\3\2\2\2z\u027d\3\2\2\2|\u029c\3\2\2\2~\u02bb\3\2"+
		"\2\2\u0080\u02cd\3\2\2\2\u0082\u02db\3\2\2\2\u0084\u02dd\3\2\2\2\u0086"+
		"\u02ec\3\2\2\2\u0088\u02ee\3\2\2\2\u008a\u02f6\3\2\2\2\u008c\u0300\3\2"+
		"\2\2\u008e\u0302\3\2\2\2\u0090\u030c\3\2\2\2\u0092\u0332\3\2\2\2\u0094"+
		"\u0339\3\2\2\2\u0096\u033c\3\2\2\2\u0098\u0342\3\2\2\2\u009a\u0353\3\2"+
		"\2\2\u009c\u0355\3\2\2\2\u009e\u0359\3\2\2\2\u00a0\u0367\3\2\2\2\u00a2"+
		"\u036f\3\2\2\2\u00a4\u0372\3\2\2\2\u00a6\u00ab\5Z.\2\u00a7\u00ab\5\u0080"+
		"A\2\u00a8\u00ab\5\4\3\2\u00a9\u00ab\5X-\2\u00aa\u00a6\3\2\2\2\u00aa\u00a7"+
		"\3\2\2\2\u00aa\u00a8\3\2\2\2\u00aa\u00a9\3\2\2\2\u00ab\u00ae\3\2\2\2\u00ac"+
		"\u00aa\3\2\2\2\u00ac\u00ad\3\2\2\2\u00ad\3\3\2\2\2\u00ae\u00ac\3\2\2\2"+
		"\u00af\u00b0\7O\2\2\u00b0\u00b1\7P\2\2\u00b1\u00b2\5\u00a0Q\2\u00b2\u00b3"+
		"\7\60\2\2\u00b3\5\3\2\2\2\u00b4\u00b7\5\b\5\2\u00b5\u00b6\7\34\2\2\u00b6"+
		"\u00b8\5\b\5\2\u00b7\u00b5\3\2\2\2\u00b7\u00b8\3\2\2\2\u00b8\7\3\2\2\2"+
		"\u00b9\u00bf\5\n\6\2\u00ba\u00bb\5<\37\2\u00bb\u00bc\5\n\6\2\u00bc\u00be"+
		"\3\2\2\2\u00bd\u00ba\3\2\2\2\u00be\u00c1\3\2\2\2\u00bf\u00bd\3\2\2\2\u00bf"+
		"\u00c0\3\2\2\2\u00c0\t\3\2\2\2\u00c1\u00bf\3\2\2\2\u00c2\u00c8\5\f\7\2"+
		"\u00c3\u00c4\7\"\2\2\u00c4\u00c5\5\6\4\2\u00c5\u00c6\7\36\2\2\u00c6\u00c7"+
		"\5\n\6\2\u00c7\u00c9\3\2\2\2\u00c8\u00c3\3\2\2\2\u00c8\u00c9\3\2\2\2\u00c9"+
		"\13\3\2\2\2\u00ca\u00cf\5\16\b\2\u00cb\u00cc\7\62\2\2\u00cc\u00ce\5\16"+
		"\b\2\u00cd\u00cb\3\2\2\2\u00ce\u00d1\3\2\2\2\u00cf\u00cd\3\2\2\2\u00cf"+
		"\u00d0\3\2\2\2\u00d0\r\3\2\2\2\u00d1\u00cf\3\2\2\2\u00d2\u00d7\5\20\t"+
		"\2\u00d3\u00d4\7\61\2\2\u00d4\u00d6\5\20\t\2\u00d5\u00d3\3\2\2\2\u00d6"+
		"\u00d9\3\2\2\2\u00d7\u00d5\3\2\2\2\u00d7\u00d8\3\2\2\2\u00d8\17\3\2\2"+
		"\2\u00d9\u00d7\3\2\2\2\u00da\u00df\5\22\n\2\u00db\u00dc\7\25\2\2\u00dc"+
		"\u00de\5\22\n\2\u00dd\u00db\3\2\2\2\u00de\u00e1\3\2\2\2\u00df\u00dd\3"+
		"\2\2\2\u00df\u00e0\3\2\2\2\u00e0\21\3\2\2\2\u00e1\u00df\3\2\2\2\u00e2"+
		"\u00e7\5\24\13\2\u00e3\u00e4\7,\2\2\u00e4\u00e6\5\24\13\2\u00e5\u00e3"+
		"\3\2\2\2\u00e6\u00e9\3\2\2\2\u00e7\u00e5\3\2\2\2\u00e7\u00e8\3\2\2\2\u00e8"+
		"\23\3\2\2\2\u00e9\u00e7\3\2\2\2\u00ea\u00ef\5\26\f\2\u00eb\u00ec\7\3\2"+
		"\2\u00ec\u00ee\5\26\f\2\u00ed\u00eb\3\2\2\2\u00ee\u00f1\3\2\2\2\u00ef"+
		"\u00ed\3\2\2\2\u00ef\u00f0\3\2\2\2\u00f0\25\3\2\2\2\u00f1\u00ef\3\2\2"+
		"\2\u00f2\u00f8\5\30\r\2\u00f3\u00f4\5> \2\u00f4\u00f5\5\30\r\2\u00f5\u00f7"+
		"\3\2\2\2\u00f6\u00f3\3\2\2\2\u00f7\u00fa\3\2\2\2\u00f8\u00f6\3\2\2\2\u00f8"+
		"\u00f9\3\2\2\2\u00f9\27\3\2\2\2\u00fa\u00f8\3\2\2\2\u00fb\u0101\5\32\16"+
		"\2\u00fc\u00fd\5\60\31\2\u00fd\u00fe\5\32\16\2\u00fe\u0100\3\2\2\2\u00ff"+
		"\u00fc\3\2\2\2\u0100\u0103\3\2\2\2\u0101\u00ff\3\2\2\2\u0101\u0102\3\2"+
		"\2\2\u0102\31\3\2\2\2\u0103\u0101\3\2\2\2\u0104\u0109\5\34\17\2\u0105"+
		"\u0106\t\2\2\2\u0106\u0108\5\34\17\2\u0107\u0105\3\2\2\2\u0108\u010b\3"+
		"\2\2\2\u0109\u0107\3\2\2\2\u0109\u010a\3\2\2\2\u010a\33\3\2\2\2\u010b"+
		"\u0109\3\2\2\2\u010c\u0111\5\36\20\2\u010d\u010e\t\3\2\2\u010e\u0110\5"+
		"\36\20\2\u010f\u010d\3\2\2\2\u0110\u0113\3\2\2\2\u0111\u010f\3\2\2\2\u0111"+
		"\u0112\3\2\2\2\u0112\35\3\2\2\2\u0113\u0111\3\2\2\2\u0114\u0119\5 \21"+
		"\2\u0115\u0116\t\4\2\2\u0116\u0118\5 \21\2\u0117\u0115\3\2\2\2\u0118\u011b"+
		"\3\2\2\2\u0119\u0117\3\2\2\2\u0119\u011a\3\2\2\2\u011a\37\3\2\2\2\u011b"+
		"\u0119\3\2\2\2\u011c\u011d\7\37\2\2\u011d\u0121\5\u0092J\2\u011e\u0120"+
		"\5\66\34\2\u011f\u011e\3\2\2\2\u0120\u0123\3\2\2\2\u0121\u011f\3\2\2\2"+
		"\u0121\u0122\3\2\2\2\u0122\u0124\3\2\2\2\u0123\u0121\3\2\2\2\u0124\u0125"+
		"\7\16\2\2\u0125\u0126\5 \21\2\u0126\u0129\3\2\2\2\u0127\u0129\5\"\22\2"+
		"\u0128\u011c\3\2\2\2\u0128\u0127\3\2\2\2\u0129!\3\2\2\2\u012a\u012c\t"+
		"\5\2\2\u012b\u012a\3\2\2\2\u012c\u012f\3\2\2\2\u012d\u012b\3\2\2\2\u012d"+
		"\u012e\3\2\2\2\u012e\u0133\3\2\2\2\u012f\u012d\3\2\2\2\u0130\u0132\5."+
		"\30\2\u0131\u0130\3\2\2\2\u0132\u0135\3\2\2\2\u0133\u0131\3\2\2\2\u0133"+
		"\u0134\3\2\2\2\u0134\u0136\3\2\2\2\u0135\u0133\3\2\2\2\u0136\u013b\5$"+
		"\23\2\u0137\u0138\7\7\2\2\u0138\u0139\5B\"\2\u0139\u013a\7\63\2\2\u013a"+
		"\u013c\3\2\2\2\u013b\u0137\3\2\2\2\u013b\u013c\3\2\2\2\u013c\u013d\3\2"+
		"\2\2\u013d\u013e\5&\24\2\u013e\u014d\3\2\2\2\u013f\u0141\t\6\2\2\u0140"+
		"\u013f\3\2\2\2\u0141\u0144\3\2\2\2\u0142\u0140\3\2\2\2\u0142\u0143\3\2"+
		"\2\2\u0143\u0148\3\2\2\2\u0144\u0142\3\2\2\2\u0145\u0147\5.\30\2\u0146"+
		"\u0145\3\2\2\2\u0147\u014a\3\2\2\2\u0148\u0146\3\2\2\2\u0148\u0149\3\2"+
		"\2\2\u0149\u014b\3\2\2\2\u014a\u0148\3\2\2\2\u014b\u014d\5$\23\2\u014c"+
		"\u012d\3\2\2\2\u014c\u0142\3\2\2\2\u014d#\3\2\2\2\u014e\u0152\5,\27\2"+
		"\u014f\u0151\5*\26\2\u0150\u014f\3\2\2\2\u0151\u0154\3\2\2\2\u0152\u0150"+
		"\3\2\2\2\u0152\u0153\3\2\2\2\u0153%\3\2\2\2\u0154\u0152\3\2\2\2\u0155"+
		"\u015e\7\37\2\2\u0156\u015b\5(\25\2\u0157\u0158\7\34\2\2\u0158\u015a\5"+
		"(\25\2\u0159\u0157\3\2\2\2\u015a\u015d\3\2\2\2\u015b\u0159\3\2\2\2\u015b"+
		"\u015c\3\2\2\2\u015c\u015f\3\2\2\2\u015d\u015b\3\2\2\2\u015e\u0156\3\2"+
		"\2\2\u015e\u015f\3\2\2\2\u015f\u0160\3\2\2\2\u0160\u0161\7\16\2\2\u0161"+
		"\'\3\2\2\2\u0162\u0163\5\b\5\2\u0163)\3\2\2\2\u0164\u0165\7-\2\2\u0165"+
		"\u016d\5\u00a0Q\2\u0166\u0167\7\f\2\2\u0167\u016d\5\u00a0Q\2\u0168\u0169"+
		"\7\4\2\2\u0169\u016a\5\6\4\2\u016a\u016b\7\27\2\2\u016b\u016d\3\2\2\2"+
		"\u016c\u0164\3\2\2\2\u016c\u0166\3\2\2\2\u016c\u0168\3\2\2\2\u016d\u0171"+
		"\3\2\2\2\u016e\u0171\7)\2\2\u016f\u0171\7\6\2\2\u0170\u016c\3\2\2\2\u0170"+
		"\u016e\3\2\2\2\u0170\u016f\3\2\2\2\u0171+\3\2\2\2\u0172\u0179\5\u00a0"+
		"Q\2\u0173\u0179\5\62\32\2\u0174\u0175\7\37\2\2\u0175\u0176\5\6\4\2\u0176"+
		"\u0177\7\16\2\2\u0177\u0179\3\2\2\2\u0178\u0172\3\2\2\2\u0178\u0173\3"+
		"\2\2\2\u0178\u0174\3\2\2\2\u0179-\3\2\2\2\u017a\u017b\t\7\2\2\u017b/\3"+
		"\2\2\2\u017c\u017d\t\b\2\2\u017d\61\3\2\2\2\u017e\u017f\t\t\2\2\u017f"+
		"\63\3\2\2\2\u0180\u0181\t\n\2\2\u0181\65\3\2\2\2\u0182\u0183\t\13\2\2"+
		"\u0183\67\3\2\2\2\u0184\u0185\t\f\2\2\u01859\3\2\2\2\u0186\u0189\t\r\2"+
		"\2\u0187\u0188\7\4\2\2\u0188\u018a\7\27\2\2\u0189\u0187\3\2\2\2\u0189"+
		"\u018a\3\2\2\2\u018a\u01b4\3\2\2\2\u018b\u01b4\7.\2\2\u018c\u01b4\7\35"+
		"\2\2\u018d\u01b4\7\5\2\2\u018e\u01b4\7\66\2\2\u018f\u01b4\7\13\2\2\u0190"+
		"\u01b4\7,\2\2\u0191\u01b4\7\3\2\2\u0192\u01b4\7\25\2\2\u0193\u01b4\78"+
		"\2\2\u0194\u01b4\7\26\2\2\u0195\u01b4\7\22\2\2\u0196\u01b4\7\7\2\2\u0197"+
		"\u01b4\7\63\2\2\u0198\u01b4\7%\2\2\u0199\u01b4\7\31\2\2\u019a\u01b4\7"+
		"\r\2\2\u019b\u01b4\7\65\2\2\u019c\u01b4\7\64\2\2\u019d\u01b4\7&\2\2\u019e"+
		"\u01b4\7 \2\2\u019f\u01b4\7\23\2\2\u01a0\u01b4\7*\2\2\u01a1\u01b4\7\n"+
		"\2\2\u01a2\u01b4\7#\2\2\u01a3\u01b4\7\30\2\2\u01a4\u01b4\7\67\2\2\u01a5"+
		"\u01b4\7\b\2\2\u01a6\u01b4\7\t\2\2\u01a7\u01b4\79\2\2\u01a8\u01b4\7\61"+
		"\2\2\u01a9\u01b4\7\62\2\2\u01aa\u01b4\7)\2\2\u01ab\u01b4\7\6\2\2\u01ac"+
		"\u01b4\7\34\2\2\u01ad\u01b4\7\32\2\2\u01ae\u01b4\7\f\2\2\u01af\u01b0\7"+
		"\37\2\2\u01b0\u01b4\7\16\2\2\u01b1\u01b2\7\4\2\2\u01b2\u01b4\7\27\2\2"+
		"\u01b3\u0186\3\2\2\2\u01b3\u018b\3\2\2\2\u01b3\u018c\3\2\2\2\u01b3\u018d"+
		"\3\2\2\2\u01b3\u018e\3\2\2\2\u01b3\u018f\3\2\2\2\u01b3\u0190\3\2\2\2\u01b3"+
		"\u0191\3\2\2\2\u01b3\u0192\3\2\2\2\u01b3\u0193\3\2\2\2\u01b3\u0194\3\2"+
		"\2\2\u01b3\u0195\3\2\2\2\u01b3\u0196\3\2\2\2\u01b3\u0197\3\2\2\2\u01b3"+
		"\u0198\3\2\2\2\u01b3\u0199\3\2\2\2\u01b3\u019a\3\2\2\2\u01b3\u019b\3\2"+
		"\2\2\u01b3\u019c\3\2\2\2\u01b3\u019d\3\2\2\2\u01b3\u019e\3\2\2\2\u01b3"+
		"\u019f\3\2\2\2\u01b3\u01a0\3\2\2\2\u01b3\u01a1\3\2\2\2\u01b3\u01a2\3\2"+
		"\2\2\u01b3\u01a3\3\2\2\2\u01b3\u01a4\3\2\2\2\u01b3\u01a5\3\2\2\2\u01b3"+
		"\u01a6\3\2\2\2\u01b3\u01a7\3\2\2\2\u01b3\u01a8\3\2\2\2\u01b3\u01a9\3\2"+
		"\2\2\u01b3\u01aa\3\2\2\2\u01b3\u01ab\3\2\2\2\u01b3\u01ac\3\2\2\2\u01b3"+
		"\u01ad\3\2\2\2\u01b3\u01ae\3\2\2\2\u01b3\u01af\3\2\2\2\u01b3\u01b1\3\2"+
		"\2\2\u01b4;\3\2\2\2\u01b5\u01b6\t\16\2\2\u01b6=\3\2\2\2\u01b7\u01b8\t"+
		"\17\2\2\u01b8?\3\2\2\2\u01b9\u01ba\7T\2\2\u01ba\u01bb\5B\"\2\u01bbA\3"+
		"\2\2\2\u01bc\u01bd\7\7\2\2\u01bd\u01be\5B\"\2\u01be\u01bf\7\63\2\2\u01bf"+
		"\u01c6\3\2\2\2\u01c0\u01c1\7\37\2\2\u01c1\u01c2\5B\"\2\u01c2\u01c3\7\16"+
		"\2\2\u01c3\u01c6\3\2\2\2\u01c4\u01c6\5J&\2\u01c5\u01bc\3\2\2\2\u01c5\u01c0"+
		"\3\2\2\2\u01c5\u01c4\3\2\2\2\u01c6\u01c7\3\2\2\2\u01c7\u01c5\3\2\2\2\u01c7"+
		"\u01c8\3\2\2\2\u01c8C\3\2\2\2\u01c9\u01ca\n\20\2\2\u01caE\3\2\2\2\u01cb"+
		"\u01cc\n\21\2\2\u01ccG\3\2\2\2\u01cd\u01ce\n\22\2\2\u01ceI\3\2\2\2\u01cf"+
		"\u01d0\n\23\2\2\u01d0K\3\2\2\2\u01d1\u01d2\n\24\2\2\u01d2M\3\2\2\2\u01d3"+
		"\u01d4\n\25\2\2\u01d4O\3\2\2\2\u01d5\u01d6\n\26\2\2\u01d6Q\3\2\2\2\u01d7"+
		"\u01d8\n\27\2\2\u01d8S\3\2\2\2\u01d9\u01da\n\30\2\2\u01daU\3\2\2\2\u01db"+
		"\u01dc\n\31\2\2\u01dcW\3\2\2\2\u01dd\u01de\13\2\2\2\u01deY\3\2\2\2\u01df"+
		"\u01e1\5@!\2\u01e0\u01df\3\2\2\2\u01e0\u01e1\3\2\2\2\u01e1\u01e3\3\2\2"+
		"\2\u01e2\u01e4\5\\/\2\u01e3\u01e2\3\2\2\2\u01e3\u01e4\3\2\2\2\u01e4\u01e5"+
		"\3\2\2\2\u01e5\u01e6\5p9\2\u01e6\u01e8\5^\60\2\u01e7\u01e9\5h\65\2\u01e8"+
		"\u01e7\3\2\2\2\u01e8\u01e9\3\2\2\2\u01e9\u01ea\3\2\2\2\u01ea\u01eb\5f"+
		"\64\2\u01eb[\3\2\2\2\u01ec\u01ee\5\64\33\2\u01ed\u01ec\3\2\2\2\u01ee\u01f1"+
		"\3\2\2\2\u01ef\u01ed\3\2\2\2\u01ef\u01f0\3\2\2\2\u01f0\u01f2\3\2\2\2\u01f1"+
		"\u01ef\3\2\2\2\u01f2\u01f3\5\u0092J\2\u01f3\u01f7\3\2\2\2\u01f4\u01f6"+
		"\5\66\34\2\u01f5\u01f4\3\2\2\2\u01f6\u01f9\3\2\2\2\u01f7\u01f5\3\2\2\2"+
		"\u01f7\u01f8\3\2\2\2\u01f8]\3\2\2\2\u01f9\u01f7\3\2\2\2\u01fa\u01fc\7"+
		"\37\2\2\u01fb\u01fd\5`\61\2\u01fc\u01fb\3\2\2\2\u01fc\u01fd\3\2\2\2\u01fd"+
		"\u01fe\3\2\2\2\u01fe\u0202\7\16\2\2\u01ff\u0201\7J\2\2\u0200\u01ff\3\2"+
		"\2\2\u0201\u0204\3\2\2\2\u0202\u0200\3\2\2\2\u0202\u0203\3\2\2\2\u0203"+
		"\u0206\3\2\2\2\u0204\u0202\3\2\2\2\u0205\u0207\5r:\2\u0206\u0205\3\2\2"+
		"\2\u0206\u0207\3\2\2\2\u0207_\3\2\2\2\u0208\u020d\5b\62\2\u0209\u020a"+
		"\7\34\2\2\u020a\u020c\5b\62\2\u020b\u0209\3\2\2\2\u020c\u020f\3\2\2\2"+
		"\u020d\u020b\3\2\2\2\u020d\u020e\3\2\2\2\u020e\u0212\3\2\2\2\u020f\u020d"+
		"\3\2\2\2\u0210\u0211\7\34\2\2\u0211\u0213\7$\2\2\u0212\u0210\3\2\2\2\u0212"+
		"\u0213\3\2\2\2\u0213\u0216\3\2\2\2\u0214\u0216\7F\2\2\u0215\u0208\3\2"+
		"\2\2\u0215\u0214\3\2\2\2\u0216a\3\2\2\2\u0217\u0218\5\u0096L\2\u0218\u0219"+
		"\5d\63\2\u0219c\3\2\2\2\u021a\u021c\5\u00a4S\2\u021b\u021a\3\2\2\2\u021b"+
		"\u021c\3\2\2\2\u021c\u0222\3\2\2\2\u021d\u021e\7\37\2\2\u021e\u021f\5"+
		"d\63\2\u021f\u0220\7\16\2\2\u0220\u0223\3\2\2\2\u0221\u0223\5\u0098M\2"+
		"\u0222\u021d\3\2\2\2\u0222\u0221\3\2\2\2\u0223\u0225\3\2\2\2\u0224\u0226"+
		"\5x=\2\u0225\u0224\3\2\2\2\u0225\u0226\3\2\2\2\u0226e\3\2\2\2\u0227\u0228"+
		"\7W\2\2\u0228\u0229\b\64\1\2\u0229g\3\2\2\2\u022a\u022b\7\36\2\2\u022b"+
		"\u0230\5j\66\2\u022c\u022d\7\34\2\2\u022d\u022f\5j\66\2\u022e\u022c\3"+
		"\2\2\2\u022f\u0232\3\2\2\2\u0230\u022e\3\2\2\2\u0230\u0231\3\2\2\2\u0231"+
		"i\3\2\2\2\u0232\u0230\3\2\2\2\u0233\u0234\5l\67\2\u0234\u0235\5n8\2\u0235"+
		"k\3\2\2\2\u0236\u0238\7\21\2\2\u0237\u0236\3\2\2\2\u0237\u0238\3\2\2\2"+
		"\u0238\u0239\3\2\2\2\u0239\u023a\5\u00a0Q\2\u023am\3\2\2\2\u023b\u023d"+
		"\7\37\2\2\u023c\u023e\5\6\4\2\u023d\u023c\3\2\2\2\u023d\u023e\3\2\2\2"+
		"\u023e\u023f\3\2\2\2\u023f\u0240\7\16\2\2\u0240o\3\2\2\2\u0241\u0242\7"+
		"\37\2\2\u0242\u0243\5p9\2\u0243\u0244\7\16\2\2\u0244\u0249\3\2\2\2\u0245"+
		"\u0249\5\u00a0Q\2\u0246\u0247\7S\2\2\u0247\u0249\5:\36\2\u0248\u0241\3"+
		"\2\2\2\u0248\u0245\3\2\2\2\u0248\u0246\3\2\2\2\u0249q\3\2\2\2\u024a\u024b"+
		"\7N\2\2\u024b\u024c\7\37\2\2\u024c\u024d\5t;\2\u024d\u024e\7\16\2\2\u024e"+
		"s\3\2\2\2\u024f\u0251\5D#\2\u0250\u024f\3\2\2\2\u0251\u0254\3\2\2\2\u0252"+
		"\u0250\3\2\2\2\u0252\u0253\3\2\2\2\u0253\u0260\3\2\2\2\u0254\u0252\3\2"+
		"\2\2\u0255\u0256\7\37\2\2\u0256\u0257\5t;\2\u0257\u025b\7\16\2\2\u0258"+
		"\u025a\5D#\2\u0259\u0258\3\2\2\2\u025a\u025d\3\2\2\2\u025b\u0259\3\2\2"+
		"\2\u025b\u025c\3\2\2\2\u025c\u025f\3\2\2\2\u025d\u025b\3\2\2\2\u025e\u0255"+
		"\3\2\2\2\u025f\u0262\3\2\2\2\u0260\u025e\3\2\2\2\u0260\u0261\3\2\2\2\u0261"+
		"u\3\2\2\2\u0262\u0260\3\2\2\2\u0263\u0265\5\u00a4S\2\u0264\u0263\3\2\2"+
		"\2\u0264\u0265\3\2\2\2\u0265\u0266\3\2\2\2\u0266\u0268\5\u00a0Q\2\u0267"+
		"\u0269\5x=\2\u0268\u0267\3\2\2\2\u0268\u0269\3\2\2\2\u0269\u0271\3\2\2"+
		"\2\u026a\u026c\7\37\2\2\u026b\u026d\5\6\4\2\u026c\u026b\3\2\2\2\u026c"+
		"\u026d\3\2\2\2\u026d\u026e\3\2\2\2\u026e\u0272\7\16\2\2\u026f\u0270\7"+
		"\22\2\2\u0270\u0272\5z>\2\u0271\u026a\3\2\2\2\u0271\u026f\3\2\2\2\u0271"+
		"\u0272\3\2\2\2\u0272w\3\2\2\2\u0273\u0274\7\4\2\2\u0274\u0275\5~@\2\u0275"+
		"\u0276\7\27\2\2\u0276\u0279\3\2\2\2\u0277\u0279\5\u009aN\2\u0278\u0273"+
		"\3\2\2\2\u0278\u0277\3\2\2\2\u0279y\3\2\2\2\u027a\u027c\5T+\2\u027b\u027a"+
		"\3\2\2\2\u027c\u027f\3\2\2\2\u027d\u027b\3\2\2\2\u027d\u027e\3\2\2\2\u027e"+
		"\u0296\3\2\2\2\u027f\u027d\3\2\2\2\u0280\u0281\7W\2\2\u0281\u0282\5|?"+
		"\2\u0282\u0283\7X\2\2\u0283\u028d\3\2\2\2\u0284\u0285\7\37\2\2\u0285\u0286"+
		"\5|?\2\u0286\u0287\7\16\2\2\u0287\u028d\3\2\2\2\u0288\u0289\7\4\2\2\u0289"+
		"\u028a\5|?\2\u028a\u028b\7\27\2\2\u028b\u028d\3\2\2\2\u028c\u0280\3\2"+
		"\2\2\u028c\u0284\3\2\2\2\u028c\u0288\3\2\2\2\u028d\u0291\3\2\2\2\u028e"+
		"\u0290\5T+\2\u028f\u028e\3\2\2\2\u0290\u0293\3\2\2\2\u0291\u028f\3\2\2"+
		"\2\u0291\u0292\3\2\2\2\u0292\u0295\3\2\2\2\u0293\u0291\3\2\2\2\u0294\u028c"+
		"\3\2\2\2\u0295\u0298\3\2\2\2\u0296\u0294\3\2\2\2\u0296\u0297\3\2\2\2\u0297"+
		"{\3\2\2\2\u0298\u0296\3\2\2\2\u0299\u029b\5V,\2\u029a\u0299\3\2\2\2\u029b"+
		"\u029e\3\2\2\2\u029c\u029a\3\2\2\2\u029c\u029d\3\2\2\2\u029d\u02b5\3\2"+
		"\2\2\u029e\u029c\3\2\2\2\u029f\u02a0\7W\2\2\u02a0\u02a1\5|?\2\u02a1\u02a2"+
		"\7X\2\2\u02a2\u02ac\3\2\2\2\u02a3\u02a4\7\37\2\2\u02a4\u02a5\5|?\2\u02a5"+
		"\u02a6\7\16\2\2\u02a6\u02ac\3\2\2\2\u02a7\u02a8\7\4\2\2\u02a8\u02a9\5"+
		"|?\2\u02a9\u02aa\7\27\2\2\u02aa\u02ac\3\2\2\2\u02ab\u029f\3\2\2\2\u02ab"+
		"\u02a3\3\2\2\2\u02ab\u02a7\3\2\2\2\u02ac\u02b0\3\2\2\2\u02ad\u02af\5V"+
		",\2\u02ae\u02ad\3\2\2\2\u02af\u02b2\3\2\2\2\u02b0\u02ae\3\2\2\2\u02b0"+
		"\u02b1\3\2\2\2\u02b1\u02b4\3\2\2\2\u02b2\u02b0\3\2\2\2\u02b3\u02ab\3\2"+
		"\2\2\u02b4\u02b7\3\2\2\2\u02b5\u02b3\3\2\2\2\u02b5\u02b6\3\2\2\2\u02b6"+
		"}\3\2\2\2\u02b7\u02b5\3\2\2\2\u02b8\u02ba\5N(\2\u02b9\u02b8\3\2\2\2\u02ba"+
		"\u02bd\3\2\2\2\u02bb\u02b9\3\2\2\2\u02bb\u02bc\3\2\2\2\u02bc\u02c9\3\2"+
		"\2\2\u02bd\u02bb\3\2\2\2\u02be\u02bf\7\4\2\2\u02bf\u02c0\5~@\2\u02c0\u02c4"+
		"\7\27\2\2\u02c1\u02c3\5N(\2\u02c2\u02c1\3\2\2\2\u02c3\u02c6\3\2\2\2\u02c4"+
		"\u02c2\3\2\2\2\u02c4\u02c5\3\2\2\2\u02c5\u02c8\3\2\2\2\u02c6\u02c4\3\2"+
		"\2\2\u02c7\u02be\3\2\2\2\u02c8\u02cb\3\2\2\2\u02c9\u02c7\3\2\2\2\u02c9"+
		"\u02ca\3\2\2\2\u02ca\177\3\2\2\2\u02cb\u02c9\3\2\2\2\u02cc\u02ce\7E\2"+
		"\2\u02cd\u02cc\3\2\2\2\u02cd\u02ce\3\2\2\2\u02ce\u02d0\3\2\2\2\u02cf\u02d1"+
		"\5@!\2\u02d0\u02cf\3\2\2\2\u02d0\u02d1\3\2\2\2\u02d1\u02d2\3\2\2\2\u02d2"+
		"\u02d3\5\u0082B\2\u02d3\u0081\3\2\2\2\u02d4\u02d6\5\u008aF\2\u02d5\u02d7"+
		"\5\u0084C\2\u02d6\u02d5\3\2\2\2\u02d6\u02d7\3\2\2\2\u02d7\u02dc\3\2\2"+
		"\2\u02d8\u02d9\5\u0092J\2\u02d9\u02da\5\u0084C\2\u02da\u02dc\3\2\2\2\u02db"+
		"\u02d4\3\2\2\2\u02db\u02d8\3\2\2\2\u02dc\u0083\3\2\2\2\u02dd\u02e2\5v"+
		"<\2\u02de\u02df\7\34\2\2\u02df\u02e1\5v<\2\u02e0\u02de\3\2\2\2\u02e1\u02e4"+
		"\3\2\2\2\u02e2\u02e0\3\2\2\2\u02e2\u02e3\3\2\2\2\u02e3\u02e5\3\2\2\2\u02e4"+
		"\u02e2\3\2\2\2\u02e5\u02e6\7\60\2\2\u02e6\u0085\3\2\2\2\u02e7\u02ed\5"+
		"\b\5\2\u02e8\u02e9\7W\2\2\u02e9\u02ea\5\u0088E\2\u02ea\u02eb\7X\2\2\u02eb"+
		"\u02ed\3\2\2\2\u02ec\u02e7\3\2\2\2\u02ec\u02e8\3\2\2\2\u02ed\u0087\3\2"+
		"\2\2\u02ee\u02f3\5\u0086D\2\u02ef\u02f0\7\34\2\2\u02f0\u02f2\5\u0086D"+
		"\2\u02f1\u02ef\3\2\2\2\u02f2\u02f5\3\2\2\2\u02f3\u02f1\3\2\2\2\u02f3\u02f4"+
		"\3\2\2\2\u02f4\u0089\3\2\2\2\u02f5\u02f3\3\2\2\2\u02f6\u02f8\7U\2\2\u02f7"+
		"\u02f9\5\u008cG\2\u02f8\u02f7\3\2\2\2\u02f8\u02f9\3\2\2\2\u02f9\u02fb"+
		"\3\2\2\2\u02fa\u02fc\5\u008eH\2\u02fb\u02fa\3\2\2\2\u02fb\u02fc\3\2\2"+
		"\2\u02fc\u02fd\3\2\2\2\u02fd\u02fe\7W\2\2\u02fe\u02ff\bF\1\2\u02ff\u008b"+
		"\3\2\2\2\u0300\u0301\5\u00a0Q\2\u0301\u008d\3\2\2\2\u0302\u0303\7\36\2"+
		"\2\u0303\u0308\5\u0090I\2\u0304\u0305\7\34\2\2\u0305\u0307\5\u0090I\2"+
		"\u0306\u0304\3\2\2\2\u0307\u030a\3\2\2\2\u0308\u0306\3\2\2\2\u0308\u0309"+
		"\3\2\2\2\u0309\u008f\3\2\2\2\u030a\u0308\3\2\2\2\u030b\u030d\7K\2\2\u030c"+
		"\u030b\3\2\2\2\u030c\u030d\3\2\2\2\u030d\u030f\3\2\2\2\u030e\u0310\58"+
		"\35\2\u030f\u030e\3\2\2\2\u030f\u0310\3\2\2\2\u0310\u0311\3\2\2\2\u0311"+
		"\u0312\5\u00a0Q\2\u0312\u0091\3\2\2\2\u0313\u0315\7J\2\2\u0314\u0313\3"+
		"\2\2\2\u0315\u0318\3\2\2\2\u0316\u0314\3\2\2\2\u0316\u0317\3\2\2\2\u0317"+
		"\u031a\3\2\2\2\u0318\u0316\3\2\2\2\u0319\u031b\t\32\2\2\u031a\u0319\3"+
		"\2\2\2\u031a\u031b\3\2\2\2\u031b\u031c\3\2\2\2\u031c\u0321\5\u0094K\2"+
		"\u031d\u031e\7\7\2\2\u031e\u031f\5B\"\2\u031f\u0320\7\63\2\2\u0320\u0322"+
		"\3\2\2\2\u0321\u031d\3\2\2\2\u0321\u0322\3\2\2\2\u0322\u032d\3\2\2\2\u0323"+
		"\u0324\7\21\2\2\u0324\u0329\5\u0094K\2\u0325\u0326\7\7\2\2\u0326\u0327"+
		"\5B\"\2\u0327\u0328\7\63\2\2\u0328\u032a\3\2\2\2\u0329\u0325\3\2\2\2\u0329"+
		"\u032a\3\2\2\2\u032a\u032c\3\2\2\2\u032b\u0323\3\2\2\2\u032c\u032f\3\2"+
		"\2\2\u032d\u032b\3\2\2\2\u032d\u032e\3\2\2\2\u032e\u0333\3\2\2\2\u032f"+
		"\u032d\3\2\2\2\u0330\u0333\7G\2\2\u0331\u0333\7H\2\2\u0332\u0316\3\2\2"+
		"\2\u0332\u0330\3\2\2\2\u0332\u0331\3\2\2\2\u0333\u0093\3\2\2\2\u0334\u033a"+
		"\7V\2\2\u0335\u033a\7F\2\2\u0336\u033a\7I\2\2\u0337\u0338\7I\2\2\u0338"+
		"\u033a\7I\2\2\u0339\u0334\3\2\2\2\u0339\u0335\3\2\2\2\u0339\u0336\3\2"+
		"\2\2\u0339\u0337\3\2\2\2\u033a\u0095\3\2\2\2\u033b\u033d\t\33\2\2\u033c"+
		"\u033b\3\2\2\2\u033c\u033d\3\2\2\2\u033d\u033e\3\2\2\2\u033e\u033f\5\u0092"+
		"J\2\u033f\u0097\3\2\2\2\u0340\u0343\5\u00a0Q\2\u0341\u0343\58\35\2\u0342"+
		"\u0340\3\2\2\2\u0342\u0341\3\2\2\2\u0343\u0099\3\2\2\2\u0344\u0345\7\37"+
		"\2\2\u0345\u0346\7F\2\2\u0346\u0354\7\16\2\2\u0347\u0350\7\37\2\2\u0348"+
		"\u034d\5\u009cO\2\u0349\u034a\7\34\2\2\u034a\u034c\5\u009cO\2\u034b\u0349"+
		"\3\2\2\2\u034c\u034f\3\2\2\2\u034d\u034b\3\2\2\2\u034d\u034e\3\2\2\2\u034e"+
		"\u0351\3\2\2\2\u034f\u034d\3\2\2\2\u0350\u0348\3\2\2\2\u0350\u0351\3\2"+
		"\2\2\u0351\u0352\3\2\2\2\u0352\u0354\7\16\2\2\u0353\u0344\3\2\2\2\u0353"+
		"\u0347\3\2\2\2\u0354\u009b\3\2\2\2\u0355\u0356\5\u0096L\2\u0356\u0357"+
		"\5\u009eP\2\u0357\u009d\3\2\2\2\u0358\u035a\5\u00a4S\2\u0359\u0358\3\2"+
		"\2\2\u0359\u035a\3\2\2\2\u035a\u0362\3\2\2\2\u035b\u035c\7\37\2\2\u035c"+
		"\u035d\5\u009eP\2\u035d\u035e\7\16\2\2\u035e\u0363\3\2\2\2\u035f\u0361"+
		"\5\u0098M\2\u0360\u035f\3\2\2\2\u0360\u0361\3\2\2\2\u0361\u0363\3\2\2"+
		"\2\u0362\u035b\3\2\2\2\u0362\u0360\3\2\2\2\u0363\u0365\3\2\2\2\u0364\u0366"+
		"\5x=\2\u0365\u0364\3\2\2\2\u0365\u0366\3\2\2\2\u0366\u009f\3\2\2\2\u0367"+
		"\u036c\7V\2\2\u0368\u0369\7\21\2\2\u0369\u036b\7V\2\2\u036a\u0368\3\2"+
		"\2\2\u036b\u036e\3\2\2\2\u036c\u036a\3\2\2\2\u036c\u036d\3\2\2\2\u036d"+
		"\u00a1\3\2\2\2\u036e\u036c\3\2\2\2\u036f\u0370\t\34\2\2\u0370\u00a3\3"+
		"\2\2\2\u0371\u0373\5\66\34\2\u0372\u0371\3\2\2\2\u0373\u0374\3\2\2\2\u0374"+
		"\u0372\3\2\2\2\u0374\u0375\3\2\2\2\u0375\u00a5\3\2\2\2f\u00aa\u00ac\u00b7"+
		"\u00bf\u00c8\u00cf\u00d7\u00df\u00e7\u00ef\u00f8\u0101\u0109\u0111\u0119"+
		"\u0121\u0128\u012d\u0133\u013b\u0142\u0148\u014c\u0152\u015b\u015e\u016c"+
		"\u0170\u0178\u0189\u01b3\u01c5\u01c7\u01e0\u01e3\u01e8\u01ef\u01f7\u01fc"+
		"\u0202\u0206\u020d\u0212\u0215\u021b\u0222\u0225\u0230\u0237\u023d\u0248"+
		"\u0252\u025b\u0260\u0264\u0268\u026c\u0271\u0278\u027d\u028c\u0291\u0296"+
		"\u029c\u02ab\u02b0\u02b5\u02bb\u02c4\u02c9\u02cd\u02d0\u02d6\u02db\u02e2"+
		"\u02ec\u02f3\u02f8\u02fb\u0308\u030c\u030f\u0316\u031a\u0321\u0329\u032d"+
		"\u0332\u0339\u033c\u0342\u034d\u0350\u0353\u0359\u0360\u0362\u0365\u036c"+
		"\u0374";
	public static final ATN _ATN =
		ATNSimulator.deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
	}
}