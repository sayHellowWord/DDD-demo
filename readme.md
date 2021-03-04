# 项目简介

结合阿里技术专家详解DDD系列与COLA的落地


# Domain Primitive

Domain Primitive 是一个在特定领域里，拥有精准定义的、可自我验证的、拥有行为的 Value Object 。

* DP是一个传统意义上的Value Object，拥有Immutable的特性
* DP是一个完整的概念整体，拥有精准定义
* DP使用业务域中的原生语言
* DP可以是业务域的最小组成部分、也可以构建复杂组合

## 问题
### 接口清晰度（可阅读性）
释义命名函数
编译时发现问题（联系Java代码编译后特性、参数名编译后丢失）

### 数据验证和错误处理
DRY 原则
业务逻辑异常和数据校验异常被混在了一起

把数据验证的工作量前置到了调用方，而调用方本来就是应该提供合法数据的，所以更加合适

### 业务逻辑代码的清晰度
面向过程编程
胶水代码
项目里充斥着大量的静态工具类，业务代码散在多个文件当中时，你是否还能找到核心的业务逻辑呢


在刨除了数据验证代码、胶水代码之后，剩下的都是核心业务逻辑
### 可测试性


## 解决方案

## Make Implicit Concepts Explicit（将隐性的概念显性化）


### 接口清晰度（可阅读性）
 User register(
  @NotNull Name name,
  @NotNull PhoneNumber phone,
  @NotNull Address address
) 

### 数据验证和错误处理

把数据验证的工作量前置到了调用方，而调用方本来就是应该提供合法数据的，所以更加合适

### 业务逻辑代码的清晰度

SalesRep rep = salesRepRepo.findRep(phone.getAreaCode());
User user = xxx;
return userRepo.save(user);

在刨除了数据验证代码、胶水代码之后，剩下的都是核心业务逻辑
### 可测试性


## Make Implicit Context Explicit（将 隐性的 上下文 显性化）
Money 案例

## Encapsulate Multi-Object Behavior(封装 多对象 行为)

public void pay(Money money, Currency targetCurrency, Long recipientId) {
    ExchangeRate rate = ExchangeService.getRate(money.getCurrency(), targetCurrency);
    Money targetMoney = rate.exchange(money);
    BankService.transfer(targetMoney, recipientId);
}


是否要将付款金额放到付款服务里面


## 老应用重构的流程

### 第一步 - 创建 Domain Primitive，收集所有 DP 行为
以前散落在各个服务或工具类里面的代码，可以都抽出来放在 DP 里，成为 DP 自己的行为或属性
抽离出来的方法要做到无状态


### 第二步 - 替换数据校验和无状态逻辑

不会去修改接口的签名，而是通过代码替换原有的校验逻辑和根 DP 相关的业务逻辑


### 第三步 - 创建新接口

创建新接口，将DP的代码提升到接口参数层

### 第四步 - 修改外部调用


# Repository模式

贫血模型
充血模型

* 数据模型（Data Model）：指业务数据该如何持久化，以及数据之间的关系，也就是传统的ER模型；
* 业务模型/领域模型（Domain Model）：指业务逻辑中，相关联的数据该如何联动

代码里严格区分Data Model和Domain Model


## 
* 硬件（Hardware）：指创造了之后不可（或者很难）变更的东西。数据库对于开发来说，就属于”硬件“，数据库选型后基本上后面不会再变，比如：用了MySQL就很难再改为MongoDB，改造成本过高。
* 软件（Software）：指创造了之后可以随时修改的东西。对于开发来说，业务代码应该追求做”软件“，因为业务流程、规则在不停的变化，我们的代码也应该能随时变化。
* 固件（Firmware）：即那些强烈依赖了硬件的软件。我们常见的是路由器里的固件或安卓的固件等等。固件的特点是对硬件做了抽象，但仅能适配某款硬件，不能通用。所以今天不存在所谓的通用安卓固件，而是每个手机都需要有自己的固件。
《代码整洁之道》

`数据库在本质上属于”硬件“，DAO 在本质上属于”固件“，而我们自己的代码希望是属于”软件“。但是，固件有个非常不好的特性，那就是会传播，也就是说当一个软件强依赖了固件时，由于固件的限制，会导致软件也变得难以变更，最终让软件变得跟固件一样难以变更`

DO:
Entity:字段和方法应该和业务语言保持一致，和持久化方式无关,Entity的生命周期应该仅存在于内存中
DTO:避免让业务对象变成一个万能大对象