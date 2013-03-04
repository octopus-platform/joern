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
		T__5=67, T__4=68, T__3=69, T__2=70, T__1=71, T__0=72, ALPHA_NUMERIC=73, 
		CPPCOMMENT=74, COMMENT=75, STRING=76, PREPROC=77, HEX_LITERAL=78, DECIMAL_LITERAL=79, 
		OCTAL_LITERAL=80, FLOATING_POINT_LITERAL=81, WHITESPACE=82, OTHER=83;
	public static final String[] tokenNames = {
		"<INVALID>", "'&'", "'register'", "'*'", "'['", "'<'", "'--'", "'!='", 
		"'<='", "'<<'", "'namespace'", "'}'", "'case'", "'%'", "'->'", "'auto'", 
		"'union'", "'*='", "')'", "'virtual'", "'signed'", "'explicit'", "'inline'", 
		"'unsigned'", "'::'", "'throw'", "'template'", "'='", "'const'", "'|='", 
		"'new'", "'class'", "'|'", "'!'", "'enum'", "']'", "'using'", "'<<='", 
		"'-='", "'->*'", "'public'", "','", "'-'", "':'", "'('", "'&='", "'private'", 
		"'>>='", "'{'", "'+='", "'^='", "'friend'", "'struct'", "'static'", "'++'", 
		"'>>'", "'delete'", "'^'", "'+'", "'protected'", "'operator'", "'typedef'", 
		"'volatile'", "';'", "'&&'", "'||'", "'>'", "'%='", "'/='", "'/'", "'=='", 
		"'~'", "'>='", "ALPHA_NUMERIC", "CPPCOMMENT", "COMMENT", "STRING", "PREPROC", 
		"HEX_LITERAL", "DECIMAL_LITERAL", "OCTAL_LITERAL", "FLOATING_POINT_LITERAL", 
		"WHITESPACE", "OTHER"
	};
	public static final int
		RULE_code = 0, RULE_part = 1, RULE_declaration = 2, RULE_simple_decl = 3, 
		RULE_var_decl = 4, RULE_init_declarator_list = 5, RULE_init_declarator = 6, 
		RULE_class_def = 7, RULE_class_name = 8, RULE_base_classes = 9, RULE_base_class = 10, 
		RULE_class_content = 11, RULE_class_content_elem = 12, RULE_label = 13, 
		RULE_function_def = 14, RULE_return_type = 15, RULE_type_name = 16, RULE_template_decl_start = 17, 
		RULE_assign_expr = 18, RULE_template_param_list = 19, RULE_template_param_list_elem = 20, 
		RULE_function_param_list = 21, RULE_parameter_decl_clause = 22, RULE_parameter_decl = 23, 
		RULE_ptrs = 24, RULE_param_decl_specifiers = 25, RULE_type_suffix = 26, 
		RULE_constant_expr = 27, RULE_expr = 28, RULE_compound_statement = 29, 
		RULE_parameter_name = 30, RULE_parameter_name_start = 31, RULE_ctor_list = 32, 
		RULE_ctor_initializer = 33, RULE_initializer_id = 34, RULE_ctor_expr = 35, 
		RULE_function_name = 36, RULE_exception_specification = 37, RULE_type_id_list = 38, 
		RULE_using_directive = 39, RULE_unary_operator = 40, RULE_constant = 41, 
		RULE_no_brackets = 42, RULE_no_brackets_curlies_or_squares = 43, RULE_no_brackets_or_semicolon = 44, 
		RULE_no_angle_brackets_or_brackets = 45, RULE_no_curlies = 46, RULE_no_squares = 47, 
		RULE_no_squares_or_semicolon = 48, RULE_no_comma_or_semicolon = 49, RULE_cv_qualifier = 50, 
		RULE_function_decl_specifiers = 51, RULE_class_key = 52, RULE_ptr_operator = 53, 
		RULE_access_specifier = 54, RULE_operator_function_id = 55, RULE_operator = 56, 
		RULE_assignment_operator = 57, RULE_identifier = 58, RULE_number = 59, 
		RULE_water = 60;
	public static final String[] ruleNames = {
		"code", "part", "declaration", "simple_decl", "var_decl", "init_declarator_list", 
		"init_declarator", "class_def", "class_name", "base_classes", "base_class", 
		"class_content", "class_content_elem", "label", "function_def", "return_type", 
		"type_name", "template_decl_start", "assign_expr", "template_param_list", 
		"template_param_list_elem", "function_param_list", "parameter_decl_clause", 
		"parameter_decl", "ptrs", "param_decl_specifiers", "type_suffix", "constant_expr", 
		"expr", "compound_statement", "parameter_name", "parameter_name_start", 
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
			setState(125);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << 1) | (1L << 2) | (1L << 3) | (1L << 4) | (1L << 5) | (1L << 6) | (1L << 7) | (1L << 8) | (1L << 9) | (1L << 10) | (1L << 11) | (1L << 12) | (1L << 13) | (1L << 14) | (1L << 15) | (1L << 16) | (1L << 17) | (1L << 18) | (1L << 19) | (1L << 20) | (1L << 21) | (1L << 22) | (1L << 23) | (1L << 24) | (1L << 25) | (1L << 26) | (1L << 27) | (1L << 28) | (1L << 29) | (1L << 30) | (1L << 31) | (1L << 32) | (1L << 33) | (1L << 34) | (1L << 35) | (1L << 36) | (1L << 37) | (1L << 38) | (1L << 39) | (1L << 40) | (1L << 41) | (1L << 42) | (1L << 43) | (1L << 44) | (1L << 45) | (1L << 46) | (1L << 47) | (1L << 48) | (1L << 49) | (1L << 50) | (1L << 51) | (1L << 52) | (1L << 53) | (1L << 54) | (1L << 55) | (1L << 56) | (1L << 57) | (1L << 58) | (1L << 59) | (1L << 60) | (1L << 61) | (1L << 62) | (1L << 63))) != 0) || ((((_la - 64)) & ~0x3f) == 0 && ((1L << (_la - 64)) & ((1L << (64 - 64)) | (1L << (65 - 64)) | (1L << (66 - 64)) | (1L << (67 - 64)) | (1L << (68 - 64)) | (1L << (69 - 64)) | (1L << (70 - 64)) | (1L << (71 - 64)) | (1L << (72 - 64)) | (1L << (ALPHA_NUMERIC - 64)) | (1L << (CPPCOMMENT - 64)) | (1L << (COMMENT - 64)) | (1L << (STRING - 64)) | (1L << (PREPROC - 64)) | (1L << (HEX_LITERAL - 64)) | (1L << (DECIMAL_LITERAL - 64)) | (1L << (OCTAL_LITERAL - 64)) | (1L << (FLOATING_POINT_LITERAL - 64)) | (1L << (WHITESPACE - 64)) | (1L << (26 - 64)) | (1L << (28 - 64)) | (1L << (31 - 64)) | (1L << (34 - 64)) | (1L << (36 - 64)) | (1L << (44 - 64)) | (1L << (51 - 64)) | (1L << (52 - 64)) | (1L << (53 - 64)) | (1L << (60 - 64)) | (1L << (61 - 64)) | (1L << (62 - 64)) | (1L << (ALPHA_NUMERIC - 64)))) != 0)) {
				{
				{
				setState(122); part();
				}
				}
				setState(127);
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
			setState(130);
			switch ( getInterpreter().adaptivePredict(_input,1,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(128); declaration();
				}
				break;

			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(129); water();
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
			setState(135);
			switch ( getInterpreter().adaptivePredict(_input,2,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(132); simple_decl();
				}
				break;

			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(133); function_def();
				}
				break;

			case 3:
				enterOuterAlt(_localctx, 3);
				{
				setState(134); using_directive();
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
			setState(138);
			_la = _input.LA(1);
			if (_la==61) {
				{
				setState(137); match(61);
				}
			}

			setState(141);
			_la = _input.LA(1);
			if (_la==26) {
				{
				setState(140); template_decl_start();
				}
			}

			setState(143); var_decl();
			setState(144); match(63);
			}
		}
		catch (RecognitionException re) {
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
			setState(153);
			switch ( getInterpreter().adaptivePredict(_input,6,_ctx) ) {
			case 1:
				_localctx = new DeclByTypeContext(_localctx);
				enterOuterAlt(_localctx, 1);
				{
				setState(146); type_name();
				setState(147); init_declarator_list();
				}
				break;

			case 2:
				_localctx = new DeclByClassContext(_localctx);
				enterOuterAlt(_localctx, 2);
				{
				setState(149); class_def();
				setState(151);
				_la = _input.LA(1);
				if (_la==1 || _la==3 || _la==ALPHA_NUMERIC) {
					{
					setState(150); init_declarator_list();
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
			setState(155); init_declarator();
			setState(160);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==41) {
				{
				{
				setState(156); match(41);
				setState(157); init_declarator();
				}
				}
				setState(162);
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
			setState(164);
			_la = _input.LA(1);
			if (_la==1 || _la==3) {
				{
				setState(163); ptrs();
				}
			}

			setState(166); identifier();
			setState(168);
			_la = _input.LA(1);
			if (_la==4) {
				{
				setState(167); type_suffix();
				}
			}

			}
			setState(177);
			switch (_input.LA(1)) {
			case 44:
				{
				{
				setState(170); match(44);
				setState(172);
				switch ( getInterpreter().adaptivePredict(_input,10,_ctx) ) {
				case 1:
					{
					setState(171); expr();
					}
					break;
				}
				setState(174); match(18);
				}
				}
				break;
			case 27:
				{
				{
				setState(175); match(27);
				setState(176); assign_expr();
				}
				}
				break;
			case 41:
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
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(179); class_key();
			setState(180); class_name();
			setState(181); base_classes();
			setState(182); match(48);
			setState(183); class_content();
			setState(184); match(11);
			}
		}
		catch (RecognitionException re) {
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
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(187);
			_la = _input.LA(1);
			if (_la==ALPHA_NUMERIC) {
				{
				setState(186); identifier();
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
			setState(189); match(43);
			setState(190); base_class();
			setState(195);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==41) {
				{
				{
				setState(191); match(41);
				setState(192); base_class();
				}
				}
				setState(197);
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
			setState(199);
			_la = _input.LA(1);
			if (_la==19) {
				{
				setState(198); match(19);
				}
			}

			setState(202);
			_la = _input.LA(1);
			if ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << 40) | (1L << 46) | (1L << 59))) != 0)) {
				{
				setState(201); access_specifier();
				}
			}

			setState(204); identifier();
			}
		}
		catch (RecognitionException re) {
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
		public Class_content_elemContext class_content_elem(int i) {
			return getRuleContext(Class_content_elemContext.class,i);
		}
		public List<Class_content_elemContext> class_content_elem() {
			return getRuleContexts(Class_content_elemContext.class);
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
			setState(209);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << 1) | (1L << 2) | (1L << 3) | (1L << 4) | (1L << 5) | (1L << 6) | (1L << 7) | (1L << 8) | (1L << 9) | (1L << 10) | (1L << 12) | (1L << 13) | (1L << 14) | (1L << 15) | (1L << 16) | (1L << 17) | (1L << 18) | (1L << 19) | (1L << 20) | (1L << 21) | (1L << 22) | (1L << 23) | (1L << 24) | (1L << 25) | (1L << 26) | (1L << 27) | (1L << 28) | (1L << 29) | (1L << 30) | (1L << 31) | (1L << 32) | (1L << 33) | (1L << 34) | (1L << 35) | (1L << 36) | (1L << 37) | (1L << 38) | (1L << 39) | (1L << 40) | (1L << 41) | (1L << 42) | (1L << 43) | (1L << 44) | (1L << 45) | (1L << 46) | (1L << 47) | (1L << 19) | (1L << 20) | (1L << 21) | (1L << 22) | (1L << 23) | (1L << 26) | (1L << 28) | (1L << 31) | (1L << 34) | (1L << 40) | (1L << 44) | (1L << 46) | (1L << 48) | (1L << 49) | (1L << 50) | (1L << 51) | (1L << 52) | (1L << 53) | (1L << 54) | (1L << 55) | (1L << 56) | (1L << 57) | (1L << 58) | (1L << 59) | (1L << 60) | (1L << 61) | (1L << 62) | (1L << 63))) != 0) || ((((_la - 64)) & ~0x3f) == 0 && ((1L << (_la - 64)) & ((1L << (64 - 64)) | (1L << (65 - 64)) | (1L << (66 - 64)) | (1L << (67 - 64)) | (1L << (68 - 64)) | (1L << (69 - 64)) | (1L << (70 - 64)) | (1L << (71 - 64)) | (1L << (72 - 64)) | (1L << (ALPHA_NUMERIC - 64)) | (1L << (CPPCOMMENT - 64)) | (1L << (COMMENT - 64)) | (1L << (STRING - 64)) | (1L << (PREPROC - 64)) | (1L << (HEX_LITERAL - 64)) | (1L << (DECIMAL_LITERAL - 64)) | (1L << (OCTAL_LITERAL - 64)) | (1L << (FLOATING_POINT_LITERAL - 64)) | (1L << (WHITESPACE - 64)) | (1L << (OTHER - 64)) | (1L << (59 - 64)) | (1L << (60 - 64)) | (1L << (61 - 64)) | (1L << (62 - 64)) | (1L << (ALPHA_NUMERIC - 64)) | (1L << (HEX_LITERAL - 64)) | (1L << (DECIMAL_LITERAL - 64)) | (1L << (OCTAL_LITERAL - 64)))) != 0)) {
				{
				{
				setState(206); class_content_elem();
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

	public static class Class_content_elemContext extends ParserRuleContext {
		public Class_contentContext class_content() {
			return getRuleContext(Class_contentContext.class,0);
		}
		public Function_defContext function_def() {
			return getRuleContext(Function_defContext.class,0);
		}
		public No_curliesContext no_curlies() {
			return getRuleContext(No_curliesContext.class,0);
		}
		public LabelContext label() {
			return getRuleContext(LabelContext.class,0);
		}
		public Simple_declContext simple_decl() {
			return getRuleContext(Simple_declContext.class,0);
		}
		public Class_content_elemContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_class_content_elem; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof CodeSensorListener ) ((CodeSensorListener)listener).enterClass_content_elem(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof CodeSensorListener ) ((CodeSensorListener)listener).exitClass_content_elem(this);
		}
	}

	public final Class_content_elemContext class_content_elem() throws RecognitionException {
		Class_content_elemContext _localctx = new Class_content_elemContext(_ctx, getState());
		enterRule(_localctx, 24, RULE_class_content_elem);
		try {
			setState(220);
			switch ( getInterpreter().adaptivePredict(_input,17,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(212); simple_decl();
				}
				break;

			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(213); function_def();
				}
				break;

			case 3:
				enterOuterAlt(_localctx, 3);
				{
				setState(214); label();
				}
				break;

			case 4:
				enterOuterAlt(_localctx, 4);
				{
				setState(215); match(48);
				setState(216); class_content();
				setState(217); match(11);
				}
				break;

			case 5:
				enterOuterAlt(_localctx, 5);
				{
				setState(219); no_curlies();
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
		enterRule(_localctx, 26, RULE_label);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(230);
			switch (_input.LA(1)) {
			case 12:
			case ALPHA_NUMERIC:
			case HEX_LITERAL:
			case DECIMAL_LITERAL:
			case OCTAL_LITERAL:
				{
				{
				setState(223);
				_la = _input.LA(1);
				if (_la==12) {
					{
					setState(222); match(12);
					}
				}

				setState(227);
				switch (_input.LA(1)) {
				case ALPHA_NUMERIC:
					{
					setState(225); identifier();
					}
					break;
				case HEX_LITERAL:
				case DECIMAL_LITERAL:
				case OCTAL_LITERAL:
					{
					setState(226); number();
					}
					break;
				default:
					throw new NoViableAltException(this);
				}
				}
				}
				break;
			case 40:
			case 46:
			case 59:
				{
				setState(229); access_specifier();
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
			setState(232); match(43);
			}
		}
		catch (RecognitionException re) {
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
		enterRule(_localctx, 28, RULE_function_def);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(235);
			_la = _input.LA(1);
			if (_la==26) {
				{
				setState(234); template_decl_start();
				}
			}

			setState(238);
			switch ( getInterpreter().adaptivePredict(_input,22,_ctx) ) {
			case 1:
				{
				setState(237); return_type();
				}
				break;
			}
			setState(240); function_name();
			setState(241); function_param_list();
			setState(243);
			_la = _input.LA(1);
			if (_la==43) {
				{
				setState(242); ctor_list();
				}
			}

			setState(245); compound_statement();
			}
		}
		catch (RecognitionException re) {
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
		enterRule(_localctx, 30, RULE_return_type);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			{
			setState(250);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << 19) | (1L << 21) | (1L << 22) | (1L << 51) | (1L << 53))) != 0)) {
				{
				{
				setState(247); function_decl_specifiers();
				}
				}
				setState(252);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(253); type_name();
			}
			setState(258);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << 19) | (1L << 21) | (1L << 22) | (1L << 51) | (1L << 53))) != 0)) {
				{
				{
				setState(255); function_decl_specifiers();
				}
				}
				setState(260);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(264);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==1 || _la==3) {
				{
				{
				setState(261); ptr_operator();
				}
				}
				setState(266);
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
		enterRule(_localctx, 32, RULE_type_name);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(270);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==28 || _la==62) {
				{
				{
				setState(267); cv_qualifier();
				}
				}
				setState(272);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(274);
			_la = _input.LA(1);
			if ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << 16) | (1L << 31) | (1L << 34) | (1L << 52))) != 0)) {
				{
				setState(273); class_key();
				}
			}

			setState(277);
			_la = _input.LA(1);
			if (_la==20 || _la==23) {
				{
				setState(276);
				_la = _input.LA(1);
				if ( !(_la==20 || _la==23) ) {
				_errHandler.recoverInline(this);
				}
				consume();
				}
			}

			setState(279); match(ALPHA_NUMERIC);
			setState(284);
			_la = _input.LA(1);
			if (_la==5) {
				{
				setState(280); match(5);
				setState(281); template_param_list();
				setState(282); match(66);
				}
			}

			setState(296);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==24) {
				{
				{
				setState(286); match(24);
				setState(287); match(ALPHA_NUMERIC);
				setState(292);
				_la = _input.LA(1);
				if (_la==5) {
					{
					setState(288); match(5);
					setState(289); template_param_list();
					setState(290); match(66);
					}
				}

				}
				}
				setState(298);
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
		enterRule(_localctx, 34, RULE_template_decl_start);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(299); match(26);
			setState(300); match(5);
			setState(301); template_param_list();
			setState(302); match(66);
			}
		}
		catch (RecognitionException re) {
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
		enterRule(_localctx, 36, RULE_assign_expr);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(305); 
			_errHandler.sync(this);
			_la = _input.LA(1);
			do {
				{
				{
				setState(304); no_comma_or_semicolon();
				}
				}
				setState(307); 
				_errHandler.sync(this);
				_la = _input.LA(1);
			} while ( (((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << 1) | (1L << 2) | (1L << 3) | (1L << 4) | (1L << 5) | (1L << 6) | (1L << 7) | (1L << 8) | (1L << 9) | (1L << 10) | (1L << 11) | (1L << 12) | (1L << 13) | (1L << 14) | (1L << 15) | (1L << 16) | (1L << 17) | (1L << 18) | (1L << 19) | (1L << 20) | (1L << 21) | (1L << 22) | (1L << 23) | (1L << 24) | (1L << 25) | (1L << 26) | (1L << 27) | (1L << 28) | (1L << 29) | (1L << 30) | (1L << 31) | (1L << 32) | (1L << 33) | (1L << 34) | (1L << 35) | (1L << 36) | (1L << 37) | (1L << 38) | (1L << 39) | (1L << 40) | (1L << 42) | (1L << 43) | (1L << 44) | (1L << 45) | (1L << 46) | (1L << 47) | (1L << 48) | (1L << 49) | (1L << 50) | (1L << 51) | (1L << 52) | (1L << 53) | (1L << 54) | (1L << 55) | (1L << 56) | (1L << 57) | (1L << 58) | (1L << 59) | (1L << 60) | (1L << 61) | (1L << 62))) != 0) || ((((_la - 64)) & ~0x3f) == 0 && ((1L << (_la - 64)) & ((1L << (64 - 64)) | (1L << (65 - 64)) | (1L << (66 - 64)) | (1L << (67 - 64)) | (1L << (68 - 64)) | (1L << (69 - 64)) | (1L << (70 - 64)) | (1L << (71 - 64)) | (1L << (72 - 64)) | (1L << (ALPHA_NUMERIC - 64)) | (1L << (CPPCOMMENT - 64)) | (1L << (COMMENT - 64)) | (1L << (STRING - 64)) | (1L << (PREPROC - 64)) | (1L << (HEX_LITERAL - 64)) | (1L << (DECIMAL_LITERAL - 64)) | (1L << (OCTAL_LITERAL - 64)) | (1L << (FLOATING_POINT_LITERAL - 64)) | (1L << (WHITESPACE - 64)) | (1L << (OTHER - 64)))) != 0) );
			}
		}
		catch (RecognitionException re) {
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
		enterRule(_localctx, 38, RULE_template_param_list);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(312);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << 1) | (1L << 2) | (1L << 3) | (1L << 4) | (1L << 5) | (1L << 6) | (1L << 7) | (1L << 8) | (1L << 9) | (1L << 10) | (1L << 11) | (1L << 12) | (1L << 13) | (1L << 14) | (1L << 15) | (1L << 16) | (1L << 17) | (1L << 19) | (1L << 20) | (1L << 21) | (1L << 22) | (1L << 23) | (1L << 24) | (1L << 25) | (1L << 26) | (1L << 27) | (1L << 28) | (1L << 29) | (1L << 30) | (1L << 31) | (1L << 32) | (1L << 33) | (1L << 34) | (1L << 35) | (1L << 36) | (1L << 37) | (1L << 38) | (1L << 39) | (1L << 40) | (1L << 41) | (1L << 42) | (1L << 43) | (1L << 44) | (1L << 45) | (1L << 46) | (1L << 47) | (1L << 48) | (1L << 49) | (1L << 50) | (1L << 51) | (1L << 52) | (1L << 53) | (1L << 54) | (1L << 55) | (1L << 56) | (1L << 57) | (1L << 58) | (1L << 59) | (1L << 60) | (1L << 61) | (1L << 62) | (1L << 63))) != 0) || ((((_la - 64)) & ~0x3f) == 0 && ((1L << (_la - 64)) & ((1L << (64 - 64)) | (1L << (65 - 64)) | (1L << (67 - 64)) | (1L << (68 - 64)) | (1L << (69 - 64)) | (1L << (70 - 64)) | (1L << (71 - 64)) | (1L << (72 - 64)) | (1L << (ALPHA_NUMERIC - 64)) | (1L << (CPPCOMMENT - 64)) | (1L << (COMMENT - 64)) | (1L << (STRING - 64)) | (1L << (PREPROC - 64)) | (1L << (HEX_LITERAL - 64)) | (1L << (DECIMAL_LITERAL - 64)) | (1L << (OCTAL_LITERAL - 64)) | (1L << (FLOATING_POINT_LITERAL - 64)) | (1L << (WHITESPACE - 64)) | (1L << (OTHER - 64)))) != 0)) {
				{
				{
				setState(309); template_param_list_elem();
				}
				}
				setState(314);
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
		enterRule(_localctx, 40, RULE_template_param_list_elem);
		try {
			setState(324);
			switch (_input.LA(1)) {
			case 5:
				enterOuterAlt(_localctx, 1);
				{
				{
				setState(315); match(5);
				setState(316); template_param_list();
				setState(317); match(66);
				}
				}
				break;
			case 44:
				enterOuterAlt(_localctx, 2);
				{
				{
				setState(319); match(44);
				setState(320); template_param_list();
				setState(321); match(18);
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
			case 17:
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
			case 43:
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
				setState(323); no_angle_brackets_or_brackets();
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
		public Token o;
		public Token c;
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
		enterRule(_localctx, 42, RULE_function_param_list);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(326); ((Function_param_listContext)_localctx).o = match(44);
			setState(328);
			_la = _input.LA(1);
			if ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << 2) | (1L << 15) | (1L << 16) | (1L << 20) | (1L << 23) | (1L << 28) | (1L << 31) | (1L << 34) | (1L << 52) | (1L << 62))) != 0) || _la==ALPHA_NUMERIC) {
				{
				setState(327); parameter_decl_clause();
				}
			}

			setState(330); ((Function_param_listContext)_localctx).c = match(18);
			setState(334);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==28 || _la==62) {
				{
				{
				setState(331); cv_qualifier();
				}
				}
				setState(336);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(338);
			_la = _input.LA(1);
			if (_la==25) {
				{
				setState(337); exception_specification();
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
		enterRule(_localctx, 44, RULE_parameter_decl_clause);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(340); parameter_decl();
			setState(345);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==41) {
				{
				{
				setState(341); match(41);
				setState(342); parameter_decl();
				}
				}
				setState(347);
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

	public static class Parameter_declContext extends ParserRuleContext {
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
		enterRule(_localctx, 46, RULE_parameter_decl);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(348); param_decl_specifiers();
			setState(350);
			_la = _input.LA(1);
			if (_la==1 || _la==3) {
				{
				setState(349); ptrs();
				}
			}

			setState(352); parameter_name();
			setState(354);
			_la = _input.LA(1);
			if (_la==4) {
				{
				setState(353); type_suffix();
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
			setState(357); 
			_errHandler.sync(this);
			_la = _input.LA(1);
			do {
				{
				{
				setState(356); ptr_operator();
				}
				}
				setState(359); 
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
			setState(362);
			_la = _input.LA(1);
			if (_la==2 || _la==15) {
				{
				setState(361);
				_la = _input.LA(1);
				if ( !(_la==2 || _la==15) ) {
				_errHandler.recoverInline(this);
				}
				consume();
				}
			}

			setState(364); type_name();
			}
		}
		catch (RecognitionException re) {
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
			enterOuterAlt(_localctx, 1);
			{
			{
			setState(366); match(4);
			setState(367); constant_expr();
			setState(368); match(35);
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
		enterRule(_localctx, 54, RULE_constant_expr);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(373);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << 1) | (1L << 2) | (1L << 3) | (1L << 5) | (1L << 6) | (1L << 7) | (1L << 8) | (1L << 9) | (1L << 10) | (1L << 11) | (1L << 12) | (1L << 13) | (1L << 14) | (1L << 15) | (1L << 16) | (1L << 17) | (1L << 18) | (1L << 19) | (1L << 20) | (1L << 21) | (1L << 22) | (1L << 23) | (1L << 24) | (1L << 25) | (1L << 26) | (1L << 27) | (1L << 28) | (1L << 29) | (1L << 30) | (1L << 31) | (1L << 32) | (1L << 33) | (1L << 34) | (1L << 36) | (1L << 37) | (1L << 38) | (1L << 39) | (1L << 40) | (1L << 41) | (1L << 42) | (1L << 43) | (1L << 44) | (1L << 45) | (1L << 46) | (1L << 47) | (1L << 48) | (1L << 49) | (1L << 50) | (1L << 51) | (1L << 52) | (1L << 53) | (1L << 54) | (1L << 55) | (1L << 56) | (1L << 57) | (1L << 58) | (1L << 59) | (1L << 60) | (1L << 61) | (1L << 62) | (1L << 63))) != 0) || ((((_la - 64)) & ~0x3f) == 0 && ((1L << (_la - 64)) & ((1L << (64 - 64)) | (1L << (65 - 64)) | (1L << (66 - 64)) | (1L << (67 - 64)) | (1L << (68 - 64)) | (1L << (69 - 64)) | (1L << (70 - 64)) | (1L << (71 - 64)) | (1L << (72 - 64)) | (1L << (ALPHA_NUMERIC - 64)) | (1L << (CPPCOMMENT - 64)) | (1L << (COMMENT - 64)) | (1L << (STRING - 64)) | (1L << (PREPROC - 64)) | (1L << (HEX_LITERAL - 64)) | (1L << (DECIMAL_LITERAL - 64)) | (1L << (OCTAL_LITERAL - 64)) | (1L << (FLOATING_POINT_LITERAL - 64)) | (1L << (WHITESPACE - 64)) | (1L << (OTHER - 64)))) != 0)) {
				{
				{
				setState(370); no_squares();
				}
				}
				setState(375);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(387);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==4) {
				{
				{
				setState(376); match(4);
				setState(377); constant_expr();
				setState(378); match(35);
				setState(382);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << 1) | (1L << 2) | (1L << 3) | (1L << 5) | (1L << 6) | (1L << 7) | (1L << 8) | (1L << 9) | (1L << 10) | (1L << 11) | (1L << 12) | (1L << 13) | (1L << 14) | (1L << 15) | (1L << 16) | (1L << 17) | (1L << 18) | (1L << 19) | (1L << 20) | (1L << 21) | (1L << 22) | (1L << 23) | (1L << 24) | (1L << 25) | (1L << 26) | (1L << 27) | (1L << 28) | (1L << 29) | (1L << 30) | (1L << 31) | (1L << 32) | (1L << 33) | (1L << 34) | (1L << 36) | (1L << 37) | (1L << 38) | (1L << 39) | (1L << 40) | (1L << 41) | (1L << 42) | (1L << 43) | (1L << 44) | (1L << 45) | (1L << 46) | (1L << 47) | (1L << 48) | (1L << 49) | (1L << 50) | (1L << 51) | (1L << 52) | (1L << 53) | (1L << 54) | (1L << 55) | (1L << 56) | (1L << 57) | (1L << 58) | (1L << 59) | (1L << 60) | (1L << 61) | (1L << 62) | (1L << 63))) != 0) || ((((_la - 64)) & ~0x3f) == 0 && ((1L << (_la - 64)) & ((1L << (64 - 64)) | (1L << (65 - 64)) | (1L << (66 - 64)) | (1L << (67 - 64)) | (1L << (68 - 64)) | (1L << (69 - 64)) | (1L << (70 - 64)) | (1L << (71 - 64)) | (1L << (72 - 64)) | (1L << (ALPHA_NUMERIC - 64)) | (1L << (CPPCOMMENT - 64)) | (1L << (COMMENT - 64)) | (1L << (STRING - 64)) | (1L << (PREPROC - 64)) | (1L << (HEX_LITERAL - 64)) | (1L << (DECIMAL_LITERAL - 64)) | (1L << (OCTAL_LITERAL - 64)) | (1L << (FLOATING_POINT_LITERAL - 64)) | (1L << (WHITESPACE - 64)) | (1L << (OTHER - 64)))) != 0)) {
					{
					{
					setState(379); no_squares();
					}
					}
					setState(384);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				}
				}
				setState(389);
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
		enterRule(_localctx, 56, RULE_expr);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(393);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << 1) | (1L << 2) | (1L << 3) | (1L << 4) | (1L << 5) | (1L << 6) | (1L << 7) | (1L << 8) | (1L << 9) | (1L << 10) | (1L << 11) | (1L << 12) | (1L << 13) | (1L << 14) | (1L << 15) | (1L << 16) | (1L << 17) | (1L << 19) | (1L << 20) | (1L << 21) | (1L << 22) | (1L << 23) | (1L << 24) | (1L << 25) | (1L << 26) | (1L << 27) | (1L << 28) | (1L << 29) | (1L << 30) | (1L << 31) | (1L << 32) | (1L << 33) | (1L << 34) | (1L << 35) | (1L << 36) | (1L << 37) | (1L << 38) | (1L << 39) | (1L << 40) | (1L << 41) | (1L << 42) | (1L << 43) | (1L << 45) | (1L << 46) | (1L << 47) | (1L << 48) | (1L << 49) | (1L << 50) | (1L << 51) | (1L << 52) | (1L << 53) | (1L << 54) | (1L << 55) | (1L << 56) | (1L << 57) | (1L << 58) | (1L << 59) | (1L << 60) | (1L << 61) | (1L << 62) | (1L << 63))) != 0) || ((((_la - 64)) & ~0x3f) == 0 && ((1L << (_la - 64)) & ((1L << (64 - 64)) | (1L << (65 - 64)) | (1L << (66 - 64)) | (1L << (67 - 64)) | (1L << (68 - 64)) | (1L << (69 - 64)) | (1L << (70 - 64)) | (1L << (71 - 64)) | (1L << (72 - 64)) | (1L << (ALPHA_NUMERIC - 64)) | (1L << (CPPCOMMENT - 64)) | (1L << (COMMENT - 64)) | (1L << (STRING - 64)) | (1L << (PREPROC - 64)) | (1L << (HEX_LITERAL - 64)) | (1L << (DECIMAL_LITERAL - 64)) | (1L << (OCTAL_LITERAL - 64)) | (1L << (FLOATING_POINT_LITERAL - 64)) | (1L << (WHITESPACE - 64)) | (1L << (OTHER - 64)))) != 0)) {
				{
				{
				setState(390); no_brackets();
				}
				}
				setState(395);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(407);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==44) {
				{
				{
				setState(396); match(44);
				setState(397); expr();
				setState(398); match(18);
				setState(402);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << 1) | (1L << 2) | (1L << 3) | (1L << 4) | (1L << 5) | (1L << 6) | (1L << 7) | (1L << 8) | (1L << 9) | (1L << 10) | (1L << 11) | (1L << 12) | (1L << 13) | (1L << 14) | (1L << 15) | (1L << 16) | (1L << 17) | (1L << 19) | (1L << 20) | (1L << 21) | (1L << 22) | (1L << 23) | (1L << 24) | (1L << 25) | (1L << 26) | (1L << 27) | (1L << 28) | (1L << 29) | (1L << 30) | (1L << 31) | (1L << 32) | (1L << 33) | (1L << 34) | (1L << 35) | (1L << 36) | (1L << 37) | (1L << 38) | (1L << 39) | (1L << 40) | (1L << 41) | (1L << 42) | (1L << 43) | (1L << 45) | (1L << 46) | (1L << 47) | (1L << 48) | (1L << 49) | (1L << 50) | (1L << 51) | (1L << 52) | (1L << 53) | (1L << 54) | (1L << 55) | (1L << 56) | (1L << 57) | (1L << 58) | (1L << 59) | (1L << 60) | (1L << 61) | (1L << 62) | (1L << 63))) != 0) || ((((_la - 64)) & ~0x3f) == 0 && ((1L << (_la - 64)) & ((1L << (64 - 64)) | (1L << (65 - 64)) | (1L << (66 - 64)) | (1L << (67 - 64)) | (1L << (68 - 64)) | (1L << (69 - 64)) | (1L << (70 - 64)) | (1L << (71 - 64)) | (1L << (72 - 64)) | (1L << (ALPHA_NUMERIC - 64)) | (1L << (CPPCOMMENT - 64)) | (1L << (COMMENT - 64)) | (1L << (STRING - 64)) | (1L << (PREPROC - 64)) | (1L << (HEX_LITERAL - 64)) | (1L << (DECIMAL_LITERAL - 64)) | (1L << (OCTAL_LITERAL - 64)) | (1L << (FLOATING_POINT_LITERAL - 64)) | (1L << (WHITESPACE - 64)) | (1L << (OTHER - 64)))) != 0)) {
					{
					{
					setState(399); no_brackets();
					}
					}
					setState(404);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				}
				}
				setState(409);
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
		enterRule(_localctx, 58, RULE_compound_statement);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(410); match(48);
			setState(414);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << 1) | (1L << 2) | (1L << 3) | (1L << 4) | (1L << 5) | (1L << 6) | (1L << 7) | (1L << 8) | (1L << 9) | (1L << 10) | (1L << 12) | (1L << 13) | (1L << 14) | (1L << 15) | (1L << 16) | (1L << 17) | (1L << 18) | (1L << 19) | (1L << 20) | (1L << 21) | (1L << 22) | (1L << 23) | (1L << 24) | (1L << 25) | (1L << 26) | (1L << 27) | (1L << 28) | (1L << 29) | (1L << 30) | (1L << 31) | (1L << 32) | (1L << 33) | (1L << 34) | (1L << 35) | (1L << 36) | (1L << 37) | (1L << 38) | (1L << 39) | (1L << 40) | (1L << 41) | (1L << 42) | (1L << 43) | (1L << 44) | (1L << 45) | (1L << 46) | (1L << 47) | (1L << 49) | (1L << 50) | (1L << 51) | (1L << 52) | (1L << 53) | (1L << 54) | (1L << 55) | (1L << 56) | (1L << 57) | (1L << 58) | (1L << 59) | (1L << 60) | (1L << 61) | (1L << 62) | (1L << 63))) != 0) || ((((_la - 64)) & ~0x3f) == 0 && ((1L << (_la - 64)) & ((1L << (64 - 64)) | (1L << (65 - 64)) | (1L << (66 - 64)) | (1L << (67 - 64)) | (1L << (68 - 64)) | (1L << (69 - 64)) | (1L << (70 - 64)) | (1L << (71 - 64)) | (1L << (72 - 64)) | (1L << (ALPHA_NUMERIC - 64)) | (1L << (CPPCOMMENT - 64)) | (1L << (COMMENT - 64)) | (1L << (STRING - 64)) | (1L << (PREPROC - 64)) | (1L << (HEX_LITERAL - 64)) | (1L << (DECIMAL_LITERAL - 64)) | (1L << (OCTAL_LITERAL - 64)) | (1L << (FLOATING_POINT_LITERAL - 64)) | (1L << (WHITESPACE - 64)) | (1L << (OTHER - 64)))) != 0)) {
				{
				{
				setState(411); no_curlies();
				}
				}
				setState(416);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(426);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==48) {
				{
				{
				setState(417); compound_statement();
				setState(421);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << 1) | (1L << 2) | (1L << 3) | (1L << 4) | (1L << 5) | (1L << 6) | (1L << 7) | (1L << 8) | (1L << 9) | (1L << 10) | (1L << 12) | (1L << 13) | (1L << 14) | (1L << 15) | (1L << 16) | (1L << 17) | (1L << 18) | (1L << 19) | (1L << 20) | (1L << 21) | (1L << 22) | (1L << 23) | (1L << 24) | (1L << 25) | (1L << 26) | (1L << 27) | (1L << 28) | (1L << 29) | (1L << 30) | (1L << 31) | (1L << 32) | (1L << 33) | (1L << 34) | (1L << 35) | (1L << 36) | (1L << 37) | (1L << 38) | (1L << 39) | (1L << 40) | (1L << 41) | (1L << 42) | (1L << 43) | (1L << 44) | (1L << 45) | (1L << 46) | (1L << 47) | (1L << 49) | (1L << 50) | (1L << 51) | (1L << 52) | (1L << 53) | (1L << 54) | (1L << 55) | (1L << 56) | (1L << 57) | (1L << 58) | (1L << 59) | (1L << 60) | (1L << 61) | (1L << 62) | (1L << 63))) != 0) || ((((_la - 64)) & ~0x3f) == 0 && ((1L << (_la - 64)) & ((1L << (64 - 64)) | (1L << (65 - 64)) | (1L << (66 - 64)) | (1L << (67 - 64)) | (1L << (68 - 64)) | (1L << (69 - 64)) | (1L << (70 - 64)) | (1L << (71 - 64)) | (1L << (72 - 64)) | (1L << (ALPHA_NUMERIC - 64)) | (1L << (CPPCOMMENT - 64)) | (1L << (COMMENT - 64)) | (1L << (STRING - 64)) | (1L << (PREPROC - 64)) | (1L << (HEX_LITERAL - 64)) | (1L << (DECIMAL_LITERAL - 64)) | (1L << (OCTAL_LITERAL - 64)) | (1L << (FLOATING_POINT_LITERAL - 64)) | (1L << (WHITESPACE - 64)) | (1L << (OTHER - 64)))) != 0)) {
					{
					{
					setState(418); no_curlies();
					}
					}
					setState(423);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				}
				}
				setState(428);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(429); match(11);
			}
		}
		catch (RecognitionException re) {
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
		enterRule(_localctx, 60, RULE_parameter_name);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(431); ((Parameter_nameContext)_localctx).x = parameter_name_start();
			setState(433);
			switch ( getInterpreter().adaptivePredict(_input,53,_ctx) ) {
			case 1:
				{
				setState(432); ((Parameter_nameContext)_localctx).s = type_suffix();
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
		enterRule(_localctx, 62, RULE_parameter_name_start);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(440);
			switch (_input.LA(1)) {
			case 44:
				{
				setState(435); match(44);
				setState(436); parameter_name();
				setState(437); match(18);
				}
				break;
			case ALPHA_NUMERIC:
				{
				setState(439); identifier();
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
		enterRule(_localctx, 64, RULE_ctor_list);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(442); match(43);
			setState(443); ctor_initializer();
			setState(448);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==41) {
				{
				{
				setState(444); match(41);
				setState(445); ctor_initializer();
				}
				}
				setState(450);
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
		enterRule(_localctx, 66, RULE_ctor_initializer);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(451); initializer_id();
			setState(452); ctor_expr();
			}
		}
		catch (RecognitionException re) {
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
		enterRule(_localctx, 68, RULE_initializer_id);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(455);
			_la = _input.LA(1);
			if (_la==24) {
				{
				setState(454); match(24);
				}
			}

			setState(457); identifier();
			}
		}
		catch (RecognitionException re) {
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
		enterRule(_localctx, 70, RULE_ctor_expr);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(459); match(44);
			setState(461);
			switch ( getInterpreter().adaptivePredict(_input,57,_ctx) ) {
			case 1:
				{
				setState(460); expr();
				}
				break;
			}
			setState(463); match(18);
			}
		}
		catch (RecognitionException re) {
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
		enterRule(_localctx, 72, RULE_function_name);
		try {
			setState(471);
			switch (_input.LA(1)) {
			case 44:
				enterOuterAlt(_localctx, 1);
				{
				setState(465); match(44);
				setState(466); function_name();
				setState(467); match(18);
				}
				break;
			case ALPHA_NUMERIC:
				enterOuterAlt(_localctx, 2);
				{
				setState(469); identifier();
				}
				break;
			case 60:
				enterOuterAlt(_localctx, 3);
				{
				setState(470); operator_function_id();
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
		enterRule(_localctx, 74, RULE_exception_specification);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(473); match(25);
			setState(474); match(44);
			setState(475); type_id_list();
			setState(476); match(18);
			}
		}
		catch (RecognitionException re) {
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
		enterRule(_localctx, 76, RULE_type_id_list);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(481);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << 1) | (1L << 2) | (1L << 3) | (1L << 4) | (1L << 5) | (1L << 6) | (1L << 7) | (1L << 8) | (1L << 9) | (1L << 10) | (1L << 11) | (1L << 12) | (1L << 13) | (1L << 14) | (1L << 15) | (1L << 16) | (1L << 17) | (1L << 19) | (1L << 20) | (1L << 21) | (1L << 22) | (1L << 23) | (1L << 24) | (1L << 25) | (1L << 26) | (1L << 27) | (1L << 28) | (1L << 29) | (1L << 30) | (1L << 31) | (1L << 32) | (1L << 33) | (1L << 34) | (1L << 35) | (1L << 36) | (1L << 37) | (1L << 38) | (1L << 39) | (1L << 40) | (1L << 41) | (1L << 42) | (1L << 43) | (1L << 45) | (1L << 46) | (1L << 47) | (1L << 48) | (1L << 49) | (1L << 50) | (1L << 51) | (1L << 52) | (1L << 53) | (1L << 54) | (1L << 55) | (1L << 56) | (1L << 57) | (1L << 58) | (1L << 59) | (1L << 60) | (1L << 61) | (1L << 62) | (1L << 63))) != 0) || ((((_la - 64)) & ~0x3f) == 0 && ((1L << (_la - 64)) & ((1L << (64 - 64)) | (1L << (65 - 64)) | (1L << (66 - 64)) | (1L << (67 - 64)) | (1L << (68 - 64)) | (1L << (69 - 64)) | (1L << (70 - 64)) | (1L << (71 - 64)) | (1L << (72 - 64)) | (1L << (ALPHA_NUMERIC - 64)) | (1L << (CPPCOMMENT - 64)) | (1L << (COMMENT - 64)) | (1L << (STRING - 64)) | (1L << (PREPROC - 64)) | (1L << (HEX_LITERAL - 64)) | (1L << (DECIMAL_LITERAL - 64)) | (1L << (OCTAL_LITERAL - 64)) | (1L << (FLOATING_POINT_LITERAL - 64)) | (1L << (WHITESPACE - 64)) | (1L << (OTHER - 64)))) != 0)) {
				{
				{
				setState(478); no_brackets();
				}
				}
				setState(483);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(495);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==44) {
				{
				{
				setState(484); match(44);
				setState(485); type_id_list();
				setState(486); match(18);
				setState(490);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << 1) | (1L << 2) | (1L << 3) | (1L << 4) | (1L << 5) | (1L << 6) | (1L << 7) | (1L << 8) | (1L << 9) | (1L << 10) | (1L << 11) | (1L << 12) | (1L << 13) | (1L << 14) | (1L << 15) | (1L << 16) | (1L << 17) | (1L << 19) | (1L << 20) | (1L << 21) | (1L << 22) | (1L << 23) | (1L << 24) | (1L << 25) | (1L << 26) | (1L << 27) | (1L << 28) | (1L << 29) | (1L << 30) | (1L << 31) | (1L << 32) | (1L << 33) | (1L << 34) | (1L << 35) | (1L << 36) | (1L << 37) | (1L << 38) | (1L << 39) | (1L << 40) | (1L << 41) | (1L << 42) | (1L << 43) | (1L << 45) | (1L << 46) | (1L << 47) | (1L << 48) | (1L << 49) | (1L << 50) | (1L << 51) | (1L << 52) | (1L << 53) | (1L << 54) | (1L << 55) | (1L << 56) | (1L << 57) | (1L << 58) | (1L << 59) | (1L << 60) | (1L << 61) | (1L << 62) | (1L << 63))) != 0) || ((((_la - 64)) & ~0x3f) == 0 && ((1L << (_la - 64)) & ((1L << (64 - 64)) | (1L << (65 - 64)) | (1L << (66 - 64)) | (1L << (67 - 64)) | (1L << (68 - 64)) | (1L << (69 - 64)) | (1L << (70 - 64)) | (1L << (71 - 64)) | (1L << (72 - 64)) | (1L << (ALPHA_NUMERIC - 64)) | (1L << (CPPCOMMENT - 64)) | (1L << (COMMENT - 64)) | (1L << (STRING - 64)) | (1L << (PREPROC - 64)) | (1L << (HEX_LITERAL - 64)) | (1L << (DECIMAL_LITERAL - 64)) | (1L << (OCTAL_LITERAL - 64)) | (1L << (FLOATING_POINT_LITERAL - 64)) | (1L << (WHITESPACE - 64)) | (1L << (OTHER - 64)))) != 0)) {
					{
					{
					setState(487); no_brackets();
					}
					}
					setState(492);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				}
				}
				setState(497);
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
		enterRule(_localctx, 78, RULE_using_directive);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(498); match(36);
			setState(499); match(10);
			setState(500); identifier();
			setState(501); match(63);
			}
		}
		catch (RecognitionException re) {
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
		enterRule(_localctx, 80, RULE_unary_operator);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(503);
			_la = _input.LA(1);
			if ( !((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << 1) | (1L << 3) | (1L << 33) | (1L << 42) | (1L << 58))) != 0) || _la==71) ) {
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
		enterRule(_localctx, 82, RULE_constant);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(505);
			_la = _input.LA(1);
			if ( !(((((_la - 76)) & ~0x3f) == 0 && ((1L << (_la - 76)) & ((1L << (STRING - 76)) | (1L << (HEX_LITERAL - 76)) | (1L << (DECIMAL_LITERAL - 76)) | (1L << (OCTAL_LITERAL - 76)) | (1L << (FLOATING_POINT_LITERAL - 76)))) != 0)) ) {
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
		enterRule(_localctx, 84, RULE_no_brackets);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(507);
			_la = _input.LA(1);
			if ( _la <= 0 || (_la==18 || _la==44) ) {
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
		enterRule(_localctx, 86, RULE_no_brackets_curlies_or_squares);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(509);
			_la = _input.LA(1);
			if ( _la <= 0 || ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << 4) | (1L << 11) | (1L << 18) | (1L << 35) | (1L << 44) | (1L << 48))) != 0)) ) {
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
		enterRule(_localctx, 88, RULE_no_brackets_or_semicolon);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(511);
			_la = _input.LA(1);
			if ( _la <= 0 || ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << 18) | (1L << 44) | (1L << 63))) != 0)) ) {
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
		enterRule(_localctx, 90, RULE_no_angle_brackets_or_brackets);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(513);
			_la = _input.LA(1);
			if ( _la <= 0 || (((((_la - 5)) & ~0x3f) == 0 && ((1L << (_la - 5)) & ((1L << (5 - 5)) | (1L << (18 - 5)) | (1L << (44 - 5)) | (1L << (66 - 5)))) != 0)) ) {
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
		enterRule(_localctx, 92, RULE_no_curlies);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(515);
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
		enterRule(_localctx, 94, RULE_no_squares);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(517);
			_la = _input.LA(1);
			if ( _la <= 0 || (_la==4 || _la==35) ) {
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
		enterRule(_localctx, 96, RULE_no_squares_or_semicolon);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(519);
			_la = _input.LA(1);
			if ( _la <= 0 || ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << 4) | (1L << 35) | (1L << 63))) != 0)) ) {
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
		enterRule(_localctx, 98, RULE_no_comma_or_semicolon);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(521);
			_la = _input.LA(1);
			if ( _la <= 0 || (_la==41 || _la==63) ) {
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
		enterRule(_localctx, 100, RULE_cv_qualifier);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(523);
			_la = _input.LA(1);
			if ( !(_la==28 || _la==62) ) {
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
		enterRule(_localctx, 102, RULE_function_decl_specifiers);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(525);
			_la = _input.LA(1);
			if ( !((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << 19) | (1L << 21) | (1L << 22) | (1L << 51) | (1L << 53))) != 0)) ) {
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
		enterRule(_localctx, 104, RULE_class_key);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(527);
			_la = _input.LA(1);
			if ( !((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << 16) | (1L << 31) | (1L << 34) | (1L << 52))) != 0)) ) {
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
		enterRule(_localctx, 106, RULE_ptr_operator);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(529);
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
		enterRule(_localctx, 108, RULE_access_specifier);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(531);
			_la = _input.LA(1);
			if ( !((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << 40) | (1L << 46) | (1L << 59))) != 0)) ) {
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
		enterRule(_localctx, 110, RULE_operator_function_id);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(533); match(60);
			setState(534); operator();
			}
		}
		catch (RecognitionException re) {
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
		enterRule(_localctx, 112, RULE_operator);
		int _la;
		try {
			setState(581);
			switch (_input.LA(1)) {
			case 30:
			case 56:
				enterOuterAlt(_localctx, 1);
				{
				{
				setState(536);
				_la = _input.LA(1);
				if ( !(_la==30 || _la==56) ) {
				_errHandler.recoverInline(this);
				}
				consume();
				setState(539);
				_la = _input.LA(1);
				if (_la==4) {
					{
					setState(537); match(4);
					setState(538); match(35);
					}
				}

				}
				}
				break;
			case 58:
				enterOuterAlt(_localctx, 2);
				{
				setState(541); match(58);
				}
				break;
			case 42:
				enterOuterAlt(_localctx, 3);
				{
				setState(542); match(42);
				}
				break;
			case 3:
				enterOuterAlt(_localctx, 4);
				{
				setState(543); match(3);
				}
				break;
			case 69:
				enterOuterAlt(_localctx, 5);
				{
				setState(544); match(69);
				}
				break;
			case 13:
				enterOuterAlt(_localctx, 6);
				{
				setState(545); match(13);
				}
				break;
			case 57:
				enterOuterAlt(_localctx, 7);
				{
				setState(546); match(57);
				}
				break;
			case 1:
				enterOuterAlt(_localctx, 8);
				{
				setState(547); match(1);
				}
				break;
			case 32:
				enterOuterAlt(_localctx, 9);
				{
				setState(548); match(32);
				}
				break;
			case 71:
				enterOuterAlt(_localctx, 10);
				{
				setState(549); match(71);
				}
				break;
			case 33:
				enterOuterAlt(_localctx, 11);
				{
				setState(550); match(33);
				}
				break;
			case 27:
				enterOuterAlt(_localctx, 12);
				{
				setState(551); match(27);
				}
				break;
			case 5:
				enterOuterAlt(_localctx, 13);
				{
				setState(552); match(5);
				}
				break;
			case 66:
				enterOuterAlt(_localctx, 14);
				{
				setState(553); match(66);
				}
				break;
			case 49:
				enterOuterAlt(_localctx, 15);
				{
				setState(554); match(49);
				}
				break;
			case 38:
				enterOuterAlt(_localctx, 16);
				{
				setState(555); match(38);
				}
				break;
			case 17:
				enterOuterAlt(_localctx, 17);
				{
				setState(556); match(17);
				}
				break;
			case 68:
				enterOuterAlt(_localctx, 18);
				{
				setState(557); match(68);
				}
				break;
			case 67:
				enterOuterAlt(_localctx, 19);
				{
				setState(558); match(67);
				}
				break;
			case 50:
				enterOuterAlt(_localctx, 20);
				{
				setState(559); match(50);
				}
				break;
			case 45:
				enterOuterAlt(_localctx, 21);
				{
				setState(560); match(45);
				}
				break;
			case 29:
				enterOuterAlt(_localctx, 22);
				{
				setState(561); match(29);
				}
				break;
			case 55:
				enterOuterAlt(_localctx, 23);
				{
				setState(562); match(55);
				}
				break;
			case 9:
				enterOuterAlt(_localctx, 24);
				{
				setState(563); match(9);
				}
				break;
			case 47:
				enterOuterAlt(_localctx, 25);
				{
				setState(564); match(47);
				}
				break;
			case 37:
				enterOuterAlt(_localctx, 26);
				{
				setState(565); match(37);
				}
				break;
			case 70:
				enterOuterAlt(_localctx, 27);
				{
				setState(566); match(70);
				}
				break;
			case 7:
				enterOuterAlt(_localctx, 28);
				{
				setState(567); match(7);
				}
				break;
			case 8:
				enterOuterAlt(_localctx, 29);
				{
				setState(568); match(8);
				}
				break;
			case 72:
				enterOuterAlt(_localctx, 30);
				{
				setState(569); match(72);
				}
				break;
			case 64:
				enterOuterAlt(_localctx, 31);
				{
				setState(570); match(64);
				}
				break;
			case 65:
				enterOuterAlt(_localctx, 32);
				{
				setState(571); match(65);
				}
				break;
			case 54:
				enterOuterAlt(_localctx, 33);
				{
				setState(572); match(54);
				}
				break;
			case 6:
				enterOuterAlt(_localctx, 34);
				{
				setState(573); match(6);
				}
				break;
			case 41:
				enterOuterAlt(_localctx, 35);
				{
				setState(574); match(41);
				}
				break;
			case 39:
				enterOuterAlt(_localctx, 36);
				{
				setState(575); match(39);
				}
				break;
			case 14:
				enterOuterAlt(_localctx, 37);
				{
				setState(576); match(14);
				}
				break;
			case 44:
				enterOuterAlt(_localctx, 38);
				{
				setState(577); match(44);
				setState(578); match(18);
				}
				break;
			case 4:
				enterOuterAlt(_localctx, 39);
				{
				setState(579); match(4);
				setState(580); match(35);
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
		enterRule(_localctx, 114, RULE_assignment_operator);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(583);
			_la = _input.LA(1);
			if ( !(((((_la - 17)) & ~0x3f) == 0 && ((1L << (_la - 17)) & ((1L << (17 - 17)) | (1L << (27 - 17)) | (1L << (29 - 17)) | (1L << (37 - 17)) | (1L << (38 - 17)) | (1L << (45 - 17)) | (1L << (47 - 17)) | (1L << (49 - 17)) | (1L << (50 - 17)) | (1L << (67 - 17)) | (1L << (68 - 17)))) != 0)) ) {
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
		enterRule(_localctx, 116, RULE_identifier);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(585); match(ALPHA_NUMERIC);
			setState(590);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==24) {
				{
				{
				setState(586); match(24);
				setState(587); match(ALPHA_NUMERIC);
				}
				}
				setState(592);
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
		enterRule(_localctx, 118, RULE_number);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(593);
			_la = _input.LA(1);
			if ( !(((((_la - 78)) & ~0x3f) == 0 && ((1L << (_la - 78)) & ((1L << (HEX_LITERAL - 78)) | (1L << (DECIMAL_LITERAL - 78)) | (1L << (OCTAL_LITERAL - 78)))) != 0)) ) {
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
		enterRule(_localctx, 120, RULE_water);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(595);
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
		"\2\3U\u0258\4\2\t\2\4\3\t\3\4\4\t\4\4\5\t\5\4\6\t\6\4\7\t\7\4\b\t\b\4"+
		"\t\t\t\4\n\t\n\4\13\t\13\4\f\t\f\4\r\t\r\4\16\t\16\4\17\t\17\4\20\t\20"+
		"\4\21\t\21\4\22\t\22\4\23\t\23\4\24\t\24\4\25\t\25\4\26\t\26\4\27\t\27"+
		"\4\30\t\30\4\31\t\31\4\32\t\32\4\33\t\33\4\34\t\34\4\35\t\35\4\36\t\36"+
		"\4\37\t\37\4 \t \4!\t!\4\"\t\"\4#\t#\4$\t$\4%\t%\4&\t&\4\'\t\'\4(\t(\4"+
		")\t)\4*\t*\4+\t+\4,\t,\4-\t-\4.\t.\4/\t/\4\60\t\60\4\61\t\61\4\62\t\62"+
		"\4\63\t\63\4\64\t\64\4\65\t\65\4\66\t\66\4\67\t\67\48\t8\49\t9\4:\t:\4"+
		";\t;\4<\t<\4=\t=\4>\t>\3\2\7\2~\n\2\f\2\16\2\u0081\13\2\3\3\3\3\5\3\u0085"+
		"\n\3\3\4\3\4\3\4\5\4\u008a\n\4\3\5\5\5\u008d\n\5\3\5\5\5\u0090\n\5\3\5"+
		"\3\5\3\5\3\6\3\6\3\6\3\6\3\6\5\6\u009a\n\6\5\6\u009c\n\6\3\7\3\7\3\7\7"+
		"\7\u00a1\n\7\f\7\16\7\u00a4\13\7\3\b\5\b\u00a7\n\b\3\b\3\b\5\b\u00ab\n"+
		"\b\3\b\3\b\5\b\u00af\n\b\3\b\3\b\3\b\5\b\u00b4\n\b\3\t\3\t\3\t\3\t\3\t"+
		"\3\t\3\t\3\n\5\n\u00be\n\n\3\13\3\13\3\13\3\13\7\13\u00c4\n\13\f\13\16"+
		"\13\u00c7\13\13\3\f\5\f\u00ca\n\f\3\f\5\f\u00cd\n\f\3\f\3\f\3\r\7\r\u00d2"+
		"\n\r\f\r\16\r\u00d5\13\r\3\16\3\16\3\16\3\16\3\16\3\16\3\16\3\16\5\16"+
		"\u00df\n\16\3\17\5\17\u00e2\n\17\3\17\3\17\5\17\u00e6\n\17\3\17\5\17\u00e9"+
		"\n\17\3\17\3\17\3\20\5\20\u00ee\n\20\3\20\5\20\u00f1\n\20\3\20\3\20\3"+
		"\20\5\20\u00f6\n\20\3\20\3\20\3\21\7\21\u00fb\n\21\f\21\16\21\u00fe\13"+
		"\21\3\21\3\21\3\21\7\21\u0103\n\21\f\21\16\21\u0106\13\21\3\21\7\21\u0109"+
		"\n\21\f\21\16\21\u010c\13\21\3\22\7\22\u010f\n\22\f\22\16\22\u0112\13"+
		"\22\3\22\5\22\u0115\n\22\3\22\5\22\u0118\n\22\3\22\3\22\3\22\3\22\3\22"+
		"\5\22\u011f\n\22\3\22\3\22\3\22\3\22\3\22\3\22\5\22\u0127\n\22\7\22\u0129"+
		"\n\22\f\22\16\22\u012c\13\22\3\23\3\23\3\23\3\23\3\23\3\24\6\24\u0134"+
		"\n\24\r\24\16\24\u0135\3\25\7\25\u0139\n\25\f\25\16\25\u013c\13\25\3\26"+
		"\3\26\3\26\3\26\3\26\3\26\3\26\3\26\3\26\5\26\u0147\n\26\3\27\3\27\5\27"+
		"\u014b\n\27\3\27\3\27\7\27\u014f\n\27\f\27\16\27\u0152\13\27\3\27\5\27"+
		"\u0155\n\27\3\30\3\30\3\30\7\30\u015a\n\30\f\30\16\30\u015d\13\30\3\31"+
		"\3\31\5\31\u0161\n\31\3\31\3\31\5\31\u0165\n\31\3\32\6\32\u0168\n\32\r"+
		"\32\16\32\u0169\3\33\5\33\u016d\n\33\3\33\3\33\3\34\3\34\3\34\3\34\3\35"+
		"\7\35\u0176\n\35\f\35\16\35\u0179\13\35\3\35\3\35\3\35\3\35\7\35\u017f"+
		"\n\35\f\35\16\35\u0182\13\35\7\35\u0184\n\35\f\35\16\35\u0187\13\35\3"+
		"\36\7\36\u018a\n\36\f\36\16\36\u018d\13\36\3\36\3\36\3\36\3\36\7\36\u0193"+
		"\n\36\f\36\16\36\u0196\13\36\7\36\u0198\n\36\f\36\16\36\u019b\13\36\3"+
		"\37\3\37\7\37\u019f\n\37\f\37\16\37\u01a2\13\37\3\37\3\37\7\37\u01a6\n"+
		"\37\f\37\16\37\u01a9\13\37\7\37\u01ab\n\37\f\37\16\37\u01ae\13\37\3\37"+
		"\3\37\3 \3 \5 \u01b4\n \3!\3!\3!\3!\3!\5!\u01bb\n!\3\"\3\"\3\"\3\"\7\""+
		"\u01c1\n\"\f\"\16\"\u01c4\13\"\3#\3#\3#\3$\5$\u01ca\n$\3$\3$\3%\3%\5%"+
		"\u01d0\n%\3%\3%\3&\3&\3&\3&\3&\3&\5&\u01da\n&\3\'\3\'\3\'\3\'\3\'\3(\7"+
		"(\u01e2\n(\f(\16(\u01e5\13(\3(\3(\3(\3(\7(\u01eb\n(\f(\16(\u01ee\13(\7"+
		"(\u01f0\n(\f(\16(\u01f3\13(\3)\3)\3)\3)\3)\3*\3*\3+\3+\3,\3,\3-\3-\3."+
		"\3.\3/\3/\3\60\3\60\3\61\3\61\3\62\3\62\3\63\3\63\3\64\3\64\3\65\3\65"+
		"\3\66\3\66\3\67\3\67\38\38\39\39\39\3:\3:\3:\5:\u021e\n:\3:\3:\3:\3:\3"+
		":\3:\3:\3:\3:\3:\3:\3:\3:\3:\3:\3:\3:\3:\3:\3:\3:\3:\3:\3:\3:\3:\3:\3"+
		":\3:\3:\3:\3:\3:\3:\3:\3:\3:\3:\3:\3:\5:\u0248\n:\3;\3;\3<\3<\3<\7<\u024f"+
		"\n<\f<\16<\u0252\13<\3=\3=\3>\3>\3>\2?\2\4\6\b\n\f\16\20\22\24\26\30\32"+
		"\34\36 \"$&(*,.\60\62\64\668:<>@BDFHJLNPRTVXZ\\^`bdfhjlnprtvxz\2\27\4"+
		"\26\26\31\31\4\4\4\21\21\b\3\3\5\5##,,<<II\4NNPS\4\24\24..\b\6\6\r\r\24"+
		"\24%%..\62\62\5\24\24..AA\6\7\7\24\24..DD\4\r\r\62\62\4\6\6%%\5\6\6%%"+
		"AA\4++AA\4\36\36@@\6\25\25\27\30\65\65\67\67\6\22\22!!$$\66\66\4\3\3\5"+
		"\5\5**\60\60==\4  ::\n\23\23\35\35\37\37\'(//\61\61\63\64EF\3PR\3UU\u0287"+
		"\2\177\3\2\2\2\4\u0084\3\2\2\2\6\u0089\3\2\2\2\b\u008c\3\2\2\2\n\u009b"+
		"\3\2\2\2\f\u009d\3\2\2\2\16\u00a6\3\2\2\2\20\u00b5\3\2\2\2\22\u00bd\3"+
		"\2\2\2\24\u00bf\3\2\2\2\26\u00c9\3\2\2\2\30\u00d3\3\2\2\2\32\u00de\3\2"+
		"\2\2\34\u00e8\3\2\2\2\36\u00ed\3\2\2\2 \u00fc\3\2\2\2\"\u0110\3\2\2\2"+
		"$\u012d\3\2\2\2&\u0133\3\2\2\2(\u013a\3\2\2\2*\u0146\3\2\2\2,\u0148\3"+
		"\2\2\2.\u0156\3\2\2\2\60\u015e\3\2\2\2\62\u0167\3\2\2\2\64\u016c\3\2\2"+
		"\2\66\u0170\3\2\2\28\u0177\3\2\2\2:\u018b\3\2\2\2<\u019c\3\2\2\2>\u01b1"+
		"\3\2\2\2@\u01ba\3\2\2\2B\u01bc\3\2\2\2D\u01c5\3\2\2\2F\u01c9\3\2\2\2H"+
		"\u01cd\3\2\2\2J\u01d9\3\2\2\2L\u01db\3\2\2\2N\u01e3\3\2\2\2P\u01f4\3\2"+
		"\2\2R\u01f9\3\2\2\2T\u01fb\3\2\2\2V\u01fd\3\2\2\2X\u01ff\3\2\2\2Z\u0201"+
		"\3\2\2\2\\\u0203\3\2\2\2^\u0205\3\2\2\2`\u0207\3\2\2\2b\u0209\3\2\2\2"+
		"d\u020b\3\2\2\2f\u020d\3\2\2\2h\u020f\3\2\2\2j\u0211\3\2\2\2l\u0213\3"+
		"\2\2\2n\u0215\3\2\2\2p\u0217\3\2\2\2r\u0247\3\2\2\2t\u0249\3\2\2\2v\u024b"+
		"\3\2\2\2x\u0253\3\2\2\2z\u0255\3\2\2\2|~\5\4\3\2}|\3\2\2\2~\u0081\3\2"+
		"\2\2\177}\3\2\2\2\177\u0080\3\2\2\2\u0080\3\3\2\2\2\u0081\177\3\2\2\2"+
		"\u0082\u0085\5\6\4\2\u0083\u0085\5z>\2\u0084\u0082\3\2\2\2\u0084\u0083"+
		"\3\2\2\2\u0085\5\3\2\2\2\u0086\u008a\5\b\5\2\u0087\u008a\5\36\20\2\u0088"+
		"\u008a\5P)\2\u0089\u0086\3\2\2\2\u0089\u0087\3\2\2\2\u0089\u0088\3\2\2"+
		"\2\u008a\7\3\2\2\2\u008b\u008d\7?\2\2\u008c\u008b\3\2\2\2\u008c\u008d"+
		"\3\2\2\2\u008d\u008f\3\2\2\2\u008e\u0090\5$\23\2\u008f\u008e\3\2\2\2\u008f"+
		"\u0090\3\2\2\2\u0090\u0091\3\2\2\2\u0091\u0092\5\n\6\2\u0092\u0093\7A"+
		"\2\2\u0093\t\3\2\2\2\u0094\u0095\5\"\22\2\u0095\u0096\5\f\7\2\u0096\u009c"+
		"\3\2\2\2\u0097\u0099\5\20\t\2\u0098\u009a\5\f\7\2\u0099\u0098\3\2\2\2"+
		"\u0099\u009a\3\2\2\2\u009a\u009c\3\2\2\2\u009b\u0094\3\2\2\2\u009b\u0097"+
		"\3\2\2\2\u009c\13\3\2\2\2\u009d\u00a2\5\16\b\2\u009e\u009f\7+\2\2\u009f"+
		"\u00a1\5\16\b\2\u00a0\u009e\3\2\2\2\u00a1\u00a4\3\2\2\2\u00a2\u00a0\3"+
		"\2\2\2\u00a2\u00a3\3\2\2\2\u00a3\r\3\2\2\2\u00a4\u00a2\3\2\2\2\u00a5\u00a7"+
		"\5\62\32\2\u00a6\u00a5\3\2\2\2\u00a6\u00a7\3\2\2\2\u00a7\u00a8\3\2\2\2"+
		"\u00a8\u00aa\5v<\2\u00a9\u00ab\5\66\34\2\u00aa\u00a9\3\2\2\2\u00aa\u00ab"+
		"\3\2\2\2\u00ab\u00b3\3\2\2\2\u00ac\u00ae\7.\2\2\u00ad\u00af\5:\36\2\u00ae"+
		"\u00ad\3\2\2\2\u00ae\u00af\3\2\2\2\u00af\u00b0\3\2\2\2\u00b0\u00b4\7\24"+
		"\2\2\u00b1\u00b2\7\35\2\2\u00b2\u00b4\5&\24\2\u00b3\u00ac\3\2\2\2\u00b3"+
		"\u00b1\3\2\2\2\u00b3\u00b4\3\2\2\2\u00b4\17\3\2\2\2\u00b5\u00b6\5j\66"+
		"\2\u00b6\u00b7\5\22\n\2\u00b7\u00b8\5\24\13\2\u00b8\u00b9\7\62\2\2\u00b9"+
		"\u00ba\5\30\r\2\u00ba\u00bb\7\r\2\2\u00bb\21\3\2\2\2\u00bc\u00be\5v<\2"+
		"\u00bd\u00bc\3\2\2\2\u00bd\u00be\3\2\2\2\u00be\23\3\2\2\2\u00bf\u00c0"+
		"\7-\2\2\u00c0\u00c5\5\26\f\2\u00c1\u00c2\7+\2\2\u00c2\u00c4\5\26\f\2\u00c3"+
		"\u00c1\3\2\2\2\u00c4\u00c7\3\2\2\2\u00c5\u00c3\3\2\2\2\u00c5\u00c6\3\2"+
		"\2\2\u00c6\25\3\2\2\2\u00c7\u00c5\3\2\2\2\u00c8\u00ca\7\25\2\2\u00c9\u00c8"+
		"\3\2\2\2\u00c9\u00ca\3\2\2\2\u00ca\u00cc\3\2\2\2\u00cb\u00cd\5n8\2\u00cc"+
		"\u00cb\3\2\2\2\u00cc\u00cd\3\2\2\2\u00cd\u00ce\3\2\2\2\u00ce\u00cf\5v"+
		"<\2\u00cf\27\3\2\2\2\u00d0\u00d2\5\32\16\2\u00d1\u00d0\3\2\2\2\u00d2\u00d5"+
		"\3\2\2\2\u00d3\u00d1\3\2\2\2\u00d3\u00d4\3\2\2\2\u00d4\31\3\2\2\2\u00d5"+
		"\u00d3\3\2\2\2\u00d6\u00df\5\b\5\2\u00d7\u00df\5\36\20\2\u00d8\u00df\5"+
		"\34\17\2\u00d9\u00da\7\62\2\2\u00da\u00db\5\30\r\2\u00db\u00dc\7\r\2\2"+
		"\u00dc\u00df\3\2\2\2\u00dd\u00df\5^\60\2\u00de\u00d6\3\2\2\2\u00de\u00d7"+
		"\3\2\2\2\u00de\u00d8\3\2\2\2\u00de\u00d9\3\2\2\2\u00de\u00dd\3\2\2\2\u00df"+
		"\33\3\2\2\2\u00e0\u00e2\7\16\2\2\u00e1\u00e0\3\2\2\2\u00e1\u00e2\3\2\2"+
		"\2\u00e2\u00e5\3\2\2\2\u00e3\u00e6\5v<\2\u00e4\u00e6\5x=\2\u00e5\u00e3"+
		"\3\2\2\2\u00e5\u00e4\3\2\2\2\u00e6\u00e9\3\2\2\2\u00e7\u00e9\5n8\2\u00e8"+
		"\u00e1\3\2\2\2\u00e8\u00e7\3\2\2\2\u00e9\u00ea\3\2\2\2\u00ea\u00eb\7-"+
		"\2\2\u00eb\35\3\2\2\2\u00ec\u00ee\5$\23\2\u00ed\u00ec\3\2\2\2\u00ed\u00ee"+
		"\3\2\2\2\u00ee\u00f0\3\2\2\2\u00ef\u00f1\5 \21\2\u00f0\u00ef\3\2\2\2\u00f0"+
		"\u00f1\3\2\2\2\u00f1\u00f2\3\2\2\2\u00f2\u00f3\5J&\2\u00f3\u00f5\5,\27"+
		"\2\u00f4\u00f6\5B\"\2\u00f5\u00f4\3\2\2\2\u00f5\u00f6\3\2\2\2\u00f6\u00f7"+
		"\3\2\2\2\u00f7\u00f8\5<\37\2\u00f8\37\3\2\2\2\u00f9\u00fb\5h\65\2\u00fa"+
		"\u00f9\3\2\2\2\u00fb\u00fe\3\2\2\2\u00fc\u00fa\3\2\2\2\u00fc\u00fd\3\2"+
		"\2\2\u00fd\u00ff\3\2\2\2\u00fe\u00fc\3\2\2\2\u00ff\u0100\5\"\22\2\u0100"+
		"\u0104\3\2\2\2\u0101\u0103\5h\65\2\u0102\u0101\3\2\2\2\u0103\u0106\3\2"+
		"\2\2\u0104\u0102\3\2\2\2\u0104\u0105\3\2\2\2\u0105\u010a\3\2\2\2\u0106"+
		"\u0104\3\2\2\2\u0107\u0109\5l\67\2\u0108\u0107\3\2\2\2\u0109\u010c\3\2"+
		"\2\2\u010a\u0108\3\2\2\2\u010a\u010b\3\2\2\2\u010b!\3\2\2\2\u010c\u010a"+
		"\3\2\2\2\u010d\u010f\5f\64\2\u010e\u010d\3\2\2\2\u010f\u0112\3\2\2\2\u0110"+
		"\u010e\3\2\2\2\u0110\u0111\3\2\2\2\u0111\u0114\3\2\2\2\u0112\u0110\3\2"+
		"\2\2\u0113\u0115\5j\66\2\u0114\u0113\3\2\2\2\u0114\u0115\3\2\2\2\u0115"+
		"\u0117\3\2\2\2\u0116\u0118\t\2\2\2\u0117\u0116\3\2\2\2\u0117\u0118\3\2"+
		"\2\2\u0118\u0119\3\2\2\2\u0119\u011e\7K\2\2\u011a\u011b\7\7\2\2\u011b"+
		"\u011c\5(\25\2\u011c\u011d\7D\2\2\u011d\u011f\3\2\2\2\u011e\u011a\3\2"+
		"\2\2\u011e\u011f\3\2\2\2\u011f\u012a\3\2\2\2\u0120\u0121\7\32\2\2\u0121"+
		"\u0126\7K\2\2\u0122\u0123\7\7\2\2\u0123\u0124\5(\25\2\u0124\u0125\7D\2"+
		"\2\u0125\u0127\3\2\2\2\u0126\u0122\3\2\2\2\u0126\u0127\3\2\2\2\u0127\u0129"+
		"\3\2\2\2\u0128\u0120\3\2\2\2\u0129\u012c\3\2\2\2\u012a\u0128\3\2\2\2\u012a"+
		"\u012b\3\2\2\2\u012b#\3\2\2\2\u012c\u012a\3\2\2\2\u012d\u012e\7\34\2\2"+
		"\u012e\u012f\7\7\2\2\u012f\u0130\5(\25\2\u0130\u0131\7D\2\2\u0131%\3\2"+
		"\2\2\u0132\u0134\5d\63\2\u0133\u0132\3\2\2\2\u0134\u0135\3\2\2\2\u0135"+
		"\u0133\3\2\2\2\u0135\u0136\3\2\2\2\u0136\'\3\2\2\2\u0137\u0139\5*\26\2"+
		"\u0138\u0137\3\2\2\2\u0139\u013c\3\2\2\2\u013a\u0138\3\2\2\2\u013a\u013b"+
		"\3\2\2\2\u013b)\3\2\2\2\u013c\u013a\3\2\2\2\u013d\u013e\7\7\2\2\u013e"+
		"\u013f\5(\25\2\u013f\u0140\7D\2\2\u0140\u0147\3\2\2\2\u0141\u0142\7.\2"+
		"\2\u0142\u0143\5(\25\2\u0143\u0144\7\24\2\2\u0144\u0147\3\2\2\2\u0145"+
		"\u0147\5\\/\2\u0146\u013d\3\2\2\2\u0146\u0141\3\2\2\2\u0146\u0145\3\2"+
		"\2\2\u0147+\3\2\2\2\u0148\u014a\7.\2\2\u0149\u014b\5.\30\2\u014a\u0149"+
		"\3\2\2\2\u014a\u014b\3\2\2\2\u014b\u014c\3\2\2\2\u014c\u0150\7\24\2\2"+
		"\u014d\u014f\5f\64\2\u014e\u014d\3\2\2\2\u014f\u0152\3\2\2\2\u0150\u014e"+
		"\3\2\2\2\u0150\u0151\3\2\2\2\u0151\u0154\3\2\2\2\u0152\u0150\3\2\2\2\u0153"+
		"\u0155\5L\'\2\u0154\u0153\3\2\2\2\u0154\u0155\3\2\2\2\u0155-\3\2\2\2\u0156"+
		"\u015b\5\60\31\2\u0157\u0158\7+\2\2\u0158\u015a\5\60\31\2\u0159\u0157"+
		"\3\2\2\2\u015a\u015d\3\2\2\2\u015b\u0159\3\2\2\2\u015b\u015c\3\2\2\2\u015c"+
		"/\3\2\2\2\u015d\u015b\3\2\2\2\u015e\u0160\5\64\33\2\u015f\u0161\5\62\32"+
		"\2\u0160\u015f\3\2\2\2\u0160\u0161\3\2\2\2\u0161\u0162\3\2\2\2\u0162\u0164"+
		"\5> \2\u0163\u0165\5\66\34\2\u0164\u0163\3\2\2\2\u0164\u0165\3\2\2\2\u0165"+
		"\61\3\2\2\2\u0166\u0168\5l\67\2\u0167\u0166\3\2\2\2\u0168\u0169\3\2\2"+
		"\2\u0169\u0167\3\2\2\2\u0169\u016a\3\2\2\2\u016a\63\3\2\2\2\u016b\u016d"+
		"\t\3\2\2\u016c\u016b\3\2\2\2\u016c\u016d\3\2\2\2\u016d\u016e\3\2\2\2\u016e"+
		"\u016f\5\"\22\2\u016f\65\3\2\2\2\u0170\u0171\7\6\2\2\u0171\u0172\58\35"+
		"\2\u0172\u0173\7%\2\2\u0173\67\3\2\2\2\u0174\u0176\5`\61\2\u0175\u0174"+
		"\3\2\2\2\u0176\u0179\3\2\2\2\u0177\u0175\3\2\2\2\u0177\u0178\3\2\2\2\u0178"+
		"\u0185\3\2\2\2\u0179\u0177\3\2\2\2\u017a\u017b\7\6\2\2\u017b\u017c\58"+
		"\35\2\u017c\u0180\7%\2\2\u017d\u017f\5`\61\2\u017e\u017d\3\2\2\2\u017f"+
		"\u0182\3\2\2\2\u0180\u017e\3\2\2\2\u0180\u0181\3\2\2\2\u0181\u0184\3\2"+
		"\2\2\u0182\u0180\3\2\2\2\u0183\u017a\3\2\2\2\u0184\u0187\3\2\2\2\u0185"+
		"\u0183\3\2\2\2\u0185\u0186\3\2\2\2\u01869\3\2\2\2\u0187\u0185\3\2\2\2"+
		"\u0188\u018a\5V,\2\u0189\u0188\3\2\2\2\u018a\u018d\3\2\2\2\u018b\u0189"+
		"\3\2\2\2\u018b\u018c\3\2\2\2\u018c\u0199\3\2\2\2\u018d\u018b\3\2\2\2\u018e"+
		"\u018f\7.\2\2\u018f\u0190\5:\36\2\u0190\u0194\7\24\2\2\u0191\u0193\5V"+
		",\2\u0192\u0191\3\2\2\2\u0193\u0196\3\2\2\2\u0194\u0192\3\2\2\2\u0194"+
		"\u0195\3\2\2\2\u0195\u0198\3\2\2\2\u0196\u0194\3\2\2\2\u0197\u018e\3\2"+
		"\2\2\u0198\u019b\3\2\2\2\u0199\u0197\3\2\2\2\u0199\u019a\3\2\2\2\u019a"+
		";\3\2\2\2\u019b\u0199\3\2\2\2\u019c\u01a0\7\62\2\2\u019d\u019f\5^\60\2"+
		"\u019e\u019d\3\2\2\2\u019f\u01a2\3\2\2\2\u01a0\u019e\3\2\2\2\u01a0\u01a1"+
		"\3\2\2\2\u01a1\u01ac\3\2\2\2\u01a2\u01a0\3\2\2\2\u01a3\u01a7\5<\37\2\u01a4"+
		"\u01a6\5^\60\2\u01a5\u01a4\3\2\2\2\u01a6\u01a9\3\2\2\2\u01a7\u01a5\3\2"+
		"\2\2\u01a7\u01a8\3\2\2\2\u01a8\u01ab\3\2\2\2\u01a9\u01a7\3\2\2\2\u01aa"+
		"\u01a3\3\2\2\2\u01ab\u01ae\3\2\2\2\u01ac\u01aa\3\2\2\2\u01ac\u01ad\3\2"+
		"\2\2\u01ad\u01af\3\2\2\2\u01ae\u01ac\3\2\2\2\u01af\u01b0\7\r\2\2\u01b0"+
		"=\3\2\2\2\u01b1\u01b3\5@!\2\u01b2\u01b4\5\66\34\2\u01b3\u01b2\3\2\2\2"+
		"\u01b3\u01b4\3\2\2\2\u01b4?\3\2\2\2\u01b5\u01b6\7.\2\2\u01b6\u01b7\5>"+
		" \2\u01b7\u01b8\7\24\2\2\u01b8\u01bb\3\2\2\2\u01b9\u01bb\5v<\2\u01ba\u01b5"+
		"\3\2\2\2\u01ba\u01b9\3\2\2\2\u01bbA\3\2\2\2\u01bc\u01bd\7-\2\2\u01bd\u01c2"+
		"\5D#\2\u01be\u01bf\7+\2\2\u01bf\u01c1\5D#\2\u01c0\u01be\3\2\2\2\u01c1"+
		"\u01c4\3\2\2\2\u01c2\u01c0\3\2\2\2\u01c2\u01c3\3\2\2\2\u01c3C\3\2\2\2"+
		"\u01c4\u01c2\3\2\2\2\u01c5\u01c6\5F$\2\u01c6\u01c7\5H%\2\u01c7E\3\2\2"+
		"\2\u01c8\u01ca\7\32\2\2\u01c9\u01c8\3\2\2\2\u01c9\u01ca\3\2\2\2\u01ca"+
		"\u01cb\3\2\2\2\u01cb\u01cc\5v<\2\u01ccG\3\2\2\2\u01cd\u01cf\7.\2\2\u01ce"+
		"\u01d0\5:\36\2\u01cf\u01ce\3\2\2\2\u01cf\u01d0\3\2\2\2\u01d0\u01d1\3\2"+
		"\2\2\u01d1\u01d2\7\24\2\2\u01d2I\3\2\2\2\u01d3\u01d4\7.\2\2\u01d4\u01d5"+
		"\5J&\2\u01d5\u01d6\7\24\2\2\u01d6\u01da\3\2\2\2\u01d7\u01da\5v<\2\u01d8"+
		"\u01da\5p9\2\u01d9\u01d3\3\2\2\2\u01d9\u01d7\3\2\2\2\u01d9\u01d8\3\2\2"+
		"\2\u01daK\3\2\2\2\u01db\u01dc\7\33\2\2\u01dc\u01dd\7.\2\2\u01dd\u01de"+
		"\5N(\2\u01de\u01df\7\24\2\2\u01dfM\3\2\2\2\u01e0\u01e2\5V,\2\u01e1\u01e0"+
		"\3\2\2\2\u01e2\u01e5\3\2\2\2\u01e3\u01e1\3\2\2\2\u01e3\u01e4\3\2\2\2\u01e4"+
		"\u01f1\3\2\2\2\u01e5\u01e3\3\2\2\2\u01e6\u01e7\7.\2\2\u01e7\u01e8\5N("+
		"\2\u01e8\u01ec\7\24\2\2\u01e9\u01eb\5V,\2\u01ea\u01e9\3\2\2\2\u01eb\u01ee"+
		"\3\2\2\2\u01ec\u01ea\3\2\2\2\u01ec\u01ed\3\2\2\2\u01ed\u01f0\3\2\2\2\u01ee"+
		"\u01ec\3\2\2\2\u01ef\u01e6\3\2\2\2\u01f0\u01f3\3\2\2\2\u01f1\u01ef\3\2"+
		"\2\2\u01f1\u01f2\3\2\2\2\u01f2O\3\2\2\2\u01f3\u01f1\3\2\2\2\u01f4\u01f5"+
		"\7&\2\2\u01f5\u01f6\7\f\2\2\u01f6\u01f7\5v<\2\u01f7\u01f8\7A\2\2\u01f8"+
		"Q\3\2\2\2\u01f9\u01fa\t\4\2\2\u01faS\3\2\2\2\u01fb\u01fc\t\5\2\2\u01fc"+
		"U\3\2\2\2\u01fd\u01fe\n\6\2\2\u01feW\3\2\2\2\u01ff\u0200\n\7\2\2\u0200"+
		"Y\3\2\2\2\u0201\u0202\n\b\2\2\u0202[\3\2\2\2\u0203\u0204\n\t\2\2\u0204"+
		"]\3\2\2\2\u0205\u0206\n\n\2\2\u0206_\3\2\2\2\u0207\u0208\n\13\2\2\u0208"+
		"a\3\2\2\2\u0209\u020a\n\f\2\2\u020ac\3\2\2\2\u020b\u020c\n\r\2\2\u020c"+
		"e\3\2\2\2\u020d\u020e\t\16\2\2\u020eg\3\2\2\2\u020f\u0210\t\17\2\2\u0210"+
		"i\3\2\2\2\u0211\u0212\t\20\2\2\u0212k\3\2\2\2\u0213\u0214\t\21\2\2\u0214"+
		"m\3\2\2\2\u0215\u0216\t\22\2\2\u0216o\3\2\2\2\u0217\u0218\7>\2\2\u0218"+
		"\u0219\5r:\2\u0219q\3\2\2\2\u021a\u021d\t\23\2\2\u021b\u021c\7\6\2\2\u021c"+
		"\u021e\7%\2\2\u021d\u021b\3\2\2\2\u021d\u021e\3\2\2\2\u021e\u0248\3\2"+
		"\2\2\u021f\u0248\7<\2\2\u0220\u0248\7,\2\2\u0221\u0248\7\5\2\2\u0222\u0248"+
		"\7G\2\2\u0223\u0248\7\17\2\2\u0224\u0248\7;\2\2\u0225\u0248\7\3\2\2\u0226"+
		"\u0248\7\"\2\2\u0227\u0248\7I\2\2\u0228\u0248\7#\2\2\u0229\u0248\7\35"+
		"\2\2\u022a\u0248\7\7\2\2\u022b\u0248\7D\2\2\u022c\u0248\7\63\2\2\u022d"+
		"\u0248\7(\2\2\u022e\u0248\7\23\2\2\u022f\u0248\7F\2\2\u0230\u0248\7E\2"+
		"\2\u0231\u0248\7\64\2\2\u0232\u0248\7/\2\2\u0233\u0248\7\37\2\2\u0234"+
		"\u0248\79\2\2\u0235\u0248\7\13\2\2\u0236\u0248\7\61\2\2\u0237\u0248\7"+
		"\'\2\2\u0238\u0248\7H\2\2\u0239\u0248\7\t\2\2\u023a\u0248\7\n\2\2\u023b"+
		"\u0248\7J\2\2\u023c\u0248\7B\2\2\u023d\u0248\7C\2\2\u023e\u0248\78\2\2"+
		"\u023f\u0248\7\b\2\2\u0240\u0248\7+\2\2\u0241\u0248\7)\2\2\u0242\u0248"+
		"\7\20\2\2\u0243\u0244\7.\2\2\u0244\u0248\7\24\2\2\u0245\u0246\7\6\2\2"+
		"\u0246\u0248\7%\2\2\u0247\u021a\3\2\2\2\u0247\u021f\3\2\2\2\u0247\u0220"+
		"\3\2\2\2\u0247\u0221\3\2\2\2\u0247\u0222\3\2\2\2\u0247\u0223\3\2\2\2\u0247"+
		"\u0224\3\2\2\2\u0247\u0225\3\2\2\2\u0247\u0226\3\2\2\2\u0247\u0227\3\2"+
		"\2\2\u0247\u0228\3\2\2\2\u0247\u0229\3\2\2\2\u0247\u022a\3\2\2\2\u0247"+
		"\u022b\3\2\2\2\u0247\u022c\3\2\2\2\u0247\u022d\3\2\2\2\u0247\u022e\3\2"+
		"\2\2\u0247\u022f\3\2\2\2\u0247\u0230\3\2\2\2\u0247\u0231\3\2\2\2\u0247"+
		"\u0232\3\2\2\2\u0247\u0233\3\2\2\2\u0247\u0234\3\2\2\2\u0247\u0235\3\2"+
		"\2\2\u0247\u0236\3\2\2\2\u0247\u0237\3\2\2\2\u0247\u0238\3\2\2\2\u0247"+
		"\u0239\3\2\2\2\u0247\u023a\3\2\2\2\u0247\u023b\3\2\2\2\u0247\u023c\3\2"+
		"\2\2\u0247\u023d\3\2\2\2\u0247\u023e\3\2\2\2\u0247\u023f\3\2\2\2\u0247"+
		"\u0240\3\2\2\2\u0247\u0241\3\2\2\2\u0247\u0242\3\2\2\2\u0247\u0243\3\2"+
		"\2\2\u0247\u0245\3\2\2\2\u0248s\3\2\2\2\u0249\u024a\t\24\2\2\u024au\3"+
		"\2\2\2\u024b\u0250\7K\2\2\u024c\u024d\7\32\2\2\u024d\u024f\7K\2\2\u024e"+
		"\u024c\3\2\2\2\u024f\u0252\3\2\2\2\u0250\u024e\3\2\2\2\u0250\u0251\3\2"+
		"\2\2\u0251w\3\2\2\2\u0252\u0250\3\2\2\2\u0253\u0254\t\25\2\2\u0254y\3"+
		"\2\2\2\u0255\u0256\n\26\2\2\u0256{\3\2\2\2C\177\u0084\u0089\u008c\u008f"+
		"\u0099\u009b\u00a2\u00a6\u00aa\u00ae\u00b3\u00bd\u00c5\u00c9\u00cc\u00d3"+
		"\u00de\u00e1\u00e5\u00e8\u00ed\u00f0\u00f5\u00fc\u0104\u010a\u0110\u0114"+
		"\u0117\u011e\u0126\u012a\u0135\u013a\u0146\u014a\u0150\u0154\u015b\u0160"+
		"\u0164\u0169\u016c\u0177\u0180\u0185\u018b\u0194\u0199\u01a0\u01a7\u01ac"+
		"\u01b3\u01ba\u01c2\u01c9\u01cf\u01d9\u01e3\u01ec\u01f1\u021d\u0247\u0250";
	public static final ATN _ATN =
		ATNSimulator.deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
	}
}