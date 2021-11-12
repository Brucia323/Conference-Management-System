



# 背景
请按两人一组自由组队的方式，使用MVC设计模式实现一个会议管理系统，要求使用EL和JSTL，实现分页查看数据（使用MVC模式）。
![1b1dce64723a3d8f91a022443dad4d7b.png](https://cdn.nlark.com/yuque/0/2021/png/23075474/1636438547967-6647b49d-9f73-4966-a653-b417f20b4e29.png#clientId=u27f46d23-ef61-4&from=ui&id=uae29df9e&margin=%5Bobject%20Object%5D&name=1b1dce64723a3d8f91a022443dad4d7b.png&originHeight=711&originWidth=1366&originalType=binary&ratio=1&size=131227&status=done&style=none&taskId=u63fdb170-d9db-4754-96f1-6637ca7ff50)![1e3556a98932568aa0965b39a02351a0.png](https://cdn.nlark.com/yuque/0/2021/png/23075474/1636438547938-fe6e4c34-0b3d-470a-a902-9c8413387bc4.png#clientId=u27f46d23-ef61-4&from=ui&id=u34ffdb64&margin=%5Bobject%20Object%5D&name=1e3556a98932568aa0965b39a02351a0.png&originHeight=580&originWidth=1366&originalType=binary&ratio=1&size=88686&status=done&style=none&taskId=uf75a5ed0-8a97-42a4-a577-f9bdb8acd84)![11ebd2e1e7c589fe0d9b71b50aba23d9.png](https://cdn.nlark.com/yuque/0/2021/png/23075474/1636438548001-30574108-ee6b-497e-a3c2-20f2e8cd77a4.png#clientId=u27f46d23-ef61-4&from=ui&id=u89c38d52&margin=%5Bobject%20Object%5D&name=11ebd2e1e7c589fe0d9b71b50aba23d9.png&originHeight=705&originWidth=1366&originalType=binary&ratio=1&size=129693&status=done&style=none&taskId=u70de9448-f217-414a-817b-b19f2494868)![12cf23a07752c4362bb039a38cfbf867.png](https://cdn.nlark.com/yuque/0/2021/png/23075474/1636438548466-729cfd68-6b1e-4060-83e9-ae9232a4622b.png#clientId=u27f46d23-ef61-4&from=ui&id=ua43cb525&margin=%5Bobject%20Object%5D&name=12cf23a07752c4362bb039a38cfbf867.png&originHeight=729&originWidth=1366&originalType=binary&ratio=1&size=120668&status=done&style=none&taskId=u8176f522-651f-40bf-a5a7-317a23e20ea)![65a131028f876c984d75f70e780f382f.png](https://cdn.nlark.com/yuque/0/2021/png/23075474/1636438547957-300908b7-1db0-48da-9dc9-45ddea63ec07.png#clientId=u27f46d23-ef61-4&from=ui&id=u4c8bf2bf&margin=%5Bobject%20Object%5D&name=65a131028f876c984d75f70e780f382f.png&originHeight=710&originWidth=1366&originalType=binary&ratio=1&size=97060&status=done&style=none&taskId=uc9d7ec58-ba75-4ee9-a0b3-04762910729)![81c0853575c881300ec71e88d7fec5e5.png](https://cdn.nlark.com/yuque/0/2021/png/23075474/1636438549469-75ec52fe-97da-45f2-8953-3a64ce48a79c.png#clientId=u27f46d23-ef61-4&from=ui&id=u10ec5b98&margin=%5Bobject%20Object%5D&name=81c0853575c881300ec71e88d7fec5e5.png&originHeight=614&originWidth=1366&originalType=binary&ratio=1&size=98610&status=done&style=none&taskId=u93373738-94db-4664-9937-c2931b50eba)![444fd0937f49dc4c67ec3bf68b10c23a.png](https://cdn.nlark.com/yuque/0/2021/png/23075474/1636438549684-09cbba7f-4785-4ce7-a958-15264c74bb23.png#clientId=u27f46d23-ef61-4&from=ui&id=u256606c3&margin=%5Bobject%20Object%5D&name=444fd0937f49dc4c67ec3bf68b10c23a.png&originHeight=593&originWidth=1366&originalType=binary&ratio=1&size=88209&status=done&style=none&taskId=ue6df588b-7485-4c94-831d-5d3a7320d9b)![3650d9b43c6605c74a2f289b7fe67435.png](https://cdn.nlark.com/yuque/0/2021/png/23075474/1636438549834-620ca3d5-a3b7-4327-9420-f78781e992af.png#clientId=u27f46d23-ef61-4&from=ui&id=u224b5a91&margin=%5Bobject%20Object%5D&name=3650d9b43c6605c74a2f289b7fe67435.png&originHeight=629&originWidth=1366&originalType=binary&ratio=1&size=105338&status=done&style=none&taskId=u60ce8724-410f-4555-8adb-44388601139)![aadde12492b3bff73df0fbbfd0b31bcc.png](https://cdn.nlark.com/yuque/0/2021/png/23075474/1636438549955-940dafd5-7c6c-4696-ac36-e6e7ad5b2ca1.png#clientId=u27f46d23-ef61-4&from=ui&id=u71c1c6dc&margin=%5Bobject%20Object%5D&name=aadde12492b3bff73df0fbbfd0b31bcc.png&originHeight=732&originWidth=1366&originalType=binary&ratio=1&size=61700&status=done&style=none&taskId=u2458e9fc-1023-42a3-a63a-16046962eec)![bdba76eca0bf7144478f7178a21edec1.png](https://cdn.nlark.com/yuque/0/2021/png/23075474/1636438550417-67dc32d6-2774-45ec-951a-1a3944aba12e.png#clientId=u27f46d23-ef61-4&from=ui&id=uc1cdd36a&margin=%5Bobject%20Object%5D&name=bdba76eca0bf7144478f7178a21edec1.png&originHeight=709&originWidth=1366&originalType=binary&ratio=1&size=52118&status=done&style=none&taskId=u7d8604ae-a154-45a9-a276-3bbdeafcf53)![bf88a080df68425415208255aa3e6f17.png](https://cdn.nlark.com/yuque/0/2021/png/23075474/1636438550755-18f8e943-9d8b-4443-ba4e-0778f342c5b4.png#clientId=u27f46d23-ef61-4&from=ui&id=u023eadc4&margin=%5Bobject%20Object%5D&name=bf88a080df68425415208255aa3e6f17.png&originHeight=735&originWidth=1366&originalType=binary&ratio=1&size=74178&status=done&style=none&taskId=uaad88fd0-2a35-461c-a1f8-3e95b4e27ef)![c7b898e5537e2f81e66f970a8b715dd6.png](https://cdn.nlark.com/yuque/0/2021/png/23075474/1636438550996-3634cc7d-11ac-4b62-b787-1eb0fc901011.png#clientId=u27f46d23-ef61-4&from=ui&id=u42b20e40&margin=%5Bobject%20Object%5D&name=c7b898e5537e2f81e66f970a8b715dd6.png&originHeight=737&originWidth=1366&originalType=binary&ratio=1&size=130353&status=done&style=none&taskId=uf5a8e75a-a83a-4884-9474-afb3e46a756)![c7ed27e30c716be72162a3a1b539a3fe.png](https://cdn.nlark.com/yuque/0/2021/png/23075474/1636438551315-c55ceae8-12ea-4781-b3fc-54ab316e2700.png#clientId=u27f46d23-ef61-4&from=ui&id=u525d262f&margin=%5Bobject%20Object%5D&name=c7ed27e30c716be72162a3a1b539a3fe.png&originHeight=487&originWidth=1366&originalType=binary&ratio=1&size=86588&status=done&style=none&taskId=uc20d205e-6798-4ba1-b926-740c46c0f74)![d4348c6b69c1b9299a04e7ba3a4b22fc.png](https://cdn.nlark.com/yuque/0/2021/png/23075474/1636438551332-72afdee3-1e10-465e-8b52-5c03caea8f01.png#clientId=u27f46d23-ef61-4&from=ui&id=u5e01fa8f&margin=%5Bobject%20Object%5D&name=d4348c6b69c1b9299a04e7ba3a4b22fc.png&originHeight=585&originWidth=1366&originalType=binary&ratio=1&size=93130&status=done&style=none&taskId=u965e417f-7a75-47e4-8729-86edc7601a6)![dc8dc3f7df39b3a001d44e93e6675bcb.png](https://cdn.nlark.com/yuque/0/2021/png/23075474/1636438551367-718c0ca5-6002-4da6-b0ab-51692a06d50d.png#clientId=u27f46d23-ef61-4&from=ui&id=u7aa52a34&margin=%5Bobject%20Object%5D&name=dc8dc3f7df39b3a001d44e93e6675bcb.png&originHeight=623&originWidth=1366&originalType=binary&ratio=1&size=93407&status=done&style=none&taskId=u68c01a5d-c4bc-4a49-b66f-9b119cc9711)
# 一、产品概述
## 1.版本信息

- 版本号：1
- 创建日期：2021年11月9日
- 审核人：周晨阳



## 2.修订历史
| **时间** | **版本号** | **修订人** | **主要修订内容** |
| --- | --- | --- | --- |
|  |  |  |  |
|  |  |  |  |
|  |  |  |  |

## 3.开发周期
| 目标 | 预计时间 | 结束日期 | 是否完成 |
| --- | --- | --- | --- |
| 开发 | 2021年11月13日 | 2021年11月19日 | 
- [ ] 

 |
| 测试 | 2021年11月19日 | 2021年11月20日 | 
- [ ] 

 |
| 上线 | ​
 |  | 
- [ ] 

 |

## 4.产品介绍
> 可以在这里写产品名称、产品简介、用户画像、使用场景、产品定位等

### 4.1 产品名称
会议管理系统
### 4.2产品简介
​

### 4.3用户画像
​

### 4.4使用场景
会议管理
### 4.5产品定位
​

# 二、文档说明
## 1、名词解释
| **术语 / 缩略词** | **说明** |
| --- | --- |
| MVC | 经典MVC模式中，M是指业务模型，V是指用户界面，C则是控制器，使用MVC的目的是将M和V的实现代码分离，从而使同一个程序可以使用不同的表现形式。其中，View的定义比较清晰，就是用户界面。 |
| EL | EL（Expression Language） 是为了使JSP写起来更加简单。表达式语言的灵感来自于 ECMAScript 和 XPath 表达式语言，它提供了在 JSP 中简化表达式的方法，让Jsp的代码更加简化。 |
| JSTL | JSTL（Java server pages standarded tag library，即JSP标准标签库）是由JCP（Java community Proces）所制定的标准规范，它主要提供给Java Web开发人员一个标准通用的标签库，并由Apache的Jakarta小组来维护。开发人员可以利用这些标签取代JSP页面上的Java代码，从而提高程序的可读性，降低程序的维护难度。 |



# 四、需求背景 
## 1.产品 / 数据现状 




## 2.用户调研
> 简要说明调研方法、样本情况及关键结论，点击工具栏![image.png](https://cdn.nlark.com/yuque/0/2021/png/21674429/1629038178993-18c8df03-914c-4348-b197-4bafcfc5c457.png#clientId=u4c736b72-f89f-4&from=paste&height=26&id=u454d30cb&margin=%5Bobject%20Object%5D&name=image.png&originHeight=52&originWidth=64&originalType=binary&ratio=1&size=1434&status=done&style=none&taskId=udb95ed0e-6da2-4179-82a9-8586ea7f358&width=32)「插入链接」，在此附上详细的数据分析报告并添加在【附录】中 

​

​

## 3.竞品分析
> 列出竞品对比的主要信息和关键结论，可点击插入链接，在此附上详细的竞品分析报告并添加在【附录】中

|  | **主要信息** | **关键结论** | **截图或视频** |
| --- | --- | --- | --- |
| **竞品1** |  |  | 建议尽量把图片横向排布，精简文档篇幅  |
| **竞品2** |  |  |  |
|  |  |  |  |



# 五、需求范围
> 可条理性地罗列需求范围或信息架

### PC 端
| **需求** | **简要说明** | **优先级** |
| --- | --- | --- |
| 员工注册 | 在人员管理中实现 | ​P0 |
| 登录 |  | ​P0 |
| 最新通知 | 在个人中心中实现 | ​P0 |
| 我的预定 | 在个人中心中实现 | P0 |
| 我的会议 | 在个人中心中实现 | P1 |
| 修改会议预定 | 在会议预定中实现 | P2 |
| 撤销会议预定 | 在会议预定中实现 | P2 |
| 部门管理 | 在人员管理中实现 | P1 |
| 注册审批 | 在人员管理中实现 | P2 |
| 搜索员工 | 在会议预定中实现 | P3 |
| 添加会议室 | 在会议预定中实现 | P1 |
| 查看会议室 | 在会议预定中实现 | P1 |
| 预定会议 | 在会议预定中实现 | P0 |
| 搜索会议 | 在会议预定中实现 | P2 |

### 移动端
| **需求** | **简要说明** | **优先级** |
| --- | --- | --- |
|  |  | ​P0 |
|  |  | ​P1 |
|  |  | ​P2 |

# 六、功能详细说明
## 1.产品流程图
![](https://cdn.nlark.com/yuque/__puml/a2da73a5a281d2758299f42a8b888e74.svg#lake_card_v2=eyJ0eXBlIjoicHVtbCIsImNvZGUiOiJAc3RhcnR1bWxcblxuY2xhc3Mg5ZGY5belIHtcbiAgLUlEXG4gIC3lp5PlkI1cblx0Lei0puaIt-WQjVxuXHQt5a-G56CBXG5cdC3ogZTns7vnlLXor51cblx0LeeUteWtkOmCruS7tlxuXHQt5omA5Zyo6YOo6ZeoXG5cdC3nirbmgIFcbiAgK-azqOWGjCgpXG4gICvnmbvlvZUoKVxufVxuXG5jbGFzcyDpg6jpl6h7XG5cdC1JRFxuXHQt6YOo6Zeo5ZCN56ewXG5cdCvmt7vliqDpg6jpl6goKVxuXHQr5p-l55yL5omA5pyJ6YOo6ZeoKClcblx0K-e8lui-kemDqOmXqCgpXG5cdCvliKDpmaTpg6jpl6goKVxufVxuXG5jbGFzcyDkvJrorq57XG5cdC1JRFxuXHQt5Lya6K6u5ZCN56ewXG5cdC3pooTorqHlj4LliqDkurrmlbBcblx0LemihOiuoeW8gOWni-aXtumXtFxuXHQt6aKE6K6h57uT5p2f5pe26Ze0XG5cdC3kvJrorq7lrqTlkI3np7Bcblx0LeS8muiuruivtOaYjlxuXHQt6aKE5a6a6ICFXG5cdCvkv67mlLnkvJrorq7pooTlrpooKVxuXHQr5Y-W5raI5Lya6K6u6aKE5a6aKClcblx0K-mihOWumuS8muiurigpXG5cdCvmkJzntKLkvJrorq4oKVxuXHQr5p-l55yL5pyq5p2lN-WkqeeahOS8muiurigpXG5cdCvmn6XnnIvlt7Llj5bmtojnmoTkvJrorq4oKVxuXHQr5p-l55yL6aKE5a6a55qE5Lya6K6uKClcblx0K-afpeeci-WPguWKoOeahOS8muiurigpXG59XG5cbmNsYXNzIOWPguS8muS6uuWRmHtcblx0LeWRmOW3pUlEXG5cdC3kvJrorq5JRFxuXHQr5aKe5Yqg5Y-C5Lya5Lq65ZGYKClcblx0K-WHj-WwkeWPguS8muS6uuWRmCgpXG59XG5cbmNsYXNzIOS8muiuruWupHtcblx0LUlEXG5cdC3pl6jniYzlj7dcblx0LeS8muiuruWupOWQjeensFxuXHQt5pyA5aSa5a6557qz5Lq65pWwXG5cdC3lvZPliY3nirbmgIFcblx0LeWkh-azqFxuXHQr5re75Yqg5Lya6K6u5a6kKClcblx0K-afpeeci-S8muiuruWupCgpXG59XG5cbumDqOmXqCBvLS0g5ZGY5belXG7lkZjlt6Ugby0tIOWPguS8muS6uuWRmFxu5Lya6K6uIG8tLSDlj4LkvJrkurrlkZhcbuS8muiuriBvLS0g5Lya6K6u5a6kXG5cbkBlbmR1bWwiLCJ1cmwiOiJodHRwczovL2Nkbi5ubGFyay5jb20veXVxdWUvX19wdW1sL2EyZGE3M2E1YTI4MWQyNzU4Mjk5ZjQyYThiODg4ZTc0LnN2ZyIsImlkIjoibVlyck0iLCJtYXJnaW4iOnsidG9wIjp0cnVlLCJib3R0b20iOnRydWV9LCJoZWlnaHQiOjEzNjguMDYyNSwiY2FyZCI6ImRpYWdyYW0ifQ==)



## 2.交互原型图
> 鼠标点击左上角![image.png](https://cdn.nlark.com/yuque/0/2021/png/21674429/1629038355812-65f9dad2-a3fc-44af-89b2-6503edd7c86a.png#clientId=u4c736b72-f89f-4&from=paste&height=21&id=jFO9e&margin=%5Bobject%20Object%5D&name=image.png&originHeight=42&originWidth=40&originalType=binary&ratio=1&size=3868&status=done&style=none&taskId=u71a91668-fb58-4c58-ae2d-b9206fdfca2&width=20)，点击“**引入第三方服务**”中的“**Figma 设计图**”，粘贴Figma链接，
> 在文档中嵌入网页书签，展示设计原型 

## 3.功能说明
| **序号** | **模块** | **功能** | **功能详细说明** | **交互图** |
| --- | --- | --- | --- | --- |
| 1  | 资料编辑  | 
- 更换头像 

 |  |  |
|  | .  |  |  |  |
|  |  |  |  |  |
|  |  |  |  |  |

# 七、非功能需求
> 可以列举性能需求、系统需求、运营需求、安全需求、财务需求、法务需求、统计需求、使用帮助等...

​

# 八、埋点
| **参数名** | **参数说明** | **参数值** |
| --- | --- | --- |
|  |  |  |
|  |  |  |
|  |  |  |

# 九、项目规划
> 鼠标点击左上角![image.png](https://cdn.nlark.com/yuque/0/2021/png/21674429/1629038355812-65f9dad2-a3fc-44af-89b2-6503edd7c86a.png#clientId=u4c736b72-f89f-4&from=paste&height=21&id=IeR9p&margin=%5Bobject%20Object%5D&name=image.png&originHeight=42&originWidth=40&originalType=binary&ratio=1&size=3868&status=done&style=none&taskId=u71a91668-fb58-4c58-ae2d-b9206fdfca2&width=20)，选择附件或者引入语雀内容，把正文提及的项目管理文档附在此处



# 附录 
输入 @ 把正文提及的具体文档，或需求相关的其他说明文档附在此处以供查阅 

1. 数据分析报告 
1. 用户调研报告 
1. 设计分析报告 
1. ...... 
