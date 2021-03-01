# 项目简介

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