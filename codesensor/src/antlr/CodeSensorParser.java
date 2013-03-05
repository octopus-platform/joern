// Generated from ./CodeSensor.g4 by ANTLR 4.0

	package antlr;

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
		T__71=1, T__70=2, T__69=3, T__68=4, T__67=5, T__66=6, T__65=7, T__64=8, 
		T__63=9, T__62=10, T__61=11, T__60=12, T__59=13, T__58=14, T__57=15, T__56=16, 
		T__55=17, T__54=18, T__53=19, T__52=20, T__51=21, T__50=22, T__49=23, 
		T__48=24, T__47=25, T__46=26, T__45=27, T__44=28, T__43=29, T__42=30, 
		T__41=31, T__40=32, T__39=33, T__38=34, T__37=35, T__36=36, T__35=37, 
		T__34=38, T__33=39, T__32=40, T__31=41, T__30=42, T__29=43, T__28=44, 
		T__27=45, T__26=46, T__25=47, T__24=48, T__23=49, T__22=50, T__21=51, 
		T__20=52, T__19=53, T__18=54, T__17=55, T__16=56, T__15=57, T__14=58, 
		T__13=59, T__12=60, T__11=61, T__10=62, T__9=63, T__8=64, T__7=65, T__6=66, 
		T__5=67, T__4=68, T__3=69, T__2=70, T__1=71, T__0=72, IF=73, ELSE=74, 
		FOR=75, WHILE=76, SWITCH=77, CONTINUE=78, BREAK=79, GOTO=80, RETURN=81, 
		CASE=82, ALPHA_NUMERIC=83, CPPCOMMENT=84, COMMENT=85, STRING=86, PREPROC=87, 
		HEX_LITERAL=88, DECIMAL_LITERAL=89, OCTAL_LITERAL=90, FLOATING_POINT_LITERAL=91, 
		WHITESPACE=92, OTHER=93;
	public static final String[] tokenNames = {
		"<INVALID>", "'&'", "'register'", "'*'", "'['", "'<'", "'--'", "'!='", 
		"'<='", "'<<'", "'namespace'", "'}'", "'%'", "'->'", "'auto'", "'union'", 
		"'*='", "')'", "'virtual'", "'signed'", "'explicit'", "'inline'", "'unsigned'", 
		"'::'", "'throw'", "'template'", "'='", "'const'", "'|='", "'new'", "'class'", 
		"'|'", "'!'", "'enum'", "']'", "'using'", "'<<='", "'-='", "'->*'", "'public'", 
		"','", "'-'", "':'", "'('", "'&='", "'private'", "'void'", "'>>='", "'{'", 
		"'+='", "'^='", "'friend'", "'struct'", "'static'", "'++'", "'>>'", "'delete'", 
		"'^'", "'+'", "'protected'", "'operator'", "'typedef'", "'volatile'", 
		"';'", "'&&'", "'||'", "'>'", "'%='", "'/='", "'/'", "'=='", "'~'", "'>='", 
		"'if'", "'ELSE'", "'for'", "'while'", "'switch'", "'continue'", "'break'", 
		"'goto'", "'return'", "'case'", "ALPHA_NUMERIC", "CPPCOMMENT", "COMMENT", 
		"STRING", "PREPROC", "HEX_LITERAL", "DECIMAL_LITERAL", "OCTAL_LITERAL", 
		"FLOATING_POINT_LITERAL", "WHITESPACE", "OTHER"
	};
	public static final int
		RULE_code = 0, RULE_part = 1, RULE_declaration = 2, RULE_simple_decl = 3, 
		RULE_var_decl = 4, RULE_init_declarator_list = 5, RULE_init_declarator = 6, 
		RULE_class_def = 7, RULE_class_name = 8, RULE_base_classes = 9, RULE_base_class = 10, 
		RULE_class_content = 11, RULE_label = 12, RULE_function_def = 13, RULE_return_type = 14, 
		RULE_type_name = 15, RULE_template_decl_start = 16, RULE_assign_expr = 17, 
		RULE_template_param_list = 18, RULE_template_param_list_elem = 19, RULE_function_param_list = 20, 
		RULE_parameter_decl_clause = 21, RULE_parameter_decl = 22, RULE_parameter_id = 23, 
		RULE_ptrs = 24, RULE_param_decl_specifiers = 25, RULE_type_suffix = 26, 
		RULE_param_type_list = 27, RULE_param_type = 28, RULE_constant_expr = 29, 
		RULE_expr = 30, RULE_compound_statement = 31, RULE_parameter_name = 32, 
		RULE_parameter_name_start = 33, RULE_ctor_list = 34, RULE_ctor_initializer = 35, 
		RULE_initializer_id = 36, RULE_ctor_expr = 37, RULE_function_name = 38, 
		RULE_exception_specification = 39, RULE_type_id_list = 40, RULE_using_directive = 41, 
		RULE_unary_operator = 42, RULE_constant = 43, RULE_no_brackets = 44, RULE_no_brackets_curlies_or_squares = 45, 
		RULE_no_brackets_or_semicolon = 46, RULE_no_angle_brackets_or_brackets = 47, 
		RULE_no_curlies = 48, RULE_no_squares = 49, RULE_no_squares_or_semicolon = 50, 
		RULE_no_comma_or_semicolon = 51, RULE_cv_qualifier = 52, RULE_function_decl_specifiers = 53, 
		RULE_class_key = 54, RULE_ptr_operator = 55, RULE_access_specifier = 56, 
		RULE_operator_function_id = 57, RULE_operator = 58, RULE_assignment_operator = 59, 
		RULE_identifier = 60, RULE_number = 61, RULE_water = 62;
	public static final String[] ruleNames = {
		"code", "part", "declaration", "simple_decl", "var_decl", "init_declarator_list", 
		"init_declarator", "class_def", "class_name", "base_classes", "base_class", 
		"class_content", "label", "function_def", "return_type", "type_name", 
		"template_decl_start", "assign_expr", "template_param_list", "template_param_list_elem", 
		"function_param_list", "parameter_decl_clause", "parameter_decl", "parameter_id", 
		"ptrs", "param_decl_specifiers", "type_suffix", "param_type_list", "param_type", 
		"constant_expr", "expr", "compound_statement", "parameter_name", "parameter_name_start", 
		"ctor_list", "ctor_initializer", "initializer_id", "ctor_expr", "function_name", 
		"exception_specification", "type_id_list", "using_directive", "unary_operator", 
		"constant", "no_brackets", "no_brackets_curlies_or_squares", "no_brackets_or_semicolon", 
		"no_angle_brackets_or_brackets", "no_curlies", "no_squares", "no_squares_or_semicolon", 
		"no_comma_or_semicolon", "cv_qualifier", "function_decl_specifiers", "class_key", 
		"ptr_operator", "access_specifier", "operator_function_id", "operator", 
		"assignment_operator", "identifier", "number", "water"
	};

	@Override
	public String getGrammarFileName() { return "CodeSensor.g4"; }

	@Override
	public String[] getTokenNames() { return tokenNames; }

	@Override
	public String[] getRuleNames() { return ruleNames; }

	@Override
	public ATN getATN() { return _ATN; }

	public CodeSensorParser(TokenStream input) {
		super(input);
		_interp = new ParserATNSimulator(this,_ATN,_decisionToDFA,_sharedContextCache);
	}
	public static class CodeContext extends ParserRuleContext {
		public PartContext part(int i) {
			return getRuleContext(PartContext.class,i);
		}
		public List<PartContext> part() {
			return getRuleContexts(PartContext.class);
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
			setState(129);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << 1) | (1L << 2) | (1L << 3) | (1L << 4) | (1L << 5) | (1L << 6) | (1L << 7) | (1L << 8) | (1L << 9) | (1L << 10) | (1L << 11) | (1L << 12) | (1L << 13) | (1L << 14) | (1L << 15) | (1L << 16) | (1L << 17) | (1L << 18) | (1L << 19) | (1L << 20) | (1L << 21) | (1L << 22) | (1L << 23) | (1L << 24) | (1L << 25) | (1L << 26) | (1L << 27) | (1L << 28) | (1L << 29) | (1L << 30) | (1L << 31) | (1L << 32) | (1L << 33) | (1L << 34) | (1L << 35) | (1L << 36) | (1L << 37) | (1L << 38) | (1L << 39) | (1L << 40) | (1L << 41) | (1L << 42) | (1L << 43) | (1L << 44) | (1L << 45) | (1L << 46) | (1L << 47) | (1L << 48) | (1L << 49) | (1L << 50) | (1L << 51) | (1L << 52) | (1L << 53) | (1L << 54) | (1L << 55) | (1L << 56) | (1L << 57) | (1L << 58) | (1L << 59) | (1L << 60) | (1L << 61) | (1L << 62) | (1L << 63))) != 0) || ((((_la - 64)) & ~0x3f) == 0 && ((1L << (_la - 64)) & ((1L << (64 - 64)) | (1L << (65 - 64)) | (1L << (66 - 64)) | (1L << (67 - 64)) | (1L << (68 - 64)) | (1L << (69 - 64)) | (1L << (70 - 64)) | (1L << (71 - 64)) | (1L << (72 - 64)) | (1L << (IF - 64)) | (1L << (ELSE - 64)) | (1L << (FOR - 64)) | (1L << (WHILE - 64)) | (1L << (SWITCH - 64)) | (1L << (CONTINUE - 64)) | (1L << (BREAK - 64)) | (1L << (GOTO - 64)) | (1L << (RETURN - 64)) | (1L << (CASE - 64)) | (1L << (ALPHA_NUMERIC - 64)) | (1L << (CPPCOMMENT - 64)) | (1L << (COMMENT - 64)) | (1L << (STRING - 64)) | (1L << (PREPROC - 64)) | (1L << (HEX_LITERAL - 64)) | (1L << (DECIMAL_LITERAL - 64)) | (1L << (OCTAL_LITERAL - 64)) | (1L << (FLOATING_POINT_LITERAL - 64)) | (1L << (WHITESPACE - 64)) | (1L << (25 - 64)) | (1L << (27 - 64)) | (1L << (30 - 64)) | (1L << (33 - 64)) | (1L << (35 - 64)) | (1L << (43 - 64)) | (1L << (51 - 64)) | (1L << (52 - 64)) | (1L << (53 - 64)) | (1L << (60 - 64)) | (1L << (61 - 64)) | (1L << (62 - 64)) | (1L << (ALPHA_NUMERIC - 64)))) != 0)) {
				{
				{
				setState(126); part();
				}
				}
				setState(131);
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

	public static class PartContext extends ParserRuleContext {
		public WaterContext water() {
			return getRuleContext(WaterContext.class,0);
		}
		public DeclarationContext declaration() {
			return getRuleContext(DeclarationContext.class,0);
		}
		public PartContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_part; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof CodeSensorListener ) ((CodeSensorListener)listener).enterPart(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof CodeSensorListener ) ((CodeSensorListener)listener).exitPart(this);
		}
	}

	public final PartContext part() throws RecognitionException {
		PartContext _localctx = new PartContext(_ctx, getState());
		enterRule(_localctx, 2, RULE_part);
		try {
			setState(134);
			switch ( getInterpreter().adaptivePredict(_input,1,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(132); declaration();
				}
				break;

			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(133); water();
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

	public static class DeclarationContext extends ParserRuleContext {
		public Function_defContext function_def() {
			return getRuleContext(Function_defContext.class,0);
		}
		public Using_directiveContext using_directive() {
			return getRuleContext(Using_directiveContext.class,0);
		}
		public Simple_declContext simple_decl() {
			return getRuleContext(Simple_declContext.class,0);
		}
		public DeclarationContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_declaration; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof CodeSensorListener ) ((CodeSensorListener)listener).enterDeclaration(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof CodeSensorListener ) ((CodeSensorListener)listener).exitDeclaration(this);
		}
	}

	public final DeclarationContext declaration() throws RecognitionException {
		DeclarationContext _localctx = new DeclarationContext(_ctx, getState());
		enterRule(_localctx, 4, RULE_declaration);
		try {
			setState(139);
			switch ( getInterpreter().adaptivePredict(_input,2,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(136); simple_decl();
				}
				break;

			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(137); function_def();
				}
				break;

			case 3:
				enterOuterAlt(_localctx, 3);
				{
				setState(138); using_directive();
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

	public static class Simple_declContext extends ParserRuleContext {
		public Template_decl_startContext template_decl_start() {
			return getRuleContext(Template_decl_startContext.class,0);
		}
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
		enterRule(_localctx, 6, RULE_simple_decl);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(142);
			_la = _input.LA(1);
			if (_la==61) {
				{
				setState(141); match(61);
				}
			}

			setState(145);
			_la = _input.LA(1);
			if (_la==25) {
				{
				setState(144); template_decl_start();
				}
			}

			setState(147); var_decl();
			setState(148); match(63);
			}
		}
		catch (RecognitionException re) {
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
		enterRule(_localctx, 8, RULE_var_decl);
		int _la;
		try {
			setState(157);
			switch ( getInterpreter().adaptivePredict(_input,6,_ctx) ) {
			case 1:
				_localctx = new DeclByTypeContext(_localctx);
				enterOuterAlt(_localctx, 1);
				{
				setState(150); type_name();
				setState(151); init_declarator_list();
				}
				break;

			case 2:
				_localctx = new DeclByClassContext(_localctx);
				enterOuterAlt(_localctx, 2);
				{
				setState(153); class_def();
				setState(155);
				_la = _input.LA(1);
				if (_la==1 || _la==3 || _la==ALPHA_NUMERIC) {
					{
					setState(154); init_declarator_list();
					}
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
			if ( listener instanceof CodeSensorListener ) ((CodeSensorListener)listener).enterInit_declarator_list(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof CodeSensorListener ) ((CodeSensorListener)listener).exitInit_declarator_list(this);
		}
	}

	public final Init_declarator_listContext init_declarator_list() throws RecognitionException {
		Init_declarator_listContext _localctx = new Init_declarator_listContext(_ctx, getState());
		enterRule(_localctx, 10, RULE_init_declarator_list);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(159); init_declarator();
			setState(164);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==40) {
				{
				{
				setState(160); match(40);
				setState(161); init_declarator();
				}
				}
				setState(166);
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
		public Assign_exprContext assign_expr() {
			return getRuleContext(Assign_exprContext.class,0);
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
		enterRule(_localctx, 12, RULE_init_declarator);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			{
			setState(168);
			_la = _input.LA(1);
			if (_la==1 || _la==3) {
				{
				setState(167); ptrs();
				}
			}

			setState(170); identifier();
			setState(172);
			switch ( getInterpreter().adaptivePredict(_input,9,_ctx) ) {
			case 1:
				{
				setState(171); type_suffix();
				}
				break;
			}
			}
			setState(181);
			switch (_input.LA(1)) {
			case 43:
				{
				{
				setState(174); match(43);
				setState(176);
				switch ( getInterpreter().adaptivePredict(_input,10,_ctx) ) {
				case 1:
					{
					setState(175); expr();
					}
					break;
				}
				setState(178); match(17);
				}
				}
				break;
			case 26:
				{
				{
				setState(179); match(26);
				setState(180); assign_expr();
				}
				}
				break;
			case 40:
			case 63:
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

	public static class Class_defContext extends ParserRuleContext {
		public Class_contentContext class_content() {
			return getRuleContext(Class_contentContext.class,0);
		}
		public Base_classesContext base_classes() {
			return getRuleContext(Base_classesContext.class,0);
		}
		public Class_keyContext class_key() {
			return getRuleContext(Class_keyContext.class,0);
		}
		public Class_nameContext class_name() {
			return getRuleContext(Class_nameContext.class,0);
		}
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
		enterRule(_localctx, 14, RULE_class_def);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(183); class_key();
			setState(185);
			_la = _input.LA(1);
			if (_la==ALPHA_NUMERIC) {
				{
				setState(184); class_name();
				}
			}

			setState(188);
			_la = _input.LA(1);
			if (_la==42) {
				{
				setState(187); base_classes();
				}
			}

			setState(190); match(48);
			setState(191); class_content();
			setState(192); match(11);
			}
		}
		catch (RecognitionException re) {
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
		enterRule(_localctx, 16, RULE_class_name);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(194); identifier();
			}
		}
		catch (RecognitionException re) {
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
		enterRule(_localctx, 18, RULE_base_classes);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(196); match(42);
			setState(197); base_class();
			setState(202);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==40) {
				{
				{
				setState(198); match(40);
				setState(199); base_class();
				}
				}
				setState(204);
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
		enterRule(_localctx, 20, RULE_base_class);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(206);
			_la = _input.LA(1);
			if (_la==18) {
				{
				setState(205); match(18);
				}
			}

			setState(209);
			_la = _input.LA(1);
			if ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << 39) | (1L << 45) | (1L << 59))) != 0)) {
				{
				setState(208); access_specifier();
				}
			}

			setState(211); identifier();
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class Class_contentContext extends ParserRuleContext {
		public List<Class_contentContext> class_content() {
			return getRuleContexts(Class_contentContext.class);
		}
		public LabelContext label(int i) {
			return getRuleContext(LabelContext.class,i);
		}
		public List<Function_defContext> function_def() {
			return getRuleContexts(Function_defContext.class);
		}
		public Class_contentContext class_content(int i) {
			return getRuleContext(Class_contentContext.class,i);
		}
		public Simple_declContext simple_decl(int i) {
			return getRuleContext(Simple_declContext.class,i);
		}
		public List<No_curliesContext> no_curlies() {
			return getRuleContexts(No_curliesContext.class);
		}
		public No_curliesContext no_curlies(int i) {
			return getRuleContext(No_curliesContext.class,i);
		}
		public List<LabelContext> label() {
			return getRuleContexts(LabelContext.class);
		}
		public Function_defContext function_def(int i) {
			return getRuleContext(Function_defContext.class,i);
		}
		public List<Simple_declContext> simple_decl() {
			return getRuleContexts(Simple_declContext.class);
		}
		public Class_contentContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_class_content; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof CodeSensorListener ) ((CodeSensorListener)listener).enterClass_content(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof CodeSensorListener ) ((CodeSensorListener)listener).exitClass_content(this);
		}
	}

	public final Class_contentContext class_content() throws RecognitionException {
		Class_contentContext _localctx = new Class_contentContext(_ctx, getState());
		enterRule(_localctx, 22, RULE_class_content);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(223);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << 1) | (1L << 2) | (1L << 3) | (1L << 4) | (1L << 5) | (1L << 6) | (1L << 7) | (1L << 8) | (1L << 9) | (1L << 10) | (1L << 12) | (1L << 13) | (1L << 14) | (1L << 15) | (1L << 16) | (1L << 17) | (1L << 18) | (1L << 19) | (1L << 20) | (1L << 21) | (1L << 22) | (1L << 23) | (1L << 24) | (1L << 25) | (1L << 26) | (1L << 27) | (1L << 28) | (1L << 29) | (1L << 30) | (1L << 31) | (1L << 32) | (1L << 33) | (1L << 34) | (1L << 35) | (1L << 36) | (1L << 37) | (1L << 38) | (1L << 39) | (1L << 40) | (1L << 41) | (1L << 42) | (1L << 43) | (1L << 44) | (1L << 45) | (1L << 46) | (1L << 47) | (1L << 25) | (1L << 27) | (1L << 30) | (1L << 33) | (1L << 39) | (1L << 43) | (1L << 45) | (1L << 48) | (1L << 49) | (1L << 50) | (1L << 51) | (1L << 52) | (1L << 53) | (1L << 54) | (1L << 55) | (1L << 56) | (1L << 57) | (1L << 58) | (1L << 59) | (1L << 60) | (1L << 61) | (1L << 62) | (1L << 63))) != 0) || ((((_la - 64)) & ~0x3f) == 0 && ((1L << (_la - 64)) & ((1L << (64 - 64)) | (1L << (65 - 64)) | (1L << (66 - 64)) | (1L << (67 - 64)) | (1L << (68 - 64)) | (1L << (69 - 64)) | (1L << (70 - 64)) | (1L << (71 - 64)) | (1L << (72 - 64)) | (1L << (IF - 64)) | (1L << (ELSE - 64)) | (1L << (FOR - 64)) | (1L << (WHILE - 64)) | (1L << (SWITCH - 64)) | (1L << (CONTINUE - 64)) | (1L << (BREAK - 64)) | (1L << (GOTO - 64)) | (1L << (RETURN - 64)) | (1L << (CASE - 64)) | (1L << (ALPHA_NUMERIC - 64)) | (1L << (CPPCOMMENT - 64)) | (1L << (COMMENT - 64)) | (1L << (STRING - 64)) | (1L << (PREPROC - 64)) | (1L << (HEX_LITERAL - 64)) | (1L << (DECIMAL_LITERAL - 64)) | (1L << (OCTAL_LITERAL - 64)) | (1L << (FLOATING_POINT_LITERAL - 64)) | (1L << (WHITESPACE - 64)) | (1L << (OTHER - 64)) | (1L << (59 - 64)) | (1L << (60 - 64)) | (1L << (61 - 64)) | (1L << (62 - 64)) | (1L << (CASE - 64)) | (1L << (ALPHA_NUMERIC - 64)) | (1L << (HEX_LITERAL - 64)) | (1L << (DECIMAL_LITERAL - 64)) | (1L << (OCTAL_LITERAL - 64)))) != 0)) {
				{
				setState(221);
				switch ( getInterpreter().adaptivePredict(_input,17,_ctx) ) {
				case 1:
					{
					setState(213); simple_decl();
					}
					break;

				case 2:
					{
					setState(214); function_def();
					}
					break;

				case 3:
					{
					setState(215); label();
					}
					break;

				case 4:
					{
					setState(216); match(48);
					setState(217); class_content();
					setState(218); match(11);
					}
					break;

				case 5:
					{
					setState(220); no_curlies();
					}
					break;
				}
				}
				setState(225);
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

	public static class LabelContext extends ParserRuleContext {
		public NumberContext number() {
			return getRuleContext(NumberContext.class,0);
		}
		public Access_specifierContext access_specifier() {
			return getRuleContext(Access_specifierContext.class,0);
		}
		public IdentifierContext identifier() {
			return getRuleContext(IdentifierContext.class,0);
		}
		public LabelContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_label; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof CodeSensorListener ) ((CodeSensorListener)listener).enterLabel(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof CodeSensorListener ) ((CodeSensorListener)listener).exitLabel(this);
		}
	}

	public final LabelContext label() throws RecognitionException {
		LabelContext _localctx = new LabelContext(_ctx, getState());
		enterRule(_localctx, 24, RULE_label);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(234);
			switch (_input.LA(1)) {
			case CASE:
			case ALPHA_NUMERIC:
			case HEX_LITERAL:
			case DECIMAL_LITERAL:
			case OCTAL_LITERAL:
				{
				{
				setState(227);
				_la = _input.LA(1);
				if (_la==CASE) {
					{
					setState(226); match(CASE);
					}
				}

				setState(231);
				switch (_input.LA(1)) {
				case ALPHA_NUMERIC:
					{
					setState(229); identifier();
					}
					break;
				case HEX_LITERAL:
				case DECIMAL_LITERAL:
				case OCTAL_LITERAL:
					{
					setState(230); number();
					}
					break;
				default:
					throw new NoViableAltException(this);
				}
				}
				}
				break;
			case 39:
			case 45:
			case 59:
				{
				setState(233); access_specifier();
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
			setState(236); match(42);
			}
		}
		catch (RecognitionException re) {
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
		enterRule(_localctx, 26, RULE_function_def);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(239);
			_la = _input.LA(1);
			if (_la==25) {
				{
				setState(238); template_decl_start();
				}
			}

			setState(242);
			switch ( getInterpreter().adaptivePredict(_input,23,_ctx) ) {
			case 1:
				{
				setState(241); return_type();
				}
				break;
			}
			setState(244); function_name();
			setState(245); function_param_list();
			setState(247);
			_la = _input.LA(1);
			if (_la==42) {
				{
				setState(246); ctor_list();
				}
			}

			setState(249); compound_statement();
			}
		}
		catch (RecognitionException re) {
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
		public List<Ptr_operatorContext> ptr_operator() {
			return getRuleContexts(Ptr_operatorContext.class);
		}
		public Function_decl_specifiersContext function_decl_specifiers(int i) {
			return getRuleContext(Function_decl_specifiersContext.class,i);
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
		enterRule(_localctx, 28, RULE_return_type);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			{
			setState(254);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << 18) | (1L << 20) | (1L << 21) | (1L << 51) | (1L << 53))) != 0)) {
				{
				{
				setState(251); function_decl_specifiers();
				}
				}
				setState(256);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(257); type_name();
			}
			setState(262);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << 18) | (1L << 20) | (1L << 21) | (1L << 51) | (1L << 53))) != 0)) {
				{
				{
				setState(259); function_decl_specifiers();
				}
				}
				setState(264);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(268);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==1 || _la==3) {
				{
				{
				setState(265); ptr_operator();
				}
				}
				setState(270);
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

	public static class Type_nameContext extends ParserRuleContext {
		public Template_param_listContext template_param_list(int i) {
			return getRuleContext(Template_param_listContext.class,i);
		}
		public List<Cv_qualifierContext> cv_qualifier() {
			return getRuleContexts(Cv_qualifierContext.class);
		}
		public TerminalNode ALPHA_NUMERIC(int i) {
			return getToken(CodeSensorParser.ALPHA_NUMERIC, i);
		}
		public List<TerminalNode> ALPHA_NUMERIC() { return getTokens(CodeSensorParser.ALPHA_NUMERIC); }
		public List<Template_param_listContext> template_param_list() {
			return getRuleContexts(Template_param_listContext.class);
		}
		public Class_keyContext class_key() {
			return getRuleContext(Class_keyContext.class,0);
		}
		public Cv_qualifierContext cv_qualifier(int i) {
			return getRuleContext(Cv_qualifierContext.class,i);
		}
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
		enterRule(_localctx, 30, RULE_type_name);
		int _la;
		try {
			setState(304);
			switch ( getInterpreter().adaptivePredict(_input,34,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				{
				setState(274);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (_la==27 || _la==62) {
					{
					{
					setState(271); cv_qualifier();
					}
					}
					setState(276);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				setState(278);
				_la = _input.LA(1);
				if ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << 15) | (1L << 30) | (1L << 33) | (1L << 52))) != 0)) {
					{
					setState(277); class_key();
					}
				}

				setState(281);
				_la = _input.LA(1);
				if (_la==19 || _la==22) {
					{
					setState(280);
					_la = _input.LA(1);
					if ( !(_la==19 || _la==22) ) {
					_errHandler.recoverInline(this);
					}
					consume();
					}
				}

				setState(283); match(ALPHA_NUMERIC);
				setState(288);
				_la = _input.LA(1);
				if (_la==5) {
					{
					setState(284); match(5);
					setState(285); template_param_list();
					setState(286); match(66);
					}
				}

				setState(300);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (_la==23) {
					{
					{
					setState(290); match(23);
					setState(291); match(ALPHA_NUMERIC);
					setState(296);
					_la = _input.LA(1);
					if (_la==5) {
						{
						setState(292); match(5);
						setState(293); template_param_list();
						setState(294); match(66);
						}
					}

					}
					}
					setState(302);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				}
				}
				break;

			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(303);
				_la = _input.LA(1);
				if ( !(_la==19 || _la==22) ) {
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

	public static class Template_decl_startContext extends ParserRuleContext {
		public Template_param_listContext template_param_list() {
			return getRuleContext(Template_param_listContext.class,0);
		}
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
		enterRule(_localctx, 32, RULE_template_decl_start);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(306); match(25);
			setState(307); match(5);
			setState(308); template_param_list();
			setState(309); match(66);
			}
		}
		catch (RecognitionException re) {
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
		public List<No_comma_or_semicolonContext> no_comma_or_semicolon() {
			return getRuleContexts(No_comma_or_semicolonContext.class);
		}
		public No_comma_or_semicolonContext no_comma_or_semicolon(int i) {
			return getRuleContext(No_comma_or_semicolonContext.class,i);
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
		enterRule(_localctx, 34, RULE_assign_expr);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(312); 
			_errHandler.sync(this);
			_la = _input.LA(1);
			do {
				{
				{
				setState(311); no_comma_or_semicolon();
				}
				}
				setState(314); 
				_errHandler.sync(this);
				_la = _input.LA(1);
			} while ( (((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << 1) | (1L << 2) | (1L << 3) | (1L << 4) | (1L << 5) | (1L << 6) | (1L << 7) | (1L << 8) | (1L << 9) | (1L << 10) | (1L << 11) | (1L << 12) | (1L << 13) | (1L << 14) | (1L << 15) | (1L << 16) | (1L << 17) | (1L << 18) | (1L << 19) | (1L << 20) | (1L << 21) | (1L << 22) | (1L << 23) | (1L << 24) | (1L << 25) | (1L << 26) | (1L << 27) | (1L << 28) | (1L << 29) | (1L << 30) | (1L << 31) | (1L << 32) | (1L << 33) | (1L << 34) | (1L << 35) | (1L << 36) | (1L << 37) | (1L << 38) | (1L << 39) | (1L << 41) | (1L << 42) | (1L << 43) | (1L << 44) | (1L << 45) | (1L << 46) | (1L << 47) | (1L << 48) | (1L << 49) | (1L << 50) | (1L << 51) | (1L << 52) | (1L << 53) | (1L << 54) | (1L << 55) | (1L << 56) | (1L << 57) | (1L << 58) | (1L << 59) | (1L << 60) | (1L << 61) | (1L << 62))) != 0) || ((((_la - 64)) & ~0x3f) == 0 && ((1L << (_la - 64)) & ((1L << (64 - 64)) | (1L << (65 - 64)) | (1L << (66 - 64)) | (1L << (67 - 64)) | (1L << (68 - 64)) | (1L << (69 - 64)) | (1L << (70 - 64)) | (1L << (71 - 64)) | (1L << (72 - 64)) | (1L << (IF - 64)) | (1L << (ELSE - 64)) | (1L << (FOR - 64)) | (1L << (WHILE - 64)) | (1L << (SWITCH - 64)) | (1L << (CONTINUE - 64)) | (1L << (BREAK - 64)) | (1L << (GOTO - 64)) | (1L << (RETURN - 64)) | (1L << (CASE - 64)) | (1L << (ALPHA_NUMERIC - 64)) | (1L << (CPPCOMMENT - 64)) | (1L << (COMMENT - 64)) | (1L << (STRING - 64)) | (1L << (PREPROC - 64)) | (1L << (HEX_LITERAL - 64)) | (1L << (DECIMAL_LITERAL - 64)) | (1L << (OCTAL_LITERAL - 64)) | (1L << (FLOATING_POINT_LITERAL - 64)) | (1L << (WHITESPACE - 64)) | (1L << (OTHER - 64)))) != 0) );
			}
		}
		catch (RecognitionException re) {
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
		public Template_param_list_elemContext template_param_list_elem(int i) {
			return getRuleContext(Template_param_list_elemContext.class,i);
		}
		public List<Template_param_list_elemContext> template_param_list_elem() {
			return getRuleContexts(Template_param_list_elemContext.class);
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
		enterRule(_localctx, 36, RULE_template_param_list);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(319);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << 1) | (1L << 2) | (1L << 3) | (1L << 4) | (1L << 5) | (1L << 6) | (1L << 7) | (1L << 8) | (1L << 9) | (1L << 10) | (1L << 11) | (1L << 12) | (1L << 13) | (1L << 14) | (1L << 15) | (1L << 16) | (1L << 18) | (1L << 19) | (1L << 20) | (1L << 21) | (1L << 22) | (1L << 23) | (1L << 24) | (1L << 25) | (1L << 26) | (1L << 27) | (1L << 28) | (1L << 29) | (1L << 30) | (1L << 31) | (1L << 32) | (1L << 33) | (1L << 34) | (1L << 35) | (1L << 36) | (1L << 37) | (1L << 38) | (1L << 39) | (1L << 40) | (1L << 41) | (1L << 42) | (1L << 43) | (1L << 44) | (1L << 45) | (1L << 46) | (1L << 47) | (1L << 48) | (1L << 49) | (1L << 50) | (1L << 51) | (1L << 52) | (1L << 53) | (1L << 54) | (1L << 55) | (1L << 56) | (1L << 57) | (1L << 58) | (1L << 59) | (1L << 60) | (1L << 61) | (1L << 62) | (1L << 63))) != 0) || ((((_la - 64)) & ~0x3f) == 0 && ((1L << (_la - 64)) & ((1L << (64 - 64)) | (1L << (65 - 64)) | (1L << (67 - 64)) | (1L << (68 - 64)) | (1L << (69 - 64)) | (1L << (70 - 64)) | (1L << (71 - 64)) | (1L << (72 - 64)) | (1L << (IF - 64)) | (1L << (ELSE - 64)) | (1L << (FOR - 64)) | (1L << (WHILE - 64)) | (1L << (SWITCH - 64)) | (1L << (CONTINUE - 64)) | (1L << (BREAK - 64)) | (1L << (GOTO - 64)) | (1L << (RETURN - 64)) | (1L << (CASE - 64)) | (1L << (ALPHA_NUMERIC - 64)) | (1L << (CPPCOMMENT - 64)) | (1L << (COMMENT - 64)) | (1L << (STRING - 64)) | (1L << (PREPROC - 64)) | (1L << (HEX_LITERAL - 64)) | (1L << (DECIMAL_LITERAL - 64)) | (1L << (OCTAL_LITERAL - 64)) | (1L << (FLOATING_POINT_LITERAL - 64)) | (1L << (WHITESPACE - 64)) | (1L << (OTHER - 64)))) != 0)) {
				{
				{
				setState(316); template_param_list_elem();
				}
				}
				setState(321);
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

	public static class Template_param_list_elemContext extends ParserRuleContext {
		public No_angle_brackets_or_bracketsContext no_angle_brackets_or_brackets() {
			return getRuleContext(No_angle_brackets_or_bracketsContext.class,0);
		}
		public Template_param_listContext template_param_list() {
			return getRuleContext(Template_param_listContext.class,0);
		}
		public Template_param_list_elemContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_template_param_list_elem; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof CodeSensorListener ) ((CodeSensorListener)listener).enterTemplate_param_list_elem(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof CodeSensorListener ) ((CodeSensorListener)listener).exitTemplate_param_list_elem(this);
		}
	}

	public final Template_param_list_elemContext template_param_list_elem() throws RecognitionException {
		Template_param_list_elemContext _localctx = new Template_param_list_elemContext(_ctx, getState());
		enterRule(_localctx, 38, RULE_template_param_list_elem);
		try {
			setState(331);
			switch (_input.LA(1)) {
			case 5:
				enterOuterAlt(_localctx, 1);
				{
				{
				setState(322); match(5);
				setState(323); template_param_list();
				setState(324); match(66);
				}
				}
				break;
			case 43:
				enterOuterAlt(_localctx, 2);
				{
				{
				setState(326); match(43);
				setState(327); template_param_list();
				setState(328); match(17);
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
			case 12:
			case 13:
			case 14:
			case 15:
			case 16:
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
			case 54:
			case 55:
			case 56:
			case 57:
			case 58:
			case 59:
			case 60:
			case 61:
			case 62:
			case 63:
			case 64:
			case 65:
			case 67:
			case 68:
			case 69:
			case 70:
			case 71:
			case 72:
			case IF:
			case ELSE:
			case FOR:
			case WHILE:
			case SWITCH:
			case CONTINUE:
			case BREAK:
			case GOTO:
			case RETURN:
			case CASE:
			case ALPHA_NUMERIC:
			case CPPCOMMENT:
			case COMMENT:
			case STRING:
			case PREPROC:
			case HEX_LITERAL:
			case DECIMAL_LITERAL:
			case OCTAL_LITERAL:
			case FLOATING_POINT_LITERAL:
			case WHITESPACE:
			case OTHER:
				enterOuterAlt(_localctx, 3);
				{
				setState(330); no_angle_brackets_or_brackets();
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

	public static class Function_param_listContext extends ParserRuleContext {
		public List<Cv_qualifierContext> cv_qualifier() {
			return getRuleContexts(Cv_qualifierContext.class);
		}
		public Exception_specificationContext exception_specification() {
			return getRuleContext(Exception_specificationContext.class,0);
		}
		public Parameter_decl_clauseContext parameter_decl_clause() {
			return getRuleContext(Parameter_decl_clauseContext.class,0);
		}
		public Cv_qualifierContext cv_qualifier(int i) {
			return getRuleContext(Cv_qualifierContext.class,i);
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
		enterRule(_localctx, 40, RULE_function_param_list);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(333); match(43);
			setState(335);
			_la = _input.LA(1);
			if ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << 2) | (1L << 14) | (1L << 15) | (1L << 19) | (1L << 22) | (1L << 27) | (1L << 30) | (1L << 33) | (1L << 46) | (1L << 52) | (1L << 62))) != 0) || _la==ALPHA_NUMERIC) {
				{
				setState(334); parameter_decl_clause();
				}
			}

			setState(337); match(17);
			setState(341);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==27 || _la==62) {
				{
				{
				setState(338); cv_qualifier();
				}
				}
				setState(343);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(345);
			_la = _input.LA(1);
			if (_la==24) {
				{
				setState(344); exception_specification();
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
		enterRule(_localctx, 42, RULE_parameter_decl_clause);
		int _la;
		try {
			setState(356);
			switch (_input.LA(1)) {
			case 46:
				enterOuterAlt(_localctx, 1);
				{
				setState(347); match(46);
				}
				break;
			case 2:
			case 14:
			case 15:
			case 19:
			case 22:
			case 27:
			case 30:
			case 33:
			case 52:
			case 62:
			case ALPHA_NUMERIC:
				enterOuterAlt(_localctx, 2);
				{
				{
				setState(348); parameter_decl();
				setState(353);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (_la==40) {
					{
					{
					setState(349); match(40);
					setState(350); parameter_decl();
					}
					}
					setState(355);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
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
		enterRule(_localctx, 44, RULE_parameter_decl);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(358); param_decl_specifiers();
			setState(359); parameter_id();
			}
		}
		catch (RecognitionException re) {
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
		enterRule(_localctx, 46, RULE_parameter_id);
		int _la;
		try {
			setState(377);
			switch ( getInterpreter().adaptivePredict(_input,47,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(362);
				_la = _input.LA(1);
				if (_la==1 || _la==3) {
					{
					setState(361); ptrs();
					}
				}

				setState(364); match(43);
				setState(365); parameter_id();
				setState(366); match(17);
				setState(368);
				_la = _input.LA(1);
				if (_la==4 || _la==43) {
					{
					setState(367); type_suffix();
					}
				}

				}
				break;

			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(371);
				_la = _input.LA(1);
				if (_la==1 || _la==3) {
					{
					setState(370); ptrs();
					}
				}

				setState(373); parameter_name();
				setState(375);
				_la = _input.LA(1);
				if (_la==4 || _la==43) {
					{
					setState(374); type_suffix();
					}
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
		enterRule(_localctx, 48, RULE_ptrs);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(380); 
			_errHandler.sync(this);
			_la = _input.LA(1);
			do {
				{
				{
				setState(379); ptr_operator();
				}
				}
				setState(382); 
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

	public static class Param_decl_specifiersContext extends ParserRuleContext {
		public Type_nameContext type_name() {
			return getRuleContext(Type_nameContext.class,0);
		}
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
		enterRule(_localctx, 50, RULE_param_decl_specifiers);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(385);
			_la = _input.LA(1);
			if (_la==2 || _la==14) {
				{
				setState(384);
				_la = _input.LA(1);
				if ( !(_la==2 || _la==14) ) {
				_errHandler.recoverInline(this);
				}
				consume();
				}
			}

			setState(387); type_name();
			}
		}
		catch (RecognitionException re) {
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
		public Constant_exprContext constant_expr() {
			return getRuleContext(Constant_exprContext.class,0);
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
		enterRule(_localctx, 52, RULE_type_suffix);
		try {
			setState(394);
			switch (_input.LA(1)) {
			case 4:
				enterOuterAlt(_localctx, 1);
				{
				{
				setState(389); match(4);
				setState(390); constant_expr();
				setState(391); match(34);
				}
				}
				break;
			case 43:
				enterOuterAlt(_localctx, 2);
				{
				setState(393); param_type_list();
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
		enterRule(_localctx, 54, RULE_param_type_list);
		int _la;
		try {
			setState(411);
			switch ( getInterpreter().adaptivePredict(_input,53,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(396); match(43);
				setState(397); match(46);
				setState(398); match(17);
				}
				break;

			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(399); match(43);
				setState(408);
				_la = _input.LA(1);
				if ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << 2) | (1L << 14) | (1L << 15) | (1L << 19) | (1L << 22) | (1L << 27) | (1L << 30) | (1L << 33) | (1L << 52) | (1L << 62))) != 0) || _la==ALPHA_NUMERIC) {
					{
					setState(400); param_type();
					setState(405);
					_errHandler.sync(this);
					_la = _input.LA(1);
					while (_la==40) {
						{
						{
						setState(401); match(40);
						setState(402); param_type();
						}
						}
						setState(407);
						_errHandler.sync(this);
						_la = _input.LA(1);
					}
					}
				}

				setState(410); match(17);
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
		public Param_decl_specifiersContext param_decl_specifiers() {
			return getRuleContext(Param_decl_specifiersContext.class,0);
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
		enterRule(_localctx, 56, RULE_param_type);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(413); param_decl_specifiers();
			setState(415);
			_la = _input.LA(1);
			if (_la==1 || _la==3) {
				{
				setState(414); ptrs();
				}
			}

			setState(418);
			switch ( getInterpreter().adaptivePredict(_input,55,_ctx) ) {
			case 1:
				{
				setState(417); parameter_name();
				}
				break;
			}
			setState(421);
			_la = _input.LA(1);
			if (_la==4 || _la==43) {
				{
				setState(420); type_suffix();
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

	public static class Constant_exprContext extends ParserRuleContext {
		public List<No_squaresContext> no_squares() {
			return getRuleContexts(No_squaresContext.class);
		}
		public No_squaresContext no_squares(int i) {
			return getRuleContext(No_squaresContext.class,i);
		}
		public List<Constant_exprContext> constant_expr() {
			return getRuleContexts(Constant_exprContext.class);
		}
		public Constant_exprContext constant_expr(int i) {
			return getRuleContext(Constant_exprContext.class,i);
		}
		public Constant_exprContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_constant_expr; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof CodeSensorListener ) ((CodeSensorListener)listener).enterConstant_expr(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof CodeSensorListener ) ((CodeSensorListener)listener).exitConstant_expr(this);
		}
	}

	public final Constant_exprContext constant_expr() throws RecognitionException {
		Constant_exprContext _localctx = new Constant_exprContext(_ctx, getState());
		enterRule(_localctx, 58, RULE_constant_expr);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(426);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << 1) | (1L << 2) | (1L << 3) | (1L << 5) | (1L << 6) | (1L << 7) | (1L << 8) | (1L << 9) | (1L << 10) | (1L << 11) | (1L << 12) | (1L << 13) | (1L << 14) | (1L << 15) | (1L << 16) | (1L << 17) | (1L << 18) | (1L << 19) | (1L << 20) | (1L << 21) | (1L << 22) | (1L << 23) | (1L << 24) | (1L << 25) | (1L << 26) | (1L << 27) | (1L << 28) | (1L << 29) | (1L << 30) | (1L << 31) | (1L << 32) | (1L << 33) | (1L << 35) | (1L << 36) | (1L << 37) | (1L << 38) | (1L << 39) | (1L << 40) | (1L << 41) | (1L << 42) | (1L << 43) | (1L << 44) | (1L << 45) | (1L << 46) | (1L << 47) | (1L << 48) | (1L << 49) | (1L << 50) | (1L << 51) | (1L << 52) | (1L << 53) | (1L << 54) | (1L << 55) | (1L << 56) | (1L << 57) | (1L << 58) | (1L << 59) | (1L << 60) | (1L << 61) | (1L << 62) | (1L << 63))) != 0) || ((((_la - 64)) & ~0x3f) == 0 && ((1L << (_la - 64)) & ((1L << (64 - 64)) | (1L << (65 - 64)) | (1L << (66 - 64)) | (1L << (67 - 64)) | (1L << (68 - 64)) | (1L << (69 - 64)) | (1L << (70 - 64)) | (1L << (71 - 64)) | (1L << (72 - 64)) | (1L << (IF - 64)) | (1L << (ELSE - 64)) | (1L << (FOR - 64)) | (1L << (WHILE - 64)) | (1L << (SWITCH - 64)) | (1L << (CONTINUE - 64)) | (1L << (BREAK - 64)) | (1L << (GOTO - 64)) | (1L << (RETURN - 64)) | (1L << (CASE - 64)) | (1L << (ALPHA_NUMERIC - 64)) | (1L << (CPPCOMMENT - 64)) | (1L << (COMMENT - 64)) | (1L << (STRING - 64)) | (1L << (PREPROC - 64)) | (1L << (HEX_LITERAL - 64)) | (1L << (DECIMAL_LITERAL - 64)) | (1L << (OCTAL_LITERAL - 64)) | (1L << (FLOATING_POINT_LITERAL - 64)) | (1L << (WHITESPACE - 64)) | (1L << (OTHER - 64)))) != 0)) {
				{
				{
				setState(423); no_squares();
				}
				}
				setState(428);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(440);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==4) {
				{
				{
				setState(429); match(4);
				setState(430); constant_expr();
				setState(431); match(34);
				setState(435);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << 1) | (1L << 2) | (1L << 3) | (1L << 5) | (1L << 6) | (1L << 7) | (1L << 8) | (1L << 9) | (1L << 10) | (1L << 11) | (1L << 12) | (1L << 13) | (1L << 14) | (1L << 15) | (1L << 16) | (1L << 17) | (1L << 18) | (1L << 19) | (1L << 20) | (1L << 21) | (1L << 22) | (1L << 23) | (1L << 24) | (1L << 25) | (1L << 26) | (1L << 27) | (1L << 28) | (1L << 29) | (1L << 30) | (1L << 31) | (1L << 32) | (1L << 33) | (1L << 35) | (1L << 36) | (1L << 37) | (1L << 38) | (1L << 39) | (1L << 40) | (1L << 41) | (1L << 42) | (1L << 43) | (1L << 44) | (1L << 45) | (1L << 46) | (1L << 47) | (1L << 48) | (1L << 49) | (1L << 50) | (1L << 51) | (1L << 52) | (1L << 53) | (1L << 54) | (1L << 55) | (1L << 56) | (1L << 57) | (1L << 58) | (1L << 59) | (1L << 60) | (1L << 61) | (1L << 62) | (1L << 63))) != 0) || ((((_la - 64)) & ~0x3f) == 0 && ((1L << (_la - 64)) & ((1L << (64 - 64)) | (1L << (65 - 64)) | (1L << (66 - 64)) | (1L << (67 - 64)) | (1L << (68 - 64)) | (1L << (69 - 64)) | (1L << (70 - 64)) | (1L << (71 - 64)) | (1L << (72 - 64)) | (1L << (IF - 64)) | (1L << (ELSE - 64)) | (1L << (FOR - 64)) | (1L << (WHILE - 64)) | (1L << (SWITCH - 64)) | (1L << (CONTINUE - 64)) | (1L << (BREAK - 64)) | (1L << (GOTO - 64)) | (1L << (RETURN - 64)) | (1L << (CASE - 64)) | (1L << (ALPHA_NUMERIC - 64)) | (1L << (CPPCOMMENT - 64)) | (1L << (COMMENT - 64)) | (1L << (STRING - 64)) | (1L << (PREPROC - 64)) | (1L << (HEX_LITERAL - 64)) | (1L << (DECIMAL_LITERAL - 64)) | (1L << (OCTAL_LITERAL - 64)) | (1L << (FLOATING_POINT_LITERAL - 64)) | (1L << (WHITESPACE - 64)) | (1L << (OTHER - 64)))) != 0)) {
					{
					{
					setState(432); no_squares();
					}
					}
					setState(437);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				}
				}
				setState(442);
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

	public static class ExprContext extends ParserRuleContext {
		public ExprContext expr(int i) {
			return getRuleContext(ExprContext.class,i);
		}
		public List<ExprContext> expr() {
			return getRuleContexts(ExprContext.class);
		}
		public No_bracketsContext no_brackets(int i) {
			return getRuleContext(No_bracketsContext.class,i);
		}
		public List<No_bracketsContext> no_brackets() {
			return getRuleContexts(No_bracketsContext.class);
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
		enterRule(_localctx, 60, RULE_expr);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(446);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << 1) | (1L << 2) | (1L << 3) | (1L << 4) | (1L << 5) | (1L << 6) | (1L << 7) | (1L << 8) | (1L << 9) | (1L << 10) | (1L << 11) | (1L << 12) | (1L << 13) | (1L << 14) | (1L << 15) | (1L << 16) | (1L << 18) | (1L << 19) | (1L << 20) | (1L << 21) | (1L << 22) | (1L << 23) | (1L << 24) | (1L << 25) | (1L << 26) | (1L << 27) | (1L << 28) | (1L << 29) | (1L << 30) | (1L << 31) | (1L << 32) | (1L << 33) | (1L << 34) | (1L << 35) | (1L << 36) | (1L << 37) | (1L << 38) | (1L << 39) | (1L << 40) | (1L << 41) | (1L << 42) | (1L << 44) | (1L << 45) | (1L << 46) | (1L << 47) | (1L << 48) | (1L << 49) | (1L << 50) | (1L << 51) | (1L << 52) | (1L << 53) | (1L << 54) | (1L << 55) | (1L << 56) | (1L << 57) | (1L << 58) | (1L << 59) | (1L << 60) | (1L << 61) | (1L << 62) | (1L << 63))) != 0) || ((((_la - 64)) & ~0x3f) == 0 && ((1L << (_la - 64)) & ((1L << (64 - 64)) | (1L << (65 - 64)) | (1L << (66 - 64)) | (1L << (67 - 64)) | (1L << (68 - 64)) | (1L << (69 - 64)) | (1L << (70 - 64)) | (1L << (71 - 64)) | (1L << (72 - 64)) | (1L << (IF - 64)) | (1L << (ELSE - 64)) | (1L << (FOR - 64)) | (1L << (WHILE - 64)) | (1L << (SWITCH - 64)) | (1L << (CONTINUE - 64)) | (1L << (BREAK - 64)) | (1L << (GOTO - 64)) | (1L << (RETURN - 64)) | (1L << (CASE - 64)) | (1L << (ALPHA_NUMERIC - 64)) | (1L << (CPPCOMMENT - 64)) | (1L << (COMMENT - 64)) | (1L << (STRING - 64)) | (1L << (PREPROC - 64)) | (1L << (HEX_LITERAL - 64)) | (1L << (DECIMAL_LITERAL - 64)) | (1L << (OCTAL_LITERAL - 64)) | (1L << (FLOATING_POINT_LITERAL - 64)) | (1L << (WHITESPACE - 64)) | (1L << (OTHER - 64)))) != 0)) {
				{
				{
				setState(443); no_brackets();
				}
				}
				setState(448);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(460);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==43) {
				{
				{
				setState(449); match(43);
				setState(450); expr();
				setState(451); match(17);
				setState(455);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << 1) | (1L << 2) | (1L << 3) | (1L << 4) | (1L << 5) | (1L << 6) | (1L << 7) | (1L << 8) | (1L << 9) | (1L << 10) | (1L << 11) | (1L << 12) | (1L << 13) | (1L << 14) | (1L << 15) | (1L << 16) | (1L << 18) | (1L << 19) | (1L << 20) | (1L << 21) | (1L << 22) | (1L << 23) | (1L << 24) | (1L << 25) | (1L << 26) | (1L << 27) | (1L << 28) | (1L << 29) | (1L << 30) | (1L << 31) | (1L << 32) | (1L << 33) | (1L << 34) | (1L << 35) | (1L << 36) | (1L << 37) | (1L << 38) | (1L << 39) | (1L << 40) | (1L << 41) | (1L << 42) | (1L << 44) | (1L << 45) | (1L << 46) | (1L << 47) | (1L << 48) | (1L << 49) | (1L << 50) | (1L << 51) | (1L << 52) | (1L << 53) | (1L << 54) | (1L << 55) | (1L << 56) | (1L << 57) | (1L << 58) | (1L << 59) | (1L << 60) | (1L << 61) | (1L << 62) | (1L << 63))) != 0) || ((((_la - 64)) & ~0x3f) == 0 && ((1L << (_la - 64)) & ((1L << (64 - 64)) | (1L << (65 - 64)) | (1L << (66 - 64)) | (1L << (67 - 64)) | (1L << (68 - 64)) | (1L << (69 - 64)) | (1L << (70 - 64)) | (1L << (71 - 64)) | (1L << (72 - 64)) | (1L << (IF - 64)) | (1L << (ELSE - 64)) | (1L << (FOR - 64)) | (1L << (WHILE - 64)) | (1L << (SWITCH - 64)) | (1L << (CONTINUE - 64)) | (1L << (BREAK - 64)) | (1L << (GOTO - 64)) | (1L << (RETURN - 64)) | (1L << (CASE - 64)) | (1L << (ALPHA_NUMERIC - 64)) | (1L << (CPPCOMMENT - 64)) | (1L << (COMMENT - 64)) | (1L << (STRING - 64)) | (1L << (PREPROC - 64)) | (1L << (HEX_LITERAL - 64)) | (1L << (DECIMAL_LITERAL - 64)) | (1L << (OCTAL_LITERAL - 64)) | (1L << (FLOATING_POINT_LITERAL - 64)) | (1L << (WHITESPACE - 64)) | (1L << (OTHER - 64)))) != 0)) {
					{
					{
					setState(452); no_brackets();
					}
					}
					setState(457);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				}
				}
				setState(462);
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

	public static class Compound_statementContext extends ParserRuleContext {
		public Compound_statementContext compound_statement(int i) {
			return getRuleContext(Compound_statementContext.class,i);
		}
		public List<No_curliesContext> no_curlies() {
			return getRuleContexts(No_curliesContext.class);
		}
		public No_curliesContext no_curlies(int i) {
			return getRuleContext(No_curliesContext.class,i);
		}
		public List<Compound_statementContext> compound_statement() {
			return getRuleContexts(Compound_statementContext.class);
		}
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
		enterRule(_localctx, 62, RULE_compound_statement);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(463); match(48);
			setState(467);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << 1) | (1L << 2) | (1L << 3) | (1L << 4) | (1L << 5) | (1L << 6) | (1L << 7) | (1L << 8) | (1L << 9) | (1L << 10) | (1L << 12) | (1L << 13) | (1L << 14) | (1L << 15) | (1L << 16) | (1L << 17) | (1L << 18) | (1L << 19) | (1L << 20) | (1L << 21) | (1L << 22) | (1L << 23) | (1L << 24) | (1L << 25) | (1L << 26) | (1L << 27) | (1L << 28) | (1L << 29) | (1L << 30) | (1L << 31) | (1L << 32) | (1L << 33) | (1L << 34) | (1L << 35) | (1L << 36) | (1L << 37) | (1L << 38) | (1L << 39) | (1L << 40) | (1L << 41) | (1L << 42) | (1L << 43) | (1L << 44) | (1L << 45) | (1L << 46) | (1L << 47) | (1L << 49) | (1L << 50) | (1L << 51) | (1L << 52) | (1L << 53) | (1L << 54) | (1L << 55) | (1L << 56) | (1L << 57) | (1L << 58) | (1L << 59) | (1L << 60) | (1L << 61) | (1L << 62) | (1L << 63))) != 0) || ((((_la - 64)) & ~0x3f) == 0 && ((1L << (_la - 64)) & ((1L << (64 - 64)) | (1L << (65 - 64)) | (1L << (66 - 64)) | (1L << (67 - 64)) | (1L << (68 - 64)) | (1L << (69 - 64)) | (1L << (70 - 64)) | (1L << (71 - 64)) | (1L << (72 - 64)) | (1L << (IF - 64)) | (1L << (ELSE - 64)) | (1L << (FOR - 64)) | (1L << (WHILE - 64)) | (1L << (SWITCH - 64)) | (1L << (CONTINUE - 64)) | (1L << (BREAK - 64)) | (1L << (GOTO - 64)) | (1L << (RETURN - 64)) | (1L << (CASE - 64)) | (1L << (ALPHA_NUMERIC - 64)) | (1L << (CPPCOMMENT - 64)) | (1L << (COMMENT - 64)) | (1L << (STRING - 64)) | (1L << (PREPROC - 64)) | (1L << (HEX_LITERAL - 64)) | (1L << (DECIMAL_LITERAL - 64)) | (1L << (OCTAL_LITERAL - 64)) | (1L << (FLOATING_POINT_LITERAL - 64)) | (1L << (WHITESPACE - 64)) | (1L << (OTHER - 64)))) != 0)) {
				{
				{
				setState(464); no_curlies();
				}
				}
				setState(469);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(479);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==48) {
				{
				{
				setState(470); compound_statement();
				setState(474);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << 1) | (1L << 2) | (1L << 3) | (1L << 4) | (1L << 5) | (1L << 6) | (1L << 7) | (1L << 8) | (1L << 9) | (1L << 10) | (1L << 12) | (1L << 13) | (1L << 14) | (1L << 15) | (1L << 16) | (1L << 17) | (1L << 18) | (1L << 19) | (1L << 20) | (1L << 21) | (1L << 22) | (1L << 23) | (1L << 24) | (1L << 25) | (1L << 26) | (1L << 27) | (1L << 28) | (1L << 29) | (1L << 30) | (1L << 31) | (1L << 32) | (1L << 33) | (1L << 34) | (1L << 35) | (1L << 36) | (1L << 37) | (1L << 38) | (1L << 39) | (1L << 40) | (1L << 41) | (1L << 42) | (1L << 43) | (1L << 44) | (1L << 45) | (1L << 46) | (1L << 47) | (1L << 49) | (1L << 50) | (1L << 51) | (1L << 52) | (1L << 53) | (1L << 54) | (1L << 55) | (1L << 56) | (1L << 57) | (1L << 58) | (1L << 59) | (1L << 60) | (1L << 61) | (1L << 62) | (1L << 63))) != 0) || ((((_la - 64)) & ~0x3f) == 0 && ((1L << (_la - 64)) & ((1L << (64 - 64)) | (1L << (65 - 64)) | (1L << (66 - 64)) | (1L << (67 - 64)) | (1L << (68 - 64)) | (1L << (69 - 64)) | (1L << (70 - 64)) | (1L << (71 - 64)) | (1L << (72 - 64)) | (1L << (IF - 64)) | (1L << (ELSE - 64)) | (1L << (FOR - 64)) | (1L << (WHILE - 64)) | (1L << (SWITCH - 64)) | (1L << (CONTINUE - 64)) | (1L << (BREAK - 64)) | (1L << (GOTO - 64)) | (1L << (RETURN - 64)) | (1L << (CASE - 64)) | (1L << (ALPHA_NUMERIC - 64)) | (1L << (CPPCOMMENT - 64)) | (1L << (COMMENT - 64)) | (1L << (STRING - 64)) | (1L << (PREPROC - 64)) | (1L << (HEX_LITERAL - 64)) | (1L << (DECIMAL_LITERAL - 64)) | (1L << (OCTAL_LITERAL - 64)) | (1L << (FLOATING_POINT_LITERAL - 64)) | (1L << (WHITESPACE - 64)) | (1L << (OTHER - 64)))) != 0)) {
					{
					{
					setState(471); no_curlies();
					}
					}
					setState(476);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				}
				}
				setState(481);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(482); match(11);
			}
		}
		catch (RecognitionException re) {
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
		public Parameter_name_startContext x;
		public Type_suffixContext s;
		public Type_suffixContext type_suffix() {
			return getRuleContext(Type_suffixContext.class,0);
		}
		public Parameter_name_startContext parameter_name_start() {
			return getRuleContext(Parameter_name_startContext.class,0);
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
		enterRule(_localctx, 64, RULE_parameter_name);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(484); ((Parameter_nameContext)_localctx).x = parameter_name_start();
			setState(486);
			switch ( getInterpreter().adaptivePredict(_input,66,_ctx) ) {
			case 1:
				{
				setState(485); ((Parameter_nameContext)_localctx).s = type_suffix();
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

	public static class Parameter_name_startContext extends ParserRuleContext {
		public Parameter_nameContext parameter_name() {
			return getRuleContext(Parameter_nameContext.class,0);
		}
		public IdentifierContext identifier() {
			return getRuleContext(IdentifierContext.class,0);
		}
		public Parameter_name_startContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_parameter_name_start; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof CodeSensorListener ) ((CodeSensorListener)listener).enterParameter_name_start(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof CodeSensorListener ) ((CodeSensorListener)listener).exitParameter_name_start(this);
		}
	}

	public final Parameter_name_startContext parameter_name_start() throws RecognitionException {
		Parameter_name_startContext _localctx = new Parameter_name_startContext(_ctx, getState());
		enterRule(_localctx, 66, RULE_parameter_name_start);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(493);
			switch (_input.LA(1)) {
			case 43:
				{
				setState(488); match(43);
				setState(489); parameter_name();
				setState(490); match(17);
				}
				break;
			case ALPHA_NUMERIC:
				{
				setState(492); identifier();
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
		enterRule(_localctx, 68, RULE_ctor_list);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(495); match(42);
			setState(496); ctor_initializer();
			setState(501);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==40) {
				{
				{
				setState(497); match(40);
				setState(498); ctor_initializer();
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
		enterRule(_localctx, 70, RULE_ctor_initializer);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(504); initializer_id();
			setState(505); ctor_expr();
			}
		}
		catch (RecognitionException re) {
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
		enterRule(_localctx, 72, RULE_initializer_id);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(508);
			_la = _input.LA(1);
			if (_la==23) {
				{
				setState(507); match(23);
				}
			}

			setState(510); identifier();
			}
		}
		catch (RecognitionException re) {
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
		enterRule(_localctx, 74, RULE_ctor_expr);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(512); match(43);
			setState(514);
			switch ( getInterpreter().adaptivePredict(_input,70,_ctx) ) {
			case 1:
				{
				setState(513); expr();
				}
				break;
			}
			setState(516); match(17);
			}
		}
		catch (RecognitionException re) {
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
		enterRule(_localctx, 76, RULE_function_name);
		try {
			setState(524);
			switch (_input.LA(1)) {
			case 43:
				enterOuterAlt(_localctx, 1);
				{
				setState(518); match(43);
				setState(519); function_name();
				setState(520); match(17);
				}
				break;
			case ALPHA_NUMERIC:
				enterOuterAlt(_localctx, 2);
				{
				setState(522); identifier();
				}
				break;
			case 60:
				enterOuterAlt(_localctx, 3);
				{
				setState(523); operator_function_id();
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
		enterRule(_localctx, 78, RULE_exception_specification);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(526); match(24);
			setState(527); match(43);
			setState(528); type_id_list();
			setState(529); match(17);
			}
		}
		catch (RecognitionException re) {
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
		enterRule(_localctx, 80, RULE_type_id_list);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(534);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << 1) | (1L << 2) | (1L << 3) | (1L << 4) | (1L << 5) | (1L << 6) | (1L << 7) | (1L << 8) | (1L << 9) | (1L << 10) | (1L << 11) | (1L << 12) | (1L << 13) | (1L << 14) | (1L << 15) | (1L << 16) | (1L << 18) | (1L << 19) | (1L << 20) | (1L << 21) | (1L << 22) | (1L << 23) | (1L << 24) | (1L << 25) | (1L << 26) | (1L << 27) | (1L << 28) | (1L << 29) | (1L << 30) | (1L << 31) | (1L << 32) | (1L << 33) | (1L << 34) | (1L << 35) | (1L << 36) | (1L << 37) | (1L << 38) | (1L << 39) | (1L << 40) | (1L << 41) | (1L << 42) | (1L << 44) | (1L << 45) | (1L << 46) | (1L << 47) | (1L << 48) | (1L << 49) | (1L << 50) | (1L << 51) | (1L << 52) | (1L << 53) | (1L << 54) | (1L << 55) | (1L << 56) | (1L << 57) | (1L << 58) | (1L << 59) | (1L << 60) | (1L << 61) | (1L << 62) | (1L << 63))) != 0) || ((((_la - 64)) & ~0x3f) == 0 && ((1L << (_la - 64)) & ((1L << (64 - 64)) | (1L << (65 - 64)) | (1L << (66 - 64)) | (1L << (67 - 64)) | (1L << (68 - 64)) | (1L << (69 - 64)) | (1L << (70 - 64)) | (1L << (71 - 64)) | (1L << (72 - 64)) | (1L << (IF - 64)) | (1L << (ELSE - 64)) | (1L << (FOR - 64)) | (1L << (WHILE - 64)) | (1L << (SWITCH - 64)) | (1L << (CONTINUE - 64)) | (1L << (BREAK - 64)) | (1L << (GOTO - 64)) | (1L << (RETURN - 64)) | (1L << (CASE - 64)) | (1L << (ALPHA_NUMERIC - 64)) | (1L << (CPPCOMMENT - 64)) | (1L << (COMMENT - 64)) | (1L << (STRING - 64)) | (1L << (PREPROC - 64)) | (1L << (HEX_LITERAL - 64)) | (1L << (DECIMAL_LITERAL - 64)) | (1L << (OCTAL_LITERAL - 64)) | (1L << (FLOATING_POINT_LITERAL - 64)) | (1L << (WHITESPACE - 64)) | (1L << (OTHER - 64)))) != 0)) {
				{
				{
				setState(531); no_brackets();
				}
				}
				setState(536);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(548);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==43) {
				{
				{
				setState(537); match(43);
				setState(538); type_id_list();
				setState(539); match(17);
				setState(543);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << 1) | (1L << 2) | (1L << 3) | (1L << 4) | (1L << 5) | (1L << 6) | (1L << 7) | (1L << 8) | (1L << 9) | (1L << 10) | (1L << 11) | (1L << 12) | (1L << 13) | (1L << 14) | (1L << 15) | (1L << 16) | (1L << 18) | (1L << 19) | (1L << 20) | (1L << 21) | (1L << 22) | (1L << 23) | (1L << 24) | (1L << 25) | (1L << 26) | (1L << 27) | (1L << 28) | (1L << 29) | (1L << 30) | (1L << 31) | (1L << 32) | (1L << 33) | (1L << 34) | (1L << 35) | (1L << 36) | (1L << 37) | (1L << 38) | (1L << 39) | (1L << 40) | (1L << 41) | (1L << 42) | (1L << 44) | (1L << 45) | (1L << 46) | (1L << 47) | (1L << 48) | (1L << 49) | (1L << 50) | (1L << 51) | (1L << 52) | (1L << 53) | (1L << 54) | (1L << 55) | (1L << 56) | (1L << 57) | (1L << 58) | (1L << 59) | (1L << 60) | (1L << 61) | (1L << 62) | (1L << 63))) != 0) || ((((_la - 64)) & ~0x3f) == 0 && ((1L << (_la - 64)) & ((1L << (64 - 64)) | (1L << (65 - 64)) | (1L << (66 - 64)) | (1L << (67 - 64)) | (1L << (68 - 64)) | (1L << (69 - 64)) | (1L << (70 - 64)) | (1L << (71 - 64)) | (1L << (72 - 64)) | (1L << (IF - 64)) | (1L << (ELSE - 64)) | (1L << (FOR - 64)) | (1L << (WHILE - 64)) | (1L << (SWITCH - 64)) | (1L << (CONTINUE - 64)) | (1L << (BREAK - 64)) | (1L << (GOTO - 64)) | (1L << (RETURN - 64)) | (1L << (CASE - 64)) | (1L << (ALPHA_NUMERIC - 64)) | (1L << (CPPCOMMENT - 64)) | (1L << (COMMENT - 64)) | (1L << (STRING - 64)) | (1L << (PREPROC - 64)) | (1L << (HEX_LITERAL - 64)) | (1L << (DECIMAL_LITERAL - 64)) | (1L << (OCTAL_LITERAL - 64)) | (1L << (FLOATING_POINT_LITERAL - 64)) | (1L << (WHITESPACE - 64)) | (1L << (OTHER - 64)))) != 0)) {
					{
					{
					setState(540); no_brackets();
					}
					}
					setState(545);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				}
				}
				setState(550);
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
		public IdentifierContext identifier() {
			return getRuleContext(IdentifierContext.class,0);
		}
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
		enterRule(_localctx, 82, RULE_using_directive);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(551); match(35);
			setState(552); match(10);
			setState(553); identifier();
			setState(554); match(63);
			}
		}
		catch (RecognitionException re) {
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
		enterRule(_localctx, 84, RULE_unary_operator);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(556);
			_la = _input.LA(1);
			if ( !((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << 1) | (1L << 3) | (1L << 32) | (1L << 41) | (1L << 58))) != 0) || _la==71) ) {
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
		enterRule(_localctx, 86, RULE_constant);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(558);
			_la = _input.LA(1);
			if ( !(((((_la - 86)) & ~0x3f) == 0 && ((1L << (_la - 86)) & ((1L << (STRING - 86)) | (1L << (HEX_LITERAL - 86)) | (1L << (DECIMAL_LITERAL - 86)) | (1L << (OCTAL_LITERAL - 86)) | (1L << (FLOATING_POINT_LITERAL - 86)))) != 0)) ) {
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
		enterRule(_localctx, 88, RULE_no_brackets);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(560);
			_la = _input.LA(1);
			if ( _la <= 0 || (_la==17 || _la==43) ) {
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
		enterRule(_localctx, 90, RULE_no_brackets_curlies_or_squares);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(562);
			_la = _input.LA(1);
			if ( _la <= 0 || ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << 4) | (1L << 11) | (1L << 17) | (1L << 34) | (1L << 43) | (1L << 48))) != 0)) ) {
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
		enterRule(_localctx, 92, RULE_no_brackets_or_semicolon);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(564);
			_la = _input.LA(1);
			if ( _la <= 0 || ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << 17) | (1L << 43) | (1L << 63))) != 0)) ) {
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
		enterRule(_localctx, 94, RULE_no_angle_brackets_or_brackets);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(566);
			_la = _input.LA(1);
			if ( _la <= 0 || (((((_la - 5)) & ~0x3f) == 0 && ((1L << (_la - 5)) & ((1L << (5 - 5)) | (1L << (17 - 5)) | (1L << (43 - 5)) | (1L << (66 - 5)))) != 0)) ) {
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
		enterRule(_localctx, 96, RULE_no_curlies);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(568);
			_la = _input.LA(1);
			if ( _la <= 0 || (_la==11 || _la==48) ) {
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
		enterRule(_localctx, 98, RULE_no_squares);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(570);
			_la = _input.LA(1);
			if ( _la <= 0 || (_la==4 || _la==34) ) {
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
		enterRule(_localctx, 100, RULE_no_squares_or_semicolon);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(572);
			_la = _input.LA(1);
			if ( _la <= 0 || ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << 4) | (1L << 34) | (1L << 63))) != 0)) ) {
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
		enterRule(_localctx, 102, RULE_no_comma_or_semicolon);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(574);
			_la = _input.LA(1);
			if ( _la <= 0 || (_la==40 || _la==63) ) {
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

	public static class Cv_qualifierContext extends ParserRuleContext {
		public Cv_qualifierContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_cv_qualifier; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof CodeSensorListener ) ((CodeSensorListener)listener).enterCv_qualifier(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof CodeSensorListener ) ((CodeSensorListener)listener).exitCv_qualifier(this);
		}
	}

	public final Cv_qualifierContext cv_qualifier() throws RecognitionException {
		Cv_qualifierContext _localctx = new Cv_qualifierContext(_ctx, getState());
		enterRule(_localctx, 104, RULE_cv_qualifier);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(576);
			_la = _input.LA(1);
			if ( !(_la==27 || _la==62) ) {
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
		enterRule(_localctx, 106, RULE_function_decl_specifiers);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(578);
			_la = _input.LA(1);
			if ( !((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << 18) | (1L << 20) | (1L << 21) | (1L << 51) | (1L << 53))) != 0)) ) {
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
			if ( listener instanceof CodeSensorListener ) ((CodeSensorListener)listener).enterClass_key(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof CodeSensorListener ) ((CodeSensorListener)listener).exitClass_key(this);
		}
	}

	public final Class_keyContext class_key() throws RecognitionException {
		Class_keyContext _localctx = new Class_keyContext(_ctx, getState());
		enterRule(_localctx, 108, RULE_class_key);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(580);
			_la = _input.LA(1);
			if ( !((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << 15) | (1L << 30) | (1L << 33) | (1L << 52))) != 0)) ) {
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
		enterRule(_localctx, 110, RULE_ptr_operator);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(582);
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
		enterRule(_localctx, 112, RULE_access_specifier);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(584);
			_la = _input.LA(1);
			if ( !((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << 39) | (1L << 45) | (1L << 59))) != 0)) ) {
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
		enterRule(_localctx, 114, RULE_operator_function_id);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(586); match(60);
			setState(587); operator();
			}
		}
		catch (RecognitionException re) {
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
		enterRule(_localctx, 116, RULE_operator);
		int _la;
		try {
			setState(634);
			switch (_input.LA(1)) {
			case 29:
			case 56:
				enterOuterAlt(_localctx, 1);
				{
				{
				setState(589);
				_la = _input.LA(1);
				if ( !(_la==29 || _la==56) ) {
				_errHandler.recoverInline(this);
				}
				consume();
				setState(592);
				_la = _input.LA(1);
				if (_la==4) {
					{
					setState(590); match(4);
					setState(591); match(34);
					}
				}

				}
				}
				break;
			case 58:
				enterOuterAlt(_localctx, 2);
				{
				setState(594); match(58);
				}
				break;
			case 41:
				enterOuterAlt(_localctx, 3);
				{
				setState(595); match(41);
				}
				break;
			case 3:
				enterOuterAlt(_localctx, 4);
				{
				setState(596); match(3);
				}
				break;
			case 69:
				enterOuterAlt(_localctx, 5);
				{
				setState(597); match(69);
				}
				break;
			case 12:
				enterOuterAlt(_localctx, 6);
				{
				setState(598); match(12);
				}
				break;
			case 57:
				enterOuterAlt(_localctx, 7);
				{
				setState(599); match(57);
				}
				break;
			case 1:
				enterOuterAlt(_localctx, 8);
				{
				setState(600); match(1);
				}
				break;
			case 31:
				enterOuterAlt(_localctx, 9);
				{
				setState(601); match(31);
				}
				break;
			case 71:
				enterOuterAlt(_localctx, 10);
				{
				setState(602); match(71);
				}
				break;
			case 32:
				enterOuterAlt(_localctx, 11);
				{
				setState(603); match(32);
				}
				break;
			case 26:
				enterOuterAlt(_localctx, 12);
				{
				setState(604); match(26);
				}
				break;
			case 5:
				enterOuterAlt(_localctx, 13);
				{
				setState(605); match(5);
				}
				break;
			case 66:
				enterOuterAlt(_localctx, 14);
				{
				setState(606); match(66);
				}
				break;
			case 49:
				enterOuterAlt(_localctx, 15);
				{
				setState(607); match(49);
				}
				break;
			case 37:
				enterOuterAlt(_localctx, 16);
				{
				setState(608); match(37);
				}
				break;
			case 16:
				enterOuterAlt(_localctx, 17);
				{
				setState(609); match(16);
				}
				break;
			case 68:
				enterOuterAlt(_localctx, 18);
				{
				setState(610); match(68);
				}
				break;
			case 67:
				enterOuterAlt(_localctx, 19);
				{
				setState(611); match(67);
				}
				break;
			case 50:
				enterOuterAlt(_localctx, 20);
				{
				setState(612); match(50);
				}
				break;
			case 44:
				enterOuterAlt(_localctx, 21);
				{
				setState(613); match(44);
				}
				break;
			case 28:
				enterOuterAlt(_localctx, 22);
				{
				setState(614); match(28);
				}
				break;
			case 55:
				enterOuterAlt(_localctx, 23);
				{
				setState(615); match(55);
				}
				break;
			case 9:
				enterOuterAlt(_localctx, 24);
				{
				setState(616); match(9);
				}
				break;
			case 47:
				enterOuterAlt(_localctx, 25);
				{
				setState(617); match(47);
				}
				break;
			case 36:
				enterOuterAlt(_localctx, 26);
				{
				setState(618); match(36);
				}
				break;
			case 70:
				enterOuterAlt(_localctx, 27);
				{
				setState(619); match(70);
				}
				break;
			case 7:
				enterOuterAlt(_localctx, 28);
				{
				setState(620); match(7);
				}
				break;
			case 8:
				enterOuterAlt(_localctx, 29);
				{
				setState(621); match(8);
				}
				break;
			case 72:
				enterOuterAlt(_localctx, 30);
				{
				setState(622); match(72);
				}
				break;
			case 64:
				enterOuterAlt(_localctx, 31);
				{
				setState(623); match(64);
				}
				break;
			case 65:
				enterOuterAlt(_localctx, 32);
				{
				setState(624); match(65);
				}
				break;
			case 54:
				enterOuterAlt(_localctx, 33);
				{
				setState(625); match(54);
				}
				break;
			case 6:
				enterOuterAlt(_localctx, 34);
				{
				setState(626); match(6);
				}
				break;
			case 40:
				enterOuterAlt(_localctx, 35);
				{
				setState(627); match(40);
				}
				break;
			case 38:
				enterOuterAlt(_localctx, 36);
				{
				setState(628); match(38);
				}
				break;
			case 13:
				enterOuterAlt(_localctx, 37);
				{
				setState(629); match(13);
				}
				break;
			case 43:
				enterOuterAlt(_localctx, 38);
				{
				setState(630); match(43);
				setState(631); match(17);
				}
				break;
			case 4:
				enterOuterAlt(_localctx, 39);
				{
				setState(632); match(4);
				setState(633); match(34);
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
		enterRule(_localctx, 118, RULE_assignment_operator);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(636);
			_la = _input.LA(1);
			if ( !(((((_la - 16)) & ~0x3f) == 0 && ((1L << (_la - 16)) & ((1L << (16 - 16)) | (1L << (26 - 16)) | (1L << (28 - 16)) | (1L << (36 - 16)) | (1L << (37 - 16)) | (1L << (44 - 16)) | (1L << (47 - 16)) | (1L << (49 - 16)) | (1L << (50 - 16)) | (1L << (67 - 16)) | (1L << (68 - 16)))) != 0)) ) {
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
		enterRule(_localctx, 120, RULE_identifier);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(638); match(ALPHA_NUMERIC);
			setState(643);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==23) {
				{
				{
				setState(639); match(23);
				setState(640); match(ALPHA_NUMERIC);
				}
				}
				setState(645);
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
		enterRule(_localctx, 122, RULE_number);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(646);
			_la = _input.LA(1);
			if ( !(((((_la - 88)) & ~0x3f) == 0 && ((1L << (_la - 88)) & ((1L << (HEX_LITERAL - 88)) | (1L << (DECIMAL_LITERAL - 88)) | (1L << (OCTAL_LITERAL - 88)))) != 0)) ) {
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
		public TerminalNode OTHER() { return getToken(CodeSensorParser.OTHER, 0); }
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
		enterRule(_localctx, 124, RULE_water);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(648);
			_la = _input.LA(1);
			if ( _la <= 0 || (_la==OTHER) ) {
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

	public static final String _serializedATN =
		"\2\3_\u028d\4\2\t\2\4\3\t\3\4\4\t\4\4\5\t\5\4\6\t\6\4\7\t\7\4\b\t\b\4"+
		"\t\t\t\4\n\t\n\4\13\t\13\4\f\t\f\4\r\t\r\4\16\t\16\4\17\t\17\4\20\t\20"+
		"\4\21\t\21\4\22\t\22\4\23\t\23\4\24\t\24\4\25\t\25\4\26\t\26\4\27\t\27"+
		"\4\30\t\30\4\31\t\31\4\32\t\32\4\33\t\33\4\34\t\34\4\35\t\35\4\36\t\36"+
		"\4\37\t\37\4 \t \4!\t!\4\"\t\"\4#\t#\4$\t$\4%\t%\4&\t&\4\'\t\'\4(\t(\4"+
		")\t)\4*\t*\4+\t+\4,\t,\4-\t-\4.\t.\4/\t/\4\60\t\60\4\61\t\61\4\62\t\62"+
		"\4\63\t\63\4\64\t\64\4\65\t\65\4\66\t\66\4\67\t\67\48\t8\49\t9\4:\t:\4"+
		";\t;\4<\t<\4=\t=\4>\t>\4?\t?\4@\t@\3\2\7\2\u0082\n\2\f\2\16\2\u0085\13"+
		"\2\3\3\3\3\5\3\u0089\n\3\3\4\3\4\3\4\5\4\u008e\n\4\3\5\5\5\u0091\n\5\3"+
		"\5\5\5\u0094\n\5\3\5\3\5\3\5\3\6\3\6\3\6\3\6\3\6\5\6\u009e\n\6\5\6\u00a0"+
		"\n\6\3\7\3\7\3\7\7\7\u00a5\n\7\f\7\16\7\u00a8\13\7\3\b\5\b\u00ab\n\b\3"+
		"\b\3\b\5\b\u00af\n\b\3\b\3\b\5\b\u00b3\n\b\3\b\3\b\3\b\5\b\u00b8\n\b\3"+
		"\t\3\t\5\t\u00bc\n\t\3\t\5\t\u00bf\n\t\3\t\3\t\3\t\3\t\3\n\3\n\3\13\3"+
		"\13\3\13\3\13\7\13\u00cb\n\13\f\13\16\13\u00ce\13\13\3\f\5\f\u00d1\n\f"+
		"\3\f\5\f\u00d4\n\f\3\f\3\f\3\r\3\r\3\r\3\r\3\r\3\r\3\r\3\r\7\r\u00e0\n"+
		"\r\f\r\16\r\u00e3\13\r\3\16\5\16\u00e6\n\16\3\16\3\16\5\16\u00ea\n\16"+
		"\3\16\5\16\u00ed\n\16\3\16\3\16\3\17\5\17\u00f2\n\17\3\17\5\17\u00f5\n"+
		"\17\3\17\3\17\3\17\5\17\u00fa\n\17\3\17\3\17\3\20\7\20\u00ff\n\20\f\20"+
		"\16\20\u0102\13\20\3\20\3\20\3\20\7\20\u0107\n\20\f\20\16\20\u010a\13"+
		"\20\3\20\7\20\u010d\n\20\f\20\16\20\u0110\13\20\3\21\7\21\u0113\n\21\f"+
		"\21\16\21\u0116\13\21\3\21\5\21\u0119\n\21\3\21\5\21\u011c\n\21\3\21\3"+
		"\21\3\21\3\21\3\21\5\21\u0123\n\21\3\21\3\21\3\21\3\21\3\21\3\21\5\21"+
		"\u012b\n\21\7\21\u012d\n\21\f\21\16\21\u0130\13\21\3\21\5\21\u0133\n\21"+
		"\3\22\3\22\3\22\3\22\3\22\3\23\6\23\u013b\n\23\r\23\16\23\u013c\3\24\7"+
		"\24\u0140\n\24\f\24\16\24\u0143\13\24\3\25\3\25\3\25\3\25\3\25\3\25\3"+
		"\25\3\25\3\25\5\25\u014e\n\25\3\26\3\26\5\26\u0152\n\26\3\26\3\26\7\26"+
		"\u0156\n\26\f\26\16\26\u0159\13\26\3\26\5\26\u015c\n\26\3\27\3\27\3\27"+
		"\3\27\7\27\u0162\n\27\f\27\16\27\u0165\13\27\5\27\u0167\n\27\3\30\3\30"+
		"\3\30\3\31\5\31\u016d\n\31\3\31\3\31\3\31\3\31\5\31\u0173\n\31\3\31\5"+
		"\31\u0176\n\31\3\31\3\31\5\31\u017a\n\31\5\31\u017c\n\31\3\32\6\32\u017f"+
		"\n\32\r\32\16\32\u0180\3\33\5\33\u0184\n\33\3\33\3\33\3\34\3\34\3\34\3"+
		"\34\3\34\5\34\u018d\n\34\3\35\3\35\3\35\3\35\3\35\3\35\3\35\7\35\u0196"+
		"\n\35\f\35\16\35\u0199\13\35\5\35\u019b\n\35\3\35\5\35\u019e\n\35\3\36"+
		"\3\36\5\36\u01a2\n\36\3\36\5\36\u01a5\n\36\3\36\5\36\u01a8\n\36\3\37\7"+
		"\37\u01ab\n\37\f\37\16\37\u01ae\13\37\3\37\3\37\3\37\3\37\7\37\u01b4\n"+
		"\37\f\37\16\37\u01b7\13\37\7\37\u01b9\n\37\f\37\16\37\u01bc\13\37\3 \7"+
		" \u01bf\n \f \16 \u01c2\13 \3 \3 \3 \3 \7 \u01c8\n \f \16 \u01cb\13 \7"+
		" \u01cd\n \f \16 \u01d0\13 \3!\3!\7!\u01d4\n!\f!\16!\u01d7\13!\3!\3!\7"+
		"!\u01db\n!\f!\16!\u01de\13!\7!\u01e0\n!\f!\16!\u01e3\13!\3!\3!\3\"\3\""+
		"\5\"\u01e9\n\"\3#\3#\3#\3#\3#\5#\u01f0\n#\3$\3$\3$\3$\7$\u01f6\n$\f$\16"+
		"$\u01f9\13$\3%\3%\3%\3&\5&\u01ff\n&\3&\3&\3\'\3\'\5\'\u0205\n\'\3\'\3"+
		"\'\3(\3(\3(\3(\3(\3(\5(\u020f\n(\3)\3)\3)\3)\3)\3*\7*\u0217\n*\f*\16*"+
		"\u021a\13*\3*\3*\3*\3*\7*\u0220\n*\f*\16*\u0223\13*\7*\u0225\n*\f*\16"+
		"*\u0228\13*\3+\3+\3+\3+\3+\3,\3,\3-\3-\3.\3.\3/\3/\3\60\3\60\3\61\3\61"+
		"\3\62\3\62\3\63\3\63\3\64\3\64\3\65\3\65\3\66\3\66\3\67\3\67\38\38\39"+
		"\39\3:\3:\3;\3;\3;\3<\3<\3<\5<\u0253\n<\3<\3<\3<\3<\3<\3<\3<\3<\3<\3<"+
		"\3<\3<\3<\3<\3<\3<\3<\3<\3<\3<\3<\3<\3<\3<\3<\3<\3<\3<\3<\3<\3<\3<\3<"+
		"\3<\3<\3<\3<\3<\3<\3<\5<\u027d\n<\3=\3=\3>\3>\3>\7>\u0284\n>\f>\16>\u0287"+
		"\13>\3?\3?\3@\3@\3@\2A\2\4\6\b\n\f\16\20\22\24\26\30\32\34\36 \"$&(*,"+
		".\60\62\64\668:<>@BDFHJLNPRTVXZ\\^`bdfhjlnprtvxz|~\2\30\4\25\25\30\30"+
		"\4\25\25\30\30\4\4\4\20\20\b\3\3\5\5\"\"++<<II\4XXZ]\4\23\23--\b\6\6\r"+
		"\r\23\23$$--\62\62\5\23\23--AA\6\7\7\23\23--DD\4\r\r\62\62\4\6\6$$\5\6"+
		"\6$$AA\4**AA\4\35\35@@\6\24\24\26\27\65\65\67\67\6\21\21  ##\66\66\4\3"+
		"\3\5\5\5))//==\4\37\37::\n\22\22\34\34\36\36&\'..\61\61\63\64EF\3Z\\\3"+
		"__\u02c7\2\u0083\3\2\2\2\4\u0088\3\2\2\2\6\u008d\3\2\2\2\b\u0090\3\2\2"+
		"\2\n\u009f\3\2\2\2\f\u00a1\3\2\2\2\16\u00aa\3\2\2\2\20\u00b9\3\2\2\2\22"+
		"\u00c4\3\2\2\2\24\u00c6\3\2\2\2\26\u00d0\3\2\2\2\30\u00e1\3\2\2\2\32\u00ec"+
		"\3\2\2\2\34\u00f1\3\2\2\2\36\u0100\3\2\2\2 \u0132\3\2\2\2\"\u0134\3\2"+
		"\2\2$\u013a\3\2\2\2&\u0141\3\2\2\2(\u014d\3\2\2\2*\u014f\3\2\2\2,\u0166"+
		"\3\2\2\2.\u0168\3\2\2\2\60\u017b\3\2\2\2\62\u017e\3\2\2\2\64\u0183\3\2"+
		"\2\2\66\u018c\3\2\2\28\u019d\3\2\2\2:\u019f\3\2\2\2<\u01ac\3\2\2\2>\u01c0"+
		"\3\2\2\2@\u01d1\3\2\2\2B\u01e6\3\2\2\2D\u01ef\3\2\2\2F\u01f1\3\2\2\2H"+
		"\u01fa\3\2\2\2J\u01fe\3\2\2\2L\u0202\3\2\2\2N\u020e\3\2\2\2P\u0210\3\2"+
		"\2\2R\u0218\3\2\2\2T\u0229\3\2\2\2V\u022e\3\2\2\2X\u0230\3\2\2\2Z\u0232"+
		"\3\2\2\2\\\u0234\3\2\2\2^\u0236\3\2\2\2`\u0238\3\2\2\2b\u023a\3\2\2\2"+
		"d\u023c\3\2\2\2f\u023e\3\2\2\2h\u0240\3\2\2\2j\u0242\3\2\2\2l\u0244\3"+
		"\2\2\2n\u0246\3\2\2\2p\u0248\3\2\2\2r\u024a\3\2\2\2t\u024c\3\2\2\2v\u027c"+
		"\3\2\2\2x\u027e\3\2\2\2z\u0280\3\2\2\2|\u0288\3\2\2\2~\u028a\3\2\2\2\u0080"+
		"\u0082\5\4\3\2\u0081\u0080\3\2\2\2\u0082\u0085\3\2\2\2\u0083\u0081\3\2"+
		"\2\2\u0083\u0084\3\2\2\2\u0084\3\3\2\2\2\u0085\u0083\3\2\2\2\u0086\u0089"+
		"\5\6\4\2\u0087\u0089\5~@\2\u0088\u0086\3\2\2\2\u0088\u0087\3\2\2\2\u0089"+
		"\5\3\2\2\2\u008a\u008e\5\b\5\2\u008b\u008e\5\34\17\2\u008c\u008e\5T+\2"+
		"\u008d\u008a\3\2\2\2\u008d\u008b\3\2\2\2\u008d\u008c\3\2\2\2\u008e\7\3"+
		"\2\2\2\u008f\u0091\7?\2\2\u0090\u008f\3\2\2\2\u0090\u0091\3\2\2\2\u0091"+
		"\u0093\3\2\2\2\u0092\u0094\5\"\22\2\u0093\u0092\3\2\2\2\u0093\u0094\3"+
		"\2\2\2\u0094\u0095\3\2\2\2\u0095\u0096\5\n\6\2\u0096\u0097\7A\2\2\u0097"+
		"\t\3\2\2\2\u0098\u0099\5 \21\2\u0099\u009a\5\f\7\2\u009a\u00a0\3\2\2\2"+
		"\u009b\u009d\5\20\t\2\u009c\u009e\5\f\7\2\u009d\u009c\3\2\2\2\u009d\u009e"+
		"\3\2\2\2\u009e\u00a0\3\2\2\2\u009f\u0098\3\2\2\2\u009f\u009b\3\2\2\2\u00a0"+
		"\13\3\2\2\2\u00a1\u00a6\5\16\b\2\u00a2\u00a3\7*\2\2\u00a3\u00a5\5\16\b"+
		"\2\u00a4\u00a2\3\2\2\2\u00a5\u00a8\3\2\2\2\u00a6\u00a4\3\2\2\2\u00a6\u00a7"+
		"\3\2\2\2\u00a7\r\3\2\2\2\u00a8\u00a6\3\2\2\2\u00a9\u00ab\5\62\32\2\u00aa"+
		"\u00a9\3\2\2\2\u00aa\u00ab\3\2\2\2\u00ab\u00ac\3\2\2\2\u00ac\u00ae\5z"+
		">\2\u00ad\u00af\5\66\34\2\u00ae\u00ad\3\2\2\2\u00ae\u00af\3\2\2\2\u00af"+
		"\u00b7\3\2\2\2\u00b0\u00b2\7-\2\2\u00b1\u00b3\5> \2\u00b2\u00b1\3\2\2"+
		"\2\u00b2\u00b3\3\2\2\2\u00b3\u00b4\3\2\2\2\u00b4\u00b8\7\23\2\2\u00b5"+
		"\u00b6\7\34\2\2\u00b6\u00b8\5$\23\2\u00b7\u00b0\3\2\2\2\u00b7\u00b5\3"+
		"\2\2\2\u00b7\u00b8\3\2\2\2\u00b8\17\3\2\2\2\u00b9\u00bb\5n8\2\u00ba\u00bc"+
		"\5\22\n\2\u00bb\u00ba\3\2\2\2\u00bb\u00bc\3\2\2\2\u00bc\u00be\3\2\2\2"+
		"\u00bd\u00bf\5\24\13\2\u00be\u00bd\3\2\2\2\u00be\u00bf\3\2\2\2\u00bf\u00c0"+
		"\3\2\2\2\u00c0\u00c1\7\62\2\2\u00c1\u00c2\5\30\r\2\u00c2\u00c3\7\r\2\2"+
		"\u00c3\21\3\2\2\2\u00c4\u00c5\5z>\2\u00c5\23\3\2\2\2\u00c6\u00c7\7,\2"+
		"\2\u00c7\u00cc\5\26\f\2\u00c8\u00c9\7*\2\2\u00c9\u00cb\5\26\f\2\u00ca"+
		"\u00c8\3\2\2\2\u00cb\u00ce\3\2\2\2\u00cc\u00ca\3\2\2\2\u00cc\u00cd\3\2"+
		"\2\2\u00cd\25\3\2\2\2\u00ce\u00cc\3\2\2\2\u00cf\u00d1\7\24\2\2\u00d0\u00cf"+
		"\3\2\2\2\u00d0\u00d1\3\2\2\2\u00d1\u00d3\3\2\2\2\u00d2\u00d4\5r:\2\u00d3"+
		"\u00d2\3\2\2\2\u00d3\u00d4\3\2\2\2\u00d4\u00d5\3\2\2\2\u00d5\u00d6\5z"+
		">\2\u00d6\27\3\2\2\2\u00d7\u00e0\5\b\5\2\u00d8\u00e0\5\34\17\2\u00d9\u00e0"+
		"\5\32\16\2\u00da\u00db\7\62\2\2\u00db\u00dc\5\30\r\2\u00dc\u00dd\7\r\2"+
		"\2\u00dd\u00e0\3\2\2\2\u00de\u00e0\5b\62\2\u00df\u00d7\3\2\2\2\u00df\u00d8"+
		"\3\2\2\2\u00df\u00d9\3\2\2\2\u00df\u00da\3\2\2\2\u00df\u00de\3\2\2\2\u00e0"+
		"\u00e3\3\2\2\2\u00e1\u00df\3\2\2\2\u00e1\u00e2\3\2\2\2\u00e2\31\3\2\2"+
		"\2\u00e3\u00e1\3\2\2\2\u00e4\u00e6\7T\2\2\u00e5\u00e4\3\2\2\2\u00e5\u00e6"+
		"\3\2\2\2\u00e6\u00e9\3\2\2\2\u00e7\u00ea\5z>\2\u00e8\u00ea\5|?\2\u00e9"+
		"\u00e7\3\2\2\2\u00e9\u00e8\3\2\2\2\u00ea\u00ed\3\2\2\2\u00eb\u00ed\5r"+
		":\2\u00ec\u00e5\3\2\2\2\u00ec\u00eb\3\2\2\2\u00ed\u00ee\3\2\2\2\u00ee"+
		"\u00ef\7,\2\2\u00ef\33\3\2\2\2\u00f0\u00f2\5\"\22\2\u00f1\u00f0\3\2\2"+
		"\2\u00f1\u00f2\3\2\2\2\u00f2\u00f4\3\2\2\2\u00f3\u00f5\5\36\20\2\u00f4"+
		"\u00f3\3\2\2\2\u00f4\u00f5\3\2\2\2\u00f5\u00f6\3\2\2\2\u00f6\u00f7\5N"+
		"(\2\u00f7\u00f9\5*\26\2\u00f8\u00fa\5F$\2\u00f9\u00f8\3\2\2\2\u00f9\u00fa"+
		"\3\2\2\2\u00fa\u00fb\3\2\2\2\u00fb\u00fc\5@!\2\u00fc\35\3\2\2\2\u00fd"+
		"\u00ff\5l\67\2\u00fe\u00fd\3\2\2\2\u00ff\u0102\3\2\2\2\u0100\u00fe\3\2"+
		"\2\2\u0100\u0101\3\2\2\2\u0101\u0103\3\2\2\2\u0102\u0100\3\2\2\2\u0103"+
		"\u0104\5 \21\2\u0104\u0108\3\2\2\2\u0105\u0107\5l\67\2\u0106\u0105\3\2"+
		"\2\2\u0107\u010a\3\2\2\2\u0108\u0106\3\2\2\2\u0108\u0109\3\2\2\2\u0109"+
		"\u010e\3\2\2\2\u010a\u0108\3\2\2\2\u010b\u010d\5p9\2\u010c\u010b\3\2\2"+
		"\2\u010d\u0110\3\2\2\2\u010e\u010c\3\2\2\2\u010e\u010f\3\2\2\2\u010f\37"+
		"\3\2\2\2\u0110\u010e\3\2\2\2\u0111\u0113\5j\66\2\u0112\u0111\3\2\2\2\u0113"+
		"\u0116\3\2\2\2\u0114\u0112\3\2\2\2\u0114\u0115\3\2\2\2\u0115\u0118\3\2"+
		"\2\2\u0116\u0114\3\2\2\2\u0117\u0119\5n8\2\u0118\u0117\3\2\2\2\u0118\u0119"+
		"\3\2\2\2\u0119\u011b\3\2\2\2\u011a\u011c\t\2\2\2\u011b\u011a\3\2\2\2\u011b"+
		"\u011c\3\2\2\2\u011c\u011d\3\2\2\2\u011d\u0122\7U\2\2\u011e\u011f\7\7"+
		"\2\2\u011f\u0120\5&\24\2\u0120\u0121\7D\2\2\u0121\u0123\3\2\2\2\u0122"+
		"\u011e\3\2\2\2\u0122\u0123\3\2\2\2\u0123\u012e\3\2\2\2\u0124\u0125\7\31"+
		"\2\2\u0125\u012a\7U\2\2\u0126\u0127\7\7\2\2\u0127\u0128\5&\24\2\u0128"+
		"\u0129\7D\2\2\u0129\u012b\3\2\2\2\u012a\u0126\3\2\2\2\u012a\u012b\3\2"+
		"\2\2\u012b\u012d\3\2\2\2\u012c\u0124\3\2\2\2\u012d\u0130\3\2\2\2\u012e"+
		"\u012c\3\2\2\2\u012e\u012f\3\2\2\2\u012f\u0133\3\2\2\2\u0130\u012e\3\2"+
		"\2\2\u0131\u0133\t\3\2\2\u0132\u0114\3\2\2\2\u0132\u0131\3\2\2\2\u0133"+
		"!\3\2\2\2\u0134\u0135\7\33\2\2\u0135\u0136\7\7\2\2\u0136\u0137\5&\24\2"+
		"\u0137\u0138\7D\2\2\u0138#\3\2\2\2\u0139\u013b\5h\65\2\u013a\u0139\3\2"+
		"\2\2\u013b\u013c\3\2\2\2\u013c\u013a\3\2\2\2\u013c\u013d\3\2\2\2\u013d"+
		"%\3\2\2\2\u013e\u0140\5(\25\2\u013f\u013e\3\2\2\2\u0140\u0143\3\2\2\2"+
		"\u0141\u013f\3\2\2\2\u0141\u0142\3\2\2\2\u0142\'\3\2\2\2\u0143\u0141\3"+
		"\2\2\2\u0144\u0145\7\7\2\2\u0145\u0146\5&\24\2\u0146\u0147\7D\2\2\u0147"+
		"\u014e\3\2\2\2\u0148\u0149\7-\2\2\u0149\u014a\5&\24\2\u014a\u014b\7\23"+
		"\2\2\u014b\u014e\3\2\2\2\u014c\u014e\5`\61\2\u014d\u0144\3\2\2\2\u014d"+
		"\u0148\3\2\2\2\u014d\u014c\3\2\2\2\u014e)\3\2\2\2\u014f\u0151\7-\2\2\u0150"+
		"\u0152\5,\27\2\u0151\u0150\3\2\2\2\u0151\u0152\3\2\2\2\u0152\u0153\3\2"+
		"\2\2\u0153\u0157\7\23\2\2\u0154\u0156\5j\66\2\u0155\u0154\3\2\2\2\u0156"+
		"\u0159\3\2\2\2\u0157\u0155\3\2\2\2\u0157\u0158\3\2\2\2\u0158\u015b\3\2"+
		"\2\2\u0159\u0157\3\2\2\2\u015a\u015c\5P)\2\u015b\u015a\3\2\2\2\u015b\u015c"+
		"\3\2\2\2\u015c+\3\2\2\2\u015d\u0167\7\60\2\2\u015e\u0163\5.\30\2\u015f"+
		"\u0160\7*\2\2\u0160\u0162\5.\30\2\u0161\u015f\3\2\2\2\u0162\u0165\3\2"+
		"\2\2\u0163\u0161\3\2\2\2\u0163\u0164\3\2\2\2\u0164\u0167\3\2\2\2\u0165"+
		"\u0163\3\2\2\2\u0166\u015d\3\2\2\2\u0166\u015e\3\2\2\2\u0167-\3\2\2\2"+
		"\u0168\u0169\5\64\33\2\u0169\u016a\5\60\31\2\u016a/\3\2\2\2\u016b\u016d"+
		"\5\62\32\2\u016c\u016b\3\2\2\2\u016c\u016d\3\2\2\2\u016d\u016e\3\2\2\2"+
		"\u016e\u016f\7-\2\2\u016f\u0170\5\60\31\2\u0170\u0172\7\23\2\2\u0171\u0173"+
		"\5\66\34\2\u0172\u0171\3\2\2\2\u0172\u0173\3\2\2\2\u0173\u017c\3\2\2\2"+
		"\u0174\u0176\5\62\32\2\u0175\u0174\3\2\2\2\u0175\u0176\3\2\2\2\u0176\u0177"+
		"\3\2\2\2\u0177\u0179\5B\"\2\u0178\u017a\5\66\34\2\u0179\u0178\3\2\2\2"+
		"\u0179\u017a\3\2\2\2\u017a\u017c\3\2\2\2\u017b\u016c\3\2\2\2\u017b\u0175"+
		"\3\2\2\2\u017c\61\3\2\2\2\u017d\u017f\5p9\2\u017e\u017d\3\2\2\2\u017f"+
		"\u0180\3\2\2\2\u0180\u017e\3\2\2\2\u0180\u0181\3\2\2\2\u0181\63\3\2\2"+
		"\2\u0182\u0184\t\4\2\2\u0183\u0182\3\2\2\2\u0183\u0184\3\2\2\2\u0184\u0185"+
		"\3\2\2\2\u0185\u0186\5 \21\2\u0186\65\3\2\2\2\u0187\u0188\7\6\2\2\u0188"+
		"\u0189\5<\37\2\u0189\u018a\7$\2\2\u018a\u018d\3\2\2\2\u018b\u018d\58\35"+
		"\2\u018c\u0187\3\2\2\2\u018c\u018b\3\2\2\2\u018d\67\3\2\2\2\u018e\u018f"+
		"\7-\2\2\u018f\u0190\7\60\2\2\u0190\u019e\7\23\2\2\u0191\u019a\7-\2\2\u0192"+
		"\u0197\5:\36\2\u0193\u0194\7*\2\2\u0194\u0196\5:\36\2\u0195\u0193\3\2"+
		"\2\2\u0196\u0199\3\2\2\2\u0197\u0195\3\2\2\2\u0197\u0198\3\2\2\2\u0198"+
		"\u019b\3\2\2\2\u0199\u0197\3\2\2\2\u019a\u0192\3\2\2\2\u019a\u019b\3\2"+
		"\2\2\u019b\u019c\3\2\2\2\u019c\u019e\7\23\2\2\u019d\u018e\3\2\2\2\u019d"+
		"\u0191\3\2\2\2\u019e9\3\2\2\2\u019f\u01a1\5\64\33\2\u01a0\u01a2\5\62\32"+
		"\2\u01a1\u01a0\3\2\2\2\u01a1\u01a2\3\2\2\2\u01a2\u01a4\3\2\2\2\u01a3\u01a5"+
		"\5B\"\2\u01a4\u01a3\3\2\2\2\u01a4\u01a5\3\2\2\2\u01a5\u01a7\3\2\2\2\u01a6"+
		"\u01a8\5\66\34\2\u01a7\u01a6\3\2\2\2\u01a7\u01a8\3\2\2\2\u01a8;\3\2\2"+
		"\2\u01a9\u01ab\5d\63\2\u01aa\u01a9\3\2\2\2\u01ab\u01ae\3\2\2\2\u01ac\u01aa"+
		"\3\2\2\2\u01ac\u01ad\3\2\2\2\u01ad\u01ba\3\2\2\2\u01ae\u01ac\3\2\2\2\u01af"+
		"\u01b0\7\6\2\2\u01b0\u01b1\5<\37\2\u01b1\u01b5\7$\2\2\u01b2\u01b4\5d\63"+
		"\2\u01b3\u01b2\3\2\2\2\u01b4\u01b7\3\2\2\2\u01b5\u01b3\3\2\2\2\u01b5\u01b6"+
		"\3\2\2\2\u01b6\u01b9\3\2\2\2\u01b7\u01b5\3\2\2\2\u01b8\u01af\3\2\2\2\u01b9"+
		"\u01bc\3\2\2\2\u01ba\u01b8\3\2\2\2\u01ba\u01bb\3\2\2\2\u01bb=\3\2\2\2"+
		"\u01bc\u01ba\3\2\2\2\u01bd\u01bf\5Z.\2\u01be\u01bd\3\2\2\2\u01bf\u01c2"+
		"\3\2\2\2\u01c0\u01be\3\2\2\2\u01c0\u01c1\3\2\2\2\u01c1\u01ce\3\2\2\2\u01c2"+
		"\u01c0\3\2\2\2\u01c3\u01c4\7-\2\2\u01c4\u01c5\5> \2\u01c5\u01c9\7\23\2"+
		"\2\u01c6\u01c8\5Z.\2\u01c7\u01c6\3\2\2\2\u01c8\u01cb\3\2\2\2\u01c9\u01c7"+
		"\3\2\2\2\u01c9\u01ca\3\2\2\2\u01ca\u01cd\3\2\2\2\u01cb\u01c9\3\2\2\2\u01cc"+
		"\u01c3\3\2\2\2\u01cd\u01d0\3\2\2\2\u01ce\u01cc\3\2\2\2\u01ce\u01cf\3\2"+
		"\2\2\u01cf?\3\2\2\2\u01d0\u01ce\3\2\2\2\u01d1\u01d5\7\62\2\2\u01d2\u01d4"+
		"\5b\62\2\u01d3\u01d2\3\2\2\2\u01d4\u01d7\3\2\2\2\u01d5\u01d3\3\2\2\2\u01d5"+
		"\u01d6\3\2\2\2\u01d6\u01e1\3\2\2\2\u01d7\u01d5\3\2\2\2\u01d8\u01dc\5@"+
		"!\2\u01d9\u01db\5b\62\2\u01da\u01d9\3\2\2\2\u01db\u01de\3\2\2\2\u01dc"+
		"\u01da\3\2\2\2\u01dc\u01dd\3\2\2\2\u01dd\u01e0\3\2\2\2\u01de\u01dc\3\2"+
		"\2\2\u01df\u01d8\3\2\2\2\u01e0\u01e3\3\2\2\2\u01e1\u01df\3\2\2\2\u01e1"+
		"\u01e2\3\2\2\2\u01e2\u01e4\3\2\2\2\u01e3\u01e1\3\2\2\2\u01e4\u01e5\7\r"+
		"\2\2\u01e5A\3\2\2\2\u01e6\u01e8\5D#\2\u01e7\u01e9\5\66\34\2\u01e8\u01e7"+
		"\3\2\2\2\u01e8\u01e9\3\2\2\2\u01e9C\3\2\2\2\u01ea\u01eb\7-\2\2\u01eb\u01ec"+
		"\5B\"\2\u01ec\u01ed\7\23\2\2\u01ed\u01f0\3\2\2\2\u01ee\u01f0\5z>\2\u01ef"+
		"\u01ea\3\2\2\2\u01ef\u01ee\3\2\2\2\u01f0E\3\2\2\2\u01f1\u01f2\7,\2\2\u01f2"+
		"\u01f7\5H%\2\u01f3\u01f4\7*\2\2\u01f4\u01f6\5H%\2\u01f5\u01f3\3\2\2\2"+
		"\u01f6\u01f9\3\2\2\2\u01f7\u01f5\3\2\2\2\u01f7\u01f8\3\2\2\2\u01f8G\3"+
		"\2\2\2\u01f9\u01f7\3\2\2\2\u01fa\u01fb\5J&\2\u01fb\u01fc\5L\'\2\u01fc"+
		"I\3\2\2\2\u01fd\u01ff\7\31\2\2\u01fe\u01fd\3\2\2\2\u01fe\u01ff\3\2\2\2"+
		"\u01ff\u0200\3\2\2\2\u0200\u0201\5z>\2\u0201K\3\2\2\2\u0202\u0204\7-\2"+
		"\2\u0203\u0205\5> \2\u0204\u0203\3\2\2\2\u0204\u0205\3\2\2\2\u0205\u0206"+
		"\3\2\2\2\u0206\u0207\7\23\2\2\u0207M\3\2\2\2\u0208\u0209\7-\2\2\u0209"+
		"\u020a\5N(\2\u020a\u020b\7\23\2\2\u020b\u020f\3\2\2\2\u020c\u020f\5z>"+
		"\2\u020d\u020f\5t;\2\u020e\u0208\3\2\2\2\u020e\u020c\3\2\2\2\u020e\u020d"+
		"\3\2\2\2\u020fO\3\2\2\2\u0210\u0211\7\32\2\2\u0211\u0212\7-\2\2\u0212"+
		"\u0213\5R*\2\u0213\u0214\7\23\2\2\u0214Q\3\2\2\2\u0215\u0217\5Z.\2\u0216"+
		"\u0215\3\2\2\2\u0217\u021a\3\2\2\2\u0218\u0216\3\2\2\2\u0218\u0219\3\2"+
		"\2\2\u0219\u0226\3\2\2\2\u021a\u0218\3\2\2\2\u021b\u021c\7-\2\2\u021c"+
		"\u021d\5R*\2\u021d\u0221\7\23\2\2\u021e\u0220\5Z.\2\u021f\u021e\3\2\2"+
		"\2\u0220\u0223\3\2\2\2\u0221\u021f\3\2\2\2\u0221\u0222\3\2\2\2\u0222\u0225"+
		"\3\2\2\2\u0223\u0221\3\2\2\2\u0224\u021b\3\2\2\2\u0225\u0228\3\2\2\2\u0226"+
		"\u0224\3\2\2\2\u0226\u0227\3\2\2\2\u0227S\3\2\2\2\u0228\u0226\3\2\2\2"+
		"\u0229\u022a\7%\2\2\u022a\u022b\7\f\2\2\u022b\u022c\5z>\2\u022c\u022d"+
		"\7A\2\2\u022dU\3\2\2\2\u022e\u022f\t\5\2\2\u022fW\3\2\2\2\u0230\u0231"+
		"\t\6\2\2\u0231Y\3\2\2\2\u0232\u0233\n\7\2\2\u0233[\3\2\2\2\u0234\u0235"+
		"\n\b\2\2\u0235]\3\2\2\2\u0236\u0237\n\t\2\2\u0237_\3\2\2\2\u0238\u0239"+
		"\n\n\2\2\u0239a\3\2\2\2\u023a\u023b\n\13\2\2\u023bc\3\2\2\2\u023c\u023d"+
		"\n\f\2\2\u023de\3\2\2\2\u023e\u023f\n\r\2\2\u023fg\3\2\2\2\u0240\u0241"+
		"\n\16\2\2\u0241i\3\2\2\2\u0242\u0243\t\17\2\2\u0243k\3\2\2\2\u0244\u0245"+
		"\t\20\2\2\u0245m\3\2\2\2\u0246\u0247\t\21\2\2\u0247o\3\2\2\2\u0248\u0249"+
		"\t\22\2\2\u0249q\3\2\2\2\u024a\u024b\t\23\2\2\u024bs\3\2\2\2\u024c\u024d"+
		"\7>\2\2\u024d\u024e\5v<\2\u024eu\3\2\2\2\u024f\u0252\t\24\2\2\u0250\u0251"+
		"\7\6\2\2\u0251\u0253\7$\2\2\u0252\u0250\3\2\2\2\u0252\u0253\3\2\2\2\u0253"+
		"\u027d\3\2\2\2\u0254\u027d\7<\2\2\u0255\u027d\7+\2\2\u0256\u027d\7\5\2"+
		"\2\u0257\u027d\7G\2\2\u0258\u027d\7\16\2\2\u0259\u027d\7;\2\2\u025a\u027d"+
		"\7\3\2\2\u025b\u027d\7!\2\2\u025c\u027d\7I\2\2\u025d\u027d\7\"\2\2\u025e"+
		"\u027d\7\34\2\2\u025f\u027d\7\7\2\2\u0260\u027d\7D\2\2\u0261\u027d\7\63"+
		"\2\2\u0262\u027d\7\'\2\2\u0263\u027d\7\22\2\2\u0264\u027d\7F\2\2\u0265"+
		"\u027d\7E\2\2\u0266\u027d\7\64\2\2\u0267\u027d\7.\2\2\u0268\u027d\7\36"+
		"\2\2\u0269\u027d\79\2\2\u026a\u027d\7\13\2\2\u026b\u027d\7\61\2\2\u026c"+
		"\u027d\7&\2\2\u026d\u027d\7H\2\2\u026e\u027d\7\t\2\2\u026f\u027d\7\n\2"+
		"\2\u0270\u027d\7J\2\2\u0271\u027d\7B\2\2\u0272\u027d\7C\2\2\u0273\u027d"+
		"\78\2\2\u0274\u027d\7\b\2\2\u0275\u027d\7*\2\2\u0276\u027d\7(\2\2\u0277"+
		"\u027d\7\17\2\2\u0278\u0279\7-\2\2\u0279\u027d\7\23\2\2\u027a\u027b\7"+
		"\6\2\2\u027b\u027d\7$\2\2\u027c\u024f\3\2\2\2\u027c\u0254\3\2\2\2\u027c"+
		"\u0255\3\2\2\2\u027c\u0256\3\2\2\2\u027c\u0257\3\2\2\2\u027c\u0258\3\2"+
		"\2\2\u027c\u0259\3\2\2\2\u027c\u025a\3\2\2\2\u027c\u025b\3\2\2\2\u027c"+
		"\u025c\3\2\2\2\u027c\u025d\3\2\2\2\u027c\u025e\3\2\2\2\u027c\u025f\3\2"+
		"\2\2\u027c\u0260\3\2\2\2\u027c\u0261\3\2\2\2\u027c\u0262\3\2\2\2\u027c"+
		"\u0263\3\2\2\2\u027c\u0264\3\2\2\2\u027c\u0265\3\2\2\2\u027c\u0266\3\2"+
		"\2\2\u027c\u0267\3\2\2\2\u027c\u0268\3\2\2\2\u027c\u0269\3\2\2\2\u027c"+
		"\u026a\3\2\2\2\u027c\u026b\3\2\2\2\u027c\u026c\3\2\2\2\u027c\u026d\3\2"+
		"\2\2\u027c\u026e\3\2\2\2\u027c\u026f\3\2\2\2\u027c\u0270\3\2\2\2\u027c"+
		"\u0271\3\2\2\2\u027c\u0272\3\2\2\2\u027c\u0273\3\2\2\2\u027c\u0274\3\2"+
		"\2\2\u027c\u0275\3\2\2\2\u027c\u0276\3\2\2\2\u027c\u0277\3\2\2\2\u027c"+
		"\u0278\3\2\2\2\u027c\u027a\3\2\2\2\u027dw\3\2\2\2\u027e\u027f\t\25\2\2"+
		"\u027fy\3\2\2\2\u0280\u0285\7U\2\2\u0281\u0282\7\31\2\2\u0282\u0284\7"+
		"U\2\2\u0283\u0281\3\2\2\2\u0284\u0287\3\2\2\2\u0285\u0283\3\2\2\2\u0285"+
		"\u0286\3\2\2\2\u0286{\3\2\2\2\u0287\u0285\3\2\2\2\u0288\u0289\t\26\2\2"+
		"\u0289}\3\2\2\2\u028a\u028b\n\27\2\2\u028b\177\3\2\2\2P\u0083\u0088\u008d"+
		"\u0090\u0093\u009d\u009f\u00a6\u00aa\u00ae\u00b2\u00b7\u00bb\u00be\u00cc"+
		"\u00d0\u00d3\u00df\u00e1\u00e5\u00e9\u00ec\u00f1\u00f4\u00f9\u0100\u0108"+
		"\u010e\u0114\u0118\u011b\u0122\u012a\u012e\u0132\u013c\u0141\u014d\u0151"+
		"\u0157\u015b\u0163\u0166\u016c\u0172\u0175\u0179\u017b\u0180\u0183\u018c"+
		"\u0197\u019a\u019d\u01a1\u01a4\u01a7\u01ac\u01b5\u01ba\u01c0\u01c9\u01ce"+
		"\u01d5\u01dc\u01e1\u01e8\u01ef\u01f7\u01fe\u0204\u020e\u0218\u0221\u0226"+
		"\u0252\u027c\u0285";
	public static final ATN _ATN =
		ATNSimulator.deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
	}
}