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
		FOR=61, WHILE=62, BREAK=63, CASE=64, CONTINUE=65, SWITCH=66, DO=67, GOTO=68, 
		RETURN=69, TYPEDEF=70, VOID=71, UNSIGNED=72, SIGNED=73, LONG=74, CV_QUALIFIER=75, 
		VIRTUAL=76, TRY=77, CATCH=78, THROW=79, USING=80, NAMESPACE=81, AUTO=82, 
		REGISTER=83, OPERATOR=84, TEMPLATE=85, ALPHA_NUMERIC=86, OPENING_CURLY=87, 
		CLOSING_CURLY=88, PRE_IF=89, PRE_ELSE=90, PRE_ENDIF=91, HEX_LITERAL=92, 
		DECIMAL_LITERAL=93, OCTAL_LITERAL=94, FLOATING_POINT_LITERAL=95, CHAR=96, 
		STRING=97, COMMENT=98, WHITESPACE=99, CPPCOMMENT=100, OTHER=101;
	public static final String[] tokenNames = {
		"<INVALID>", "'&'", "'['", "'*'", "'<'", "'--'", "'!='", "'<='", "'<<'", 
		"'%'", "'->'", "'*='", "'union'", "')'", "'inline'", "'explicit'", "'::'", 
		"'='", "'|='", "'new'", "'class'", "'|'", "'!'", "'enum'", "'<<='", "']'", 
		"'-='", "'->*'", "'public'", "','", "'-'", "'('", "':'", "'&='", "'private'", 
		"'?'", "'>>='", "'+='", "'^='", "'friend'", "'++'", "'static'", "'struct'", 
		"'>>'", "'^'", "'delete'", "'.'", "'+'", "'protected'", "';'", "'&&'", 
		"'||'", "'>'", "'%='", "'/='", "'=='", "'/'", "'~'", "'>='", "'if'", "'else'", 
		"'for'", "'while'", "'break'", "'case'", "'continue'", "'switch'", "'do'", 
		"'goto'", "'return'", "'typedef'", "'void'", "'unsigned'", "'signed'", 
		"'long'", "CV_QUALIFIER", "'virtual'", "'try'", "'catch'", "'throw'", 
		"'using'", "'namespace'", "'auto'", "'register'", "'operator'", "'template'", 
		"ALPHA_NUMERIC", "'{'", "'}'", "PRE_IF", "PRE_ELSE", "PRE_ENDIF", "HEX_LITERAL", 
		"DECIMAL_LITERAL", "OCTAL_LITERAL", "FLOATING_POINT_LITERAL", "CHAR", 
		"STRING", "COMMENT", "WHITESPACE", "CPPCOMMENT", "OTHER"
	};
	public static final int
		RULE_coarse_content = 0, RULE_unary_operator = 1, RULE_relational_operator = 2, 
		RULE_constant = 3, RULE_function_decl_specifiers = 4, RULE_class_key = 5, 
		RULE_ptr_operator = 6, RULE_access_specifier = 7, RULE_operator_function_id = 8, 
		RULE_operator = 9, RULE_assignment_operator = 10, RULE_equality_operator = 11, 
		RULE_template_decl_start = 12, RULE_template_param_list = 13, RULE_no_brackets = 14, 
		RULE_no_brackets_curlies_or_squares = 15, RULE_no_brackets_or_semicolon = 16, 
		RULE_no_angle_brackets_or_brackets = 17, RULE_no_curlies = 18, RULE_no_squares = 19, 
		RULE_no_squares_or_semicolon = 20, RULE_no_comma_or_semicolon = 21, RULE_assign_water = 22, 
		RULE_assign_water_l2 = 23, RULE_water = 24, RULE_expr = 25, RULE_assign_expr = 26, 
		RULE_conditional_expression = 27, RULE_or_expression = 28, RULE_and_expression = 29, 
		RULE_inclusive_or_expression = 30, RULE_exclusive_or_expression = 31, 
		RULE_bit_and_expression = 32, RULE_equality_expression = 33, RULE_relational_expression = 34, 
		RULE_shift_expression = 35, RULE_additive_expression = 36, RULE_multiplicative_expression = 37, 
		RULE_cast_expression = 38, RULE_unary_expression = 39, RULE_postfix_expression = 40, 
		RULE_field = 41, RULE_function_call_tail = 42, RULE_call_template_list = 43, 
		RULE_function_argument_list = 44, RULE_function_argument = 45, RULE_postfix = 46, 
		RULE_primary_expression = 47, RULE_init_declarator = 48, RULE_type_suffix = 49, 
		RULE_simple_decl = 50, RULE_var_decl = 51, RULE_init_declarator_list = 52, 
		RULE_initializer = 53, RULE_initializer_list = 54, RULE_class_def = 55, 
		RULE_class_name = 56, RULE_base_classes = 57, RULE_base_class = 58, RULE_type_name = 59, 
		RULE_base_type = 60, RULE_param_decl_specifiers = 61, RULE_parameter_name = 62, 
		RULE_param_type_list = 63, RULE_param_type = 64, RULE_param_type_id = 65, 
		RULE_identifier = 66, RULE_number = 67, RULE_ptrs = 68;
	public static final String[] ruleNames = {
		"coarse_content", "unary_operator", "relational_operator", "constant", 
		"function_decl_specifiers", "class_key", "ptr_operator", "access_specifier", 
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
		"function_argument", "postfix", "primary_expression", "init_declarator", 
		"type_suffix", "simple_decl", "var_decl", "init_declarator_list", "initializer", 
		"initializer_list", "class_def", "class_name", "base_classes", "base_class", 
		"type_name", "base_type", "param_decl_specifiers", "parameter_name", "param_type_list", 
		"param_type", "param_type_id", "identifier", "number", "ptrs"
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
		public List<WaterContext> water() {
			return getRuleContexts(WaterContext.class);
		}
		public List<Unary_expressionContext> unary_expression() {
			return getRuleContexts(Unary_expressionContext.class);
		}
		public Simple_declContext simple_decl(int i) {
			return getRuleContext(Simple_declContext.class,i);
		}
		public TerminalNode EOF() { return getToken(SymbolsParser.EOF, 0); }
		public List<Simple_declContext> simple_decl() {
			return getRuleContexts(Simple_declContext.class);
		}
		public WaterContext water(int i) {
			return getRuleContext(WaterContext.class,i);
		}
		public Unary_expressionContext unary_expression(int i) {
			return getRuleContext(Unary_expressionContext.class,i);
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
			setState(143);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << 1) | (1L << 2) | (1L << 3) | (1L << 4) | (1L << 5) | (1L << 6) | (1L << 7) | (1L << 8) | (1L << 9) | (1L << 10) | (1L << 11) | (1L << 12) | (1L << 13) | (1L << 14) | (1L << 15) | (1L << 16) | (1L << 17) | (1L << 18) | (1L << 19) | (1L << 20) | (1L << 21) | (1L << 22) | (1L << 23) | (1L << 24) | (1L << 25) | (1L << 26) | (1L << 27) | (1L << 28) | (1L << 29) | (1L << 30) | (1L << 31) | (1L << 32) | (1L << 33) | (1L << 34) | (1L << 35) | (1L << 36) | (1L << 37) | (1L << 38) | (1L << 39) | (1L << 40) | (1L << 41) | (1L << 42) | (1L << 43) | (1L << 44) | (1L << 45) | (1L << 46) | (1L << 47) | (1L << 48) | (1L << 49) | (1L << 50) | (1L << 51) | (1L << 52) | (1L << 53) | (1L << 54) | (1L << 55) | (1L << 56) | (1L << 57) | (1L << 58) | (1L << IF) | (1L << ELSE) | (1L << FOR) | (1L << WHILE) | (1L << BREAK))) != 0) || ((((_la - 64)) & ~0x3f) == 0 && ((1L << (_la - 64)) & ((1L << (CASE - 64)) | (1L << (CONTINUE - 64)) | (1L << (SWITCH - 64)) | (1L << (DO - 64)) | (1L << (GOTO - 64)) | (1L << (RETURN - 64)) | (1L << (TYPEDEF - 64)) | (1L << (VOID - 64)) | (1L << (UNSIGNED - 64)) | (1L << (SIGNED - 64)) | (1L << (LONG - 64)) | (1L << (CV_QUALIFIER - 64)) | (1L << (VIRTUAL - 64)) | (1L << (TRY - 64)) | (1L << (CATCH - 64)) | (1L << (THROW - 64)) | (1L << (USING - 64)) | (1L << (NAMESPACE - 64)) | (1L << (AUTO - 64)) | (1L << (REGISTER - 64)) | (1L << (OPERATOR - 64)) | (1L << (TEMPLATE - 64)) | (1L << (ALPHA_NUMERIC - 64)) | (1L << (OPENING_CURLY - 64)) | (1L << (CLOSING_CURLY - 64)) | (1L << (PRE_IF - 64)) | (1L << (PRE_ELSE - 64)) | (1L << (PRE_ENDIF - 64)) | (1L << (HEX_LITERAL - 64)) | (1L << (DECIMAL_LITERAL - 64)) | (1L << (OCTAL_LITERAL - 64)) | (1L << (FLOATING_POINT_LITERAL - 64)) | (1L << (CHAR - 64)) | (1L << (STRING - 64)) | (1L << (COMMENT - 64)) | (1L << (WHITESPACE - 64)) | (1L << (CPPCOMMENT - 64)) | (1L << (OTHER - 64)) | (1L << (5 - 64)) | (1L << (12 - 64)) | (1L << (20 - 64)) | (1L << (22 - 64)) | (1L << (23 - 64)) | (1L << (30 - 64)) | (1L << (31 - 64)) | (1L << (40 - 64)) | (1L << (42 - 64)) | (1L << (47 - 64)) | (1L << (57 - 64)) | (1L << (TYPEDEF - 64)) | (1L << (VOID - 64)) | (1L << (UNSIGNED - 64)) | (1L << (SIGNED - 64)) | (1L << (LONG - 64)) | (1L << (CV_QUALIFIER - 64)) | (1L << (TEMPLATE - 64)) | (1L << (ALPHA_NUMERIC - 64)) | (1L << (HEX_LITERAL - 64)) | (1L << (DECIMAL_LITERAL - 64)) | (1L << (OCTAL_LITERAL - 64)) | (1L << (FLOATING_POINT_LITERAL - 64)) | (1L << (CHAR - 64)) | (1L << (STRING - 64)))) != 0)) {
				{
				setState(141);
				switch ( getInterpreter().adaptivePredict(_input,0,_ctx) ) {
				case 1:
					{
					setState(138); simple_decl();
					}
					break;

				case 2:
					{
					setState(139); unary_expression();
					}
					break;

				case 3:
					{
					setState(140); water();
					}
					break;
				}
				}
				setState(145);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(146); match(EOF);
			}
		}
		catch (RecognitionException re) {
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
		enterRule(_localctx, 2, RULE_unary_operator);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(148);
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
		enterRule(_localctx, 4, RULE_relational_operator);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(150);
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
		enterRule(_localctx, 6, RULE_constant);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(152);
			_la = _input.LA(1);
			if ( !(((((_la - 92)) & ~0x3f) == 0 && ((1L << (_la - 92)) & ((1L << (HEX_LITERAL - 92)) | (1L << (DECIMAL_LITERAL - 92)) | (1L << (OCTAL_LITERAL - 92)) | (1L << (FLOATING_POINT_LITERAL - 92)) | (1L << (CHAR - 92)) | (1L << (STRING - 92)))) != 0)) ) {
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
		enterRule(_localctx, 8, RULE_function_decl_specifiers);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(154);
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
		enterRule(_localctx, 10, RULE_class_key);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(156);
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
		enterRule(_localctx, 12, RULE_ptr_operator);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(158);
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
		enterRule(_localctx, 14, RULE_access_specifier);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(160);
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
		enterRule(_localctx, 16, RULE_operator_function_id);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(162); match(OPERATOR);
			setState(163); operator();
			}
		}
		catch (RecognitionException re) {
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
		enterRule(_localctx, 18, RULE_operator);
		int _la;
		try {
			setState(210);
			switch (_input.LA(1)) {
			case 19:
			case 45:
				enterOuterAlt(_localctx, 1);
				{
				{
				setState(165);
				_la = _input.LA(1);
				if ( !(_la==19 || _la==45) ) {
				_errHandler.recoverInline(this);
				}
				consume();
				setState(168);
				_la = _input.LA(1);
				if (_la==2) {
					{
					setState(166); match(2);
					setState(167); match(25);
					}
				}

				}
				}
				break;
			case 47:
				enterOuterAlt(_localctx, 2);
				{
				setState(170); match(47);
				}
				break;
			case 30:
				enterOuterAlt(_localctx, 3);
				{
				setState(171); match(30);
				}
				break;
			case 3:
				enterOuterAlt(_localctx, 4);
				{
				setState(172); match(3);
				}
				break;
			case 56:
				enterOuterAlt(_localctx, 5);
				{
				setState(173); match(56);
				}
				break;
			case 9:
				enterOuterAlt(_localctx, 6);
				{
				setState(174); match(9);
				}
				break;
			case 44:
				enterOuterAlt(_localctx, 7);
				{
				setState(175); match(44);
				}
				break;
			case 1:
				enterOuterAlt(_localctx, 8);
				{
				setState(176); match(1);
				}
				break;
			case 21:
				enterOuterAlt(_localctx, 9);
				{
				setState(177); match(21);
				}
				break;
			case 57:
				enterOuterAlt(_localctx, 10);
				{
				setState(178); match(57);
				}
				break;
			case 22:
				enterOuterAlt(_localctx, 11);
				{
				setState(179); match(22);
				}
				break;
			case 17:
				enterOuterAlt(_localctx, 12);
				{
				setState(180); match(17);
				}
				break;
			case 4:
				enterOuterAlt(_localctx, 13);
				{
				setState(181); match(4);
				}
				break;
			case 52:
				enterOuterAlt(_localctx, 14);
				{
				setState(182); match(52);
				}
				break;
			case 37:
				enterOuterAlt(_localctx, 15);
				{
				setState(183); match(37);
				}
				break;
			case 26:
				enterOuterAlt(_localctx, 16);
				{
				setState(184); match(26);
				}
				break;
			case 11:
				enterOuterAlt(_localctx, 17);
				{
				setState(185); match(11);
				}
				break;
			case 54:
				enterOuterAlt(_localctx, 18);
				{
				setState(186); match(54);
				}
				break;
			case 53:
				enterOuterAlt(_localctx, 19);
				{
				setState(187); match(53);
				}
				break;
			case 38:
				enterOuterAlt(_localctx, 20);
				{
				setState(188); match(38);
				}
				break;
			case 33:
				enterOuterAlt(_localctx, 21);
				{
				setState(189); match(33);
				}
				break;
			case 18:
				enterOuterAlt(_localctx, 22);
				{
				setState(190); match(18);
				}
				break;
			case 43:
				enterOuterAlt(_localctx, 23);
				{
				setState(191); match(43);
				}
				break;
			case 8:
				enterOuterAlt(_localctx, 24);
				{
				setState(192); match(8);
				}
				break;
			case 36:
				enterOuterAlt(_localctx, 25);
				{
				setState(193); match(36);
				}
				break;
			case 24:
				enterOuterAlt(_localctx, 26);
				{
				setState(194); match(24);
				}
				break;
			case 55:
				enterOuterAlt(_localctx, 27);
				{
				setState(195); match(55);
				}
				break;
			case 6:
				enterOuterAlt(_localctx, 28);
				{
				setState(196); match(6);
				}
				break;
			case 7:
				enterOuterAlt(_localctx, 29);
				{
				setState(197); match(7);
				}
				break;
			case 58:
				enterOuterAlt(_localctx, 30);
				{
				setState(198); match(58);
				}
				break;
			case 50:
				enterOuterAlt(_localctx, 31);
				{
				setState(199); match(50);
				}
				break;
			case 51:
				enterOuterAlt(_localctx, 32);
				{
				setState(200); match(51);
				}
				break;
			case 40:
				enterOuterAlt(_localctx, 33);
				{
				setState(201); match(40);
				}
				break;
			case 5:
				enterOuterAlt(_localctx, 34);
				{
				setState(202); match(5);
				}
				break;
			case 29:
				enterOuterAlt(_localctx, 35);
				{
				setState(203); match(29);
				}
				break;
			case 27:
				enterOuterAlt(_localctx, 36);
				{
				setState(204); match(27);
				}
				break;
			case 10:
				enterOuterAlt(_localctx, 37);
				{
				setState(205); match(10);
				}
				break;
			case 31:
				enterOuterAlt(_localctx, 38);
				{
				setState(206); match(31);
				setState(207); match(13);
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 39);
				{
				setState(208); match(2);
				setState(209); match(25);
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
		enterRule(_localctx, 20, RULE_assignment_operator);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(212);
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
		enterRule(_localctx, 22, RULE_equality_operator);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(214);
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
		enterRule(_localctx, 24, RULE_template_decl_start);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(216); match(TEMPLATE);
			setState(217); match(4);
			setState(218); template_param_list();
			setState(219); match(52);
			}
		}
		catch (RecognitionException re) {
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
		enterRule(_localctx, 26, RULE_template_param_list);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(232);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << 1) | (1L << 2) | (1L << 3) | (1L << 4) | (1L << 5) | (1L << 6) | (1L << 7) | (1L << 8) | (1L << 9) | (1L << 10) | (1L << 11) | (1L << 12) | (1L << 14) | (1L << 15) | (1L << 16) | (1L << 17) | (1L << 18) | (1L << 19) | (1L << 20) | (1L << 21) | (1L << 22) | (1L << 23) | (1L << 24) | (1L << 25) | (1L << 26) | (1L << 27) | (1L << 28) | (1L << 29) | (1L << 30) | (1L << 31) | (1L << 32) | (1L << 33) | (1L << 34) | (1L << 35) | (1L << 36) | (1L << 37) | (1L << 38) | (1L << 39) | (1L << 40) | (1L << 41) | (1L << 42) | (1L << 43) | (1L << 44) | (1L << 45) | (1L << 46) | (1L << 47) | (1L << 48) | (1L << 49) | (1L << 50) | (1L << 51) | (1L << 53) | (1L << 54) | (1L << 55) | (1L << 56) | (1L << 57) | (1L << 58) | (1L << IF) | (1L << ELSE) | (1L << FOR) | (1L << WHILE) | (1L << BREAK))) != 0) || ((((_la - 64)) & ~0x3f) == 0 && ((1L << (_la - 64)) & ((1L << (CASE - 64)) | (1L << (CONTINUE - 64)) | (1L << (SWITCH - 64)) | (1L << (DO - 64)) | (1L << (GOTO - 64)) | (1L << (RETURN - 64)) | (1L << (TYPEDEF - 64)) | (1L << (VOID - 64)) | (1L << (UNSIGNED - 64)) | (1L << (SIGNED - 64)) | (1L << (LONG - 64)) | (1L << (CV_QUALIFIER - 64)) | (1L << (VIRTUAL - 64)) | (1L << (TRY - 64)) | (1L << (CATCH - 64)) | (1L << (THROW - 64)) | (1L << (USING - 64)) | (1L << (NAMESPACE - 64)) | (1L << (AUTO - 64)) | (1L << (REGISTER - 64)) | (1L << (OPERATOR - 64)) | (1L << (TEMPLATE - 64)) | (1L << (ALPHA_NUMERIC - 64)) | (1L << (OPENING_CURLY - 64)) | (1L << (CLOSING_CURLY - 64)) | (1L << (PRE_IF - 64)) | (1L << (PRE_ELSE - 64)) | (1L << (PRE_ENDIF - 64)) | (1L << (HEX_LITERAL - 64)) | (1L << (DECIMAL_LITERAL - 64)) | (1L << (OCTAL_LITERAL - 64)) | (1L << (FLOATING_POINT_LITERAL - 64)) | (1L << (CHAR - 64)) | (1L << (STRING - 64)) | (1L << (COMMENT - 64)) | (1L << (WHITESPACE - 64)) | (1L << (CPPCOMMENT - 64)) | (1L << (OTHER - 64)))) != 0)) {
				{
				setState(230);
				switch (_input.LA(1)) {
				case 4:
					{
					{
					setState(221); match(4);
					setState(222); template_param_list();
					setState(223); match(52);
					}
					}
					break;
				case 31:
					{
					{
					setState(225); match(31);
					setState(226); template_param_list();
					setState(227); match(13);
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
					setState(229); no_angle_brackets_or_brackets();
					}
					break;
				default:
					throw new NoViableAltException(this);
				}
				}
				setState(234);
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
		enterRule(_localctx, 28, RULE_no_brackets);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(235);
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
		enterRule(_localctx, 30, RULE_no_brackets_curlies_or_squares);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(237);
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
		enterRule(_localctx, 32, RULE_no_brackets_or_semicolon);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(239);
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
		enterRule(_localctx, 34, RULE_no_angle_brackets_or_brackets);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(241);
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
		enterRule(_localctx, 36, RULE_no_curlies);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(243);
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
		enterRule(_localctx, 38, RULE_no_squares);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(245);
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
		enterRule(_localctx, 40, RULE_no_squares_or_semicolon);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(247);
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
		enterRule(_localctx, 42, RULE_no_comma_or_semicolon);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(249);
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
		enterRule(_localctx, 44, RULE_assign_water);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(251);
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
		enterRule(_localctx, 46, RULE_assign_water_l2);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(253);
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
		enterRule(_localctx, 48, RULE_water);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(255);
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
		enterRule(_localctx, 50, RULE_expr);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(257); assign_expr();
			setState(260);
			_la = _input.LA(1);
			if (_la==29) {
				{
				setState(258); match(29);
				setState(259); assign_expr();
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
		enterRule(_localctx, 52, RULE_assign_expr);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(262); conditional_expression();
			setState(266);
			_la = _input.LA(1);
			if ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << 11) | (1L << 17) | (1L << 18) | (1L << 24) | (1L << 26) | (1L << 33) | (1L << 36) | (1L << 37) | (1L << 38) | (1L << 53) | (1L << 54))) != 0)) {
				{
				setState(263); assignment_operator();
				setState(264); assign_expr();
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
		enterRule(_localctx, 54, RULE_conditional_expression);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(268); or_expression();
			setState(274);
			_la = _input.LA(1);
			if (_la==35) {
				{
				setState(269); match(35);
				setState(270); expr();
				setState(271); match(32);
				setState(272); conditional_expression();
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
		enterRule(_localctx, 56, RULE_or_expression);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(276); and_expression();
			setState(279);
			_la = _input.LA(1);
			if (_la==51) {
				{
				setState(277); match(51);
				setState(278); or_expression();
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
		enterRule(_localctx, 58, RULE_and_expression);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(281); inclusive_or_expression();
			setState(284);
			_la = _input.LA(1);
			if (_la==50) {
				{
				setState(282); match(50);
				setState(283); and_expression();
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
		enterRule(_localctx, 60, RULE_inclusive_or_expression);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(286); exclusive_or_expression();
			setState(289);
			_la = _input.LA(1);
			if (_la==21) {
				{
				setState(287); match(21);
				setState(288); inclusive_or_expression();
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
		enterRule(_localctx, 62, RULE_exclusive_or_expression);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(291); bit_and_expression();
			setState(294);
			_la = _input.LA(1);
			if (_la==44) {
				{
				setState(292); match(44);
				setState(293); exclusive_or_expression();
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
		enterRule(_localctx, 64, RULE_bit_and_expression);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(296); equality_expression();
			setState(299);
			_la = _input.LA(1);
			if (_la==1) {
				{
				setState(297); match(1);
				setState(298); bit_and_expression();
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
		enterRule(_localctx, 66, RULE_equality_expression);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(301); relational_expression();
			setState(305);
			_la = _input.LA(1);
			if (_la==6 || _la==55) {
				{
				setState(302); equality_operator();
				setState(303); equality_expression();
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
		enterRule(_localctx, 68, RULE_relational_expression);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(307); shift_expression();
			setState(311);
			_la = _input.LA(1);
			if ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << 4) | (1L << 7) | (1L << 52) | (1L << 58))) != 0)) {
				{
				setState(308); relational_operator();
				setState(309); relational_expression();
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
		enterRule(_localctx, 70, RULE_shift_expression);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(313); additive_expression();
			setState(316);
			_la = _input.LA(1);
			if (_la==8 || _la==43) {
				{
				setState(314);
				_la = _input.LA(1);
				if ( !(_la==8 || _la==43) ) {
				_errHandler.recoverInline(this);
				}
				consume();
				setState(315); shift_expression();
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
		enterRule(_localctx, 72, RULE_additive_expression);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(318); multiplicative_expression();
			setState(321);
			_la = _input.LA(1);
			if (_la==30 || _la==47) {
				{
				setState(319);
				_la = _input.LA(1);
				if ( !(_la==30 || _la==47) ) {
				_errHandler.recoverInline(this);
				}
				consume();
				setState(320); additive_expression();
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
		enterRule(_localctx, 74, RULE_multiplicative_expression);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(323); cast_expression();
			setState(326);
			_la = _input.LA(1);
			if ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << 3) | (1L << 9) | (1L << 56))) != 0)) {
				{
				setState(324);
				_la = _input.LA(1);
				if ( !((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << 3) | (1L << 9) | (1L << 56))) != 0)) ) {
				_errHandler.recoverInline(this);
				}
				consume();
				setState(325); cast_expression();
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
		enterRule(_localctx, 76, RULE_cast_expression);
		int _la;
		try {
			setState(340);
			switch ( getInterpreter().adaptivePredict(_input,20,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				{
				setState(328); match(31);
				setState(329); type_name();
				setState(333);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (_la==1 || _la==3) {
					{
					{
					setState(330); ptr_operator();
					}
					}
					setState(335);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				setState(336); match(13);
				setState(337); cast_expression();
				}
				}
				break;

			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(339); unary_expression();
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
		enterRule(_localctx, 78, RULE_unary_expression);
		int _la;
		try {
			setState(353);
			switch (_input.LA(1)) {
			case 5:
				enterOuterAlt(_localctx, 1);
				{
				setState(342); match(5);
				setState(343); unary_expression();
				}
				break;
			case 40:
				enterOuterAlt(_localctx, 2);
				{
				setState(344); match(40);
				setState(345); unary_expression();
				}
				break;
			case 1:
			case 3:
			case 22:
			case 30:
			case 31:
			case 47:
			case 57:
			case ALPHA_NUMERIC:
			case HEX_LITERAL:
			case DECIMAL_LITERAL:
			case OCTAL_LITERAL:
			case FLOATING_POINT_LITERAL:
			case CHAR:
			case STRING:
				enterOuterAlt(_localctx, 3);
				{
				setState(349);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << 1) | (1L << 3) | (1L << 22) | (1L << 30) | (1L << 47) | (1L << 57))) != 0)) {
					{
					{
					setState(346); unary_operator();
					}
					}
					setState(351);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				setState(352); postfix_expression();
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
		enterRule(_localctx, 80, RULE_postfix_expression);
		try {
			setState(359);
			switch ( getInterpreter().adaptivePredict(_input,23,_ctx) ) {
			case 1:
				_localctx = new FuncCallContext(_localctx);
				enterOuterAlt(_localctx, 1);
				{
				setState(355); field();
				setState(356); function_call_tail();
				}
				break;

			case 2:
				_localctx = new FieldOnlyContext(_localctx);
				enterOuterAlt(_localctx, 2);
				{
				setState(358); field();
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
		enterRule(_localctx, 82, RULE_field);
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(361); primary_expression();
			setState(365);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,24,_ctx);
			while ( _alt!=2 && _alt!=-1 ) {
				if ( _alt==1 ) {
					{
					{
					setState(362); postfix();
					}
					} 
				}
				setState(367);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,24,_ctx);
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
		enterRule(_localctx, 84, RULE_function_call_tail);
		try {
			setState(372);
			switch (_input.LA(1)) {
			case 4:
				enterOuterAlt(_localctx, 1);
				{
				setState(368); call_template_list();
				setState(369); function_argument_list();
				}
				break;
			case 31:
				enterOuterAlt(_localctx, 2);
				{
				setState(371); function_argument_list();
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
		enterRule(_localctx, 86, RULE_call_template_list);
		try {
			enterOuterAlt(_localctx, 1);
			{
			{
			setState(374); match(4);
			setState(375); template_param_list();
			setState(376); match(52);
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
		enterRule(_localctx, 88, RULE_function_argument_list);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(378); match(31);
			setState(387);
			_la = _input.LA(1);
			if ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << 1) | (1L << 3) | (1L << 5) | (1L << 22) | (1L << 30) | (1L << 31) | (1L << 40) | (1L << 47) | (1L << 57))) != 0) || ((((_la - 86)) & ~0x3f) == 0 && ((1L << (_la - 86)) & ((1L << (ALPHA_NUMERIC - 86)) | (1L << (HEX_LITERAL - 86)) | (1L << (DECIMAL_LITERAL - 86)) | (1L << (OCTAL_LITERAL - 86)) | (1L << (FLOATING_POINT_LITERAL - 86)) | (1L << (CHAR - 86)) | (1L << (STRING - 86)))) != 0)) {
				{
				setState(379); function_argument();
				setState(384);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (_la==29) {
					{
					{
					setState(380); match(29);
					setState(381); function_argument();
					}
					}
					setState(386);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				}
			}

			setState(389); match(13);
			}
		}
		catch (RecognitionException re) {
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
		enterRule(_localctx, 90, RULE_function_argument);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(391); assign_expr();
			}
		}
		catch (RecognitionException re) {
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
		enterRule(_localctx, 92, RULE_postfix);
		try {
			setState(405);
			switch (_input.LA(1)) {
			case 2:
			case 10:
			case 46:
				enterOuterAlt(_localctx, 1);
				{
				setState(401);
				switch (_input.LA(1)) {
				case 46:
					{
					setState(393); match(46);
					setState(394); identifier();
					}
					break;
				case 10:
					{
					setState(395); match(10);
					setState(396); identifier();
					}
					break;
				case 2:
					{
					setState(397); match(2);
					setState(398); expr();
					setState(399); match(25);
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
				setState(403); match(40);
				}
				break;
			case 5:
				enterOuterAlt(_localctx, 3);
				{
				setState(404); match(5);
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
		enterRule(_localctx, 94, RULE_primary_expression);
		try {
			setState(413);
			switch (_input.LA(1)) {
			case ALPHA_NUMERIC:
				enterOuterAlt(_localctx, 1);
				{
				setState(407); identifier();
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
				setState(408); constant();
				}
				break;
			case 31:
				enterOuterAlt(_localctx, 3);
				{
				setState(409); match(31);
				setState(410); expr();
				setState(411); match(13);
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
		public InitializerContext initializer() {
			return getRuleContext(InitializerContext.class,0);
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
		enterRule(_localctx, 96, RULE_init_declarator);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			{
			setState(416);
			_la = _input.LA(1);
			if (_la==1 || _la==3) {
				{
				setState(415); ptrs();
				}
			}

			setState(418); identifier();
			setState(420);
			switch ( getInterpreter().adaptivePredict(_input,32,_ctx) ) {
			case 1:
				{
				setState(419); type_suffix();
				}
				break;
			}
			}
			setState(429);
			switch (_input.LA(1)) {
			case 31:
				{
				{
				setState(422); match(31);
				setState(424);
				_la = _input.LA(1);
				if ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << 1) | (1L << 3) | (1L << 5) | (1L << 22) | (1L << 30) | (1L << 31) | (1L << 40) | (1L << 47) | (1L << 57))) != 0) || ((((_la - 86)) & ~0x3f) == 0 && ((1L << (_la - 86)) & ((1L << (ALPHA_NUMERIC - 86)) | (1L << (HEX_LITERAL - 86)) | (1L << (DECIMAL_LITERAL - 86)) | (1L << (OCTAL_LITERAL - 86)) | (1L << (FLOATING_POINT_LITERAL - 86)) | (1L << (CHAR - 86)) | (1L << (STRING - 86)))) != 0)) {
					{
					setState(423); expr();
					}
				}

				setState(426); match(13);
				}
				}
				break;
			case 17:
				{
				{
				setState(427); match(17);
				setState(428); initializer();
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

	public static class Type_suffixContext extends ParserRuleContext {
		public Conditional_expressionContext conditional_expression() {
			return getRuleContext(Conditional_expressionContext.class,0);
		}
		public Param_type_listContext param_type_list() {
			return getRuleContext(Param_type_listContext.class,0);
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
		enterRule(_localctx, 98, RULE_type_suffix);
		int _la;
		try {
			setState(437);
			switch (_input.LA(1)) {
			case 2:
				enterOuterAlt(_localctx, 1);
				{
				{
				setState(431); match(2);
				setState(433);
				_la = _input.LA(1);
				if ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << 1) | (1L << 3) | (1L << 5) | (1L << 22) | (1L << 30) | (1L << 31) | (1L << 40) | (1L << 47) | (1L << 57))) != 0) || ((((_la - 86)) & ~0x3f) == 0 && ((1L << (_la - 86)) & ((1L << (ALPHA_NUMERIC - 86)) | (1L << (HEX_LITERAL - 86)) | (1L << (DECIMAL_LITERAL - 86)) | (1L << (OCTAL_LITERAL - 86)) | (1L << (FLOATING_POINT_LITERAL - 86)) | (1L << (CHAR - 86)) | (1L << (STRING - 86)))) != 0)) {
					{
					setState(432); conditional_expression();
					}
				}

				setState(435); match(25);
				}
				}
				break;
			case 31:
				enterOuterAlt(_localctx, 2);
				{
				setState(436); param_type_list();
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
		enterRule(_localctx, 100, RULE_simple_decl);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(440);
			_la = _input.LA(1);
			if (_la==TYPEDEF) {
				{
				setState(439); match(TYPEDEF);
				}
			}

			setState(443);
			_la = _input.LA(1);
			if (_la==TEMPLATE) {
				{
				setState(442); template_decl_start();
				}
			}

			setState(445); var_decl();
			}
		}
		catch (RecognitionException re) {
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
		enterRule(_localctx, 102, RULE_var_decl);
		try {
			setState(454);
			switch ( getInterpreter().adaptivePredict(_input,40,_ctx) ) {
			case 1:
				_localctx = new DeclByTypeContext(_localctx);
				enterOuterAlt(_localctx, 1);
				{
				setState(447); type_name();
				setState(448); init_declarator_list();
				}
				break;

			case 2:
				_localctx = new DeclByClassContext(_localctx);
				enterOuterAlt(_localctx, 2);
				{
				setState(450); class_def();
				setState(452);
				switch ( getInterpreter().adaptivePredict(_input,39,_ctx) ) {
				case 1:
					{
					setState(451); init_declarator_list();
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
		enterRule(_localctx, 104, RULE_init_declarator_list);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(456); init_declarator();
			setState(461);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==29) {
				{
				{
				setState(457); match(29);
				setState(458); init_declarator();
				}
				}
				setState(463);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(464); match(49);
			}
		}
		catch (RecognitionException re) {
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
		enterRule(_localctx, 106, RULE_initializer);
		try {
			setState(471);
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
				setState(466); assign_expr();
				}
				break;
			case OPENING_CURLY:
				enterOuterAlt(_localctx, 2);
				{
				setState(467); match(OPENING_CURLY);
				setState(468); initializer_list();
				setState(469); match(CLOSING_CURLY);
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
		enterRule(_localctx, 108, RULE_initializer_list);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(473); initializer();
			setState(478);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==29) {
				{
				{
				setState(474); match(29);
				setState(475); initializer();
				}
				}
				setState(480);
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
		enterRule(_localctx, 110, RULE_class_def);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(481); class_key();
			setState(483);
			_la = _input.LA(1);
			if (_la==ALPHA_NUMERIC) {
				{
				setState(482); class_name();
				}
			}

			setState(486);
			_la = _input.LA(1);
			if (_la==32) {
				{
				setState(485); base_classes();
				}
			}

			setState(488); match(OPENING_CURLY);
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
		enterRule(_localctx, 112, RULE_class_name);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(491); identifier();
			}
		}
		catch (RecognitionException re) {
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
		enterRule(_localctx, 114, RULE_base_classes);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(493); match(32);
			setState(494); base_class();
			setState(499);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==29) {
				{
				{
				setState(495); match(29);
				setState(496); base_class();
				}
				}
				setState(501);
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
		enterRule(_localctx, 116, RULE_base_class);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(503);
			_la = _input.LA(1);
			if (_la==VIRTUAL) {
				{
				setState(502); match(VIRTUAL);
				}
			}

			setState(506);
			_la = _input.LA(1);
			if ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << 28) | (1L << 34) | (1L << 48))) != 0)) {
				{
				setState(505); access_specifier();
				}
			}

			setState(508); identifier();
			}
		}
		catch (RecognitionException re) {
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
		enterRule(_localctx, 118, RULE_type_name);
		int _la;
		try {
			setState(542);
			switch ( getInterpreter().adaptivePredict(_input,54,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				{
				setState(513);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (_la==CV_QUALIFIER) {
					{
					{
					setState(510); match(CV_QUALIFIER);
					}
					}
					setState(515);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				setState(519);
				switch (_input.LA(1)) {
				case 12:
				case 20:
				case 23:
				case 42:
					{
					setState(516); class_key();
					}
					break;
				case UNSIGNED:
					{
					setState(517); match(UNSIGNED);
					}
					break;
				case SIGNED:
					{
					setState(518); match(SIGNED);
					}
					break;
				case VOID:
				case LONG:
				case ALPHA_NUMERIC:
					break;
				default:
					throw new NoViableAltException(this);
				}
				setState(521); base_type();
				setState(526);
				_la = _input.LA(1);
				if (_la==4) {
					{
					setState(522); match(4);
					setState(523); template_param_list();
					setState(524); match(52);
					}
				}

				setState(538);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (_la==16) {
					{
					{
					setState(528); match(16);
					setState(529); base_type();
					setState(534);
					_la = _input.LA(1);
					if (_la==4) {
						{
						setState(530); match(4);
						setState(531); template_param_list();
						setState(532); match(52);
						}
					}

					}
					}
					setState(540);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				}
				}
				break;

			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(541);
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
		enterRule(_localctx, 120, RULE_base_type);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(549);
			switch ( getInterpreter().adaptivePredict(_input,55,_ctx) ) {
			case 1:
				{
				setState(544); match(ALPHA_NUMERIC);
				}
				break;

			case 2:
				{
				setState(545); match(VOID);
				}
				break;

			case 3:
				{
				setState(546); match(LONG);
				}
				break;

			case 4:
				{
				setState(547); match(LONG);
				setState(548); match(LONG);
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
		enterRule(_localctx, 122, RULE_param_decl_specifiers);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(552);
			_la = _input.LA(1);
			if (_la==AUTO || _la==REGISTER) {
				{
				setState(551);
				_la = _input.LA(1);
				if ( !(_la==AUTO || _la==REGISTER) ) {
				_errHandler.recoverInline(this);
				}
				consume();
				}
			}

			setState(554); type_name();
			}
		}
		catch (RecognitionException re) {
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
		enterRule(_localctx, 124, RULE_parameter_name);
		try {
			setState(558);
			switch (_input.LA(1)) {
			case ALPHA_NUMERIC:
				enterOuterAlt(_localctx, 1);
				{
				setState(556); identifier();
				}
				break;
			case 28:
			case 34:
			case 48:
				enterOuterAlt(_localctx, 2);
				{
				setState(557); access_specifier();
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
		enterRule(_localctx, 126, RULE_param_type_list);
		int _la;
		try {
			setState(575);
			switch ( getInterpreter().adaptivePredict(_input,60,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(560); match(31);
				setState(561); match(VOID);
				setState(562); match(13);
				}
				break;

			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(563); match(31);
				setState(572);
				_la = _input.LA(1);
				if ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << 12) | (1L << 20) | (1L << 23) | (1L << 42))) != 0) || ((((_la - 71)) & ~0x3f) == 0 && ((1L << (_la - 71)) & ((1L << (VOID - 71)) | (1L << (UNSIGNED - 71)) | (1L << (SIGNED - 71)) | (1L << (LONG - 71)) | (1L << (CV_QUALIFIER - 71)) | (1L << (AUTO - 71)) | (1L << (REGISTER - 71)) | (1L << (ALPHA_NUMERIC - 71)))) != 0)) {
					{
					setState(564); param_type();
					setState(569);
					_errHandler.sync(this);
					_la = _input.LA(1);
					while (_la==29) {
						{
						{
						setState(565); match(29);
						setState(566); param_type();
						}
						}
						setState(571);
						_errHandler.sync(this);
						_la = _input.LA(1);
					}
					}
				}

				setState(574); match(13);
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
		enterRule(_localctx, 128, RULE_param_type);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(577); param_decl_specifiers();
			setState(578); param_type_id();
			}
		}
		catch (RecognitionException re) {
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
		enterRule(_localctx, 130, RULE_param_type_id);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(581);
			_la = _input.LA(1);
			if (_la==1 || _la==3) {
				{
				setState(580); ptrs();
				}
			}

			setState(590);
			switch ( getInterpreter().adaptivePredict(_input,63,_ctx) ) {
			case 1:
				{
				setState(583); match(31);
				setState(584); param_type_id();
				setState(585); match(13);
				}
				break;

			case 2:
				{
				setState(588);
				_la = _input.LA(1);
				if (((((_la - 28)) & ~0x3f) == 0 && ((1L << (_la - 28)) & ((1L << (28 - 28)) | (1L << (34 - 28)) | (1L << (48 - 28)) | (1L << (ALPHA_NUMERIC - 28)))) != 0)) {
					{
					setState(587); parameter_name();
					}
				}

				}
				break;
			}
			setState(593);
			_la = _input.LA(1);
			if (_la==2 || _la==31) {
				{
				setState(592); type_suffix();
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
		enterRule(_localctx, 132, RULE_identifier);
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(595); match(ALPHA_NUMERIC);
			setState(600);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,65,_ctx);
			while ( _alt!=2 && _alt!=-1 ) {
				if ( _alt==1 ) {
					{
					{
					setState(596); match(16);
					setState(597); match(ALPHA_NUMERIC);
					}
					} 
				}
				setState(602);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,65,_ctx);
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
		enterRule(_localctx, 134, RULE_number);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(603);
			_la = _input.LA(1);
			if ( !(((((_la - 92)) & ~0x3f) == 0 && ((1L << (_la - 92)) & ((1L << (HEX_LITERAL - 92)) | (1L << (DECIMAL_LITERAL - 92)) | (1L << (OCTAL_LITERAL - 92)))) != 0)) ) {
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
		enterRule(_localctx, 136, RULE_ptrs);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(606); 
			_errHandler.sync(this);
			_la = _input.LA(1);
			do {
				{
				{
				setState(605); ptr_operator();
				}
				}
				setState(608); 
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
		"\2\3g\u0265\4\2\t\2\4\3\t\3\4\4\t\4\4\5\t\5\4\6\t\6\4\7\t\7\4\b\t\b\4"+
		"\t\t\t\4\n\t\n\4\13\t\13\4\f\t\f\4\r\t\r\4\16\t\16\4\17\t\17\4\20\t\20"+
		"\4\21\t\21\4\22\t\22\4\23\t\23\4\24\t\24\4\25\t\25\4\26\t\26\4\27\t\27"+
		"\4\30\t\30\4\31\t\31\4\32\t\32\4\33\t\33\4\34\t\34\4\35\t\35\4\36\t\36"+
		"\4\37\t\37\4 \t \4!\t!\4\"\t\"\4#\t#\4$\t$\4%\t%\4&\t&\4\'\t\'\4(\t(\4"+
		")\t)\4*\t*\4+\t+\4,\t,\4-\t-\4.\t.\4/\t/\4\60\t\60\4\61\t\61\4\62\t\62"+
		"\4\63\t\63\4\64\t\64\4\65\t\65\4\66\t\66\4\67\t\67\48\t8\49\t9\4:\t:\4"+
		";\t;\4<\t<\4=\t=\4>\t>\4?\t?\4@\t@\4A\tA\4B\tB\4C\tC\4D\tD\4E\tE\4F\t"+
		"F\3\2\3\2\3\2\7\2\u0090\n\2\f\2\16\2\u0093\13\2\3\2\3\2\3\3\3\3\3\4\3"+
		"\4\3\5\3\5\3\6\3\6\3\7\3\7\3\b\3\b\3\t\3\t\3\n\3\n\3\n\3\13\3\13\3\13"+
		"\5\13\u00ab\n\13\3\13\3\13\3\13\3\13\3\13\3\13\3\13\3\13\3\13\3\13\3\13"+
		"\3\13\3\13\3\13\3\13\3\13\3\13\3\13\3\13\3\13\3\13\3\13\3\13\3\13\3\13"+
		"\3\13\3\13\3\13\3\13\3\13\3\13\3\13\3\13\3\13\3\13\3\13\3\13\3\13\3\13"+
		"\3\13\5\13\u00d5\n\13\3\f\3\f\3\r\3\r\3\16\3\16\3\16\3\16\3\16\3\17\3"+
		"\17\3\17\3\17\3\17\3\17\3\17\3\17\3\17\7\17\u00e9\n\17\f\17\16\17\u00ec"+
		"\13\17\3\20\3\20\3\21\3\21\3\22\3\22\3\23\3\23\3\24\3\24\3\25\3\25\3\26"+
		"\3\26\3\27\3\27\3\30\3\30\3\31\3\31\3\32\3\32\3\33\3\33\3\33\5\33\u0107"+
		"\n\33\3\34\3\34\3\34\3\34\5\34\u010d\n\34\3\35\3\35\3\35\3\35\3\35\3\35"+
		"\5\35\u0115\n\35\3\36\3\36\3\36\5\36\u011a\n\36\3\37\3\37\3\37\5\37\u011f"+
		"\n\37\3 \3 \3 \5 \u0124\n \3!\3!\3!\5!\u0129\n!\3\"\3\"\3\"\5\"\u012e"+
		"\n\"\3#\3#\3#\3#\5#\u0134\n#\3$\3$\3$\3$\5$\u013a\n$\3%\3%\3%\5%\u013f"+
		"\n%\3&\3&\3&\5&\u0144\n&\3\'\3\'\3\'\5\'\u0149\n\'\3(\3(\3(\7(\u014e\n"+
		"(\f(\16(\u0151\13(\3(\3(\3(\3(\5(\u0157\n(\3)\3)\3)\3)\3)\7)\u015e\n)"+
		"\f)\16)\u0161\13)\3)\5)\u0164\n)\3*\3*\3*\3*\5*\u016a\n*\3+\3+\7+\u016e"+
		"\n+\f+\16+\u0171\13+\3,\3,\3,\3,\5,\u0177\n,\3-\3-\3-\3-\3.\3.\3.\3.\7"+
		".\u0181\n.\f.\16.\u0184\13.\5.\u0186\n.\3.\3.\3/\3/\3\60\3\60\3\60\3\60"+
		"\3\60\3\60\3\60\3\60\5\60\u0194\n\60\3\60\3\60\5\60\u0198\n\60\3\61\3"+
		"\61\3\61\3\61\3\61\3\61\5\61\u01a0\n\61\3\62\5\62\u01a3\n\62\3\62\3\62"+
		"\5\62\u01a7\n\62\3\62\3\62\5\62\u01ab\n\62\3\62\3\62\3\62\5\62\u01b0\n"+
		"\62\3\63\3\63\5\63\u01b4\n\63\3\63\3\63\5\63\u01b8\n\63\3\64\5\64\u01bb"+
		"\n\64\3\64\5\64\u01be\n\64\3\64\3\64\3\65\3\65\3\65\3\65\3\65\5\65\u01c7"+
		"\n\65\5\65\u01c9\n\65\3\66\3\66\3\66\7\66\u01ce\n\66\f\66\16\66\u01d1"+
		"\13\66\3\66\3\66\3\67\3\67\3\67\3\67\3\67\5\67\u01da\n\67\38\38\38\78"+
		"\u01df\n8\f8\168\u01e2\138\39\39\59\u01e6\n9\39\59\u01e9\n9\39\39\39\3"+
		":\3:\3;\3;\3;\3;\7;\u01f4\n;\f;\16;\u01f7\13;\3<\5<\u01fa\n<\3<\5<\u01fd"+
		"\n<\3<\3<\3=\7=\u0202\n=\f=\16=\u0205\13=\3=\3=\3=\5=\u020a\n=\3=\3=\3"+
		"=\3=\3=\5=\u0211\n=\3=\3=\3=\3=\3=\3=\5=\u0219\n=\7=\u021b\n=\f=\16=\u021e"+
		"\13=\3=\5=\u0221\n=\3>\3>\3>\3>\3>\5>\u0228\n>\3?\5?\u022b\n?\3?\3?\3"+
		"@\3@\5@\u0231\n@\3A\3A\3A\3A\3A\3A\3A\7A\u023a\nA\fA\16A\u023d\13A\5A"+
		"\u023f\nA\3A\5A\u0242\nA\3B\3B\3B\3C\5C\u0248\nC\3C\3C\3C\3C\3C\5C\u024f"+
		"\nC\5C\u0251\nC\3C\5C\u0254\nC\3D\3D\3D\7D\u0259\nD\fD\16D\u025c\13D\3"+
		"E\3E\3F\6F\u0261\nF\rF\16F\u0262\3F\2G\2\4\6\b\n\f\16\20\22\24\26\30\32"+
		"\34\36 \"$&(*,.\60\62\64\668:<>@BDFHJLNPRTVXZ\\^`bdfhjlnprtvxz|~\u0080"+
		"\u0082\u0084\u0086\u0088\u008a\2\34\b\3\3\5\5\30\30  \61\61;;\6\6\6\t"+
		"\t\66\66<<\3^c\6\20\21))++NN\6\16\16\26\26\31\31,,\4\3\3\5\5\5\36\36$"+
		"$\62\62\4\25\25//\t\r\r\23\24\32\32\34\34##&(\678\4\b\b99\4\17\17!!\7"+
		"\4\4\17\17\33\33!!YZ\5\17\17!!\63\63\6\6\6\17\17!!\66\66\3YZ\4\4\4\33"+
		"\33\5\4\4\33\33\63\63\4\37\37\63\63\t\4\4\17\17\33\33\37\37!!\63\63YZ"+
		"\7\4\4\17\17\33\33!!YZ\4\n\n--\4  \61\61\5\5\5\13\13::\3JK\3TU\3^`\u0292"+
		"\2\u0091\3\2\2\2\4\u0096\3\2\2\2\6\u0098\3\2\2\2\b\u009a\3\2\2\2\n\u009c"+
		"\3\2\2\2\f\u009e\3\2\2\2\16\u00a0\3\2\2\2\20\u00a2\3\2\2\2\22\u00a4\3"+
		"\2\2\2\24\u00d4\3\2\2\2\26\u00d6\3\2\2\2\30\u00d8\3\2\2\2\32\u00da\3\2"+
		"\2\2\34\u00ea\3\2\2\2\36\u00ed\3\2\2\2 \u00ef\3\2\2\2\"\u00f1\3\2\2\2"+
		"$\u00f3\3\2\2\2&\u00f5\3\2\2\2(\u00f7\3\2\2\2*\u00f9\3\2\2\2,\u00fb\3"+
		"\2\2\2.\u00fd\3\2\2\2\60\u00ff\3\2\2\2\62\u0101\3\2\2\2\64\u0103\3\2\2"+
		"\2\66\u0108\3\2\2\28\u010e\3\2\2\2:\u0116\3\2\2\2<\u011b\3\2\2\2>\u0120"+
		"\3\2\2\2@\u0125\3\2\2\2B\u012a\3\2\2\2D\u012f\3\2\2\2F\u0135\3\2\2\2H"+
		"\u013b\3\2\2\2J\u0140\3\2\2\2L\u0145\3\2\2\2N\u0156\3\2\2\2P\u0163\3\2"+
		"\2\2R\u0169\3\2\2\2T\u016b\3\2\2\2V\u0176\3\2\2\2X\u0178\3\2\2\2Z\u017c"+
		"\3\2\2\2\\\u0189\3\2\2\2^\u0197\3\2\2\2`\u019f\3\2\2\2b\u01a2\3\2\2\2"+
		"d\u01b7\3\2\2\2f\u01ba\3\2\2\2h\u01c8\3\2\2\2j\u01ca\3\2\2\2l\u01d9\3"+
		"\2\2\2n\u01db\3\2\2\2p\u01e3\3\2\2\2r\u01ed\3\2\2\2t\u01ef\3\2\2\2v\u01f9"+
		"\3\2\2\2x\u0220\3\2\2\2z\u0227\3\2\2\2|\u022a\3\2\2\2~\u0230\3\2\2\2\u0080"+
		"\u0241\3\2\2\2\u0082\u0243\3\2\2\2\u0084\u0247\3\2\2\2\u0086\u0255\3\2"+
		"\2\2\u0088\u025d\3\2\2\2\u008a\u0260\3\2\2\2\u008c\u0090\5f\64\2\u008d"+
		"\u0090\5P)\2\u008e\u0090\5\62\32\2\u008f\u008c\3\2\2\2\u008f\u008d\3\2"+
		"\2\2\u008f\u008e\3\2\2\2\u0090\u0093\3\2\2\2\u0091\u008f\3\2\2\2\u0091"+
		"\u0092\3\2\2\2\u0092\u0094\3\2\2\2\u0093\u0091\3\2\2\2\u0094\u0095\7\1"+
		"\2\2\u0095\3\3\2\2\2\u0096\u0097\t\2\2\2\u0097\5\3\2\2\2\u0098\u0099\t"+
		"\3\2\2\u0099\7\3\2\2\2\u009a\u009b\t\4\2\2\u009b\t\3\2\2\2\u009c\u009d"+
		"\t\5\2\2\u009d\13\3\2\2\2\u009e\u009f\t\6\2\2\u009f\r\3\2\2\2\u00a0\u00a1"+
		"\t\7\2\2\u00a1\17\3\2\2\2\u00a2\u00a3\t\b\2\2\u00a3\21\3\2\2\2\u00a4\u00a5"+
		"\7V\2\2\u00a5\u00a6\5\24\13\2\u00a6\23\3\2\2\2\u00a7\u00aa\t\t\2\2\u00a8"+
		"\u00a9\7\4\2\2\u00a9\u00ab\7\33\2\2\u00aa\u00a8\3\2\2\2\u00aa\u00ab\3"+
		"\2\2\2\u00ab\u00d5\3\2\2\2\u00ac\u00d5\7\61\2\2\u00ad\u00d5\7 \2\2\u00ae"+
		"\u00d5\7\5\2\2\u00af\u00d5\7:\2\2\u00b0\u00d5\7\13\2\2\u00b1\u00d5\7."+
		"\2\2\u00b2\u00d5\7\3\2\2\u00b3\u00d5\7\27\2\2\u00b4\u00d5\7;\2\2\u00b5"+
		"\u00d5\7\30\2\2\u00b6\u00d5\7\23\2\2\u00b7\u00d5\7\6\2\2\u00b8\u00d5\7"+
		"\66\2\2\u00b9\u00d5\7\'\2\2\u00ba\u00d5\7\34\2\2\u00bb\u00d5\7\r\2\2\u00bc"+
		"\u00d5\78\2\2\u00bd\u00d5\7\67\2\2\u00be\u00d5\7(\2\2\u00bf\u00d5\7#\2"+
		"\2\u00c0\u00d5\7\24\2\2\u00c1\u00d5\7-\2\2\u00c2\u00d5\7\n\2\2\u00c3\u00d5"+
		"\7&\2\2\u00c4\u00d5\7\32\2\2\u00c5\u00d5\79\2\2\u00c6\u00d5\7\b\2\2\u00c7"+
		"\u00d5\7\t\2\2\u00c8\u00d5\7<\2\2\u00c9\u00d5\7\64\2\2\u00ca\u00d5\7\65"+
		"\2\2\u00cb\u00d5\7*\2\2\u00cc\u00d5\7\7\2\2\u00cd\u00d5\7\37\2\2\u00ce"+
		"\u00d5\7\35\2\2\u00cf\u00d5\7\f\2\2\u00d0\u00d1\7!\2\2\u00d1\u00d5\7\17"+
		"\2\2\u00d2\u00d3\7\4\2\2\u00d3\u00d5\7\33\2\2\u00d4\u00a7\3\2\2\2\u00d4"+
		"\u00ac\3\2\2\2\u00d4\u00ad\3\2\2\2\u00d4\u00ae\3\2\2\2\u00d4\u00af\3\2"+
		"\2\2\u00d4\u00b0\3\2\2\2\u00d4\u00b1\3\2\2\2\u00d4\u00b2\3\2\2\2\u00d4"+
		"\u00b3\3\2\2\2\u00d4\u00b4\3\2\2\2\u00d4\u00b5\3\2\2\2\u00d4\u00b6\3\2"+
		"\2\2\u00d4\u00b7\3\2\2\2\u00d4\u00b8\3\2\2\2\u00d4\u00b9\3\2\2\2\u00d4"+
		"\u00ba\3\2\2\2\u00d4\u00bb\3\2\2\2\u00d4\u00bc\3\2\2\2\u00d4\u00bd\3\2"+
		"\2\2\u00d4\u00be\3\2\2\2\u00d4\u00bf\3\2\2\2\u00d4\u00c0\3\2\2\2\u00d4"+
		"\u00c1\3\2\2\2\u00d4\u00c2\3\2\2\2\u00d4\u00c3\3\2\2\2\u00d4\u00c4\3\2"+
		"\2\2\u00d4\u00c5\3\2\2\2\u00d4\u00c6\3\2\2\2\u00d4\u00c7\3\2\2\2\u00d4"+
		"\u00c8\3\2\2\2\u00d4\u00c9\3\2\2\2\u00d4\u00ca\3\2\2\2\u00d4\u00cb\3\2"+
		"\2\2\u00d4\u00cc\3\2\2\2\u00d4\u00cd\3\2\2\2\u00d4\u00ce\3\2\2\2\u00d4"+
		"\u00cf\3\2\2\2\u00d4\u00d0\3\2\2\2\u00d4\u00d2\3\2\2\2\u00d5\25\3\2\2"+
		"\2\u00d6\u00d7\t\n\2\2\u00d7\27\3\2\2\2\u00d8\u00d9\t\13\2\2\u00d9\31"+
		"\3\2\2\2\u00da\u00db\7W\2\2\u00db\u00dc\7\6\2\2\u00dc\u00dd\5\34\17\2"+
		"\u00dd\u00de\7\66\2\2\u00de\33\3\2\2\2\u00df\u00e0\7\6\2\2\u00e0\u00e1"+
		"\5\34\17\2\u00e1\u00e2\7\66\2\2\u00e2\u00e9\3\2\2\2\u00e3\u00e4\7!\2\2"+
		"\u00e4\u00e5\5\34\17\2\u00e5\u00e6\7\17\2\2\u00e6\u00e9\3\2\2\2\u00e7"+
		"\u00e9\5$\23\2\u00e8\u00df\3\2\2\2\u00e8\u00e3\3\2\2\2\u00e8\u00e7\3\2"+
		"\2\2\u00e9\u00ec\3\2\2\2\u00ea\u00e8\3\2\2\2\u00ea\u00eb\3\2\2\2\u00eb"+
		"\35\3\2\2\2\u00ec\u00ea\3\2\2\2\u00ed\u00ee\n\f\2\2\u00ee\37\3\2\2\2\u00ef"+
		"\u00f0\n\r\2\2\u00f0!\3\2\2\2\u00f1\u00f2\n\16\2\2\u00f2#\3\2\2\2\u00f3"+
		"\u00f4\n\17\2\2\u00f4%\3\2\2\2\u00f5\u00f6\n\20\2\2\u00f6\'\3\2\2\2\u00f7"+
		"\u00f8\n\21\2\2\u00f8)\3\2\2\2\u00f9\u00fa\n\22\2\2\u00fa+\3\2\2\2\u00fb"+
		"\u00fc\n\23\2\2\u00fc-\3\2\2\2\u00fd\u00fe\n\24\2\2\u00fe/\3\2\2\2\u00ff"+
		"\u0100\n\25\2\2\u0100\61\3\2\2\2\u0101\u0102\13\2\2\2\u0102\63\3\2\2\2"+
		"\u0103\u0106\5\66\34\2\u0104\u0105\7\37\2\2\u0105\u0107\5\66\34\2\u0106"+
		"\u0104\3\2\2\2\u0106\u0107\3\2\2\2\u0107\65\3\2\2\2\u0108\u010c\58\35"+
		"\2\u0109\u010a\5\26\f\2\u010a\u010b\5\66\34\2\u010b\u010d\3\2\2\2\u010c"+
		"\u0109\3\2\2\2\u010c\u010d\3\2\2\2\u010d\67\3\2\2\2\u010e\u0114\5:\36"+
		"\2\u010f\u0110\7%\2\2\u0110\u0111\5\64\33\2\u0111\u0112\7\"\2\2\u0112"+
		"\u0113\58\35\2\u0113\u0115\3\2\2\2\u0114\u010f\3\2\2\2\u0114\u0115\3\2"+
		"\2\2\u01159\3\2\2\2\u0116\u0119\5<\37\2\u0117\u0118\7\65\2\2\u0118\u011a"+
		"\5:\36\2\u0119\u0117\3\2\2\2\u0119\u011a\3\2\2\2\u011a;\3\2\2\2\u011b"+
		"\u011e\5> \2\u011c\u011d\7\64\2\2\u011d\u011f\5<\37\2\u011e\u011c\3\2"+
		"\2\2\u011e\u011f\3\2\2\2\u011f=\3\2\2\2\u0120\u0123\5@!\2\u0121\u0122"+
		"\7\27\2\2\u0122\u0124\5> \2\u0123\u0121\3\2\2\2\u0123\u0124\3\2\2\2\u0124"+
		"?\3\2\2\2\u0125\u0128\5B\"\2\u0126\u0127\7.\2\2\u0127\u0129\5@!\2\u0128"+
		"\u0126\3\2\2\2\u0128\u0129\3\2\2\2\u0129A\3\2\2\2\u012a\u012d\5D#\2\u012b"+
		"\u012c\7\3\2\2\u012c\u012e\5B\"\2\u012d\u012b\3\2\2\2\u012d\u012e\3\2"+
		"\2\2\u012eC\3\2\2\2\u012f\u0133\5F$\2\u0130\u0131\5\30\r\2\u0131\u0132"+
		"\5D#\2\u0132\u0134\3\2\2\2\u0133\u0130\3\2\2\2\u0133\u0134\3\2\2\2\u0134"+
		"E\3\2\2\2\u0135\u0139\5H%\2\u0136\u0137\5\6\4\2\u0137\u0138\5F$\2\u0138"+
		"\u013a\3\2\2\2\u0139\u0136\3\2\2\2\u0139\u013a\3\2\2\2\u013aG\3\2\2\2"+
		"\u013b\u013e\5J&\2\u013c\u013d\t\26\2\2\u013d\u013f\5H%\2\u013e\u013c"+
		"\3\2\2\2\u013e\u013f\3\2\2\2\u013fI\3\2\2\2\u0140\u0143\5L\'\2\u0141\u0142"+
		"\t\27\2\2\u0142\u0144\5J&\2\u0143\u0141\3\2\2\2\u0143\u0144\3\2\2\2\u0144"+
		"K\3\2\2\2\u0145\u0148\5N(\2\u0146\u0147\t\30\2\2\u0147\u0149\5N(\2\u0148"+
		"\u0146\3\2\2\2\u0148\u0149\3\2\2\2\u0149M\3\2\2\2\u014a\u014b\7!\2\2\u014b"+
		"\u014f\5x=\2\u014c\u014e\5\16\b\2\u014d\u014c\3\2\2\2\u014e\u0151\3\2"+
		"\2\2\u014f\u014d\3\2\2\2\u014f\u0150\3\2\2\2\u0150\u0152\3\2\2\2\u0151"+
		"\u014f\3\2\2\2\u0152\u0153\7\17\2\2\u0153\u0154\5N(\2\u0154\u0157\3\2"+
		"\2\2\u0155\u0157\5P)\2\u0156\u014a\3\2\2\2\u0156\u0155\3\2\2\2\u0157O"+
		"\3\2\2\2\u0158\u0159\7\7\2\2\u0159\u0164\5P)\2\u015a\u015b\7*\2\2\u015b"+
		"\u0164\5P)\2\u015c\u015e\5\4\3\2\u015d\u015c\3\2\2\2\u015e\u0161\3\2\2"+
		"\2\u015f\u015d\3\2\2\2\u015f\u0160\3\2\2\2\u0160\u0162\3\2\2\2\u0161\u015f"+
		"\3\2\2\2\u0162\u0164\5R*\2\u0163\u0158\3\2\2\2\u0163\u015a\3\2\2\2\u0163"+
		"\u015f\3\2\2\2\u0164Q\3\2\2\2\u0165\u0166\5T+\2\u0166\u0167\5V,\2\u0167"+
		"\u016a\3\2\2\2\u0168\u016a\5T+\2\u0169\u0165\3\2\2\2\u0169\u0168\3\2\2"+
		"\2\u016aS\3\2\2\2\u016b\u016f\5`\61\2\u016c\u016e\5^\60\2\u016d\u016c"+
		"\3\2\2\2\u016e\u0171\3\2\2\2\u016f\u016d\3\2\2\2\u016f\u0170\3\2\2\2\u0170"+
		"U\3\2\2\2\u0171\u016f\3\2\2\2\u0172\u0173\5X-\2\u0173\u0174\5Z.\2\u0174"+
		"\u0177\3\2\2\2\u0175\u0177\5Z.\2\u0176\u0172\3\2\2\2\u0176\u0175\3\2\2"+
		"\2\u0177W\3\2\2\2\u0178\u0179\7\6\2\2\u0179\u017a\5\34\17\2\u017a\u017b"+
		"\7\66\2\2\u017bY\3\2\2\2\u017c\u0185\7!\2\2\u017d\u0182\5\\/\2\u017e\u017f"+
		"\7\37\2\2\u017f\u0181\5\\/\2\u0180\u017e\3\2\2\2\u0181\u0184\3\2\2\2\u0182"+
		"\u0180\3\2\2\2\u0182\u0183\3\2\2\2\u0183\u0186\3\2\2\2\u0184\u0182\3\2"+
		"\2\2\u0185\u017d\3\2\2\2\u0185\u0186\3\2\2\2\u0186\u0187\3\2\2\2\u0187"+
		"\u0188\7\17\2\2\u0188[\3\2\2\2\u0189\u018a\5\66\34\2\u018a]\3\2\2\2\u018b"+
		"\u018c\7\60\2\2\u018c\u0194\5\u0086D\2\u018d\u018e\7\f\2\2\u018e\u0194"+
		"\5\u0086D\2\u018f\u0190\7\4\2\2\u0190\u0191\5\64\33\2\u0191\u0192\7\33"+
		"\2\2\u0192\u0194\3\2\2\2\u0193\u018b\3\2\2\2\u0193\u018d\3\2\2\2\u0193"+
		"\u018f\3\2\2\2\u0194\u0198\3\2\2\2\u0195\u0198\7*\2\2\u0196\u0198\7\7"+
		"\2\2\u0197\u0193\3\2\2\2\u0197\u0195\3\2\2\2\u0197\u0196\3\2\2\2\u0198"+
		"_\3\2\2\2\u0199\u01a0\5\u0086D\2\u019a\u01a0\5\b\5\2\u019b\u019c\7!\2"+
		"\2\u019c\u019d\5\64\33\2\u019d\u019e\7\17\2\2\u019e\u01a0\3\2\2\2\u019f"+
		"\u0199\3\2\2\2\u019f\u019a\3\2\2\2\u019f\u019b\3\2\2\2\u01a0a\3\2\2\2"+
		"\u01a1\u01a3\5\u008aF\2\u01a2\u01a1\3\2\2\2\u01a2\u01a3\3\2\2\2\u01a3"+
		"\u01a4\3\2\2\2\u01a4\u01a6\5\u0086D\2\u01a5\u01a7\5d\63\2\u01a6\u01a5"+
		"\3\2\2\2\u01a6\u01a7\3\2\2\2\u01a7\u01af\3\2\2\2\u01a8\u01aa\7!\2\2\u01a9"+
		"\u01ab\5\64\33\2\u01aa\u01a9\3\2\2\2\u01aa\u01ab\3\2\2\2\u01ab\u01ac\3"+
		"\2\2\2\u01ac\u01b0\7\17\2\2\u01ad\u01ae\7\23\2\2\u01ae\u01b0\5l\67\2\u01af"+
		"\u01a8\3\2\2\2\u01af\u01ad\3\2\2\2\u01af\u01b0\3\2\2\2\u01b0c\3\2\2\2"+
		"\u01b1\u01b3\7\4\2\2\u01b2\u01b4\58\35\2\u01b3\u01b2\3\2\2\2\u01b3\u01b4"+
		"\3\2\2\2\u01b4\u01b5\3\2\2\2\u01b5\u01b8\7\33\2\2\u01b6\u01b8\5\u0080"+
		"A\2\u01b7\u01b1\3\2\2\2\u01b7\u01b6\3\2\2\2\u01b8e\3\2\2\2\u01b9\u01bb"+
		"\7H\2\2\u01ba\u01b9\3\2\2\2\u01ba\u01bb\3\2\2\2\u01bb\u01bd\3\2\2\2\u01bc"+
		"\u01be\5\32\16\2\u01bd\u01bc\3\2\2\2\u01bd\u01be\3\2\2\2\u01be\u01bf\3"+
		"\2\2\2\u01bf\u01c0\5h\65\2\u01c0g\3\2\2\2\u01c1\u01c2\5x=\2\u01c2\u01c3"+
		"\5j\66\2\u01c3\u01c9\3\2\2\2\u01c4\u01c6\5p9\2\u01c5\u01c7\5j\66\2\u01c6"+
		"\u01c5\3\2\2\2\u01c6\u01c7\3\2\2\2\u01c7\u01c9\3\2\2\2\u01c8\u01c1\3\2"+
		"\2\2\u01c8\u01c4\3\2\2\2\u01c9i\3\2\2\2\u01ca\u01cf\5b\62\2\u01cb\u01cc"+
		"\7\37\2\2\u01cc\u01ce\5b\62\2\u01cd\u01cb\3\2\2\2\u01ce\u01d1\3\2\2\2"+
		"\u01cf\u01cd\3\2\2\2\u01cf\u01d0\3\2\2\2\u01d0\u01d2\3\2\2\2\u01d1\u01cf"+
		"\3\2\2\2\u01d2\u01d3\7\63\2\2\u01d3k\3\2\2\2\u01d4\u01da\5\66\34\2\u01d5"+
		"\u01d6\7Y\2\2\u01d6\u01d7\5n8\2\u01d7\u01d8\7Z\2\2\u01d8\u01da\3\2\2\2"+
		"\u01d9\u01d4\3\2\2\2\u01d9\u01d5\3\2\2\2\u01dam\3\2\2\2\u01db\u01e0\5"+
		"l\67\2\u01dc\u01dd\7\37\2\2\u01dd\u01df\5l\67\2\u01de\u01dc\3\2\2\2\u01df"+
		"\u01e2\3\2\2\2\u01e0\u01de\3\2\2\2\u01e0\u01e1\3\2\2\2\u01e1o\3\2\2\2"+
		"\u01e2\u01e0\3\2\2\2\u01e3\u01e5\5\f\7\2\u01e4\u01e6\5r:\2\u01e5\u01e4"+
		"\3\2\2\2\u01e5\u01e6\3\2\2\2\u01e6\u01e8\3\2\2\2\u01e7\u01e9\5t;\2\u01e8"+
		"\u01e7\3\2\2\2\u01e8\u01e9\3\2\2\2\u01e9\u01ea\3\2\2\2\u01ea\u01eb\7Y"+
		"\2\2\u01eb\u01ec\b9\1\2\u01ecq\3\2\2\2\u01ed\u01ee\5\u0086D\2\u01ees\3"+
		"\2\2\2\u01ef\u01f0\7\"\2\2\u01f0\u01f5\5v<\2\u01f1\u01f2\7\37\2\2\u01f2"+
		"\u01f4\5v<\2\u01f3\u01f1\3\2\2\2\u01f4\u01f7\3\2\2\2\u01f5\u01f3\3\2\2"+
		"\2\u01f5\u01f6\3\2\2\2\u01f6u\3\2\2\2\u01f7\u01f5\3\2\2\2\u01f8\u01fa"+
		"\7N\2\2\u01f9\u01f8\3\2\2\2\u01f9\u01fa\3\2\2\2\u01fa\u01fc\3\2\2\2\u01fb"+
		"\u01fd\5\20\t\2\u01fc\u01fb\3\2\2\2\u01fc\u01fd\3\2\2\2\u01fd\u01fe\3"+
		"\2\2\2\u01fe\u01ff\5\u0086D\2\u01ffw\3\2\2\2\u0200\u0202\7M\2\2\u0201"+
		"\u0200\3\2\2\2\u0202\u0205\3\2\2\2\u0203\u0201\3\2\2\2\u0203\u0204\3\2"+
		"\2\2\u0204\u0209\3\2\2\2\u0205\u0203\3\2\2\2\u0206\u020a\5\f\7\2\u0207"+
		"\u020a\7J\2\2\u0208\u020a\7K\2\2\u0209\u0206\3\2\2\2\u0209\u0207\3\2\2"+
		"\2\u0209\u0208\3\2\2\2\u0209\u020a\3\2\2\2\u020a\u020b\3\2\2\2\u020b\u0210"+
		"\5z>\2\u020c\u020d\7\6\2\2\u020d\u020e\5\34\17\2\u020e\u020f\7\66\2\2"+
		"\u020f\u0211\3\2\2\2\u0210\u020c\3\2\2\2\u0210\u0211\3\2\2\2\u0211\u021c"+
		"\3\2\2\2\u0212\u0213\7\22\2\2\u0213\u0218\5z>\2\u0214\u0215\7\6\2\2\u0215"+
		"\u0216\5\34\17\2\u0216\u0217\7\66\2\2\u0217\u0219\3\2\2\2\u0218\u0214"+
		"\3\2\2\2\u0218\u0219\3\2\2\2\u0219\u021b\3\2\2\2\u021a\u0212\3\2\2\2\u021b"+
		"\u021e\3\2\2\2\u021c\u021a\3\2\2\2\u021c\u021d\3\2\2\2\u021d\u0221\3\2"+
		"\2\2\u021e\u021c\3\2\2\2\u021f\u0221\t\31\2\2\u0220\u0203\3\2\2\2\u0220"+
		"\u021f\3\2\2\2\u0221y\3\2\2\2\u0222\u0228\7X\2\2\u0223\u0228\7I\2\2\u0224"+
		"\u0228\7L\2\2\u0225\u0226\7L\2\2\u0226\u0228\7L\2\2\u0227\u0222\3\2\2"+
		"\2\u0227\u0223\3\2\2\2\u0227\u0224\3\2\2\2\u0227\u0225\3\2\2\2\u0228{"+
		"\3\2\2\2\u0229\u022b\t\32\2\2\u022a\u0229\3\2\2\2\u022a\u022b\3\2\2\2"+
		"\u022b\u022c\3\2\2\2\u022c\u022d\5x=\2\u022d}\3\2\2\2\u022e\u0231\5\u0086"+
		"D\2\u022f\u0231\5\20\t\2\u0230\u022e\3\2\2\2\u0230\u022f\3\2\2\2\u0231"+
		"\177\3\2\2\2\u0232\u0233\7!\2\2\u0233\u0234\7I\2\2\u0234\u0242\7\17\2"+
		"\2\u0235\u023e\7!\2\2\u0236\u023b\5\u0082B\2\u0237\u0238\7\37\2\2\u0238"+
		"\u023a\5\u0082B\2\u0239\u0237\3\2\2\2\u023a\u023d\3\2\2\2\u023b\u0239"+
		"\3\2\2\2\u023b\u023c\3\2\2\2\u023c\u023f\3\2\2\2\u023d\u023b\3\2\2\2\u023e"+
		"\u0236\3\2\2\2\u023e\u023f\3\2\2\2\u023f\u0240\3\2\2\2\u0240\u0242\7\17"+
		"\2\2\u0241\u0232\3\2\2\2\u0241\u0235\3\2\2\2\u0242\u0081\3\2\2\2\u0243"+
		"\u0244\5|?\2\u0244\u0245\5\u0084C\2\u0245\u0083\3\2\2\2\u0246\u0248\5"+
		"\u008aF\2\u0247\u0246\3\2\2\2\u0247\u0248\3\2\2\2\u0248\u0250\3\2\2\2"+
		"\u0249\u024a\7!\2\2\u024a\u024b\5\u0084C\2\u024b\u024c\7\17\2\2\u024c"+
		"\u0251\3\2\2\2\u024d\u024f\5~@\2\u024e\u024d\3\2\2\2\u024e\u024f\3\2\2"+
		"\2\u024f\u0251\3\2\2\2\u0250\u0249\3\2\2\2\u0250\u024e\3\2\2\2\u0251\u0253"+
		"\3\2\2\2\u0252\u0254\5d\63\2\u0253\u0252\3\2\2\2\u0253\u0254\3\2\2\2\u0254"+
		"\u0085\3\2\2\2\u0255\u025a\7X\2\2\u0256\u0257\7\22\2\2\u0257\u0259\7X"+
		"\2\2\u0258\u0256\3\2\2\2\u0259\u025c\3\2\2\2\u025a\u0258\3\2\2\2\u025a"+
		"\u025b\3\2\2\2\u025b\u0087\3\2\2\2\u025c\u025a\3\2\2\2\u025d\u025e\t\33"+
		"\2\2\u025e\u0089\3\2\2\2\u025f\u0261\5\16\b\2\u0260\u025f\3\2\2\2\u0261"+
		"\u0262\3\2\2\2\u0262\u0260\3\2\2\2\u0262\u0263\3\2\2\2\u0263\u008b\3\2"+
		"\2\2E\u008f\u0091\u00aa\u00d4\u00e8\u00ea\u0106\u010c\u0114\u0119\u011e"+
		"\u0123\u0128\u012d\u0133\u0139\u013e\u0143\u0148\u014f\u0156\u015f\u0163"+
		"\u0169\u016f\u0176\u0182\u0185\u0193\u0197\u019f\u01a2\u01a6\u01aa\u01af"+
		"\u01b3\u01b7\u01ba\u01bd\u01c6\u01c8\u01cf\u01d9\u01e0\u01e5\u01e8\u01f5"+
		"\u01f9\u01fc\u0203\u0209\u0210\u0218\u021c\u0220\u0227\u022a\u0230\u023b"+
		"\u023e\u0241\u0247\u024e\u0250\u0253\u025a\u0262";
	public static final ATN _ATN =
		ATNSimulator.deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
	}
}