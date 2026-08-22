/* Copyright 2026 上海如静知华信息科技有限公司 · https://www.zhuatech.cn/ */
export const domain={
 code:'CLM',systemName:'合同生命周期管理系统',englishName:'CONTRACT LIFECYCLE MANAGEMENT',
 theme:{primary:'#24456b',dark:'#17283f',accent:'#c28a3c'},
 workspace:'合同中心 / 合同组合运营',fieldWorkspace:'销售合同组合',period:'2026-08-01 · 周六',liveText:'条款模板数据链路正常',
 fieldContextLabel:'当前合同组合',fieldContext:'日班 · 08:30—17:30',fieldUser:'陆承',fieldRole:'合同专员',adminUser:'周妍',adminRole:'合同组合主管',
 adminTitle:'合同组合运营驾驶舱',adminBreadcrumb:'合同组合运营 / 今日态势',adminSubtitle:'集中查看合同收件、审查、复核、条款模板与时限风险。',exportAction:'导出审查日报',createAction:'新建合同审查',
 chartTitle:'审查完成趋势',chartSubtitle:'当日累计完成率 / 计划目标',chartLabels:['08:30','09:30','10:30','11:30','13:30','14:30','15:30','16:30','17:30'],loadTitle:'合同组合负荷',loadSubtitle:'在审合同占可用能力',recordsTitle:'在审合同',recordsSubtitle:'按承诺时限与异常优先显示',issueTitle:'履约与时限风险',issueSubtitle:'需要合同组合主管处理的事项',
 recordName:'合同审查',itemName:'合同 / 项目',unitName:'合同组合',batchName:'合同批次',planName:'计划项目',doneName:'已完成',exceptionName:'异常',unitLabel:'项',
 listBreadcrumb:'合同管理 / 任务台账',listSubtitle:'统一管理合同收件、任务分派、审查、复核与合同归档。',listSummary:[['今日新建合同','18'],['在审合同','23'],['待复核','8'],['超时风险','2',true]],tabs:['全部','待确认','审查中','待复核','已完成'],
 fieldBreadcrumb:'审查执行 / 我的工作台',fieldTitle:'合同审查工作台',fieldSubtitle:'当前 7 项在审合同 · 2 个标准模板待调用 · 合同专员陆承',fieldSecondary:'交接记录',reportAction:'录入结果',fieldNoticeTitle:'条款版本已同步',fieldNotice:'模板版本、审批权限与客户主体信息均已校验',
 steps:['合同收件确认','条款预审','法务审查','法务复核','合同归档'],documentAction:'查看合同制度',printAction:'打印合同标签',resourceCardTitle:'条款模板状态',resourceValueLabel:'版本号',resourceHealthLabel:'模板覆盖率',quickSubtitle:'合同组合高频业务入口',quickActions:[['结果录入','/shopfloor/report','审查意见与结论'],['合同流转','/shopfloor/material','会签与归档位置'],['模板调用','/shopfloor/resources','模板库与调用记录'],['义务预警','/shopfloor/andon','付款、交付与续约提醒']],
 reportDefaults:[3,0],reportTitle:'审查结论录入',reportSubtitle:'记录原始结果、异常数量和审查过程备注。',reportSuccess:'审查结论已保存并进入复核队列',reportPlaceholder:'填写修改依据、争议条款或补充审查说明',reportFootnote:'提交后写入原始记录并生成审批轨迹',ruleTitle:'制度控制要求',ruleSubtitle:'CLM-SAAS-03 · V4.3',rules:[['付款周期','30 天'],['履约保证金','5%'],['法务会签','已完成'],['模板版本','有效',true]],fieldTotals:[['16','已完成项目'],['1','异常结果'],['5','待复核结果'],['98.2%','合同要素完整率']],
 adminMenus:[['/admin','home','运营驾驶舱'],['/admin/work-orders','order','合同审查'],['/admin/samples','box','合同管理'],['/admin/schedule','calendar','排班预约'],['/admin/methods','process','制度与标准'],['/admin/reviews','quality','法务复核'],['/admin/resources','machine','条款模板'],['/admin/report','chart','合同分析']],
 fieldMenus:[['/shopfloor','home','我的工作台'],['/shopfloor/report','report','结果录入'],['/shopfloor/tasks','order','待检任务'],['/shopfloor/material','box','合同流转'],['/shopfloor/resources','machine','模板调用'],['/shopfloor/andon','risk','义务预警',1]],
 moduleTitles:{tasks:['待检任务','查看任务优先级、合同状态与承诺时限'],material:['合同流转','跟踪接收、分样、留样与销毁全过程'],resources:['模板调用','管理条款模板档期、校准和使用记录'],andon:['义务预警','登记并跟踪 OOS、OOT 与环境义务'],samples:['合同管理','管理合同登记、标签、位置和生命周期'],schedule:['排班预约','协调人员、条款模板和制度的可用时间'],methods:['制度与标准','维护合同制度、限度和标准物质'],reviews:['法务复核','执行商务复核、审批记录批准和电子签名'],report:['合同分析','分析周转时间、一次通过率和义务趋势']},
 tagline:'让每一份审查结论都有完整审批记录链',storyTitle:'从合同收件到审批记录，<br/>每个结果都可复核、可追溯。',storyText:'连接合同、制度、条款模板、人员与原始数据的合同组合数字底座。',pattern:[2,3,8,9,10,15,16,17,22,23,24,29,30,23],loginStats:[['98.2%','合同要素完整率'],['23','当前在审合同'],['1.8 天','平均审查时长']],loginTitle:'合同组合合同中心',adminDemo:'合同 / 条款 / 会签',fieldDemo:'审查 / 结果 / 义务'
}
export const records=[
 {no:'CTR-260801-018',name:'华东区域年度框架采购合同',code:'CLM-FRAME-01',unit:'采购合同组合',group:'合同中心',plan:24,done:16,exception:1,due:'08-02',batch:'V3.2',status:'审查中',progress:67,priority:'加急'},
 {no:'CTR-260801-021',name:'软件私有化部署合同',code:'CLM-SAAS-03',unit:'销售合同组合',group:'合同中心',plan:18,done:8,exception:0,due:'08-02',batch:'V2.1',status:'审查中',progress:44,priority:'正常'},
 {no:'CTR-260802-006',name:'渠道合作协议',code:'CLM-CHANNEL-02',unit:'渠道合同组合',group:'研发中心',plan:12,done:0,exception:0,due:'08-04',batch:'V1.4',status:'待确认',progress:0,priority:'正常'},
 {no:'CTR-260723-015',name:'客户维保续费合同',code:'CLM-MAINT-04',unit:'销售合同组合',group:'合同中心',plan:20,done:20,exception:1,due:'08-01',batch:'V5.0',status:'已完成',progress:100,priority:'正常'},
 {no:'CTR-260801-024',name:'数据处理协议',code:'CLM-DPA-05',unit:'销售合同组合',group:'合同中心',plan:15,done:10,exception:0,due:'08-03',batch:'V1.8',status:'待复核',progress:67,priority:'关注'}]
export const resources=[{code:'CLS-PAY-03',name:'付款条款模板',unit:'销售合同组合',status:'运行',health:88,value:'3.2',valueUnit:'版',note:'制度 CLM-SAAS-03 · 适用销售框架合同'},{code:'CLS-UTM-05',name:'违约责任条款',unit:'采购合同组合',status:'运行',health:91,value:'5',valueUnit:'条',note:'法务确认有效至 2026-12'},{code:'CLS-INC-08',name:'数据保护条款',unit:'渠道合同组合',status:'报警',health:62,value:'1.8',valueUnit:'版',note:'数据跨境条款待法务确认'}]
export const reviews=[{no:'REV-260801-032',title:'华东采购框架合同法务复核',type:'法务复核',detail:'12 项条款 · 周妍',result:'通过'},{no:'REV-260801-011',title:'软件部署合同商务会签',type:'商务复核',detail:'6 项修改 · 顾清',result:'待确认'},{no:'REV-260723-018',title:'维保合同续约义务核查',type:'义务评审',detail:'OBL-260723-02',result:'异常'}]
export const adminMetrics=[['今日新建合同','18','较昨日增加 8 份','blue'],['按时完成率','96.8%','目标值 ≥ 95.0%','green'],['待复核结果','8','其中 2 项加急','orange'],['义务 / OOS','2','1 项进入调查','red']]
export const fieldMetrics=[['今日任务','7','18 个审查事项','blue'],['已完成','16','当前进度 67%','green'],['待复核','5','数据已完整提交','orange'],['条款模板档期','今日 16:00','付款条款 V3.2','slate']]
export const chartActual=[8,18,29,42,49,61,72,84,91],chartTarget=[10,21,32,43,18,65,76,87,98]
export const loads=[['销售合同组合',92,'12 项在检'],['采购合同组合',78,'8 项在检'],['渠道合同组合',71,'6 项在检'],['战略合作合同组合',56,'5 项在检']]
export const issues=[{type:'条款模板',title:'付款节点临近未确认',detail:'CLS-INC-08 · 距到期 3 天',status:'调查中'},{type:'结果',title:'客户责任条款存在争议',detail:'OBL-260723-02 · 等待商务确认',status:'待判定'},{type:'时限',title:'两份合同可能错过签署窗口',detail:'预计延迟 1 个工作日',status:'协调中'}]
