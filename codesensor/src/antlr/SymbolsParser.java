// Generated from ./Symbols.g4 by ANTLR 4.0

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
public class SymbolsParser extends Parser {
	protected static final DFA[] _decisionToDFA;
	protected static final PredictionContextCache _sharedContextCache =
		new PredictionContextCache();
	public static final int
		T__57=1, T__56=2, T__55=3, T__54=4, T__53=5, T__52=6, T__51=7, T__50=8, 
		T__49=9, T__48=10, T__47=11, T__46=12, T__45=13, T__44=14, T__43=15, T__42=16, 
		T__41=17, T__40=18, T__39=19, T__38=20, T__37=21, T__36=22, T__35=23, 
		T__34=24, T__33=25, T__32=26, T__31=27, T__30=28, T__29=29, T__28=30, 
		T__27=31, T__26=32, T__25=33, T__24=34, T__23=35, T__22=36, T__21=37, 
		T__20=38, T__19=39, T__18=40, T__17=41, T__16=42, T__15=43, T__14=44, 
		T__13=45, T__12=46, T__11=47, T__10=48, T__9=49, T__8=50, T__7=51, T__6=52, 
		T__5=53, T__4=54, T__3=55, T__2=56, T__1=57, T__0=58, IF=59, ELSE=60, 
		FOR=61, WHILE=62, BREAK=63, CASE=64, CONTINUE=65, SWITCH=66, GOTO=67, 
		RETURN=68, TYPEDEF=69, VOID=70, UNSIGNED=71, SIGNED=72, LONG=73, CV_QUALIFIER=74, 
		VIRTUAL=75, TRY=76, CATCH=77, THROW=78, USING=79, NAMESPACE=80, AUTO=81, 
		REGISTER=82, OPERATOR=83, TEMPLATE=84, ALPHA_NUMERIC=85, OPENING_CURLY=86, 
		CLOSING_CURLY=87, PRE_IF=88, PRE_ELSE=89, PRE_ENDIF=90, HEX_LITERAL=91, 
		DECIMAL_LITERAL=92, OCTAL_LITERAL=93, FLOATING_POINT_LITERAL=94, CHAR=95, 
		STRING=96, COMMENT=97, WHITESPACE=98, CPPCOMMENT=99, OTHER=100;
	public static final String[] tokenNames = {
		"<INVALID>", "'&'", "'['", "'*'", "'<'", "'--'", "'!='", "'<='", "'<<'", 
		"'%'", "'->'", "'*='", "'union'", "')'", "'inline'", "'explicit'", "'::'", 
		"'='", "'|='", "'new'", "'class'", "'|'", "'!'", "'enum'", "'<<='", "']'", 
		"'-='", "'->*'", "'public'", "','", "'-'", "'('", "':'", "'&='", "'private'", 
		"'?'", "'>>='", "'+='", "'^='", "'friend'", "'++'", "'static'", "'struct'", 
		"'>>'", "'^'", "'delete'", "'.'", "'+'", "'protected'", "';'", "'&&'", 
		"'||'", "'>'", "'%='", "'/='", "'=='", "'/'", "'~'", "'>='", "'if'", "'else'", 
		"'for'", "'while'", "'break'", "'case'", "'continue'", "'switch'", "'goto'", 
		"'return'", "'typedef'", "'void'", "'unsigned'", "'signed'", "'long'", 
		"CV_QUALIFIER", "'virtual'", "'try'", "'catch'", "'throw'", "'using'", 
		"'namespace'", "'auto'", "'register'", "'operator'", "'template'", "ALPHA_NUMERIC", 
		"'{'", "'}'", "PRE_IF", "PRE_ELSE", "PRE_ENDIF", "HEX_LITERAL", "DECIMAL_LITERAL", 
		"OCTAL_LITERAL", "FLOATING_POINT_LITERAL", "CHAR", "STRING", "COMMENT", 
		"WHITESPACE", "CPPCOMMENT", "OTHER"
	};
	public static final int
		RULE_coarse_content = 0, RULE_coarse_elem = 1, RULE_unary_operator = 2, 
		RULE_relational_operator = 3, RULE_constant = 4, RULE_function_decl_specifiers = 5, 
		RULE_class_key = 6, RULE_ptr_operator = 7, RULE_access_specifier = 8, 
		RULE_operator_function_id = 9, RULE_operator = 10, RULE_assignment_operator = 11, 
		RULE_equality_operator = 12, RULE_template_decl_start = 13, RULE_template_param_list = 14, 
		RULE_no_brackets = 15, RULE_no_brackets_curlies_or_squares = 16, RULE_no_brackets_or_semicolon = 17, 
		RULE_no_angle_brackets_or_brackets = 18, RULE_no_curlies = 19, RULE_no_squares = 20, 
		RULE_no_squares_or_semicolon = 21, RULE_no_comma_or_semicolon = 22, RULE_assign_water = 23, 
		RULE_assign_water_l2 = 24, RULE_water = 25, RULE_expr = 26, RULE_assign_expr = 27, 
		RULE_conditional_expression = 28, RULE_or_expression = 29, RULE_and_expression = 30, 
		RULE_inclusive_or_expression = 31, RULE_exclusive_or_expression = 32, 
		RULE_bit_and_expression = 33, RULE_equality_expression = 34, RULE_relational_expression = 35, 
		RULE_shift_expression = 36, RULE_additive_expression = 37, RULE_multiplicative_expression = 38, 
		RULE_cast_expression = 39, RULE_unary_expression = 40, RULE_postfix_expression = 41, 
		RULE_field = 42, RULE_function_call_tail = 43, RULE_call_template_list = 44, 
		RULE_function_argument_list = 45, RULE_function_argument = 46, RULE_postfix = 47, 
		RULE_primary_expression = 48, RULE_simple_decl = 49, RULE_var_decl = 50, 
		RULE_init_declarator_list = 51, RULE_init_declarator = 52, RULE_assign_expr_w_ = 53, 
		RULE_assign_expr_w__l2 = 54, RULE_constant_expr_w_ = 55, RULE_initializer = 56, 
		RULE_initializer_list = 57, RULE_class_def = 58, RULE_class_name = 59, 
		RULE_base_classes = 60, RULE_base_class = 61, RULE_type_name = 62, RULE_type_suffix = 63, 
		RULE_base_type = 64, RULE_param_decl_specifiers = 65, RULE_parameter_name = 66, 
		RULE_param_type_list = 67, RULE_param_type = 68, RULE_param_type_id = 69, 
		RULE_identifier = 70, RULE_number = 71, RULE_ptrs = 72;
	public static final String[] ruleNames = {
		"coarse_content", "coarse_elem", "unary_operator", "relational_operator", 
		"constant", "function_decl_specifiers", "class_key", "ptr_operator", "access_specifier", 
		"operator_function_id", "operator", "assignment_operator", "equality_operator", 
		"template_decl_start", "template_param_list", "no_brackets", "no_brackets_curlies_or_squares", 
		"no_brackets_or_semicolon", "no_angle_brackets_or_brackets", "no_curlies", 
		"no_squares", "no_squares_or_semicolon", "no_comma_or_semicolon", "assign_water", 
		"assign_water_l2", "water", "expr", "assign_expr", "conditional_expression", 
		"or_expression", "and_expression", "inclusive_or_expression", "exclusive_or_expression", 
		"bit_and_expression", "equality_expression", "relational_expression", 
		"shift_expression", "additive_expression", "multiplicative_expression", 
		"cast_expression", "unary_expression", "postfix_expression", "field", 
		"function_call_tail", "call_template_list", "function_argument_list", 
		"function_argument", "postfix", "primary_expression", "simple_decl", "var_decl", 
		"init_declarator_list", "init_declarator", "assign_expr_w_", "assign_expr_w__l2", 
		"constant_expr_w_", "initializer", "initializer_list", "class_def", "class_name", 
		"base_classes", "base_class", "type_name", "type_suffix", "base_type", 
		"param_decl_specifiers", "parameter_name", "param_type_list", "param_type", 
		"param_type_id", "identifier", "number", "ptrs"
	};

	@Override
	public String getGrammarFileName() { return "Symbols.g4"; }

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


	public SymbolsParser(TokenStream input) {
		super(input);
		_interp = new ParserATNSimulator(this,_ATN,_decisionToDFA,_sharedContextCache);
	}
	public static class Coarse_contentContext extends ParserRuleContext {
		public Coarse_elemContext coarse_elem(int i) {
			return getRuleContext(Coarse_elemContext.class,i);
		}
		public TerminalNode EOF() { return getToken(SymbolsParser.EOF, 0); }
		public List<Coarse_elemContext> coarse_elem() {
			return getRuleContexts(Coarse_elemContext.class);
		}
		public Coarse_contentContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_coarse_content; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof SymbolsListener ) ((SymbolsListener)listener).enterCoarse_content(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SymbolsListener ) ((SymbolsListener)listener).exitCoarse_content(this);
		}
	}

	public final Coarse_contentContext coarse_content() throws RecognitionException {
		Coarse_contentContext _localctx = new Coarse_contentContext(_ctx, getState());
		enterRule(_localctx, 0, RULE_coarse_content);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(149);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << 1) | (1L << 2) | (1L << 3) | (1L << 4) | (1L << 5) | (1L << 6) | (1L << 7) | (1L << 8) | (1L << 9) | (1L << 10) | (1L << 11) | (1L << 12) | (1L << 13) | (1L << 14) | (1L << 15) | (1L << 16) | (1L << 17) | (1L << 18) | (1L << 19) | (1L << 20) | (1L << 21) | (1L << 22) | (1L << 23) | (1L << 24) | (1L << 25) | (1L << 26) | (1L << 27) | (1L << 28) | (1L << 29) | (1L << 30) | (1L << 31) | (1L << 32) | (1L << 33) | (1L << 34) | (1L << 35) | (1L << 36) | (1L << 37) | (1L << 38) | (1L << 39) | (1L << 40) | (1L << 41) | (1L << 42) | (1L << 43) | (1L << 44) | (1L << 45) | (1L << 46) | (1L << 47) | (1L << 48) | (1L << 49) | (1L << 50) | (1L << 51) | (1L << 52) | (1L << 53) | (1L << 54) | (1L << 55) | (1L << 56) | (1L << 57) | (1L << 58) | (1L << IF) | (1L << ELSE) | (1L << FOR) | (1L << WHILE) | (1L << BREAK))) != 0) || ((((_la - 64)) & ~0x3f) == 0 && ((1L << (_la - 64)) & ((1L << (CASE - 64)) | (1L << (CONTINUE - 64)) | (1L << (SWITCH - 64)) | (1L << (GOTO - 64)) | (1L << (RETURN - 64)) | (1L << (TYPEDEF - 64)) | (1L << (VOID - 64)) | (1L << (UNSIGNED - 64)) | (1L << (SIGNED - 64)) | (1L << (LONG - 64)) | (1L << (CV_QUALIFIER - 64)) | (1L << (VIRTUAL - 64)) | (1L << (TRY - 64)) | (1L << (CATCH - 64)) | (1L << (THROW - 64)) | (1L << (USING - 64)) | (1L << (NAMESPACE - 64)) | (1L << (AUTO - 64)) | (1L << (REGISTER - 64)) | (1L << (OPERATOR - 64)) | (1L << (TEMPLATE - 64)) | (1L << (ALPHA_NUMERIC - 64)) | (1L << (OPENING_CURLY - 64)) | (1L << (CLOSING_CURLY - 64)) | (1L << (PRE_IF - 64)) | (1L << (PRE_ELSE - 64)) | (1L << (PRE_ENDIF - 64)) | (1L << (HEX_LITERAL - 64)) | (1L << (DECIMAL_LITERAL - 64)) | (1L << (OCTAL_LITERAL - 64)) | (1L << (FLOATING_POINT_LITERAL - 64)) | (1L << (CHAR - 64)) | (1L << (STRING - 64)) | (1L << (COMMENT - 64)) | (1L << (WHITESPACE - 64)) | (1L << (CPPCOMMENT - 64)) | (1L << (OTHER - 64)) | (1L << (5 - 64)) | (1L << (12 - 64)) | (1L << (20 - 64)) | (1L << (22 - 64)) | (1L << (23 - 64)) | (1L << (30 - 64)) | (1L << (31 - 64)) | (1L << (40 - 64)) | (1L << (42 - 64)) | (1L << (47 - 64)) | (1L << (57 - 64)) | (1L << (TYPEDEF - 64)) | (1L << (VOID - 64)) | (1L << (UNSIGNED - 64)) | (1L << (SIGNED - 64)) | (1L << (LONG - 64)) | (1L << (CV_QUALIFIER - 64)) | (1L << (TEMPLATE - 64)) | (1L << (ALPHA_NUMERIC - 64)) | (1L << (HEX_LITERAL - 64)) | (1L << (DECIMAL_LITERAL - 64)) | (1L << (OCTAL_LITERAL - 64)) | (1L << (FLOATING_POINT_LITERAL - 64)) | (1L << (CHAR - 64)) | (1L << (STRING - 64)))) != 0)) {
				{
				{
				setState(146); coarse_elem();
				}
				}
				setState(151);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(152); match(EOF);
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

	public static class Coarse_elemContext extends ParserRuleContext {
		public WaterContext water() {
			return getRuleContext(WaterContext.class,0);
		}
		public Unary_expressionContext unary_expression() {
			return getRuleContext(Unary_expressionContext.class,0);
		}
		public Simple_declContext simple_decl() {
			return getRuleContext(Simple_declContext.class,0);
		}
		public Coarse_elemContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_coarse_elem; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof SymbolsListener ) ((SymbolsListener)listener).enterCoarse_elem(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SymbolsListener ) ((SymbolsListener)listener).exitCoarse_elem(this);
		}
	}

	public final Coarse_elemContext coarse_elem() throws RecognitionException {
		Coarse_elemContext _localctx = new Coarse_elemContext(_ctx, getState());
		enterRule(_localctx, 2, RULE_coarse_elem);
		try {
			setState(157);
			switch ( getInterpreter().adaptivePredict(_input,1,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(154); unary_expression();
				}
				break;

			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(155); simple_decl();
				}
				break;

			case 3:
				enterOuterAlt(_localctx, 3);
				{
				setState(156); water();
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

	public static class Unary_operatorContext extends ParserRuleContext {
		public Unary_operatorContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_unary_operator; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof SymbolsListener ) ((SymbolsListener)listener).enterUnary_operator(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SymbolsListener ) ((SymbolsListener)listener).exitUnary_operator(this);
		}
	}

	public final Unary_operatorContext unary_operator() throws RecognitionException {
		Unary_operatorContext _localctx = new Unary_operatorContext(_ctx, getState());
		enterRule(_localctx, 4, RULE_unary_operator);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(159);
			_la = _input.LA(1);
			if ( !((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << 1) | (1L << 3) | (1L << 22) | (1L << 30) | (1L << 47) | (1L << 57))) != 0)) ) {
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
			if ( listener instanceof SymbolsListener ) ((SymbolsListener)listener).enterRelational_operator(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SymbolsListener ) ((SymbolsListener)listener).exitRelational_operator(this);
		}
	}

	public final Relational_operatorContext relational_operator() throws RecognitionException {
		Relational_operatorContext _localctx = new Relational_operatorContext(_ctx, getState());
		enterRule(_localctx, 6, RULE_relational_operator);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(161);
			_la = _input.LA(1);
			if ( !((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << 4) | (1L << 7) | (1L << 52) | (1L << 58))) != 0)) ) {
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
		public TerminalNode CHAR() { return getToken(SymbolsParser.CHAR, 0); }
		public TerminalNode OCTAL_LITERAL() { return getToken(SymbolsParser.OCTAL_LITERAL, 0); }
		public TerminalNode HEX_LITERAL() { return getToken(SymbolsParser.HEX_LITERAL, 0); }
		public TerminalNode FLOATING_POINT_LITERAL() { return getToken(SymbolsParser.FLOATING_POINT_LITERAL, 0); }
		public TerminalNode DECIMAL_LITERAL() { return getToken(SymbolsParser.DECIMAL_LITERAL, 0); }
		public TerminalNode STRING() { return getToken(SymbolsParser.STRING, 0); }
		public ConstantContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_constant; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof SymbolsListener ) ((SymbolsListener)listener).enterConstant(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SymbolsListener ) ((SymbolsListener)listener).exitConstant(this);
		}
	}

	public final ConstantContext constant() throws RecognitionException {
		ConstantContext _localctx = new ConstantContext(_ctx, getState());
		enterRule(_localctx, 8, RULE_constant);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(163);
			_la = _input.LA(1);
			if ( !(((((_la - 91)) & ~0x3f) == 0 && ((1L << (_la - 91)) & ((1L << (HEX_LITERAL - 91)) | (1L << (DECIMAL_LITERAL - 91)) | (1L << (OCTAL_LITERAL - 91)) | (1L << (FLOATING_POINT_LITERAL - 91)) | (1L << (CHAR - 91)) | (1L << (STRING - 91)))) != 0)) ) {
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
			if ( listener instanceof SymbolsListener ) ((SymbolsListener)listener).enterFunction_decl_specifiers(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SymbolsListener ) ((SymbolsListener)listener).exitFunction_decl_specifiers(this);
		}
	}

	public final Function_decl_specifiersContext function_decl_specifiers() throws RecognitionException {
		Function_decl_specifiersContext _localctx = new Function_decl_specifiersContext(_ctx, getState());
		enterRule(_localctx, 10, RULE_function_decl_specifiers);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(165);
			_la = _input.LA(1);
			if ( !(((((_la - 14)) & ~0x3f) == 0 && ((1L << (_la - 14)) & ((1L << (14 - 14)) | (1L << (15 - 14)) | (1L << (39 - 14)) | (1L << (41 - 14)) | (1L << (VIRTUAL - 14)))) != 0)) ) {
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

	public static class Class_keyContext extends ParserRuleContext {
		public Class_keyContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_class_key; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof SymbolsListener ) ((SymbolsListener)listener).enterClass_key(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SymbolsListener ) ((SymbolsListener)listener).exitClass_key(this);
		}
	}

	public final Class_keyContext class_key() throws RecognitionException {
		Class_keyContext _localctx = new Class_keyContext(_ctx, getState());
		enterRule(_localctx, 12, RULE_class_key);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(167);
			_la = _input.LA(1);
			if ( !((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << 12) | (1L << 20) | (1L << 23) | (1L << 42))) != 0)) ) {
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
			if ( listener instanceof SymbolsListener ) ((SymbolsListener)listener).enterPtr_operator(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SymbolsListener ) ((SymbolsListener)listener).exitPtr_operator(this);
		}
	}

	public final Ptr_operatorContext ptr_operator() throws RecognitionException {
		Ptr_operatorContext _localctx = new Ptr_operatorContext(_ctx, getState());
		enterRule(_localctx, 14, RULE_ptr_operator);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(169);
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
			if ( listener instanceof SymbolsListener ) ((SymbolsListener)listener).enterAccess_specifier(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SymbolsListener ) ((SymbolsListener)listener).exitAccess_specifier(this);
		}
	}

	public final Access_specifierContext access_specifier() throws RecognitionException {
		Access_specifierContext _localctx = new Access_specifierContext(_ctx, getState());
		enterRule(_localctx, 16, RULE_access_specifier);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(171);
			_la = _input.LA(1);
			if ( !((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << 28) | (1L << 34) | (1L << 48))) != 0)) ) {
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
		public TerminalNode OPERATOR() { return getToken(SymbolsParser.OPERATOR, 0); }
		public OperatorContext operator() {
			return getRuleContext(OperatorContext.class,0);
		}
		public Operator_function_idContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_operator_function_id; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof SymbolsListener ) ((SymbolsListener)listener).enterOperator_function_id(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SymbolsListener ) ((SymbolsListener)listener).exitOperator_function_id(this);
		}
	}

	public final Operator_function_idContext operator_function_id() throws RecognitionException {
		Operator_function_idContext _localctx = new Operator_function_idContext(_ctx, getState());
		enterRule(_localctx, 18, RULE_operator_function_id);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(173); match(OPERATOR);
			setState(174); operator();
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
			if ( listener instanceof SymbolsListener ) ((SymbolsListener)listener).enterOperator(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SymbolsListener ) ((SymbolsListener)listener).exitOperator(this);
		}
	}

	public final OperatorContext operator() throws RecognitionException {
		OperatorContext _localctx = new OperatorContext(_ctx, getState());
		enterRule(_localctx, 20, RULE_operator);
		int _la;
		try {
			setState(221);
			switch (_input.LA(1)) {
			case 19:
			case 45:
				enterOuterAlt(_localctx, 1);
				{
				{
				setState(176);
				_la = _input.LA(1);
				if ( !(_la==19 || _la==45) ) {
				_errHandler.recoverInline(this);
				}
				consume();
				setState(179);
				_la = _input.LA(1);
				if (_la==2) {
					{
					setState(177); match(2);
					setState(178); match(25);
					}
				}

				}
				}
				break;
			case 47:
				enterOuterAlt(_localctx, 2);
				{
				setState(181); match(47);
				}
				break;
			case 30:
				enterOuterAlt(_localctx, 3);
				{
				setState(182); match(30);
				}
				break;
			case 3:
				enterOuterAlt(_localctx, 4);
				{
				setState(183); match(3);
				}
				break;
			case 56:
				enterOuterAlt(_localctx, 5);
				{
				setState(184); match(56);
				}
				break;
			case 9:
				enterOuterAlt(_localctx, 6);
				{
				setState(185); match(9);
				}
				break;
			case 44:
				enterOuterAlt(_localctx, 7);
				{
				setState(186); match(44);
				}
				break;
			case 1:
				enterOuterAlt(_localctx, 8);
				{
				setState(187); match(1);
				}
				break;
			case 21:
				enterOuterAlt(_localctx, 9);
				{
				setState(188); match(21);
				}
				break;
			case 57:
				enterOuterAlt(_localctx, 10);
				{
				setState(189); match(57);
				}
				break;
			case 22:
				enterOuterAlt(_localctx, 11);
				{
				setState(190); match(22);
				}
				break;
			case 17:
				enterOuterAlt(_localctx, 12);
				{
				setState(191); match(17);
				}
				break;
			case 4:
				enterOuterAlt(_localctx, 13);
				{
				setState(192); match(4);
				}
				break;
			case 52:
				enterOuterAlt(_localctx, 14);
				{
				setState(193); match(52);
				}
				break;
			case 37:
				enterOuterAlt(_localctx, 15);
				{
				setState(194); match(37);
				}
				break;
			case 26:
				enterOuterAlt(_localctx, 16);
				{
				setState(195); match(26);
				}
				break;
			case 11:
				enterOuterAlt(_localctx, 17);
				{
				setState(196); match(11);
				}
				break;
			case 54:
				enterOuterAlt(_localctx, 18);
				{
				setState(197); match(54);
				}
				break;
			case 53:
				enterOuterAlt(_localctx, 19);
				{
				setState(198); match(53);
				}
				break;
			case 38:
				enterOuterAlt(_localctx, 20);
				{
				setState(199); match(38);
				}
				break;
			case 33:
				enterOuterAlt(_localctx, 21);
				{
				setState(200); match(33);
				}
				break;
			case 18:
				enterOuterAlt(_localctx, 22);
				{
				setState(201); match(18);
				}
				break;
			case 43:
				enterOuterAlt(_localctx, 23);
				{
				setState(202); match(43);
				}
				break;
			case 8:
				enterOuterAlt(_localctx, 24);
				{
				setState(203); match(8);
				}
				break;
			case 36:
				enterOuterAlt(_localctx, 25);
				{
				setState(204); match(36);
				}
				break;
			case 24:
				enterOuterAlt(_localctx, 26);
				{
				setState(205); match(24);
				}
				break;
			case 55:
				enterOuterAlt(_localctx, 27);
				{
				setState(206); match(55);
				}
				break;
			case 6:
				enterOuterAlt(_localctx, 28);
				{
				setState(207); match(6);
				}
				break;
			case 7:
				enterOuterAlt(_localctx, 29);
				{
				setState(208); match(7);
				}
				break;
			case 58:
				enterOuterAlt(_localctx, 30);
				{
				setState(209); match(58);
				}
				break;
			case 50:
				enterOuterAlt(_localctx, 31);
				{
				setState(210); match(50);
				}
				break;
			case 51:
				enterOuterAlt(_localctx, 32);
				{
				setState(211); match(51);
				}
				break;
			case 40:
				enterOuterAlt(_localctx, 33);
				{
				setState(212); match(40);
				}
				break;
			case 5:
				enterOuterAlt(_localctx, 34);
				{
				setState(213); match(5);
				}
				break;
			case 29:
				enterOuterAlt(_localctx, 35);
				{
				setState(214); match(29);
				}
				break;
			case 27:
				enterOuterAlt(_localctx, 36);
				{
				setState(215); match(27);
				}
				break;
			case 10:
				enterOuterAlt(_localctx, 37);
				{
				setState(216); match(10);
				}
				break;
			case 31:
				enterOuterAlt(_localctx, 38);
				{
				setState(217); match(31);
				setState(218); match(13);
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 39);
				{
				setState(219); match(2);
				setState(220); match(25);
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
			if ( listener instanceof SymbolsListener ) ((SymbolsListener)listener).enterAssignment_operator(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SymbolsListener ) ((SymbolsListener)listener).exitAssignment_operator(this);
		}
	}

	public final Assignment_operatorContext assignment_operator() throws RecognitionException {
		Assignment_operatorContext _localctx = new Assignment_operatorContext(_ctx, getState());
		enterRule(_localctx, 22, RULE_assignment_operator);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(223);
			_la = _input.LA(1);
			if ( !((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << 11) | (1L << 17) | (1L << 18) | (1L << 24) | (1L << 26) | (1L << 33) | (1L << 36) | (1L << 37) | (1L << 38) | (1L << 53) | (1L << 54))) != 0)) ) {
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
			if ( listener instanceof SymbolsListener ) ((SymbolsListener)listener).enterEquality_operator(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SymbolsListener ) ((SymbolsListener)listener).exitEquality_operator(this);
		}
	}

	public final Equality_operatorContext equality_operator() throws RecognitionException {
		Equality_operatorContext _localctx = new Equality_operatorContext(_ctx, getState());
		enterRule(_localctx, 24, RULE_equality_operator);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(225);
			_la = _input.LA(1);
			if ( !(_la==6 || _la==55) ) {
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
		public TerminalNode TEMPLATE() { return getToken(SymbolsParser.TEMPLATE, 0); }
		public Template_decl_startContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_template_decl_start; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof SymbolsListener ) ((SymbolsListener)listener).enterTemplate_decl_start(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SymbolsListener ) ((SymbolsListener)listener).exitTemplate_decl_start(this);
		}
	}

	public final Template_decl_startContext template_decl_start() throws RecognitionException {
		Template_decl_startContext _localctx = new Template_decl_startContext(_ctx, getState());
		enterRule(_localctx, 26, RULE_template_decl_start);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(227); match(TEMPLATE);
			setState(228); match(4);
			setState(229); template_param_list();
			setState(230); match(52);
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
			if ( listener instanceof SymbolsListener ) ((SymbolsListener)listener).enterTemplate_param_list(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SymbolsListener ) ((SymbolsListener)listener).exitTemplate_param_list(this);
		}
	}

	public final Template_param_listContext template_param_list() throws RecognitionException {
		Template_param_listContext _localctx = new Template_param_listContext(_ctx, getState());
		enterRule(_localctx, 28, RULE_template_param_list);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(243);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << 1) | (1L << 2) | (1L << 3) | (1L << 4) | (1L << 5) | (1L << 6) | (1L << 7) | (1L << 8) | (1L << 9) | (1L << 10) | (1L << 11) | (1L << 12) | (1L << 14) | (1L << 15) | (1L << 16) | (1L << 17) | (1L << 18) | (1L << 19) | (1L << 20) | (1L << 21) | (1L << 22) | (1L << 23) | (1L << 24) | (1L << 25) | (1L << 26) | (1L << 27) | (1L << 28) | (1L << 29) | (1L << 30) | (1L << 31) | (1L << 32) | (1L << 33) | (1L << 34) | (1L << 35) | (1L << 36) | (1L << 37) | (1L << 38) | (1L << 39) | (1L << 40) | (1L << 41) | (1L << 42) | (1L << 43) | (1L << 44) | (1L << 45) | (1L << 46) | (1L << 47) | (1L << 48) | (1L << 49) | (1L << 50) | (1L << 51) | (1L << 53) | (1L << 54) | (1L << 55) | (1L << 56) | (1L << 57) | (1L << 58) | (1L << IF) | (1L << ELSE) | (1L << FOR) | (1L << WHILE) | (1L << BREAK))) != 0) || ((((_la - 64)) & ~0x3f) == 0 && ((1L << (_la - 64)) & ((1L << (CASE - 64)) | (1L << (CONTINUE - 64)) | (1L << (SWITCH - 64)) | (1L << (GOTO - 64)) | (1L << (RETURN - 64)) | (1L << (TYPEDEF - 64)) | (1L << (VOID - 64)) | (1L << (UNSIGNED - 64)) | (1L << (SIGNED - 64)) | (1L << (LONG - 64)) | (1L << (CV_QUALIFIER - 64)) | (1L << (VIRTUAL - 64)) | (1L << (TRY - 64)) | (1L << (CATCH - 64)) | (1L << (THROW - 64)) | (1L << (USING - 64)) | (1L << (NAMESPACE - 64)) | (1L << (AUTO - 64)) | (1L << (REGISTER - 64)) | (1L << (OPERATOR - 64)) | (1L << (TEMPLATE - 64)) | (1L << (ALPHA_NUMERIC - 64)) | (1L << (OPENING_CURLY - 64)) | (1L << (CLOSING_CURLY - 64)) | (1L << (PRE_IF - 64)) | (1L << (PRE_ELSE - 64)) | (1L << (PRE_ENDIF - 64)) | (1L << (HEX_LITERAL - 64)) | (1L << (DECIMAL_LITERAL - 64)) | (1L << (OCTAL_LITERAL - 64)) | (1L << (FLOATING_POINT_LITERAL - 64)) | (1L << (CHAR - 64)) | (1L << (STRING - 64)) | (1L << (COMMENT - 64)) | (1L << (WHITESPACE - 64)) | (1L << (CPPCOMMENT - 64)) | (1L << (OTHER - 64)))) != 0)) {
				{
				setState(241);
				switch (_input.LA(1)) {
				case 4:
					{
					{
					setState(232); match(4);
					setState(233); template_param_list();
					setState(234); match(52);
					}
					}
					break;
				case 31:
					{
					{
					setState(236); match(31);
					setState(237); template_param_list();
					setState(238); match(13);
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
				case 12:
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
				case 29:
				case 30:
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
				case 53:
				case 54:
				case 55:
				case 56:
				case 57:
				case 58:
				case IF:
				case ELSE:
				case FOR:
				case WHILE:
				case BREAK:
				case CASE:
				case CONTINUE:
				case SWITCH:
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
					setState(240); no_angle_brackets_or_brackets();
					}
					break;
				default:
					throw new NoViableAltException(this);
				}
				}
				setState(245);
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

	public static class No_bracketsContext extends ParserRuleContext {
		public No_bracketsContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_no_brackets; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof SymbolsListener ) ((SymbolsListener)listener).enterNo_brackets(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SymbolsListener ) ((SymbolsListener)listener).exitNo_brackets(this);
		}
	}

	public final No_bracketsContext no_brackets() throws RecognitionException {
		No_bracketsContext _localctx = new No_bracketsContext(_ctx, getState());
		enterRule(_localctx, 30, RULE_no_brackets);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(246);
			_la = _input.LA(1);
			if ( _la <= 0 || (_la==13 || _la==31) ) {
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
			if ( listener instanceof SymbolsListener ) ((SymbolsListener)listener).enterNo_brackets_curlies_or_squares(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SymbolsListener ) ((SymbolsListener)listener).exitNo_brackets_curlies_or_squares(this);
		}
	}

	public final No_brackets_curlies_or_squaresContext no_brackets_curlies_or_squares() throws RecognitionException {
		No_brackets_curlies_or_squaresContext _localctx = new No_brackets_curlies_or_squaresContext(_ctx, getState());
		enterRule(_localctx, 32, RULE_no_brackets_curlies_or_squares);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(248);
			_la = _input.LA(1);
			if ( _la <= 0 || ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << 2) | (1L << 13) | (1L << 25) | (1L << 31))) != 0) || _la==OPENING_CURLY || _la==CLOSING_CURLY) ) {
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
			if ( listener instanceof SymbolsListener ) ((SymbolsListener)listener).enterNo_brackets_or_semicolon(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SymbolsListener ) ((SymbolsListener)listener).exitNo_brackets_or_semicolon(this);
		}
	}

	public final No_brackets_or_semicolonContext no_brackets_or_semicolon() throws RecognitionException {
		No_brackets_or_semicolonContext _localctx = new No_brackets_or_semicolonContext(_ctx, getState());
		enterRule(_localctx, 34, RULE_no_brackets_or_semicolon);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(250);
			_la = _input.LA(1);
			if ( _la <= 0 || ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << 13) | (1L << 31) | (1L << 49))) != 0)) ) {
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
			if ( listener instanceof SymbolsListener ) ((SymbolsListener)listener).enterNo_angle_brackets_or_brackets(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SymbolsListener ) ((SymbolsListener)listener).exitNo_angle_brackets_or_brackets(this);
		}
	}

	public final No_angle_brackets_or_bracketsContext no_angle_brackets_or_brackets() throws RecognitionException {
		No_angle_brackets_or_bracketsContext _localctx = new No_angle_brackets_or_bracketsContext(_ctx, getState());
		enterRule(_localctx, 36, RULE_no_angle_brackets_or_brackets);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(252);
			_la = _input.LA(1);
			if ( _la <= 0 || ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << 4) | (1L << 13) | (1L << 31) | (1L << 52))) != 0)) ) {
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
			if ( listener instanceof SymbolsListener ) ((SymbolsListener)listener).enterNo_curlies(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SymbolsListener ) ((SymbolsListener)listener).exitNo_curlies(this);
		}
	}

	public final No_curliesContext no_curlies() throws RecognitionException {
		No_curliesContext _localctx = new No_curliesContext(_ctx, getState());
		enterRule(_localctx, 38, RULE_no_curlies);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(254);
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
			if ( listener instanceof SymbolsListener ) ((SymbolsListener)listener).enterNo_squares(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SymbolsListener ) ((SymbolsListener)listener).exitNo_squares(this);
		}
	}

	public final No_squaresContext no_squares() throws RecognitionException {
		No_squaresContext _localctx = new No_squaresContext(_ctx, getState());
		enterRule(_localctx, 40, RULE_no_squares);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(256);
			_la = _input.LA(1);
			if ( _la <= 0 || (_la==2 || _la==25) ) {
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
			if ( listener instanceof SymbolsListener ) ((SymbolsListener)listener).enterNo_squares_or_semicolon(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SymbolsListener ) ((SymbolsListener)listener).exitNo_squares_or_semicolon(this);
		}
	}

	public final No_squares_or_semicolonContext no_squares_or_semicolon() throws RecognitionException {
		No_squares_or_semicolonContext _localctx = new No_squares_or_semicolonContext(_ctx, getState());
		enterRule(_localctx, 42, RULE_no_squares_or_semicolon);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(258);
			_la = _input.LA(1);
			if ( _la <= 0 || ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << 2) | (1L << 25) | (1L << 49))) != 0)) ) {
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
			if ( listener instanceof SymbolsListener ) ((SymbolsListener)listener).enterNo_comma_or_semicolon(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SymbolsListener ) ((SymbolsListener)listener).exitNo_comma_or_semicolon(this);
		}
	}

	public final No_comma_or_semicolonContext no_comma_or_semicolon() throws RecognitionException {
		No_comma_or_semicolonContext _localctx = new No_comma_or_semicolonContext(_ctx, getState());
		enterRule(_localctx, 44, RULE_no_comma_or_semicolon);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(260);
			_la = _input.LA(1);
			if ( _la <= 0 || (_la==29 || _la==49) ) {
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
			if ( listener instanceof SymbolsListener ) ((SymbolsListener)listener).enterAssign_water(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SymbolsListener ) ((SymbolsListener)listener).exitAssign_water(this);
		}
	}

	public final Assign_waterContext assign_water() throws RecognitionException {
		Assign_waterContext _localctx = new Assign_waterContext(_ctx, getState());
		enterRule(_localctx, 46, RULE_assign_water);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(262);
			_la = _input.LA(1);
			if ( _la <= 0 || ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << 2) | (1L << 13) | (1L << 25) | (1L << 29) | (1L << 31) | (1L << 49))) != 0) || _la==OPENING_CURLY || _la==CLOSING_CURLY) ) {
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
			if ( listener instanceof SymbolsListener ) ((SymbolsListener)listener).enterAssign_water_l2(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SymbolsListener ) ((SymbolsListener)listener).exitAssign_water_l2(this);
		}
	}

	public final Assign_water_l2Context assign_water_l2() throws RecognitionException {
		Assign_water_l2Context _localctx = new Assign_water_l2Context(_ctx, getState());
		enterRule(_localctx, 48, RULE_assign_water_l2);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(264);
			_la = _input.LA(1);
			if ( _la <= 0 || ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << 2) | (1L << 13) | (1L << 25) | (1L << 31))) != 0) || _la==OPENING_CURLY || _la==CLOSING_CURLY) ) {
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
			if ( listener instanceof SymbolsListener ) ((SymbolsListener)listener).enterWater(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SymbolsListener ) ((SymbolsListener)listener).exitWater(this);
		}
	}

	public final WaterContext water() throws RecognitionException {
		WaterContext _localctx = new WaterContext(_ctx, getState());
		enterRule(_localctx, 50, RULE_water);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(266);
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
			if ( listener instanceof SymbolsListener ) ((SymbolsListener)listener).enterExpr(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SymbolsListener ) ((SymbolsListener)listener).exitExpr(this);
		}
	}

	public final ExprContext expr() throws RecognitionException {
		ExprContext _localctx = new ExprContext(_ctx, getState());
		enterRule(_localctx, 52, RULE_expr);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(268); assign_expr();
			setState(271);
			_la = _input.LA(1);
			if (_la==29) {
				{
				setState(269); match(29);
				setState(270); assign_expr();
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
			if ( listener instanceof SymbolsListener ) ((SymbolsListener)listener).enterAssign_expr(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SymbolsListener ) ((SymbolsListener)listener).exitAssign_expr(this);
		}
	}

	public final Assign_exprContext assign_expr() throws RecognitionException {
		Assign_exprContext _localctx = new Assign_exprContext(_ctx, getState());
		enterRule(_localctx, 54, RULE_assign_expr);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(273); conditional_expression();
			setState(277);
			_la = _input.LA(1);
			if ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << 11) | (1L << 17) | (1L << 18) | (1L << 24) | (1L << 26) | (1L << 33) | (1L << 36) | (1L << 37) | (1L << 38) | (1L << 53) | (1L << 54))) != 0)) {
				{
				setState(274); assignment_operator();
				setState(275); assign_expr();
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
			if ( listener instanceof SymbolsListener ) ((SymbolsListener)listener).enterConditional_expression(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SymbolsListener ) ((SymbolsListener)listener).exitConditional_expression(this);
		}
	}

	public final Conditional_expressionContext conditional_expression() throws RecognitionException {
		Conditional_expressionContext _localctx = new Conditional_expressionContext(_ctx, getState());
		enterRule(_localctx, 56, RULE_conditional_expression);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(279); or_expression();
			setState(285);
			_la = _input.LA(1);
			if (_la==35) {
				{
				setState(280); match(35);
				setState(281); expr();
				setState(282); match(32);
				setState(283); conditional_expression();
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
			if ( listener instanceof SymbolsListener ) ((SymbolsListener)listener).enterOr_expression(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SymbolsListener ) ((SymbolsListener)listener).exitOr_expression(this);
		}
	}

	public final Or_expressionContext or_expression() throws RecognitionException {
		Or_expressionContext _localctx = new Or_expressionContext(_ctx, getState());
		enterRule(_localctx, 58, RULE_or_expression);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(287); and_expression();
			setState(290);
			_la = _input.LA(1);
			if (_la==51) {
				{
				setState(288); match(51);
				setState(289); or_expression();
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
			if ( listener instanceof SymbolsListener ) ((SymbolsListener)listener).enterAnd_expression(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SymbolsListener ) ((SymbolsListener)listener).exitAnd_expression(this);
		}
	}

	public final And_expressionContext and_expression() throws RecognitionException {
		And_expressionContext _localctx = new And_expressionContext(_ctx, getState());
		enterRule(_localctx, 60, RULE_and_expression);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(292); inclusive_or_expression();
			setState(295);
			_la = _input.LA(1);
			if (_la==50) {
				{
				setState(293); match(50);
				setState(294); and_expression();
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
			if ( listener instanceof SymbolsListener ) ((SymbolsListener)listener).enterInclusive_or_expression(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SymbolsListener ) ((SymbolsListener)listener).exitInclusive_or_expression(this);
		}
	}

	public final Inclusive_or_expressionContext inclusive_or_expression() throws RecognitionException {
		Inclusive_or_expressionContext _localctx = new Inclusive_or_expressionContext(_ctx, getState());
		enterRule(_localctx, 62, RULE_inclusive_or_expression);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(297); exclusive_or_expression();
			setState(300);
			_la = _input.LA(1);
			if (_la==21) {
				{
				setState(298); match(21);
				setState(299); inclusive_or_expression();
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
			if ( listener instanceof SymbolsListener ) ((SymbolsListener)listener).enterExclusive_or_expression(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SymbolsListener ) ((SymbolsListener)listener).exitExclusive_or_expression(this);
		}
	}

	public final Exclusive_or_expressionContext exclusive_or_expression() throws RecognitionException {
		Exclusive_or_expressionContext _localctx = new Exclusive_or_expressionContext(_ctx, getState());
		enterRule(_localctx, 64, RULE_exclusive_or_expression);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(302); bit_and_expression();
			setState(305);
			_la = _input.LA(1);
			if (_la==44) {
				{
				setState(303); match(44);
				setState(304); exclusive_or_expression();
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
			if ( listener instanceof SymbolsListener ) ((SymbolsListener)listener).enterBit_and_expression(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SymbolsListener ) ((SymbolsListener)listener).exitBit_and_expression(this);
		}
	}

	public final Bit_and_expressionContext bit_and_expression() throws RecognitionException {
		Bit_and_expressionContext _localctx = new Bit_and_expressionContext(_ctx, getState());
		enterRule(_localctx, 66, RULE_bit_and_expression);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(307); equality_expression();
			setState(310);
			_la = _input.LA(1);
			if (_la==1) {
				{
				setState(308); match(1);
				setState(309); bit_and_expression();
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
			if ( listener instanceof SymbolsListener ) ((SymbolsListener)listener).enterEquality_expression(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SymbolsListener ) ((SymbolsListener)listener).exitEquality_expression(this);
		}
	}

	public final Equality_expressionContext equality_expression() throws RecognitionException {
		Equality_expressionContext _localctx = new Equality_expressionContext(_ctx, getState());
		enterRule(_localctx, 68, RULE_equality_expression);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(312); relational_expression();
			setState(316);
			_la = _input.LA(1);
			if (_la==6 || _la==55) {
				{
				setState(313); equality_operator();
				setState(314); equality_expression();
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
			if ( listener instanceof SymbolsListener ) ((SymbolsListener)listener).enterRelational_expression(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SymbolsListener ) ((SymbolsListener)listener).exitRelational_expression(this);
		}
	}

	public final Relational_expressionContext relational_expression() throws RecognitionException {
		Relational_expressionContext _localctx = new Relational_expressionContext(_ctx, getState());
		enterRule(_localctx, 70, RULE_relational_expression);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(318); shift_expression();
			setState(322);
			_la = _input.LA(1);
			if ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << 4) | (1L << 7) | (1L << 52) | (1L << 58))) != 0)) {
				{
				setState(319); relational_operator();
				setState(320); relational_expression();
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
			if ( listener instanceof SymbolsListener ) ((SymbolsListener)listener).enterShift_expression(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SymbolsListener ) ((SymbolsListener)listener).exitShift_expression(this);
		}
	}

	public final Shift_expressionContext shift_expression() throws RecognitionException {
		Shift_expressionContext _localctx = new Shift_expressionContext(_ctx, getState());
		enterRule(_localctx, 72, RULE_shift_expression);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(324); additive_expression();
			setState(327);
			_la = _input.LA(1);
			if (_la==8 || _la==43) {
				{
				setState(325);
				_la = _input.LA(1);
				if ( !(_la==8 || _la==43) ) {
				_errHandler.recoverInline(this);
				}
				consume();
				setState(326); shift_expression();
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
			if ( listener instanceof SymbolsListener ) ((SymbolsListener)listener).enterAdditive_expression(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SymbolsListener ) ((SymbolsListener)listener).exitAdditive_expression(this);
		}
	}

	public final Additive_expressionContext additive_expression() throws RecognitionException {
		Additive_expressionContext _localctx = new Additive_expressionContext(_ctx, getState());
		enterRule(_localctx, 74, RULE_additive_expression);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(329); multiplicative_expression();
			setState(332);
			_la = _input.LA(1);
			if (_la==30 || _la==47) {
				{
				setState(330);
				_la = _input.LA(1);
				if ( !(_la==30 || _la==47) ) {
				_errHandler.recoverInline(this);
				}
				consume();
				setState(331); additive_expression();
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
			if ( listener instanceof SymbolsListener ) ((SymbolsListener)listener).enterMultiplicative_expression(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SymbolsListener ) ((SymbolsListener)listener).exitMultiplicative_expression(this);
		}
	}

	public final Multiplicative_expressionContext multiplicative_expression() throws RecognitionException {
		Multiplicative_expressionContext _localctx = new Multiplicative_expressionContext(_ctx, getState());
		enterRule(_localctx, 76, RULE_multiplicative_expression);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(334); cast_expression();
			setState(337);
			_la = _input.LA(1);
			if ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << 3) | (1L << 9) | (1L << 56))) != 0)) {
				{
				setState(335);
				_la = _input.LA(1);
				if ( !((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << 3) | (1L << 9) | (1L << 56))) != 0)) ) {
				_errHandler.recoverInline(this);
				}
				consume();
				setState(336); cast_expression();
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
			if ( listener instanceof SymbolsListener ) ((SymbolsListener)listener).enterCast_expression(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SymbolsListener ) ((SymbolsListener)listener).exitCast_expression(this);
		}
	}

	public final Cast_expressionContext cast_expression() throws RecognitionException {
		Cast_expressionContext _localctx = new Cast_expressionContext(_ctx, getState());
		enterRule(_localctx, 78, RULE_cast_expression);
		int _la;
		try {
			setState(351);
			switch ( getInterpreter().adaptivePredict(_input,20,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				{
				setState(339); match(31);
				setState(340); type_name();
				setState(344);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (_la==1 || _la==3) {
					{
					{
					setState(341); ptr_operator();
					}
					}
					setState(346);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				setState(347); match(13);
				setState(348); cast_expression();
				}
				}
				break;

			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(350); unary_expression();
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
			if ( listener instanceof SymbolsListener ) ((SymbolsListener)listener).enterUnary_expression(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SymbolsListener ) ((SymbolsListener)listener).exitUnary_expression(this);
		}
	}

	public final Unary_expressionContext unary_expression() throws RecognitionException {
		Unary_expressionContext _localctx = new Unary_expressionContext(_ctx, getState());
		enterRule(_localctx, 80, RULE_unary_expression);
		int _la;
		try {
			setState(365);
			switch (_input.LA(1)) {
			case 31:
			case ALPHA_NUMERIC:
			case HEX_LITERAL:
			case DECIMAL_LITERAL:
			case OCTAL_LITERAL:
			case FLOATING_POINT_LITERAL:
			case CHAR:
			case STRING:
				enterOuterAlt(_localctx, 1);
				{
				setState(353); postfix_expression();
				}
				break;
			case 5:
				enterOuterAlt(_localctx, 2);
				{
				setState(354); match(5);
				setState(355); unary_expression();
				}
				break;
			case 40:
				enterOuterAlt(_localctx, 3);
				{
				setState(356); match(40);
				setState(357); unary_expression();
				}
				break;
			case 1:
			case 3:
			case 22:
			case 30:
			case 47:
			case 57:
				enterOuterAlt(_localctx, 4);
				{
				{
				setState(359); 
				_errHandler.sync(this);
				_la = _input.LA(1);
				do {
					{
					{
					setState(358); unary_operator();
					}
					}
					setState(361); 
					_errHandler.sync(this);
					_la = _input.LA(1);
				} while ( (((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << 1) | (1L << 3) | (1L << 22) | (1L << 30) | (1L << 47) | (1L << 57))) != 0) );
				setState(363); postfix_expression();
				}
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
			if ( listener instanceof SymbolsListener ) ((SymbolsListener)listener).enterFieldOnly(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SymbolsListener ) ((SymbolsListener)listener).exitFieldOnly(this);
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
			if ( listener instanceof SymbolsListener ) ((SymbolsListener)listener).enterFuncCall(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SymbolsListener ) ((SymbolsListener)listener).exitFuncCall(this);
		}
	}

	public final Postfix_expressionContext postfix_expression() throws RecognitionException {
		Postfix_expressionContext _localctx = new Postfix_expressionContext(_ctx, getState());
		enterRule(_localctx, 82, RULE_postfix_expression);
		try {
			setState(371);
			switch ( getInterpreter().adaptivePredict(_input,23,_ctx) ) {
			case 1:
				_localctx = new FuncCallContext(_localctx);
				enterOuterAlt(_localctx, 1);
				{
				setState(367); field();
				setState(368); function_call_tail();
				}
				break;

			case 2:
				_localctx = new FieldOnlyContext(_localctx);
				enterOuterAlt(_localctx, 2);
				{
				setState(370); field();
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
			if ( listener instanceof SymbolsListener ) ((SymbolsListener)listener).enterField(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SymbolsListener ) ((SymbolsListener)listener).exitField(this);
		}
	}

	public final FieldContext field() throws RecognitionException {
		FieldContext _localctx = new FieldContext(_ctx, getState());
		enterRule(_localctx, 84, RULE_field);
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			{
			setState(373); primary_expression();
			setState(377);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,24,_ctx);
			while ( _alt!=2 && _alt!=-1 ) {
				if ( _alt==1 ) {
					{
					{
					setState(374); postfix();
					}
					} 
				}
				setState(379);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,24,_ctx);
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
			if ( listener instanceof SymbolsListener ) ((SymbolsListener)listener).enterFunction_call_tail(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SymbolsListener ) ((SymbolsListener)listener).exitFunction_call_tail(this);
		}
	}

	public final Function_call_tailContext function_call_tail() throws RecognitionException {
		Function_call_tailContext _localctx = new Function_call_tailContext(_ctx, getState());
		enterRule(_localctx, 86, RULE_function_call_tail);
		try {
			setState(384);
			switch (_input.LA(1)) {
			case 4:
				enterOuterAlt(_localctx, 1);
				{
				setState(380); call_template_list();
				setState(381); function_argument_list();
				}
				break;
			case 31:
				enterOuterAlt(_localctx, 2);
				{
				setState(383); function_argument_list();
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
			if ( listener instanceof SymbolsListener ) ((SymbolsListener)listener).enterCall_template_list(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SymbolsListener ) ((SymbolsListener)listener).exitCall_template_list(this);
		}
	}

	public final Call_template_listContext call_template_list() throws RecognitionException {
		Call_template_listContext _localctx = new Call_template_listContext(_ctx, getState());
		enterRule(_localctx, 88, RULE_call_template_list);
		try {
			enterOuterAlt(_localctx, 1);
			{
			{
			setState(386); match(4);
			setState(387); template_param_list();
			setState(388); match(52);
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
			if ( listener instanceof SymbolsListener ) ((SymbolsListener)listener).enterFunction_argument_list(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SymbolsListener ) ((SymbolsListener)listener).exitFunction_argument_list(this);
		}
	}

	public final Function_argument_listContext function_argument_list() throws RecognitionException {
		Function_argument_listContext _localctx = new Function_argument_listContext(_ctx, getState());
		enterRule(_localctx, 90, RULE_function_argument_list);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(390); match(31);
			setState(399);
			_la = _input.LA(1);
			if ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << 1) | (1L << 3) | (1L << 5) | (1L << 22) | (1L << 30) | (1L << 31) | (1L << 40) | (1L << 47) | (1L << 57))) != 0) || ((((_la - 85)) & ~0x3f) == 0 && ((1L << (_la - 85)) & ((1L << (ALPHA_NUMERIC - 85)) | (1L << (HEX_LITERAL - 85)) | (1L << (DECIMAL_LITERAL - 85)) | (1L << (OCTAL_LITERAL - 85)) | (1L << (FLOATING_POINT_LITERAL - 85)) | (1L << (CHAR - 85)) | (1L << (STRING - 85)))) != 0)) {
				{
				setState(391); function_argument();
				setState(396);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (_la==29) {
					{
					{
					setState(392); match(29);
					setState(393); function_argument();
					}
					}
					setState(398);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				}
			}

			setState(401); match(13);
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
			if ( listener instanceof SymbolsListener ) ((SymbolsListener)listener).enterFunction_argument(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SymbolsListener ) ((SymbolsListener)listener).exitFunction_argument(this);
		}
	}

	public final Function_argumentContext function_argument() throws RecognitionException {
		Function_argumentContext _localctx = new Function_argumentContext(_ctx, getState());
		enterRule(_localctx, 92, RULE_function_argument);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(403); assign_expr();
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
			if ( listener instanceof SymbolsListener ) ((SymbolsListener)listener).enterPostfix(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SymbolsListener ) ((SymbolsListener)listener).exitPostfix(this);
		}
	}

	public final PostfixContext postfix() throws RecognitionException {
		PostfixContext _localctx = new PostfixContext(_ctx, getState());
		enterRule(_localctx, 94, RULE_postfix);
		try {
			setState(417);
			switch (_input.LA(1)) {
			case 2:
			case 10:
			case 46:
				enterOuterAlt(_localctx, 1);
				{
				setState(413);
				switch (_input.LA(1)) {
				case 46:
					{
					setState(405); match(46);
					setState(406); identifier();
					}
					break;
				case 10:
					{
					setState(407); match(10);
					setState(408); identifier();
					}
					break;
				case 2:
					{
					setState(409); match(2);
					setState(410); expr();
					setState(411); match(25);
					}
					break;
				default:
					throw new NoViableAltException(this);
				}
				}
				break;
			case 40:
				enterOuterAlt(_localctx, 2);
				{
				setState(415); match(40);
				}
				break;
			case 5:
				enterOuterAlt(_localctx, 3);
				{
				setState(416); match(5);
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
			if ( listener instanceof SymbolsListener ) ((SymbolsListener)listener).enterPrimary_expression(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SymbolsListener ) ((SymbolsListener)listener).exitPrimary_expression(this);
		}
	}

	public final Primary_expressionContext primary_expression() throws RecognitionException {
		Primary_expressionContext _localctx = new Primary_expressionContext(_ctx, getState());
		enterRule(_localctx, 96, RULE_primary_expression);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(425);
			switch (_input.LA(1)) {
			case 31:
				{
				setState(419); match(31);
				setState(420); expr();
				setState(421); match(13);
				}
				break;
			case ALPHA_NUMERIC:
				{
				setState(423); identifier();
				}
				break;
			case HEX_LITERAL:
			case DECIMAL_LITERAL:
			case OCTAL_LITERAL:
			case FLOATING_POINT_LITERAL:
			case CHAR:
			case STRING:
				{
				setState(424); constant();
				}
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

	public static class Simple_declContext extends ParserRuleContext {
		public Template_decl_startContext template_decl_start() {
			return getRuleContext(Template_decl_startContext.class,0);
		}
		public TerminalNode TYPEDEF() { return getToken(SymbolsParser.TYPEDEF, 0); }
		public Var_declContext var_decl() {
			return getRuleContext(Var_declContext.class,0);
		}
		public Simple_declContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_simple_decl; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof SymbolsListener ) ((SymbolsListener)listener).enterSimple_decl(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SymbolsListener ) ((SymbolsListener)listener).exitSimple_decl(this);
		}
	}

	public final Simple_declContext simple_decl() throws RecognitionException {
		Simple_declContext _localctx = new Simple_declContext(_ctx, getState());
		enterRule(_localctx, 98, RULE_simple_decl);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(428);
			_la = _input.LA(1);
			if (_la==TYPEDEF) {
				{
				setState(427); match(TYPEDEF);
				}
			}

			setState(431);
			_la = _input.LA(1);
			if (_la==TEMPLATE) {
				{
				setState(430); template_decl_start();
				}
			}

			setState(433); var_decl();
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
			if ( listener instanceof SymbolsListener ) ((SymbolsListener)listener).enterDeclByClass(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SymbolsListener ) ((SymbolsListener)listener).exitDeclByClass(this);
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
			if ( listener instanceof SymbolsListener ) ((SymbolsListener)listener).enterDeclByType(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SymbolsListener ) ((SymbolsListener)listener).exitDeclByType(this);
		}
	}

	public final Var_declContext var_decl() throws RecognitionException {
		Var_declContext _localctx = new Var_declContext(_ctx, getState());
		enterRule(_localctx, 100, RULE_var_decl);
		try {
			setState(442);
			switch ( getInterpreter().adaptivePredict(_input,34,_ctx) ) {
			case 1:
				_localctx = new DeclByTypeContext(_localctx);
				enterOuterAlt(_localctx, 1);
				{
				setState(435); type_name();
				setState(436); init_declarator_list();
				}
				break;

			case 2:
				_localctx = new DeclByClassContext(_localctx);
				enterOuterAlt(_localctx, 2);
				{
				setState(438); class_def();
				setState(440);
				switch ( getInterpreter().adaptivePredict(_input,33,_ctx) ) {
				case 1:
					{
					setState(439); init_declarator_list();
					}
					break;
				}
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
			if ( listener instanceof SymbolsListener ) ((SymbolsListener)listener).enterInit_declarator_list(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SymbolsListener ) ((SymbolsListener)listener).exitInit_declarator_list(this);
		}
	}

	public final Init_declarator_listContext init_declarator_list() throws RecognitionException {
		Init_declarator_listContext _localctx = new Init_declarator_listContext(_ctx, getState());
		enterRule(_localctx, 102, RULE_init_declarator_list);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(444); init_declarator();
			setState(449);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==29) {
				{
				{
				setState(445); match(29);
				setState(446); init_declarator();
				}
				}
				setState(451);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(452); match(49);
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
			if ( listener instanceof SymbolsListener ) ((SymbolsListener)listener).enterInit_declarator(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SymbolsListener ) ((SymbolsListener)listener).exitInit_declarator(this);
		}
	}

	public final Init_declaratorContext init_declarator() throws RecognitionException {
		Init_declaratorContext _localctx = new Init_declaratorContext(_ctx, getState());
		enterRule(_localctx, 104, RULE_init_declarator);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			{
			setState(455);
			_la = _input.LA(1);
			if (_la==1 || _la==3) {
				{
				setState(454); ptrs();
				}
			}

			setState(457); identifier();
			setState(459);
			switch ( getInterpreter().adaptivePredict(_input,37,_ctx) ) {
			case 1:
				{
				setState(458); type_suffix();
				}
				break;
			}
			}
			setState(468);
			switch (_input.LA(1)) {
			case 31:
				{
				{
				setState(461); match(31);
				setState(463);
				_la = _input.LA(1);
				if ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << 1) | (1L << 3) | (1L << 5) | (1L << 22) | (1L << 30) | (1L << 31) | (1L << 40) | (1L << 47) | (1L << 57))) != 0) || ((((_la - 85)) & ~0x3f) == 0 && ((1L << (_la - 85)) & ((1L << (ALPHA_NUMERIC - 85)) | (1L << (HEX_LITERAL - 85)) | (1L << (DECIMAL_LITERAL - 85)) | (1L << (OCTAL_LITERAL - 85)) | (1L << (FLOATING_POINT_LITERAL - 85)) | (1L << (CHAR - 85)) | (1L << (STRING - 85)))) != 0)) {
					{
					setState(462); expr();
					}
				}

				setState(465); match(13);
				}
				}
				break;
			case 17:
				{
				{
				setState(466); match(17);
				setState(467); assign_expr_w_();
				}
				}
				break;
			case 29:
			case 49:
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
			if ( listener instanceof SymbolsListener ) ((SymbolsListener)listener).enterAssign_expr_w_(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SymbolsListener ) ((SymbolsListener)listener).exitAssign_expr_w_(this);
		}
	}

	public final Assign_expr_w_Context assign_expr_w_() throws RecognitionException {
		Assign_expr_w_Context _localctx = new Assign_expr_w_Context(_ctx, getState());
		enterRule(_localctx, 106, RULE_assign_expr_w_);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(473);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << 1) | (1L << 3) | (1L << 4) | (1L << 5) | (1L << 6) | (1L << 7) | (1L << 8) | (1L << 9) | (1L << 10) | (1L << 11) | (1L << 12) | (1L << 14) | (1L << 15) | (1L << 16) | (1L << 17) | (1L << 18) | (1L << 19) | (1L << 20) | (1L << 21) | (1L << 22) | (1L << 23) | (1L << 24) | (1L << 26) | (1L << 27) | (1L << 28) | (1L << 30) | (1L << 32) | (1L << 33) | (1L << 34) | (1L << 35) | (1L << 36) | (1L << 37) | (1L << 38) | (1L << 39) | (1L << 40) | (1L << 41) | (1L << 42) | (1L << 43) | (1L << 44) | (1L << 45) | (1L << 46) | (1L << 47) | (1L << 48) | (1L << 50) | (1L << 51) | (1L << 52) | (1L << 53) | (1L << 54) | (1L << 55) | (1L << 56) | (1L << 57) | (1L << 58) | (1L << IF) | (1L << ELSE) | (1L << FOR) | (1L << WHILE) | (1L << BREAK))) != 0) || ((((_la - 64)) & ~0x3f) == 0 && ((1L << (_la - 64)) & ((1L << (CASE - 64)) | (1L << (CONTINUE - 64)) | (1L << (SWITCH - 64)) | (1L << (GOTO - 64)) | (1L << (RETURN - 64)) | (1L << (TYPEDEF - 64)) | (1L << (VOID - 64)) | (1L << (UNSIGNED - 64)) | (1L << (SIGNED - 64)) | (1L << (LONG - 64)) | (1L << (CV_QUALIFIER - 64)) | (1L << (VIRTUAL - 64)) | (1L << (TRY - 64)) | (1L << (CATCH - 64)) | (1L << (THROW - 64)) | (1L << (USING - 64)) | (1L << (NAMESPACE - 64)) | (1L << (AUTO - 64)) | (1L << (REGISTER - 64)) | (1L << (OPERATOR - 64)) | (1L << (TEMPLATE - 64)) | (1L << (ALPHA_NUMERIC - 64)) | (1L << (PRE_IF - 64)) | (1L << (PRE_ELSE - 64)) | (1L << (PRE_ENDIF - 64)) | (1L << (HEX_LITERAL - 64)) | (1L << (DECIMAL_LITERAL - 64)) | (1L << (OCTAL_LITERAL - 64)) | (1L << (FLOATING_POINT_LITERAL - 64)) | (1L << (CHAR - 64)) | (1L << (STRING - 64)) | (1L << (COMMENT - 64)) | (1L << (WHITESPACE - 64)) | (1L << (CPPCOMMENT - 64)) | (1L << (OTHER - 64)))) != 0)) {
				{
				{
				setState(470); assign_water();
				}
				}
				setState(475);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(498);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==2 || _la==31 || _la==OPENING_CURLY) {
				{
				{
				setState(488);
				switch (_input.LA(1)) {
				case OPENING_CURLY:
					{
					setState(476); match(OPENING_CURLY);
					setState(477); assign_expr_w__l2();
					setState(478); match(CLOSING_CURLY);
					}
					break;
				case 31:
					{
					setState(480); match(31);
					setState(481); assign_expr_w__l2();
					setState(482); match(13);
					}
					break;
				case 2:
					{
					setState(484); match(2);
					setState(485); assign_expr_w__l2();
					setState(486); match(25);
					}
					break;
				default:
					throw new NoViableAltException(this);
				}
				setState(493);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << 1) | (1L << 3) | (1L << 4) | (1L << 5) | (1L << 6) | (1L << 7) | (1L << 8) | (1L << 9) | (1L << 10) | (1L << 11) | (1L << 12) | (1L << 14) | (1L << 15) | (1L << 16) | (1L << 17) | (1L << 18) | (1L << 19) | (1L << 20) | (1L << 21) | (1L << 22) | (1L << 23) | (1L << 24) | (1L << 26) | (1L << 27) | (1L << 28) | (1L << 30) | (1L << 32) | (1L << 33) | (1L << 34) | (1L << 35) | (1L << 36) | (1L << 37) | (1L << 38) | (1L << 39) | (1L << 40) | (1L << 41) | (1L << 42) | (1L << 43) | (1L << 44) | (1L << 45) | (1L << 46) | (1L << 47) | (1L << 48) | (1L << 50) | (1L << 51) | (1L << 52) | (1L << 53) | (1L << 54) | (1L << 55) | (1L << 56) | (1L << 57) | (1L << 58) | (1L << IF) | (1L << ELSE) | (1L << FOR) | (1L << WHILE) | (1L << BREAK))) != 0) || ((((_la - 64)) & ~0x3f) == 0 && ((1L << (_la - 64)) & ((1L << (CASE - 64)) | (1L << (CONTINUE - 64)) | (1L << (SWITCH - 64)) | (1L << (GOTO - 64)) | (1L << (RETURN - 64)) | (1L << (TYPEDEF - 64)) | (1L << (VOID - 64)) | (1L << (UNSIGNED - 64)) | (1L << (SIGNED - 64)) | (1L << (LONG - 64)) | (1L << (CV_QUALIFIER - 64)) | (1L << (VIRTUAL - 64)) | (1L << (TRY - 64)) | (1L << (CATCH - 64)) | (1L << (THROW - 64)) | (1L << (USING - 64)) | (1L << (NAMESPACE - 64)) | (1L << (AUTO - 64)) | (1L << (REGISTER - 64)) | (1L << (OPERATOR - 64)) | (1L << (TEMPLATE - 64)) | (1L << (ALPHA_NUMERIC - 64)) | (1L << (PRE_IF - 64)) | (1L << (PRE_ELSE - 64)) | (1L << (PRE_ENDIF - 64)) | (1L << (HEX_LITERAL - 64)) | (1L << (DECIMAL_LITERAL - 64)) | (1L << (OCTAL_LITERAL - 64)) | (1L << (FLOATING_POINT_LITERAL - 64)) | (1L << (CHAR - 64)) | (1L << (STRING - 64)) | (1L << (COMMENT - 64)) | (1L << (WHITESPACE - 64)) | (1L << (CPPCOMMENT - 64)) | (1L << (OTHER - 64)))) != 0)) {
					{
					{
					setState(490); assign_water();
					}
					}
					setState(495);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				}
				}
				setState(500);
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
			if ( listener instanceof SymbolsListener ) ((SymbolsListener)listener).enterAssign_expr_w__l2(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SymbolsListener ) ((SymbolsListener)listener).exitAssign_expr_w__l2(this);
		}
	}

	public final Assign_expr_w__l2Context assign_expr_w__l2() throws RecognitionException {
		Assign_expr_w__l2Context _localctx = new Assign_expr_w__l2Context(_ctx, getState());
		enterRule(_localctx, 108, RULE_assign_expr_w__l2);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(504);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << 1) | (1L << 3) | (1L << 4) | (1L << 5) | (1L << 6) | (1L << 7) | (1L << 8) | (1L << 9) | (1L << 10) | (1L << 11) | (1L << 12) | (1L << 14) | (1L << 15) | (1L << 16) | (1L << 17) | (1L << 18) | (1L << 19) | (1L << 20) | (1L << 21) | (1L << 22) | (1L << 23) | (1L << 24) | (1L << 26) | (1L << 27) | (1L << 28) | (1L << 29) | (1L << 30) | (1L << 32) | (1L << 33) | (1L << 34) | (1L << 35) | (1L << 36) | (1L << 37) | (1L << 38) | (1L << 39) | (1L << 40) | (1L << 41) | (1L << 42) | (1L << 43) | (1L << 44) | (1L << 45) | (1L << 46) | (1L << 47) | (1L << 48) | (1L << 49) | (1L << 50) | (1L << 51) | (1L << 52) | (1L << 53) | (1L << 54) | (1L << 55) | (1L << 56) | (1L << 57) | (1L << 58) | (1L << IF) | (1L << ELSE) | (1L << FOR) | (1L << WHILE) | (1L << BREAK))) != 0) || ((((_la - 64)) & ~0x3f) == 0 && ((1L << (_la - 64)) & ((1L << (CASE - 64)) | (1L << (CONTINUE - 64)) | (1L << (SWITCH - 64)) | (1L << (GOTO - 64)) | (1L << (RETURN - 64)) | (1L << (TYPEDEF - 64)) | (1L << (VOID - 64)) | (1L << (UNSIGNED - 64)) | (1L << (SIGNED - 64)) | (1L << (LONG - 64)) | (1L << (CV_QUALIFIER - 64)) | (1L << (VIRTUAL - 64)) | (1L << (TRY - 64)) | (1L << (CATCH - 64)) | (1L << (THROW - 64)) | (1L << (USING - 64)) | (1L << (NAMESPACE - 64)) | (1L << (AUTO - 64)) | (1L << (REGISTER - 64)) | (1L << (OPERATOR - 64)) | (1L << (TEMPLATE - 64)) | (1L << (ALPHA_NUMERIC - 64)) | (1L << (PRE_IF - 64)) | (1L << (PRE_ELSE - 64)) | (1L << (PRE_ENDIF - 64)) | (1L << (HEX_LITERAL - 64)) | (1L << (DECIMAL_LITERAL - 64)) | (1L << (OCTAL_LITERAL - 64)) | (1L << (FLOATING_POINT_LITERAL - 64)) | (1L << (CHAR - 64)) | (1L << (STRING - 64)) | (1L << (COMMENT - 64)) | (1L << (WHITESPACE - 64)) | (1L << (CPPCOMMENT - 64)) | (1L << (OTHER - 64)))) != 0)) {
				{
				{
				setState(501); assign_water_l2();
				}
				}
				setState(506);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(529);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==2 || _la==31 || _la==OPENING_CURLY) {
				{
				{
				setState(519);
				switch (_input.LA(1)) {
				case OPENING_CURLY:
					{
					setState(507); match(OPENING_CURLY);
					setState(508); assign_expr_w__l2();
					setState(509); match(CLOSING_CURLY);
					}
					break;
				case 31:
					{
					setState(511); match(31);
					setState(512); assign_expr_w__l2();
					setState(513); match(13);
					}
					break;
				case 2:
					{
					setState(515); match(2);
					setState(516); assign_expr_w__l2();
					setState(517); match(25);
					}
					break;
				default:
					throw new NoViableAltException(this);
				}
				setState(524);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << 1) | (1L << 3) | (1L << 4) | (1L << 5) | (1L << 6) | (1L << 7) | (1L << 8) | (1L << 9) | (1L << 10) | (1L << 11) | (1L << 12) | (1L << 14) | (1L << 15) | (1L << 16) | (1L << 17) | (1L << 18) | (1L << 19) | (1L << 20) | (1L << 21) | (1L << 22) | (1L << 23) | (1L << 24) | (1L << 26) | (1L << 27) | (1L << 28) | (1L << 29) | (1L << 30) | (1L << 32) | (1L << 33) | (1L << 34) | (1L << 35) | (1L << 36) | (1L << 37) | (1L << 38) | (1L << 39) | (1L << 40) | (1L << 41) | (1L << 42) | (1L << 43) | (1L << 44) | (1L << 45) | (1L << 46) | (1L << 47) | (1L << 48) | (1L << 49) | (1L << 50) | (1L << 51) | (1L << 52) | (1L << 53) | (1L << 54) | (1L << 55) | (1L << 56) | (1L << 57) | (1L << 58) | (1L << IF) | (1L << ELSE) | (1L << FOR) | (1L << WHILE) | (1L << BREAK))) != 0) || ((((_la - 64)) & ~0x3f) == 0 && ((1L << (_la - 64)) & ((1L << (CASE - 64)) | (1L << (CONTINUE - 64)) | (1L << (SWITCH - 64)) | (1L << (GOTO - 64)) | (1L << (RETURN - 64)) | (1L << (TYPEDEF - 64)) | (1L << (VOID - 64)) | (1L << (UNSIGNED - 64)) | (1L << (SIGNED - 64)) | (1L << (LONG - 64)) | (1L << (CV_QUALIFIER - 64)) | (1L << (VIRTUAL - 64)) | (1L << (TRY - 64)) | (1L << (CATCH - 64)) | (1L << (THROW - 64)) | (1L << (USING - 64)) | (1L << (NAMESPACE - 64)) | (1L << (AUTO - 64)) | (1L << (REGISTER - 64)) | (1L << (OPERATOR - 64)) | (1L << (TEMPLATE - 64)) | (1L << (ALPHA_NUMERIC - 64)) | (1L << (PRE_IF - 64)) | (1L << (PRE_ELSE - 64)) | (1L << (PRE_ENDIF - 64)) | (1L << (HEX_LITERAL - 64)) | (1L << (DECIMAL_LITERAL - 64)) | (1L << (OCTAL_LITERAL - 64)) | (1L << (FLOATING_POINT_LITERAL - 64)) | (1L << (CHAR - 64)) | (1L << (STRING - 64)) | (1L << (COMMENT - 64)) | (1L << (WHITESPACE - 64)) | (1L << (CPPCOMMENT - 64)) | (1L << (OTHER - 64)))) != 0)) {
					{
					{
					setState(521); assign_water_l2();
					}
					}
					setState(526);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				}
				}
				setState(531);
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
			if ( listener instanceof SymbolsListener ) ((SymbolsListener)listener).enterConstant_expr_w_(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SymbolsListener ) ((SymbolsListener)listener).exitConstant_expr_w_(this);
		}
	}

	public final Constant_expr_w_Context constant_expr_w_() throws RecognitionException {
		Constant_expr_w_Context _localctx = new Constant_expr_w_Context(_ctx, getState());
		enterRule(_localctx, 110, RULE_constant_expr_w_);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(535);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << 1) | (1L << 3) | (1L << 4) | (1L << 5) | (1L << 6) | (1L << 7) | (1L << 8) | (1L << 9) | (1L << 10) | (1L << 11) | (1L << 12) | (1L << 13) | (1L << 14) | (1L << 15) | (1L << 16) | (1L << 17) | (1L << 18) | (1L << 19) | (1L << 20) | (1L << 21) | (1L << 22) | (1L << 23) | (1L << 24) | (1L << 26) | (1L << 27) | (1L << 28) | (1L << 29) | (1L << 30) | (1L << 31) | (1L << 32) | (1L << 33) | (1L << 34) | (1L << 35) | (1L << 36) | (1L << 37) | (1L << 38) | (1L << 39) | (1L << 40) | (1L << 41) | (1L << 42) | (1L << 43) | (1L << 44) | (1L << 45) | (1L << 46) | (1L << 47) | (1L << 48) | (1L << 49) | (1L << 50) | (1L << 51) | (1L << 52) | (1L << 53) | (1L << 54) | (1L << 55) | (1L << 56) | (1L << 57) | (1L << 58) | (1L << IF) | (1L << ELSE) | (1L << FOR) | (1L << WHILE) | (1L << BREAK))) != 0) || ((((_la - 64)) & ~0x3f) == 0 && ((1L << (_la - 64)) & ((1L << (CASE - 64)) | (1L << (CONTINUE - 64)) | (1L << (SWITCH - 64)) | (1L << (GOTO - 64)) | (1L << (RETURN - 64)) | (1L << (TYPEDEF - 64)) | (1L << (VOID - 64)) | (1L << (UNSIGNED - 64)) | (1L << (SIGNED - 64)) | (1L << (LONG - 64)) | (1L << (CV_QUALIFIER - 64)) | (1L << (VIRTUAL - 64)) | (1L << (TRY - 64)) | (1L << (CATCH - 64)) | (1L << (THROW - 64)) | (1L << (USING - 64)) | (1L << (NAMESPACE - 64)) | (1L << (AUTO - 64)) | (1L << (REGISTER - 64)) | (1L << (OPERATOR - 64)) | (1L << (TEMPLATE - 64)) | (1L << (ALPHA_NUMERIC - 64)) | (1L << (OPENING_CURLY - 64)) | (1L << (CLOSING_CURLY - 64)) | (1L << (PRE_IF - 64)) | (1L << (PRE_ELSE - 64)) | (1L << (PRE_ENDIF - 64)) | (1L << (HEX_LITERAL - 64)) | (1L << (DECIMAL_LITERAL - 64)) | (1L << (OCTAL_LITERAL - 64)) | (1L << (FLOATING_POINT_LITERAL - 64)) | (1L << (CHAR - 64)) | (1L << (STRING - 64)) | (1L << (COMMENT - 64)) | (1L << (WHITESPACE - 64)) | (1L << (CPPCOMMENT - 64)) | (1L << (OTHER - 64)))) != 0)) {
				{
				{
				setState(532); no_squares();
				}
				}
				setState(537);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(549);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==2) {
				{
				{
				setState(538); match(2);
				setState(539); constant_expr_w_();
				setState(540); match(25);
				setState(544);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << 1) | (1L << 3) | (1L << 4) | (1L << 5) | (1L << 6) | (1L << 7) | (1L << 8) | (1L << 9) | (1L << 10) | (1L << 11) | (1L << 12) | (1L << 13) | (1L << 14) | (1L << 15) | (1L << 16) | (1L << 17) | (1L << 18) | (1L << 19) | (1L << 20) | (1L << 21) | (1L << 22) | (1L << 23) | (1L << 24) | (1L << 26) | (1L << 27) | (1L << 28) | (1L << 29) | (1L << 30) | (1L << 31) | (1L << 32) | (1L << 33) | (1L << 34) | (1L << 35) | (1L << 36) | (1L << 37) | (1L << 38) | (1L << 39) | (1L << 40) | (1L << 41) | (1L << 42) | (1L << 43) | (1L << 44) | (1L << 45) | (1L << 46) | (1L << 47) | (1L << 48) | (1L << 49) | (1L << 50) | (1L << 51) | (1L << 52) | (1L << 53) | (1L << 54) | (1L << 55) | (1L << 56) | (1L << 57) | (1L << 58) | (1L << IF) | (1L << ELSE) | (1L << FOR) | (1L << WHILE) | (1L << BREAK))) != 0) || ((((_la - 64)) & ~0x3f) == 0 && ((1L << (_la - 64)) & ((1L << (CASE - 64)) | (1L << (CONTINUE - 64)) | (1L << (SWITCH - 64)) | (1L << (GOTO - 64)) | (1L << (RETURN - 64)) | (1L << (TYPEDEF - 64)) | (1L << (VOID - 64)) | (1L << (UNSIGNED - 64)) | (1L << (SIGNED - 64)) | (1L << (LONG - 64)) | (1L << (CV_QUALIFIER - 64)) | (1L << (VIRTUAL - 64)) | (1L << (TRY - 64)) | (1L << (CATCH - 64)) | (1L << (THROW - 64)) | (1L << (USING - 64)) | (1L << (NAMESPACE - 64)) | (1L << (AUTO - 64)) | (1L << (REGISTER - 64)) | (1L << (OPERATOR - 64)) | (1L << (TEMPLATE - 64)) | (1L << (ALPHA_NUMERIC - 64)) | (1L << (OPENING_CURLY - 64)) | (1L << (CLOSING_CURLY - 64)) | (1L << (PRE_IF - 64)) | (1L << (PRE_ELSE - 64)) | (1L << (PRE_ENDIF - 64)) | (1L << (HEX_LITERAL - 64)) | (1L << (DECIMAL_LITERAL - 64)) | (1L << (OCTAL_LITERAL - 64)) | (1L << (FLOATING_POINT_LITERAL - 64)) | (1L << (CHAR - 64)) | (1L << (STRING - 64)) | (1L << (COMMENT - 64)) | (1L << (WHITESPACE - 64)) | (1L << (CPPCOMMENT - 64)) | (1L << (OTHER - 64)))) != 0)) {
					{
					{
					setState(541); no_squares();
					}
					}
					setState(546);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				}
				}
				setState(551);
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
			if ( listener instanceof SymbolsListener ) ((SymbolsListener)listener).enterInitializer(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SymbolsListener ) ((SymbolsListener)listener).exitInitializer(this);
		}
	}

	public final InitializerContext initializer() throws RecognitionException {
		InitializerContext _localctx = new InitializerContext(_ctx, getState());
		enterRule(_localctx, 112, RULE_initializer);
		try {
			setState(557);
			switch (_input.LA(1)) {
			case 1:
			case 3:
			case 5:
			case 22:
			case 30:
			case 31:
			case 40:
			case 47:
			case 57:
			case ALPHA_NUMERIC:
			case HEX_LITERAL:
			case DECIMAL_LITERAL:
			case OCTAL_LITERAL:
			case FLOATING_POINT_LITERAL:
			case CHAR:
			case STRING:
				enterOuterAlt(_localctx, 1);
				{
				setState(552); assign_expr();
				}
				break;
			case OPENING_CURLY:
				enterOuterAlt(_localctx, 2);
				{
				setState(553); match(OPENING_CURLY);
				setState(554); initializer_list();
				setState(555); match(CLOSING_CURLY);
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
			if ( listener instanceof SymbolsListener ) ((SymbolsListener)listener).enterInitializer_list(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SymbolsListener ) ((SymbolsListener)listener).exitInitializer_list(this);
		}
	}

	public final Initializer_listContext initializer_list() throws RecognitionException {
		Initializer_listContext _localctx = new Initializer_listContext(_ctx, getState());
		enterRule(_localctx, 114, RULE_initializer_list);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(559); initializer();
			setState(564);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==29) {
				{
				{
				setState(560); match(29);
				setState(561); initializer();
				}
				}
				setState(566);
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
		public Class_keyContext class_key() {
			return getRuleContext(Class_keyContext.class,0);
		}
		public Class_nameContext class_name() {
			return getRuleContext(Class_nameContext.class,0);
		}
		public TerminalNode OPENING_CURLY() { return getToken(SymbolsParser.OPENING_CURLY, 0); }
		public Class_defContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_class_def; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof SymbolsListener ) ((SymbolsListener)listener).enterClass_def(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SymbolsListener ) ((SymbolsListener)listener).exitClass_def(this);
		}
	}

	public final Class_defContext class_def() throws RecognitionException {
		Class_defContext _localctx = new Class_defContext(_ctx, getState());
		enterRule(_localctx, 116, RULE_class_def);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(567); class_key();
			setState(569);
			_la = _input.LA(1);
			if (_la==ALPHA_NUMERIC) {
				{
				setState(568); class_name();
				}
			}

			setState(572);
			_la = _input.LA(1);
			if (_la==32) {
				{
				setState(571); base_classes();
				}
			}

			setState(574); match(OPENING_CURLY);
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
			if ( listener instanceof SymbolsListener ) ((SymbolsListener)listener).enterClass_name(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SymbolsListener ) ((SymbolsListener)listener).exitClass_name(this);
		}
	}

	public final Class_nameContext class_name() throws RecognitionException {
		Class_nameContext _localctx = new Class_nameContext(_ctx, getState());
		enterRule(_localctx, 118, RULE_class_name);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(577); identifier();
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
			if ( listener instanceof SymbolsListener ) ((SymbolsListener)listener).enterBase_classes(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SymbolsListener ) ((SymbolsListener)listener).exitBase_classes(this);
		}
	}

	public final Base_classesContext base_classes() throws RecognitionException {
		Base_classesContext _localctx = new Base_classesContext(_ctx, getState());
		enterRule(_localctx, 120, RULE_base_classes);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(579); match(32);
			setState(580); base_class();
			setState(585);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==29) {
				{
				{
				setState(581); match(29);
				setState(582); base_class();
				}
				}
				setState(587);
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
		public TerminalNode VIRTUAL() { return getToken(SymbolsParser.VIRTUAL, 0); }
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
			if ( listener instanceof SymbolsListener ) ((SymbolsListener)listener).enterBase_class(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SymbolsListener ) ((SymbolsListener)listener).exitBase_class(this);
		}
	}

	public final Base_classContext base_class() throws RecognitionException {
		Base_classContext _localctx = new Base_classContext(_ctx, getState());
		enterRule(_localctx, 122, RULE_base_class);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(589);
			_la = _input.LA(1);
			if (_la==VIRTUAL) {
				{
				setState(588); match(VIRTUAL);
				}
			}

			setState(592);
			_la = _input.LA(1);
			if ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << 28) | (1L << 34) | (1L << 48))) != 0)) {
				{
				setState(591); access_specifier();
				}
			}

			setState(594); identifier();
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
		public List<TerminalNode> CV_QUALIFIER() { return getTokens(SymbolsParser.CV_QUALIFIER); }
		public Template_param_listContext template_param_list(int i) {
			return getRuleContext(Template_param_listContext.class,i);
		}
		public TerminalNode SIGNED() { return getToken(SymbolsParser.SIGNED, 0); }
		public TerminalNode UNSIGNED() { return getToken(SymbolsParser.UNSIGNED, 0); }
		public List<Template_param_listContext> template_param_list() {
			return getRuleContexts(Template_param_listContext.class);
		}
		public Class_keyContext class_key() {
			return getRuleContext(Class_keyContext.class,0);
		}
		public Base_typeContext base_type(int i) {
			return getRuleContext(Base_typeContext.class,i);
		}
		public List<Base_typeContext> base_type() {
			return getRuleContexts(Base_typeContext.class);
		}
		public TerminalNode CV_QUALIFIER(int i) {
			return getToken(SymbolsParser.CV_QUALIFIER, i);
		}
		public Type_nameContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_type_name; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof SymbolsListener ) ((SymbolsListener)listener).enterType_name(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SymbolsListener ) ((SymbolsListener)listener).exitType_name(this);
		}
	}

	public final Type_nameContext type_name() throws RecognitionException {
		Type_nameContext _localctx = new Type_nameContext(_ctx, getState());
		enterRule(_localctx, 124, RULE_type_name);
		int _la;
		try {
			setState(628);
			switch ( getInterpreter().adaptivePredict(_input,63,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				{
				setState(599);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (_la==CV_QUALIFIER) {
					{
					{
					setState(596); match(CV_QUALIFIER);
					}
					}
					setState(601);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				setState(605);
				switch (_input.LA(1)) {
				case 12:
				case 20:
				case 23:
				case 42:
					{
					setState(602); class_key();
					}
					break;
				case UNSIGNED:
					{
					setState(603); match(UNSIGNED);
					}
					break;
				case SIGNED:
					{
					setState(604); match(SIGNED);
					}
					break;
				case VOID:
				case LONG:
				case ALPHA_NUMERIC:
					break;
				default:
					throw new NoViableAltException(this);
				}
				setState(607); base_type();
				setState(612);
				_la = _input.LA(1);
				if (_la==4) {
					{
					setState(608); match(4);
					setState(609); template_param_list();
					setState(610); match(52);
					}
				}

				setState(624);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (_la==16) {
					{
					{
					setState(614); match(16);
					setState(615); base_type();
					setState(620);
					_la = _input.LA(1);
					if (_la==4) {
						{
						setState(616); match(4);
						setState(617); template_param_list();
						setState(618); match(52);
						}
					}

					}
					}
					setState(626);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				}
				}
				break;

			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(627);
				_la = _input.LA(1);
				if ( !(_la==UNSIGNED || _la==SIGNED) ) {
				_errHandler.recoverInline(this);
				}
				consume();
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
			if ( listener instanceof SymbolsListener ) ((SymbolsListener)listener).enterType_suffix(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SymbolsListener ) ((SymbolsListener)listener).exitType_suffix(this);
		}
	}

	public final Type_suffixContext type_suffix() throws RecognitionException {
		Type_suffixContext _localctx = new Type_suffixContext(_ctx, getState());
		enterRule(_localctx, 126, RULE_type_suffix);
		try {
			setState(635);
			switch (_input.LA(1)) {
			case 2:
				enterOuterAlt(_localctx, 1);
				{
				{
				setState(630); match(2);
				setState(631); constant_expr_w_();
				setState(632); match(25);
				}
				}
				break;
			case 31:
				enterOuterAlt(_localctx, 2);
				{
				setState(634); param_type_list();
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

	public static class Base_typeContext extends ParserRuleContext {
		public TerminalNode VOID() { return getToken(SymbolsParser.VOID, 0); }
		public TerminalNode ALPHA_NUMERIC() { return getToken(SymbolsParser.ALPHA_NUMERIC, 0); }
		public TerminalNode LONG(int i) {
			return getToken(SymbolsParser.LONG, i);
		}
		public List<TerminalNode> LONG() { return getTokens(SymbolsParser.LONG); }
		public Base_typeContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_base_type; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof SymbolsListener ) ((SymbolsListener)listener).enterBase_type(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SymbolsListener ) ((SymbolsListener)listener).exitBase_type(this);
		}
	}

	public final Base_typeContext base_type() throws RecognitionException {
		Base_typeContext _localctx = new Base_typeContext(_ctx, getState());
		enterRule(_localctx, 128, RULE_base_type);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(642);
			switch ( getInterpreter().adaptivePredict(_input,65,_ctx) ) {
			case 1:
				{
				setState(637); match(ALPHA_NUMERIC);
				}
				break;

			case 2:
				{
				setState(638); match(VOID);
				}
				break;

			case 3:
				{
				setState(639); match(LONG);
				}
				break;

			case 4:
				{
				setState(640); match(LONG);
				setState(641); match(LONG);
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
		public TerminalNode REGISTER() { return getToken(SymbolsParser.REGISTER, 0); }
		public TerminalNode AUTO() { return getToken(SymbolsParser.AUTO, 0); }
		public Param_decl_specifiersContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_param_decl_specifiers; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof SymbolsListener ) ((SymbolsListener)listener).enterParam_decl_specifiers(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SymbolsListener ) ((SymbolsListener)listener).exitParam_decl_specifiers(this);
		}
	}

	public final Param_decl_specifiersContext param_decl_specifiers() throws RecognitionException {
		Param_decl_specifiersContext _localctx = new Param_decl_specifiersContext(_ctx, getState());
		enterRule(_localctx, 130, RULE_param_decl_specifiers);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(645);
			_la = _input.LA(1);
			if (_la==AUTO || _la==REGISTER) {
				{
				setState(644);
				_la = _input.LA(1);
				if ( !(_la==AUTO || _la==REGISTER) ) {
				_errHandler.recoverInline(this);
				}
				consume();
				}
			}

			setState(647); type_name();
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
			if ( listener instanceof SymbolsListener ) ((SymbolsListener)listener).enterParameter_name(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SymbolsListener ) ((SymbolsListener)listener).exitParameter_name(this);
		}
	}

	public final Parameter_nameContext parameter_name() throws RecognitionException {
		Parameter_nameContext _localctx = new Parameter_nameContext(_ctx, getState());
		enterRule(_localctx, 132, RULE_parameter_name);
		try {
			setState(651);
			switch (_input.LA(1)) {
			case ALPHA_NUMERIC:
				enterOuterAlt(_localctx, 1);
				{
				setState(649); identifier();
				}
				break;
			case 28:
			case 34:
			case 48:
				enterOuterAlt(_localctx, 2);
				{
				setState(650); access_specifier();
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
		public TerminalNode VOID() { return getToken(SymbolsParser.VOID, 0); }
		public Param_type_listContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_param_type_list; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof SymbolsListener ) ((SymbolsListener)listener).enterParam_type_list(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SymbolsListener ) ((SymbolsListener)listener).exitParam_type_list(this);
		}
	}

	public final Param_type_listContext param_type_list() throws RecognitionException {
		Param_type_listContext _localctx = new Param_type_listContext(_ctx, getState());
		enterRule(_localctx, 134, RULE_param_type_list);
		int _la;
		try {
			setState(668);
			switch ( getInterpreter().adaptivePredict(_input,70,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(653); match(31);
				setState(654); match(VOID);
				setState(655); match(13);
				}
				break;

			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(656); match(31);
				setState(665);
				_la = _input.LA(1);
				if ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << 12) | (1L << 20) | (1L << 23) | (1L << 42))) != 0) || ((((_la - 70)) & ~0x3f) == 0 && ((1L << (_la - 70)) & ((1L << (VOID - 70)) | (1L << (UNSIGNED - 70)) | (1L << (SIGNED - 70)) | (1L << (LONG - 70)) | (1L << (CV_QUALIFIER - 70)) | (1L << (AUTO - 70)) | (1L << (REGISTER - 70)) | (1L << (ALPHA_NUMERIC - 70)))) != 0)) {
					{
					setState(657); param_type();
					setState(662);
					_errHandler.sync(this);
					_la = _input.LA(1);
					while (_la==29) {
						{
						{
						setState(658); match(29);
						setState(659); param_type();
						}
						}
						setState(664);
						_errHandler.sync(this);
						_la = _input.LA(1);
					}
					}
				}

				setState(667); match(13);
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
			if ( listener instanceof SymbolsListener ) ((SymbolsListener)listener).enterParam_type(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SymbolsListener ) ((SymbolsListener)listener).exitParam_type(this);
		}
	}

	public final Param_typeContext param_type() throws RecognitionException {
		Param_typeContext _localctx = new Param_typeContext(_ctx, getState());
		enterRule(_localctx, 136, RULE_param_type);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(670); param_decl_specifiers();
			setState(671); param_type_id();
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
			if ( listener instanceof SymbolsListener ) ((SymbolsListener)listener).enterParam_type_id(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SymbolsListener ) ((SymbolsListener)listener).exitParam_type_id(this);
		}
	}

	public final Param_type_idContext param_type_id() throws RecognitionException {
		Param_type_idContext _localctx = new Param_type_idContext(_ctx, getState());
		enterRule(_localctx, 138, RULE_param_type_id);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(674);
			_la = _input.LA(1);
			if (_la==1 || _la==3) {
				{
				setState(673); ptrs();
				}
			}

			setState(683);
			switch ( getInterpreter().adaptivePredict(_input,73,_ctx) ) {
			case 1:
				{
				setState(676); match(31);
				setState(677); param_type_id();
				setState(678); match(13);
				}
				break;

			case 2:
				{
				setState(681);
				_la = _input.LA(1);
				if (((((_la - 28)) & ~0x3f) == 0 && ((1L << (_la - 28)) & ((1L << (28 - 28)) | (1L << (34 - 28)) | (1L << (48 - 28)) | (1L << (ALPHA_NUMERIC - 28)))) != 0)) {
					{
					setState(680); parameter_name();
					}
				}

				}
				break;
			}
			setState(686);
			_la = _input.LA(1);
			if (_la==2 || _la==31) {
				{
				setState(685); type_suffix();
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
			return getToken(SymbolsParser.ALPHA_NUMERIC, i);
		}
		public List<TerminalNode> ALPHA_NUMERIC() { return getTokens(SymbolsParser.ALPHA_NUMERIC); }
		public IdentifierContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_identifier; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof SymbolsListener ) ((SymbolsListener)listener).enterIdentifier(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SymbolsListener ) ((SymbolsListener)listener).exitIdentifier(this);
		}
	}

	public final IdentifierContext identifier() throws RecognitionException {
		IdentifierContext _localctx = new IdentifierContext(_ctx, getState());
		enterRule(_localctx, 140, RULE_identifier);
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(688); match(ALPHA_NUMERIC);
			setState(693);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,75,_ctx);
			while ( _alt!=2 && _alt!=-1 ) {
				if ( _alt==1 ) {
					{
					{
					setState(689); match(16);
					setState(690); match(ALPHA_NUMERIC);
					}
					} 
				}
				setState(695);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,75,_ctx);
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
		public TerminalNode OCTAL_LITERAL() { return getToken(SymbolsParser.OCTAL_LITERAL, 0); }
		public TerminalNode HEX_LITERAL() { return getToken(SymbolsParser.HEX_LITERAL, 0); }
		public TerminalNode DECIMAL_LITERAL() { return getToken(SymbolsParser.DECIMAL_LITERAL, 0); }
		public NumberContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_number; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof SymbolsListener ) ((SymbolsListener)listener).enterNumber(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SymbolsListener ) ((SymbolsListener)listener).exitNumber(this);
		}
	}

	public final NumberContext number() throws RecognitionException {
		NumberContext _localctx = new NumberContext(_ctx, getState());
		enterRule(_localctx, 142, RULE_number);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(696);
			_la = _input.LA(1);
			if ( !(((((_la - 91)) & ~0x3f) == 0 && ((1L << (_la - 91)) & ((1L << (HEX_LITERAL - 91)) | (1L << (DECIMAL_LITERAL - 91)) | (1L << (OCTAL_LITERAL - 91)))) != 0)) ) {
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
			if ( listener instanceof SymbolsListener ) ((SymbolsListener)listener).enterPtrs(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SymbolsListener ) ((SymbolsListener)listener).exitPtrs(this);
		}
	}

	public final PtrsContext ptrs() throws RecognitionException {
		PtrsContext _localctx = new PtrsContext(_ctx, getState());
		enterRule(_localctx, 144, RULE_ptrs);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(699); 
			_errHandler.sync(this);
			_la = _input.LA(1);
			do {
				{
				{
				setState(698); ptr_operator();
				}
				}
				setState(701); 
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
		"\2\3f\u02c2\4\2\t\2\4\3\t\3\4\4\t\4\4\5\t\5\4\6\t\6\4\7\t\7\4\b\t\b\4"+
		"\t\t\t\4\n\t\n\4\13\t\13\4\f\t\f\4\r\t\r\4\16\t\16\4\17\t\17\4\20\t\20"+
		"\4\21\t\21\4\22\t\22\4\23\t\23\4\24\t\24\4\25\t\25\4\26\t\26\4\27\t\27"+
		"\4\30\t\30\4\31\t\31\4\32\t\32\4\33\t\33\4\34\t\34\4\35\t\35\4\36\t\36"+
		"\4\37\t\37\4 \t \4!\t!\4\"\t\"\4#\t#\4$\t$\4%\t%\4&\t&\4\'\t\'\4(\t(\4"+
		")\t)\4*\t*\4+\t+\4,\t,\4-\t-\4.\t.\4/\t/\4\60\t\60\4\61\t\61\4\62\t\62"+
		"\4\63\t\63\4\64\t\64\4\65\t\65\4\66\t\66\4\67\t\67\48\t8\49\t9\4:\t:\4"+
		";\t;\4<\t<\4=\t=\4>\t>\4?\t?\4@\t@\4A\tA\4B\tB\4C\tC\4D\tD\4E\tE\4F\t"+
		"F\4G\tG\4H\tH\4I\tI\4J\tJ\3\2\7\2\u0096\n\2\f\2\16\2\u0099\13\2\3\2\3"+
		"\2\3\3\3\3\3\3\5\3\u00a0\n\3\3\4\3\4\3\5\3\5\3\6\3\6\3\7\3\7\3\b\3\b\3"+
		"\t\3\t\3\n\3\n\3\13\3\13\3\13\3\f\3\f\3\f\5\f\u00b6\n\f\3\f\3\f\3\f\3"+
		"\f\3\f\3\f\3\f\3\f\3\f\3\f\3\f\3\f\3\f\3\f\3\f\3\f\3\f\3\f\3\f\3\f\3\f"+
		"\3\f\3\f\3\f\3\f\3\f\3\f\3\f\3\f\3\f\3\f\3\f\3\f\3\f\3\f\3\f\3\f\3\f\3"+
		"\f\3\f\5\f\u00e0\n\f\3\r\3\r\3\16\3\16\3\17\3\17\3\17\3\17\3\17\3\20\3"+
		"\20\3\20\3\20\3\20\3\20\3\20\3\20\3\20\7\20\u00f4\n\20\f\20\16\20\u00f7"+
		"\13\20\3\21\3\21\3\22\3\22\3\23\3\23\3\24\3\24\3\25\3\25\3\26\3\26\3\27"+
		"\3\27\3\30\3\30\3\31\3\31\3\32\3\32\3\33\3\33\3\34\3\34\3\34\5\34\u0112"+
		"\n\34\3\35\3\35\3\35\3\35\5\35\u0118\n\35\3\36\3\36\3\36\3\36\3\36\3\36"+
		"\5\36\u0120\n\36\3\37\3\37\3\37\5\37\u0125\n\37\3 \3 \3 \5 \u012a\n \3"+
		"!\3!\3!\5!\u012f\n!\3\"\3\"\3\"\5\"\u0134\n\"\3#\3#\3#\5#\u0139\n#\3$"+
		"\3$\3$\3$\5$\u013f\n$\3%\3%\3%\3%\5%\u0145\n%\3&\3&\3&\5&\u014a\n&\3\'"+
		"\3\'\3\'\5\'\u014f\n\'\3(\3(\3(\5(\u0154\n(\3)\3)\3)\7)\u0159\n)\f)\16"+
		")\u015c\13)\3)\3)\3)\3)\5)\u0162\n)\3*\3*\3*\3*\3*\3*\6*\u016a\n*\r*\16"+
		"*\u016b\3*\3*\5*\u0170\n*\3+\3+\3+\3+\5+\u0176\n+\3,\3,\7,\u017a\n,\f"+
		",\16,\u017d\13,\3-\3-\3-\3-\5-\u0183\n-\3.\3.\3.\3.\3/\3/\3/\3/\7/\u018d"+
		"\n/\f/\16/\u0190\13/\5/\u0192\n/\3/\3/\3\60\3\60\3\61\3\61\3\61\3\61\3"+
		"\61\3\61\3\61\3\61\5\61\u01a0\n\61\3\61\3\61\5\61\u01a4\n\61\3\62\3\62"+
		"\3\62\3\62\3\62\3\62\5\62\u01ac\n\62\3\63\5\63\u01af\n\63\3\63\5\63\u01b2"+
		"\n\63\3\63\3\63\3\64\3\64\3\64\3\64\3\64\5\64\u01bb\n\64\5\64\u01bd\n"+
		"\64\3\65\3\65\3\65\7\65\u01c2\n\65\f\65\16\65\u01c5\13\65\3\65\3\65\3"+
		"\66\5\66\u01ca\n\66\3\66\3\66\5\66\u01ce\n\66\3\66\3\66\5\66\u01d2\n\66"+
		"\3\66\3\66\3\66\5\66\u01d7\n\66\3\67\7\67\u01da\n\67\f\67\16\67\u01dd"+
		"\13\67\3\67\3\67\3\67\3\67\3\67\3\67\3\67\3\67\3\67\3\67\3\67\3\67\5\67"+
		"\u01eb\n\67\3\67\7\67\u01ee\n\67\f\67\16\67\u01f1\13\67\7\67\u01f3\n\67"+
		"\f\67\16\67\u01f6\13\67\38\78\u01f9\n8\f8\168\u01fc\138\38\38\38\38\3"+
		"8\38\38\38\38\38\38\38\58\u020a\n8\38\78\u020d\n8\f8\168\u0210\138\78"+
		"\u0212\n8\f8\168\u0215\138\39\79\u0218\n9\f9\169\u021b\139\39\39\39\3"+
		"9\79\u0221\n9\f9\169\u0224\139\79\u0226\n9\f9\169\u0229\139\3:\3:\3:\3"+
		":\3:\5:\u0230\n:\3;\3;\3;\7;\u0235\n;\f;\16;\u0238\13;\3<\3<\5<\u023c"+
		"\n<\3<\5<\u023f\n<\3<\3<\3<\3=\3=\3>\3>\3>\3>\7>\u024a\n>\f>\16>\u024d"+
		"\13>\3?\5?\u0250\n?\3?\5?\u0253\n?\3?\3?\3@\7@\u0258\n@\f@\16@\u025b\13"+
		"@\3@\3@\3@\5@\u0260\n@\3@\3@\3@\3@\3@\5@\u0267\n@\3@\3@\3@\3@\3@\3@\5"+
		"@\u026f\n@\7@\u0271\n@\f@\16@\u0274\13@\3@\5@\u0277\n@\3A\3A\3A\3A\3A"+
		"\5A\u027e\nA\3B\3B\3B\3B\3B\5B\u0285\nB\3C\5C\u0288\nC\3C\3C\3D\3D\5D"+
		"\u028e\nD\3E\3E\3E\3E\3E\3E\3E\7E\u0297\nE\fE\16E\u029a\13E\5E\u029c\n"+
		"E\3E\5E\u029f\nE\3F\3F\3F\3G\5G\u02a5\nG\3G\3G\3G\3G\3G\5G\u02ac\nG\5"+
		"G\u02ae\nG\3G\5G\u02b1\nG\3H\3H\3H\7H\u02b6\nH\fH\16H\u02b9\13H\3I\3I"+
		"\3J\6J\u02be\nJ\rJ\16J\u02bf\3J\2K\2\4\6\b\n\f\16\20\22\24\26\30\32\34"+
		"\36 \"$&(*,.\60\62\64\668:<>@BDFHJLNPRTVXZ\\^`bdfhjlnprtvxz|~\u0080\u0082"+
		"\u0084\u0086\u0088\u008a\u008c\u008e\u0090\u0092\2\34\b\3\3\5\5\30\30"+
		"  \61\61;;\6\6\6\t\t\66\66<<\3]b\6\20\21))++MM\6\16\16\26\26\31\31,,\4"+
		"\3\3\5\5\5\36\36$$\62\62\4\25\25//\t\r\r\23\24\32\32\34\34##&(\678\4\b"+
		"\b99\4\17\17!!\7\4\4\17\17\33\33!!XY\5\17\17!!\63\63\6\6\6\17\17!!\66"+
		"\66\3XY\4\4\4\33\33\5\4\4\33\33\63\63\4\37\37\63\63\t\4\4\17\17\33\33"+
		"\37\37!!\63\63XY\7\4\4\17\17\33\33!!XY\4\n\n--\4  \61\61\5\5\5\13\13:"+
		":\3IJ\3ST\3]_\u02f8\2\u0097\3\2\2\2\4\u009f\3\2\2\2\6\u00a1\3\2\2\2\b"+
		"\u00a3\3\2\2\2\n\u00a5\3\2\2\2\f\u00a7\3\2\2\2\16\u00a9\3\2\2\2\20\u00ab"+
		"\3\2\2\2\22\u00ad\3\2\2\2\24\u00af\3\2\2\2\26\u00df\3\2\2\2\30\u00e1\3"+
		"\2\2\2\32\u00e3\3\2\2\2\34\u00e5\3\2\2\2\36\u00f5\3\2\2\2 \u00f8\3\2\2"+
		"\2\"\u00fa\3\2\2\2$\u00fc\3\2\2\2&\u00fe\3\2\2\2(\u0100\3\2\2\2*\u0102"+
		"\3\2\2\2,\u0104\3\2\2\2.\u0106\3\2\2\2\60\u0108\3\2\2\2\62\u010a\3\2\2"+
		"\2\64\u010c\3\2\2\2\66\u010e\3\2\2\28\u0113\3\2\2\2:\u0119\3\2\2\2<\u0121"+
		"\3\2\2\2>\u0126\3\2\2\2@\u012b\3\2\2\2B\u0130\3\2\2\2D\u0135\3\2\2\2F"+
		"\u013a\3\2\2\2H\u0140\3\2\2\2J\u0146\3\2\2\2L\u014b\3\2\2\2N\u0150\3\2"+
		"\2\2P\u0161\3\2\2\2R\u016f\3\2\2\2T\u0175\3\2\2\2V\u0177\3\2\2\2X\u0182"+
		"\3\2\2\2Z\u0184\3\2\2\2\\\u0188\3\2\2\2^\u0195\3\2\2\2`\u01a3\3\2\2\2"+
		"b\u01ab\3\2\2\2d\u01ae\3\2\2\2f\u01bc\3\2\2\2h\u01be\3\2\2\2j\u01c9\3"+
		"\2\2\2l\u01db\3\2\2\2n\u01fa\3\2\2\2p\u0219\3\2\2\2r\u022f\3\2\2\2t\u0231"+
		"\3\2\2\2v\u0239\3\2\2\2x\u0243\3\2\2\2z\u0245\3\2\2\2|\u024f\3\2\2\2~"+
		"\u0276\3\2\2\2\u0080\u027d\3\2\2\2\u0082\u0284\3\2\2\2\u0084\u0287\3\2"+
		"\2\2\u0086\u028d\3\2\2\2\u0088\u029e\3\2\2\2\u008a\u02a0\3\2\2\2\u008c"+
		"\u02a4\3\2\2\2\u008e\u02b2\3\2\2\2\u0090\u02ba\3\2\2\2\u0092\u02bd\3\2"+
		"\2\2\u0094\u0096\5\4\3\2\u0095\u0094\3\2\2\2\u0096\u0099\3\2\2\2\u0097"+
		"\u0095\3\2\2\2\u0097\u0098\3\2\2\2\u0098\u009a\3\2\2\2\u0099\u0097\3\2"+
		"\2\2\u009a\u009b\7\1\2\2\u009b\3\3\2\2\2\u009c\u00a0\5R*\2\u009d\u00a0"+
		"\5d\63\2\u009e\u00a0\5\64\33\2\u009f\u009c\3\2\2\2\u009f\u009d\3\2\2\2"+
		"\u009f\u009e\3\2\2\2\u00a0\5\3\2\2\2\u00a1\u00a2\t\2\2\2\u00a2\7\3\2\2"+
		"\2\u00a3\u00a4\t\3\2\2\u00a4\t\3\2\2\2\u00a5\u00a6\t\4\2\2\u00a6\13\3"+
		"\2\2\2\u00a7\u00a8\t\5\2\2\u00a8\r\3\2\2\2\u00a9\u00aa\t\6\2\2\u00aa\17"+
		"\3\2\2\2\u00ab\u00ac\t\7\2\2\u00ac\21\3\2\2\2\u00ad\u00ae\t\b\2\2\u00ae"+
		"\23\3\2\2\2\u00af\u00b0\7U\2\2\u00b0\u00b1\5\26\f\2\u00b1\25\3\2\2\2\u00b2"+
		"\u00b5\t\t\2\2\u00b3\u00b4\7\4\2\2\u00b4\u00b6\7\33\2\2\u00b5\u00b3\3"+
		"\2\2\2\u00b5\u00b6\3\2\2\2\u00b6\u00e0\3\2\2\2\u00b7\u00e0\7\61\2\2\u00b8"+
		"\u00e0\7 \2\2\u00b9\u00e0\7\5\2\2\u00ba\u00e0\7:\2\2\u00bb\u00e0\7\13"+
		"\2\2\u00bc\u00e0\7.\2\2\u00bd\u00e0\7\3\2\2\u00be\u00e0\7\27\2\2\u00bf"+
		"\u00e0\7;\2\2\u00c0\u00e0\7\30\2\2\u00c1\u00e0\7\23\2\2\u00c2\u00e0\7"+
		"\6\2\2\u00c3\u00e0\7\66\2\2\u00c4\u00e0\7\'\2\2\u00c5\u00e0\7\34\2\2\u00c6"+
		"\u00e0\7\r\2\2\u00c7\u00e0\78\2\2\u00c8\u00e0\7\67\2\2\u00c9\u00e0\7("+
		"\2\2\u00ca\u00e0\7#\2\2\u00cb\u00e0\7\24\2\2\u00cc\u00e0\7-\2\2\u00cd"+
		"\u00e0\7\n\2\2\u00ce\u00e0\7&\2\2\u00cf\u00e0\7\32\2\2\u00d0\u00e0\79"+
		"\2\2\u00d1\u00e0\7\b\2\2\u00d2\u00e0\7\t\2\2\u00d3\u00e0\7<\2\2\u00d4"+
		"\u00e0\7\64\2\2\u00d5\u00e0\7\65\2\2\u00d6\u00e0\7*\2\2\u00d7\u00e0\7"+
		"\7\2\2\u00d8\u00e0\7\37\2\2\u00d9\u00e0\7\35\2\2\u00da\u00e0\7\f\2\2\u00db"+
		"\u00dc\7!\2\2\u00dc\u00e0\7\17\2\2\u00dd\u00de\7\4\2\2\u00de\u00e0\7\33"+
		"\2\2\u00df\u00b2\3\2\2\2\u00df\u00b7\3\2\2\2\u00df\u00b8\3\2\2\2\u00df"+
		"\u00b9\3\2\2\2\u00df\u00ba\3\2\2\2\u00df\u00bb\3\2\2\2\u00df\u00bc\3\2"+
		"\2\2\u00df\u00bd\3\2\2\2\u00df\u00be\3\2\2\2\u00df\u00bf\3\2\2\2\u00df"+
		"\u00c0\3\2\2\2\u00df\u00c1\3\2\2\2\u00df\u00c2\3\2\2\2\u00df\u00c3\3\2"+
		"\2\2\u00df\u00c4\3\2\2\2\u00df\u00c5\3\2\2\2\u00df\u00c6\3\2\2\2\u00df"+
		"\u00c7\3\2\2\2\u00df\u00c8\3\2\2\2\u00df\u00c9\3\2\2\2\u00df\u00ca\3\2"+
		"\2\2\u00df\u00cb\3\2\2\2\u00df\u00cc\3\2\2\2\u00df\u00cd\3\2\2\2\u00df"+
		"\u00ce\3\2\2\2\u00df\u00cf\3\2\2\2\u00df\u00d0\3\2\2\2\u00df\u00d1\3\2"+
		"\2\2\u00df\u00d2\3\2\2\2\u00df\u00d3\3\2\2\2\u00df\u00d4\3\2\2\2\u00df"+
		"\u00d5\3\2\2\2\u00df\u00d6\3\2\2\2\u00df\u00d7\3\2\2\2\u00df\u00d8\3\2"+
		"\2\2\u00df\u00d9\3\2\2\2\u00df\u00da\3\2\2\2\u00df\u00db\3\2\2\2\u00df"+
		"\u00dd\3\2\2\2\u00e0\27\3\2\2\2\u00e1\u00e2\t\n\2\2\u00e2\31\3\2\2\2\u00e3"+
		"\u00e4\t\13\2\2\u00e4\33\3\2\2\2\u00e5\u00e6\7V\2\2\u00e6\u00e7\7\6\2"+
		"\2\u00e7\u00e8\5\36\20\2\u00e8\u00e9\7\66\2\2\u00e9\35\3\2\2\2\u00ea\u00eb"+
		"\7\6\2\2\u00eb\u00ec\5\36\20\2\u00ec\u00ed\7\66\2\2\u00ed\u00f4\3\2\2"+
		"\2\u00ee\u00ef\7!\2\2\u00ef\u00f0\5\36\20\2\u00f0\u00f1\7\17\2\2\u00f1"+
		"\u00f4\3\2\2\2\u00f2\u00f4\5&\24\2\u00f3\u00ea\3\2\2\2\u00f3\u00ee\3\2"+
		"\2\2\u00f3\u00f2\3\2\2\2\u00f4\u00f7\3\2\2\2\u00f5\u00f3\3\2\2\2\u00f5"+
		"\u00f6\3\2\2\2\u00f6\37\3\2\2\2\u00f7\u00f5\3\2\2\2\u00f8\u00f9\n\f\2"+
		"\2\u00f9!\3\2\2\2\u00fa\u00fb\n\r\2\2\u00fb#\3\2\2\2\u00fc\u00fd\n\16"+
		"\2\2\u00fd%\3\2\2\2\u00fe\u00ff\n\17\2\2\u00ff\'\3\2\2\2\u0100\u0101\n"+
		"\20\2\2\u0101)\3\2\2\2\u0102\u0103\n\21\2\2\u0103+\3\2\2\2\u0104\u0105"+
		"\n\22\2\2\u0105-\3\2\2\2\u0106\u0107\n\23\2\2\u0107/\3\2\2\2\u0108\u0109"+
		"\n\24\2\2\u0109\61\3\2\2\2\u010a\u010b\n\25\2\2\u010b\63\3\2\2\2\u010c"+
		"\u010d\13\2\2\2\u010d\65\3\2\2\2\u010e\u0111\58\35\2\u010f\u0110\7\37"+
		"\2\2\u0110\u0112\58\35\2\u0111\u010f\3\2\2\2\u0111\u0112\3\2\2\2\u0112"+
		"\67\3\2\2\2\u0113\u0117\5:\36\2\u0114\u0115\5\30\r\2\u0115\u0116\58\35"+
		"\2\u0116\u0118\3\2\2\2\u0117\u0114\3\2\2\2\u0117\u0118\3\2\2\2\u01189"+
		"\3\2\2\2\u0119\u011f\5<\37\2\u011a\u011b\7%\2\2\u011b\u011c\5\66\34\2"+
		"\u011c\u011d\7\"\2\2\u011d\u011e\5:\36\2\u011e\u0120\3\2\2\2\u011f\u011a"+
		"\3\2\2\2\u011f\u0120\3\2\2\2\u0120;\3\2\2\2\u0121\u0124\5> \2\u0122\u0123"+
		"\7\65\2\2\u0123\u0125\5<\37\2\u0124\u0122\3\2\2\2\u0124\u0125\3\2\2\2"+
		"\u0125=\3\2\2\2\u0126\u0129\5@!\2\u0127\u0128\7\64\2\2\u0128\u012a\5>"+
		" \2\u0129\u0127\3\2\2\2\u0129\u012a\3\2\2\2\u012a?\3\2\2\2\u012b\u012e"+
		"\5B\"\2\u012c\u012d\7\27\2\2\u012d\u012f\5@!\2\u012e\u012c\3\2\2\2\u012e"+
		"\u012f\3\2\2\2\u012fA\3\2\2\2\u0130\u0133\5D#\2\u0131\u0132\7.\2\2\u0132"+
		"\u0134\5B\"\2\u0133\u0131\3\2\2\2\u0133\u0134\3\2\2\2\u0134C\3\2\2\2\u0135"+
		"\u0138\5F$\2\u0136\u0137\7\3\2\2\u0137\u0139\5D#\2\u0138\u0136\3\2\2\2"+
		"\u0138\u0139\3\2\2\2\u0139E\3\2\2\2\u013a\u013e\5H%\2\u013b\u013c\5\32"+
		"\16\2\u013c\u013d\5F$\2\u013d\u013f\3\2\2\2\u013e\u013b\3\2\2\2\u013e"+
		"\u013f\3\2\2\2\u013fG\3\2\2\2\u0140\u0144\5J&\2\u0141\u0142\5\b\5\2\u0142"+
		"\u0143\5H%\2\u0143\u0145\3\2\2\2\u0144\u0141\3\2\2\2\u0144\u0145\3\2\2"+
		"\2\u0145I\3\2\2\2\u0146\u0149\5L\'\2\u0147\u0148\t\26\2\2\u0148\u014a"+
		"\5J&\2\u0149\u0147\3\2\2\2\u0149\u014a\3\2\2\2\u014aK\3\2\2\2\u014b\u014e"+
		"\5N(\2\u014c\u014d\t\27\2\2\u014d\u014f\5L\'\2\u014e\u014c\3\2\2\2\u014e"+
		"\u014f\3\2\2\2\u014fM\3\2\2\2\u0150\u0153\5P)\2\u0151\u0152\t\30\2\2\u0152"+
		"\u0154\5P)\2\u0153\u0151\3\2\2\2\u0153\u0154\3\2\2\2\u0154O\3\2\2\2\u0155"+
		"\u0156\7!\2\2\u0156\u015a\5~@\2\u0157\u0159\5\20\t\2\u0158\u0157\3\2\2"+
		"\2\u0159\u015c\3\2\2\2\u015a\u0158\3\2\2\2\u015a\u015b\3\2\2\2\u015b\u015d"+
		"\3\2\2\2\u015c\u015a\3\2\2\2\u015d\u015e\7\17\2\2\u015e\u015f\5P)\2\u015f"+
		"\u0162\3\2\2\2\u0160\u0162\5R*\2\u0161\u0155\3\2\2\2\u0161\u0160\3\2\2"+
		"\2\u0162Q\3\2\2\2\u0163\u0170\5T+\2\u0164\u0165\7\7\2\2\u0165\u0170\5"+
		"R*\2\u0166\u0167\7*\2\2\u0167\u0170\5R*\2\u0168\u016a\5\6\4\2\u0169\u0168"+
		"\3\2\2\2\u016a\u016b\3\2\2\2\u016b\u0169\3\2\2\2\u016b\u016c\3\2\2\2\u016c"+
		"\u016d\3\2\2\2\u016d\u016e\5T+\2\u016e\u0170\3\2\2\2\u016f\u0163\3\2\2"+
		"\2\u016f\u0164\3\2\2\2\u016f\u0166\3\2\2\2\u016f\u0169\3\2\2\2\u0170S"+
		"\3\2\2\2\u0171\u0172\5V,\2\u0172\u0173\5X-\2\u0173\u0176\3\2\2\2\u0174"+
		"\u0176\5V,\2\u0175\u0171\3\2\2\2\u0175\u0174\3\2\2\2\u0176U\3\2\2\2\u0177"+
		"\u017b\5b\62\2\u0178\u017a\5`\61\2\u0179\u0178\3\2\2\2\u017a\u017d\3\2"+
		"\2\2\u017b\u0179\3\2\2\2\u017b\u017c\3\2\2\2\u017cW\3\2\2\2\u017d\u017b"+
		"\3\2\2\2\u017e\u017f\5Z.\2\u017f\u0180\5\\/\2\u0180\u0183\3\2\2\2\u0181"+
		"\u0183\5\\/\2\u0182\u017e\3\2\2\2\u0182\u0181\3\2\2\2\u0183Y\3\2\2\2\u0184"+
		"\u0185\7\6\2\2\u0185\u0186\5\36\20\2\u0186\u0187\7\66\2\2\u0187[\3\2\2"+
		"\2\u0188\u0191\7!\2\2\u0189\u018e\5^\60\2\u018a\u018b\7\37\2\2\u018b\u018d"+
		"\5^\60\2\u018c\u018a\3\2\2\2\u018d\u0190\3\2\2\2\u018e\u018c\3\2\2\2\u018e"+
		"\u018f\3\2\2\2\u018f\u0192\3\2\2\2\u0190\u018e\3\2\2\2\u0191\u0189\3\2"+
		"\2\2\u0191\u0192\3\2\2\2\u0192\u0193\3\2\2\2\u0193\u0194\7\17\2\2\u0194"+
		"]\3\2\2\2\u0195\u0196\58\35\2\u0196_\3\2\2\2\u0197\u0198\7\60\2\2\u0198"+
		"\u01a0\5\u008eH\2\u0199\u019a\7\f\2\2\u019a\u01a0\5\u008eH\2\u019b\u019c"+
		"\7\4\2\2\u019c\u019d\5\66\34\2\u019d\u019e\7\33\2\2\u019e\u01a0\3\2\2"+
		"\2\u019f\u0197\3\2\2\2\u019f\u0199\3\2\2\2\u019f\u019b\3\2\2\2\u01a0\u01a4"+
		"\3\2\2\2\u01a1\u01a4\7*\2\2\u01a2\u01a4\7\7\2\2\u01a3\u019f\3\2\2\2\u01a3"+
		"\u01a1\3\2\2\2\u01a3\u01a2\3\2\2\2\u01a4a\3\2\2\2\u01a5\u01a6\7!\2\2\u01a6"+
		"\u01a7\5\66\34\2\u01a7\u01a8\7\17\2\2\u01a8\u01ac\3\2\2\2\u01a9\u01ac"+
		"\5\u008eH\2\u01aa\u01ac\5\n\6\2\u01ab\u01a5\3\2\2\2\u01ab\u01a9\3\2\2"+
		"\2\u01ab\u01aa\3\2\2\2\u01acc\3\2\2\2\u01ad\u01af\7G\2\2\u01ae\u01ad\3"+
		"\2\2\2\u01ae\u01af\3\2\2\2\u01af\u01b1\3\2\2\2\u01b0\u01b2\5\34\17\2\u01b1"+
		"\u01b0\3\2\2\2\u01b1\u01b2\3\2\2\2\u01b2\u01b3\3\2\2\2\u01b3\u01b4\5f"+
		"\64\2\u01b4e\3\2\2\2\u01b5\u01b6\5~@\2\u01b6\u01b7\5h\65\2\u01b7\u01bd"+
		"\3\2\2\2\u01b8\u01ba\5v<\2\u01b9\u01bb\5h\65\2\u01ba\u01b9\3\2\2\2\u01ba"+
		"\u01bb\3\2\2\2\u01bb\u01bd\3\2\2\2\u01bc\u01b5\3\2\2\2\u01bc\u01b8\3\2"+
		"\2\2\u01bdg\3\2\2\2\u01be\u01c3\5j\66\2\u01bf\u01c0\7\37\2\2\u01c0\u01c2"+
		"\5j\66\2\u01c1\u01bf\3\2\2\2\u01c2\u01c5\3\2\2\2\u01c3\u01c1\3\2\2\2\u01c3"+
		"\u01c4\3\2\2\2\u01c4\u01c6\3\2\2\2\u01c5\u01c3\3\2\2\2\u01c6\u01c7\7\63"+
		"\2\2\u01c7i\3\2\2\2\u01c8\u01ca\5\u0092J\2\u01c9\u01c8\3\2\2\2\u01c9\u01ca"+
		"\3\2\2\2\u01ca\u01cb\3\2\2\2\u01cb\u01cd\5\u008eH\2\u01cc\u01ce\5\u0080"+
		"A\2\u01cd\u01cc\3\2\2\2\u01cd\u01ce\3\2\2\2\u01ce\u01d6\3\2\2\2\u01cf"+
		"\u01d1\7!\2\2\u01d0\u01d2\5\66\34\2\u01d1\u01d0\3\2\2\2\u01d1\u01d2\3"+
		"\2\2\2\u01d2\u01d3\3\2\2\2\u01d3\u01d7\7\17\2\2\u01d4\u01d5\7\23\2\2\u01d5"+
		"\u01d7\5l\67\2\u01d6\u01cf\3\2\2\2\u01d6\u01d4\3\2\2\2\u01d6\u01d7\3\2"+
		"\2\2\u01d7k\3\2\2\2\u01d8\u01da\5\60\31\2\u01d9\u01d8\3\2\2\2\u01da\u01dd"+
		"\3\2\2\2\u01db\u01d9\3\2\2\2\u01db\u01dc\3\2\2\2\u01dc\u01f4\3\2\2\2\u01dd"+
		"\u01db\3\2\2\2\u01de\u01df\7X\2\2\u01df\u01e0\5n8\2\u01e0\u01e1\7Y\2\2"+
		"\u01e1\u01eb\3\2\2\2\u01e2\u01e3\7!\2\2\u01e3\u01e4\5n8\2\u01e4\u01e5"+
		"\7\17\2\2\u01e5\u01eb\3\2\2\2\u01e6\u01e7\7\4\2\2\u01e7\u01e8\5n8\2\u01e8"+
		"\u01e9\7\33\2\2\u01e9\u01eb\3\2\2\2\u01ea\u01de\3\2\2\2\u01ea\u01e2\3"+
		"\2\2\2\u01ea\u01e6\3\2\2\2\u01eb\u01ef\3\2\2\2\u01ec\u01ee\5\60\31\2\u01ed"+
		"\u01ec\3\2\2\2\u01ee\u01f1\3\2\2\2\u01ef\u01ed\3\2\2\2\u01ef\u01f0\3\2"+
		"\2\2\u01f0\u01f3\3\2\2\2\u01f1\u01ef\3\2\2\2\u01f2\u01ea\3\2\2\2\u01f3"+
		"\u01f6\3\2\2\2\u01f4\u01f2\3\2\2\2\u01f4\u01f5\3\2\2\2\u01f5m\3\2\2\2"+
		"\u01f6\u01f4\3\2\2\2\u01f7\u01f9\5\62\32\2\u01f8\u01f7\3\2\2\2\u01f9\u01fc"+
		"\3\2\2\2\u01fa\u01f8\3\2\2\2\u01fa\u01fb\3\2\2\2\u01fb\u0213\3\2\2\2\u01fc"+
		"\u01fa\3\2\2\2\u01fd\u01fe\7X\2\2\u01fe\u01ff\5n8\2\u01ff\u0200\7Y\2\2"+
		"\u0200\u020a\3\2\2\2\u0201\u0202\7!\2\2\u0202\u0203\5n8\2\u0203\u0204"+
		"\7\17\2\2\u0204\u020a\3\2\2\2\u0205\u0206\7\4\2\2\u0206\u0207\5n8\2\u0207"+
		"\u0208\7\33\2\2\u0208\u020a\3\2\2\2\u0209\u01fd\3\2\2\2\u0209\u0201\3"+
		"\2\2\2\u0209\u0205\3\2\2\2\u020a\u020e\3\2\2\2\u020b\u020d\5\62\32\2\u020c"+
		"\u020b\3\2\2\2\u020d\u0210\3\2\2\2\u020e\u020c\3\2\2\2\u020e\u020f\3\2"+
		"\2\2\u020f\u0212\3\2\2\2\u0210\u020e\3\2\2\2\u0211\u0209\3\2\2\2\u0212"+
		"\u0215\3\2\2\2\u0213\u0211\3\2\2\2\u0213\u0214\3\2\2\2\u0214o\3\2\2\2"+
		"\u0215\u0213\3\2\2\2\u0216\u0218\5*\26\2\u0217\u0216\3\2\2\2\u0218\u021b"+
		"\3\2\2\2\u0219\u0217\3\2\2\2\u0219\u021a\3\2\2\2\u021a\u0227\3\2\2\2\u021b"+
		"\u0219\3\2\2\2\u021c\u021d\7\4\2\2\u021d\u021e\5p9\2\u021e\u0222\7\33"+
		"\2\2\u021f\u0221\5*\26\2\u0220\u021f\3\2\2\2\u0221\u0224\3\2\2\2\u0222"+
		"\u0220\3\2\2\2\u0222\u0223\3\2\2\2\u0223\u0226\3\2\2\2\u0224\u0222\3\2"+
		"\2\2\u0225\u021c\3\2\2\2\u0226\u0229\3\2\2\2\u0227\u0225\3\2\2\2\u0227"+
		"\u0228\3\2\2\2\u0228q\3\2\2\2\u0229\u0227\3\2\2\2\u022a\u0230\58\35\2"+
		"\u022b\u022c\7X\2\2\u022c\u022d\5t;\2\u022d\u022e\7Y\2\2\u022e\u0230\3"+
		"\2\2\2\u022f\u022a\3\2\2\2\u022f\u022b\3\2\2\2\u0230s\3\2\2\2\u0231\u0236"+
		"\5r:\2\u0232\u0233\7\37\2\2\u0233\u0235\5r:\2\u0234\u0232\3\2\2\2\u0235"+
		"\u0238\3\2\2\2\u0236\u0234\3\2\2\2\u0236\u0237\3\2\2\2\u0237u\3\2\2\2"+
		"\u0238\u0236\3\2\2\2\u0239\u023b\5\16\b\2\u023a\u023c\5x=\2\u023b\u023a"+
		"\3\2\2\2\u023b\u023c\3\2\2\2\u023c\u023e\3\2\2\2\u023d\u023f\5z>\2\u023e"+
		"\u023d\3\2\2\2\u023e\u023f\3\2\2\2\u023f\u0240\3\2\2\2\u0240\u0241\7X"+
		"\2\2\u0241\u0242\b<\1\2\u0242w\3\2\2\2\u0243\u0244\5\u008eH\2\u0244y\3"+
		"\2\2\2\u0245\u0246\7\"\2\2\u0246\u024b\5|?\2\u0247\u0248\7\37\2\2\u0248"+
		"\u024a\5|?\2\u0249\u0247\3\2\2\2\u024a\u024d\3\2\2\2\u024b\u0249\3\2\2"+
		"\2\u024b\u024c\3\2\2\2\u024c{\3\2\2\2\u024d\u024b\3\2\2\2\u024e\u0250"+
		"\7M\2\2\u024f\u024e\3\2\2\2\u024f\u0250\3\2\2\2\u0250\u0252\3\2\2\2\u0251"+
		"\u0253\5\22\n\2\u0252\u0251\3\2\2\2\u0252\u0253\3\2\2\2\u0253\u0254\3"+
		"\2\2\2\u0254\u0255\5\u008eH\2\u0255}\3\2\2\2\u0256\u0258\7L\2\2\u0257"+
		"\u0256\3\2\2\2\u0258\u025b\3\2\2\2\u0259\u0257\3\2\2\2\u0259\u025a\3\2"+
		"\2\2\u025a\u025f\3\2\2\2\u025b\u0259\3\2\2\2\u025c\u0260\5\16\b\2\u025d"+
		"\u0260\7I\2\2\u025e\u0260\7J\2\2\u025f\u025c\3\2\2\2\u025f\u025d\3\2\2"+
		"\2\u025f\u025e\3\2\2\2\u025f\u0260\3\2\2\2\u0260\u0261\3\2\2\2\u0261\u0266"+
		"\5\u0082B\2\u0262\u0263\7\6\2\2\u0263\u0264\5\36\20\2\u0264\u0265\7\66"+
		"\2\2\u0265\u0267\3\2\2\2\u0266\u0262\3\2\2\2\u0266\u0267\3\2\2\2\u0267"+
		"\u0272\3\2\2\2\u0268\u0269\7\22\2\2\u0269\u026e\5\u0082B\2\u026a\u026b"+
		"\7\6\2\2\u026b\u026c\5\36\20\2\u026c\u026d\7\66\2\2\u026d\u026f\3\2\2"+
		"\2\u026e\u026a\3\2\2\2\u026e\u026f\3\2\2\2\u026f\u0271\3\2\2\2\u0270\u0268"+
		"\3\2\2\2\u0271\u0274\3\2\2\2\u0272\u0270\3\2\2\2\u0272\u0273\3\2\2\2\u0273"+
		"\u0277\3\2\2\2\u0274\u0272\3\2\2\2\u0275\u0277\t\31\2\2\u0276\u0259\3"+
		"\2\2\2\u0276\u0275\3\2\2\2\u0277\177\3\2\2\2\u0278\u0279\7\4\2\2\u0279"+
		"\u027a\5p9\2\u027a\u027b\7\33\2\2\u027b\u027e\3\2\2\2\u027c\u027e\5\u0088"+
		"E\2\u027d\u0278\3\2\2\2\u027d\u027c\3\2\2\2\u027e\u0081\3\2\2\2\u027f"+
		"\u0285\7W\2\2\u0280\u0285\7H\2\2\u0281\u0285\7K\2\2\u0282\u0283\7K\2\2"+
		"\u0283\u0285\7K\2\2\u0284\u027f\3\2\2\2\u0284\u0280\3\2\2\2\u0284\u0281"+
		"\3\2\2\2\u0284\u0282\3\2\2\2\u0285\u0083\3\2\2\2\u0286\u0288\t\32\2\2"+
		"\u0287\u0286\3\2\2\2\u0287\u0288\3\2\2\2\u0288\u0289\3\2\2\2\u0289\u028a"+
		"\5~@\2\u028a\u0085\3\2\2\2\u028b\u028e\5\u008eH\2\u028c\u028e\5\22\n\2"+
		"\u028d\u028b\3\2\2\2\u028d\u028c\3\2\2\2\u028e\u0087\3\2\2\2\u028f\u0290"+
		"\7!\2\2\u0290\u0291\7H\2\2\u0291\u029f\7\17\2\2\u0292\u029b\7!\2\2\u0293"+
		"\u0298\5\u008aF\2\u0294\u0295\7\37\2\2\u0295\u0297\5\u008aF\2\u0296\u0294"+
		"\3\2\2\2\u0297\u029a\3\2\2\2\u0298\u0296\3\2\2\2\u0298\u0299\3\2\2\2\u0299"+
		"\u029c\3\2\2\2\u029a\u0298\3\2\2\2\u029b\u0293\3\2\2\2\u029b\u029c\3\2"+
		"\2\2\u029c\u029d\3\2\2\2\u029d\u029f\7\17\2\2\u029e\u028f\3\2\2\2\u029e"+
		"\u0292\3\2\2\2\u029f\u0089\3\2\2\2\u02a0\u02a1\5\u0084C\2\u02a1\u02a2"+
		"\5\u008cG\2\u02a2\u008b\3\2\2\2\u02a3\u02a5\5\u0092J\2\u02a4\u02a3\3\2"+
		"\2\2\u02a4\u02a5\3\2\2\2\u02a5\u02ad\3\2\2\2\u02a6\u02a7\7!\2\2\u02a7"+
		"\u02a8\5\u008cG\2\u02a8\u02a9\7\17\2\2\u02a9\u02ae\3\2\2\2\u02aa\u02ac"+
		"\5\u0086D\2\u02ab\u02aa\3\2\2\2\u02ab\u02ac\3\2\2\2\u02ac\u02ae\3\2\2"+
		"\2\u02ad\u02a6\3\2\2\2\u02ad\u02ab\3\2\2\2\u02ae\u02b0\3\2\2\2\u02af\u02b1"+
		"\5\u0080A\2\u02b0\u02af\3\2\2\2\u02b0\u02b1\3\2\2\2\u02b1\u008d\3\2\2"+
		"\2\u02b2\u02b7\7W\2\2\u02b3\u02b4\7\22\2\2\u02b4\u02b6\7W\2\2\u02b5\u02b3"+
		"\3\2\2\2\u02b6\u02b9\3\2\2\2\u02b7\u02b5\3\2\2\2\u02b7\u02b8\3\2\2\2\u02b8"+
		"\u008f\3\2\2\2\u02b9\u02b7\3\2\2\2\u02ba\u02bb\t\33\2\2\u02bb\u0091\3"+
		"\2\2\2\u02bc\u02be\5\20\t\2\u02bd\u02bc\3\2\2\2\u02be\u02bf\3\2\2\2\u02bf"+
		"\u02bd\3\2\2\2\u02bf\u02c0\3\2\2\2\u02c0\u0093\3\2\2\2O\u0097\u009f\u00b5"+
		"\u00df\u00f3\u00f5\u0111\u0117\u011f\u0124\u0129\u012e\u0133\u0138\u013e"+
		"\u0144\u0149\u014e\u0153\u015a\u0161\u016b\u016f\u0175\u017b\u0182\u018e"+
		"\u0191\u019f\u01a3\u01ab\u01ae\u01b1\u01ba\u01bc\u01c3\u01c9\u01cd\u01d1"+
		"\u01d6\u01db\u01ea\u01ef\u01f4\u01fa\u0209\u020e\u0213\u0219\u0222\u0227"+
		"\u022f\u0236\u023b\u023e\u024b\u024f\u0252\u0259\u025f\u0266\u026e\u0272"+
		"\u0276\u027d\u0284\u0287\u028d\u0298\u029b\u029e\u02a4\u02ab\u02ad\u02b0"+
		"\u02b7\u02bf";
	public static final ATN _ATN =
		ATNSimulator.deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
	}
}