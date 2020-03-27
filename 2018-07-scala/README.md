+  `layer.use_case.entiry`ではなく`use_case.layer.entiry`で切る
  + `use_case`間の依存を完全に断ってみる
  + `api`と`domain`が超遠くなるの、ファイルツリーが辛い
+ 1 ファイル 1 クラスじゃあなくなれば、パッケージをしっかり分類したら細かいパッケージをどうするかは気にならなくなった
+ `repository`は`Try`
+ `domain`は`Either`
+ なので`service`は`TryT[Either]`
+ `api`は`ValidationNel`
+ `api`が`ValidationNel`カ`TryT[Either]`を`String`にする
+ https://github.com/suzuki-hoge/stack/tree/transfomer/layer-1
+ implicit conversion はすげーいいなと思ったけど非推奨な流れなのか
  + まー ds 層に限ればありと思った
