document.getElementById('loginForm').addEventListener('submit', function (e) {
  e.preventDefault();

  var usernameInput = document.getElementById('username');
  var passwordInput = document.getElementById('password');
  var loginBtn = document.getElementById('loginBtn');

  // ログイン中の表示
  loginBtn.disabled = true;
  loginBtn.innerText = 'ログイン中...';

  // サーバーへのログインリクエストの送信（非同期処理）
  setTimeout(function () {
    // ログイン成功の場合
    // ログインフォームの送信を実行する
    document.getElementById('loginForm').submit();

    // ログイン失敗の場合
    // エラーメッセージを表示する
    // 例：alert('ログインに失敗しました');

    // ログイン処理後の表示をリセットする
    loginBtn.disabled = false;
    loginBtn.innerText = 'ログイン';
  }, 2000);
});
