import { ValidationErrors } from '@angular/forms';

var regexp: RegExp =
  /^[0-9a-fA-F]{8}-[0-9a-fA-F]{4}-[0-9a-fA-F]{4}-[0-9a-fA-F]{4}-[0-9a-fA-F]{12}$/gi;

export function IsUuid(uuid: string): ValidationErrors | null {
  // const s = uuid.match(regexp);
  // if (s === null) {
  //   return { IsUuid: false };
  // }

  return null;
}
