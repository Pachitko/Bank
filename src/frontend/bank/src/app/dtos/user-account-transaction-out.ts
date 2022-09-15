// todo: interface?
// todo transaction creation or transaction out?
export class UserAccountTransactionOut {
  fromUserAccountId: string = '';
  toUserAccountId: string = '';
  amount: number = 0;

  public constructor(init?: Partial<UserAccountTransactionOut>) {
    Object.assign(this, init);
  }
}
