export class UserAccountTransactionIn {
  fromUserAccountId?: string;
  toUserAccountId?: string;
  amount?: number;

  public constructor(init?: Partial<UserAccountTransactionIn>) {
    Object.assign(this, init);
  }
}
