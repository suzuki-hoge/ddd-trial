# モデル
図は`puml`を参照

## 方針
### ドメインクラス
+ 登録時のユーザと参照時のユーザは別エンティティ

### 認証
+ 認証の都合等はドメイン層には含めない
+ API層で済ませ、Service層は認証済であるとする
+ リポジトリを作る都合上、ドメインに認証がある
+ APIから直接リポジトリを呼ばずに、Service経由で呼ぶ

### テスト
+ ドメインクラスのみ