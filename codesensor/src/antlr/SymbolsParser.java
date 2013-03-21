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
		"'%'", "'->'", "'*='", "'union'", "')'", "'::'", "'inline'", "'explicit'", 
		"'='", "'|='", "'new'", "'class'", "'|'", "'!'", "'enum'", "']'", "'<<='", 
		"'-='", "'->*'", "'public'", "','", "'-'", "':'", "'('", "'&='", "'private'", 
		"'?'", "'>>='", "'+='", "'^='", "'friend'", "'struct'", "'static'", "'++'", 
		"'>>'", "'^'", "'delete'", "'.'", "'+'", "'protected'", "';'", "'&&'", 
		"'||'", "'>'", "'%='", "'/='", "'/'", "'=='", "'~'", "'>='", "'if'", "'else'", 
		"'for'", "'while'", "'break'", "'case'", "'continue'", "'switch'", "'goto'", 
		"'return'", "'typedef'", "'void'", "'unsigned'", "'signed'", "'long'", 
		"CV_QUALIFIER", "'virtual'", "'try'", "'catch'", "'throw'", "'using'", 
		"'namespace'", "'auto'", "'register'", "'operator'", "'template'", "ALPHA_NUMERIC", 
		"'{'", "'}'", "PRE_IF", "PRE_ELSE", "PRE_ENDIF", "HEX_LITERAL", "DECIMAL_LITERAL", 
		"OCTAL_LITERAL", "FLOATING_POINT_LITERAL", "CHAR", "STRING", "COMMENT", 
		"WHITESPACE", "CPPCOMMENT", "OTHER"
	};
	public static final int
		RULE_coarse_content = 0, RULE_function_call = 1, RULE_simple_decl = 2, 
		RULE_var_decl = 3, RULE_init_declarator_list = 4, RULE_init_declarator = 5, 
		RULE_assign_expr_w_ = 6, RULE_assign_expr_w__l2 = 7, RULE_class_def = 8, 
		RULE_class_name = 9, RULE_base_classes = 10, RULE_base_class = 11, RULE_type_name = 12, 
		RULE_type_suffix = 13, RULE_base_type = 14, RULE_constant_expr_w_ = 15, 
		RULE_param_decl_specifiers = 16, RULE_parameter_name = 17, RULE_param_type_list = 18, 
		RULE_param_type = 19, RULE_param_type_id = 20, RULE_identifier = 21, RULE_number = 22, 
		RULE_ptrs = 23, RULE_unary_operator = 24, RULE_relational_operator = 25, 
		RULE_constant = 26, RULE_function_decl_specifiers = 27, RULE_class_key = 28, 
		RULE_ptr_operator = 29, RULE_access_specifier = 30, RULE_operator_function_id = 31, 
		RULE_operator = 32, RULE_assignment_operator = 33, RULE_equality_operator = 34, 
		RULE_template_decl_start = 35, RULE_template_param_list = 36, RULE_no_brackets = 37, 
		RULE_no_brackets_curlies_or_squares = 38, RULE_no_brackets_or_semicolon = 39, 
		RULE_no_angle_brackets_or_brackets = 40, RULE_no_curlies = 41, RULE_no_squares = 42, 
		RULE_no_squares_or_semicolon = 43, RULE_no_comma_or_semicolon = 44, RULE_assign_water = 45, 
		RULE_assign_water_l2 = 46, RULE_water = 47, RULE_expr = 48, RULE_assign_expr = 49, 
		RULE_conditional_expression = 50, RULE_or_expression = 51, RULE_and_expression = 52, 
		RULE_inclusive_or_expression = 53, RULE_exclusive_or_expression = 54, 
		RULE_bit_and_expression = 55, RULE_equality_expression = 56, RULE_relational_expression = 57, 
		RULE_shift_expression = 58, RULE_additive_expression = 59, RULE_multiplicative_expression = 60, 
		RULE_cast_expression = 61, RULE_unary_expression = 62, RULE_postfix_expression = 63, 
		RULE_field = 64, RULE_function_call_tail = 65, RULE_call_template_list = 66, 
		RULE_function_argument_list = 67, RULE_function_argument = 68, RULE_postfix = 69, 
		RULE_primary_expression = 70;
	public static final String[] ruleNames = {
		"coarse_content", "function_call", "simple_decl", "var_decl", "init_declarator_list", 
		"init_declarator", "assign_expr_w_", "assign_expr_w__l2", "class_def", 
		"class_name", "base_classes", "base_class", "type_name", "type_suffix", 
		"base_type", "constant_expr_w_", "param_decl_specifiers", "parameter_name", 
		"param_type_list", "param_type", "param_type_id", "identifier", "number", 
		"ptrs", "unary_operator", "relational_operator", "constant", "function_decl_specifiers", 
		"class_key", "ptr_operator", "access_specifier", "operator_function_id", 
		"operator", "assignment_operator", "equality_operator", "template_decl_start", 
		"template_param_list", "no_brackets", "no_brackets_curlies_or_squares", 
		"no_brackets_or_semicolon", "no_angle_brackets_or_brackets", "no_curlies", 
		"no_squares", "no_squares_or_semicolon", "no_comma_or_semicolon", "assign_water", 
		"assign_water_l2", "water", "expr", "assign_expr", "conditional_expression", 
		"or_expression", "and_expression", "inclusive_or_expression", "exclusive_or_expression", 
		"bit_and_expression", "equality_expression", "relational_expression", 
		"shift_expression", "additive_expression", "multiplicative_expression", 
		"cast_expression", "unary_expression", "postfix_expression", "field", 
		"function_call_tail", "call_template_list", "function_argument_list", 
		"function_argument", "postfix", "primary_expression"
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
		public List<FieldContext> field() {
			return getRuleContexts(FieldContext.class);
		}
		public List<Function_callContext> function_call() {
			return getRuleContexts(Function_callContext.class);
		}
		public FieldContext field(int i) {
			return getRuleContext(FieldContext.class,i);
		}
		public Simple_declContext simple_decl(int i) {
			return getRuleContext(Simple_declContext.class,i);
		}
		public Function_callContext function_call(int i) {
			return getRuleContext(Function_callContext.class,i);
		}
		public List<Simple_declContext> simple_decl() {
			return getRuleContexts(Simple_declContext.class);
		}
		public WaterContext water(int i) {
			return getRuleContext(WaterContext.class,i);
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
			setState(148);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << 1) | (1L << 2) | (1L << 3) | (1L << 4) | (1L << 5) | (1L << 6) | (1L << 7) | (1L << 8) | (1L << 9) | (1L << 10) | (1L << 11) | (1L << 12) | (1L << 13) | (1L << 14) | (1L << 15) | (1L << 16) | (1L << 17) | (1L << 18) | (1L << 19) | (1L << 20) | (1L << 21) | (1L << 22) | (1L << 23) | (1L << 24) | (1L << 25) | (1L << 26) | (1L << 27) | (1L << 28) | (1L << 29) | (1L << 30) | (1L << 31) | (1L << 32) | (1L << 33) | (1L << 34) | (1L << 35) | (1L << 36) | (1L << 37) | (1L << 38) | (1L << 39) | (1L << 40) | (1L << 41) | (1L << 42) | (1L << 43) | (1L << 44) | (1L << 45) | (1L << 46) | (1L << 47) | (1L << 48) | (1L << 49) | (1L << 50) | (1L << 51) | (1L << 52) | (1L << 53) | (1L << 54) | (1L << 55) | (1L << 56) | (1L << 57) | (1L << 58) | (1L << IF) | (1L << ELSE) | (1L << FOR) | (1L << WHILE) | (1L << BREAK))) != 0) || ((((_la - 64)) & ~0x3f) == 0 && ((1L << (_la - 64)) & ((1L << (CASE - 64)) | (1L << (CONTINUE - 64)) | (1L << (SWITCH - 64)) | (1L << (GOTO - 64)) | (1L << (RETURN - 64)) | (1L << (TYPEDEF - 64)) | (1L << (VOID - 64)) | (1L << (UNSIGNED - 64)) | (1L << (SIGNED - 64)) | (1L << (LONG - 64)) | (1L << (CV_QUALIFIER - 64)) | (1L << (VIRTUAL - 64)) | (1L << (TRY - 64)) | (1L << (CATCH - 64)) | (1L << (THROW - 64)) | (1L << (USING - 64)) | (1L << (NAMESPACE - 64)) | (1L << (AUTO - 64)) | (1L << (REGISTER - 64)) | (1L << (OPERATOR - 64)) | (1L << (TEMPLATE - 64)) | (1L << (ALPHA_NUMERIC - 64)) | (1L << (OPENING_CURLY - 64)) | (1L << (CLOSING_CURLY - 64)) | (1L << (PRE_IF - 64)) | (1L << (PRE_ELSE - 64)) | (1L << (PRE_ENDIF - 64)) | (1L << (HEX_LITERAL - 64)) | (1L << (DECIMAL_LITERAL - 64)) | (1L << (OCTAL_LITERAL - 64)) | (1L << (FLOATING_POINT_LITERAL - 64)) | (1L << (CHAR - 64)) | (1L << (STRING - 64)) | (1L << (COMMENT - 64)) | (1L << (WHITESPACE - 64)) | (1L << (CPPCOMMENT - 64)) | (1L << (OTHER - 64)) | (1L << (23 - 64)) | (1L << (32 - 64)) | (1L << (40 - 64)) | (1L << (TYPEDEF - 64)) | (1L << (VOID - 64)) | (1L << (UNSIGNED - 64)) | (1L << (SIGNED - 64)) | (1L << (LONG - 64)) | (1L << (CV_QUALIFIER - 64)) | (1L << (TEMPLATE - 64)) | (1L << (ALPHA_NUMERIC - 64)) | (1L << (HEX_LITERAL - 64)) | (1L << (DECIMAL_LITERAL - 64)) | (1L << (OCTAL_LITERAL - 64)) | (1L << (FLOATING_POINT_LITERAL - 64)) | (1L << (CHAR - 64)) | (1L << (STRING - 64)))) != 0)) {
				{
				setState(146);
				switch ( getInterpreter().adaptivePredict(_input,0,_ctx) ) {
				case 1:
					{
					setState(142); simple_decl();
					}
					break;

				case 2:
					{
					setState(143); function_call();
					}
					break;

				case 3:
					{
					setState(144); field();
					}
					break;

				case 4:
					{
					setState(145); water();
					}
					break;
				}
				}
				setState(150);
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

	public static class Function_callContext extends ParserRuleContext {
		public FieldContext field() {
			return getRuleContext(FieldContext.class,0);
		}
		public Function_call_tailContext function_call_tail() {
			return getRuleContext(Function_call_tailContext.class,0);
		}
		public Function_callContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_function_call; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof SymbolsListener ) ((SymbolsListener)listener).enterFunction_call(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SymbolsListener ) ((SymbolsListener)listener).exitFunction_call(this);
		}
	}

	public final Function_callContext function_call() throws RecognitionException {
		Function_callContext _localctx = new Function_callContext(_ctx, getState());
		enterRule(_localctx, 2, RULE_function_call);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(151); field();
			setState(152); function_call_tail();
			}
		}
		catch (RecognitionException re) {
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
		enterRule(_localctx, 4, RULE_simple_decl);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(155);
			_la = _input.LA(1);
			if (_la==TYPEDEF) {
				{
				setState(154); match(TYPEDEF);
				}
			}

			setState(158);
			_la = _input.LA(1);
			if (_la==TEMPLATE) {
				{
				setState(157); template_decl_start();
				}
			}

			setState(160); var_decl();
			}
		}
		catch (RecognitionException re) {
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
		enterRule(_localctx, 6, RULE_var_decl);
		try {
			setState(169);
			switch ( getInterpreter().adaptivePredict(_input,5,_ctx) ) {
			case 1:
				_localctx = new DeclByTypeContext(_localctx);
				enterOuterAlt(_localctx, 1);
				{
				setState(162); type_name();
				setState(163); init_declarator_list();
				}
				break;

			case 2:
				_localctx = new DeclByClassContext(_localctx);
				enterOuterAlt(_localctx, 2);
				{
				setState(165); class_def();
				setState(167);
				switch ( getInterpreter().adaptivePredict(_input,4,_ctx) ) {
				case 1:
					{
					setState(166); init_declarator_list();
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
		enterRule(_localctx, 8, RULE_init_declarator_list);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(171); init_declarator();
			setState(176);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==29) {
				{
				{
				setState(172); match(29);
				setState(173); init_declarator();
				}
				}
				setState(178);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(179); match(49);
			}
		}
		catch (RecognitionException re) {
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
		enterRule(_localctx, 10, RULE_init_declarator);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			{
			setState(182);
			_la = _input.LA(1);
			if (_la==1 || _la==3) {
				{
				setState(181); ptrs();
				}
			}

			setState(184); identifier();
			setState(186);
			switch ( getInterpreter().adaptivePredict(_input,8,_ctx) ) {
			case 1:
				{
				setState(185); type_suffix();
				}
				break;
			}
			}
			setState(195);
			switch (_input.LA(1)) {
			case 32:
				{
				{
				setState(188); match(32);
				setState(190);
				_la = _input.LA(1);
				if ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << 1) | (1L << 3) | (1L << 5) | (1L << 22) | (1L << 30) | (1L << 32) | (1L << 42) | (1L << 47) | (1L << 57))) != 0) || ((((_la - 85)) & ~0x3f) == 0 && ((1L << (_la - 85)) & ((1L << (ALPHA_NUMERIC - 85)) | (1L << (HEX_LITERAL - 85)) | (1L << (DECIMAL_LITERAL - 85)) | (1L << (OCTAL_LITERAL - 85)) | (1L << (FLOATING_POINT_LITERAL - 85)) | (1L << (CHAR - 85)) | (1L << (STRING - 85)))) != 0)) {
					{
					setState(189); expr();
					}
				}

				setState(192); match(13);
				}
				}
				break;
			case 17:
				{
				{
				setState(193); match(17);
				setState(194); assign_expr_w_();
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
		enterRule(_localctx, 12, RULE_assign_expr_w_);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(200);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << 1) | (1L << 3) | (1L << 4) | (1L << 5) | (1L << 6) | (1L << 7) | (1L << 8) | (1L << 9) | (1L << 10) | (1L << 11) | (1L << 12) | (1L << 14) | (1L << 15) | (1L << 16) | (1L << 17) | (1L << 18) | (1L << 19) | (1L << 20) | (1L << 21) | (1L << 22) | (1L << 23) | (1L << 25) | (1L << 26) | (1L << 27) | (1L << 28) | (1L << 30) | (1L << 31) | (1L << 33) | (1L << 34) | (1L << 35) | (1L << 36) | (1L << 37) | (1L << 38) | (1L << 39) | (1L << 40) | (1L << 41) | (1L << 42) | (1L << 43) | (1L << 44) | (1L << 45) | (1L << 46) | (1L << 47) | (1L << 48) | (1L << 50) | (1L << 51) | (1L << 52) | (1L << 53) | (1L << 54) | (1L << 55) | (1L << 56) | (1L << 57) | (1L << 58) | (1L << IF) | (1L << ELSE) | (1L << FOR) | (1L << WHILE) | (1L << BREAK))) != 0) || ((((_la - 64)) & ~0x3f) == 0 && ((1L << (_la - 64)) & ((1L << (CASE - 64)) | (1L << (CONTINUE - 64)) | (1L << (SWITCH - 64)) | (1L << (GOTO - 64)) | (1L << (RETURN - 64)) | (1L << (TYPEDEF - 64)) | (1L << (VOID - 64)) | (1L << (UNSIGNED - 64)) | (1L << (SIGNED - 64)) | (1L << (LONG - 64)) | (1L << (CV_QUALIFIER - 64)) | (1L << (VIRTUAL - 64)) | (1L << (TRY - 64)) | (1L << (CATCH - 64)) | (1L << (THROW - 64)) | (1L << (USING - 64)) | (1L << (NAMESPACE - 64)) | (1L << (AUTO - 64)) | (1L << (REGISTER - 64)) | (1L << (OPERATOR - 64)) | (1L << (TEMPLATE - 64)) | (1L << (ALPHA_NUMERIC - 64)) | (1L << (PRE_IF - 64)) | (1L << (PRE_ELSE - 64)) | (1L << (PRE_ENDIF - 64)) | (1L << (HEX_LITERAL - 64)) | (1L << (DECIMAL_LITERAL - 64)) | (1L << (OCTAL_LITERAL - 64)) | (1L << (FLOATING_POINT_LITERAL - 64)) | (1L << (CHAR - 64)) | (1L << (STRING - 64)) | (1L << (COMMENT - 64)) | (1L << (WHITESPACE - 64)) | (1L << (CPPCOMMENT - 64)) | (1L << (OTHER - 64)))) != 0)) {
				{
				{
				setState(197); assign_water();
				}
				}
				setState(202);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(225);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==2 || _la==32 || _la==OPENING_CURLY) {
				{
				{
				setState(215);
				switch (_input.LA(1)) {
				case OPENING_CURLY:
					{
					setState(203); match(OPENING_CURLY);
					setState(204); assign_expr_w__l2();
					setState(205); match(CLOSING_CURLY);
					}
					break;
				case 32:
					{
					setState(207); match(32);
					setState(208); assign_expr_w__l2();
					setState(209); match(13);
					}
					break;
				case 2:
					{
					setState(211); match(2);
					setState(212); assign_expr_w__l2();
					setState(213); match(24);
					}
					break;
				default:
					throw new NoViableAltException(this);
				}
				setState(220);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << 1) | (1L << 3) | (1L << 4) | (1L << 5) | (1L << 6) | (1L << 7) | (1L << 8) | (1L << 9) | (1L << 10) | (1L << 11) | (1L << 12) | (1L << 14) | (1L << 15) | (1L << 16) | (1L << 17) | (1L << 18) | (1L << 19) | (1L << 20) | (1L << 21) | (1L << 22) | (1L << 23) | (1L << 25) | (1L << 26) | (1L << 27) | (1L << 28) | (1L << 30) | (1L << 31) | (1L << 33) | (1L << 34) | (1L << 35) | (1L << 36) | (1L << 37) | (1L << 38) | (1L << 39) | (1L << 40) | (1L << 41) | (1L << 42) | (1L << 43) | (1L << 44) | (1L << 45) | (1L << 46) | (1L << 47) | (1L << 48) | (1L << 50) | (1L << 51) | (1L << 52) | (1L << 53) | (1L << 54) | (1L << 55) | (1L << 56) | (1L << 57) | (1L << 58) | (1L << IF) | (1L << ELSE) | (1L << FOR) | (1L << WHILE) | (1L << BREAK))) != 0) || ((((_la - 64)) & ~0x3f) == 0 && ((1L << (_la - 64)) & ((1L << (CASE - 64)) | (1L << (CONTINUE - 64)) | (1L << (SWITCH - 64)) | (1L << (GOTO - 64)) | (1L << (RETURN - 64)) | (1L << (TYPEDEF - 64)) | (1L << (VOID - 64)) | (1L << (UNSIGNED - 64)) | (1L << (SIGNED - 64)) | (1L << (LONG - 64)) | (1L << (CV_QUALIFIER - 64)) | (1L << (VIRTUAL - 64)) | (1L << (TRY - 64)) | (1L << (CATCH - 64)) | (1L << (THROW - 64)) | (1L << (USING - 64)) | (1L << (NAMESPACE - 64)) | (1L << (AUTO - 64)) | (1L << (REGISTER - 64)) | (1L << (OPERATOR - 64)) | (1L << (TEMPLATE - 64)) | (1L << (ALPHA_NUMERIC - 64)) | (1L << (PRE_IF - 64)) | (1L << (PRE_ELSE - 64)) | (1L << (PRE_ENDIF - 64)) | (1L << (HEX_LITERAL - 64)) | (1L << (DECIMAL_LITERAL - 64)) | (1L << (OCTAL_LITERAL - 64)) | (1L << (FLOATING_POINT_LITERAL - 64)) | (1L << (CHAR - 64)) | (1L << (STRING - 64)) | (1L << (COMMENT - 64)) | (1L << (WHITESPACE - 64)) | (1L << (CPPCOMMENT - 64)) | (1L << (OTHER - 64)))) != 0)) {
					{
					{
					setState(217); assign_water();
					}
					}
					setState(222);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
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
		enterRule(_localctx, 14, RULE_assign_expr_w__l2);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(231);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << 1) | (1L << 3) | (1L << 4) | (1L << 5) | (1L << 6) | (1L << 7) | (1L << 8) | (1L << 9) | (1L << 10) | (1L << 11) | (1L << 12) | (1L << 14) | (1L << 15) | (1L << 16) | (1L << 17) | (1L << 18) | (1L << 19) | (1L << 20) | (1L << 21) | (1L << 22) | (1L << 23) | (1L << 25) | (1L << 26) | (1L << 27) | (1L << 28) | (1L << 29) | (1L << 30) | (1L << 31) | (1L << 33) | (1L << 34) | (1L << 35) | (1L << 36) | (1L << 37) | (1L << 38) | (1L << 39) | (1L << 40) | (1L << 41) | (1L << 42) | (1L << 43) | (1L << 44) | (1L << 45) | (1L << 46) | (1L << 47) | (1L << 48) | (1L << 49) | (1L << 50) | (1L << 51) | (1L << 52) | (1L << 53) | (1L << 54) | (1L << 55) | (1L << 56) | (1L << 57) | (1L << 58) | (1L << IF) | (1L << ELSE) | (1L << FOR) | (1L << WHILE) | (1L << BREAK))) != 0) || ((((_la - 64)) & ~0x3f) == 0 && ((1L << (_la - 64)) & ((1L << (CASE - 64)) | (1L << (CONTINUE - 64)) | (1L << (SWITCH - 64)) | (1L << (GOTO - 64)) | (1L << (RETURN - 64)) | (1L << (TYPEDEF - 64)) | (1L << (VOID - 64)) | (1L << (UNSIGNED - 64)) | (1L << (SIGNED - 64)) | (1L << (LONG - 64)) | (1L << (CV_QUALIFIER - 64)) | (1L << (VIRTUAL - 64)) | (1L << (TRY - 64)) | (1L << (CATCH - 64)) | (1L << (THROW - 64)) | (1L << (USING - 64)) | (1L << (NAMESPACE - 64)) | (1L << (AUTO - 64)) | (1L << (REGISTER - 64)) | (1L << (OPERATOR - 64)) | (1L << (TEMPLATE - 64)) | (1L << (ALPHA_NUMERIC - 64)) | (1L << (PRE_IF - 64)) | (1L << (PRE_ELSE - 64)) | (1L << (PRE_ENDIF - 64)) | (1L << (HEX_LITERAL - 64)) | (1L << (DECIMAL_LITERAL - 64)) | (1L << (OCTAL_LITERAL - 64)) | (1L << (FLOATING_POINT_LITERAL - 64)) | (1L << (CHAR - 64)) | (1L << (STRING - 64)) | (1L << (COMMENT - 64)) | (1L << (WHITESPACE - 64)) | (1L << (CPPCOMMENT - 64)) | (1L << (OTHER - 64)))) != 0)) {
				{
				{
				setState(228); assign_water_l2();
				}
				}
				setState(233);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(256);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==2 || _la==32 || _la==OPENING_CURLY) {
				{
				{
				setState(246);
				switch (_input.LA(1)) {
				case OPENING_CURLY:
					{
					setState(234); match(OPENING_CURLY);
					setState(235); assign_expr_w__l2();
					setState(236); match(CLOSING_CURLY);
					}
					break;
				case 32:
					{
					setState(238); match(32);
					setState(239); assign_expr_w__l2();
					setState(240); match(13);
					}
					break;
				case 2:
					{
					setState(242); match(2);
					setState(243); assign_expr_w__l2();
					setState(244); match(24);
					}
					break;
				default:
					throw new NoViableAltException(this);
				}
				setState(251);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << 1) | (1L << 3) | (1L << 4) | (1L << 5) | (1L << 6) | (1L << 7) | (1L << 8) | (1L << 9) | (1L << 10) | (1L << 11) | (1L << 12) | (1L << 14) | (1L << 15) | (1L << 16) | (1L << 17) | (1L << 18) | (1L << 19) | (1L << 20) | (1L << 21) | (1L << 22) | (1L << 23) | (1L << 25) | (1L << 26) | (1L << 27) | (1L << 28) | (1L << 29) | (1L << 30) | (1L << 31) | (1L << 33) | (1L << 34) | (1L << 35) | (1L << 36) | (1L << 37) | (1L << 38) | (1L << 39) | (1L << 40) | (1L << 41) | (1L << 42) | (1L << 43) | (1L << 44) | (1L << 45) | (1L << 46) | (1L << 47) | (1L << 48) | (1L << 49) | (1L << 50) | (1L << 51) | (1L << 52) | (1L << 53) | (1L << 54) | (1L << 55) | (1L << 56) | (1L << 57) | (1L << 58) | (1L << IF) | (1L << ELSE) | (1L << FOR) | (1L << WHILE) | (1L << BREAK))) != 0) || ((((_la - 64)) & ~0x3f) == 0 && ((1L << (_la - 64)) & ((1L << (CASE - 64)) | (1L << (CONTINUE - 64)) | (1L << (SWITCH - 64)) | (1L << (GOTO - 64)) | (1L << (RETURN - 64)) | (1L << (TYPEDEF - 64)) | (1L << (VOID - 64)) | (1L << (UNSIGNED - 64)) | (1L << (SIGNED - 64)) | (1L << (LONG - 64)) | (1L << (CV_QUALIFIER - 64)) | (1L << (VIRTUAL - 64)) | (1L << (TRY - 64)) | (1L << (CATCH - 64)) | (1L << (THROW - 64)) | (1L << (USING - 64)) | (1L << (NAMESPACE - 64)) | (1L << (AUTO - 64)) | (1L << (REGISTER - 64)) | (1L << (OPERATOR - 64)) | (1L << (TEMPLATE - 64)) | (1L << (ALPHA_NUMERIC - 64)) | (1L << (PRE_IF - 64)) | (1L << (PRE_ELSE - 64)) | (1L << (PRE_ENDIF - 64)) | (1L << (HEX_LITERAL - 64)) | (1L << (DECIMAL_LITERAL - 64)) | (1L << (OCTAL_LITERAL - 64)) | (1L << (FLOATING_POINT_LITERAL - 64)) | (1L << (CHAR - 64)) | (1L << (STRING - 64)) | (1L << (COMMENT - 64)) | (1L << (WHITESPACE - 64)) | (1L << (CPPCOMMENT - 64)) | (1L << (OTHER - 64)))) != 0)) {
					{
					{
					setState(248); assign_water_l2();
					}
					}
					setState(253);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				}
				}
				setState(258);
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
		enterRule(_localctx, 16, RULE_class_def);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(259); class_key();
			setState(261);
			_la = _input.LA(1);
			if (_la==ALPHA_NUMERIC) {
				{
				setState(260); class_name();
				}
			}

			setState(264);
			_la = _input.LA(1);
			if (_la==31) {
				{
				setState(263); base_classes();
				}
			}

			setState(266); match(OPENING_CURLY);
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
		enterRule(_localctx, 18, RULE_class_name);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(269); identifier();
			}
		}
		catch (RecognitionException re) {
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
		enterRule(_localctx, 20, RULE_base_classes);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(271); match(31);
			setState(272); base_class();
			setState(277);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==29) {
				{
				{
				setState(273); match(29);
				setState(274); base_class();
				}
				}
				setState(279);
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
		enterRule(_localctx, 22, RULE_base_class);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(281);
			_la = _input.LA(1);
			if (_la==VIRTUAL) {
				{
				setState(280); match(VIRTUAL);
				}
			}

			setState(284);
			_la = _input.LA(1);
			if ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << 28) | (1L << 34) | (1L << 48))) != 0)) {
				{
				setState(283); access_specifier();
				}
			}

			setState(286); identifier();
			}
		}
		catch (RecognitionException re) {
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
		enterRule(_localctx, 24, RULE_type_name);
		int _la;
		try {
			setState(320);
			switch ( getInterpreter().adaptivePredict(_input,29,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				{
				setState(291);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (_la==CV_QUALIFIER) {
					{
					{
					setState(288); match(CV_QUALIFIER);
					}
					}
					setState(293);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				setState(297);
				switch (_input.LA(1)) {
				case 12:
				case 20:
				case 23:
				case 40:
					{
					setState(294); class_key();
					}
					break;
				case UNSIGNED:
					{
					setState(295); match(UNSIGNED);
					}
					break;
				case SIGNED:
					{
					setState(296); match(SIGNED);
					}
					break;
				case VOID:
				case LONG:
				case ALPHA_NUMERIC:
					break;
				default:
					throw new NoViableAltException(this);
				}
				setState(299); base_type();
				setState(304);
				_la = _input.LA(1);
				if (_la==4) {
					{
					setState(300); match(4);
					setState(301); template_param_list();
					setState(302); match(52);
					}
				}

				setState(316);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (_la==14) {
					{
					{
					setState(306); match(14);
					setState(307); base_type();
					setState(312);
					_la = _input.LA(1);
					if (_la==4) {
						{
						setState(308); match(4);
						setState(309); template_param_list();
						setState(310); match(52);
						}
					}

					}
					}
					setState(318);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				}
				}
				break;

			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(319);
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
		enterRule(_localctx, 26, RULE_type_suffix);
		try {
			setState(327);
			switch (_input.LA(1)) {
			case 2:
				enterOuterAlt(_localctx, 1);
				{
				{
				setState(322); match(2);
				setState(323); constant_expr_w_();
				setState(324); match(24);
				}
				}
				break;
			case 32:
				enterOuterAlt(_localctx, 2);
				{
				setState(326); param_type_list();
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
		enterRule(_localctx, 28, RULE_base_type);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(334);
			switch ( getInterpreter().adaptivePredict(_input,31,_ctx) ) {
			case 1:
				{
				setState(329); match(ALPHA_NUMERIC);
				}
				break;

			case 2:
				{
				setState(330); match(VOID);
				}
				break;

			case 3:
				{
				setState(331); match(LONG);
				}
				break;

			case 4:
				{
				setState(332); match(LONG);
				setState(333); match(LONG);
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
		enterRule(_localctx, 30, RULE_constant_expr_w_);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(339);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << 1) | (1L << 3) | (1L << 4) | (1L << 5) | (1L << 6) | (1L << 7) | (1L << 8) | (1L << 9) | (1L << 10) | (1L << 11) | (1L << 12) | (1L << 13) | (1L << 14) | (1L << 15) | (1L << 16) | (1L << 17) | (1L << 18) | (1L << 19) | (1L << 20) | (1L << 21) | (1L << 22) | (1L << 23) | (1L << 25) | (1L << 26) | (1L << 27) | (1L << 28) | (1L << 29) | (1L << 30) | (1L << 31) | (1L << 32) | (1L << 33) | (1L << 34) | (1L << 35) | (1L << 36) | (1L << 37) | (1L << 38) | (1L << 39) | (1L << 40) | (1L << 41) | (1L << 42) | (1L << 43) | (1L << 44) | (1L << 45) | (1L << 46) | (1L << 47) | (1L << 48) | (1L << 49) | (1L << 50) | (1L << 51) | (1L << 52) | (1L << 53) | (1L << 54) | (1L << 55) | (1L << 56) | (1L << 57) | (1L << 58) | (1L << IF) | (1L << ELSE) | (1L << FOR) | (1L << WHILE) | (1L << BREAK))) != 0) || ((((_la - 64)) & ~0x3f) == 0 && ((1L << (_la - 64)) & ((1L << (CASE - 64)) | (1L << (CONTINUE - 64)) | (1L << (SWITCH - 64)) | (1L << (GOTO - 64)) | (1L << (RETURN - 64)) | (1L << (TYPEDEF - 64)) | (1L << (VOID - 64)) | (1L << (UNSIGNED - 64)) | (1L << (SIGNED - 64)) | (1L << (LONG - 64)) | (1L << (CV_QUALIFIER - 64)) | (1L << (VIRTUAL - 64)) | (1L << (TRY - 64)) | (1L << (CATCH - 64)) | (1L << (THROW - 64)) | (1L << (USING - 64)) | (1L << (NAMESPACE - 64)) | (1L << (AUTO - 64)) | (1L << (REGISTER - 64)) | (1L << (OPERATOR - 64)) | (1L << (TEMPLATE - 64)) | (1L << (ALPHA_NUMERIC - 64)) | (1L << (OPENING_CURLY - 64)) | (1L << (CLOSING_CURLY - 64)) | (1L << (PRE_IF - 64)) | (1L << (PRE_ELSE - 64)) | (1L << (PRE_ENDIF - 64)) | (1L << (HEX_LITERAL - 64)) | (1L << (DECIMAL_LITERAL - 64)) | (1L << (OCTAL_LITERAL - 64)) | (1L << (FLOATING_POINT_LITERAL - 64)) | (1L << (CHAR - 64)) | (1L << (STRING - 64)) | (1L << (COMMENT - 64)) | (1L << (WHITESPACE - 64)) | (1L << (CPPCOMMENT - 64)) | (1L << (OTHER - 64)))) != 0)) {
				{
				{
				setState(336); no_squares();
				}
				}
				setState(341);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(353);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==2) {
				{
				{
				setState(342); match(2);
				setState(343); constant_expr_w_();
				setState(344); match(24);
				setState(348);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << 1) | (1L << 3) | (1L << 4) | (1L << 5) | (1L << 6) | (1L << 7) | (1L << 8) | (1L << 9) | (1L << 10) | (1L << 11) | (1L << 12) | (1L << 13) | (1L << 14) | (1L << 15) | (1L << 16) | (1L << 17) | (1L << 18) | (1L << 19) | (1L << 20) | (1L << 21) | (1L << 22) | (1L << 23) | (1L << 25) | (1L << 26) | (1L << 27) | (1L << 28) | (1L << 29) | (1L << 30) | (1L << 31) | (1L << 32) | (1L << 33) | (1L << 34) | (1L << 35) | (1L << 36) | (1L << 37) | (1L << 38) | (1L << 39) | (1L << 40) | (1L << 41) | (1L << 42) | (1L << 43) | (1L << 44) | (1L << 45) | (1L << 46) | (1L << 47) | (1L << 48) | (1L << 49) | (1L << 50) | (1L << 51) | (1L << 52) | (1L << 53) | (1L << 54) | (1L << 55) | (1L << 56) | (1L << 57) | (1L << 58) | (1L << IF) | (1L << ELSE) | (1L << FOR) | (1L << WHILE) | (1L << BREAK))) != 0) || ((((_la - 64)) & ~0x3f) == 0 && ((1L << (_la - 64)) & ((1L << (CASE - 64)) | (1L << (CONTINUE - 64)) | (1L << (SWITCH - 64)) | (1L << (GOTO - 64)) | (1L << (RETURN - 64)) | (1L << (TYPEDEF - 64)) | (1L << (VOID - 64)) | (1L << (UNSIGNED - 64)) | (1L << (SIGNED - 64)) | (1L << (LONG - 64)) | (1L << (CV_QUALIFIER - 64)) | (1L << (VIRTUAL - 64)) | (1L << (TRY - 64)) | (1L << (CATCH - 64)) | (1L << (THROW - 64)) | (1L << (USING - 64)) | (1L << (NAMESPACE - 64)) | (1L << (AUTO - 64)) | (1L << (REGISTER - 64)) | (1L << (OPERATOR - 64)) | (1L << (TEMPLATE - 64)) | (1L << (ALPHA_NUMERIC - 64)) | (1L << (OPENING_CURLY - 64)) | (1L << (CLOSING_CURLY - 64)) | (1L << (PRE_IF - 64)) | (1L << (PRE_ELSE - 64)) | (1L << (PRE_ENDIF - 64)) | (1L << (HEX_LITERAL - 64)) | (1L << (DECIMAL_LITERAL - 64)) | (1L << (OCTAL_LITERAL - 64)) | (1L << (FLOATING_POINT_LITERAL - 64)) | (1L << (CHAR - 64)) | (1L << (STRING - 64)) | (1L << (COMMENT - 64)) | (1L << (WHITESPACE - 64)) | (1L << (CPPCOMMENT - 64)) | (1L << (OTHER - 64)))) != 0)) {
					{
					{
					setState(345); no_squares();
					}
					}
					setState(350);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				}
				}
				setState(355);
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
		enterRule(_localctx, 32, RULE_param_decl_specifiers);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(357);
			_la = _input.LA(1);
			if (_la==AUTO || _la==REGISTER) {
				{
				setState(356);
				_la = _input.LA(1);
				if ( !(_la==AUTO || _la==REGISTER) ) {
				_errHandler.recoverInline(this);
				}
				consume();
				}
			}

			setState(359); type_name();
			}
		}
		catch (RecognitionException re) {
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
		enterRule(_localctx, 34, RULE_parameter_name);
		try {
			setState(363);
			switch (_input.LA(1)) {
			case ALPHA_NUMERIC:
				enterOuterAlt(_localctx, 1);
				{
				setState(361); identifier();
				}
				break;
			case 28:
			case 34:
			case 48:
				enterOuterAlt(_localctx, 2);
				{
				setState(362); access_specifier();
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
		enterRule(_localctx, 36, RULE_param_type_list);
		int _la;
		try {
			setState(380);
			switch ( getInterpreter().adaptivePredict(_input,39,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(365); match(32);
				setState(366); match(VOID);
				setState(367); match(13);
				}
				break;

			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(368); match(32);
				setState(377);
				_la = _input.LA(1);
				if ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << 12) | (1L << 20) | (1L << 23) | (1L << 40))) != 0) || ((((_la - 70)) & ~0x3f) == 0 && ((1L << (_la - 70)) & ((1L << (VOID - 70)) | (1L << (UNSIGNED - 70)) | (1L << (SIGNED - 70)) | (1L << (LONG - 70)) | (1L << (CV_QUALIFIER - 70)) | (1L << (AUTO - 70)) | (1L << (REGISTER - 70)) | (1L << (ALPHA_NUMERIC - 70)))) != 0)) {
					{
					setState(369); param_type();
					setState(374);
					_errHandler.sync(this);
					_la = _input.LA(1);
					while (_la==29) {
						{
						{
						setState(370); match(29);
						setState(371); param_type();
						}
						}
						setState(376);
						_errHandler.sync(this);
						_la = _input.LA(1);
					}
					}
				}

				setState(379); match(13);
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
		enterRule(_localctx, 38, RULE_param_type);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(382); param_decl_specifiers();
			setState(383); param_type_id();
			}
		}
		catch (RecognitionException re) {
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
		enterRule(_localctx, 40, RULE_param_type_id);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(386);
			_la = _input.LA(1);
			if (_la==1 || _la==3) {
				{
				setState(385); ptrs();
				}
			}

			setState(395);
			switch ( getInterpreter().adaptivePredict(_input,42,_ctx) ) {
			case 1:
				{
				setState(388); match(32);
				setState(389); param_type_id();
				setState(390); match(13);
				}
				break;

			case 2:
				{
				setState(393);
				_la = _input.LA(1);
				if (((((_la - 28)) & ~0x3f) == 0 && ((1L << (_la - 28)) & ((1L << (28 - 28)) | (1L << (34 - 28)) | (1L << (48 - 28)) | (1L << (ALPHA_NUMERIC - 28)))) != 0)) {
					{
					setState(392); parameter_name();
					}
				}

				}
				break;
			}
			setState(398);
			_la = _input.LA(1);
			if (_la==2 || _la==32) {
				{
				setState(397); type_suffix();
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
		enterRule(_localctx, 42, RULE_identifier);
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(400); match(ALPHA_NUMERIC);
			setState(405);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,44,_ctx);
			while ( _alt!=2 && _alt!=-1 ) {
				if ( _alt==1 ) {
					{
					{
					setState(401); match(14);
					setState(402); match(ALPHA_NUMERIC);
					}
					} 
				}
				setState(407);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,44,_ctx);
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
		enterRule(_localctx, 44, RULE_number);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(408);
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
		enterRule(_localctx, 46, RULE_ptrs);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(411); 
			_errHandler.sync(this);
			_la = _input.LA(1);
			do {
				{
				{
				setState(410); ptr_operator();
				}
				}
				setState(413); 
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
		enterRule(_localctx, 48, RULE_unary_operator);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(415);
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
		enterRule(_localctx, 50, RULE_relational_operator);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(417);
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
		enterRule(_localctx, 52, RULE_constant);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(419);
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
		enterRule(_localctx, 54, RULE_function_decl_specifiers);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(421);
			_la = _input.LA(1);
			if ( !(((((_la - 15)) & ~0x3f) == 0 && ((1L << (_la - 15)) & ((1L << (15 - 15)) | (1L << (16 - 15)) | (1L << (39 - 15)) | (1L << (41 - 15)) | (1L << (VIRTUAL - 15)))) != 0)) ) {
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
		enterRule(_localctx, 56, RULE_class_key);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(423);
			_la = _input.LA(1);
			if ( !((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << 12) | (1L << 20) | (1L << 23) | (1L << 40))) != 0)) ) {
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
		enterRule(_localctx, 58, RULE_ptr_operator);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(425);
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
		enterRule(_localctx, 60, RULE_access_specifier);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(427);
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
		enterRule(_localctx, 62, RULE_operator_function_id);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(429); match(OPERATOR);
			setState(430); operator();
			}
		}
		catch (RecognitionException re) {
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
		enterRule(_localctx, 64, RULE_operator);
		int _la;
		try {
			setState(477);
			switch (_input.LA(1)) {
			case 19:
			case 45:
				enterOuterAlt(_localctx, 1);
				{
				{
				setState(432);
				_la = _input.LA(1);
				if ( !(_la==19 || _la==45) ) {
				_errHandler.recoverInline(this);
				}
				consume();
				setState(435);
				_la = _input.LA(1);
				if (_la==2) {
					{
					setState(433); match(2);
					setState(434); match(24);
					}
				}

				}
				}
				break;
			case 47:
				enterOuterAlt(_localctx, 2);
				{
				setState(437); match(47);
				}
				break;
			case 30:
				enterOuterAlt(_localctx, 3);
				{
				setState(438); match(30);
				}
				break;
			case 3:
				enterOuterAlt(_localctx, 4);
				{
				setState(439); match(3);
				}
				break;
			case 55:
				enterOuterAlt(_localctx, 5);
				{
				setState(440); match(55);
				}
				break;
			case 9:
				enterOuterAlt(_localctx, 6);
				{
				setState(441); match(9);
				}
				break;
			case 44:
				enterOuterAlt(_localctx, 7);
				{
				setState(442); match(44);
				}
				break;
			case 1:
				enterOuterAlt(_localctx, 8);
				{
				setState(443); match(1);
				}
				break;
			case 21:
				enterOuterAlt(_localctx, 9);
				{
				setState(444); match(21);
				}
				break;
			case 57:
				enterOuterAlt(_localctx, 10);
				{
				setState(445); match(57);
				}
				break;
			case 22:
				enterOuterAlt(_localctx, 11);
				{
				setState(446); match(22);
				}
				break;
			case 17:
				enterOuterAlt(_localctx, 12);
				{
				setState(447); match(17);
				}
				break;
			case 4:
				enterOuterAlt(_localctx, 13);
				{
				setState(448); match(4);
				}
				break;
			case 52:
				enterOuterAlt(_localctx, 14);
				{
				setState(449); match(52);
				}
				break;
			case 37:
				enterOuterAlt(_localctx, 15);
				{
				setState(450); match(37);
				}
				break;
			case 26:
				enterOuterAlt(_localctx, 16);
				{
				setState(451); match(26);
				}
				break;
			case 11:
				enterOuterAlt(_localctx, 17);
				{
				setState(452); match(11);
				}
				break;
			case 54:
				enterOuterAlt(_localctx, 18);
				{
				setState(453); match(54);
				}
				break;
			case 53:
				enterOuterAlt(_localctx, 19);
				{
				setState(454); match(53);
				}
				break;
			case 38:
				enterOuterAlt(_localctx, 20);
				{
				setState(455); match(38);
				}
				break;
			case 33:
				enterOuterAlt(_localctx, 21);
				{
				setState(456); match(33);
				}
				break;
			case 18:
				enterOuterAlt(_localctx, 22);
				{
				setState(457); match(18);
				}
				break;
			case 43:
				enterOuterAlt(_localctx, 23);
				{
				setState(458); match(43);
				}
				break;
			case 8:
				enterOuterAlt(_localctx, 24);
				{
				setState(459); match(8);
				}
				break;
			case 36:
				enterOuterAlt(_localctx, 25);
				{
				setState(460); match(36);
				}
				break;
			case 25:
				enterOuterAlt(_localctx, 26);
				{
				setState(461); match(25);
				}
				break;
			case 56:
				enterOuterAlt(_localctx, 27);
				{
				setState(462); match(56);
				}
				break;
			case 6:
				enterOuterAlt(_localctx, 28);
				{
				setState(463); match(6);
				}
				break;
			case 7:
				enterOuterAlt(_localctx, 29);
				{
				setState(464); match(7);
				}
				break;
			case 58:
				enterOuterAlt(_localctx, 30);
				{
				setState(465); match(58);
				}
				break;
			case 50:
				enterOuterAlt(_localctx, 31);
				{
				setState(466); match(50);
				}
				break;
			case 51:
				enterOuterAlt(_localctx, 32);
				{
				setState(467); match(51);
				}
				break;
			case 42:
				enterOuterAlt(_localctx, 33);
				{
				setState(468); match(42);
				}
				break;
			case 5:
				enterOuterAlt(_localctx, 34);
				{
				setState(469); match(5);
				}
				break;
			case 29:
				enterOuterAlt(_localctx, 35);
				{
				setState(470); match(29);
				}
				break;
			case 27:
				enterOuterAlt(_localctx, 36);
				{
				setState(471); match(27);
				}
				break;
			case 10:
				enterOuterAlt(_localctx, 37);
				{
				setState(472); match(10);
				}
				break;
			case 32:
				enterOuterAlt(_localctx, 38);
				{
				setState(473); match(32);
				setState(474); match(13);
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 39);
				{
				setState(475); match(2);
				setState(476); match(24);
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
		enterRule(_localctx, 66, RULE_assignment_operator);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(479);
			_la = _input.LA(1);
			if ( !((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << 11) | (1L << 17) | (1L << 18) | (1L << 25) | (1L << 26) | (1L << 33) | (1L << 36) | (1L << 37) | (1L << 38) | (1L << 53) | (1L << 54))) != 0)) ) {
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
		enterRule(_localctx, 68, RULE_equality_operator);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(481);
			_la = _input.LA(1);
			if ( !(_la==6 || _la==56) ) {
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
		enterRule(_localctx, 70, RULE_template_decl_start);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(483); match(TEMPLATE);
			setState(484); match(4);
			setState(485); template_param_list();
			setState(486); match(52);
			}
		}
		catch (RecognitionException re) {
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
		enterRule(_localctx, 72, RULE_template_param_list);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(499);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << 1) | (1L << 2) | (1L << 3) | (1L << 4) | (1L << 5) | (1L << 6) | (1L << 7) | (1L << 8) | (1L << 9) | (1L << 10) | (1L << 11) | (1L << 12) | (1L << 14) | (1L << 15) | (1L << 16) | (1L << 17) | (1L << 18) | (1L << 19) | (1L << 20) | (1L << 21) | (1L << 22) | (1L << 23) | (1L << 24) | (1L << 25) | (1L << 26) | (1L << 27) | (1L << 28) | (1L << 29) | (1L << 30) | (1L << 31) | (1L << 32) | (1L << 33) | (1L << 34) | (1L << 35) | (1L << 36) | (1L << 37) | (1L << 38) | (1L << 39) | (1L << 40) | (1L << 41) | (1L << 42) | (1L << 43) | (1L << 44) | (1L << 45) | (1L << 46) | (1L << 47) | (1L << 48) | (1L << 49) | (1L << 50) | (1L << 51) | (1L << 53) | (1L << 54) | (1L << 55) | (1L << 56) | (1L << 57) | (1L << 58) | (1L << IF) | (1L << ELSE) | (1L << FOR) | (1L << WHILE) | (1L << BREAK))) != 0) || ((((_la - 64)) & ~0x3f) == 0 && ((1L << (_la - 64)) & ((1L << (CASE - 64)) | (1L << (CONTINUE - 64)) | (1L << (SWITCH - 64)) | (1L << (GOTO - 64)) | (1L << (RETURN - 64)) | (1L << (TYPEDEF - 64)) | (1L << (VOID - 64)) | (1L << (UNSIGNED - 64)) | (1L << (SIGNED - 64)) | (1L << (LONG - 64)) | (1L << (CV_QUALIFIER - 64)) | (1L << (VIRTUAL - 64)) | (1L << (TRY - 64)) | (1L << (CATCH - 64)) | (1L << (THROW - 64)) | (1L << (USING - 64)) | (1L << (NAMESPACE - 64)) | (1L << (AUTO - 64)) | (1L << (REGISTER - 64)) | (1L << (OPERATOR - 64)) | (1L << (TEMPLATE - 64)) | (1L << (ALPHA_NUMERIC - 64)) | (1L << (OPENING_CURLY - 64)) | (1L << (CLOSING_CURLY - 64)) | (1L << (PRE_IF - 64)) | (1L << (PRE_ELSE - 64)) | (1L << (PRE_ENDIF - 64)) | (1L << (HEX_LITERAL - 64)) | (1L << (DECIMAL_LITERAL - 64)) | (1L << (OCTAL_LITERAL - 64)) | (1L << (FLOATING_POINT_LITERAL - 64)) | (1L << (CHAR - 64)) | (1L << (STRING - 64)) | (1L << (COMMENT - 64)) | (1L << (WHITESPACE - 64)) | (1L << (CPPCOMMENT - 64)) | (1L << (OTHER - 64)))) != 0)) {
				{
				setState(497);
				switch (_input.LA(1)) {
				case 4:
					{
					{
					setState(488); match(4);
					setState(489); template_param_list();
					setState(490); match(52);
					}
					}
					break;
				case 32:
					{
					{
					setState(492); match(32);
					setState(493); template_param_list();
					setState(494); match(13);
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
				case 31:
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
					setState(496); no_angle_brackets_or_brackets();
					}
					break;
				default:
					throw new NoViableAltException(this);
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
		enterRule(_localctx, 74, RULE_no_brackets);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(502);
			_la = _input.LA(1);
			if ( _la <= 0 || (_la==13 || _la==32) ) {
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
		enterRule(_localctx, 76, RULE_no_brackets_curlies_or_squares);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(504);
			_la = _input.LA(1);
			if ( _la <= 0 || ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << 2) | (1L << 13) | (1L << 24) | (1L << 32))) != 0) || _la==OPENING_CURLY || _la==CLOSING_CURLY) ) {
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
		enterRule(_localctx, 78, RULE_no_brackets_or_semicolon);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(506);
			_la = _input.LA(1);
			if ( _la <= 0 || ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << 13) | (1L << 32) | (1L << 49))) != 0)) ) {
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
		enterRule(_localctx, 80, RULE_no_angle_brackets_or_brackets);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(508);
			_la = _input.LA(1);
			if ( _la <= 0 || ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << 4) | (1L << 13) | (1L << 32) | (1L << 52))) != 0)) ) {
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
		enterRule(_localctx, 82, RULE_no_curlies);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(510);
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
		enterRule(_localctx, 84, RULE_no_squares);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(512);
			_la = _input.LA(1);
			if ( _la <= 0 || (_la==2 || _la==24) ) {
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
		enterRule(_localctx, 86, RULE_no_squares_or_semicolon);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(514);
			_la = _input.LA(1);
			if ( _la <= 0 || ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << 2) | (1L << 24) | (1L << 49))) != 0)) ) {
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
		enterRule(_localctx, 88, RULE_no_comma_or_semicolon);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(516);
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
		enterRule(_localctx, 90, RULE_assign_water);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(518);
			_la = _input.LA(1);
			if ( _la <= 0 || ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << 2) | (1L << 13) | (1L << 24) | (1L << 29) | (1L << 32) | (1L << 49))) != 0) || _la==OPENING_CURLY || _la==CLOSING_CURLY) ) {
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
		enterRule(_localctx, 92, RULE_assign_water_l2);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(520);
			_la = _input.LA(1);
			if ( _la <= 0 || ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << 2) | (1L << 13) | (1L << 24) | (1L << 32))) != 0) || _la==OPENING_CURLY || _la==CLOSING_CURLY) ) {
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
		enterRule(_localctx, 94, RULE_water);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(522);
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
		enterRule(_localctx, 96, RULE_expr);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(524); assign_expr();
			setState(527);
			_la = _input.LA(1);
			if (_la==29) {
				{
				setState(525); match(29);
				setState(526); assign_expr();
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
		enterRule(_localctx, 98, RULE_assign_expr);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(529); conditional_expression();
			setState(533);
			_la = _input.LA(1);
			if ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << 11) | (1L << 17) | (1L << 18) | (1L << 25) | (1L << 26) | (1L << 33) | (1L << 36) | (1L << 37) | (1L << 38) | (1L << 53) | (1L << 54))) != 0)) {
				{
				setState(530); assignment_operator();
				setState(531); assign_expr();
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
		enterRule(_localctx, 100, RULE_conditional_expression);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(535); or_expression();
			setState(541);
			_la = _input.LA(1);
			if (_la==35) {
				{
				setState(536); match(35);
				setState(537); expr();
				setState(538); match(31);
				setState(539); conditional_expression();
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
		enterRule(_localctx, 102, RULE_or_expression);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(543); and_expression();
			setState(546);
			_la = _input.LA(1);
			if (_la==51) {
				{
				setState(544); match(51);
				setState(545); or_expression();
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
		enterRule(_localctx, 104, RULE_and_expression);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(548); inclusive_or_expression();
			setState(551);
			_la = _input.LA(1);
			if (_la==50) {
				{
				setState(549); match(50);
				setState(550); and_expression();
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
		enterRule(_localctx, 106, RULE_inclusive_or_expression);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(553); exclusive_or_expression();
			setState(556);
			_la = _input.LA(1);
			if (_la==21) {
				{
				setState(554); match(21);
				setState(555); inclusive_or_expression();
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
		enterRule(_localctx, 108, RULE_exclusive_or_expression);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(558); bit_and_expression();
			setState(561);
			_la = _input.LA(1);
			if (_la==44) {
				{
				setState(559); match(44);
				setState(560); exclusive_or_expression();
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
		enterRule(_localctx, 110, RULE_bit_and_expression);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(563); equality_expression();
			setState(566);
			_la = _input.LA(1);
			if (_la==1) {
				{
				setState(564); match(1);
				setState(565); bit_and_expression();
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
		enterRule(_localctx, 112, RULE_equality_expression);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(568); relational_expression();
			setState(572);
			_la = _input.LA(1);
			if (_la==6 || _la==56) {
				{
				setState(569); equality_operator();
				setState(570); equality_expression();
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
		enterRule(_localctx, 114, RULE_relational_expression);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(574); shift_expression();
			setState(578);
			_la = _input.LA(1);
			if ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << 4) | (1L << 7) | (1L << 52) | (1L << 58))) != 0)) {
				{
				setState(575); relational_operator();
				setState(576); relational_expression();
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
		enterRule(_localctx, 116, RULE_shift_expression);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(580); additive_expression();
			setState(583);
			_la = _input.LA(1);
			if (_la==8 || _la==43) {
				{
				setState(581);
				_la = _input.LA(1);
				if ( !(_la==8 || _la==43) ) {
				_errHandler.recoverInline(this);
				}
				consume();
				setState(582); shift_expression();
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
		enterRule(_localctx, 118, RULE_additive_expression);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(585); multiplicative_expression();
			setState(588);
			_la = _input.LA(1);
			if (_la==30 || _la==47) {
				{
				setState(586);
				_la = _input.LA(1);
				if ( !(_la==30 || _la==47) ) {
				_errHandler.recoverInline(this);
				}
				consume();
				setState(587); additive_expression();
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
		enterRule(_localctx, 120, RULE_multiplicative_expression);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(590); cast_expression();
			setState(593);
			_la = _input.LA(1);
			if ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << 3) | (1L << 9) | (1L << 55))) != 0)) {
				{
				setState(591);
				_la = _input.LA(1);
				if ( !((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << 3) | (1L << 9) | (1L << 55))) != 0)) ) {
				_errHandler.recoverInline(this);
				}
				consume();
				setState(592); cast_expression();
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
		enterRule(_localctx, 122, RULE_cast_expression);
		int _la;
		try {
			setState(607);
			switch ( getInterpreter().adaptivePredict(_input,64,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				{
				setState(595); match(32);
				setState(596); type_name();
				setState(600);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (_la==1 || _la==3) {
					{
					{
					setState(597); ptr_operator();
					}
					}
					setState(602);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				setState(603); match(13);
				setState(604); cast_expression();
				}
				}
				break;

			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(606); unary_expression();
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
		enterRule(_localctx, 124, RULE_unary_expression);
		int _la;
		try {
			setState(621);
			switch (_input.LA(1)) {
			case 32:
			case ALPHA_NUMERIC:
			case HEX_LITERAL:
			case DECIMAL_LITERAL:
			case OCTAL_LITERAL:
			case FLOATING_POINT_LITERAL:
			case CHAR:
			case STRING:
				enterOuterAlt(_localctx, 1);
				{
				setState(609); postfix_expression();
				}
				break;
			case 5:
				enterOuterAlt(_localctx, 2);
				{
				setState(610); match(5);
				setState(611); unary_expression();
				}
				break;
			case 42:
				enterOuterAlt(_localctx, 3);
				{
				setState(612); match(42);
				setState(613); unary_expression();
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
				setState(615); 
				_errHandler.sync(this);
				_la = _input.LA(1);
				do {
					{
					{
					setState(614); unary_operator();
					}
					}
					setState(617); 
					_errHandler.sync(this);
					_la = _input.LA(1);
				} while ( (((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << 1) | (1L << 3) | (1L << 22) | (1L << 30) | (1L << 47) | (1L << 57))) != 0) );
				setState(619); postfix_expression();
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
		enterRule(_localctx, 126, RULE_postfix_expression);
		try {
			setState(627);
			switch ( getInterpreter().adaptivePredict(_input,67,_ctx) ) {
			case 1:
				_localctx = new FieldOnlyContext(_localctx);
				enterOuterAlt(_localctx, 1);
				{
				setState(623); field();
				}
				break;

			case 2:
				_localctx = new FuncCallContext(_localctx);
				enterOuterAlt(_localctx, 2);
				{
				setState(624); field();
				setState(625); function_call_tail();
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
		enterRule(_localctx, 128, RULE_field);
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			{
			setState(629); primary_expression();
			setState(633);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,68,_ctx);
			while ( _alt!=2 && _alt!=-1 ) {
				if ( _alt==1 ) {
					{
					{
					setState(630); postfix();
					}
					} 
				}
				setState(635);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,68,_ctx);
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
		enterRule(_localctx, 130, RULE_function_call_tail);
		try {
			setState(640);
			switch (_input.LA(1)) {
			case 4:
				enterOuterAlt(_localctx, 1);
				{
				setState(636); call_template_list();
				setState(637); function_argument_list();
				}
				break;
			case 32:
				enterOuterAlt(_localctx, 2);
				{
				setState(639); function_argument_list();
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
		enterRule(_localctx, 132, RULE_call_template_list);
		try {
			enterOuterAlt(_localctx, 1);
			{
			{
			setState(642); match(4);
			setState(643); template_param_list();
			setState(644); match(52);
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
		enterRule(_localctx, 134, RULE_function_argument_list);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(646); match(32);
			setState(655);
			_la = _input.LA(1);
			if ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << 1) | (1L << 3) | (1L << 5) | (1L << 22) | (1L << 30) | (1L << 32) | (1L << 42) | (1L << 47) | (1L << 57))) != 0) || ((((_la - 85)) & ~0x3f) == 0 && ((1L << (_la - 85)) & ((1L << (ALPHA_NUMERIC - 85)) | (1L << (HEX_LITERAL - 85)) | (1L << (DECIMAL_LITERAL - 85)) | (1L << (OCTAL_LITERAL - 85)) | (1L << (FLOATING_POINT_LITERAL - 85)) | (1L << (CHAR - 85)) | (1L << (STRING - 85)))) != 0)) {
				{
				setState(647); function_argument();
				setState(652);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (_la==29) {
					{
					{
					setState(648); match(29);
					setState(649); function_argument();
					}
					}
					setState(654);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				}
			}

			setState(657); match(13);
			}
		}
		catch (RecognitionException re) {
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
		enterRule(_localctx, 136, RULE_function_argument);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(659); assign_expr();
			}
		}
		catch (RecognitionException re) {
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
		enterRule(_localctx, 138, RULE_postfix);
		try {
			setState(673);
			switch (_input.LA(1)) {
			case 2:
			case 10:
			case 46:
				enterOuterAlt(_localctx, 1);
				{
				setState(669);
				switch (_input.LA(1)) {
				case 46:
					{
					setState(661); match(46);
					setState(662); identifier();
					}
					break;
				case 10:
					{
					setState(663); match(10);
					setState(664); identifier();
					}
					break;
				case 2:
					{
					setState(665); match(2);
					setState(666); expr();
					setState(667); match(24);
					}
					break;
				default:
					throw new NoViableAltException(this);
				}
				}
				break;
			case 42:
				enterOuterAlt(_localctx, 2);
				{
				setState(671); match(42);
				}
				break;
			case 5:
				enterOuterAlt(_localctx, 3);
				{
				setState(672); match(5);
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
		enterRule(_localctx, 140, RULE_primary_expression);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(681);
			switch (_input.LA(1)) {
			case 32:
				{
				setState(675); match(32);
				setState(676); expr();
				setState(677); match(13);
				}
				break;
			case ALPHA_NUMERIC:
				{
				setState(679); identifier();
				}
				break;
			case HEX_LITERAL:
			case DECIMAL_LITERAL:
			case OCTAL_LITERAL:
			case FLOATING_POINT_LITERAL:
			case CHAR:
			case STRING:
				{
				setState(680); constant();
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

	public static final String _serializedATN =
		"\2\3f\u02ae\4\2\t\2\4\3\t\3\4\4\t\4\4\5\t\5\4\6\t\6\4\7\t\7\4\b\t\b\4"+
		"\t\t\t\4\n\t\n\4\13\t\13\4\f\t\f\4\r\t\r\4\16\t\16\4\17\t\17\4\20\t\20"+
		"\4\21\t\21\4\22\t\22\4\23\t\23\4\24\t\24\4\25\t\25\4\26\t\26\4\27\t\27"+
		"\4\30\t\30\4\31\t\31\4\32\t\32\4\33\t\33\4\34\t\34\4\35\t\35\4\36\t\36"+
		"\4\37\t\37\4 \t \4!\t!\4\"\t\"\4#\t#\4$\t$\4%\t%\4&\t&\4\'\t\'\4(\t(\4"+
		")\t)\4*\t*\4+\t+\4,\t,\4-\t-\4.\t.\4/\t/\4\60\t\60\4\61\t\61\4\62\t\62"+
		"\4\63\t\63\4\64\t\64\4\65\t\65\4\66\t\66\4\67\t\67\48\t8\49\t9\4:\t:\4"+
		";\t;\4<\t<\4=\t=\4>\t>\4?\t?\4@\t@\4A\tA\4B\tB\4C\tC\4D\tD\4E\tE\4F\t"+
		"F\4G\tG\4H\tH\3\2\3\2\3\2\3\2\7\2\u0095\n\2\f\2\16\2\u0098\13\2\3\3\3"+
		"\3\3\3\3\4\5\4\u009e\n\4\3\4\5\4\u00a1\n\4\3\4\3\4\3\5\3\5\3\5\3\5\3\5"+
		"\5\5\u00aa\n\5\5\5\u00ac\n\5\3\6\3\6\3\6\7\6\u00b1\n\6\f\6\16\6\u00b4"+
		"\13\6\3\6\3\6\3\7\5\7\u00b9\n\7\3\7\3\7\5\7\u00bd\n\7\3\7\3\7\5\7\u00c1"+
		"\n\7\3\7\3\7\3\7\5\7\u00c6\n\7\3\b\7\b\u00c9\n\b\f\b\16\b\u00cc\13\b\3"+
		"\b\3\b\3\b\3\b\3\b\3\b\3\b\3\b\3\b\3\b\3\b\3\b\5\b\u00da\n\b\3\b\7\b\u00dd"+
		"\n\b\f\b\16\b\u00e0\13\b\7\b\u00e2\n\b\f\b\16\b\u00e5\13\b\3\t\7\t\u00e8"+
		"\n\t\f\t\16\t\u00eb\13\t\3\t\3\t\3\t\3\t\3\t\3\t\3\t\3\t\3\t\3\t\3\t\3"+
		"\t\5\t\u00f9\n\t\3\t\7\t\u00fc\n\t\f\t\16\t\u00ff\13\t\7\t\u0101\n\t\f"+
		"\t\16\t\u0104\13\t\3\n\3\n\5\n\u0108\n\n\3\n\5\n\u010b\n\n\3\n\3\n\3\n"+
		"\3\13\3\13\3\f\3\f\3\f\3\f\7\f\u0116\n\f\f\f\16\f\u0119\13\f\3\r\5\r\u011c"+
		"\n\r\3\r\5\r\u011f\n\r\3\r\3\r\3\16\7\16\u0124\n\16\f\16\16\16\u0127\13"+
		"\16\3\16\3\16\3\16\5\16\u012c\n\16\3\16\3\16\3\16\3\16\3\16\5\16\u0133"+
		"\n\16\3\16\3\16\3\16\3\16\3\16\3\16\5\16\u013b\n\16\7\16\u013d\n\16\f"+
		"\16\16\16\u0140\13\16\3\16\5\16\u0143\n\16\3\17\3\17\3\17\3\17\3\17\5"+
		"\17\u014a\n\17\3\20\3\20\3\20\3\20\3\20\5\20\u0151\n\20\3\21\7\21\u0154"+
		"\n\21\f\21\16\21\u0157\13\21\3\21\3\21\3\21\3\21\7\21\u015d\n\21\f\21"+
		"\16\21\u0160\13\21\7\21\u0162\n\21\f\21\16\21\u0165\13\21\3\22\5\22\u0168"+
		"\n\22\3\22\3\22\3\23\3\23\5\23\u016e\n\23\3\24\3\24\3\24\3\24\3\24\3\24"+
		"\3\24\7\24\u0177\n\24\f\24\16\24\u017a\13\24\5\24\u017c\n\24\3\24\5\24"+
		"\u017f\n\24\3\25\3\25\3\25\3\26\5\26\u0185\n\26\3\26\3\26\3\26\3\26\3"+
		"\26\5\26\u018c\n\26\5\26\u018e\n\26\3\26\5\26\u0191\n\26\3\27\3\27\3\27"+
		"\7\27\u0196\n\27\f\27\16\27\u0199\13\27\3\30\3\30\3\31\6\31\u019e\n\31"+
		"\r\31\16\31\u019f\3\32\3\32\3\33\3\33\3\34\3\34\3\35\3\35\3\36\3\36\3"+
		"\37\3\37\3 \3 \3!\3!\3!\3\"\3\"\3\"\5\"\u01b6\n\"\3\"\3\"\3\"\3\"\3\""+
		"\3\"\3\"\3\"\3\"\3\"\3\"\3\"\3\"\3\"\3\"\3\"\3\"\3\"\3\"\3\"\3\"\3\"\3"+
		"\"\3\"\3\"\3\"\3\"\3\"\3\"\3\"\3\"\3\"\3\"\3\"\3\"\3\"\3\"\3\"\3\"\3\""+
		"\5\"\u01e0\n\"\3#\3#\3$\3$\3%\3%\3%\3%\3%\3&\3&\3&\3&\3&\3&\3&\3&\3&\7"+
		"&\u01f4\n&\f&\16&\u01f7\13&\3\'\3\'\3(\3(\3)\3)\3*\3*\3+\3+\3,\3,\3-\3"+
		"-\3.\3.\3/\3/\3\60\3\60\3\61\3\61\3\62\3\62\3\62\5\62\u0212\n\62\3\63"+
		"\3\63\3\63\3\63\5\63\u0218\n\63\3\64\3\64\3\64\3\64\3\64\3\64\5\64\u0220"+
		"\n\64\3\65\3\65\3\65\5\65\u0225\n\65\3\66\3\66\3\66\5\66\u022a\n\66\3"+
		"\67\3\67\3\67\5\67\u022f\n\67\38\38\38\58\u0234\n8\39\39\39\59\u0239\n"+
		"9\3:\3:\3:\3:\5:\u023f\n:\3;\3;\3;\3;\5;\u0245\n;\3<\3<\3<\5<\u024a\n"+
		"<\3=\3=\3=\5=\u024f\n=\3>\3>\3>\5>\u0254\n>\3?\3?\3?\7?\u0259\n?\f?\16"+
		"?\u025c\13?\3?\3?\3?\3?\5?\u0262\n?\3@\3@\3@\3@\3@\3@\6@\u026a\n@\r@\16"+
		"@\u026b\3@\3@\5@\u0270\n@\3A\3A\3A\3A\5A\u0276\nA\3B\3B\7B\u027a\nB\f"+
		"B\16B\u027d\13B\3C\3C\3C\3C\5C\u0283\nC\3D\3D\3D\3D\3E\3E\3E\3E\7E\u028d"+
		"\nE\fE\16E\u0290\13E\5E\u0292\nE\3E\3E\3F\3F\3G\3G\3G\3G\3G\3G\3G\3G\5"+
		"G\u02a0\nG\3G\3G\5G\u02a4\nG\3H\3H\3H\3H\3H\3H\5H\u02ac\nH\3H\2I\2\4\6"+
		"\b\n\f\16\20\22\24\26\30\32\34\36 \"$&(*,.\60\62\64\668:<>@BDFHJLNPRT"+
		"VXZ\\^`bdfhjlnprtvxz|~\u0080\u0082\u0084\u0086\u0088\u008a\u008c\u008e"+
		"\2\34\3IJ\3ST\3]_\b\3\3\5\5\30\30  \61\61;;\6\6\6\t\t\66\66<<\3]b\6\21"+
		"\22))++MM\6\16\16\26\26\31\31**\4\3\3\5\5\5\36\36$$\62\62\4\25\25//\b"+
		"\r\r\23\24\33\34##&(\678\4\b\b::\4\17\17\"\"\7\4\4\17\17\32\32\"\"XY\5"+
		"\17\17\"\"\63\63\6\6\6\17\17\"\"\66\66\3XY\4\4\4\32\32\5\4\4\32\32\63"+
		"\63\4\37\37\63\63\t\4\4\17\17\32\32\37\37\"\"\63\63XY\7\4\4\17\17\32\32"+
		"\"\"XY\4\n\n--\4  \61\61\5\5\5\13\1399\u02e5\2\u0096\3\2\2\2\4\u0099\3"+
		"\2\2\2\6\u009d\3\2\2\2\b\u00ab\3\2\2\2\n\u00ad\3\2\2\2\f\u00b8\3\2\2\2"+
		"\16\u00ca\3\2\2\2\20\u00e9\3\2\2\2\22\u0105\3\2\2\2\24\u010f\3\2\2\2\26"+
		"\u0111\3\2\2\2\30\u011b\3\2\2\2\32\u0142\3\2\2\2\34\u0149\3\2\2\2\36\u0150"+
		"\3\2\2\2 \u0155\3\2\2\2\"\u0167\3\2\2\2$\u016d\3\2\2\2&\u017e\3\2\2\2"+
		"(\u0180\3\2\2\2*\u0184\3\2\2\2,\u0192\3\2\2\2.\u019a\3\2\2\2\60\u019d"+
		"\3\2\2\2\62\u01a1\3\2\2\2\64\u01a3\3\2\2\2\66\u01a5\3\2\2\28\u01a7\3\2"+
		"\2\2:\u01a9\3\2\2\2<\u01ab\3\2\2\2>\u01ad\3\2\2\2@\u01af\3\2\2\2B\u01df"+
		"\3\2\2\2D\u01e1\3\2\2\2F\u01e3\3\2\2\2H\u01e5\3\2\2\2J\u01f5\3\2\2\2L"+
		"\u01f8\3\2\2\2N\u01fa\3\2\2\2P\u01fc\3\2\2\2R\u01fe\3\2\2\2T\u0200\3\2"+
		"\2\2V\u0202\3\2\2\2X\u0204\3\2\2\2Z\u0206\3\2\2\2\\\u0208\3\2\2\2^\u020a"+
		"\3\2\2\2`\u020c\3\2\2\2b\u020e\3\2\2\2d\u0213\3\2\2\2f\u0219\3\2\2\2h"+
		"\u0221\3\2\2\2j\u0226\3\2\2\2l\u022b\3\2\2\2n\u0230\3\2\2\2p\u0235\3\2"+
		"\2\2r\u023a\3\2\2\2t\u0240\3\2\2\2v\u0246\3\2\2\2x\u024b\3\2\2\2z\u0250"+
		"\3\2\2\2|\u0261\3\2\2\2~\u026f\3\2\2\2\u0080\u0275\3\2\2\2\u0082\u0277"+
		"\3\2\2\2\u0084\u0282\3\2\2\2\u0086\u0284\3\2\2\2\u0088\u0288\3\2\2\2\u008a"+
		"\u0295\3\2\2\2\u008c\u02a3\3\2\2\2\u008e\u02ab\3\2\2\2\u0090\u0095\5\6"+
		"\4\2\u0091\u0095\5\4\3\2\u0092\u0095\5\u0082B\2\u0093\u0095\5`\61\2\u0094"+
		"\u0090\3\2\2\2\u0094\u0091\3\2\2\2\u0094\u0092\3\2\2\2\u0094\u0093\3\2"+
		"\2\2\u0095\u0098\3\2\2\2\u0096\u0094\3\2\2\2\u0096\u0097\3\2\2\2\u0097"+
		"\3\3\2\2\2\u0098\u0096\3\2\2\2\u0099\u009a\5\u0082B\2\u009a\u009b\5\u0084"+
		"C\2\u009b\5\3\2\2\2\u009c\u009e\7G\2\2\u009d\u009c\3\2\2\2\u009d\u009e"+
		"\3\2\2\2\u009e\u00a0\3\2\2\2\u009f\u00a1\5H%\2\u00a0\u009f\3\2\2\2\u00a0"+
		"\u00a1\3\2\2\2\u00a1\u00a2\3\2\2\2\u00a2\u00a3\5\b\5\2\u00a3\7\3\2\2\2"+
		"\u00a4\u00a5\5\32\16\2\u00a5\u00a6\5\n\6\2\u00a6\u00ac\3\2\2\2\u00a7\u00a9"+
		"\5\22\n\2\u00a8\u00aa\5\n\6\2\u00a9\u00a8\3\2\2\2\u00a9\u00aa\3\2\2\2"+
		"\u00aa\u00ac\3\2\2\2\u00ab\u00a4\3\2\2\2\u00ab\u00a7\3\2\2\2\u00ac\t\3"+
		"\2\2\2\u00ad\u00b2\5\f\7\2\u00ae\u00af\7\37\2\2\u00af\u00b1\5\f\7\2\u00b0"+
		"\u00ae\3\2\2\2\u00b1\u00b4\3\2\2\2\u00b2\u00b0\3\2\2\2\u00b2\u00b3\3\2"+
		"\2\2\u00b3\u00b5\3\2\2\2\u00b4\u00b2\3\2\2\2\u00b5\u00b6\7\63\2\2\u00b6"+
		"\13\3\2\2\2\u00b7\u00b9\5\60\31\2\u00b8\u00b7\3\2\2\2\u00b8\u00b9\3\2"+
		"\2\2\u00b9\u00ba\3\2\2\2\u00ba\u00bc\5,\27\2\u00bb\u00bd\5\34\17\2\u00bc"+
		"\u00bb\3\2\2\2\u00bc\u00bd\3\2\2\2\u00bd\u00c5\3\2\2\2\u00be\u00c0\7\""+
		"\2\2\u00bf\u00c1\5b\62\2\u00c0\u00bf\3\2\2\2\u00c0\u00c1\3\2\2\2\u00c1"+
		"\u00c2\3\2\2\2\u00c2\u00c6\7\17\2\2\u00c3\u00c4\7\23\2\2\u00c4\u00c6\5"+
		"\16\b\2\u00c5\u00be\3\2\2\2\u00c5\u00c3\3\2\2\2\u00c5\u00c6\3\2\2\2\u00c6"+
		"\r\3\2\2\2\u00c7\u00c9\5\\/\2\u00c8\u00c7\3\2\2\2\u00c9\u00cc\3\2\2\2"+
		"\u00ca\u00c8\3\2\2\2\u00ca\u00cb\3\2\2\2\u00cb\u00e3\3\2\2\2\u00cc\u00ca"+
		"\3\2\2\2\u00cd\u00ce\7X\2\2\u00ce\u00cf\5\20\t\2\u00cf\u00d0\7Y\2\2\u00d0"+
		"\u00da\3\2\2\2\u00d1\u00d2\7\"\2\2\u00d2\u00d3\5\20\t\2\u00d3\u00d4\7"+
		"\17\2\2\u00d4\u00da\3\2\2\2\u00d5\u00d6\7\4\2\2\u00d6\u00d7\5\20\t\2\u00d7"+
		"\u00d8\7\32\2\2\u00d8\u00da\3\2\2\2\u00d9\u00cd\3\2\2\2\u00d9\u00d1\3"+
		"\2\2\2\u00d9\u00d5\3\2\2\2\u00da\u00de\3\2\2\2\u00db\u00dd\5\\/\2\u00dc"+
		"\u00db\3\2\2\2\u00dd\u00e0\3\2\2\2\u00de\u00dc\3\2\2\2\u00de\u00df\3\2"+
		"\2\2\u00df\u00e2\3\2\2\2\u00e0\u00de\3\2\2\2\u00e1\u00d9\3\2\2\2\u00e2"+
		"\u00e5\3\2\2\2\u00e3\u00e1\3\2\2\2\u00e3\u00e4\3\2\2\2\u00e4\17\3\2\2"+
		"\2\u00e5\u00e3\3\2\2\2\u00e6\u00e8\5^\60\2\u00e7\u00e6\3\2\2\2\u00e8\u00eb"+
		"\3\2\2\2\u00e9\u00e7\3\2\2\2\u00e9\u00ea\3\2\2\2\u00ea\u0102\3\2\2\2\u00eb"+
		"\u00e9\3\2\2\2\u00ec\u00ed\7X\2\2\u00ed\u00ee\5\20\t\2\u00ee\u00ef\7Y"+
		"\2\2\u00ef\u00f9\3\2\2\2\u00f0\u00f1\7\"\2\2\u00f1\u00f2\5\20\t\2\u00f2"+
		"\u00f3\7\17\2\2\u00f3\u00f9\3\2\2\2\u00f4\u00f5\7\4\2\2\u00f5\u00f6\5"+
		"\20\t\2\u00f6\u00f7\7\32\2\2\u00f7\u00f9\3\2\2\2\u00f8\u00ec\3\2\2\2\u00f8"+
		"\u00f0\3\2\2\2\u00f8\u00f4\3\2\2\2\u00f9\u00fd\3\2\2\2\u00fa\u00fc\5^"+
		"\60\2\u00fb\u00fa\3\2\2\2\u00fc\u00ff\3\2\2\2\u00fd\u00fb\3\2\2\2\u00fd"+
		"\u00fe\3\2\2\2\u00fe\u0101\3\2\2\2\u00ff\u00fd\3\2\2\2\u0100\u00f8\3\2"+
		"\2\2\u0101\u0104\3\2\2\2\u0102\u0100\3\2\2\2\u0102\u0103\3\2\2\2\u0103"+
		"\21\3\2\2\2\u0104\u0102\3\2\2\2\u0105\u0107\5:\36\2\u0106\u0108\5\24\13"+
		"\2\u0107\u0106\3\2\2\2\u0107\u0108\3\2\2\2\u0108\u010a\3\2\2\2\u0109\u010b"+
		"\5\26\f\2\u010a\u0109\3\2\2\2\u010a\u010b\3\2\2\2\u010b\u010c\3\2\2\2"+
		"\u010c\u010d\7X\2\2\u010d\u010e\b\n\1\2\u010e\23\3\2\2\2\u010f\u0110\5"+
		",\27\2\u0110\25\3\2\2\2\u0111\u0112\7!\2\2\u0112\u0117\5\30\r\2\u0113"+
		"\u0114\7\37\2\2\u0114\u0116\5\30\r\2\u0115\u0113\3\2\2\2\u0116\u0119\3"+
		"\2\2\2\u0117\u0115\3\2\2\2\u0117\u0118\3\2\2\2\u0118\27\3\2\2\2\u0119"+
		"\u0117\3\2\2\2\u011a\u011c\7M\2\2\u011b\u011a\3\2\2\2\u011b\u011c\3\2"+
		"\2\2\u011c\u011e\3\2\2\2\u011d\u011f\5> \2\u011e\u011d\3\2\2\2\u011e\u011f"+
		"\3\2\2\2\u011f\u0120\3\2\2\2\u0120\u0121\5,\27\2\u0121\31\3\2\2\2\u0122"+
		"\u0124\7L\2\2\u0123\u0122\3\2\2\2\u0124\u0127\3\2\2\2\u0125\u0123\3\2"+
		"\2\2\u0125\u0126\3\2\2\2\u0126\u012b\3\2\2\2\u0127\u0125\3\2\2\2\u0128"+
		"\u012c\5:\36\2\u0129\u012c\7I\2\2\u012a\u012c\7J\2\2\u012b\u0128\3\2\2"+
		"\2\u012b\u0129\3\2\2\2\u012b\u012a\3\2\2\2\u012b\u012c\3\2\2\2\u012c\u012d"+
		"\3\2\2\2\u012d\u0132\5\36\20\2\u012e\u012f\7\6\2\2\u012f\u0130\5J&\2\u0130"+
		"\u0131\7\66\2\2\u0131\u0133\3\2\2\2\u0132\u012e\3\2\2\2\u0132\u0133\3"+
		"\2\2\2\u0133\u013e\3\2\2\2\u0134\u0135\7\20\2\2\u0135\u013a\5\36\20\2"+
		"\u0136\u0137\7\6\2\2\u0137\u0138\5J&\2\u0138\u0139\7\66\2\2\u0139\u013b"+
		"\3\2\2\2\u013a\u0136\3\2\2\2\u013a\u013b\3\2\2\2\u013b\u013d\3\2\2\2\u013c"+
		"\u0134\3\2\2\2\u013d\u0140\3\2\2\2\u013e\u013c\3\2\2\2\u013e\u013f\3\2"+
		"\2\2\u013f\u0143\3\2\2\2\u0140\u013e\3\2\2\2\u0141\u0143\t\2\2\2\u0142"+
		"\u0125\3\2\2\2\u0142\u0141\3\2\2\2\u0143\33\3\2\2\2\u0144\u0145\7\4\2"+
		"\2\u0145\u0146\5 \21\2\u0146\u0147\7\32\2\2\u0147\u014a\3\2\2\2\u0148"+
		"\u014a\5&\24\2\u0149\u0144\3\2\2\2\u0149\u0148\3\2\2\2\u014a\35\3\2\2"+
		"\2\u014b\u0151\7W\2\2\u014c\u0151\7H\2\2\u014d\u0151\7K\2\2\u014e\u014f"+
		"\7K\2\2\u014f\u0151\7K\2\2\u0150\u014b\3\2\2\2\u0150\u014c\3\2\2\2\u0150"+
		"\u014d\3\2\2\2\u0150\u014e\3\2\2\2\u0151\37\3\2\2\2\u0152\u0154\5V,\2"+
		"\u0153\u0152\3\2\2\2\u0154\u0157\3\2\2\2\u0155\u0153\3\2\2\2\u0155\u0156"+
		"\3\2\2\2\u0156\u0163\3\2\2\2\u0157\u0155\3\2\2\2\u0158\u0159\7\4\2\2\u0159"+
		"\u015a\5 \21\2\u015a\u015e\7\32\2\2\u015b\u015d\5V,\2\u015c\u015b\3\2"+
		"\2\2\u015d\u0160\3\2\2\2\u015e\u015c\3\2\2\2\u015e\u015f\3\2\2\2\u015f"+
		"\u0162\3\2\2\2\u0160\u015e\3\2\2\2\u0161\u0158\3\2\2\2\u0162\u0165\3\2"+
		"\2\2\u0163\u0161\3\2\2\2\u0163\u0164\3\2\2\2\u0164!\3\2\2\2\u0165\u0163"+
		"\3\2\2\2\u0166\u0168\t\3\2\2\u0167\u0166\3\2\2\2\u0167\u0168\3\2\2\2\u0168"+
		"\u0169\3\2\2\2\u0169\u016a\5\32\16\2\u016a#\3\2\2\2\u016b\u016e\5,\27"+
		"\2\u016c\u016e\5> \2\u016d\u016b\3\2\2\2\u016d\u016c\3\2\2\2\u016e%\3"+
		"\2\2\2\u016f\u0170\7\"\2\2\u0170\u0171\7H\2\2\u0171\u017f\7\17\2\2\u0172"+
		"\u017b\7\"\2\2\u0173\u0178\5(\25\2\u0174\u0175\7\37\2\2\u0175\u0177\5"+
		"(\25\2\u0176\u0174\3\2\2\2\u0177\u017a\3\2\2\2\u0178\u0176\3\2\2\2\u0178"+
		"\u0179\3\2\2\2\u0179\u017c\3\2\2\2\u017a\u0178\3\2\2\2\u017b\u0173\3\2"+
		"\2\2\u017b\u017c\3\2\2\2\u017c\u017d\3\2\2\2\u017d\u017f\7\17\2\2\u017e"+
		"\u016f\3\2\2\2\u017e\u0172\3\2\2\2\u017f\'\3\2\2\2\u0180\u0181\5\"\22"+
		"\2\u0181\u0182\5*\26\2\u0182)\3\2\2\2\u0183\u0185\5\60\31\2\u0184\u0183"+
		"\3\2\2\2\u0184\u0185\3\2\2\2\u0185\u018d\3\2\2\2\u0186\u0187\7\"\2\2\u0187"+
		"\u0188\5*\26\2\u0188\u0189\7\17\2\2\u0189\u018e\3\2\2\2\u018a\u018c\5"+
		"$\23\2\u018b\u018a\3\2\2\2\u018b\u018c\3\2\2\2\u018c\u018e\3\2\2\2\u018d"+
		"\u0186\3\2\2\2\u018d\u018b\3\2\2\2\u018e\u0190\3\2\2\2\u018f\u0191\5\34"+
		"\17\2\u0190\u018f\3\2\2\2\u0190\u0191\3\2\2\2\u0191+\3\2\2\2\u0192\u0197"+
		"\7W\2\2\u0193\u0194\7\20\2\2\u0194\u0196\7W\2\2\u0195\u0193\3\2\2\2\u0196"+
		"\u0199\3\2\2\2\u0197\u0195\3\2\2\2\u0197\u0198\3\2\2\2\u0198-\3\2\2\2"+
		"\u0199\u0197\3\2\2\2\u019a\u019b\t\4\2\2\u019b/\3\2\2\2\u019c\u019e\5"+
		"<\37\2\u019d\u019c\3\2\2\2\u019e\u019f\3\2\2\2\u019f\u019d\3\2\2\2\u019f"+
		"\u01a0\3\2\2\2\u01a0\61\3\2\2\2\u01a1\u01a2\t\5\2\2\u01a2\63\3\2\2\2\u01a3"+
		"\u01a4\t\6\2\2\u01a4\65\3\2\2\2\u01a5\u01a6\t\7\2\2\u01a6\67\3\2\2\2\u01a7"+
		"\u01a8\t\b\2\2\u01a89\3\2\2\2\u01a9\u01aa\t\t\2\2\u01aa;\3\2\2\2\u01ab"+
		"\u01ac\t\n\2\2\u01ac=\3\2\2\2\u01ad\u01ae\t\13\2\2\u01ae?\3\2\2\2\u01af"+
		"\u01b0\7U\2\2\u01b0\u01b1\5B\"\2\u01b1A\3\2\2\2\u01b2\u01b5\t\f\2\2\u01b3"+
		"\u01b4\7\4\2\2\u01b4\u01b6\7\32\2\2\u01b5\u01b3\3\2\2\2\u01b5\u01b6\3"+
		"\2\2\2\u01b6\u01e0\3\2\2\2\u01b7\u01e0\7\61\2\2\u01b8\u01e0\7 \2\2\u01b9"+
		"\u01e0\7\5\2\2\u01ba\u01e0\79\2\2\u01bb\u01e0\7\13\2\2\u01bc\u01e0\7."+
		"\2\2\u01bd\u01e0\7\3\2\2\u01be\u01e0\7\27\2\2\u01bf\u01e0\7;\2\2\u01c0"+
		"\u01e0\7\30\2\2\u01c1\u01e0\7\23\2\2\u01c2\u01e0\7\6\2\2\u01c3\u01e0\7"+
		"\66\2\2\u01c4\u01e0\7\'\2\2\u01c5\u01e0\7\34\2\2\u01c6\u01e0\7\r\2\2\u01c7"+
		"\u01e0\78\2\2\u01c8\u01e0\7\67\2\2\u01c9\u01e0\7(\2\2\u01ca\u01e0\7#\2"+
		"\2\u01cb\u01e0\7\24\2\2\u01cc\u01e0\7-\2\2\u01cd\u01e0\7\n\2\2\u01ce\u01e0"+
		"\7&\2\2\u01cf\u01e0\7\33\2\2\u01d0\u01e0\7:\2\2\u01d1\u01e0\7\b\2\2\u01d2"+
		"\u01e0\7\t\2\2\u01d3\u01e0\7<\2\2\u01d4\u01e0\7\64\2\2\u01d5\u01e0\7\65"+
		"\2\2\u01d6\u01e0\7,\2\2\u01d7\u01e0\7\7\2\2\u01d8\u01e0\7\37\2\2\u01d9"+
		"\u01e0\7\35\2\2\u01da\u01e0\7\f\2\2\u01db\u01dc\7\"\2\2\u01dc\u01e0\7"+
		"\17\2\2\u01dd\u01de\7\4\2\2\u01de\u01e0\7\32\2\2\u01df\u01b2\3\2\2\2\u01df"+
		"\u01b7\3\2\2\2\u01df\u01b8\3\2\2\2\u01df\u01b9\3\2\2\2\u01df\u01ba\3\2"+
		"\2\2\u01df\u01bb\3\2\2\2\u01df\u01bc\3\2\2\2\u01df\u01bd\3\2\2\2\u01df"+
		"\u01be\3\2\2\2\u01df\u01bf\3\2\2\2\u01df\u01c0\3\2\2\2\u01df\u01c1\3\2"+
		"\2\2\u01df\u01c2\3\2\2\2\u01df\u01c3\3\2\2\2\u01df\u01c4\3\2\2\2\u01df"+
		"\u01c5\3\2\2\2\u01df\u01c6\3\2\2\2\u01df\u01c7\3\2\2\2\u01df\u01c8\3\2"+
		"\2\2\u01df\u01c9\3\2\2\2\u01df\u01ca\3\2\2\2\u01df\u01cb\3\2\2\2\u01df"+
		"\u01cc\3\2\2\2\u01df\u01cd\3\2\2\2\u01df\u01ce\3\2\2\2\u01df\u01cf\3\2"+
		"\2\2\u01df\u01d0\3\2\2\2\u01df\u01d1\3\2\2\2\u01df\u01d2\3\2\2\2\u01df"+
		"\u01d3\3\2\2\2\u01df\u01d4\3\2\2\2\u01df\u01d5\3\2\2\2\u01df\u01d6\3\2"+
		"\2\2\u01df\u01d7\3\2\2\2\u01df\u01d8\3\2\2\2\u01df\u01d9\3\2\2\2\u01df"+
		"\u01da\3\2\2\2\u01df\u01db\3\2\2\2\u01df\u01dd\3\2\2\2\u01e0C\3\2\2\2"+
		"\u01e1\u01e2\t\r\2\2\u01e2E\3\2\2\2\u01e3\u01e4\t\16\2\2\u01e4G\3\2\2"+
		"\2\u01e5\u01e6\7V\2\2\u01e6\u01e7\7\6\2\2\u01e7\u01e8\5J&\2\u01e8\u01e9"+
		"\7\66\2\2\u01e9I\3\2\2\2\u01ea\u01eb\7\6\2\2\u01eb\u01ec\5J&\2\u01ec\u01ed"+
		"\7\66\2\2\u01ed\u01f4\3\2\2\2\u01ee\u01ef\7\"\2\2\u01ef\u01f0\5J&\2\u01f0"+
		"\u01f1\7\17\2\2\u01f1\u01f4\3\2\2\2\u01f2\u01f4\5R*\2\u01f3\u01ea\3\2"+
		"\2\2\u01f3\u01ee\3\2\2\2\u01f3\u01f2\3\2\2\2\u01f4\u01f7\3\2\2\2\u01f5"+
		"\u01f3\3\2\2\2\u01f5\u01f6\3\2\2\2\u01f6K\3\2\2\2\u01f7\u01f5\3\2\2\2"+
		"\u01f8\u01f9\n\17\2\2\u01f9M\3\2\2\2\u01fa\u01fb\n\20\2\2\u01fbO\3\2\2"+
		"\2\u01fc\u01fd\n\21\2\2\u01fdQ\3\2\2\2\u01fe\u01ff\n\22\2\2\u01ffS\3\2"+
		"\2\2\u0200\u0201\n\23\2\2\u0201U\3\2\2\2\u0202\u0203\n\24\2\2\u0203W\3"+
		"\2\2\2\u0204\u0205\n\25\2\2\u0205Y\3\2\2\2\u0206\u0207\n\26\2\2\u0207"+
		"[\3\2\2\2\u0208\u0209\n\27\2\2\u0209]\3\2\2\2\u020a\u020b\n\30\2\2\u020b"+
		"_\3\2\2\2\u020c\u020d\13\2\2\2\u020da\3\2\2\2\u020e\u0211\5d\63\2\u020f"+
		"\u0210\7\37\2\2\u0210\u0212\5d\63\2\u0211\u020f\3\2\2\2\u0211\u0212\3"+
		"\2\2\2\u0212c\3\2\2\2\u0213\u0217\5f\64\2\u0214\u0215\5D#\2\u0215\u0216"+
		"\5d\63\2\u0216\u0218\3\2\2\2\u0217\u0214\3\2\2\2\u0217\u0218\3\2\2\2\u0218"+
		"e\3\2\2\2\u0219\u021f\5h\65\2\u021a\u021b\7%\2\2\u021b\u021c\5b\62\2\u021c"+
		"\u021d\7!\2\2\u021d\u021e\5f\64\2\u021e\u0220\3\2\2\2\u021f\u021a\3\2"+
		"\2\2\u021f\u0220\3\2\2\2\u0220g\3\2\2\2\u0221\u0224\5j\66\2\u0222\u0223"+
		"\7\65\2\2\u0223\u0225\5h\65\2\u0224\u0222\3\2\2\2\u0224\u0225\3\2\2\2"+
		"\u0225i\3\2\2\2\u0226\u0229\5l\67\2\u0227\u0228\7\64\2\2\u0228\u022a\5"+
		"j\66\2\u0229\u0227\3\2\2\2\u0229\u022a\3\2\2\2\u022ak\3\2\2\2\u022b\u022e"+
		"\5n8\2\u022c\u022d\7\27\2\2\u022d\u022f\5l\67\2\u022e\u022c\3\2\2\2\u022e"+
		"\u022f\3\2\2\2\u022fm\3\2\2\2\u0230\u0233\5p9\2\u0231\u0232\7.\2\2\u0232"+
		"\u0234\5n8\2\u0233\u0231\3\2\2\2\u0233\u0234\3\2\2\2\u0234o\3\2\2\2\u0235"+
		"\u0238\5r:\2\u0236\u0237\7\3\2\2\u0237\u0239\5p9\2\u0238\u0236\3\2\2\2"+
		"\u0238\u0239\3\2\2\2\u0239q\3\2\2\2\u023a\u023e\5t;\2\u023b\u023c\5F$"+
		"\2\u023c\u023d\5r:\2\u023d\u023f\3\2\2\2\u023e\u023b\3\2\2\2\u023e\u023f"+
		"\3\2\2\2\u023fs\3\2\2\2\u0240\u0244\5v<\2\u0241\u0242\5\64\33\2\u0242"+
		"\u0243\5t;\2\u0243\u0245\3\2\2\2\u0244\u0241\3\2\2\2\u0244\u0245\3\2\2"+
		"\2\u0245u\3\2\2\2\u0246\u0249\5x=\2\u0247\u0248\t\31\2\2\u0248\u024a\5"+
		"v<\2\u0249\u0247\3\2\2\2\u0249\u024a\3\2\2\2\u024aw\3\2\2\2\u024b\u024e"+
		"\5z>\2\u024c\u024d\t\32\2\2\u024d\u024f\5x=\2\u024e\u024c\3\2\2\2\u024e"+
		"\u024f\3\2\2\2\u024fy\3\2\2\2\u0250\u0253\5|?\2\u0251\u0252\t\33\2\2\u0252"+
		"\u0254\5|?\2\u0253\u0251\3\2\2\2\u0253\u0254\3\2\2\2\u0254{\3\2\2\2\u0255"+
		"\u0256\7\"\2\2\u0256\u025a\5\32\16\2\u0257\u0259\5<\37\2\u0258\u0257\3"+
		"\2\2\2\u0259\u025c\3\2\2\2\u025a\u0258\3\2\2\2\u025a\u025b\3\2\2\2\u025b"+
		"\u025d\3\2\2\2\u025c\u025a\3\2\2\2\u025d\u025e\7\17\2\2\u025e\u025f\5"+
		"|?\2\u025f\u0262\3\2\2\2\u0260\u0262\5~@\2\u0261\u0255\3\2\2\2\u0261\u0260"+
		"\3\2\2\2\u0262}\3\2\2\2\u0263\u0270\5\u0080A\2\u0264\u0265\7\7\2\2\u0265"+
		"\u0270\5~@\2\u0266\u0267\7,\2\2\u0267\u0270\5~@\2\u0268\u026a\5\62\32"+
		"\2\u0269\u0268\3\2\2\2\u026a\u026b\3\2\2\2\u026b\u0269\3\2\2\2\u026b\u026c"+
		"\3\2\2\2\u026c\u026d\3\2\2\2\u026d\u026e\5\u0080A\2\u026e\u0270\3\2\2"+
		"\2\u026f\u0263\3\2\2\2\u026f\u0264\3\2\2\2\u026f\u0266\3\2\2\2\u026f\u0269"+
		"\3\2\2\2\u0270\177\3\2\2\2\u0271\u0276\5\u0082B\2\u0272\u0273\5\u0082"+
		"B\2\u0273\u0274\5\u0084C\2\u0274\u0276\3\2\2\2\u0275\u0271\3\2\2\2\u0275"+
		"\u0272\3\2\2\2\u0276\u0081\3\2\2\2\u0277\u027b\5\u008eH\2\u0278\u027a"+
		"\5\u008cG\2\u0279\u0278\3\2\2\2\u027a\u027d\3\2\2\2\u027b\u0279\3\2\2"+
		"\2\u027b\u027c\3\2\2\2\u027c\u0083\3\2\2\2\u027d\u027b\3\2\2\2\u027e\u027f"+
		"\5\u0086D\2\u027f\u0280\5\u0088E\2\u0280\u0283\3\2\2\2\u0281\u0283\5\u0088"+
		"E\2\u0282\u027e\3\2\2\2\u0282\u0281\3\2\2\2\u0283\u0085\3\2\2\2\u0284"+
		"\u0285\7\6\2\2\u0285\u0286\5J&\2\u0286\u0287\7\66\2\2\u0287\u0087\3\2"+
		"\2\2\u0288\u0291\7\"\2\2\u0289\u028e\5\u008aF\2\u028a\u028b\7\37\2\2\u028b"+
		"\u028d\5\u008aF\2\u028c\u028a\3\2\2\2\u028d\u0290\3\2\2\2\u028e\u028c"+
		"\3\2\2\2\u028e\u028f\3\2\2\2\u028f\u0292\3\2\2\2\u0290\u028e\3\2\2\2\u0291"+
		"\u0289\3\2\2\2\u0291\u0292\3\2\2\2\u0292\u0293\3\2\2\2\u0293\u0294\7\17"+
		"\2\2\u0294\u0089\3\2\2\2\u0295\u0296\5d\63\2\u0296\u008b\3\2\2\2\u0297"+
		"\u0298\7\60\2\2\u0298\u02a0\5,\27\2\u0299\u029a\7\f\2\2\u029a\u02a0\5"+
		",\27\2\u029b\u029c\7\4\2\2\u029c\u029d\5b\62\2\u029d\u029e\7\32\2\2\u029e"+
		"\u02a0\3\2\2\2\u029f\u0297\3\2\2\2\u029f\u0299\3\2\2\2\u029f\u029b\3\2"+
		"\2\2\u02a0\u02a4\3\2\2\2\u02a1\u02a4\7,\2\2\u02a2\u02a4\7\7\2\2\u02a3"+
		"\u029f\3\2\2\2\u02a3\u02a1\3\2\2\2\u02a3\u02a2\3\2\2\2\u02a4\u008d\3\2"+
		"\2\2\u02a5\u02a6\7\"\2\2\u02a6\u02a7\5b\62\2\u02a7\u02a8\7\17\2\2\u02a8"+
		"\u02ac\3\2\2\2\u02a9\u02ac\5,\27\2\u02aa\u02ac\5\66\34\2\u02ab\u02a5\3"+
		"\2\2\2\u02ab\u02a9\3\2\2\2\u02ab\u02aa\3\2\2\2\u02ac\u008f\3\2\2\2M\u0094"+
		"\u0096\u009d\u00a0\u00a9\u00ab\u00b2\u00b8\u00bc\u00c0\u00c5\u00ca\u00d9"+
		"\u00de\u00e3\u00e9\u00f8\u00fd\u0102\u0107\u010a\u0117\u011b\u011e\u0125"+
		"\u012b\u0132\u013a\u013e\u0142\u0149\u0150\u0155\u015e\u0163\u0167\u016d"+
		"\u0178\u017b\u017e\u0184\u018b\u018d\u0190\u0197\u019f\u01b5\u01df\u01f3"+
		"\u01f5\u0211\u0217\u021f\u0224\u0229\u022e\u0233\u0238\u023e\u0244\u0249"+
		"\u024e\u0253\u025a\u0261\u026b\u026f\u0275\u027b\u0282\u028e\u0291\u029f"+
		"\u02a3\u02ab";
	public static final ATN _ATN =
		ATNSimulator.deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
	}
}